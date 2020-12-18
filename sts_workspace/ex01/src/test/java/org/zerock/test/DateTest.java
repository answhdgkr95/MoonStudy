package org.zerock.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DateTest {

		@Test
		public void test () { // text는 public이 필수임

			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			String toDateStr = "20190329";
			String fromDateStr = "20200329";
			
			try {
				Date toDate = format.parse(toDateStr);
				Date fromDate = format.parse(fromDateStr);
				
				long baseDay = 24 * 60 * 60 * 1000; 	// 일
				long baseMonth = baseDay * 30;		// 월
				long baseYear = baseMonth * 12;		// 년
				
				// from 일자와 to 일자의 시간 차이를 계산한다.
				long calDate = fromDate.getTime() - toDate.getTime();
				
				// from 일자와 to 일자의 시간 차 값을 하루기준으로 나눠 준다.
				long diffDate = calDate / baseDay;
				long diffMonth = calDate / baseMonth;
				long diffYear = calDate / baseYear;
				
				System.out.println("diffDate : " + diffDate + "일");
				System.out.println("diffMonth : " + diffMonth + "월");
				System.out.println("diffYear : " + diffYear + "년");
				
				System.out.println(toDateStr.length());
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
 }
