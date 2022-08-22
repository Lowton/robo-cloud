package com.github.lowton.robo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.lowton.robo.component.RobotOrder;

public interface OrderRepository extends CrudRepository<RobotOrder, Long> {
}
