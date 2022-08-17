package com.bsmm.springbatch.repository;

import com.bsmm.springbatch.domain.CreditCardRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRiskRepository extends JpaRepository<CreditCardRisk, Long> {
}
