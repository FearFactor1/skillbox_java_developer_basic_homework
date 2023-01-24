package practice;

import java.util.ArrayList;

public class BankAccount {

  protected ArrayList<Double> check = new ArrayList<>();

  public double getAmount() {
    for (Double sum : check)
      return sum;
    return 0;
  }

  public void put(double amountToPut) {
    if (amountToPut < 0.0) {
      return;
    } else {
      check.add(amountToPut);
    }
  }

  public void take(double amountToTake) {
    if (check.get(0) < amountToTake) {
      return;
    }

    if (amountToTake == 100.0) {
      double com = (100/100)*1 + amountToTake;
      check.set(0, (check.get(0) - com));
    } else {
      check.set(0, (check.get(0) - amountToTake));
    }
  }
}
