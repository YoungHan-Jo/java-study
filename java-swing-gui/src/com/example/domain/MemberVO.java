package com.example.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter,setter,tostring 묶음
@NoArgsConstructor
@AllArgsConstructor // no, all 은 세트
public class MemberVO {

	private String id;
	private String passwd;
	private String name;
	private String email;
	private String recvEmail; //'Y' or 'N'
	private Timestamp regDate;
}
