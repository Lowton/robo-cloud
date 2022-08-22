package com.github.lowton.robo.component;

import static com.github.lowton.robo.component.udt.UDTUtils.toItemUDT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.github.lowton.robo.component.udt.ItemUDT;
import lombok.Data;

@Data
@Table("robots")
public class Robot {
	
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private UUID id = Uuids.timeBased();
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
			ordering = Ordering.DESCENDING)
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min = 1, message = "You must choose at least one item")
	@Column("components")
	private List<ItemUDT> components = new ArrayList<>();
	
	public void addItem(Item item) {
		components.add(toItemUDT(item));
	}
}
