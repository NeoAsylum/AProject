package gamelogic;

import java.util.ArrayList;
import java.util.LinkedList;

import entities.Boulder;
import execution.Main;

public class BoulderRain {
  private ArrayList<Boulder> boulders;
  private int boulderIntervall = 20;
  private int intervallCounter = 0;

  public BoulderRain() {
    boulders = new ArrayList<Boulder>();
    boulders.add(new Boulder());
  }

  public int findClosestIndex(int x, int y) {
    double distance = Integer.MAX_VALUE;
    int index = -1;
    for (Boulder e : boulders) {
      double distanceNew = Math.pow(
          (e.getXCoord() - x) * (e.getXCoord() - x) + (e.getYCoord() - y) * (e.getYCoord() - y),
          0.5);
      if (distance > distanceNew) {
        distance = distanceNew;
        index = boulders.indexOf(e);
      }

    }
    return index;
  }

  public void deleteBoulder() {
    LinkedList<Integer> toDelete = new LinkedList<Integer>();
    for (Boulder b : boulders) {
      if (b.getRectangle().getMinY() > Main.height) {
        toDelete.add(boulders.indexOf(b));
      }
    }
    for (Integer i : toDelete) {
      boulders.remove(Integer.valueOf(i));
    }
  }

  public void boulderSpawning() {
    intervallCounter++;
    if (intervallCounter >= boulderIntervall) {
      intervallCounter = 0;
      boulders.add(new Boulder());
    }
  }

  public ArrayList<Boulder> getBoulders() {
    return boulders;
  }
}
