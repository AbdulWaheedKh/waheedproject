package org.oneCable.java.repository;

import org.oneCable.java.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee, Long> {

}
