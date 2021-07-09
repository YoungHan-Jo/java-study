package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JPanel;

import com.example.app.StoreManager;

public class MainView implements Viewable {

	public static final String VIEW_NAME = "main";
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;
	private JPanel panelMain;

	public MainView(CardLayout cardLayout, Container container, StoreManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelMain;
	}

	private void init() {
		panelMain = new JPanel();
	}

	private void setComponents() {
	}

	private void addListener() {
	}

}
