package ru.geekbrains.lesson6;

public class Animal {


    String name; // Имя животного
    private static int counterAnimal = 0; //Счетчик животного

    //Инициализатор
    {
        int id = ++counterAnimal; // Номер животного
        System.out.printf("Номер животного: %d\n", id);
    }
    // конструктор без параметров
    public Animal() {

    }

    /** Конструктор с параметром
     *
     * @param name // Имя животного
     */
    public Animal(String name) {
        this.name = name;
    }

    /** Метод отображения дистанции, которую пробежало животное
     *
     * @param runDistance - длинна дистанции в метрах
     */
  void run(int runDistance) {
        System.out.printf("Животное пробежало: %d\n", runDistance);
    }

    /** Метод отображения дистанции, которую проплыло животное
     *
     * @param swimDistance  - длинна дистанции в метрах
     */
    public void swim(int swimDistance) {
        System.out.printf("Животное проплыло: %d\n", swimDistance);
    }

    // Метод отображения имени животного
         public  void animalInfo(){
        System.out.printf("Имя: %s\n", name);
    }


}
