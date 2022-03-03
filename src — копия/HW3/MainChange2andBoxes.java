package HW3;

//   25/02/2022, Yuriy Lomtev
//   1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//
//   2. Задача:
//        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можно использовать ArrayList<T>
//    Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//        которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//        Можно сравнивать коробки с яблоками и апельсинами;
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
//        в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//        Не забываем про метод добавления фрукта в коробку.

import java.util.ArrayList;
import java.util.Arrays;

public class MainChange2andBoxes {
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

// пп.2 ДЗ:
// создаем нужное число фруктов и ящики:
        int countApplesBox = 45;
        int countOrangeBox = 30;
        Box<Apple> appleBox1 = new Box<>(newApple(countApplesBox));
        Box<Orange> orangeBox1 = new Box<>(newOrange(countOrangeBox));
        Box<Orange> orangeBox2 = new Box<>(newOrange(0));

        if (appleBox1.compare(orangeBox1)) {
            System.out.println("Эти ящики весят одинаково");
        } else System.out.println("Эти ящики весят по-разному");
        if (orangeBox1.compare(orangeBox2)) {
            System.out.println("Эти ящики весят одинаково");
        } else System.out.println("Эти ящики весят по-разному");

        orangeBox1.box1ToBox2(orangeBox2);

        if (appleBox1.compare(orangeBox1)) {
            System.out.println("Эти ящики весят одинаково");
        } else System.out.println("Эти ящики весят по-разному");
        if (orangeBox2.compare(appleBox1)) {
            System.out.println("Эти ящики весят одинаково");
        } else System.out.println("Эти ящики весят по-разному");
    }

// создадим нужное число фруктов яблок и апельсинов:
    public static ArrayList <Apple> newApple (int count) {
        ArrayList<Apple> fruits = new ArrayList<>();
        for (int i=0; i<count; i++) {
            fruits.add(new Apple(1.0F));
        }
        return fruits;
    }
    public static ArrayList <Orange> newOrange (int count) {
        ArrayList<Orange> fruits = new ArrayList<>();
        for (int i=0; i<count; i++) {
            fruits.add(new Orange(1.5F));
        }
        return fruits;
    }
// п.1. ДЗ вариант примитивного целочисленного массива:
    public static void myChange2Array(int[] myArraу, int first, int second) {
// проверка на границы индексов: >=0, <myArray.length:
        if ( (first >= 0) && (second >= 0) &&  (first < myArraу.length) && (second < myArraу.length)
             && myArraу.length > 1) {
            int forChange = myArraу[first];
            myArraу[first] = myArraу[second];
            myArraу[second] = forChange;
        }
        else System.out.println("Некорректные индексы или длина массива!");
    }
// п.1. ДЗ вариант обобщенного ссылочного массива:
    public static <T> void myChange2Link(T [] myArraу, int first, int second) {
        if ( (first >= 0) && (second >= 0) &&  (first < myArraу.length) && (second < myArraу.length)
             && myArraу.length > 1) {
            T forChange = myArraу[first];
            myArraу[first] = myArraу[second];
            myArraу[second] = forChange;
        }
        else System.out.println("Некорректные индексы или длина массива!");
    }
}

