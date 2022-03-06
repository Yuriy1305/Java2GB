package HW3;
//   25/02/2022, Yuriy Lomtev
//   2. Задача:
//Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

public class Apple extends Fruit {
// определяем вес - одно свойство константа:
      final float appleWeight = 1.0F;
      Apple() {
        super(appleWeight);
      }
}
