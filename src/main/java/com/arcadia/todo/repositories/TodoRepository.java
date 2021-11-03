package com.arcadia.todo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcadia.todo.model.Todo;

// @Repository annotation marks this interface as a Spring Data JPA repository.
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

	// Through CrudRepository it's possible to use methods save(), findOne(),
	// findById(), findAll(), count(), delete(), deleteById() without providing
	// implementation.
}
