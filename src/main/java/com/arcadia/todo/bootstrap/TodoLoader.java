package com.arcadia.todo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.arcadia.todo.model.Todo;
import com.arcadia.todo.model.TodoStatus;
import com.arcadia.todo.repositories.TodoRepository;

// @Component annotation informs Spring that this class is a Spring component.

@Component
public class TodoLoader implements CommandLineRunner {

	public final TodoRepository todoRepository;

	public TodoLoader(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadTodos();
	}

	private void loadTodos() {
		if (todoRepository.count() == 0) {
			todoRepository.save(Todo.builder().title("Go to market").description("Buy eggs from market")
					.todoStatus(TodoStatus.NOT_COMPLETED).build());
			todoRepository.save(Todo.builder().title("Go to school").description("Complete assignments")
					.todoStatus(TodoStatus.NOT_COMPLETED).build());
			System.out.println("Sample Todos Loaded");
		}
	}

}
