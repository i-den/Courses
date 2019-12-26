package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.NotesCommand;
import com.denchevgod.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes src) {
        if (src == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(src.getId());
        notesCommand.setRecipeNotes(src.getRecipeNotes());
        return notesCommand;
    }
}
