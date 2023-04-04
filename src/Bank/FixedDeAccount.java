package Bank;

public class FixedDeAccount extends BankAccount {
    int countMonth;

    public FixedDeAccount(String name, double balance, int countMonth) throws Exception {
        super(name, balance, 5000);
        this.countMonth = countMonth;
        if (balance < 1000)
            throw new Exception("Insufficient Balance");
    }
}
