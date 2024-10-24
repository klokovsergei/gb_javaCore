package lesson2;

import java.util.Arrays;

public class MainLesson2 {
    public static void main(String[] args) {

//        1.Написать метод, возвращающий количество чётных элементов массива.
//          countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
        int[] arr = null;
        System.out.println(countEvens(new int[]{2, 1, 2, 3, 4}));

//        2.Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.

        System.out.println(findDeltaMaxMin(new int[]{2, -2, 2, 3, 4}));

//        3.Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

        System.out.println(checkNeighborsZero(new int[]{2, -2, 0, 1, 0}));

    }
    private static int countEvens(int[] arr) throws RuntimeException{
        if (arr == null)
            throw new RuntimeException("Массив не может быть равен null");
        return (int) Arrays.stream(arr).filter(x -> x % 2 == 0).count();
    }

    private static int findDeltaMaxMin(int[] arr) throws RuntimeException{
        if (arr == null)
            throw new RuntimeException("Массив не может быть равен null");
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int minValue = Arrays.stream(arr).min().getAsInt();

        return maxValue - minValue;
    }

    private static boolean checkNeighborsZero(int[] arr) throws RuntimeException{
        if (arr == null)
            throw new RuntimeException("Массив не может быть равен null");
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == 0 && arr[i + 1] == 0)
                return true;
        return false;
    }
}
