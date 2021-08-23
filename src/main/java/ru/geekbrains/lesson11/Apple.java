package ru.geekbrains.lesson11;

public class Apple extends Fruits {

    private String name;
    private float weight = 1.0f;

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Apple(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s: вес %.1f\n", getName(), getWeight());
    }
}
