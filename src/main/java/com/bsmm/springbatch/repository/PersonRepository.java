package com.bsmm.springbatch.repository;

import com.bsmm.springbatch.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}