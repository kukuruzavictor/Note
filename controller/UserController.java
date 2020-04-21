package ua.cluster.controller;

import ua.cluster.model.User;
import ua.cluster.view.UserView;

public class UserController {

    private String[] commands = {"userlist", "edit user data", "create new user", "back", "exit"};

    public void commandList(){
        UserView commandList = new UserView();
        commandList.printCommands(commands);
    }

    public boolean isExistingCommand (String command){
        for (String s : commands) {
            if (command.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void runCommand(String command, User[] userlist){
        switch (command){
            case "userlist":
                listUsers(userlist);
                break;
            case "edit user data":
                System.out.println("NOT AVAILABLE YET");
                break;
            case "create new user":
                System.out.println("NOT AVAILABLE YET");
                break;
            case "back":
                System.out.println("NOT AVAILABLE YET");
                break;
            case "exit":
                System.out.println("Buy Buy!");
                System.exit(0);
                break;
        }
    }

    public boolean logIn (User[] userlist){
        UserView login = new UserView();
        String email = login.enterEmail();
        for (int i=0; i<userCounter(userlist); i++) {
            if (userlist[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void listUsers(User[] userlist){
        UserView list = new UserView();
        list.printUserList(userlist);
    }

    // метод-костиль, використовується для підрахунтку кількості юзерів в масиві (базі)
    // вживається замість метода .length, щоб не мати справ з порожніми місцями в масиві
    public int userCounter (User[] userlist){
        int counter = 0;
        for (User user : userlist){
            if (user != null){
                counter+=1;
            }
        }
        return counter;
    }

}
