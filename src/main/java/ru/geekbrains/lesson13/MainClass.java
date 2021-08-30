package ru.geekbrains.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class MainClass {



        public static final int CARS_COUNT = 4;

        public static void main(String[] args) {
            int index = 0;
            SyncObj syncObj = new SyncObj();

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(syncObj, race, 20 + (int) (Math.random() * 10), ++index);
            }
            for (Car car : cars) {
                new Thread(car).start();
            }

        }


        public static class SyncObj{

            // Вспомогательный счетчик для учета подготовки автомобилей и победителей соревнования
            int counter = 0;

            synchronized void preparing(){

                try
                {
                    if (++counter == CARS_COUNT) {
                        notifyAll();
                        counter = 0; // Сбрасываем счетчик перед началом гонки
                        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                    }
                    else
                        wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

            }

            synchronized void checkFinish(String name){

                if (counter++ == 0){
                    System.out.println("У нас есть победитель:  " + name);
                } else {
                    System.out.println(name + " пришел " + counter + "м!");
                }
                if (counter == CARS_COUNT)
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

            }

        }

        /**
         * Автомобиль
         */
        public static class Car implements Runnable {

            private final Race race;
            private final int speed;
            private final String name;
            private final SyncObj syncObj;

            public String getName() {
                return name;
            }

            public int getSpeed() {
                return speed;
            }

            public Car(SyncObj syncObj, Race race, int speed, int index) {

                this.syncObj = syncObj;
                this.race = race;
                this.speed = speed;
                this.name = "Участник #" + index;

            }

            public void run() {

                try {
                    System.out.println(this.name + " готовится");
                    Thread.sleep(500 + (int)(Math.random() * 800));
                    System.out.println(this.name + " готов");
                    syncObj.preparing();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                }

                syncObj.checkFinish(name);
            }

        }

        /**
         * Заезд (гонка)
         */
        public static class Race {

            private final ArrayList<Stage> stages;
            public ArrayList<Stage> getStages() { return stages; }

            /**
             * Инициализация заезда
             * @param stages этапы (заезд состоит из дорог и туннелей)
             */
            public Race(Stage... stages) {
                this.stages = new ArrayList<>(Arrays.asList(stages));
            }

        }

        /**
         * Дорога
         */
        public static class Road extends Stage {

            public Road(int length) {
                this.length = length;
                this.description = "Дорога " + length + " метров";
            }

            public void go(Car c) {
                try {
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000L);
                    System.out.println(c.getName() + " закончил этап: " + description);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        /**
         * Туннель
         */
        public static class Tunnel extends Stage {

            final Semaphore semaphore = new Semaphore(CARS_COUNT / 2); // Пропускная способность туннеля

            public Tunnel() {
                this.length = 80;
                this.description = "Тоннель " + length + " метров";
            }

            public void go(Car c) {
                try {
                    try {
                        System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                        semaphore.acquire();
                        System.out.println(c.getName() + " начал этап: " + description);
                        Thread.sleep(length / c.getSpeed() * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(c.getName() + " закончил этап: " + description);
                        semaphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        /**
         * Этап
         */
        public abstract static class Stage {

            protected int length;
            protected String description;

            public abstract void go(Car c);

        }

    }
