package ru.geekbrains.lesson3;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Sample01 {

    static Scanner scanner = new Scanner(System.in);

    //region Игра 1
    static void game01() {


        int userNumber;//переменная, в которую будем сохранять значение ввода пользователя
        int computerNumber = (int)(Math.random()*10);// переменная для храниения случайного числа, которое сгенерировал(загадал) компьютер

        System.out.print("Компьютер загадал число от 0 до 9!\n");
        System.out.print("Вам дается 3-и попытки для того, чтобы его отгадать!\n\n");

        System.out.print("Поехали!!!\n\n");
        System.out.print("Ниже ведите целое число от 0 до 9\n");

        int countTry = 1;// переменная-счетчик попыток (№ попытки)
        int a = 0;


        while (a < 3){

        if (scanner.hasNextInt()) {
          userNumber = scanner.nextInt();

                if (userNumber == computerNumber) {
                    System.out.printf("Ваше число - %d\n",userNumber);
                    System.out.print("Поздравляем!!! Вы угадали число!\n");
                    System.out.print("Игра окончена!\n\n");
                    System.out.print("Чтобы продолжить нажмите Enter: ");
                    break;

                }


                else {
                    System.out.printf("Попытка № %d\n",countTry);
                    System.out.println("Неверное число!");
                    countTry++;
                    a++;

                }

            }
        else {

            System.out.println("Некорректные данные.Можно вводить только целые числа.\nНачните заного игру");
            break;

        }

                if(countTry - 1 == 3){
                System.out.println("Попыток больше нет.Вы проиграли :(\n");
                System.out.print("Чтобы продолжить нажмите Enter: ");
                break;

            }

        }
        scanner.nextLine();
       }
    //endregion

    //region Игра 2
    static void game02() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String computerWord = words[(int)Math.floor(Math.random()*words.length)];// Сохраняем в переменную слово, загаданное компьютером.

        System.out.println("Нужно угадать слово из списка ниже");
        System.out.println(Arrays.toString(words));
        System.out.println();


        String myWord;// переменная, которая хранит введенное пользователем слово

        StringBuilder lettersInWord;
        do {
            System.out.print("Введите ваше слово: ");

            myWord = scanner.nextLine();

            if (Objects.equals(myWord, computerWord)) {
                System.out.println("Поздравляем!!!\nВы угадали!!!");
                System.out.print("Для продолжения нажмите Enter");

            } else {
                lettersInWord = new StringBuilder("###############");
                int shortestWordLenght = Math.min(computerWord.length(), myWord.length()); //Определяем длинну кратчайшего слова

                for (int i=0;i<shortestWordLenght;i++){
                    if (myWord.charAt(i) == computerWord.charAt(i)) {
                        lettersInWord.setCharAt(i,myWord.charAt(i));
                    }
                }
                System.out.println("Вы угадали буквы слова");
                System.out.println(lettersInWord);
                System.out.println("Попробуйте еще!");
            }
        } while (!Objects.equals(myWord, computerWord));

    }

    //endregion

    public static void main(String[] args) {
        boolean fExit = false;


        while (!fExit){
            System.out.println();
            System.out.print("Выберите № игры\n");
            System.out.print("Игра № 1 \"(Угадай число)\" - введите 1\n");
            System.out.print("Игра № 2  - введите 2\n");
            System.out.print("Выход - введите 0\n\n");
            System.out.print("Ваш выбор: ");

            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();

                switch (n) {

                    case 0:
                        System.out.print("Выход из программы\n\n");
                        fExit = true;
                        break;

                    case 1:
                        game01();
                        break;

                    case 2:
                        game02();
                        break;
                    default:
                        System.out.print("Неверный номер\n\n");

                }
            }
            else {
                System.out.print("Введены некорректные данные\n\n");
            }
            scanner.nextLine();

        }
        scanner.close();
    }

}