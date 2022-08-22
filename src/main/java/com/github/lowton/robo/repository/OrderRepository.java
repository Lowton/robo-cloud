package com.github.lowton.robo.repository;

import com.github.lowton.robo.component.RobotOrder;

public interface OrderRepository {
	RobotOrder save(RobotOrder order);
}
