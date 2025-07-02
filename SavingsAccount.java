package Lab3;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountName, double balance,String ID) {
        super(accountName,ID,balance);
    }

    void withdraw(double amount) {
        if(this.balance-amount>=1000) {
            this.balance-=amount;
            System.out.println("Withdraw Successful");
        }
        else {
            System.out.println("Insufficient Balance");
        }
    }

    void deposit(double amount) {
        this.balance+=amount;
        useInterest();
        System.out.println("Deposit Successful");
    }

    void useInterest() {
        this.balance+=this.balance*0.025;
    }

    boolean canWithdraw(double amount) {
        if(amount > this.balance || this.balance-amount<1000) {
            return false;
        }
        else
            return true;
    }
}
