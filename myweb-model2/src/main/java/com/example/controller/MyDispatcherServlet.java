package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MVC(모델2) : Model - View - Controller 패턴으로 작성하는 방식
// 모델1은 View(jsp)가 메인이지만
// @@모델2는 controller 가 메인@@

// 컨트롤러 : 뷰와 모델 사이에서 제어를 담당하는 클래스

// 프론트 컨트롤러 패턴 : 모든 사용자 요청을 전담해서 받아 처리하는 클래스
// 뷰(jsp)가 직접적으로 요청을 받으면 안됨!. (사용자가 직접 jsp를 실행 할 수 있으면 안됨.)
// jsp는 사용자에게 노출이 되어 있으면 안됨.(webapp(공개폴더) 안에 있는 WEB-INF(비공개)폴더 안에 숨겨야함.)
// resources(정적 자원) 폴더만 webapp폴더의 하위에 남겨두고 나머지는 WEB-INF폴더의 views 폴더로 이동

// MyDispatcherServlet 클래스를 프론트 컨트롤러 역할로 작성.

//@WebServlet("*.do") // 여기는 앞에 슬래시 있으면 안됨!, 충돌 할 수도 있으니까 .do 로// 직접 만들때는 이렇게 애노테이션으로 붙일 수 있음
// web.xml로 설정 할 수 있음.
public class MyDispatcherServlet extends HttpServlet {
	
	// jsp 페이지 안에서 작성한 모든 내용은 service로 들어와서 내보냄
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출됨.");
		
		//http://localhost:8090/myweb/
		//http://localhost:8090/
		
		// 1. 사용자 요청주소를 통해 요청 명령어 구하기
		
		String requestURI = request.getRequestURI();
		System.out.println("requestURI : " + requestURI); // "/myweb/index.do"
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath); // "/myweb" 상위 경로까지만 가져옴
		
		String command = requestURI.substring(contextPath.length() + 1);
		System.out.println("command : " + command);
		
		
		// 2. 요청 명령어에 해당하는 작업 처리하기
		if(command.equals("index.do")) {
			
		} else if (command.equals("memberJoin.do")) {
			
		}
		
		// 3. 작업 처리 후 사용자에게 알맞은 응답(화면 또는 데이터)을 보내기
		
		
	} // service

	
}
