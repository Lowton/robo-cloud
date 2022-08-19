package com.github.lowton.robo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.github.lowton.robo.component.RobotOrder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("robotOrder")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm() {
		return "order-form";
	}
	
	@PostMapping
	public String processOrder(@Valid RobotOrder order, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "order-form";
		}
		log.info("Order submitted: {}", order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
