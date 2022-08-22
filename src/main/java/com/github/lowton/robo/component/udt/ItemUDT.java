package com.github.lowton.robo.component.udt;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.github.lowton.robo.component.Item;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@UserDefinedType("item")
public class ItemUDT {
	private final String name;
	private final Item.Type type;
}
