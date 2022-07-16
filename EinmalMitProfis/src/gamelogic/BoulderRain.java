package gamelogic;

import java.util.ArrayList;

import entities.Boulder;

public class BoulderRain {
  private ArrayList<Boulder> boulders;
  private int boulderIntervall = 60;
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
    boulderSpawning();
    return index;
  }

  private void boulderSpawning() {
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
