package execution;

import java.awt.EventQueue;

import gui.EinFrame;

public class Main {
  
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
