package org.zerock.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class Test1Test {

	
		@Test
		public void test() {
			String str = "TEST";
			log.info(str.length());
			
			Date date = new Date();   //���ݳ�¥ ������
			Calendar cal = Calendar.getInstance();
			
			
			SimpleDateFormat aaa = new SimpleDateFormat("yyyy-MM-dd"); //���ض� ��
			log.info(date); //���� �� (Tue Dec 08 11:49:02 KST 2020)
			log.info(aaa.format(date)); //���� �� ( 2020-12-08)
			
			
			Calendar cal1 = Calendar.getInstance();  //���ض� �� 2
			cal1.setTime(date);
			int year = cal.get(Calendar.YEAR);
			log.info(year);
			log.info(cal1.get(Calendar.YEAR));
			
			
			
		}
}
