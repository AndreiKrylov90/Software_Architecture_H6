package notes.presentation.queries.controllers;

import notes.application.interfaces.NoteEditor;
import notes.domain.Note;
import notes.presentation.queries.controllers.Controller;

public class NotesController extends Controller {


    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note) {
        this.notesEditor.add(note);
    }

    public void routeRemoveNote(Note note) {
        this.notesEditor.remove(note);
    }

    public void routeGetAll(){
        notesEditor.printAll();
    }


}
