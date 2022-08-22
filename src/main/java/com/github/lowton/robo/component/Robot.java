package com.github.lowton.robo.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Robot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=1, message="You must choose at least one item")
	@ManyToMany
	private List<Item> components = new ArrayList<>();
	
	public void addItem(Item item) {
		components.add(item);
	}
}
