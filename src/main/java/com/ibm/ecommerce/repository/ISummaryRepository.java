package com.ibm.ecommerce.repository;

import com.ibm.ecommerce.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISummaryRepository extends JpaRepository<Summary, Integer> {

}
