package Activities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
       Set<String> hs= new HashSet<String>();
       hs.add("Table");
       hs.add("Chair");
       hs.add("car");
       hs.add("Scooter");
       hs.add("Fan");
       hs.add("Ac");

       for(String i: hs){
           System.out.println(i);
       }
        System.out.println(hs.size());
        if(hs.remove("TV")) {
            System.out.println("Z removed from the Set");
        } else {
            System.out.println("Z is not present in the Set");
        }
        hs.remove("Ac");

        System.out.println(hs.contains("Tv"));

        for(String i: hs){
            System.out.println(i);
        }


    }

}
