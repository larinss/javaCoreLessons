package ru.geekbrains.lesson7;

public class Cat {
    public String name; // Имя кота
    public int appetite; // Аппетит кота(то, сколько он может съесть)
    public boolean checkSatiety; // сытость кота

    /**
     * Создаем конструктор
     *
     * @param name         - имя кота
     * @param appetite     - аппетит кота(то, сколько он может съесть)
     * @param checkSatiety - сытость кота
     */
    public Cat(String name, int appetite, boolean checkSatiety) {
        this.name = name;
        this.appetite = appetite;
        this.checkSatiety = checkSatiety;
    }

    /**
     * Метод уменьшает количество еды в тарелке на аппетит кота(то, сколько он может съесть)
     *
     * @param p - объект класса тарелка
     */
    public void eat(Plate p) {

        p.decreaseFood(appetite);

    }

}
