package org.oneCable.java.repository;

import org.oneCable.java.model.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepository extends JpaRepository<account, Long> {
	
	@Query("SELECT a FROM account a WHERE a.Username = :Username and a.Password=:Password and  a.Enable = 1")
	public account findAccountByUserNameAndPw(@Param("Username") String Username, @Param("Password") String Password);
	

}
