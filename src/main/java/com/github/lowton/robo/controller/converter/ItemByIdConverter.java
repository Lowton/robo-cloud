package com.github.lowton.robo.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.lowton.robo.component.Item;
import com.github.lowton.robo.repository.ItemRepository;

@Component
public class ItemByIdConverter implements Converter<String, Item> {
	private final ItemRepository itemRepository;
	
	public ItemByIdConverter(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public Item convert(final String id) {
		return itemRepository.findById(id).orElse(null);
	}
}
