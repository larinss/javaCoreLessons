package ru.geekbrains.lesson11;

import java.util.ArrayList;


public class Box<T extends Fruits> {
    String name;

    public Box(String name) {
        this.name = name;
    }

    private ArrayList<T> fruits = new ArrayList<>();

    /**
     * Метод добавления фрукта в коробку
     *
     * @param fruit - добавляемый фрукт
     */
    public void addFruits(T fruit) {
        fruits.add(fruit);

    }

    /**
     * Метод определения веса коробки
     *
     * @return - возвращает вес коробки типа float
     */
    public float getWeight() {
        float temp = 0.0f;

        if (!fruits.isEmpty()) {
            for (T fruit : fruits) {
                if (fruit instanceof Apple) {
                    temp += ((Apple) fruit).getWeight();
                }
                if (fruit instanceof Orange) {
                    temp += ((Orange) fruit).getWeight();

                }
            }
        }
        return temp;
    }

    /**
     * Метод сравнивает вес 2 - х коробок
     *
     * @param box - коробка, которая подается на вход данному методу
     * @return - возвращает true, если коробки равны, false - если не равны
     */
    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    /**
     * Метод позволяет переместить фрукты из одной коробки в другую такого же типа(например яблоки можно пересыпать только в коробку с яблоками).
     *
     * @param box - коробка, в которую перемещаем фрукты, подается на вход методу.
     */
    public void changeBox(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();

    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", fruits=" + fruits +
                '}';
    }
}
