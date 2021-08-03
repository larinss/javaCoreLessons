package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Sample01 {
    static void changeArray(int[] arr, int n) {

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                // Сдвигаем вправо
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                // Сдвигаем влево
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
    }


        static boolean checkBalance ( int[] arr){
            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < arr.length; i++) {
                leftSum = 0;
                rightSum = 0;

                for (int j = 0; j < i; j++) {
                    leftSum += arr[j];
                }

                for (int j = i; j < arr.length; j++) {
                    rightSum += arr[j];
                }

                if (leftSum == rightSum) return true;
            }
            return false;
        }
        // 2-й вариант решения задания 6

    static boolean checkEquals(int[] arr){

            int sum = 0;
            int leftSum = 0;
            int rightSum = 0;

           for (int i = 0;i < arr.length; i++){

               sum += arr[i];
           }

            for (int i = 0;i < arr.length; i++){

                leftSum +=arr[i];

                rightSum = sum - leftSum;
                if(leftSum == rightSum) return true;

            }

            return false;


    }



        public static void main (String[]args){

            System.out.println();
            System.out.println("Задание 1");
            System.out.println();


            //region Задание 1

            int[] array01 = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};


            for (int i = 0; i < 10; i++) {      // С помощью цикла for перебираем все элементы массива.

                if (array01[i] == 0) {          // С помощью условия, если значение элемента массива равено 0,
                    array01[i] = 1;             // меняем его на 1, в остальных случаях меняем на 0.
                } else
                    array01[i] = 0;
                System.out.format("%d\t", array01[i]);
            }
            System.out.println();

            //endregion

            System.out.println();
            System.out.println("Задание 2");
            System.out.println();

            //region Задание 2

            int[] array02 = new int[8];

            for (int i = 0; i < array02.length; i++) {  // С помощью цикла for перебираем все элементы массива.
                array02[i] = i * 3;                      // Присваиваем каждому элементу массива значения(начиная с 0 и далее, каждому следующему элементу, значение увеличивается с шагом 3)
                System.out.print(array02[i] + "\t");

            }
            System.out.println();
            //endregion

            System.out.println();
            System.out.println("Задание 3");
            System.out.println();

            //region Задание 3

            int[] array03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

            for (int i = 0; i < array03.length; i++) { // С помощью цикла for перебираем все элементы массива.
                if (array03[i] < 6) {                  // С помощью условия проверяем, если значение элемента массива меньше 6,
                    array03[i] = array03[i] * 2;        //то присваиваем это значение, умноженное на 2

                }

            }
            System.out.println(Arrays.toString(array03)); // Используем метод, который позволяет отобразить массив в виде строки.

            //endregion

            System.out.println();
            System.out.println("Задание 4");
            System.out.println();

            //region Задание 4

            int[][] array04 = new int[5][5];

            for (int i = 0; i < array04.length; i++) {       //С помощью цикла присвоили всем элементам массива значение 0
                for (int j = 0; j < array04[i].length; j++) {
                    array04[i][j] = 0;
                    System.out.print(array04[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();


                for (int i = 0; i < array04.length; i++) {    //Присваиваем диагональным элементам массива значение 1
                    for (int j = 0; j < array04.length; j++) {
                        array04[i][i] = 1;
                        array04[i][array04.length - i - 1] = 1;
                        System.out.print(array04[i][j] + "\t");
                    }
                    System.out.println();


                }


            //endregion

            System.out.println();
            System.out.println("Задание 5");
            System.out.println();

            //region Задание 5

            int[] array05 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

            int maxX = 0;
            int max = array05[maxX];

            for (int i = 0; i < array05.length; i++) {
                if (array05[i] > max) {
                    max = array05[i];
                    maxX = i;
                }

            }
            System.out.println("Максимальное значение элемента массива " + max + " находится по индексу " + "[" + maxX + "]");

            int minX = 0;
            int min = array05[minX];

            for (int i = 0; i < array05.length; i++) {
                if (array05[i] <= min) {
                    min = array05[i];
                    minX = i;
                }

            }
            System.out.println("Минимальное значение элемента массива " + min + " находится по индексу " + "[" + minX + "]");

            //endregion

            System.out.println();
            System.out.println("Задание 6");
            System.out.println();

            //region Задание 6

            // Используем созданный метод, который проверяет есть ли место, где сумма левой и правой части равны.

            int[] array06 = {1, 1, 1, 1, 2};
            System.out.println(Arrays.toString(array06));
            System.out.println();
            checkBalance(array06);
            System.out.println(checkBalance(array06));

            //endregion

            System.out.println();
            System.out.println("Задание 7");
            System.out.println();

            //region Задание 7

            System.out.println("Сдвигаем вправо");
            System.out.println();

            int[] array07 = {1, 2, 3, 4, 5}; // Исходный массив
            System.out.println("Исходный массив " + Arrays.toString(array07));

            changeArray(array07, 2);
            System.out.println("Полученный массив " + Arrays.toString(array07)); // Полученный массив
            System.out.println();

            System.out.println("Сдвигаем влево");
            System.out.println();
            int[] array08 = {1, 2, 3, 4, 5}; // Исходный массив
            System.out.println("Исходный массив " + Arrays.toString(array08));


            changeArray(array08, -2);
            System.out.println("Полученный массив " + Arrays.toString(array08)); // Полученный массив

            //endregion

        }


    }









