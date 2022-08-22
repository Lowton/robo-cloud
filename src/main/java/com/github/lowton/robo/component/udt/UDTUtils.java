package com.github.lowton.robo.component.udt;

import java.util.List;

import com.github.lowton.robo.component.Item;
import com.github.lowton.robo.component.Robot;

public class UDTUtils {
	public static ItemUDT toItemUDT(final Item item) {
		return new ItemUDT(item.getName(), item.getType());
	}
	
	
	public static RobotUDT toRobotUDT(final Robot robot) {
		return new RobotUDT(robot.getName(), robot.getComponents());
	}
	
	public static List<ItemUDT> toItemUDTs(List<Item> components) {
		return components.stream()
				.map(UDTUtils::toItemUDT)
				.toList();
	}
}
