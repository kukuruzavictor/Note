package ua.cluster.view;

import ua.cluster.model.Note;

import java.util.Scanner;

public class NoteView {

    public void printCommands(String[] array){
        for (String s : array) {
            System.out.println("[ "+s.toUpperCase()+" ]");
        }
    }

    // метод для виведення масиву нотаток
    public void printNotes(Note[] note) {
        System.out.println("–––––––––––––––––––––––––––––––-––––––––––––");
        for (int i=0; i<note.length; i++){
            if (note[i]!=null){
                System.out.print(i+1+" | ");
                System.out.println(note[i]);
            }
        }
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
    }

    // метод для виведення однієї нотатки
    public void printSingleNote (Note note){
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println(note);
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
    }

    public void printSingleNote (Note note, int index){
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
        System.out.print((index)+1+" ");
        System.out.println(note);
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––");
    }

    // метод приймає int довжину масиву
    // просить ввести індекс нотатки
    // обходить всі помилки при не коректному введенні int
    public int requestIndex(int arrayLength){
        System.out.print("- CHOOSE NOTE'S INDEX (from 1 to " + arrayLength+"): ");
        Scanner sc = new Scanner(System.in);
        try {
            int requestIndex = sc.nextInt();
            if (requestIndex>1 && requestIndex<arrayLength+1){
                return requestIndex;
            } else {
                System.out.println("- WRONG INDEX");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("- WRONG INDEX");
            return -1;
        }
    }

    // метод просить ввести рядок і повертає його
    public String requestNewNote(){
        System.out.print("- NOTE TEXT: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String requestDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("- DATE: ");
        return sc.nextLine();
    }

    public boolean requestChecked(){
        Scanner sc = new Scanner(System.in);
        System.out.print("- CHECKED (1 is done): ");
        switch (sc.nextLine().trim()){
            case "1":
                return true;
            default:
                return false;
        }
    }

    public String requestLabel(){
        Scanner sc = new Scanner(System.in);
        System.out.print("- LABEL: ");
        return sc.nextLine();
    }

    // метод просить ввести рядок і повертає його
    public String requestKeyword(){
        System.out.print("- SEARCH KEYWORD: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean confirmation(Note note, int index){
        printSingleNote(note, index-1);
        System.out.print("- THIS NOTE YOU MEAN? (YES by default) (Y/N): ");
        Scanner sc = new Scanner(System.in);
        String confirmation = sc.nextLine();
        if (confirmation.toLowerCase().trim().equals("y") || confirmation.trim().equals("")){
            return true;
        }
        return false;
    }

    public void printSuccess(){
        System.out.println("- DONE.");
    }

    public void nothingChanged() {
        System.out.println("- NOTHING CHANGED.");
    }

        public void nothingFound(){
        System.out.println("- NOTHING FOUND.");
    }
}
