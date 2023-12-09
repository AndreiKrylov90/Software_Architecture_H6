package notes.application.interfaces;

import notes.domain.Note;
import java.util.Date;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

    // new code
    boolean saveChanges(int userId, int id, String title, String details, Date creationDate);

}
