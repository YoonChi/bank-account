
public class BankAccount {
    protected String owner;	// unique ID number of the owner
    protected double balance;	// expressed in cents

    public BankAccount(String own, double bal) {
        owner=own;
        balance=bal;
    }

    public double deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return amt;
        }
        return 0;
    }

    public double withdraw(double amt) {
        if (amt > 0  && amt <= balance) {
            balance -= amt;
        }
        return 0;
    }

    public boolean equals(Object o) {
        if (o instanceof BankAccount) {
            BankAccount b = (BankAccount)o;
            return owner.equals(b.owner) && balance == b.balance;
        }
        return false;
    }
}