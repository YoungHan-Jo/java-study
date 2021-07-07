package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.app.MemberManager;
import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import java.awt.Font;

public class AdminView extends JFrame implements Viewable {

	public static final String VIEW_NAME = "admin";

	private MemberDAO memberDAO = MemberDAO.getInstance();

	private CardLayout cardLayout;
	private Container container;
	private MemberManager frame;

	private JPanel panelAdmin;
	private JPanel panelNorth;
	private JPanel panelWest;
	private JPanel panelSouth;
	private JLabel lblUserManager;
	private JPanel panelUpdateId;
	private JPanel panelUpdatePasswd;
	private JPanel panelUpdateName;
	private JPanel panelUpdateEmail;
	private JPanel panelUpdateRecvEmail;
	private JLabel lblUpdateId;
	private JTextField tfUpdateId;
	private JLabel lblUpdatePasswd;
	private JTextField tfUpdatePasswd;
	private JLabel lblUpdateName;
	private JTextField tfUpdateName;
	private JLabel lblUpdateEmail;
	private JLabel lblUpdateRecvEmail;
	private JTextField tfUpdateEmail;
	private JPanel panel;
	private JRadioButton rdbtnRecvYes;
	private JRadioButton rdbtnRecvNo;
	private JButton btnShowTotal;
	private JButton btnInsertUser;
	private JButton btnUpdateUser;
	private JButton btnDeleteUser;
	private ButtonGroup g;
	private JButton btnLogout;

	private JTable table;

	public AdminView(CardLayout cardLayout, Container container, MemberManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

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

		panelNorth = new JPanel();
		lblUserManager = new JLabel("관리자 계정 - 회원관리");

		panelWest = new JPanel();

		panelUpdateId = new JPanel();
		tfUpdateId = new JTextField();
		lblUpdateId = new JLabel("ID");

		panelUpdatePasswd = new JPanel();
		lblUpdatePasswd = new JLabel("P/W");
		tfUpdatePasswd = new JTextField();

		panelUpdateName = new JPanel();
		lblUpdateName = new JLabel("NAME");
		tfUpdateName = new JTextField();

		panelUpdateEmail = new JPanel();
		lblUpdateEmail = new JLabel("EMAIL");
		tfUpdateEmail = new JTextField();

		panelUpdateRecvEmail = new JPanel();
		lblUpdateRecvEmail = new JLabel("메일 수신");
		panel = new JPanel();
		g = new ButtonGroup();
		rdbtnRecvYes = new JRadioButton("예");
		rdbtnRecvNo = new JRadioButton("아니오");

		panelSouth = new JPanel();
		btnShowTotal = new JButton("전체 보기");
		btnInsertUser = new JButton("추가");
		btnUpdateUser = new JButton("수정");
		btnDeleteUser = new JButton("삭제");
		btnLogout = new JButton("로그아웃");

	}

	private void setComponents() {
		panelAdmin.setLayout(new BorderLayout());

		panelAdmin.add(this.panelNorth, BorderLayout.NORTH);
		panelNorth.add(lblUserManager);
		lblUserManager.setFont(new Font("굴림", Font.BOLD, 15));

		panelAdmin.add(this.panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(5, 1, 0, 0));

		panelWest.add(panelUpdateId);
		panelUpdateId.setLayout(new GridLayout(2, 1, 0, 0));
		lblUpdateId.setHorizontalAlignment(SwingConstants.CENTER);

		panelUpdateId.add(this.lblUpdateId);

		panelUpdateId.add(this.tfUpdateId);

		panelWest.add(panelUpdatePasswd);
		panelUpdatePasswd.setLayout(new GridLayout(2, 1, 0, 0));

		lblUpdatePasswd.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdatePasswd.add(lblUpdatePasswd);

		panelUpdatePasswd.add(tfUpdatePasswd);
		tfUpdatePasswd.setColumns(10);

		panelWest.add(panelUpdateName);
		panelUpdateName.setLayout(new GridLayout(2, 1, 0, 0));

		lblUpdateName.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdateName.add(lblUpdateName);

		panelUpdateName.add(tfUpdateName);
		tfUpdateName.setColumns(10);

		panelWest.add(panelUpdateEmail);
		panelUpdateEmail.setLayout(new GridLayout(2, 1, 0, 0));

		lblUpdateEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdateEmail.add(lblUpdateEmail);

		tfUpdateEmail.setColumns(10);
		panelUpdateEmail.add(tfUpdateEmail);

		panelWest.add(panelUpdateRecvEmail);
		panelUpdateRecvEmail.setLayout(new GridLayout(2, 1, 0, 0));

		lblUpdateRecvEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdateRecvEmail.add(lblUpdateRecvEmail);

		panel.setBackground(Color.WHITE);
		panelUpdateRecvEmail.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.g.add(rdbtnRecvYes);
		this.g.add(rdbtnRecvNo);

		rdbtnRecvYes.setBackground(Color.WHITE);
		panel.add(rdbtnRecvYes);
		rdbtnRecvNo.setBackground(Color.WHITE);
		rdbtnRecvNo.setSelected(true);
		panel.add(rdbtnRecvNo);

		panelAdmin.add(this.panelSouth, BorderLayout.SOUTH);
		panelSouth.add(btnShowTotal);
		panelSouth.add(btnInsertUser);
		panelSouth.add(btnUpdateUser);
		panelSouth.add(btnDeleteUser);
		panelSouth.add(btnLogout);

	}

