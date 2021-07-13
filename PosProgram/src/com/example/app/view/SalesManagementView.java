package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JPanel;

import com.example.app.StoreManager;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class SalesManagementView implements Viewable {

	public static final String VIEW_NAME = "sales management";

	private CardLayout cardLayout;
	private Container container;
	private StoreManager frame;

	private JPanel panelSalesManagement;
	private JPanel panelLeft;
	private JPanel panelRight;

	public SalesManagementView(CardLayout cardLayout, Container container, StoreManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelSalesManagement;
	}

	private void init() {
		
		panelSalesManagement = new JPanel();
		panelSalesManagement.setLayout(new BorderLayout(0, 0));
		panelSalesManagement.setSize(850, 1200);
		
		panelLeft = new JPanel();
		panelSalesManagement.add(panelLeft, BorderLayout.WEST);
		
		panelRight = new JPanel();
		panelSalesManagement.add(panelRight, BorderLayout.CENTER);
		
	}

	private void setComponents() {

	}

	private void addListener() {

	}

}
