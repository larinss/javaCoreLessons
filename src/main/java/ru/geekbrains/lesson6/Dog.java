package ru.geekbrains.lesson6;

public class Dog extends Animal {

    private static int counterDog = 0; // Счетчик

    // Инициализатор
    {
        int id = ++counterDog; // Номер собаки
        System.out.printf("Номер собаки: %d\n", id);
    }

    // Конструктор по умолчанию
    public Dog() {

    }

    // Конструктор по умолчанию
    public Dog(String name) { // name - имя собаки
        super(name);
    }

    /** Переопределяем метод из класса Animal
     *
     *
     * @param runDistance - длинна дистанции в метрах
     */
    @Override
    void run(int runDistance) {
        if (runDistance >= 0 && runDistance <= 500)
            System.out.printf("Собака пробежала дистанцию (в метрах): %d\n", runDistance);
        else
            System.out.println("Собака может пробежать дистанцию от 0 до 500 метров");
    }

    /** Переопределяем метод из класса Animal
     *
     *
     * @param swimDistance - длинна дистанции в метрах
     */
    @Override
    public void swim(int swimDistance) {
        if (swimDistance >= 0 && swimDistance <= 10)
            System.out.printf("Собака проплыла дистанцию (в метрах): %d\n", swimDistance);
        else
            System.out.println("Собака может проплыть от 0 до 10 метров");

    }


}
