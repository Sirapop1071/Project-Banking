package Bank;

public class StudentAccount extends SavingsAccount {

    String institutionName;

    public StudentAccount(String name, double balance, String institutioName) {
        super(institutioName, balance, 2000);
        min_balance = 100;
        this.institutionName = institutioName;
    }
}
