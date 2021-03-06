package HW3;

//   25/02/2022, Yuriy Lomtev
// 2.1       Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
// 2.1.1        Для хранения фруктов внутри коробки можно использовать ArrayList<T>
// 2.2   Сделать метод getWeight(), ко торый высчитывает вес коробки, зная вес одного фрукта и их количество:
//        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
// 2.3       Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//        которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//        Можно сравнивать коробки с яблоками и апельсинами;
// 2.4   Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//
//        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно,
//        в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

// 2.5 Не забываем про метод добавления фрукта в коробку.

import java.util.ArrayList;

// п.2.1 ДЗ
public class Box <T extends Fruit> {

// п.2.1.1 ДЗ, но помним, что фрукты разные:
    private ArrayList <T> fruits;
    public Box(ArrayList <T> fruits) {
       this.fruits=fruits;
    }
// п.2.2 ДЗ
    float getWeight () {
        float  nettoWeight = 0;
        for (T fruits : fruits) {
            nettoWeight += fruits.weight;
        }
        return nettoWeight;
    }
// п.2.3 ДЗ, т.к. и яблоки и апельсины, то метасимвол ? вместо Т:
    public boolean compare (Box <?> another) {
        return (getWeight() == another.getWeight());
    }
// п.2.4 ДЗ
    public void box1ToBox2 (Box <T> another) {
// пересыпаем все из одной в другую (пустую):
        another.fruits.addAll (fruits);
// очищаем коробку:
        fruits.clear();
    }
// п.2.5 ДЗ - не использовал
        public void addFruits (T fruit) {
       fruits.add(fruit);
    }

}
