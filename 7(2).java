interface Payment
{
    void pay(double amount);
}

class CreditCardPayment implements Payment
{
    public void pay(double amount)
    {
        System.out.println("Credit Card Payment: " + amount);
    }
}

class UPIPayment implements Payment
{
    public void pay(double amount)
    {
        System.out.println("UPI Payment: " + amount);
    }
}

class NetBankingPayment implements Payment
{
    public void pay(double amount)
    {
        System.out.println("Net Banking Payment: " + amount);
    }
}

public class Main
{
    public static void main(String args[])
    {
        Payment p;

        p = new CreditCardPayment();
        p.pay(5000);

        p = new UPIPayment();
        p.pay(2500);

        p = new NetBankingPayment();
        p.pay(1000);
    }
}