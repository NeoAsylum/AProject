package execution;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import gui.EinFrame;

/**
 * Class for executing program.
 * 
 * @author Adrian
 *
 */
public class Main implements Runnable {
  /**
   * Thread for the Game.
   */
  EinFrame frame;
  static Logger log;
  Thread gameThread;
  boolean running = false;
  static Main gameInstance;

  /**
   * Default constructor.
   */
  public Main() {
    gameStart();
    startThread();
  }

  /**
   * Main method.
   * 
   * @param args Parameters.
   */
  public static void main(String[] args) {
    log = Logger.getLogger(Main.class.getName());
    addFileHandlerToLogger();
    gameInstance = new Main();
    gameInstance.gameStart();
  }

  /**
   * Method to add Filehandler to Logger.
   */
  public static void addFileHandlerToLogger() {
    FileHandler fh = null;
    try {
      fh = new FileHandler("src/logging/filehandler.log", 50, 5);
    } catch (SecurityException e) {
      System.out.println("Logger wurde nicht erstellt");
      // TODO Automatisch generierter Erfassungsblock
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("Logger wurde nicht erstellt");

      // TODO Automatisch generierter Erfassungsblock
      e.printStackTrace();
    }
    SimpleFormatter form = new SimpleFormatter();
    fh.setFormatter(form);
    log.addHandler(fh);
    log.info("Filehandler added");
  }

  /**
   * Method to start game.
   */
  public void gameStart() {
    try {
      frame = new EinFrame();
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }

    gameThread = new Thread(gameInstance);
    gameThread.start();
  }

  /**
   * Method to start Thread(again).
   */
  public void startThread() {
    running = true;
    run();
  }

  /**
   * Method stops thread from running.
   */
  public void stopThread() {
    running = false;
  }

  /**
   * Running method.
   */
  @Override
  public void run() {
    while (running) {

      frame.paintTheGame();
      log.info("huhu");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("is running");
    }
  }
}
