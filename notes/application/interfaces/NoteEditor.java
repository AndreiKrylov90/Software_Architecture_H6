package notes.application.interfaces;

import notes.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

}
