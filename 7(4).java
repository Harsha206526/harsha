interface Confidential
{
}

class PublicDocument
{
    String name = "Public Document";
}

class SecretDocument implements Confidential
{
    String name = "Secret Document";
}

public class Main
{
    public static void main(String args[])
    {
        PublicDocument p = new PublicDocument();
        SecretDocument s = new SecretDocument();

        if (p instanceof Confidential)
            System.out.println("Public Document is Confidential");
        else
            System.out.println("Public Document is Not Confidential");

        if (s instanceof Confidential)
            System.out.println("Secret Document is Confidential");
        else
            System.out.println("Secret Document is Not Confidential");
    }
}