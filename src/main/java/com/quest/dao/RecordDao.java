package com.quest.dao;

import java.util.List;

import com.quest.model.Record;

public interface RecordDao {
	
	public void addRecord(Record record);
	public List<Record> getAllRecords();
	public Record find(String ppsNumber);

}
