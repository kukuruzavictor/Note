package ua.cluster.view;

import java.util.Scanner;

public class MainView {

    public String inputCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT COMMAND: ");
        return sc.nextLine().toLowerCase().trim();
    }
}
