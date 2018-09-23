package com.quest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quest.dao.RecordDao;
import com.quest.model.Record;

@Component
public class RecordServiceImpl implements RecordService {
	
	@Autowired
	public RecordDao recordDao;	

	@Override
	public void addRecord(Record record) {
		recordDao.addRecord(record);
	}

	@Override
	public List<Record> getAllRecords() {
		return recordDao.getAllRecords();
	}

	@Override
	public Record find(String ppsNumber) {
		return recordDao.find(ppsNumber);
	}
	
	
}
