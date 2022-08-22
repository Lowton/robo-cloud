package com.github.lowton.robo.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.lowton.robo.component.udt.ItemUDT;
import com.github.lowton.robo.component.udt.UDTUtils;
import com.github.lowton.robo.repository.ItemRepository;

@Component
public class ItemByIdConverter implements Converter<String, ItemUDT> {
	private final ItemRepository itemRepository;
	
	public ItemByIdConverter(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public ItemUDT convert(final String id) {
		return itemRepository.findById(id).map(UDTUtils::toItemUDT).orElse(null);
	}
}
