package com.userregister.userregister.repository;

import com.userregister.userregister.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository <Report, Integer> {
    
}
