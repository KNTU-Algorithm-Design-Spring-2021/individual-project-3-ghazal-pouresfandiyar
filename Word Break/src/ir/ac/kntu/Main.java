package ir.ac.kntu;

import java.io.*;
import java.util.HashMap;

public class Main {

    static HashMap<String , Boolean>  DICTIONARY ;

    public static void main(String[] args) {

        DICTIONARY= readDictionaryFromFile();
        sentenceBreak("mango");
        sentenceBreak("ILOVEICECREAMANDMANGO");
        sentenceBreak("IAMBATMAN");
        sentenceBreak("CALLSECURITYATMIAMIAIRPORTBECAUSEITHINKABOMBISABOUTTOGOOFF");
        sentenceBreak("ABORTTHEPLANMEETATTHEDARKCABIN");
        sentenceBreak("LADIESANDGENTLEMENPLEASEWEARYOURMASKSEVERYWHERE");
        sentenceBreak("MYGRANDMOTHERALWAYSREMINDEDMETODRIVECAREFULLYANYTIMEIAMONMYWAYTOHOME");

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

    public static boolean isValid(String word){
        if(DICTIONARY.get(word) == null) {
            return false;
        } else if(DICTIONARY.get(word)) {
            return true;
        }
        return false;
    }

    public static void tracingTree(String str, String result) {
        int size = str.length();
        for (int i = 1; i <= size; i++) {
            String prefix = str.substring(0, i);

            if (isValid(prefix)) {
                if (i == size) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                tracingTree(str.substring(i, size), result + prefix + " ");
            }
        }
    }

    public static void sentenceBreak(String str){
        System.out.println("__________________________________________________________________________________");
        tracingTree(str.toLowerCase() , "");
    }

}
