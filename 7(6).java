interface Payment
{
    void pay(double amount);
}

interface SecurePayment extends Payment
{
    void verifyPayment();
}

interface OnlineTransaction
{
}

class Account
{
    String accountNo;

    Account(String accountNo)
    {
        this.accountNo = accountNo;
    }

    void displayDetails()
    {
        System.out.println(accountNo);
    }
}

class SavingsAccount extends Account
{
    SavingsAccount(String accountNo)
    {
        super(accountNo);
    }

    void displayDetails()
    {
        System.out.println("Savings Account: " + accountNo);
    }
}

class CurrentAccount extends Account
{
    CurrentAccount(String accountNo)
    {
        super(accountNo);
    }

    void displayDetails()
    {
        System.out.println("Current Account: " + accountNo);
    }
}

class UPIPayment implements SecurePayment, OnlineTransaction
{
    public void pay(double amount)
    {
        System.out.println("UPI Payment: " + amount);
    }

    public void verifyPayment()
    {
        System.out.println("UPI Verified");
    }
}

class CardPayment implements Payment, OnlineTransaction
{
    public void pay(double amount)
    {
        System.out.println("Card Payment: " + amount);
    }
}

public class Main
{
    public static void main(String args[])
    {
        Account a;

        a = new SavingsAccount("SB1001");
        a.displayDetails();

        a = new CurrentAccount("CA2001");
        a.displayDetails();

        UPIPayment u = new UPIPayment();
        u.verifyPayment();
        u.pay(5000);

        CardPayment c = new CardPayment();
        c.pay(3000);

        if(u instanceof OnlineTransaction)
            System.out.println("UPI is Online Transaction");

        if(c instanceof OnlineTransaction)
            System.out.println("Card is Online Transaction");
    }
}