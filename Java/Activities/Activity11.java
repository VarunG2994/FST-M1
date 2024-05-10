package Activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[]args){

        Map<Integer, String> colors= new HashMap<Integer, String>();
        colors.put(1, "red");
        colors.put(2, "Green");
        colors.put(3, "Blue");
        colors.put(4, "White");
        colors.put(5, "Black");
        System.out.println("The Original map: " + colors);

        colors.remove(2);
        System.out.println(colors.containsValue("Green"));
        System.out.println(colors.size());
    }


}
