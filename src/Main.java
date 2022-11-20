import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] arrayF = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] arrayF1 = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}};
        String[][] arrayF2 = {{"1", "2", "C", "4"}, {"1", "2", "3", "С"}};
        String[][][] arr = {arrayF, arrayF1, arrayF2};

        for (int i = 0; i < arr.length; i++) {
            try {
                SumAllElement sum = new SumAllElement(arr[i][0].length, arr[i][1].length);
                sum.checkSize(arr[i][0].length, arr[i][1].length);
                sum.sumElement(arr[i]);

            } catch (SumAllElement.MyArrayDataException e) {
                System.out.printf("В массиве arr[%s] символ [%d][%d] %s", i, e.getX(), e.getY(), e.getMessage());
            } catch (SumAllElement.MyArraySizeException e) {
                System.out.printf("Размер массива arr[%s] составляет [%d][%d], %s\n", i, arr[i][0].length, arr[i][1].length, e.getMessage());
            }

        }

    }
}

class SumAllElement {

    int x, y;
    int sum = 0;
    int a = 0;
    String[][] arrayFour;

    public SumAllElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean checkSize(int x, int y) throws MyArraySizeException {

        if (x != 4 || y != 4) {
            throw new MyArraySizeException("Массив не [4][4]", x, y);
        }
        return true;
    }

    public void sumElement(String[][] arrayFour) throws MyArrayDataException {
        int x = 0, y = 0;

        try {
            for (int i = 0; i < arrayFour.length; i++) {
                if (i == 0) {
                    for (int j = 0; j < arrayFour[0].length; j++) {
                        x = i;
                        y = j;
                        a = Integer.parseInt(arrayFour[i][j]);
                        sum += a;

                    }
                } else if (i == 1) {
                    for (int j = 0; j < arrayFour[1].length; j++) {
                        x = i;
                        y = j;
                        a = Integer.parseInt(arrayFour[i][j]);
                        sum += a;

                    }
                }

            }
            System.out.println("Сумма массива: " + sum);

        } catch (NumberFormatException e) {
            throw new MyArrayDataException("не является числом!", x, y);
        }
    }


    class MyArrayDataException extends ArrayException {

        public MyArrayDataException(String message, int x, int y) {
            super(message, x, y);
        }
    }

    class MyArraySizeException extends ArrayException {

        public MyArraySizeException(String message, int x, int y) {

            super(message, x, y);
        }
    }

    abstract class ArrayException extends Exception {
        int x, y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public ArrayException(String message, int x, int y) {
            super(message);
            this.x = x;
            this.y = y;

        }
    }
}