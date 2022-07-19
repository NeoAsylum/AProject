package gui;

import javax.swing.JPanel;

import entities.Boulder;
import entities.Player;
import entities.TheFloor;
import execution.Main;
import gamelogic.BoulderRain;
import gamelogic.Interactions;
import useful.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Class for Game-Panel.
 * 
 * @author AdrianPlaasLink
 *
 */
@SuppressWarnings("serial")
public class GamePane extends JPanel implements Runnable {
  /**
   * Game Thread.
   */
  private Thread gameThread;
  /**
   * Keyhandler.
   */
  private KeyHandler keyHandler = new KeyHandler();
  /**
   * FPS.
   */
  int FPS = 120;
  /**
   * Player entity.
   */
  private Player player = new Player();
  /**
   * The floor.
   */
  private TheFloor floor = new TheFloor();

  /**
   * An Arraylist of Boulders.
   */
  BoulderRain br = new BoulderRain();

  /**
   * Create the panel.
   */
  public GamePane(Dimension dimension) {
    this.setPreferredSize(dimension);
    setBackground(Color.black);
    setDoubleBuffered(true);
    addKeyListener(keyHandler);
    setFocusable(true);
    System.out.println("Game Pane set up.");
    startThread();
  }

  /**
   * Method to start thread.
   */
  public void startThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  public boolean isPlayerStillAlive() {
    return player.getYCoord() < Main.height;
  }

  public boolean intersection() {

    boolean intersects = false;
    if (player.getRectangle().intersects(floor.getRectangle())) {
      if (player.getFeet().intersects(floor.getRectangle())) {
        player.resetYSpeed(0);
        intersects = true;
      } else {
        FPS = 0;
      }
    } else {
      int closestBoulder = br.findClosestIndex((int) player.getXCoord() + player.getWidth() / 2,
          (int) player.getYCoord() + player.getHeight() / 2);
      br.getBoulders().get(closestBoulder).setColor(Color.pink);
      if (closestBoulder != -1) {
        Boulder b = br.getBoulders().get(closestBoulder);
        if (b.getRectangle().intersects(player.getRectangle())) {
          if (player.getFeet().intersects(br.getBoulders().get(closestBoulder).getRectangle())) {
            System.out.println("inter");
            player.resetYSpeed(b.getYSpeed());
            intersects = true;
          } else {
            // insert death here
          }
        } else {
          player.setPlayerStanding(false);
        }
      }
    }

    return intersects;
  }

  public void cleanupStuff() {
    br.boulderSpawning();
    br.deleteBoulder();
  }

  /**
   * Update locations method.
   */
  public void update() {
    player.move(keyHandler.leftPressed, keyHandler.downPressed, keyHandler.rightPressed,
        keyHandler.upPressed);
    keyHandler.upPressed = false;
    if (isPlayerStillAlive()) {
      intersection();
      Interactions.inrceaseScore();
    }
    if(Interactions.getScore()>1000) {
      TheFloor.removeFromScreen();
    }
    for (Boulder b : br.getBoulders()) {
      b.fall();
    }
  }

  /**
   * Paint Component method.
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.white);
    ArrayList<Boulder> temp = br.getBoulders();
    for (int i=0; i<temp.size(); i++) {
      g2.setColor(temp.get(i).getColor());
      g2.fill(temp.get(i).getRectangle());
    }
    drawMenu(g2);
    g2.fill(player.getRectangle());
    g2.fill(floor.getRectangle());
    g2.dispose();
  }

  /**
   * 
   * @param g2
   */
  public void drawMenu(Graphics2D g2) {
    g2.setColor(Color.white);
    g2.drawString("Score: " + Interactions.getScore(), Main.width / 2 - 30, 80);
    if (!isPlayerStillAlive()) {
      g2.drawString("Press r to respawn.", Main.width / 2 - 30, 50);
    }
  }

  /**
   * Method draws and updates the game a certain times per second. Method run for
   * Running interface/Thread.
   */
  @Override
  public void run() {

    // Sleep Time
    double drawInterval = 1000000000 / FPS;
    double nextDrawTime = System.nanoTime() + drawInterval;
    int drawCount = 0;
    long timer = 0;
    while (gameThread != null) {
      requestFocus();
      update();
      cleanupStuff();
      drawCount++;
      repaint();
      timer += nextDrawTime - System.nanoTime();
      try {
        // Sleep Time
        double remainingTime = nextDrawTime - System.nanoTime();
        remainingTime = remainingTime / 1000000;
        if (remainingTime < 0) {
          remainingTime = 0;
        }
        Thread.sleep((long) remainingTime);
        nextDrawTime += drawInterval;
      } catch (InterruptedException e) {
        // log
        Main.getLogger().log(Level.SEVERE, "Game Thread Interrupted", e);
      }
      if (timer >= 1000000000) {
        System.out.println("FPS: " + drawCount);
        drawCount = 0;
        timer = 0;
      }
    }
  }

  public Player getPlayer() {
    return player;
  }
}
