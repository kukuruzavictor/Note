package ua.cluster.controller;

import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

public class NoteController {

    private String[] commands = {"exit","list","search", "edit", "check", "new", "remove"};

    public void commandList(){
        NoteView commandList = new NoteView();
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
        NoteView list = new NoteView();
        list.printNotes(note);
    }

    // метод змінює isChecked на протилежний
    // просить ввести номер рядка
    // виводить змінений рядок з нотаткою
    public void checkNote(Note[] note) {
        NoteView check = new NoteView();
        int index = check.requestIndex(noteCounter(note));
        if (index != -1){
            if (check.confirmation(note[index-1], index)){
                if (note[index-1].isChecked()){
                    note[index-1].setChecked(false);
                    } else {
                    note[index-1].setChecked(true);
                    }
                check.printSingleNote(note[index-1], index-1);
                check.printSuccess();
            } else {
                check.nothingChanged();
            }
        }
    }

    // метод змінює поле Note на нове, що вводиться з консолі
    // потрібно вказати номер нотатки
    // виводить оновлений рядок з нотаткою
    public void editNote(Note[] note){
        NoteView changeNote = new NoteView();
        int index = changeNote.requestIndex(noteCounter(note));
        if (index!=-1){
            if (changeNote.confirmation(note[index-1], index)){
                String replace = changeNote.requestNewNote();
                note[index-1].setNote(replace);
                changeNote.printSingleNote(note[index-1], index-1);
                changeNote.printSuccess();
            } else {
                changeNote.nothingChanged();
            }
        }
    }

    // метод здійснює пошук за текстом нотатки
    // виводить список знайдених нотаток
    public void searchNote(Note[] note){
        NoteView searchNote = new NoteView();
        String found = searchNote.requestKeyword();
        int count = 0;
        for (int i=0; i<noteCounter(note); i++){
            String n = note[i].getNote();
            int index = n.indexOf(found);
            if (index >-1){
                searchNote.printSingleNote(note[i], i);
                count+=1;
            }
        }
        if (count==0){
            searchNote.nothingFound();
        }
    }

    public void newNote(Note[] note){
        Note newNoteObj = new Note();
        NoteView newNote = new NoteView();
        newNoteObj.setNote(newNote.requestNewNote());
        newNoteObj.setDate(newNote.requestDate());
        newNoteObj.setChecked(newNote.requestChecked());
        newNoteObj.setLabel(newNote.requestLabel());
        note[noteCounter(note)] = newNoteObj;
        newNote.printSingleNote(note[noteCounter(note)-1], noteCounter(note)-1);
        newNote.printSuccess();
    }

    public void removeNote(Note[] note){
        //note[1]=null;
        NoteView removeNote = new NoteView();
        int index = removeNote.requestIndex(noteCounter(note));
        if (index!=-1){
            if (removeNote.confirmation(note[index-1], index)){
                note[index-1]=null;
                for (int i=index-1; i<noteCounter(note); i++){
                    note[i]=note[i+1];
                    }
                removeNote.printNotes(note);
                removeNote.printSuccess();
                } else {
                removeNote.nothingChanged();
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
