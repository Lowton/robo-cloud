package com.github.lowton.robo.component;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force = true)
public class Item {
	@Id
	private final String id;
	private final String name;
	private final Type type;
	
	public enum Type {
		BODY, CHASSIS, MANIPULATOR, POWER_SOURCE, CONTROLLER
	}
}
