package ua.cluster.model;

import java.util.Objects;

public class Note {
    private String note;
    private String date;
    private boolean isChecked;
    private String label;

    public Note(String note, String date, boolean isChecked, String label) {
        this.note = note;
        this.date = date;
        this.isChecked = isChecked;
        this.label = label;
    }

    public Note() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "NOTE: " + note + " | " +
                "DATE: " + date + " | " +
                "IsCHECKED: " + isChecked + " | " +
                "LABEL: " + label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return isChecked == note1.isChecked &&
                Objects.equals(note, note1.note) &&
                Objects.equals(date, note1.date) &&
                Objects.equals(label, note1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, date, isChecked, label);
    }
}
