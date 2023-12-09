import database.NotesDatabase;
import notes.application.ConcreteNoteEditor;
import notes.domain.Note;
import notes.infrastructure.persistance.DatabaseContext;
import notes.presentation.queries.controllers.NotesController;
import notes.presentation.queries.views.NotesConsolePresenter;
import java.util.Date;

public class Program {

    public static void main(String[] args) {
        NotesController notesController = new NotesController(new
        ConcreteNoteEditor(new NotesConsolePresenter(), new DatabaseContext(new
        NotesDatabase())));
        notesController.routeGetAll();

        Note newNote = new Note(123456, 456, "test title", "test details", new Date());

        notesController.routeAddNote(newNote);
        
        notesController.saveChanges(newNote.getUserId(), newNote.getId(), newNote.getTitle(), newNote.getDetails(), newNote.getCreationDate());

        notesController.routeGetAll();


    }

}
