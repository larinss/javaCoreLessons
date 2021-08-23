package ru.geekbrains.lesson11;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Apple ap01 = new Apple("red apple");
        Apple ap02 = new Apple("green apple");
        Apple ap03 = new Apple("yellow apple");

        Orange or01 = new Orange("orange1");
        Orange or02 = new Orange("orange2");
        Orange or03 = new Orange("orange3");


        Box<Apple> appleBox01 = new Box<>("appleBox01");
        Box<Apple> appleBox02 = new Box<>("appleBox02");
        Box<Orange> orangeBox01 = new Box<>("orangeBox01");
        Box<Orange> orangeBox02 = new Box<>("orangeBox02");

        appleBox01.addFruits(ap01);
        appleBox01.addFruits(ap02);
        appleBox01.addFruits(ap03);

        orangeBox01.addFruits(or01);
        orangeBox01.addFruits(or02);
        orangeBox01.addFruits(or03);

        System.out.println();
        System.out.printf("Вес коробки appleBox01 равен %.1f\n", appleBox01.getWeight());
        System.out.printf("Вес коробки orangeBox01 равен %.1f\n\n", orangeBox01.getWeight());
        System.out.println("Сравниваем вес коробки appleBox01 с  весом коробки orangeBox01");
        System.out.print("Результат: " + appleBox01.compare(orangeBox01));
        System.out.println();

        // Проверка перемещения фруктов из одной коробки в другую
        appleBox01.changeBox(appleBox02);

        /* appleBox02.changeBox(orangeBox01);
            Не получится переместить, так как разные типы Apple и Orange
            То есть коробку яблок можно пересыпать только в коробку яблок
         */

    }

}
