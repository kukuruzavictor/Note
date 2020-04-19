package ua.cluster;

import ua.cluster.controller.NoteController;
import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";

        //переписав методи всіх пакетів для обробки масиву
        // test case – змінив на масив об'єктів класу Note
        Note[] note = new Note[20];
        note[0] = new Note("first test note", "01.02.1986", true, "home");
        note[1] = new Note("second test note", "06.12.1987", true, "work");
        note[2] = new Note("third test note", "13.12.1996", true, "work");
        note[3] = new Note("fourth test note", "17.04.2000", false, "music");
        note[4] = new Note("fifth test note", "30.07.2019", false, "work");
        note[5] = new Note("sixth test note", "14.01.2019", true, "idea");
        note[6] = new Note("seventh test note", "14.04.2020", false, "work");

        System.out.println("Hello, let`s use notes!");
        while (true) {
            System.out.print("INPUT COMMAND: ");
            command = input.nextLine();
            command = command.toLowerCase().trim();

            switch (command) {
                case "exit":
                    System.out.println("Buy Buy!");
                    System.exit(0);
                default:
                    NoteController inputStr = new NoteController();
                    if (inputStr.isExistingCommand(command)){
                        inputStr.runCommand(command, note);
                    } else {
                        System.out.println("AVAILABLE COMMANDS:");
                        inputStr.commandList();}
            }
        }
    }
}
