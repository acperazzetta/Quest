package com.quest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quest.model.Record;
import com.quest.service.RecordService;

@Controller
public class RecordController {

	@Autowired
	private RecordService recordService;

	// Inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = { "/recordList" }, method = RequestMethod.GET)
	public String showRecordListPage(Model model) {

		model.addAttribute("records", recordService.getAllRecords());

		return "recordList";
	}

	@RequestMapping(value = { "/recordAdd" }, method = RequestMethod.GET)
	public String showRecordAddPage(Model model) {

		Record record = new Record();
		model.addAttribute("record", record);

		return "recordAdd";
	}

	@RequestMapping(value = { "/recordAdd" }, method = RequestMethod.POST)
	public String saveRecord(Model model, @ModelAttribute("record") Record record) {

		Record recordCheck = recordService.find(record.getPpsNumber());

		if (recordCheck == null) {
			recordService.addRecord(record);
			return "redirect:/recordList";
		} else {
			model.addAttribute("errorMessage", errorMessage);
			return "recordAdd";
		}
	}

}