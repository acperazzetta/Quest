package com.quest.service;

import java.util.List;

import com.quest.model.Record;

public interface RecordService {

	public void addRecord(Record record);
	List<Record> getAllRecords();
	public Record find(String ppsNumber);

}
