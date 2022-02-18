package HW1;
//   Yuriy Lomtev, 16/02/2022
//        2. Добавить класс Team, который будет содержать:
//        +название команды;
//        +массив из четырех участников — в конструкторе можно сразу всех участников указывать);
//        метод для вывода информации о членах команды, прошедших дистанцию;
//        +метод вывода информации обо всех членах команды.

public class Team {
    final String nameTeam = "Помощники";
    final String[] membersTeam = new String[]{"Внучка", "Жучка", "Кошка", "Мышка"};

    public void start() {
        String players = " - ";
        for (int i = 0; i < membersTeam.length; i++) {
            if (i == membersTeam.length - 2) {
                players += membersTeam[i] + " и " + membersTeam[i + 1];
                break;
            } else {
                players += membersTeam[i] + ", ";
            }
        }
        System.out.println("Игроки команды " + nameTeam + players + " побежали за главным призом - репкой!"+"\n"+"Самая быстрая Жучка, затем Кошка, потом Внучка, Мышка медленне всех.");
        System.out.println("Но по пути им могут встретиться припятствия, например, что-то поинтереснее репки...");
    }
    public void showResults(String s) {
        System.out.println(s);
    }
}

