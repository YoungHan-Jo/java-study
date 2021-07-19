package com.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.domain.MemberVO;

public class MemberMapDAO {

	// 키는 id , 값은 VO 객체
	private Map<String, MemberVO> map = new HashMap<>();

	public void deleteAll() {
		map.clear(); // Map 비우기
	}

	public int getCountAll() {
		return map.size(); // Map 사이즈
	}

	public Collection<MemberVO> getMembers() {
		// map.keySet(); // 키 전부 가져오기
		return map.values(); // 값 전부 가져오기
	}

	public MemberVO getMemberById(String id) {
		return map.get(id); // get(키값) 하면 키에 해당하는 값을 불러온다
	}

	public void insert(MemberVO memberVO) throws Exception {
		if (map.containsKey(memberVO.getId())) { // containsKey() 값이 있으면 true 없으면 false
			throw new Exception("이미 존재하는 아이디 입니다."); // 강제로 예외 만들기
		}
		map.put(memberVO.getId(), memberVO);
	}

	public void updateById(MemberVO memberVO) throws Exception {
		if (map.containsKey(memberVO.getId()) == false) {
			throw new Exception("수정할 아이디가 존재하지 않습니다.");
		}
		map.put(memberVO.getId(), memberVO);
	}

	public void deleteById(String id) {
		map.remove(id); // remove(키)
	}
}