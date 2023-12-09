package notes.application.interfaces;

import notes.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);

}
