package com.denchevgod.demo.repositories;

import com.denchevgod.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
