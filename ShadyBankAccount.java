public class ShadyBankAccount extends BankAccount{
    private final double shadiness;
    private double takeOverChance;

    public ShadyBankAccount(double shadiness, String own, double bal){
        super(own, bal);
        this.shadiness = shadiness;
    }

    @Override
    public String toString () {
        String result = "This is ShadyBankAccount: \n";
        result += "Owner: " + owner;
        result += "Balance: $" + balance;
        result += "Shadiness level: " + shadiness;

        return result;

    }

    @Override
    public boolean equals(Object o) { // checks if equal to ShadyBankAccount object
        // Verify that o is actually a BankAccount object
        if (o instanceof ShadyBankAccount) {

            // if so, cast o to BankAccount so that we can access Bank Account's instance variables
            ShadyBankAccount a = (ShadyBankAccount) o;

            return owner.equals(a.owner) && balance == a.balance && shadiness == ((ShadyBankAccount)o).shadiness;

        }
        // If o is not a ShadyBankAccount object, return false
        else
            return false;
    }

    public boolean hostileTakeover(BankAccount target) {

        if (super.equals(target)) {
            takeOverChance = 50.0;
        }
        else if (this.equals(target)) {
            // takeover is this.account shadiness - target.shadiness)
            takeOverChance = shadiness - ((ShadyBankAccount)target).shadiness;
            if (takeOverChance < 5.0) {
                takeOverChance = 5.0;
            }
        }

        double chance = Math.random() * 100;

        if (chance >= takeOverChance) {
            //successful takeover
            deposit(target.balance);
            target.withdraw(target.balance);
            return true;

        }

        return false; // unsuccessful takeover
    }

}
