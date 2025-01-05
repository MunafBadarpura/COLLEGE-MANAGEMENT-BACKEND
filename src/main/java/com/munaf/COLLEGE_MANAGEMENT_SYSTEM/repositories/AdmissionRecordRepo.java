package com.munaf.COLLEGE_MANAGEMENT_SYSTEM.repositories;

import com.munaf.COLLEGE_MANAGEMENT_SYSTEM.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecord, Long> {
}
