package ru.geekbrains.lesson7;

public class Plate {
    public int food; // Количество еды, которое содержится в тарелке

    /**
     * Создаем конструктор
     *
     * @param food - количество еды, которое содержится в тарелке
     */
    public Plate(int food) {
        this.food = food;
    }

    // Метод выводит информацию о состоянии тарелки
    public void info() {
        System.out.println("plate: " + food);
    }

    /**
     * Метод уменьшает количество еды в тарелке
     *
     * @param n - количество еды, на которое нужно уменьшить
     */
    public void decreaseFood(int n) {
        food -= n;
    }

    /**
     * Метод увеличивает количество еды в тарелке
     *
     * @param x -количество еды, на которое нужно увеличить
     */
    public void increaseFood(int x) {
        food += x;
    }


}
