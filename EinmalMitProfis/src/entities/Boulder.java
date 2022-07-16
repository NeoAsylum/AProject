package entities;

import java.awt.Rectangle;

import execution.Main;

public class Boulder extends MovingObjectAbstract {
  public final static int MAXWIDTH = 50;
  public final static int MAXHEIGHT = 20;

  public Boulder(int xcoord, int ycoord, double xspeed, double yspeed, double widthfactor,
      double heightfactor) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.xspeed = xspeed;
    this.yspeed = yspeed;
    width = (int) (MAXWIDTH * widthfactor);
    height = (int) (MAXHEIGHT * heightfactor);
    rectangle = new Rectangle(xcoord, ycoord, width, height);
  }

  public Boulder(int xcoord, int ycoord) {
    this(xcoord, ycoord, 0, 1, 1, 1);
  }

  public Boulder() {
    width = (int) (Math.random() * MAXWIDTH);
    height = (int) ((Math.random() * MAXHEIGHT));
    xcoord = (int) (Math.random() * (Main.width - width));
    ycoord = 0;
    xspeed=0;
    yspeed=1;
    rectangle = new Rectangle(xcoord, ycoord, width, height);
    System.out.println("width:"+width+"height:"+height+"xcoord:"+xcoord+"ycoord:"+ycoord);
  }

  public void fall() {
    ycoord += yspeed;
    rectangle = new Rectangle(xcoord, ycoord, width, height);
  }
}
