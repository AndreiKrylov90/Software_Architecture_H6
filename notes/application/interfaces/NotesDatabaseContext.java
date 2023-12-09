package notes.application.interfaces;

import notes.domain.Note;
import java.util.Date;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();
    boolean saveChanges(int userId, int id, String title, String details, Date creationDate);

}
