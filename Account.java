package Lab3;

abstract class Account {
    private String accountName;
    protected double balance=0.0;
    private String ID;

    public Account()
    {

    }
    public Account(String id, String name)
    {
        this.accountName = name;
        this.ID = id;
    }

    public Account(String accountName, String ID, double balance)
    {
        this.accountName = accountName;
        this.ID = ID;
        this.balance = balance;
    }

    String getID()
    {
        return ID;
    }

    String getName()
    {
        return accountName;
    }

    Double getBalance()
    {
        return balance;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    abstract boolean canWithdraw(double amount);

    abstract void useInterest();

    public String toString()
    {
        return "Account [ID: " + this.ID + ", Name: " + this.accountName + ", Balance: " + this.balance + "]";
    }
}
