package com.github.lowton.robo.component.udt;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Data;

@Data
@UserDefinedType("robot")
public class RobotUDT {
	private final String name;
	private final List<ItemUDT> components;
}
