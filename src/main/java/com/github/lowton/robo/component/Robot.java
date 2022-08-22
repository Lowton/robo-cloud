package com.github.lowton.robo.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Robot {
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min = 1, message = "You must choose at least one item")
	private List<Item> components = new ArrayList<>();
	
	public void addItem(Item item) {
		components.add(item);
	}
}
