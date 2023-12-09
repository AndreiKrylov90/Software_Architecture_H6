package notes.application.interfaces;

import notes.domain.Note;
import java.util.Date;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

    boolean saveChanges(Note note);

}
