package com.hungries.repository;

import com.hungries.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLoginId(String loginId);

    List<Customer> deleteByLoginId(String loginId);
}
