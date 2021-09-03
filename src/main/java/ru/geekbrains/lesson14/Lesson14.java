package ru.geekbrains.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson14 {


    /**
     * Метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
     *
     * @param arrIn - входной одномерный целочисленный массив.
     * @return - новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки
     */
    public static int[] method01(int[] arrIn) {

        List<Integer> list = new ArrayList<>();

        for (int el : arrIn) {
            list.add(el);
        }
        if (!list.contains(4)) throw new RuntimeException();
        int index = 0;
        for (int i = 0; i < arrIn.length; i++) {
            if (arrIn[i] == 4) {
                index = i;
            }
        }

        int[] arrOut = new int[arrIn.length - (index + 1)];
        for (int i = index + 1, j = 0; i < arrIn.length; i++, j++) {
            arrOut[j] = arrIn[i];

        }

        return arrOut;

    }

    /**
     * Метод анализирует массив int[]. Массив должен содержать элементы (и 1 и 4). Другие элементы типа int недопустимы.
     *
     * @param arrIn - одномерный целочисленный массив, который передается на вход методу. Он подлежит анализу.
     * @return true - если условие выполняется, false - в противном случае.
     */
    public static boolean method02(int[] arrIn) {
        List<Integer> list = new ArrayList<>();

        for (int el : arrIn) {
            list.add(el);
        }
        for (Integer el : list) {
            if (el != 1 && el != 4) return false;

        }
        return list.contains(1) && list.contains(4);
    }

    public static void main(String[] args) {
        int[] arr01 = {1, 2, 3, 4, 5, 6, 4, 8, 1, 4, 6, 8, 7};
        int[] arr02 = {4, 4, 4, 4, 1, 1, 1, 1, 4};
        int[] arr03 = {1, 1, 1, 2, 1, 2, 1, 2, 12, 2};
        int[] arr04 = {1, 1, 1, 1};
        int[] arr05 = {4, 4, 4, 4};


        System.out.println(Arrays.toString(method01(arr05)));

        System.out.println(method02(arr04));


    }


}
