package Lab3;

public class FixedDeposit extends Account {
    int count=0;
    public FixedDeposit(String accountName, double balance,String ID) {
        super(accountName,ID,balance);
    }

    void deposit(double amount) {
        this.balance+=amount;
        count++;
        useInterest();
        System.out.println("Deposit Successful");
    }

    void withdraw(double amount) {
        if(count>=5 && balance>=amount)
        {
            this.balance-=amount;
            System.out.println("Withdraw Successful");

        }
        else{
            System.out.println("Cannot withdraw without minimum 5 installments. Your total installment is "+ count);
        }
    }

    void useInterest() {
        this.balance+=this.balance*0.07;
    }

    boolean canWithdraw(double amount) {
        if(amount <= this.balance && count>=5) {
            return true;
        }
        else
            return false;
    }
}
