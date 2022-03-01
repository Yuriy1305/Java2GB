package HW2;
// Yuriy Lomtev, 19/02/2022
// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
//     При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать
//     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
//     или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией
//     в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
//    и MyArrayDataException и вывести результат расчета.

public class MainForExceptions {

    public static void main(String[] args) {
// правильный массив:
        String[][] myArray = new String[][]{{"    11", "12    ", "13", " 14"}, {"   21   ", " 22 ", "23 ", "24"}, {"31", "32", "33", "34"}, {"41", "42", "43", "44"}};
// неправильная размерность:
        String[][] myArrayWrongDimension = new String[][]{{"    11", "12    ", "13", " 14"}, {"   21   ", " 22 ", "23 ", "24"}, {"31", "32", "33", "34"}};
// неправильный формат:
        String[][] myArrayWrongFormat = new String[][]{{"    11", "12", "13", " 14"}, {"   21   ", " 22 ", "23 ", "24"}, {"31", "32", "33", "34"}, {"41", "@42", "43", "44"}};
// укажем размерность:
        int arrayDimensions = 4;
// 1й вариант, простой:
        System.out.println("1. Суммирование правильного массива: " + MyArray(myArray, arrayDimensions));
        System.out.println("2. Суммирование массива неправильной размерности: " + MyArray(myArrayWrongDimension, arrayDimensions));
        System.out.println("3. Суммирование массива с данными в неправильном формате: " + MyArray(myArrayWrongFormat, arrayDimensions));
// 2й вариант с отдельными классами проброса исключений:
        System.out.print("\t 1. Если данные в массиве корректные, то их сумма = ");
        try {
            System.out.println(MyArrayE(myArray, arrayDimensions));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\t 2. Проверяем неправильную размерность массива: должен иметь " + arrayDimensions + " на " + arrayDimensions +
                            ", а имеет ");
        try {
            System.out.println(MyArrayE(myArrayWrongDimension, arrayDimensions));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\t 3. Проверяем правильность формата данных в массиве: ");
        try {
            System.out.println(MyArrayE(myArrayWrongFormat, arrayDimensions));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }
// для 1го варианта:
    public static String MyArray(String[][] myArray, int arrayDimensions) {
        int sum = 0;

        for(int i = 0; i < myArray.length; ++i) {
// проверка и строк и стобцов, т.к. массив может быть непрямоугольным (пока находим первое несоответствие размеров):
            if (myArray.length != arrayDimensions || myArray[i].length != arrayDimensions) {
                return "массив должен иметь размерность " + arrayDimensions + " на " + arrayDimensions + ", а не " + myArray.length + " на " + myArray[i].length;
            }
            for(int j = 0; j < myArray[i].length; ++j) {
// проверка неформата числа:
                try {
                    sum += Integer.parseInt(myArray[i][j].trim());
                } catch (NumberFormatException e) {
                    return "нечисло в ячейке [" + i + "," + j + "] (" + e.getMessage().substring(e.getMessage().indexOf('"')) +
                            "). Сумма чисел в массиве до ошибки = " + sum;
                }
            }
        }
        return "сумма чисел в массиве = " + sum;
    }
// 2й вариант  с пробросоми:
    public static int MyArrayE(String[][] myArray, int arrayDimensions) throws MyArraySizeException, MyArrayDataException {
        if (myArray.length != arrayDimensions) {
            throw new MyArraySizeException(myArray.length, myArray[1].length);
        } else {
            int sum = 0;

            for(int i = 0; i < myArray.length; ++i) {
                if (myArray[i].length != arrayDimensions) {
                    throw new MyArraySizeException (myArray.length, myArray[1].length);
                }

                for(int j = 0; j < myArray[i].length; ++j) {
                    try {
                        sum += Integer.parseInt(myArray[i][j].trim());
                    } catch (NumberFormatException nfe) {
                        throw new MyArrayDataException(i, j, nfe);
                    }
                }
            }
            return sum;
        }
    }
}
