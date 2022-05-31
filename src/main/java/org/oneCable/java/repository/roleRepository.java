package org.oneCable.java.repository;

import java.util.List;

import org.oneCable.java.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {

	@Query("SELECT r from role r")
	public List<role> getAllRoles();

	@Query("SELECT r from role r where r.Id = :id")
	public role getRoleById(@Param("id") Long id);
}
