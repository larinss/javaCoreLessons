package ru.geekbrains.lesson1;

public class Sample01 {

    //region Задание 2

    // Создаем примитивные типы данных и инициализируем их

    byte a = 1; // 8-битное знаковое целое число, значение от -128 до 127

    short b = 2; // 16-битное знаковое целое число, значение от -32768 до 32767

    int c = 3; // 32-битное знаковое целое число, значение от -2147483648 до 2147483647

    long d = 4L; // 64-битное знаковое целое число, значение от -9223372036854775808 до 9223372036854775807

    float e = 5.55f; // 32-битное знаковое число с плавающей запятой одинарной точности

    double g = 6.666; // 64-битное знаковое число с плавающей запятой двойной точности

    char h = '*'; // 16-битный тип данных, предназначенный для хранения символов в кодировке Unicode

    boolean j = true; // логический тип данных

    // endregion

    //region Задание 3

    //Создаем метод для вычисления выражения a * (b + (c / d))

    public static float task03(float a, float b, float c, float d){

        float result = a * (b + (c / d));
        System.out.println("Результат выражения a * (b + (c / d)) равен: " + result);
        return result;

    }
    //endregion

    //region Задание 4

    // Этот метод проверяет находится ли сумма 2-х чисел в диапазоне от 10 до 20 включительно

    public static boolean task10and20(int x1, int x2){

        int sum = x1 + x2;

        if(sum >= 10 && sum <= 20){
            System.out.println(true);
            return true;
        }
        else{
            System.out.println(false);
            return false;
        }

    }

    //endregion

    //region Задание 5

    //Данный метод проверяет положительное число или отрицательное

    public static void isPositiveOrNegative(int x){

        if(x >= 0){
            System.out.println(x + " - число положительное");
        }
        else
            System.out.println(x + " - число отрицательное");
    }

    //endregion

    //region Задание 6

    // Метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

    public static boolean isNegative(int x){

        if(x < 0){
            System.out.println(true);
            return true;
        }
        else {
            System.out.println(false);
            return false;
        }
    }


    //endregion

    //region Задание 7

    public static void printName (String name){
        System.out.println("Привет, " + name + "!");
    }
    //endregion

    //region Задание 8

    // Метод определяет высокосный год ли нет

        public static void highYearOrNot(int year) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(year + " высокосный год");
            }
            else {
                System.out.println(year + " не высокосный год");
            }
        }
    //endregion


    // Создаем точку входа в программу

            public static void main(String[] args) {

        task03(1.13f,1.12f,3.156f,5.6789f); // Применяем метод из задания 3

        task10and20(10,5); // Применяем метод из задания 4

        isPositiveOrNegative(0); // Применяем метод из задания 5

        isNegative(-2); // Применяем метод из задания 6

        printName("Сергей"); // Применяем метод из задания 7

        highYearOrNot(300);


    }

}







