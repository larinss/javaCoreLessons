package ru.geekbrains.lesson10;

public class MyPhonebook {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addId("+71111111", "Иванов");
        phonebook.addId("+71111112", "Петров");
        phonebook.addId("+71111113", "Иванов");
        phonebook.addId("+71111114", "Иванов");
        phonebook.addId("+71111115", "Сидоров");
        phonebook.addId("+71111116", "Михайлов");
        phonebook.addId("+71111117", "Михайлов");
        phonebook.addId("+71111118", "Распутин");

        phonebook.getId("Иванов");
        phonebook.getId("Батыров");

    }
}
