package com.github.lowton.robo.component;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table("components")
public class Item {
	@PrimaryKey
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		BODY, CHASSIS, MANIPULATOR, POWER_SOURCE, CONTROLLER
	}
}
