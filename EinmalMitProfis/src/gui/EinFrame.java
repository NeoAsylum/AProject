package gui;

import javax.swing.JFrame;

import execution.Main;
import java.awt.Dimension;

/**
 * @version -1
 * @author Hallooo
 */
@SuppressWarnings("serial")
public class EinFrame extends JFrame {

  /**
   * The backup Pane.
   */
  public Dimension dimension = new Dimension(Main.width, Main.height);
  GamePane panel;

  /**
   * Create the frame.
   */
  public EinFrame() {
    // Frame setup
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(dimension);
    setResizable(false);
    setTitle("Titel");
    panel = new GamePane(dimension);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    add(panel);
    panel.requestFocus();
  }

  public GamePane getGamePane() {
    return panel;
  }
}
