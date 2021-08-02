package com.example.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {

	private int pageNum; // 페이지번호
	private int amount; // 한 페이지당 글 개수

	public Criteria() {
		this(1,10);
	}

	public Criteria(Integer pageNum, Integer amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}	
}
