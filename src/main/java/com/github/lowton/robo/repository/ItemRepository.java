package com.github.lowton.robo.repository;

import java.util.Optional;

import com.github.lowton.robo.component.Item;

public interface ItemRepository {
	
	Iterable<Item> findAll();
	Optional<Item> findById(String id);
	Item save(Item item);
}
