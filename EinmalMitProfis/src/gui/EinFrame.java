package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class EinFrame extends JFrame {

  private JPanel contentPane;
  private int height=800;
  private int width=400;
 

  /**
   * Create the frame.
   */
  public EinFrame() {
    //Framesetup
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, height, width);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    //Buttons
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    
    JButton optionsButton = new JButton("OPTIONS");
    optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    JButton newGameButton = new JButton("NEW GAME");
    newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    JButton creditsButton = new JButton("CREDITS");
    creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    JButton levelSelectionButton = new JButton("LEVEL SELECTION");
    levelSelectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    //Title
    JLabel spielTitelLabel = new JLabel("Spieltitel");
    spielTitelLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    spielTitelLabel.setHorizontalAlignment(SwingConstants.CENTER);
    spielTitelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    
    //Group Layout stuff
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(280)
          .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            .addComponent(creditsButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, width/4, Short.MAX_VALUE)
            .addComponent(levelSelectionButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, width/4, Short.MAX_VALUE)
            .addComponent(optionsButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, width/4, Short.MAX_VALUE)
            .addComponent(newGameButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, width/4, Short.MAX_VALUE))
          .addGap(280))
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(320)
          .addComponent(spielTitelLabel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
          .addGap(320))
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGap(32)
          .addComponent(spielTitelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGap(63)
          .addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(optionsButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(levelSelectionButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(creditsButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
          .addGap(67))
    );
    panel.setLayout(gl_panel);
  }
}
