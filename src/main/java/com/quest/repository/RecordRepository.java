package com.quest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quest.model.Record;


public interface RecordRepository extends JpaRepository<Record, Long> {
	
	@Query("SELECT rec FROM Record rec where pps_number = :ppsNumber")
	Record findRecordByPPS(@Param("ppsNumber") String ppsNumber);
	

}
