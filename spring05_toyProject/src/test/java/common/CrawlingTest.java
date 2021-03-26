package common;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.common.batch.CrawlingBatch;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class CrawlingTest {
	
	@Autowired
	CrawlingBatch batch;
	
	@Test
	public void baseBallCrawlingTest() throws MalformedURLException, IOException {
		batch.baseBallCarawling();
	}

	
	@Test
	public void OceanCrawlingTest() throws MalformedURLException, IOException {
		batch.OceanCrawling();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
