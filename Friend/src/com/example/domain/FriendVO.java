package com.example.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendVO {
	
	private int num;
	private String name;
	private String birth;
	private String phone;
	private String address;
	private Timestamp regDate;
}
