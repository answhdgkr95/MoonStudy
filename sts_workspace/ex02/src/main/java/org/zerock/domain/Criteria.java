package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {

	private int pageNum; //페이지 번호
	private int amount;	//한페이지당 몇개
	
	public Criteria() {  //기본,초기값
		this(1,10);
	}
	public Criteria (int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
