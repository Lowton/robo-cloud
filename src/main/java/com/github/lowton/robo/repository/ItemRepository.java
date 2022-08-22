package com.github.lowton.robo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.lowton.robo.component.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
}
