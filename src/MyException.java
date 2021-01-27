import java.util.Random;

public class MyException {
    public static String[][] arr = new String[4][4];
    public static String[][] arr2 = new String[4][4];
    public static Random a = new Random();

    public static void main(String[] args) throws MySizeArrayException, MyArrayDataException {
        Random a = new Random();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = a.nextInt(10) + "";
                System.out.println(arr[i][j]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("");
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = a.nextInt(10) + "";
                System.out.println(arr2[i][j]);
            }
        }
        //testMethod(arr);
        testMethod(new String[6][6]);
        arr2[2][3] = "e";
        //testMethod(arr2);
    }

    public static void testMethod(String[][] strArr) throws MySizeArrayException, MyArrayDataException {
        int lasti = 0, lastj = 0;
        try {
            if (strArr.length != 4) {
                throw new MySizeArrayException();
            }
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].length != 4)
                    throw new MySizeArrayException();


            }

        } catch (MySizeArrayException e) {

            System.out.println("Неверная размерность массива! Массив должен  быть размерностью [4][4]");
            e.printStackTrace();
        }

        try {
            int sum = 0;
            for (int i = 0; i < strArr.length; i++) {
                for (int j = 0; j < strArr[i].length; j++) {
                    lasti = i;
                    lastj = j;
                    sum = sum + Integer.parseInt(strArr[i][j]);


                }

            }
            System.out.println("sum= " + sum);

        } catch (NumberFormatException e) {
            try {
                throw new MyArrayDataException();
            } catch (MyArrayDataException ex) {
                System.out.println("Невозможно преобразовать символ в число arr[" + lasti + "]" + "[" + lastj + "]");
                ex.printStackTrace();
            }


        }

    }


    public static class MySizeArrayException extends Exception {

    }

    public static class MyArrayDataException extends Exception {

    }

}