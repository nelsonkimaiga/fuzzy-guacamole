package com.microservice.kcb.repository;

import com.microservice.kcb.model.B2c;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2cRepository extends JpaRepository<B2c, Long> {

}
