package Activities;

public class Activity8 {

     static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }

    public static void main(String[] a){
        try {
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException e) {
            System.out.println("Inside catch block: " + e.getMessage());
        }
    }
}
