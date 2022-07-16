package gui;

import javax.swing.JPanel;

import entities.Boulder;
import entities.Player;
import entities.TheFloor;
import execution.Main;
import gamelogic.BoulderRain;
import useful.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
  static final int FPS = 120;
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
  int x = 50, y = 50;

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

  public boolean intersection() {
    if (player.getRectangle().intersects(floor.getRectangle())) {
      return true;
    }
    int closestBoulder = br.findClosestIndex(player.getXCoord() + player.getWidth() / 2,
        player.getYCoord() + player.getYCoord() / 2);
    if (closestBoulder != -1) {
      if (br.getBoulders().get(closestBoulder).getRectangle().intersects(player.getRectangle())) {
        System.out.println("weee");
      }
    }
    return false;
  }

  /**
   * Update locations method.
   */
  public void update() {
    player.move(keyHandler.leftPressed, keyHandler.downPressed, keyHandler.rightPressed,
        keyHandler.upPressed);
    if (intersection()) {
      player.setYCoord((int) floor.getRectangle().getMinY() - player.getHeight());
      player.resetYSpeed();
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
    for (Boulder b : br.getBoulders()) {
      g2.fill(b.getRectangle());
    }
    g2.fill(player.getRectangle());
    g2.fill(floor.getRectangle());
    g2.fillRect(x, y, 40, 20);
    g2.dispose();
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
      repaint();
      drawCount++;
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
}
