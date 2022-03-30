package com.hungries.repository;

import com.hungries.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}