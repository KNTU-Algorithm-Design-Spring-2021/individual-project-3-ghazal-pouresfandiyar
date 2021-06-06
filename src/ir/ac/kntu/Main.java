package ir.ac.kntu;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String , Boolean> dic = readDictionaryFromFile();

    }
    public static HashMap<String , Boolean> readDictionaryFromFile (){
        HashMap<String , Boolean> DICTIONARY = new HashMap<>();
        File file = new File("Dictionary.txt");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        try {
            while ((st = br.readLine()) != null) {
                if(st.length() == 1 && !st.equals("a") && !st.equals("i")) {
                    DICTIONARY.put(st, false);
                }else {
                    DICTIONARY.put(st, true);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return DICTIONARY;
    }
}
