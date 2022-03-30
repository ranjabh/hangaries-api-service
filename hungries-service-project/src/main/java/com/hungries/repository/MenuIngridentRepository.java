 package com.hungries.repository;
import com.hungries.model.MenuIngrident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface MenuIngridentRepository extends JpaRepository<MenuIngrident, Long> {
}