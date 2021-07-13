package com.example.app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.app.view.MainView;
import com.example.app.view.SalesManagementView;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class StoreManager extends JFrame implements Runnable {

	public static final int WIDTH = 1160;
	public static final int HEIGHT = 700;

	private MainView mainView;
	private SalesManagementView salesManagementView;

	private Thread thread;

	private CardLayout cardLayout;
	private Container container;
	private JPanel panelHeader;
	private JPanel panelFooter;
	private JPanel panelBody;
	private JLabel lblTitle;
	private JLabel lblCurrentTime;
	private JPanel panelFooterCenter;
	private JPanel panelFooterRight;
	private JButton btnLogout;
	private JPanel panelFooterLeft;
	private JButton btnOpenStore;
	private JButton btnSalesManagement;
	private JButton btnGoToMain;
	private JButton btnCloseStore;

	@Override
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "년 "
					+ ((cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1)
							: (cal.get(Calendar.MONTH) + 1))
					+ "월 " + (cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE))
					+ "일 "
					+ (cal.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + cal.get(Calendar.HOUR_OF_DAY)
							: cal.get(Calendar.HOUR_OF_DAY))
					+ "시" + (cal.get(Calendar.MINUTE) < 10 ? "0" + cal.get(Calendar.MINUTE) : cal.get(Calendar.MINUTE))
					+ "분" + (cal.get(Calendar.SECOND) < 10 ? "0" + cal.get(Calendar.SECOND) : cal.get(Calendar.SECOND))
					+ "초 ";
			lblCurrentTime.setText(now);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public StoreManager() {
		super("점포 매출관리 프로그램");
		init();
		setContentPane();
		addListener();
		setFrame();
	}

	private void init() {
		container = getContentPane();
		cardLayout = new CardLayout();

		mainView = new MainView(cardLayout, container, this);
		salesManagementView = new SalesManagementView(cardLayout, container, this);

		lblCurrentTime = new JLabel("");

		panelBody = new JPanel();

		panelHeader = new JPanel();
		lblTitle = new JLabel("POS");
		panelFooter = new JPanel();
		panelFooter.setLayout(new BorderLayout(0, 0));

		panelFooterCenter = new JPanel();
		panelFooter.add(panelFooterCenter, BorderLayout.CENTER);

		btnGoToMain = new JButton("메인으로");
		panelFooterCenter.add(btnGoToMain);

		panelFooterRight = new JPanel();
		panelFooter.add(panelFooterRight, BorderLayout.EAST);

		btnCloseStore = new JButton("영업마감");
		panelFooterRight.add(btnCloseStore);

		btnLogout = new JButton("로그아웃");
		panelFooterRight.add(btnLogout);

		panelFooterLeft = new JPanel();
		panelFooter.add(panelFooterLeft, BorderLayout.WEST);

		btnOpenStore = new JButton("영업시작");
		panelFooterLeft.add(btnOpenStore);

		btnSalesManagement = new JButton("매출관리");
		panelFooterLeft.add(btnSalesManagement);

	}

	private void setContentPane() {
		setClock();

		container.add(panelBody, BorderLayout.CENTER);

		panelBody.setLayout(cardLayout);
		panelBody.add(mainView.getView(), MainView.VIEW_NAME);
		panelBody.add(salesManagementView.getView(), SalesManagementView.VIEW_NAME);

		container.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));

		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		panelHeader.add(lblTitle, BorderLayout.CENTER);
		panelHeader.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		lblCurrentTime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCurrentTime.setFont(new Font("굴림", Font.BOLD, 15));
		panelHeader.add(lblCurrentTime, BorderLayout.EAST);

		container.add(panelFooter, BorderLayout.SOUTH);
	}

	private void setClock() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	private void addListener() {
		btnSalesManagement.addActionListener(e -> {
			cardLayout.show(panelBody, SalesManagementView.VIEW_NAME);
		});

		btnGoToMain.addActionListener(e -> {
			cardLayout.show(panelBody, MainView.VIEW_NAME);
		});
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationByPlatform(true);

		cardLayout.show(panelBody, MainView.VIEW_NAME);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StoreManager();
	}

}
