package ru.geekbrains.lesson5;

public class Staff {

    private String name; // ФИО
    private String position; // Должность
    private String email; // Электронная почта
    private String phone; // Телефон
    private int wages; // Заработная плата
    private int age; // Возраст

    /**
     * Метод отбражения информации об объекте
     */
    void displayInfo() {
        System.out.printf("ФИО: %s\tДолжность: %s\temail: %s\nТелефон: %s\tЗаработная плата: %d\tВозраст: %s", name, position, email, phone, wages, age);
        System.out.println();
    }

    /**
     * конструктор по умолчанию
     */
    public Staff() {
    }

    // Создаем конструктор
    public Staff(String name, String position, String email, String phone, int wages, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.wages = wages;
        this.age = age;
    }
    // Генерируем метод, который возвращает значение age.
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        // Создаем новый объект person01
        Staff person01 = new Staff("Ларин Сергей Сергеевич", "Android developer", "larin@gmail.com", "+79788662198", 100000, 33);

        Staff[] perArray = new Staff[5]; // Создаем массив объектов

        // Для каждой ячейки массива задаем объект
        perArray[0] = person01;
        perArray[1] = new Staff("Иванов Иван Иванович", "Директор", "ivanov@mail.ru", "+79780000001", 100000, 43);
        perArray[2] = new Staff("Петров Петр Петрович", "Менеджер", "petrov@mail.ru", "+78946513563", 50000, 42);
        perArray[3] = new Staff("Коваленко Сергей Петрович", "Бухгалтер", "kovalenko@mail.ru", "+7987561245", 45000, 30);
        perArray[4] = new Staff("Деев Михаил Петрович", "Экономист", "deev@mail.ru", "+79784561245", 50000, 33);

        // С помощью цикла проходим по всему массиву и выводим информацию о тех сотрудниках, которым больше 40 лет.
        for (int j = 0; j < perArray.length; j++) {
            if (perArray[j].getAge() > 40) {
                perArray[j].displayInfo();
                System.out.println();
            }

        }


    }

}
