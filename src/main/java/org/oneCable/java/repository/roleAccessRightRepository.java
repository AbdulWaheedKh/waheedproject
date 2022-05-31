package org.oneCable.java.repository;

import java.util.List;

import org.oneCable.java.model.roleaccessright;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface roleAccessRightRepository extends JpaRepository<roleaccessright, Long> {

	@Query("SELECT pr FROM roleaccessright pr WHERE pr.RoleId = :roleId and pr.OperatorId =:instId order by pr.menuItem.navType, pr.menuItem.seqNo NULLS LAST, pr.menuItem.id ")
	public List<roleaccessright> getRoleAccessRightsByOperatorIdANDRoleId(@Param("instId") Long instId,
			@Param("roleId") Long roleId);
}
