/**
 * 
 */
package org.oneCable.java.repository;

import java.util.List;

import org.oneCable.java.model.pakage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Waheed
 *
 */
@Repository
public interface pakageRepository extends JpaRepository<pakage, Long> {

	@Query("SELECT p from pakage p")
	public List<pakage> getAllpakages();

	@Query("SELECT p from pakage p where p.Id = :id")
	public pakage getpakageById(@Param("id") Long id);
}
