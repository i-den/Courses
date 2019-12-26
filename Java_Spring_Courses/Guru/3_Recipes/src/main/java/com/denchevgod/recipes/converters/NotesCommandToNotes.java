package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.NotesCommand;
import com.denchevgod.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand src) {
        if (src == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(src.getId());
        notes.setRecipeNotes(src.getRecipeNotes());
        return notes;
    }
}
