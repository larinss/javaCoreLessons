package ru.geekbrains.lesson6;

public class Cat extends Animal {

    private static int counterCat = 0; // Счетчик


    {
        int id = ++counterCat; // номер кота
        System.out.printf("Номер кота: %d\n", id);
    }

    // Конструктор без параметров
    public Cat() {
    }

    // Конструктор с параметрами
    public Cat(String name) { // name - имя кота
        super(name);
    }

    /** Переопределяем метод из класса Animal
     *
     * @param runDistance - длинна дистанции в метрах
     */
    @Override
    void run(int runDistance) {
        if (runDistance >= 0 && runDistance <= 200)
            System.out.printf("Кот пробежал дистанцию (в метрах): %d\n", runDistance);
        else
            System.out.println("Кот может пробежать дистанцию от 0 до 200 метров");
    }

    /** Переопределяем метод из класса Animal
     *
     * @param swimDistance  - длинна дистанции в метрах
     */
    @Override
    public void swim(int swimDistance) {
        System.out.print("Кот не умеет плавать!\n");
    }

    // Переопределяем метод из класса Animal
    @Override
    public void animalInfo() {
        super.animalInfo();
    }
}
