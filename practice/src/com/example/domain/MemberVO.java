package com.example.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	private String id;
	private String passwd;
	private String name;
	private String email;
	private String recvEmail;
	private Timestamp regDate;
	
}
