package org.zerock.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DateTest {

		@Test
		public void test () { // text�� public�� �ʼ���

			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			String toDateStr = "20190329";
			String fromDateStr = "20200329";
			
			try {
				Date toDate = format.parse(toDateStr);
				Date fromDate = format.parse(fromDateStr);
				
				long baseDay = 24 * 60 * 60 * 1000; 	// ��
				long baseMonth = baseDay * 30;		// ��
				long baseYear = baseMonth * 12;		// ��
				
				// from ���ڿ� to ������ �ð� ���̸� ����Ѵ�.
				long calDate = fromDate.getTime() - toDate.getTime();
				
				// from ���ڿ� to ������ �ð� �� ���� �Ϸ�������� ���� �ش�.
				long diffDate = calDate / baseDay;
				long diffMonth = calDate / baseMonth;
				long diffYear = calDate / baseYear;
				
				System.out.println("diffDate : " + diffDate + "��");
				System.out.println("diffMonth : " + diffMonth + "��");
				System.out.println("diffYear : " + diffYear + "��");
				
				System.out.println(toDateStr.length());
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
 }
