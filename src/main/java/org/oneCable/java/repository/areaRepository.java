/**
 * 
 */
package org.oneCable.java.repository;

import java.util.List;

import org.oneCable.java.model.area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Waheed
 *
 */
@Repository
public interface areaRepository extends JpaRepository<area, Long> {

	@Query("SELECT a from area a")
	public List<area> getAllAreas();

	@Query("SELECT a from area a where a.Id = :id")
	public area getareaById(@Param("id") Long id);
}
