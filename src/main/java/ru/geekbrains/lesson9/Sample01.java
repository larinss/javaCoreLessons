package ru.geekbrains.lesson9;


public class Sample01 {

    // Создаем свой класс исключения, который является расширением класса Exception
    static class MyArraySizeException extends Exception {
        //Создаем конструктор класса
        public MyArraySizeException() {
            super("Размер массива должен быть 4х4\n"); //переопределяем поле message
        }
    }

    // Создаем свой класс исключения, который является расширением класса Exception
    static class MyArrayDataException extends Exception {
        //Инициализируем переменные row и col, которые будут необходимы для соответствия индексу двумерного массива
        private int row;
        private int col;

        // Создаем геттеры полей с модификатором видимости private
        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        //Создаем конструктор класса
        public MyArrayDataException(String message, int row, int col) {
            super(message);
            this.row = row;
            this.col = col;
        }
    }

    //Создаем метод, который суммирует все элементы двумерного массива
    public static int changeArray(String[][] myArr) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        for (int i = 0; i < myArr.length; i++) {
            if (myArr.length != 4 || myArr[i].length != 4)
                throw new MyArraySizeException(); // При данном условии возбуждается исключение MyArraySizeException
            for (int j = 0; j < myArr[i].length; j++) {
                //Обрабатываем с помощью конструкции try catch исключение NumberFormatException
                try {
                    sum += Integer.parseInt(myArr[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не удалось преобразовать данные по индексу", i, j);//возбуждаем собственное исключение MyArrayDataException
                }
            }

        }
        return sum;

    }

    public static void main(String[] args) {

        // Инициализируем 4 массива для проверки работы наших исключений

        String[][] correctArray = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "8"}
        };
        String[][] wrongSizeArray = {
                {"1", "2", "0", "3"},
                {"6", "4", "1", "5"},
                {"9", "2", "7", "4"},
                {"0", "2"}
        };
        String[][] wrongCharArray = {
                {"1", "9", "2", "3"},
                {"6", "1", "5", "7"},
                {"2", "a", "7", "6"},
                {"1", "9", "4", "5"}
        };
        String[][] wrongSizeAndCharArray = {
                {"1", "9", "2", "3"},
                {"6", "1", "5", "7"},
                {"1", "9",},
                {"2", "f", "7", "6"}

        };

        try {
            System.out.println("1. Используем корректный массив, который не будет возбуждать исключения");
            System.out.println(changeArray(correctArray));
        } catch (MyArraySizeException e) {
            System.out.print(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("Не удалось преобразовать данные из массива по индексу [%d][%s]", e.getRow(), e.getCol());
            System.out.println();
        }

        System.out.println();
        try {
            System.out.println("2. Используем массив, который имеет неподходящий размер");
            System.out.println(changeArray(wrongSizeArray));
        } catch (MyArraySizeException e) {
            System.out.print(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("Не удалось преобразовать данные из массива по индексу [%d][%s]", e.getRow(), e.getCol());
            System.out.println();
        }
        System.out.println();
        try {
            System.out.println("3. Используем массив, который имеет неподходящий элемент");
            System.out.println(changeArray(wrongCharArray));
        } catch (MyArraySizeException e) {
            System.out.print(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("Не удалось преобразовать данные из массива по индексу [%d][%s]", e.getRow(), e.getCol());
            System.out.println();
        }
        System.out.println();
        try {
            System.out.println("4. Используем массив, который имеет неподходящий размер и элемент");
            System.out.println(changeArray(wrongSizeAndCharArray));
        } catch (MyArraySizeException e) {
            System.out.print(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("Не удалось преобразовать данные из массива по индексу [%d][%s]", e.getRow(), e.getCol());
            System.out.println();
        }

    }

}
