package Lab3;

import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CurrentAccount> currentAccount = new ArrayList<>();
        ArrayList<SavingsAccount> savingsAccount = new ArrayList<>();
        ArrayList<FixedDeposit> fixedDeposit = new ArrayList<>();

        while (true) {
            if (currentAccount.isEmpty() && savingsAccount.isEmpty() && fixedDeposit.isEmpty()) {
                System.out.println("Create an Account first.");
                System.out.println("1.Current Account \n 2.Savings Account \n 3.Fixed-Deposit Account");
                System.out.println("Enter your choice:");
                int choice = sc.nextInt();
                System.out.println("Enter Account Name:");
                sc.nextLine();
                String accountName = sc.nextLine();
                System.out.println("Enter Account ID:");
                String accountID = sc.nextLine();
                System.out.println("Enter Account Balance:");
                double accountBalance = sc.nextDouble();

                switch (choice) {
                    case 1:
                        currentAccount.add(new CurrentAccount(accountName, accountBalance, accountID));
                        break;
                    case 2:
                        savingsAccount.add(new SavingsAccount(accountName, accountBalance, accountID));
                        break;
                    case 3:
                        fixedDeposit.add(new FixedDeposit(accountName, accountBalance, accountID));
                        break;
                }
            }

            System.out.println("======BANK MENU======");
            System.out.println("1.Create new account \n 2.Deposit \n 3.Withdraw \n 4.Transfer \n 5.Exit");
            System.out.println("Enter your choice:");
            int choice2 = sc.nextInt();

            if (choice2 == 1) {
                System.out.println("1.Current Account \n 2.Savings Account \n 3.Fixed-Deposit Account");
                System.out.println("Enter your choice:");
                int choice = sc.nextInt();
                System.out.println("Enter Account Name:");
                sc.nextLine();
                String accountName = sc.nextLine();
                System.out.println("Enter Account ID:");
                String accountID = sc.nextLine();
                System.out.println("Enter Account Balance:");
                double accountBalance = sc.nextDouble();

                switch (choice) {
                    case 1:
                        currentAccount.add(new CurrentAccount(accountName, accountBalance, accountID));
                        break;
                    case 2:
                        savingsAccount.add(new SavingsAccount(accountName, accountBalance, accountID));
                        break;
                    case 3:
                        fixedDeposit.add(new FixedDeposit(accountName, accountBalance, accountID));
                        break;
                }

            } else if (choice2 == 2) {

                boolean found = false;

                System.out.println("1.Current Account \n 2.Savings Account \n 3.Fixed-Deposit Account");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();

                System.out.println("Enter Account ID:");
                sc.nextLine();
                String accountID = sc.nextLine();

                System.out.println("Enter amount:");
                double amount = sc.nextDouble();

                switch (choice) {
                    case 1:
                        for (CurrentAccount a : currentAccount) {
                            if (a.getID().equals(accountID)) {
                                a.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                    case 2:
                        for (SavingsAccount a : savingsAccount) {
                            if (a.getID().equals(accountID)) {
                                a.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                    case 3:
                        for (FixedDeposit a : fixedDeposit) {
                            if (a.getID().equals(accountID)) {
                                a.deposit(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                }
            } else if (choice2 == 3) {
                boolean found = false;
                System.out.println("1.Current Account \n 2.Savings Account \n 3.Fixed-Deposit Account");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();

                System.out.println("Enter Account ID:");
                sc.nextLine();
                String accountID = sc.nextLine();

                System.out.println("Enter amount:");
                double amount = sc.nextDouble();

                switch (choice) {
                    case 1:
                        for (CurrentAccount a : currentAccount) {
                            if (a.getID().equals(accountID)) {
                                a.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                    case 2:
                        for (SavingsAccount a : savingsAccount) {
                            if (a.getID().equals(accountID)) {
                                a.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                    case 3:
                        for (FixedDeposit a : fixedDeposit) {
                            if (a.getID().equals(accountID)) {
                                a.withdraw(amount);
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Account not found");
                        }
                        break;
                }
            } else if (choice2 == 4) {

                Account source=null;
                Account destination=null;

                boolean foundSource = false;
                boolean foundDestination = false;

                System.out.println("Enter source account type:");
                System.out.println("1.Current Account \n 2.Savings Account");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                System.out.println("Enter Source Account ID:");
                sc.nextLine();
                String sourceID = sc.nextLine();

                switch (choice) {
                    case 1:
                        for (CurrentAccount a : currentAccount) {
                            if (a.getID().equals(sourceID)) {
                                source = a;
                                foundSource = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (SavingsAccount a : savingsAccount) {
                            if (a.getID().equals(sourceID)) {
                                source = a;
                                foundSource = true;
                                break;
                            }
                        }
                        break;
                }

                if(!foundSource) {
                    System.out.println("Source account not found");
                    continue;
                }

                System.out.println("Enter amount:");
                double amount = sc.nextDouble();

                if(!source.canWithdraw(amount))
                {
                    System.out.println("Insufficient balance");
                    continue;
                }

                System.out.println("Enter destination account type:");
                System.out.println("1.Current Account \n 2.Savings Account");
                System.out.println("Enter your choice");
                choice = sc.nextInt();
                System.out.println("Enter Destination Account ID:");
                sc.nextLine();
                String destID = sc.nextLine();

                switch (choice) {
                    case 1:
                        for (CurrentAccount a : currentAccount) {
                            if (a.getID().equals(destID)) {
                                destination = a;
                                foundDestination = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (SavingsAccount a : savingsAccount) {
                            if (a.getID().equals(destID)) {
                                destination = a;
                                foundDestination = true;
                                break;
                            }
                        }
                        break;
                }

                if(!foundDestination) {
                    System.out.println("Destination account not found");
                    continue;
                }

                source.withdraw(amount);
                destination.deposit(amount);
                System.out.println("Successfully deposited tk " + amount + " to " + destination.getName());

            } else if (choice2 == 5) {
                System.exit(0);
            }
        }
    }
}
