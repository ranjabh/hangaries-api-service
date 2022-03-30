package com.hungries.repository;

import com.hungries.model.MenuDishPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDishpointRepository extends JpaRepository<MenuDishPoint, Long> {


}