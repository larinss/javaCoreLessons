package ru.geekbrains.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ArrayMethods<T> {

    /**
     * Данный метод меняет два элемента массива местами
     *
     * @param array  - массив, в котором меняем элементы
     * @param index1 - 1-й индекс массива
     * @param index2 - 2-й индекс массива
     * @return - возвращаем измененный массив
     */
    public T[] swap(T[] array, int index1, int index2) {
        T temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        return array;
    }

    /**
     * Данный метод преобразует массив в коллекцию
     *
     * @param array - массив, который хотим преобразовать
     * @return - возвращаем получившуюся коллекцию
     */
    public ArrayList changeArrayToArrayList(T[] array) {
        ArrayList arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println();
        Integer[] arr02 = {1, 2, 3, 4, 5};
        String[] arr01 = {"apple", "orange", "peach", "kiwi", "lemon"};
        ArrayMethods arrayMethods = new ArrayMethods();

        System.out.println("Массивы до преобразования:\n" + Arrays.toString(arr01));
        System.out.println(Arrays.toString(arr02));
        System.out.println();
        System.out.println("После:\n" + Arrays.toString(arrayMethods.swap(arr01, 0, 1)));
        System.out.println(Arrays.toString(arrayMethods.swap(arr02, 3, 4)));
        System.out.println();

        System.out.println("Преобразование массива в коллекцию");
        System.out.println(arrayMethods.changeArrayToArrayList(arr01));
        System.out.println(arrayMethods.changeArrayToArrayList(arr02));


    }

}
