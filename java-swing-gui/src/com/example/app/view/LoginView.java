package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.example.app.MemberManager;
import com.example.domain.MemberVO;
import com.example.domain.SharedData;
import com.example.repository.MemberDAO;

public class LoginView implements Viewable { // panelLogin 패널에 다 넣기

	public static final String VIEW_NAME = "login";
	public static final int WIDTH = 340;
	public static final int HEIGHT = 350;
	
	private MemberDAO memberDAO = MemberDAO.getInstance();

	private CardLayout cardLayout;
	private Container container;
	private JPanel panelLogin;
	private MemberManager frame;

	private JLabel lblLoginId;
	private JLabel lblLoginPasswd;
	private JTextField tfLoginId;
	private JPasswordField pfLoginPasswd;
	private JLabel lblWrongUser;
	private JButton btnLogin;
	private JButton btnSignIn;

	public LoginView(CardLayout cardLayout, Container container, MemberManager frame) { // 프레임 필요하면 , MemberManager
																						// frame 추가해서
		this.cardLayout = cardLayout;
		this.container = container;
		this.frame = frame;

		init(); // 멤버초기화 메소드
		setComponents(); // 화면 구성
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelLogin;
	}

	private void init() {
		panelLogin = new JPanel();

		lblLoginId = new JLabel("아이디");
		lblLoginPasswd = new JLabel("비밀번호");
		tfLoginId = new JTextField();
		pfLoginPasswd = new JPasswordField();
		lblWrongUser = new JLabel("");
		btnLogin = new JButton("로그인");
		btnSignIn = new JButton("회원가입");
	}

	private void setComponents() {
		this.panelLogin.setLayout(null);
//		this.panelLogin.setPreferredSize(new Dimension(329, 293));

		this.lblLoginId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblLoginId.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblLoginId.setBounds(62, 61, 57, 15);
		this.panelLogin.add(this.lblLoginId);

		this.tfLoginId.setBounds(131, 58, 127, 21);
		this.tfLoginId.setColumns(10);
		this.panelLogin.add(this.tfLoginId);

		this.lblLoginPasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblLoginPasswd.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblLoginPasswd.setBounds(62, 104, 57, 15);
		this.panelLogin.add(this.lblLoginPasswd);

		this.pfLoginPasswd.setBounds(133, 101, 127, 21);
		this.panelLogin.add(this.pfLoginPasswd);

		this.lblWrongUser.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblWrongUser.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblWrongUser.setForeground(Color.RED);
		this.lblWrongUser.setBounds(12, 136, 307, 15);
		this.panelLogin.add(this.lblWrongUser);

		this.btnLogin.setForeground(Color.WHITE);
		this.btnLogin.setFont(new Font("굴림", Font.PLAIN, 12));
		this.btnLogin.setBackground(new Color(51, 204, 51));
		this.btnLogin.setBounds(62, 174, 196, 50);
		this.panelLogin.add(this.btnLogin);

		this.btnSignIn.setBounds(113, 234, 97, 23);
		this.btnSignIn.setBackground(new Color(255, 255, 255));
		this.btnSignIn.setFont(new Font("굴림", Font.PLAIN, 12));
		this.panelLogin.add(this.btnSignIn);
	}

	private void addListener() {
		btnLogin.addActionListener(e -> {
			processLogin();
		});

		btnSignIn.addActionListener(e -> {
			goToSignInView();
			initializeLogin();
		});

		tfLoginId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblWrongUser.setText("");
			}
		});

		pfLoginPasswd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					processLogin();
			}
		});

	} // end of addListener



	private void processLogin() {
		String id = tfLoginId.getText().trim();
		String passwd = new String(pfLoginPasswd.getPassword());
		MemberVO member = memberDAO.getMemberById(id);

		if (id.length() > 0) {
			if (passwd.length() > 0) {
				if (memberDAO.getCountById(id) > 0) {
					if (passwd.equals(member.getPasswd())) {

						if (id.equals("admin")) {
							goToAdminView();

						} else {
							ProfileView profileView = (ProfileView) SharedData.MAP.get("profileView");
							profileView.paintProfile(member);

							goToProfileView();

						}

						initializeLogin();
					} else
						lblWrongUser.setText("잘못된 비밀번호입니다.");

				} else
					lblWrongUser.setText("가입하지 않은 아이디입니다.");

			} else
				lblWrongUser.setText("비밀번호를 입력해 주세요.");

		} else
			lblWrongUser.setText("아이디를 입력해주세요.");

	}

	private void goToAdminView() {
		frame.setSize(700, 350);
		cardLayout.show(container, AdminView.VIEW_NAME);
	}

	private void goToProfileView() {
		frame.setSize(ProfileView.WIDTH, ProfileView.HEIGHT);
		cardLayout.show(container, ProfileView.VIEW_NAME);
	}
	
	private void goToSignInView() {
		frame.setSize(SignInView.WIDTH, SignInView.HEIGHT);
		cardLayout.show(container, SignInView.VIEW_NAME);
	}

	private void initializeLogin() {
		tfLoginId.setText("");
		pfLoginPasswd.setText("");
		lblWrongUser.setText("");
	}

}
