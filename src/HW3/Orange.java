package HW3;
//   25/02/2022, Yuriy Lomtev
//   2. Задача:
//Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

public class Orange extends Fruit {
// определяем вес - одно свойство константа:
    final float orangeWeight = 1.5F;
    Orange() {
        super(orangeWeight);
    }
}
