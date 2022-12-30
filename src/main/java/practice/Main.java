package practice;

import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        boolean isTrue = true;
        System.out.print("Введите команду: ");
        Scanner scan = new Scanner(System.in);
        while (isTrue) {
            String typeCommand = scan.nextLine();
            if (typeCommand.equals("exit")) {
                isTrue = false;
            }
            if (typeCommand.contains("ADD")) {
                String tpCom = typeCommand.replace("ADD ", "");
                todoList.add(tpCom);
                System.out.println("Добавлено дело " + '"' + tpCom + '"');
            }
            if (typeCommand.contains("LIST")) {
                for (int i = 0; i < todoList.getTodos().size(); i++) {
                    System.out.println(i + " - " + todoList.getTodos().get(i));
                }
            }
            if (typeCommand.contains("EDIT")) {
                String tpCom = typeCommand.replaceAll( "[0-9,EDIT]", "").strip();
                String[] tpInd = typeCommand.split(" ");
                System.out.println("Дело " + '"' + todoList.getTodos().get(Integer.parseInt(tpInd[1])) +
                        '"' + " заменено на " + '"' + tpCom + '"');
                todoList.edit(Integer.parseInt(tpInd[1]), tpCom);
            }
            if (typeCommand.contains("DELETE")) {
                String[] tpInd = typeCommand.split(" ");
                if (Integer.parseInt(tpInd[1]) > todoList.getTodos().size()) {
                    System.out.println("Дело с таким номером не существует");
                } else {
                    System.out.println("Дело " + '"' + todoList.getTodos().get(Integer.parseInt(tpInd[1])) + '"' + " удалено");
                    todoList.delete(Integer.parseInt(tpInd[1]));
                }
            }
        }
    }
}