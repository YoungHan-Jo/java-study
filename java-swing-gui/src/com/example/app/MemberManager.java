package com.example.app;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.example.app.view.LoginView;
import com.example.app.view.ProfileView;
import com.example.app.view.SignInView;

public class MemberManager extends JFrame {

	private LoginView loginView;
	private SignInView signInView;
	private ProfileView profileView;

	CardLayout cardLayout;
	Container container;

	public MemberManager() {
		super("회원관리 프로그램");
		init();
		setContentPane();
		setFrame();
	}

	private void init() {
		container = getContentPane();
		cardLayout = new CardLayout();
	}

	private void setContentPane() {
		container.setLayout(cardLayout);

		loginView = new LoginView(cardLayout, container); // LoginView 클래스 객체 생성// frame 필요하면 매개변수 this
		container.add(loginView.getView(), LoginView.VIEW_NAME); // 로그인패널 객체 호출해서 컨테이너에 조립

		signInView = new SignInView(cardLayout, container);
		container.add(signInView.getView(), SignInView.VIEW_NAME);

		profileView = new ProfileView(cardLayout, container);
		container.add(profileView.getView(), ProfileView.VIEW_NAME);
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(360, 600);
		setLocationByPlatform(true);

		cardLayout.show(container, LoginView.VIEW_NAME); // 프로그램 시작 첫화면

		setVisible(true);
	}

	public static void main(String[] args) {

		new MemberManager();

	}

}
