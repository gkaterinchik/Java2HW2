package Lesson3HW;

import java.util.HashMap;

public  class Test {
    static String[] words = {"абрикос","бузина","картофель","ананас","огурец","томат","морковь","яблоко","груша","огурец","абрикос","картофель",
    "баклажан","стул","стол","баклажан","ананас","бузина","огурец"};

public static void main(String[] args ){
    HashMap<String, Integer> UniqWords = new HashMap<>();
    for (int i = 0; i <words.length ; i++) {
        if (!UniqWords.containsKey((Object)words[i]))
            {
              UniqWords.put(words[i],1);
            }
        else
            {
              UniqWords.put(words[i],UniqWords.get((Object)words[i])+1);
            }
    }

    System.out.println(UniqWords.toString());
}


}