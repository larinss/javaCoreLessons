package ru.geekbrains.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, String> phonebook = new HashMap<>();

    /**
     * Метод позволяет добавить новый контакт в телефонную книгу
     *
     * @param number - номер телефона
     * @param name   - имя
     */
    public void addId(String number, String name) {
        // С помощью метода containsKey проверяем, содержится ли такой ключ(номер телефона) в коллекции
        // Если не содержится, то добавляем контакт
        if (!phonebook.containsKey(number)) {
            phonebook.put(number, name);
            System.out.printf("Контакт, с именем %s, успешно добавлен\n", name);
        } else {
            System.out.printf("%s - этот номер телефона уже есть в списке контактов\n", number);
        }
    }

    /**
     * Метод позволяет отображать номера телефонов по искомому имени
     *
     * @param name - имя
     */
    public void getId(String name) {
        //С помощью цикла foreach проходим по всем элементам коллекции.
        for (Map.Entry<String, String> e : phonebook.entrySet()) {
            // Сравниваем name c значениями ключей в коллекции, если находим, то выводим на экран
            if (e.getValue().equals(name)) {
                System.out.printf("%s - номер телефона: %s\n", e.getValue(), e.getKey());
            }
        }
        // Если такого значения нет в коллекции, то выводим соответствующее сообщение
        if (!phonebook.containsValue(name)) {
            System.out.println("Такой абонент не найден");
        }
    }

}
