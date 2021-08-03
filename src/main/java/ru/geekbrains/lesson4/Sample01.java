package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Sample01 {

    static final char DOT_HUMAN = 'X'; // Фишка - человек
    static final char DOT_AI = '0'; // Фишка - компьютер
    static final char DOT_EMPTY = '*'; // Признак пустого поля
    static final Scanner SCANNER = new Scanner(System.in); // Вспомогательный класс для ввода данных
    static Random RANDOM = new Random(); // Вспомогательный класс для генерации случайных чисел
    static char[][] field; // Двумерный массив, хранит текущее состояние игрового поля
    static int fieldSize; // Размерность игрового поля
    static int fieldSizeX; // Размерность игрового поля по оси X
    static int fieldSizeY; // Размерность игрового поля по оси Y
    static int movesToWin; // Количество фишек подряд для победы
    static int diagUpAndRight; // Количество фишек подряд по диагонали вверх и вправо
    static int diagDownAndRight; // Количество фишек подряд по диагонали вниз и вправо
    static int horRight; // Количество фишек подряд по горизонтали вправо
    static int verDown; // Количество фишек подряд по вертикали вниз

    /**
     * Проверка победы
     *
     * @param c - фишка игрока/компьютера
     * @return
     */
    static boolean checkWin(char c) {

        for (int i = 0; i < fieldSize; i++) {
            horRight = 0;
            verDown = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (field[j][i] == c) {
                    horRight++;
                } else if (field[j][i] != c && horRight < movesToWin) {
                    horRight = 0;
                }
                if (field[i][j] == c) {
                    verDown++;
                } else if (field[i][j] != c && verDown < movesToWin) {
                    verDown = 0;
                }
            }
            if (horRight >= movesToWin || verDown >= movesToWin) {
                return true;
            }
        }


        // Для определения победы проверяем количество фишек подряд по диагонали вверх и вправо
        for (int j = 0; j < fieldSize; j++) {
            diagUpAndRight = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = (fieldSize - 1) - j - i;
                if (k >= 0) {
                    if (field[i][k] == c) {
                        diagUpAndRight++;
                    } else if (field[i][k] != c && diagUpAndRight < movesToWin) {
                        diagUpAndRight = 0;
                    }
                }
                if (diagUpAndRight >= movesToWin) {
                    return true;
                }
            }
        }

        // Для определения победы проверяем количество фишек подряд по диагонали вниз и вправо
        for (int j = 0; j < fieldSize; j++) { // ок
            diagDownAndRight = 0;
            for (int i = 0; i < fieldSize; i++) {
                int k = j + i;
                if (k < fieldSize) {
                    if (field[i][k] == c) {
                        diagDownAndRight++;
                    } else if (field[i][k] != c && diagDownAndRight < movesToWin) {
                        diagDownAndRight = 0;
                    }
                }
                if (diagDownAndRight >= movesToWin) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        // Установим размерность игрового поля
        System.out.println("Введите размер игрового поля, например 5 (будет поле 5 на 5)\nи нажмите Enter >>>");
        fieldSize = SCANNER.nextInt();
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;

        System.out.println("Введите количество фишек подряд для победы (например 4) и нажмите Enter >>>");
        movesToWin = SCANNER.nextInt();
        // Инициализация массива, описывающего игровое поле
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    static void printField() {

        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i % 2 == 0) // четный
            {
                System.out.print("-");
            } else {
                System.out.print(i / 2 + 1);
            }
        }
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                //field[y][x] = DOT_EMPTY;
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты хода X и Y\nчерез пробел >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }


/**
 * Обработка хода компьютера
 */

        static void aiTurn() {
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (field[y][x] == DOT_EMPTY){
                        field[y][x] = DOT_AI;
                        // Сначала проверим, выиграет ли компьютер, при комбинации WIN? Если да, сразу же ставим фишку и компьютер побеждает
                        // Если компьютер не выигрывает, проверим, выиграет ли человек, при выигрышной комбинации
                        // Если да, заранее ставим фишку тем самым заранее прервем выигрышную комбинацию
                        if (checkWin(DOT_AI)) {
                            field[y][x] = DOT_AI;
                            return;
                        }
                        field[y][x] = DOT_HUMAN;
                        if (checkWin(DOT_HUMAN)){
                            field[y][x] = DOT_AI;
                            return;
                        }
                        field[y][x] = DOT_EMPTY;
                    }
                }
            }
         int x;
            int y;

            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (!isCellEmpty(y, x));
            field[y][x] = DOT_AI;
        }



    /**
     * Проверка корректности ввода
     * (координаты хода игрока не должны превышать размерность массива,
     * описывающего игровое поле)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {

        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;

    }


    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param c
     * @param s
     * @return
     */
    static boolean gameChecks(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn(); // Обработка хода игрока (человека)
                printField();
                if (gameChecks(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn(); // Обработка хода компьютера
                printField();
                if (gameChecks(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
