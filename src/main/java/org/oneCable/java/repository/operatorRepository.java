package org.oneCable.java.repository;

import org.oneCable.java.model.operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface operatorRepository extends JpaRepository<operator, Long> {

}
