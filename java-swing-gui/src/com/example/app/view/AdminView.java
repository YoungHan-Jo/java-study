package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

public class AdminView extends JFrame implements Viewable {
	public static final String VIEW_NAME = "admin";

	private MemberDAO memberDAO = MemberDAO.getInstance();

	private Vector<String> columnNames;

	private CardLayout cardLayout;
	private Container container;

	private JPanel panelAdmin;
	private JPanel panelNorth;
	private JPanel panelWest;
	private JPanel panelSouth;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblUpdateId;
	private JTextField tfUpdateId;
	private JLabel lblUpdatePasswd;
	private JTextField tfUpdatePasswd;
	private JLabel lblUpdateName;
	private JTextField tfUpdateName;
	private JLabel lblUpdateEmail;
	private JTextField tfUpdateEmail;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private ButtonGroup buttonGroup;
	private JButton btnShowTotal;
	private JButton btnInsertUser;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel_5;
	private JButton btnLogout;

	private JTable table;

	public AdminView(CardLayout cardLayout, Container container) {
		this.cardLayout = cardLayout;
		this.container = container;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelAdmin;
	}

	private void init() {
		panelAdmin = new JPanel();

		columnNames = new Vector<>();
		columnNames.add("아이디");
		columnNames.add("비밀번호");
		columnNames.add("이름");
		columnNames.add("이메일");
		columnNames.add("메일수신여부");
		columnNames.add("가입날짜");

		panelNorth = new JPanel();
		panelWest = new JPanel();
		panelSouth = new JPanel();

		lblNewLabel = new JLabel("관리자 계정 - 회원정보 수정");

		panel = new JPanel();
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		panel_4 = new JPanel();

		lblUpdateId = new JLabel("ID");
		tfUpdateId = new JTextField();
		lblUpdatePasswd = new JLabel("P/W");
		tfUpdatePasswd = new JTextField();
		lblUpdateName = new JLabel("Name");
		tfUpdateName = new JTextField();
		lblUpdateEmail = new JLabel("Email");
		tfUpdateEmail = new JTextField();

		panel_5 = new JPanel();
		lblNewLabel_5 = new JLabel("메일수신");
		panel_6 = new JPanel();
		buttonGroup = new ButtonGroup();
		rdbtnNewRadioButton = new JRadioButton("예");
		rdbtnNewRadioButton_1 = new JRadioButton("아니오");

		btnShowTotal = new JButton("전체보기");
		btnInsertUser = new JButton("추가");
		btnUpdateUser = new JButton("수정");
		btnDeleteUser = new JButton("삭제");
		btnLogout = new JButton("로그아웃");

		table = new JTable(null, columnNames);
	}

	private void setComponents() {
		this.panelAdmin.setLayout(new BorderLayout());

		container.add(this.panelNorth, BorderLayout.NORTH);
		this.panelNorth.add(this.lblNewLabel);

		container.add(this.panelWest, BorderLayout.WEST);
		this.panelWest.setLayout(new GridLayout(5, 1, 0, 0));

		this.panelWest.add(this.panel);
		this.panel.setLayout(new GridLayout(2, 1, 0, 0));
		this.lblUpdateId.setHorizontalAlignment(SwingConstants.CENTER);

		this.panel.add(this.lblUpdateId);

		this.panel.add(this.tfUpdateId);

		this.panelWest.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		this.lblUpdatePasswd.setHorizontalAlignment(SwingConstants.CENTER);

		this.panel_1.add(this.lblUpdatePasswd);

		this.panel_1.add(this.tfUpdatePasswd);

		this.panelWest.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		this.lblUpdateName.setHorizontalAlignment(SwingConstants.CENTER);

		this.panel_2.add(this.lblUpdateName);

		this.panel_2.add(this.tfUpdateName);

		this.panelWest.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		this.lblUpdateEmail.setHorizontalAlignment(SwingConstants.CENTER);

		this.panel_3.add(this.lblUpdateEmail);

		this.panel_3.add(this.tfUpdateEmail);

		this.panelWest.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_4.add(this.panel_5);

		this.panel_5.add(this.lblNewLabel_5);
		this.panel_6.setBackground(SystemColor.window);

		this.panel_4.add(this.panel_6);
		this.rdbtnNewRadioButton.setBackground(SystemColor.window);
		this.panel_6.add(this.rdbtnNewRadioButton);
		this.buttonGroup.add(this.rdbtnNewRadioButton);
		this.rdbtnNewRadioButton_1.setBackground(SystemColor.window);
		this.panel_6.add(this.rdbtnNewRadioButton_1);
		this.buttonGroup.add(this.rdbtnNewRadioButton_1);

		container.add(new JScrollPane(table), BorderLayout.CENTER);
		// 화면 갱신

		container.add(this.panelSouth, BorderLayout.SOUTH);
		this.panelSouth.add(this.btnShowTotal);
		this.panelSouth.add(this.btnInsertUser);
		this.panelSouth.add(this.btnUpdateUser);
		this.panelSouth.add(this.btnDeleteUser);
		this.panelSouth.add(this.btnLogout);

		setVisible(true);
	}

	private void addListener() {
		btnShowTotal.addActionListener(e -> {
			showTotal();
		});
	}

	private void showTotal() {
		List<MemberVO> list = memberDAO.getMembers();

		// 벡터로 2차배열처럼 만들기. 벡터안에 벡터
		// List<MemberVO> - > Vector<Vector<Object>> 로 변환하기

		Vector<Vector<Object>> vector = new Vector<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

		for (MemberVO member : list) {
			Vector<Object> rowVector = new Vector<>();
			rowVector.add(member.getId());
			rowVector.add(member.getPasswd());
			rowVector.add(member.getName());
			rowVector.add(member.getEmail());
			rowVector.add(member.getRecvEmail());
			rowVector.add(sdf.format(member.getRegDate()));
		}

	}

}
