package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class MenuPane extends JPanel {

  
  /**
   * Default font.
   */
  Font myFont;

  // JFrame Components
  JButton newGameButton = new JButton("NEW GAME");
  JButton optionsButton = new JButton("OPTIONS");
  JButton creditsButton = new JButton("CREDITS");
  JButton levelSelectionButton = new JButton("LEVEL SELECTION");
  JLabel spielTitelLabel = new JLabel("Spieltitel");

  /**
   * Create the panel.
   */
  public MenuPane() {
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(new BorderLayout(0, 0));
    // Buttons
    JPanel panel = new JPanel();
    panel.setFont(myFont);
    add(panel, BorderLayout.CENTER);
    optionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    levelSelectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    // Title
    spielTitelLabel.setHorizontalTextPosition(SwingConstants.CENTER);
    spielTitelLabel.setHorizontalAlignment(SwingConstants.CENTER);
    spielTitelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    spielTitelLabel.setForeground(Color.red);

    // Group Layout stuff
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_panel.createSequentialGroup().addGap(280)
            .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                .addComponent(creditsButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 200,
                    Short.MAX_VALUE)
                .addComponent(levelSelectionButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE,
                    200, Short.MAX_VALUE)
                .addComponent(optionsButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 200,
                    Short.MAX_VALUE)
                .addComponent(newGameButton, Alignment.CENTER, GroupLayout.DEFAULT_SIZE, 200,
                    Short.MAX_VALUE))
            .addGap(280))
        .addGroup(gl_panel.createSequentialGroup().addGap(320)
            .addComponent(spielTitelLabel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addGap(320)));
    gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
        .addGroup(gl_panel.createSequentialGroup().addGap(32)
            .addComponent(spielTitelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGap(60).addComponent(newGameButton, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(optionsButton, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(levelSelectionButton, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
            .addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(creditsButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addGap(100)));
    panel.setLayout(gl_panel);

    // Set Font
    myFont = new Font("SansSerif", Font.BOLD, 18);
    changeFont(this, myFont);
    addActionListeners();
  }
  /**
   * Method for changing the font of every Component inside a container.
   * 
   * @param component Said component.
   * @param font      The Font.
   */
  public static void changeFont(Component component, Font font) {
    component.setFont(font);
    if (component instanceof Container) {
      for (Component child : ((Container) component).getComponents()) {
        changeFont(child, font);
      }
    }
  }
  public void addActionListeners() {
  }
}
