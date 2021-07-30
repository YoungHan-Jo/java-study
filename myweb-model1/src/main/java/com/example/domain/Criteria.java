package com.example.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {

	private Integer pageNum; // 페이지번호
	private Integer amount; // 한 페이지당 글 개수
	private Integer startRow; // MySQL LIMIT절을 위한 시작 행 번호

	public Criteria() {
		this(1,10);
	}

	public Criteria(Integer pageNum, Integer amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
		
		startRow = (pageNum-1)*amount;
	}
	
	
	
}
