class ExamTask implements Runnable
{
String activity;

ExamTask(String activity)
{
this.activity = activity;
}

public void run()
{
try
{
for(int i=1;i<=3;i++)

{

System.out.println(Thread.currentThread().getName()+" :
"+activity+" ("+i+")");

if(activity.equals("Display Remaining Time"))
Thread.sleep(1000);

else if(activity.equals("Auto Save Answers"))
Thread.sleep(1500);

else
Thread.sleep(2000);
}
}
catch(Exception e)
{
System.out.println(e);
}
}

}

public class Main
{
public static void main(String args[])
{
ExamTask t1 = new ExamTask("Display Remaining Time");
ExamTask t2 = new ExamTask("Auto Save Answers");
ExamTask t3 = new ExamTask("Check Network
Connection");

Thread th1 = new Thread(t1);
Thread th2 = new Thread(t2);
Thread th3 = new Thread(t3);

th1.setName("Timer Thread");
th2.setName("AutoSave Thread");
th3.setName("Network Thread");

th1.start();
th2.start();
th3.start();
}
}