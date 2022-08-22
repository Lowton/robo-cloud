package com.github.lowton.robo.component;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection = "components")
@AllArgsConstructor
public class Item {
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		BODY, CHASSIS, MANIPULATOR, POWER_SOURCE, CONTROLLER
	}
}
