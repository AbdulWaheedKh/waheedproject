package org.oneCable.java.repository;

import java.util.List;

import org.oneCable.java.model.area;
import org.oneCable.java.model.menuitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface menuitemRepository extends JpaRepository<menuitem, Long> {

	
	@Query("SELECT mi from menuitem mi")
	public List<menuitem> getAllmenus();
}
