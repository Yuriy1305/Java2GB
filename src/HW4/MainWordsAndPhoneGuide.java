package HW4;
// 01/03/2022, Yuriy Lomtev
//  1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
// из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
//  2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
//  В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
//  номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//  (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//        Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//        взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов
//        проверки телефонного справочника.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainWordsAndPhoneGuide {
    public static void main(String[] args) {
        String[] listFamilies = {
                "Путин",
                "Иванов",
                "Петров",
                "Сидоров",
                "Иванов",
                "Зеленский",
                "Путин",
                "Байден",
                "Петров",
                "Иванов"};
        System.out.println("П.1 ДЗ - Вывод только уникальных фамилий: ");
        counterFamilies(listFamilies);

        System.out.println("\nП.2 ДЗ - Вывод телефоннных номеров человека по фамилии: ");
// функцию/метод add() добавлеия данных в hm из одной строки посчитал не очень нужной,
// лично для меня, усложняющей код, т.е. учел примечание к ДЗ:
        HashMap<String, String> hmNumberFamily = new HashMap<>();
// опять маленькая БЗ для телефонного справичника с ключом НомерТелефона из-за однофамильцев:
        hmNumberFamily.put("000-00-00", listFamilies[0]);
        hmNumberFamily.put("111-11-11", listFamilies[1]);
        hmNumberFamily.put("222-22-22", listFamilies[2]);
        hmNumberFamily.put("333-33-33", listFamilies[3]);
        hmNumberFamily.put("444-44-44", listFamilies[4]);
        hmNumberFamily.put("555-55-55", listFamilies[5]);
        hmNumberFamily.put("666-66-66", listFamilies[6]);
        hmNumberFamily.put("777-77-77", listFamilies[7]);
        hmNumberFamily.put("888-88-88", listFamilies[8]);
        hmNumberFamily.put("999-99-99", listFamilies[9]);
// для демонстрации метода get() сбора фамилий к Номеру (повторы здесь игнорируем, т.к. смотрим всех,
// в т.ч. и однофамильцев:
        for (String familySearch : listFamilies) { getNumberOfFamilies (hmNumberFamily, familySearch);}
    }

     public static void getNumberOfFamilies ( HashMap<String, String> hmNumberFamily, String family) {
         ArrayList<String> numbers = new ArrayList<>();
// по аналогии цап-царапа ниже:
         for (Map.Entry<String, String> o : hmNumberFamily.entrySet()) {
             if (Objects.equals(o.getValue(), family)) {
                 numbers.add(o.getKey());
             }
         }
         System.out.println("У человека с фамилией " + family + " есть телефоны с номерами: " + numbers);
    }

     public static void counterFamilies (String[] listFamilies) {
// создаем доп. маленькую БД в виде HashMap (фамилия, повторов):
        HashMap<String, Integer> hmFamilyRepeat = new HashMap<>();
        for (String familyForSearch : listFamilies) {
            // ищем фамилию в hm:
            if (hmFamilyRepeat.containsKey(familyForSearch)) {
                // есть - увеличиваем счетчик:
                hmFamilyRepeat.put(familyForSearch, hmFamilyRepeat.get(familyForSearch) + 1);
            }
// если еще нет фамилии в hm, то счетчик повторов=1:
            else hmFamilyRepeat.put(familyForSearch, 1);
        }
// выводим найденные уникальные (сдул с методички):
        for (Map.Entry<String, Integer> o : hmFamilyRepeat.entrySet()) {
            if (o.getValue() == 1) { System.out.println(o.getKey()); }
        }
// выводим все с числом повторов:
        System.out.println("\nВсего имеется " + listFamilies.length + " фамилия/и/й:");
        for (Map.Entry<String, Integer> o : hmFamilyRepeat.entrySet()) {
            System.out.println("Фамилия " + o.getKey() + " встречается " + o.getValue() + " раз/а");
        }
    }
//    public static void add (HashMap <String, String>) {
}