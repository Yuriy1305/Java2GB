package HW3;

import java.lang.reflect.Array;
import java.util.Arrays;

//   25/02/2022, Yuriy Lomtev
//   1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//
//   2. Задача:
//        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можно использовать ArrayList<T>
//    Сделать метод getWeight(), ко торый высчитывает вес коробки, зная вес одного фрукта и их количество:
//        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//        которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//        Можно сравнивать коробки с яблоками и апельсинами;
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
//        в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//        Не забываем про метод добавления фрукта в коробку.

public class MainChange2 {
    public static void main(String[] args) {
// п.1. ДЗ
        int[] myArray1 = {6, 9, 66, 99};
        System.out.println("Массив до:\t\t"+Arrays.toString(myArray1));

        myChange2Array(myArray1, 1, 3);
        System.out.println("Массив после:\t"+Arrays.toString(myArray1));
// вместо примитива int ссылочный:
        String [] myArray2 = {"6", "9", "66  ", "   99"};
        System.out.println("Ссылка до:\t\t"+Arrays.toString(myArray2));

        myChange2Link(myArray2, 3,1);
        System.out.println("Ссылка после:\t"+Arrays.toString(myArray2));
    }

// п.1. ДЗ вариант примитивного целочисленного массива:
    public static void myChange2Array(int[] myArraу, int first, int second) {
// проверка на границы индексов: >=0, <=myArray.length:
        if ( (first >= 0) && (second >= 0) &&  (first <= myArraу.length-1) && (second <= myArraу.length-1)) {
            int forChange = myArraу[first];
            myArraу[first] = myArraу[second];
            myArraу[second] = forChange;
        }
        else System.out.println("Некорректные индексы в массиве!");
    }
// п.1. ДЗ вариант обобщенного ссылочного массива:
    public static <T> void myChange2Link(T [] myArraу, int first, int second) {
        if ( (first >= 0) && (second >= 0) &&  (first <= myArraу.length-1) && (second <= myArraу.length-1)) {
            T forChange = myArraу[first];
            myArraу[first] = myArraу[second];
            myArraу[second] = forChange;
        }
        else System.out.println("Некорректные индексы в массиве!");
    }
}

