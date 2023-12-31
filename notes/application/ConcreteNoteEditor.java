package notes.application;

import notes.application.interfaces.NoteEditor;
import notes.application.interfaces.NotesDatabaseContext;
import notes.application.interfaces.NotesPresenter;
import notes.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(
            NotesPresenter notesPresenter,
            NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    public void printAll() {
        notesPresenter.printAll(getAll());
    }

    @Override
    public boolean add(Note item) {
        //dbContext.getAll().add(item);
        return dbContext.saveChanges(item);
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(new Date());
        note.get().setUserId(item.getUserId());

        return dbContext.saveChanges(item);
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer integer) {
        return dbContext.getAll().stream().filter(p -> p.getId() == integer).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public boolean saveChanges(Note note) {
        try {
            if (add(note)) {
                return dbContext.saveChanges(note); 
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
