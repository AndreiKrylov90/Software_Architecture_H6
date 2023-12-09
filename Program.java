import database.NotesDatabase;
import notes.application.ConcreteNoteEditor;
import notes.domain.Note;
import notes.infrastructure.persistance.DatabaseContext;
import notes.presentation.queries.controllers.NotesController;
import notes.presentation.queries.views.NotesConsolePresenter;
import java.util.Date;

public class Program {

    public static void main(String[] args) {
        NotesController notesController = new NotesController(
                new ConcreteNoteEditor(new NotesConsolePresenter(), new DatabaseContext(new NotesDatabase())));
        
        notesController.routeGetAll();

        System.out.println("Creating new 1...");
        Note newNote = new Note(1, 100001, "test title", "test details", new Date());

        notesController.routeAddNote(newNote);

        System.out.println("Creating new 2...");
        Note newNote2 = new Note(2, 100002, "test title2", "test details2", new Date());

        notesController.routeAddNote(newNote2);

        System.out.println("Final list: ");
        notesController.routeGetAll();

    }

}
