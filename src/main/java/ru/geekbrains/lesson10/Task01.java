package ru.geekbrains.lesson10;


import java.util.*;

public class Task01 {
    public static void main(String[] args) {

        //region Задание 1

        //Инициализируем массив строк(есть повторяющиеся слова)
        String[] arrFruits = {"apple", "lemon", "orange", "pineapple", "orange", "apple", "pineapple", "orange", "kiwi", "banana"};

        ArrayList<String> listFruits = new ArrayList<>(); // Инициализируем новую коллекцию listFruits
        //Добавляем все элементы массива fruits в коллекцию fruitsList
        listFruits.addAll(Arrays.asList(arrFruits));
        System.out.println("Коллекция фруктов" + " - " + listFruits);
        System.out.println();

        // С помощью коллекции setFruits оставляем значения без повторений из коллекции listFrits
        Set<String> setFruits = new LinkedHashSet<>(listFruits);
        System.out.println("Коллекция уникальных фруктов (без повторений)" + " - " + setFruits);
        System.out.println();

        // 1-й вариант
        // Создаем коллекцию Map. С помощью цикла foreach проходим по всем элементам коллекции setFruits
        // С помощью метода frequency определяем количество повторений элементов из коллекции listFruits
        Map<String, Integer> numberOfFruitsRepetitions = new LinkedHashMap<>();
        for (String setFruit : setFruits) {
            // Добавляем в коллекцию Map (ключ - уникальный фрукт, значение - количество повторений в коллекции listFruits)
            numberOfFruitsRepetitions.put(setFruit, Collections.frequency(listFruits, setFruit));
        }
        System.out.println("Количество повторений каждого фрукта - " + numberOfFruitsRepetitions);
        System.out.println();

        // 2-й вариант
        // С помощью цикла foreach проходим по всем элементам коллекции listFruits
       /* for (String listFruit : listFruits) {
            int count = 1;// начальное количество определенного фрукта

            // Проверяем содержится ли ключ в коллекции numberOfFruitsRepetitions
            if (numberOfFruitsRepetitions.containsKey(listFruit)){
            // Если такой ключ уже есть, то увеличиваем значение ключа на 1
                numberOfFruitsRepetitions.put(listFruit, (numberOfFruitsRepetitions.get(listFruit) + 1));
            }
            else {
            // Если такого ключа в коллекции еще нет, то просто добавляем ключ(фрукт) и начальное значение count = 1
                numberOfFruitsRepetitions.put(listFruit,count);
            }
        }
        System.out.println("Количество повторений каждого фрукта - " + numberOfFruitsRepetitions);
        System.out.println();*/

        //endregion
    }
}
