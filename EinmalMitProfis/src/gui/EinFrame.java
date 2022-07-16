package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import useful.KeyHandler;
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
  private int height = 400;
  private int width = 800;
  public Dimension dimension = new Dimension(width, height);

  /**
   * Create the frame.
   */
  public EinFrame() {
    // Frame setup
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(dimension);
    setResizable(false);
    setTitle("Titel");
    JPanel panel = new GamePane(dimension);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    add(panel);
    panel.requestFocus();
  }
}
