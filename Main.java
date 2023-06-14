

public class Main {

    public static void main(String[] args) throws  Exception {
        

        Dictionary dictionary = new Dictionary();

       dictionary.loadRecords();

        System.out.println(dictionary.findWord("snooze"));

        //Just a test to see if it adds
        // dictionary.saveWord("A", "the first letter of the alphabet");

     
    }
    
}
