package Lesson5;

public class Multithreading {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public void method1(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        ;
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        ;
        System.out.println("Время без использования многопоточности  " + (System.currentTimeMillis() - a));

    }

    class arrayThread extends Thread {
        private float[] values;

        public arrayThread(float[] values) {
            this.values = values;
        }

        @Override
        public void run() {
            for (int i = 0; i < h; i++) {
                values[i] = (float) (values[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }

        }
    }


    public void method2(float[] arr) {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h / 2, arr2, 0, h);
        arrayThread thread1 = new arrayThread(arr1);
        arrayThread thread2 = new arrayThread(arr2);
        thread1.run();
        thread2.run();
        System.arraycopy(thread1.values, 0, arr, 0, h);
        System.arraycopy(thread2.values, 0, arr, h, h);


        System.out.println("Время при использовании многопоточности  " + (System.currentTimeMillis() - a));

    }


    public static void main(String[] args) {
        // method1(arr);
        Multithreading mult1 = new Multithreading();
        mult1.method2(arr);
        Multithreading mult2 = new Multithreading();
        mult2.method1(arr);
    }
}
