package Bank;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

    float rate = .05f;
    double maxWithLimit;

    public SavingsAccount(String name, double balance, double maxWithLimit) {
        super(name, balance, 2000);
        this.maxWithLimit = maxWithLimit;
    }

    public double getNetBalance() {
        double NetBalance = getbalance() + (getbalance() * rate);
        return NetBalance;
    }

    public void withdraw(double amount) throws MaxBalance, MaxWithdraw {
        if (amount < maxWithLimit) {
            super.withdraw(amount);
        } else {
            throw new MaxWithdraw("Maximum Withdraw Limit Exceed");
        }
    }

}
