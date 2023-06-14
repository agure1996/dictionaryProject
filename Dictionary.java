import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;



public class Dictionary {
    

    Map<String,Words> dictionary = new HashMap<>();

    public void loadRecords() throws  Exception{
        

        /** we are going to read the file using buffered reader
         * 
         */
        String filename= "dictionary.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        for(String line = br.readLine(); line != null; line= br.readLine()){

        /** we will then parse (basically read then break into smaller pieces) 
         * the line and spit it where the ',' are (refer to dictionary.txt) */
        String[] parsedLine = line.split(",");
        String wordName = parsedLine[0];
        String definition = parsedLine[1];
           
        /** we now instantiate the Words class here
         * 
         * then put the parsed values in their respective places in the constructor 
         * (to understand the constructor of words refer to words class)
         */

        Words words = new Words(wordName, definition);

        /** We then put the wordName into the Key for Words  */
        this.dictionary.put(wordName,words); 
         
        }       
           /**Close the reader now */
            br.close();   
    }
    
        


    /** we are going to find a word */
    public String findWord(String word){ 
       

        /** we will take an input and loop through our dictionary map for the key value
         * we look for key value because if you remember above we assigned the wordName to
         * the K:V of Words Object which is part of a dictionary Hashmap
         */
        for (String input : dictionary.keySet()){
            /* if we find a word that matches the input */
            if(input.equals(word)){

                /* create a new string that will be used to get the definition of the word that matches the input
                 * 
                 * and return the meaning
                 */
                Words newWord = dictionary.get(input);
                return newWord.meaning;
            }
        }
        /* else return null */

        return "Word does not exist in the dictionary";

    }


    /** Now how about we add a new word
     * 
     * to write the new word we might create a new text file. . . 
     * or we can just append our already existing one, to do this we should use a filewriter with our bufferedwriter
     * otherwise its going to just overwrite our whole file
     */

    public void saveWord() throws Exception{

        String filename= "newdictionary.txt";
        FileWriter fw = new FileWriter(filename);
        BufferedWriter writer = new BufferedWriter(fw);

        for(String input : dictionary.keySet()){
            Words newWord = dictionary.get(input);

            writer.write(newWord.name);
            writer.write(":");
            writer.write(newWord.meaning);
            writer.write("\n");
        }
        writer.close();
    }
    
}
