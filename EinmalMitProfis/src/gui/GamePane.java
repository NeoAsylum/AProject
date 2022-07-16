package gui;

import javax.swing.JPanel;

import execution.Main;
import useful.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;

@SuppressWarnings("serial")
public class GamePane extends JPanel implements Runnable {
  private Thread gameThread;
  private KeyHandler keyHandler= new KeyHandler();
  static final int FPS = 120;
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

  public void startThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  public void update() {
    if (keyHandler.upPressed) {
      y -= 1;
    }
    if (keyHandler.downPressed) {
      y += 1;
    }
    if (keyHandler.leftPressed) {
      x -= 1;
    }
    if (keyHandler.rightPressed) {
      x += 1;
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.white);
    g2.fillRect(x, y, 40, 20);
    g2.dispose();
  }

  @Override
  public void run() {

    // Sleep Time
    double drawInterval = 1000000000 / FPS;
    double nextDrawTime = System.nanoTime() + drawInterval;
    int drawCount=0;
    long timer=0;
    while (gameThread != null) {
      update();
      repaint();
      drawCount++;
      timer+=nextDrawTime - System.nanoTime();
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
        //log
         Main.getLogger().log(Level.SEVERE, "Game Thread Interrupted", e);
      }
      if(timer>=1000000000) {
        System.out.println("FPS: "+drawCount);
        drawCount=0;
        timer=0;
      }
    }
  }
}
