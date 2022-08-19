package com.github.lowton.robo.controller.converter;

import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.lowton.robo.component.Item;

@Component
public class ItemByIdConverter implements Converter<String, Item> {
	private final Map<String, Item> itemMap;
	
	public ItemByIdConverter() {
		itemMap = Map.of(
				"SBB", new Item("SBB", "Square box", Item.Type.BODY),
				"CB", new Item("CB", "Cylinder", Item.Type.BODY),
				"CPUBT", new Item("CPUBT", "Baical Titan", Item.Type.CONTROLLER),
				"CPUP", new Item("CPUP", "Intel Pentium", Item.Type.CONTROLLER),
				"TC", new Item("TC", "Trucks", Item.Type.CHASSIS),
				"WC", new Item("WC", "Wheels", Item.Type.CHASSIS),
				"AM", new Item("AM", "Arm", Item.Type.MANIPULATOR),
				"TAM", new Item("TAM", "Telescopic arm", Item.Type.MANIPULATOR),
				"NPS", new Item("NPS", "Nuclear power supply", Item.Type.POWER_SOURCE),
				"ZCB", new Item("ZCB", "Zinc-carbon battery", Item.Type.POWER_SOURCE)
		);
	}
	
	@Override
	public Item convert(final String id) {
		return itemMap.get(id);
	}
}
