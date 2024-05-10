package Activities;

public class Car {
String color;
String transmission;
int make;
int tyre;
int doors;

public Car(){
    tyre=4;
    doors=4;
}

public void displayCharacteristics(){
    System.out.println("The color of the car is " + color);
    System.out.println("The transmission of the car is " + transmission);
    System.out.println("The make of the car is " + make);
    System.out.println("The tyre of the car is " + tyre);
    System.out.println("The doors of the car is " + doors);


}

public void accelarate(){
    System.out.println("Car is moving forward.");
}

    public void brake(){
        System.out.println("Car has stopped.");
    }
}
