package com.github.lowton.robo.repository;

import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.VARCHAR;
import static org.springframework.asm.Type.LONG;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.lowton.robo.component.Robot;
import com.github.lowton.robo.component.RobotOrder;

@Repository
public class JdbcOrderRepository implements OrderRepository {
	private JdbcOperations jdbcOperations;
	
	public JdbcOrderRepository(final JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	@Override
	@Transactional
	public RobotOrder save(RobotOrder order) {
		var pscf = new PreparedStatementCreatorFactory(
				"insert into Robot_Order "
						+ "(delivery_name, delivery_street, delivery_city, "
						+ "delivery_state, delivery_zip, cc_number, "
						+ "cc_expiration, cc_cvv, placed_at)  "
						+ "values (?,?,?,?,?,?,?,?,?)",
				VARCHAR, VARCHAR, VARCHAR,
				VARCHAR, VARCHAR, VARCHAR,
				VARCHAR, VARCHAR, TIMESTAMP
		);
		pscf.setReturnGeneratedKeys(true);
		
		order.setPlacedAt(new Date());
		
		var psc = pscf.newPreparedStatementCreator(
				List.of(
						order.getDeliveryName(),
						order.getDeliveryStreet(),
						order.getDeliveryCity(),
						order.getDeliveryState(),
						order.getDeliveryZip(),
						order.getCcNumber(),
						order.getCcExpiration(),
						order.getCcCVV(),
						order.getPlacedAt()));
		
		var keyHolder = new GeneratedKeyHolder();
		jdbcOperations.update(psc, keyHolder);
		long orderId = keyHolder.getKey().longValue();
		order.setId(orderId);
		
		List<Robot> robots = order.getRobots();
		int i = 0;
		for (var robot : robots) {
			saveRobot(orderId, ++i, robot);
		}
		
		return order;
	}
	
	private long saveRobot(Long orderId, int orderKey, Robot robot) {
		robot.setCreatedAt(new Date());
		var pscf = new PreparedStatementCreatorFactory(
				"insert into Robot "
						+ "(name, created_at, robot_order, robot_order_key) "
						+ "values (?, ?, ?, ?)",
				VARCHAR, TIMESTAMP, LONG, LONG
		);
		pscf.setReturnGeneratedKeys(true);
		
		var psc = pscf.newPreparedStatementCreator(List.of(
				robot.getName(),
				robot.getCreatedAt(),
				orderId,
				orderKey
		));
		
		var keyHolder = new GeneratedKeyHolder();
		jdbcOperations.update(psc, keyHolder);
		long robotId = keyHolder.getKey().longValue();
		robot.setId(robotId);
		
		saveItemRefs(robotId, robot.getComponents());
		
		return robotId;
	}
	
	private void saveItemRefs(long robotId, List<ItemRef> components) {
		int key = 0;
		
		for (var itemRef : components) {
			jdbcOperations.update(
					"insert into Item_Ref (item, robot, robot_key) "
							+ "values (?, ?, ?)",
					itemRef.item(), robotId, ++key);
		}
	}
}
