package ru.geekbrains.lesson11;

public class Orange extends Fruits {
    private String name;
    private float weight = 1.5f;

    public float getWeight() {
        return weight;
    }

    public Orange(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s: вес %.1f\n", getName(), getWeight());
    }
}
