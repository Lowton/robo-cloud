package com.github.lowton.robo.component;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force = true)
public class Item {
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		BODY, CHASSIS, MANIPULATOR, POWER_SOURCE, CONTROLLER
	}
}
