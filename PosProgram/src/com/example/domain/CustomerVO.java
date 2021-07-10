package com.example.domain;

import java.sql.Timestamp;

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
	private String orderMenu;
	private int payment;
	private String admission;
	private String tableNum;

}
