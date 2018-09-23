package com.quest.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.quest.model.Record;
import com.quest.repository.RecordRepository;

@Component
public class RecordDaoImpl implements RecordDao {
	
  @Resource
  private RecordRepository recordRepository;	
  
	@Override
  public void addRecord (Record record) {
  	recordRepository.save(record);
  }

	@Override
	public List<Record> getAllRecords() {
		return recordRepository.findAll(new Sort(Sort.Direction.ASC, "created"));
	}

	public Record find (String ppsNumber) {
		return recordRepository.findRecordByPPS(ppsNumber);
	}
}
