package com.example.app;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.example.app.view.MainView;

public class StoreManager extends JFrame {

	private MainView mainView;

	CardLayout cardLayout;
	Container container;

	public StoreManager() {
		super("점포 매출관리 프로그램");
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
		mainView = new MainView(cardLayout, container, this);
		container.add(mainView.getView(), MainView.VIEW_NAME);
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(MainView.WIDTH, MainView.HEIGHT);
		setLocationByPlatform(true);

		cardLayout.show(container, MainView.VIEW_NAME);

		setVisible(true);
	}

	public static void main(String[] args) {
		new StoreManager();
	}

}
