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


    public DatabaseContext(Database database) {
        super(database);
    }

    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public boolean saveChanges(int userId, int id, String title, String details, Date creationDate) {
        try {
            Collection<Note> notes = getAll();
    
            // Создаем новую заметку с переданными значениями
            Note newNote = new Note(userId, id, title, details, creationDate);
    
            // Добавляем новую заметку в коллекцию
            notes.add(newNote);
    
            // Ваш код для сохранения изменений в базе данных
            // Например, если у вас есть JPA EntityManager:
            // entityManager.getTransaction().begin();
            // entityManager.persist(newNote);
            // entityManager.getTransaction().commit();
    
            return true; // Возвращаем true, если сохранение прошло успешно
        } catch (Exception e) {
            e.printStackTrace(); // Логируем ошибку, если что-то пошло не так
            return false; // Возвращаем false в случае ошибки
        }
    }





}
