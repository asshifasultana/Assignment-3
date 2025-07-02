package Lab3;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountName, double balance,String ID) {
        super(accountName,ID,balance);
    }
    public CurrentAccount(String accountName, String ID) {
        super(ID,accountName);
    }

    void withdraw(double amount) {
        if(amount <= this.balance) {
            this.balance-=amount;
            System.out.println("Withdraw Successfully");
        }
        else {
            System.out.println("Insufficient Balance");
        }
    }

    void deposit(double amount) {
        this.balance+=amount;
        System.out.println("Deposit Successfully");
    }

    void useInterest() {

    }

    @Override
    boolean canWithdraw(double amount) {
        if(amount > this.balance) {
            return false;
        }
        else
            return true;
    }
}
