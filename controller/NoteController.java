package ua.cluster.controller;

import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

import java.util.Date;

public class NoteController {
    private NoteView view = new NoteView();
    private String[] commands = {"list","search", "edit", "check", "new", "remove", "user menu", "exit"};

    public void commandList(){
        view.printCommands(commands);
    }

    public boolean isExistingCommand (String command){
        for (String s : commands) {
            if (command.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void runCommand(String command, Note[] note){
        switch (command){
            case "list":
                listNote(note);
                break;
            case "search":
                searchNote(note);
                break;
            case "edit":
                editNote(note);
                break;
            case "check":
                checkNote(note);
                break;
            case "new":
                newNote(note);
                break;
            case "remove":
                removeNote(note);
        }
    }

    public void listNote (Note[] note){
        view.printNotes(note);
    }

    // метод змінює isChecked на протилежний
    // просить ввести номер рядка
    // виводить змінений рядок з нотаткою
    public void checkNote(Note[] note) {
        int index = view.requestIndex(noteCounter(note));
        if (index != -1){
            if (view.confirmation(note[index-1], index)){
                if (note[index-1].isChecked()){
                    note[index-1].setChecked(false);
                    } else {
                    note[index-1].setChecked(true);
                    }
                view.printSingleNote(note[index-1], index-1);
                view.printSuccess();
            } else {
                view.nothingChanged();
            }
        }
    }

    // метод змінює поле Note на нове, що вводиться з консолі
    // потрібно вказати номер нотатки
    // виводить оновлений рядок з нотаткою
    public void editNote(Note[] note){
        int index = view.requestIndex(noteCounter(note));
        if (index!=-1){
            if (view.confirmation(note[index-1], index)){
                String replace = view.requestNewNote();
                note[index-1].setNote(replace);
                Date date = new Date();
                note [index-1].setDate(date.toString());
                view.printSingleNote(note[index-1], index-1);
                view.printSuccess();
            } else {
                view.nothingChanged();
            }
        }
    }

    // метод здійснює пошук за текстом нотатки
    // виводить список знайдених нотаток
    public void searchNote(Note[] note){
        String found = view.requestKeyword();
        int count = 0;
        for (int i=0; i<noteCounter(note); i++){
            String n = note[i].getNote();
            int index = n.indexOf(found);
            if (index >-1){
                view.printSingleNote(note[i], i);
                count+=1;
            }
        }
        if (count==0){
            view.nothingFound();
        }
    }

    public void newNote(Note[] note){
        Note newNoteObj = new Note();
        newNoteObj.setNote(view.requestNewNote());
        newNoteObj.setChecked(view.requestChecked());
        newNoteObj.setLabel(view.requestLabel());
        Date date = new Date();
        newNoteObj.setDate(date.toString());
        note[noteCounter(note)] = newNoteObj;
        view.printSingleNote(note[noteCounter(note)-1], noteCounter(note)-1);
        view.printSuccess();
    }

    public void removeNote(Note[] note){
        //note[1]=null;
        int index = view.requestIndex(noteCounter(note));
        if (index!=-1){
            if (view.confirmation(note[index-1], index)){
                note[index-1]=null;
                for (int i=index-1; i<noteCounter(note); i++){
                    note[i]=note[i+1];
                    }
                view.printNotes(note);
                view.printSuccess();
                } else {
                view.nothingChanged();
                }
            }
    }

    // метод-костиль, використовується для підрахунтку кількості нотаток в масиві (базі)
    // вживається замість метода .length, щоб не мати справ з порожніми місцями в масиві
    public int noteCounter(Note[] note){
        int count=0;
        for (int i=0; i<note.length; i++){
            if (note[i]!=null){
                count+=1;
            }
        }
        return count;
    }
}
