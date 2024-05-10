package Activities;


import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> names = new ArrayList<String>();
        //Adding objects to Array List at default index
        names.add("Varun");
        names.add("Chandu");
        names.add("Raaghu");
        names.add(3, "Teju");
        names.add(4, "rakshitha");

        for(String i: names){
            System.out.println(i);
        }
        System.out.println("3rd name of the set is " + names.get(2));
        boolean value=names.contains("Teju");
        System.out.println(value);
        System.out.println(names.size());
        names.remove("rakshitha");
        System.out.println(names.size());
    }


}
