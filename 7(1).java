class Vehicle
{
    String vehicleNumber;
    String brand;
    int speed;

    Vehicle(String vehicleNumber, String brand, int speed)
    {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    void displayDetails()
    {
        System.out.println(vehicleNumber + " " + brand + " " + speed);
    }
}

class Car extends Vehicle
{
    int numberOfDoors;

    Car(String vehicleNumber, String brand, int speed, int numberOfDoors)
    {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    void displayDetails()
    {
        System.out.println("Car");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle
{
    boolean hasGear;

    Bike(String vehicleNumber, String brand, int speed, boolean hasGear)
    {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    void displayDetails()
    {
        System.out.println("Bike");
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
        System.out.println("Has Gear: " + hasGear);
    }
}

public class Main
{
    public static void main(String args[])
    {
        Vehicle v;

        v = new Car("TN01AB1234", "Honda", 120, 4);
        v.displayDetails();

        System.out.println();

        v = new Bike("TN09XY4567", "Yamaha", 90, true);
        v.displayDetails();
    }
}