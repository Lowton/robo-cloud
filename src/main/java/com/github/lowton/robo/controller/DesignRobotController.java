package com.github.lowton.robo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.lowton.robo.component.Item;
import com.github.lowton.robo.component.Robot;
import com.github.lowton.robo.component.RobotOrder;
import com.github.lowton.robo.component.udt.RobotUDT;
import com.github.lowton.robo.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("robotOrder")
public class DesignRobotController {
	
	private final ItemRepository itemRepository;
	
	public DesignRobotController(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@ModelAttribute
	public void addComponentsToModel(Model model) {
		var components = new ArrayList<Item>();
		itemRepository.findAll().forEach(components::add);
	
		for (var type: Item.Type.values()) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(components, type));
		}
	}
	
	@ModelAttribute(name = "robotOrder")
	public RobotOrder order() {
		return new RobotOrder();
	}
	
	@ModelAttribute(name = "robot")
	public Robot robot() {
		return new Robot();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	private Iterable<Item> filterByType(List<Item> components, Item.Type type) {
		return components.stream()
				.filter(item -> item.getType().equals(type))
				.toList();
	}
	
	@PostMapping
	public String processRobot(@Valid Robot robot, Errors errors, @ModelAttribute RobotOrder robotOrder) {
		if (errors.hasErrors()) {
			return "design";
		}
		
		log.info("Processing robot: {}", robot);
		robotOrder.addRobot(new RobotUDT(robot.getName(), robot.getComponents()));
		return "redirect:/orders/current";
	}
}
