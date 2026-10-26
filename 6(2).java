package doctor;
public class Doctor
{
private int doctorId;
private String name;
private String specialization;
private double consultationFee;
public Doctor(int doctorId,String name,String specialization,double
consultationFee)
{
this.doctorId=doctorId;
this.name=name;
this.specialization=specialization;
this.consultationFee=consultationFee;
}
public int getDoctorId()
{
return doctorId;
}
public String getName()
{
return name;
}
public String getSpecialization()
{
return specialization;
}
public double getConsultationFee()
{
return consultationFee;
}
public void displayDoctor()
{
System.out.println("Doctor ID : "+doctorId);
System.out.println("Doctor Name : "+name);
System.out.println("Specialization : "+specialization);
System.out.println("Consultation Fee : "+consultationFee);
}
}
package patient;
import doctor.Doctor;
public class Patient

{
private int patientId;
private String name;
private String disease;
private int age;
private Doctor doctor;
public Patient(int patientId,String name,String disease,int age,Doctor
doctor)
{
this.patientId=patientId;
this.name=name;
this.disease=disease;
this.age=age;
this.doctor=doctor;
}
public void displayPatient()
{
System.out.println("-----------------------------");
System.out.println("Patient ID : "+patientId);
System.out.println("Patient Name : "+name);
System.out.println("Disease : "+disease);
System.out.println("Age : "+age);
System.out.println("Doctor Details");
doctor.displayDoctor();
}
public Doctor getDoctor()
{
return doctor;
}
}
import doctor.Doctor;
import patient.Patient;
public class Main
{
public static void main(String args[])
{
Doctor d1=new Doctor(101,"Ramesh","Cardiology",500);
Doctor d2=new Doctor(102,"Priya","Orthopedic",700);
Patient p1=new Patient(1,"Arun","Heart Problem",45,d1);
Patient p2=new Patient(2,"Kiran","Chest Pain",50,d1);
Patient p3=new Patient(3,"Rahul","Bone Fracture",22,d2);
p1.displayPatient();
p2.displayPatient();
p3.displayPatient();

int count1=0,count2=0;
Patient patients[]={p1,p2,p3};
for(int i=0;i<patients.length;i++)
{
if(patients[i].getDoctor()==d1)
count1++;
else if(patients[i].getDoctor()==d2)
count2++;
}
System.out.println("-----------------------------");
System.out.println("Total Consultation Fee");
System.out.println(d1.getName()+" :
"+(count1*d1.getConsultationFee()));
System.out.println(d2.getName()+" :
"+(count2*d2.getConsultationFee()));
}
}