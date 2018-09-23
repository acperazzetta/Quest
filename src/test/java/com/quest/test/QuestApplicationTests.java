package com.quest.test;

import static org.hamcrest.CoreMatchers.hasItems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.quest.model.Record;
import com.quest.repository.RecordRepository;
import com.quest.service.RecordService;
import com.quest.service.RecordServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
public class QuestApplicationTests {
	
  @TestConfiguration
  static class QuestApplicationTestContextConfiguration {

      @Bean
      public RecordService recordService() {
          return new RecordServiceImpl();
      }
  }
	
  @Autowired
  private RecordService recordService;

  @MockBean
  private RecordRepository recordRepository;

  @Before
  public void setUp() {
   
      Mockito.when(recordService.getAllRecords()).thenReturn(populate());
      Record record = new Record("Steve Wilson", "0684861B", "15/08/1968", "083551655", null);
      Mockito.when(recordService.find("0684861B")).thenReturn(record);
  }
  
  @Test
  public void findAllTest() {
  	
  	Assert.assertThat(recordService.getAllRecords(), hasItems(new Record("Steve Wilson", "0684861B", "15/08/1968", "083551655", null)));
  	
  }
  
  @Test
  public void findByPPSTest() {
  	Assert.assertEquals("Steve Wilson", recordService.find("0684861B").getName());
  	
  }
  
  private List<Record> populate() {
  	
  	List<Record> records = new ArrayList<Record>();
    records.add(new Record("Steve Wilson", "0684861B", "15/08/1968", "083551655", null));

  	return records;
  }
}
