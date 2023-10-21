package practice;

public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    public void put(double amountToPut){
        super.put(amountToPut);
    }

    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void take(double amountToTake) {
        if (check.get(0) < amountToTake) {
            return;
        } else {
            check.set(0, (check.get(0) - (amountToTake)/100.0 - amountToTake));
        }
    }
}
