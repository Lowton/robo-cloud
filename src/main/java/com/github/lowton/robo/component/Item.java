package com.github.lowton.robo.component;

import lombok.Data;

@Data
public class Item {
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		BODY, CHASSIS, MANIPULATOR, POWER_SOURCE, CONTROLLER
	}
}
