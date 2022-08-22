package com.github.lowton.robo.component;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.github.lowton.robo.repository.ItemRef;
import lombok.Data;

@Data
@Table
public class Robot {
	
	@Id
	private Long id;
	private Date createdAt;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min=1, message="You must choose at least one item")
	private List<ItemRef> components;
}
