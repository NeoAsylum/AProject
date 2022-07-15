package execution;

import java.awt.EventQueue;

import gui.EinFrame;

/**
 * Class for executing program.
 * @author Adrian
 *
 */
public class Main {
  
  /**
   * Main method.
   * @param args Parameters.
   */
  public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          try {
            EinFrame frame = new EinFrame();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
    }
}
