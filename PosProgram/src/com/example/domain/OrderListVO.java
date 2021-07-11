package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListVO {

	private String orderNum;
	private String cno;
	private String menu;
	private int quantity;
	private int price;
	private String orderTime;

}
