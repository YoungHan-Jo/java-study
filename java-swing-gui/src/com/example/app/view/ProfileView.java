package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.example.app.MemberManager;
import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;
import java.awt.SystemColor;

public class ProfileView implements Viewable {

	public static final String VIEW_NAME = "profile";
	public static final int WIDTH = 340;
	public static final int HEIGHT = 550;

	private MemberDAO memberDAO = MemberDAO.getInstance();

	private CardLayout cardLayout;
	private Container container;
	private MemberManager frame;

	private JPanel panelProfile;

	private JLabel lblProfile;
	private JLabel lblProfileId;
	private JLabel lblGetId;
	private JLabel lblProfilePasswd;
	private JLabel lblGetPasswd;
	private JLabel lblProfileName;
	private JLabel lblGetName;
	private JLabel lblProfileEmail;
	private JLabel lblGetEmail;
	private JLabel lblProfileRecvEmail;
	private JLabel lblGetRecvEmail;
	private JLabel lblProfileTimpstamp;
	private JLabel lblGetTimestamp;
	private JButton btnUpdateProfile;
	private JButton btnLogout;
	private JButton btnDeleteUser;

	public ProfileView(CardLayout cardLayout, Container container, MemberManager frame) {
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelProfile;
	}

	private void init() {
		panelProfile = new JPanel();

		lblProfile = new JLabel("회원 정보");
		lblProfileId = new JLabel("아이디");
		lblProfilePasswd = new JLabel("비밀번호");
		lblProfileName = new JLabel("이름");
		lblProfileEmail = new JLabel("이메일");
		lblProfileRecvEmail = new JLabel("메일수신");
		lblProfileTimpstamp = new JLabel("가입일");
		btnUpdateProfile = new JButton("회원정보 수정");
		
		btnLogout = new JButton("로그아웃");
		
		btnDeleteUser = new JButton("회원 탈퇴");
		
		initializeProfile();

	}

	private void initializeProfile() {
		lblGetId = new JLabel("");
		lblGetPasswd = new JLabel("");
		lblGetName = new JLabel("");
		lblGetEmail = new JLabel("");
		lblGetRecvEmail = new JLabel("");
		lblGetTimestamp = new JLabel("");
	}
	
	public void paintProfile(MemberVO member) {
		lblGetId.setText(member.getId());
		lblGetPasswd.setText(member.getPasswd());
		lblGetName.setText(member.getName());
		lblGetEmail.setText(member.getEmail());
		lblGetRecvEmail.setText(member.getRecvEmail());
		lblGetTimestamp.setText(String.valueOf(member.getRegDate()));
	}

	private void setComponents() {
		this.panelProfile.setLayout(null);

		this.panelProfile.add(this.lblProfile);
		this.lblProfile.setBackground(new Color(255, 255, 255));
		this.lblProfile.setFont(new Font("굴림", Font.PLAIN, 20));
		this.lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblProfile.setBounds(81, 48, 165, 52);

		this.panelProfile.add(this.lblProfileId);
		this.lblProfileId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileId.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileId.setBounds(41, 110, 57, 15);

		this.panelProfile.add(this.lblProfilePasswd);
		this.lblProfilePasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfilePasswd.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfilePasswd.setBounds(41, 155, 57, 15);

		this.panelProfile.add(this.lblGetId);
		this.lblGetId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetId.setBounds(120, 110, 126, 15);

		this.panelProfile.add(this.lblGetPasswd);
		this.lblGetPasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetPasswd.setBounds(120, 155, 126, 15);

		this.panelProfile.add(this.lblProfileName);
		this.lblProfileName.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileName.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileName.setBounds(41, 199, 57, 15);

		this.panelProfile.add(this.lblProfileEmail);
		this.lblProfileEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileEmail.setBounds(41, 240, 57, 15);

		this.panelProfile.add(this.lblProfileRecvEmail);
		this.lblProfileRecvEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileRecvEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileRecvEmail.setBounds(41, 282, 57, 15);

		this.panelProfile.add(this.lblGetName);
		this.lblGetName.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetName.setBounds(120, 199, 126, 15);

		this.panelProfile.add(this.lblGetEmail);
		this.lblGetEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetEmail.setBounds(120, 240, 126, 15);

		this.panelProfile.add(this.lblGetRecvEmail);
		this.lblGetRecvEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetRecvEmail.setBounds(120, 282, 126, 15);

		this.panelProfile.add(this.btnUpdateProfile);
		this.btnUpdateProfile.setBackground(SystemColor.control);
		this.btnUpdateProfile.setBounds(104, 371, 115, 23);
		this.btnUpdateProfile.setFont(new Font("굴림", Font.PLAIN, 12));

		this.panelProfile.add(this.btnLogout);
		this.btnLogout.setBackground(Color.WHITE);
		this.btnLogout.setBounds(222, 10, 97, 23);
		this.btnLogout.setFont(new Font("굴림", Font.PLAIN, 12));

		this.panelProfile.add(this.lblProfileTimpstamp);
		this.lblProfileTimpstamp.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileTimpstamp.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileTimpstamp.setBounds(41, 326, 57, 15);

		this.panelProfile.add(this.lblGetTimestamp);
		this.lblGetTimestamp.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetTimestamp.setBounds(120, 326, 126, 15);
		
		this.btnDeleteUser.setBackground(SystemColor.control);
		this.btnDeleteUser.setFont(new Font("굴림", Font.PLAIN, 12));
		this.btnDeleteUser.setBounds(104, 404, 115, 23);
		this.panelProfile.add(btnDeleteUser);

	}

	private void addListener() {
		btnLogout.addActionListener(e -> {
			goToLoginView();
		});
		
		btnDeleteUser.addActionListener(e -> {
			memberDAO.deleteById(lblGetId.getText());
			goToLoginView();
			JOptionPane.showMessageDialog(frame, "탈퇴했습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
		});
	}

	private void goToLoginView() {
		frame.setSize(LoginView.WIDTH, LoginView.HEIGHT);
		cardLayout.show(container, LoginView.VIEW_NAME);
	}
	
}
