package HW3;
//   25/02/2022, Yuriy Lomtev
//   2. Задача:
//Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

abstract class Fruit {
// можно здесь сделать константой вес:
    public float weight;
// коструктор, одно поле/свойство:
    Fruit (float weight) {
        this.weight= weight;

    }
}
