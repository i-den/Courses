package com.denchevgod.recipes.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        long longId = 1L;

        category.setId(longId);

        assertEquals(longId, category.getId());
    }

    @Test
    void getRecipes() {
    }

    @Test
    void getDescription() {
    }
}