package useful;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for Key Listener.
 * @author AdrianPlaasLink
 *
 */
public class KeyHandler implements KeyListener {
	/**
	 * Booleans for directions w,a,s,d.
	 */
  public boolean upPressed, downPressed, leftPressed, rightPressed;

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Automatisch generierter Methodenstub

  }

  /**
   * Key Pressed method.
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code) {
    case KeyEvent.VK_W:
      upPressed = true;
      break;
    case KeyEvent.VK_A:
      leftPressed = true;
      break;
    case KeyEvent.VK_S:
      downPressed = true;
      break;
    case KeyEvent.VK_D:
      rightPressed = true;
      break;
    }
  }

  /**
   * Key released method.
   */
  @Override
  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    switch (code) {
    case KeyEvent.VK_W:
      upPressed = false;
      break;
    case KeyEvent.VK_A:
      leftPressed = false;
      break;
    case KeyEvent.VK_S:
      downPressed = false;
      break;
    case KeyEvent.VK_D:
      rightPressed = false;
      break;
    }
  }

}
