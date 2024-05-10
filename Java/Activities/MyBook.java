package Activities;

public class MyBook extends Book{
    public void setTitle(String s) {
        title = s;
    }


        public static void main(String []args) {
            //Initialize title of the book
            String title = "Two states";
            Book myBook = new MyBook();
            //Set title
            myBook.setTitle(title);

            //Print result
            System.out.println("The title is: " + myBook.getTitle());
        }
    }



