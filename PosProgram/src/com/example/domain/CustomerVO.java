package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {

	private String cno;
	private int adult;
	private int kid;
	private int payment;
	private String admission;
	private String tableNum;
	private String exitTime;

}
