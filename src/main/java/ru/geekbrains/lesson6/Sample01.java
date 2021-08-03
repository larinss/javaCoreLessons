package ru.geekbrains.lesson6;

public class Sample01 {

    public static void main(String[] args) {
        Cat cat01 = new Cat("Барсик"); // Создаем нового кота с именем Барсик
        // Вызываем методы и задаем длинну дистанции
        cat01.animalInfo();
        cat01.run(300);
        cat01.swim(120);
        System.out.println();

        Cat cat02 = new Cat("Пупсик"); // Создаем кота с именем Пупсик
        // Вызываем методы и задаем длинну дистанции
        cat02.animalInfo();
        cat02.run(12);
        cat02.swim(10);
        System.out.println();

        Dog dog01 = new Dog("Шарик"); // Создаем собаку с именем Шарик
        // Вызываем методы и задаем длинну дистанции
        dog01.animalInfo();
        dog01.run(120);
        dog01.swim(10);
        System.out.println();

        Dog dog02 = new Dog("Бублик"); // Создаем собаку с именем Бублик
        // Вызываем методы и задаем длинну дистанции
        dog02.animalInfo();
        dog02.run(600);
        dog02.swim(15);
        System.out.println();


    }


}
