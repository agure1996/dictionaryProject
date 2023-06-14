

public class Main {

    public static void main(String[] args) throws  Exception {
        

        Dictionary dictionary = new Dictionary();

        dictionary.loadRecords();

        System.out.println(dictionary.findWord("run"));

        dictionary.saveWord();
    }
    
}
