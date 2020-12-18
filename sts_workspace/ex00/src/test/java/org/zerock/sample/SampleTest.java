package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {

	@Setter(onMethod_={@Autowired})
	private Restaurant restaurnat;
	
	
	@Test //junit���� �׽�Ʈ ���
	public void testExist() {
		
		 assertNotNull(restaurnat); //�ش��ϴ� ������ null�� �ƴҶ� �׽�Ʈ����
		
		log.info(restaurnat);	
		log.info("----------------------");
		log.info(restaurnat.getChef());
		
	}
	
	@Test
	public void makeClassTest() {
		Chef chef = new Chef();
		SampleHotel s = new SampleHotel(chef);
		
	}
	

	
	
}
