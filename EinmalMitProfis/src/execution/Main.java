package execution;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import gui.EinFrame;

/**
 * Class for executing program.
 * 
 * @author Adrian
 *
 */
public class Main {
  /**
   * Thread for the Game.
   */
  private static EinFrame frame;
  private static Logger log;
  private static boolean running = false;

  /**
   * Main method.
   * 
   * @param args Parameters.
   */
  public static void main(String[] args) {
    log = Logger.getLogger(Main.class.getName());
    addFileHandlerToLogger();
    gameStart();

  }

  /**
   * Method to add Filehandler to Logger.
   */
  private static void addFileHandlerToLogger() {
    FileHandler fh = null;
    try {
      fh = new FileHandler("src/logging/filehandler.log", 50, 5);
    } catch (SecurityException e) {
      System.out.println("Logger wurde nicht erstellt");
      log.log(Level.SEVERE, "SecurityException in addFileHandler()", e);
    } catch (IOException e) {
      System.out.println("Logger wurde nicht erstellt");
      log.log(Level.SEVERE, "IOException in addFileHandler()", e);
    }
    SimpleFormatter form = new SimpleFormatter();
    fh.setFormatter(form);
    log.addHandler(fh);
    log.info("Filehandler added");
  }

  /**
   * Method to start game.
   */
  private static void gameStart() {
    try {
      frame = new EinFrame();
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to start Thread(again).
   */
  public static void runGame() {
    running = true;
    running();
  }

  /**
   * Method stops thread from running.
   */
  public static void stopRunningGame() {
    running = false;
  }

  /**
   * Running method.
   */
  private static void running() {
    while (running) {
      frame.paintTheGame();
      log.info("huhu");
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("is running");
    }
  }
  
  public static boolean getRunning() {
    return running;
  }
}
