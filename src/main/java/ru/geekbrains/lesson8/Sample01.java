package ru.geekbrains.lesson8;

import javax.annotation.processing.FilerException;
import java.io.*;


public class Sample01 {

    public static void main(String[] args) {

        //region Задание 1
        // Создаем 2 переменных типа String

        String txt01 = "Text 1\n\nMr. and Mrs. Dursley, of number four, Privet Drive,\nwere proud to say that they were perfectly normal, thank you very much.\nThey were the last people you’d expect to be involved in anything strange or mysterious,\nbecause they just didn’t hold with such nonsense.\n";

        String txt02 = "\nText 2\n\nDumbledore took Harry in his arms and turned toward the Dursleys’ house.\n";


        // Создаем новый экземпляр класса файл. В качестве параметра указываем путь
        File file01 = new File("C:\\les8");

        //Осуществляем проверку, существует ли такая директория или нет
        if (!file01.exists()) {
            System.out.println("Директория " + file01 + " не существует");

            // Создаем директорию, если она не существует
            if (file01.mkdirs()) {
                System.out.println("Директория " + file01 + " успешно создана");

            } else {
                System.out.println("Не удалось создать директорию");
            }
        } else {
            System.out.println("Директория " + file01 + " существует");
        }

        // Создаем новый класс, который позволяет записать текст в файл и обрабатываем исключения.
        // Записываем текст из переменной в файл № 1.
        try {
            FileWriter writer01 = new FileWriter("C:\\les8\\1.txt"); // Указываем путь и имя файла. Если такого файла нет, то он создается.
            writer01.write(txt01);// Указываем переменную из которой берём текст для записи в файл.
            writer01.close(); // Запись в файл, происходит после закрытия потока вывода.
            System.out.println("Данные успешно записаны в файл " + "C:\\les8\\1.txt");
        }
        // Обрабатываем исключения
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Создаем новый класс, который позволяет записать текст в файл и обрабатываем исключения.
        // Записываем текст из переменной в файл № 2.
        try {
            FileWriter writer02 = new FileWriter("C:\\les8\\2.txt");
            writer02.write(txt02);
            writer02.close();
            System.out.println("Данные успешно записаны в файл " + "C:\\les8\\2.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //endregion

        adderTextFromFiles("C:\\les8\\1.txt", "C:\\les8\\2.txt", "C:\\les8\\3.txt");

        searchWord("C:\\les8\\2.txt", "Harry");

        searchWordInDirectory("C:\\les8", "Dumbledore");

    }

    //region Задание 2

    /**
     * Метод, который склеивает текст 2-х разных файлов и записывает результат в 3-й файл
     * (Если нет 3-го файла, то он его создает)
     *
     * @param filePath01 - путь к файлу 1 (например "C:\\les8\\1.txt")
     * @param filePath02 - путь к файлу 2 (например "C:\\les8\\2.txt")
     * @param filePath03 - путь к файлу 3 (например "C:\\les8\\3.txt")
     */
    public static void adderTextFromFiles(String filePath01, String filePath02, String filePath03) {
        StringBuilder st01 = new StringBuilder();
        StringBuilder st02 = new StringBuilder();
        try {
            int i = -1;
            int k = -1;
            // Объявляем 2 массива на 10 символов
            char[] buf01 = new char[10];
            char[] buf02 = new char[10];
            // Создаем классы, которые позволяют считать текст из указанного файла
            FileReader reader01 = new FileReader(filePath01);
            FileReader reader02 = new FileReader(filePath02);

            while ((i = reader01.read(buf01)) != -1) {
                st01.append(new String(buf01, 0, i)); // добавляем в построитель строки по 10(считанных) символов
            }
            reader01.close();

            while ((k = reader02.read(buf02)) != -1) {
                st02.append(new String(buf02, 0, k));
            }
            reader02.close();

            // Создаем класс, который позволяет записать текст в указанный файл
            FileWriter writer = new FileWriter(filePath03, true);
            writer.write(st01.toString()); // Записываем текст, считанный из файла № 1 в файл № 3
            writer.flush();

            writer.write(st02.toString()); // Добавляем текст, считанный из файла № 2 в файл № 3
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Текст из файлов %s и %s считан и склеен, а результат записан в файл %s\n", filePath01, filePath02, filePath03);


    }
    //endregion

    //region Задание 3

    /**
     * Данный метод находит в указанном файле необходимое слово
     *
     * @param pathToFile - путь к файлу (например "C:\\les8\\2.txt")
     * @param word       - искомое слово
     */
    public static void searchWord(String pathToFile, String word) {
        try {
            int i = -1;
            String st;

            // Объявляем массив символов
            char[] buf = new char[2000];

            // Создаем класс, который позволяет считать текст из указанного файла
            FileReader reader = new FileReader(pathToFile);

            while ((i = reader.read(buf)) != -1) {
                st = (new String(buf, 0, i)); // сохраняем в переменную типа String текст из файла

                // С помощью метода contains проверяем наличие искомого слова
                if (st.contains(word)) {
                    System.out.println("Файл " + pathToFile + " содержит слово " + word);
                } else {
                    System.out.println("Файл " + pathToFile + " не содержит слово " + word);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //endregion

    //region Задание 4

    /**
     * Данный метод позволяет найти искомое слово в текстовых файлах в указанной директории
     *
     * @param pathToDirectory - путь к директории (например "C:\les8")
     * @param word            - искомое слово в файлах
     */
    public static void searchWordInDirectory(String pathToDirectory, String word) {

        File dir = new File(pathToDirectory);
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {

                try {
                    int i = -1;
                    String st;

                    // Объявляем массив символов
                    char[] buf = new char[2000];

                    // Создаем класс, который позволяет считать текст из указанного файла
                    FileReader reader = new FileReader(file);

                    while ((i = reader.read(buf)) != -1) {
                        st = (new String(buf, 0, i)); // сохраняем в переменную типа String текст из файла
                        // С помощью метода contains проверяем наличие искомого слова
                        if (st.contains(word)) {
                            System.out.println("Файл " + file + " содержит слово " + word);
                        } else {
                            System.out.println("Файл " + file + " не содержит слово " + word);
                        }
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        }


    }

    //endregion
}
