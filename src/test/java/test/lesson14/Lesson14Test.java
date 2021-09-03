package test.lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson14.Lesson14;

public class Lesson14Test {
    int[] arr01 = {1, 2, 3, 4, 5, 6, 4, 8, 1, 4, 6, 8, 7};
    int[] arr02 = {4, 4, 4, 4, 1, 1, 1, 1, 4};
    int[] arr03 = {1, 1, 1, 2, 1, 2, 1, 2, 12, 2};
    int[] arr04 = {1, 1, 1, 1};
    int[] arr05 = {4, 4, 4, 4};

    int[] method01Result01 = {6, 8, 7};
    int[] method01Result02 = {};
    int[] method01Result03 = {1, 1, 1, 2, 1, 2, 1, 2, 12, 2};
    int[] method01Result04 = {1, 1, 1, 1};
    int[] method01Result05 = {};

    //region Тестируем method01
    @Test
    public void method01Test01() {
        Assertions.assertArrayEquals(method01Result01, Lesson14.method01(arr01));
    }

    @Test
    public void method01Test02() {
        Assertions.assertArrayEquals(method01Result02, Lesson14.method01(arr02));
    }

    @Test
    public void method01Test03() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Lesson14.method01(arr03);
        });

    }

    @Test
    public void method01Test04() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Lesson14.method01(arr04);
        });
    }

    @Test
    public void method01Test05() {
        Assertions.assertArrayEquals(method01Result05, Lesson14.method01(arr05));
    }

    //endregion
    //region Тестируем method02
    @Test
    public void method02Test01() {
        Assertions.assertFalse(Lesson14.method02(arr01));
    }

    @Test
    public void method02Test02() {
        Assertions.assertTrue(Lesson14.method02(arr02));
    }

    @Test
    public void method02Test03() {
        Assertions.assertFalse(Lesson14.method02(arr03));
    }

    @Test
    public void method02Test04() {
        Assertions.assertFalse(Lesson14.method02(arr04));
    }

    @Test
    public void method02Test05() {
        Assertions.assertFalse(Lesson14.method02(arr05));
    }

    //endregion


}
