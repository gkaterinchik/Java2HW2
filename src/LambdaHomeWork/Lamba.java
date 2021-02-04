package LambdaHomeWork;

import lambda.Operation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Lamba {
   static ArrayList<String> resultList=new ArrayList<>();

    public static void main(String[] args) {


        Maximum maximum1 = (list) -> {
            Integer max = list[0];
            for (Integer val : list
            ) {
                if (val > max)
                    max = val;
            }
            return max;

        };


        Reversable reverse = Lamba::reverse;

        Operationable operation = (x, y) -> {
            for (int i = 0; i < y.length; i++) {
                if (x == y[i])
                    return i;
            }
            return -1;
        };


        Integer[] list = {1, 6, 10, 5, 15, 2, 0};                //Вызов метода  maximum
        System.out.println(maximum(list, maximum1));

        Integer[] arr = {2, 3, 4, 1, 5};
        System.out.println(search(2, arr, operation));        //Вызов метода  search

        String testString = "java interview";
        System.out.println(reverseStr(testString, reverse));     //Вызов метода  reverseStr

        System.out.println(average(Arrays.asList(arr)));         //Вызов метода  average

        List<String> coolStringList = Arrays.asList("aaa", "abc", "aaa","sdfg","aaa","awe","wer");

        System.out.println(search(coolStringList));
    }

    ;


    public static String reverseStr(String string, Reversable rev) {
        return rev.reverse(string);
    }


    public static int search(Integer n, Integer[] list, Operationable z) {
        return z.firstEntry(n, list);
    }


    private static String reverse(String str) {
        StringBuilder resStr = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            resStr.append(str.charAt(i));
        }
        return resStr.toString();
    }

    public static Integer maximum(Integer[] list, Maximum m) {
        return m.maxInt(list);
    }

    public static Double average(List<Integer> list) {
        Averageble averageVal = (x) -> {
            int sum = 0;
            int listLenght = 0;
            double averageValue;
            for (Integer val : x
            ) {
                listLenght++;
                sum = sum + val;
            }
            averageValue = sum / listLenght;
            return averageValue;
        };
        return averageVal.average(list);
    }


    public static List<String> search(List<String> list)
    {
        Searcheble search = (x)->{
            for (String str : list)
            {
                if (str.matches("a\\w{2}"))
                {
                    resultList.add(str);
                }


            }
            return resultList;
        };


       return search.searchString(list);
    }


}


