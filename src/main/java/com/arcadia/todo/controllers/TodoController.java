package com.arcadia.todo.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcadia.todo.model.Todo;
import com.arcadia.todo.services.TodoService;

// @RestController annotation marks this class as a controller that can process the incoming HTTP 
// requests.

@RestController

// @RequestMapping("/api/v1/todo") annotation sets the base path to the resource endpoints in 
// the controller as /api/v1/todo.

@RequestMapping("/api/v1/todo")
public class TodoController {

	// We inject the TodoService through our contractor to be able to use the
	// various methods defined in it within the TodoController class.

	TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	// The function receives a GET request, processes it and gives back a list of
	// Todo as a response.
	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.getTodos();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	// The function receives a GET request, processes it, and gives back a list of
	// Todo as a response.
	@GetMapping({ "/{todoId}" })
	public ResponseEntity<Todo> getTodo(@PathVariable Long todoId) {
		return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
	}

	// The function receives a POST request, processes it, creates a new Todo and
	// saves it to the database, and returns a resource link to the created todo.
	@PostMapping
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
		Todo todo1 = todoService.insert(todo);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("todo", "/api/v1/todo/" + todo1.getId().toString());
		return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
	}

	// The function receives a PUT request, updates the Todo with the specified Id
	// and returns the updated Todo
	@PutMapping({ "/{todoId}" })
	public ResponseEntity<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo todo) {
		todoService.updateTodo(todoId, todo);
		return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
	}

	// The function receives a DELETE request, deletes the Todo with the specified
	// Id.
	@DeleteMapping({ "/{todoId}" })
	public ResponseEntity<Todo> deleteTodo(@PathVariable("todoId") Long todoId) {
		todoService.deleteTodo(todoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}