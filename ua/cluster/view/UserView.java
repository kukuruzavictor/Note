package ua.cluster.view;

import ua.cluster.model.User;

import java.util.Scanner;

public class UserView {

    public void printCommands(String[] array){
        for (String s : array) {
            System.out.println("[ "+s.toUpperCase()+" ]");
        }
    }

    public String enterEmail (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please LOG IN (default: admin@gmail.com): ");
        return sc.nextLine().trim();
    }

    public void printUserList(User[] user) {
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
        for (int i=0; i<user.length; i++){
            if (user[i]!=null){
                System.out.print(i+1+" | ");
                System.out.println(user[i]);
            }
        }
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
    }
}
