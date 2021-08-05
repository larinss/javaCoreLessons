package ru.geekbrains.lesson7;

import java.util.Scanner;

public class Sample01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int addition; // количество еды, которое нужно добавить в тарелку
        boolean fExit = false; // флаг выхода

        Cat[] arrayCats = new Cat[5]; //Создаем массив котов
        arrayCats[0] = new Cat("Барсик", 5, false);
        arrayCats[1] = new Cat("Пушок", 10, false);
        arrayCats[2] = new Cat("Мурзик", 15, false);
        arrayCats[3] = new Cat("Васька", 25, false);
        arrayCats[4] = new Cat("Мишка", 15, false);


        Plate plate = new Plate(60);
        plate.info();
        for (Cat arrayCat : arrayCats) {
            if (!arrayCat.checkSatiety && arrayCat.appetite < plate.food) {
                arrayCat.eat(plate);
                arrayCat.checkSatiety = true;
                System.out.println(arrayCat.name + " накормлен!");
            } else if (arrayCat.checkSatiety)
                System.out.println(arrayCat.name + " накормлен!");

            else
                System.out.println(arrayCat.name + " голоден!");

        }
        plate.info();
        while (!fExit) {
            System.out.print("Введите необходимое количество еды и нажмите Enter: ");
            System.out.println();
            if (scanner.hasNextInt()) {

                addition = scanner.nextInt();

                plate.increaseFood(addition); // Происходит добавление еды в тарелку
                plate.info();
                fExit = true;
            } else System.out.println("Введены некорректные данные");
            scanner.nextLine();
        }

        for (Cat arrayCat : arrayCats) {
            if (!arrayCat.checkSatiety && arrayCat.appetite < plate.food) {
                arrayCat.eat(plate);
                arrayCat.checkSatiety = true;
                System.out.println(arrayCat.name + " накормлен!");
            } else if (arrayCat.checkSatiety)
                System.out.println(arrayCat.name + " накормлен!");

            else
                System.out.println(arrayCat.name + " голоден!");

        }

        scanner.close();

    }
}
