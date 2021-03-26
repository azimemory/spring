package com.kh.toy.common.batch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawlingBatch {
	
	@Autowired
	BatchRepository batchRepository;
	
	//cron 표현식
	//초 분 시 일 월 요일 연도(스프링에서는 사용하지 않음)
	// * : 모든
	// , : 복수 값을 지정
	// 시작시간/단위 : 시작시간부터 지정한 단위마다 실행
	// 3 * * 5 * *
	// 0 0 1 1 3,6,9,12 *
	@Scheduled(cron = "5,35 5 5 5 5 *")
	public void baseBallCarawling() throws MalformedURLException, IOException {
		Document doc = Jsoup.parse(new URL("https://www.koreabaseball.com/TeamRank/TeamRank.aspx"), 10000);
		Elements eles = doc.select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
		
		String[] keyArr = {"rank","teamName","match","win","loose","tie","rate"};
		
		for (Element e : eles) {
			Map<String,String> data = new LinkedHashMap<>();
			for(int i = 0; i < 7; i++) {
				data.put(keyArr[i], e.children().get(i).text());
			}
			
			batchRepository.insertBaseBall(data);
		}
	}
	
	
	public void OceanCrawling() throws MalformedURLException, IOException {
		Document doc = Jsoup.parse(new URL("http://www.khoa.go.kr/oceangrid/koofs/kor/observation/obs_real_list.do"), 10000);
		System.out.println("어디갔지? " + doc.select("body > ul"));
	}
}
