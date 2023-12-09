package notes.infrastructure.persistance;

import database.NotesDatabase;
import database.NotesRecord;
import notes.application.interfaces.NotesDatabaseContext;
import notes.domain.Note;
import notes.infrastructure.persistance.configuration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {

    private Collection<Note> notes;

    public DatabaseContext(Database database) {
        super(database);
        this.notes = new ArrayList<>();
    }

    public Collection<Note> getAll() {

        
        return notes;

    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public boolean saveChanges(Note note) {
        try {
            Note newNote = new Note(note.getId(), note.getUserId(),  note.getTitle(), note.getDetails(), note.getCreationDate());
            notes.add(newNote);
            return true; 
        } catch (Exception e) {
            e.printStackTrace(); 
            return false; 
        }
    }





}
