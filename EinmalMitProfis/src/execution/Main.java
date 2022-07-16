package execution;

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
  
  public final static int width=400;
  public final static int height=600;

  /**
   * Main method.
   * 
   * @param args Parameters.
   */
  public static void main(String[] args) {
    log = Logger.getLogger(Main.class.getName());
    addFileHandlerToLogger();
    setupFrame();
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
  private static void setupFrame() {
    try {
      frame = new EinFrame();
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Get the logger.
   * @return Logger.
   */
  public static Logger getLogger() {
    return log;
  }
}