	private void addListener() {
		btnShowTotal.addActionListener(e -> {
			showTotal();
		});

		btnInsertUser.addActionListener(e -> {
			insertUser();
			showTotal();
		});

		btnUpdateUser.addActionListener(e -> {
			updateUser();
			showTotal();
		});

		btnDeleteUser.addActionListener(e -> {
			deleteUser();
			showTotal();
		});

		btnLogout.addActionListener(e -> {
			goToLoginView();
			initializeUpdate();
		});
	}

	private void goToLoginView() {
		table.setVisible(false);
		frame.setSize(LoginView.WIDTH, LoginView.HEIGHT);
		cardLayout.show(container, LoginView.VIEW_NAME);
	}

	private void deleteUser() {
		String id = tfUpdateId.getText();
		memberDAO.deleteById(id);
		JOptionPane.showMessageDialog(frame, id + "계정을 삭제했습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
		initializeUpdate();
	}

	private void updateUser() {
		String id = tfUpdateId.getText();

		if (memberDAO.getCountById(id) > 0) {
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPasswd(tfUpdatePasswd.getText());
			member.setName(tfUpdateName.getText());
			member.setEmail(tfUpdateEmail.getText());
			member.setRecvEmail(rdbtnRecvYes.isSelected() ? "Y" : "N");
			member.setRegDate(memberDAO.getMemberById(id).getRegDate());

			memberDAO.updateById(id, member);
			JOptionPane.showMessageDialog(frame, id + "계정을 수정했습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
			initializeUpdate();
		} else {
			JOptionPane.showMessageDialog(panelAdmin, "수정할 내용을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void insertUser() {
		MemberVO member = new MemberVO();
		String id = tfUpdateId.getText().trim();
		String passwd = tfUpdatePasswd.getText();
		String name = tfUpdateName.getText().trim();
		String email = tfUpdateEmail.getText().trim();
		String recvEmail = rdbtnRecvYes.isSelected() ? "Y" : "N";

		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		member.setRecvEmail(recvEmail);
		member.setRegDate(new Timestamp(System.currentTimeMillis()));

		memberDAO.insert(member);
		JOptionPane.showMessageDialog(frame, id + "계정을 추가했습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
		initializeUpdate();
		showTotal();
	}

	private void initializeUpdate() {
		tfUpdateId.setText("");
		tfUpdatePasswd.setText("");
		tfUpdateName.setText("");
		tfUpdateEmail.setText("");
		rdbtnRecvNo.setSelected(true);
	}

	private void showTotal() {

		List<MemberVO> list = memberDAO.getMembers();

		Vector<Vector<Object>> vector = new Vector<>();

		for (MemberVO member : list) {
			Vector<Object> rowVector = new Vector<>();
			rowVector.add(member.getId());
			rowVector.add(member.getPasswd());
			rowVector.add(member.getName());
			rowVector.add(member.getEmail());
			rowVector.add(member.getRecvEmail());
			rowVector.add(member.getRegDate());

			vector.add(rowVector);
		}

		Vector<String> columnNames = new Vector<>();
		columnNames.add("아이디");
		columnNames.add("비밀번호");
		columnNames.add("이름");
		columnNames.add("이메일");
		columnNames.add("메일수신");
		columnNames.add("가입날짜");

		table = new JTable(vector, columnNames);

		panelAdmin.add(new JScrollPane(table), BorderLayout.CENTER);

		frame.setVisible(true);
	}
}
