package com.github.lowton.robo.config;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.lowton.robo.component.Item;
import com.github.lowton.robo.repository.ItemRepository;

@Configuration
public class RunnerConfig {
	
	@Bean
	public ApplicationRunner dataLoader(ItemRepository repo) {
		return args -> repo.saveAll(List.of(
				new Item("SBB", "Square box", Item.Type.BODY),
				new Item("CB", "Cylinder", Item.Type.BODY),
				new Item("CPUBT", "Baical Titan", Item.Type.CONTROLLER),
				new Item("CPUP", "Intel Pentium", Item.Type.CONTROLLER),
				new Item("TC", "Trucks", Item.Type.CHASSIS),
				new Item("WC", "Wheels", Item.Type.CHASSIS),
				new Item("AM", "Arm", Item.Type.MANIPULATOR),
				new Item("TAM", "Telescopic arm", Item.Type.MANIPULATOR),
				new Item("NPS", "Nuclear power supply", Item.Type.POWER_SOURCE),
				new Item("ZCB", "Zinc-carbon battery", Item.Type.POWER_SOURCE)
		));
	}
}
