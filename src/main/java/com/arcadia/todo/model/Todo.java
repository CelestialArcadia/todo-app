package com.arcadia.todo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity annotation shows that the class is a persistent Java class.
@Entity

// @Data annotation is from project Lombok. It generates the getters and setters for all 
// the fields that we have in the todo class, equals method, and a toString method.
@Data

// @NoArgsConstructor annotation is from project Lombok and it generates 
// an empty constructor for our Todo class.
@NoArgsConstructor

// @AllArgsConstructor annotation is from project Lombok and it generates a constructor with 
// all the fields that are available in our Todo class.
@AllArgsConstructor

// @Builder annotation is from project Lombok. It makes it possible 
// for us to use the builder pattern with our Todo model.
@Builder
public class Todo {

	// @Id annotation shows that the annotated field is the primary key.
	// @GeneratedValue annotation is used to specify the generation strategy used
	// for the primary key.
	// @Column annotation defines the column in the database that maps the annotated
	// field.
	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	Long id;
	@Column
	String title;
	@Column
	String description;
	@Column
	TodoStatus todoStatus;

	// @CreationTimestamp annotation is a JPA annotation that automatically updates
	// the todo creation timestamp.
	@CreationTimestamp
	@Column(updatable = false)
	Timestamp dateCreated;
	// @UpdateTimestamp annotation is a JPA annotation that automatically updates
	// the todo last modified timestamp.
	@UpdateTimestamp
	Timestamp lastModified;

}
