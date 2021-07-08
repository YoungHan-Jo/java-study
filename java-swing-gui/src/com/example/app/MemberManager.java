package com.example.app;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.app.view.AdminView;
import com.example.app.view.LoginView;
import com.example.app.view.ProfileView;
import com.example.app.view.SignInView;
import com.example.domain.SharedData;

public class MemberManager extends JFrame {

	private LoginView loginView;
	private SignInView signInView;
	private ProfileView profileView;
	private AdminView adminView;

	CardLayout cardLayout;
	Container container;

	JMenuItem item;

	public MemberManager() {
		super("회원관리 프로그램");
		init();
		setMenu();
		setContentPane();
		addListener();
		setFrame();
	}

	private void init() {
		container = getContentPane();
		cardLayout = new CardLayout();
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("파일");

		item = new JMenuItem("끝내기");

		menu1.add(item);

		JMenu menu2 = new JMenu("도움말");

		JMenuItem item1 = new JMenuItem("도움말 보기");
		JMenuItem item2 = new JMenuItem("피드백 보내기");
		JMenuItem item3 = new JMenuItem("메모장 정보");

		menu2.add(item1);
		menu2.add(item2);
		menu2.add(item3);

		menuBar.add(menu1);
		menuBar.add(menu2);

		setJMenuBar(menuBar);
	}

	private void setContentPane() {
		container.setLayout(cardLayout);

		loginView = new LoginView(cardLayout, container, this); // LoginView 클래스 객체 생성// frame 필요하면 매개변수 this
		container.add(loginView.getView(), LoginView.VIEW_NAME); // 로그인패널 객체 호출해서 컨테이너에 조립

		signInView = new SignInView(cardLayout, container, this);
		container.add(signInView.getView(), SignInView.VIEW_NAME);

		profileView = new ProfileView(cardLayout, container, this);
		container.add(profileView.getView(), ProfileView.VIEW_NAME);
		SharedData.saveAsMap("profileView", profileView);

		adminView = new AdminView(cardLayout, container, this);
		container.add(adminView.getView(), AdminView.VIEW_NAME);

	}

	private void addListener() {
		item.addActionListener(e -> {
			System.exit(0);
		});
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LoginView.WIDTH, LoginView.HEIGHT);
		setLocationByPlatform(true);

		cardLayout.show(container, LoginView.VIEW_NAME); // 프로그램 시작 첫화면

		setVisible(true);
	}

	public static void main(String[] args) {

		new MemberManager();

	}

}
