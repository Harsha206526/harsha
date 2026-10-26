interface BasicSecurity
{
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity
{
    void fingerprint();
    void faceRecognition();
}

class BankingApplication implements AdvancedSecurity
{
    public void login()
    {
        System.out.println("Login Successful");
    }

    public void logout()
    {
        System.out.println("Logout Successful");
    }

    public void fingerprint()
    {
        System.out.println("Fingerprint Verified");
    }

    public void faceRecognition()
    {
        System.out.println("Face Recognition Verified");
    }
}

public class Main
{
    public static void main(String args[])
    {
        BankingApplication obj = new BankingApplication();

        obj.login();
        obj.fingerprint();
        obj.faceRecognition();
        obj.logout();
    }
}