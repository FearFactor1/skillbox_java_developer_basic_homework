package practice;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome = LocalDate.now();

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
        }

        if (lastIncome.getYear() == LocalDate.now().getYear() & lastIncome.getMonth() == LocalDate.now().getMonth()) {
            return;
        } else {
            check.set(0, (check.get(0) - amountToTake));
        }
    }
}
