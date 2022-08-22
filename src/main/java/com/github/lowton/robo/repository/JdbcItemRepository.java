package com.github.lowton.robo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.lowton.robo.component.Item;

@Repository
public class JdbcItemRepository implements ItemRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcItemRepository(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Iterable<Item> findAll() {
		return jdbcTemplate.query(
				"select id, name, type from Item",
				this::mapRowToItem);
	}
	
	@Override
	public Optional<Item> findById(String id) {
		var result = jdbcTemplate.query(
				"select id, name, type from Item where id=?",
				this::mapRowToItem,
				id);
		
		return result.isEmpty() ?
				Optional.empty() :
				Optional.of(result.get(0));
	}
	
	@Override
	public Item save(Item item) {
		jdbcTemplate.update(
				"insert into Item (id, name, type) values (?, ?, ?)",
				item.getId(),
				item.getName(),
				item.getType().toString());
		return item;
	}
	
	private Item mapRowToItem(ResultSet row, int rowNum) throws SQLException {
		return new Item(
				row.getString("id"),
				row.getString("name"),
				Item.Type.valueOf(row.getString("type")));
	}
}
