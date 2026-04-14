package pro.sorokovsky.level3;

import pro.sorokovsky.common.validation.NotPositiveNumberException;
import pro.sorokovsky.common.validation.ValidationException;

import java.util.Arrays;
import java.util.random.RandomGenerator;

/**
 * Клас, який дозволяє працювати з одновимірними масивами.
 *
 * @author Сороковський Андрій
 * @version 1.0
 */
public class OneArray {
    private final int[] array;
    private final int count;

    /**
     * Створює новий одновимірний масив
     * @param count кількість елементів, має бути понад 0.
     * @throws ValidationException якщо від'ємний розмір.
     */
    public OneArray(int count) throws ValidationException {
        if (count < 0) throw new NotPositiveNumberException("розмір масиву");
        array = new int[count];
        this.count = count;
    }

    /**
     * Генерує масив.
     */
    public void generate() {
        var min = 1;
        var max = 999;
        final var generator = RandomGenerator.getDefault();
        for (int i = 0; i < count; i++) {
            array[i] = generator.nextInt((max - min) + 1) + min;
        }
    }

    /**
     * Виводить масив на екран
     *
     * @param title заголовок для масиву.
     */
    public void show(String title) {
        System.out.printf("Масив '%s': ", title);
        for (int i = 0; i < count; i++) {
            System.out.printf("%3d ", array[i]);
        }
        System.out.println();
    }

    /**
     * Сортує масив.
     */
    public void sort() {
        Arrays.sort(array);
    }

    /**
     * Перетворює двовимірний масив у рядкове представлення.
     *
     * @return Рядкове представлення
     */
    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
                builder.append("%3d ".formatted(array[i]));
        }
        return builder.toString();
    }
}