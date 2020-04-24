package ua.cluster;

import ua.cluster.controller.NoteController;
import ua.cluster.controller.UserController;
import ua.cluster.model.Note;
import ua.cluster.model.User;
import ua.cluster.view.MainView;

public class Main {

    public static void main(String[] args) {
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

        User[] userlist = new User[5];
        userlist[0] = new User("admin", "admin@gmail.com");
        userlist[1] = new User("Viktor Kukuruza", "kukuruzavictor@gmail.com");

        MainView menu = new MainView();
        NoteController input = new NoteController();


        System.out.println("Hello, let`s use NOTES!");

        UserController login = new UserController();
        while(true) {
            if (login.logIn(userlist))
            break;
        }

        System.out.println("AVAILABLE COMMANDS:");
        input.commandList();
        while (true) {
            String command = menu.inputCommand();

            switch (command) {
                case "exit":
                    System.out.println("Buy Buy!");
                    System.exit(0);
                case "user menu":
                    System.out.println("USER MENU | AVAILABLE COMMANDS:");
                    boolean usermenu = true;
                    login.commandList();
                    while (usermenu){
                        command = menu.inputCommand();
                        if ("back".equals(command)) {
                            usermenu = false;
                        } else {
                            if (login.isExistingCommand(command)) {
                                login.runCommand(command, userlist);
                            } else {
                                System.out.println("USER MENU | AVAILABLE COMMANDS:");
                                login.commandList();
                            }
                        }
                    }


                default:
                    if (input.isExistingCommand(command)){
                        input.runCommand(command, note);
                    } else {
                        System.out.println("AVAILABLE COMMANDS:");
                        input.commandList();
                    }
            }
        }
    }
}
