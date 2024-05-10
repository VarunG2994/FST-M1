package Activities;

public class Activity1 {
    public static void main(String[] args){
        Car mycar= new Car();
        mycar.make=2014;
        mycar.color= "Black";
        mycar.transmission="Manual";

        mycar.displayCharacteristics();
        mycar.accelarate();
        mycar.brake();
    }
}
