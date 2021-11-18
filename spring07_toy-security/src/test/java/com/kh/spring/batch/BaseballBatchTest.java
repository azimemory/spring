package com.kh.spring.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class BaseballBatchTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Test
	public void jsoupTest() throws IOException {
		Elements elementList = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")
				.get().select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
		
		String[] keyArr = {"rank","name","game","win","lose","tie"};
		
		List<Map<String,String>> dataList = new ArrayList<>();
		
		for (Element tr : elementList) {
			Elements tdList = tr.getElementsByTag("td");
			
			Map<String,String> commandMap = new HashMap<>();
			for (int i = 0; i < 6; i++) {
				Element td = tdList.get(i);
				commandMap.put(keyArr[i], td.text());
			}
			dataList.add(commandMap);
		}
		
		for (Map<String, String> map : dataList) {
			batchRepository.insertBaseBallRank(map);
		}
	
	}
	
	
	
	
	
	
	
	
	
}
