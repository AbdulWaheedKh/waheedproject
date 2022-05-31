package org.oneCable.java.repository;

import org.oneCable.java.model.profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface profileRepository extends JpaRepository<profile, Long> {

}
