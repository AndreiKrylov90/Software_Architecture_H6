package notes.application.interfaces;

import notes.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();
    boolean saveChanges();

    // new code
    

}
