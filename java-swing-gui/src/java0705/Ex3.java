package java0705;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;

import javax.swing.SwingConstants;

public class Ex3 extends JFrame {

	private MemberDAO dao = MemberDAO.getInstance();

	private Container c;

	private CardLayout cardLayout = new CardLayout(0, 0);

	private final JPanel panel1 = new JPanel();
	private final JPanel panel2 = new JPanel();
	private final JPanel panel3 = new JPanel();

	private final JLabel lblSignInId = new JLabel("아이디");
	private final JTextField tfSignInId = new JTextField();
	private final JLabel lblWrongId = new JLabel("");
	private final JLabel lblSignInPasswd1 = new JLabel("비밀번호");
	private final JPasswordField pfSignInPasswd1 = new JPasswordField();
	private final JLabel lblWrongPasswd1 = new JLabel("");
	private final JLabel lblSignInPasswd2 = new JLabel("비밀번호 재확인");
	private final JPasswordField pfSignInPasswd2 = new JPasswordField();
	private final JLabel lblWrongPasswd2 = new JLabel("");
	private final JLabel lblSignInName = new JLabel("이름");
	private final JTextField tfSignInName = new JTextField();
	private final JLabel lblSignInEmail = new JLabel("이메일");
	private final JTextField tfSignInEmail = new JTextField();
	private final JLabel tfRecvEmail = new JLabel("메일 수신");
	private final ButtonGroup g = new ButtonGroup();
	private final JRadioButton rdbtnRecvYes = new JRadioButton("예");
	private final JRadioButton rdbtnRecvNo = new JRadioButton("아니오");
	private final JButton btnInsertAccount = new JButton("가입하기");

	private final JLabel lblLoginId = new JLabel("아이디");
	private final JLabel lblLoginPasswd = new JLabel("비밀번호");
	private final JTextField tfLoginId = new JTextField();
	private final JPasswordField pfLoginPasswd = new JPasswordField();
	private final JLabel lblWrongUser = new JLabel("");
	private final JButton btnLogin = new JButton("로그인");
	private final JButton btnSignIn = new JButton("회원가입");

	private final JLabel lblProfile = new JLabel("회원 정보");
	private final JLabel lblProfileId = new JLabel("아이디");
	private final JLabel lblGetId = new JLabel("");
	private final JLabel lblProfilePasswd = new JLabel("비밀번호");
	private final JLabel lblGetPasswd = new JLabel("");
	private final JLabel lblProfileName = new JLabel("이름");
	private final JLabel lblGetName = new JLabel("");
	private final JLabel lblProfileEmail = new JLabel("이메일");
	private final JLabel lblGetEmail = new JLabel("");
	private final JLabel lblProfileRecvEmail = new JLabel("메일수신");
	private final JLabel lblGetRecvEmail = new JLabel("");
	private final JLabel lblProfileTimpstamp = new JLabel("가입일");
	private final JLabel lblGetTimestamp = new JLabel("");
	private final JButton btnUpdateProfile = new JButton("회원정보 수정");
	private final JButton btnLogout = new JButton("로그아웃");

	public Ex3() {

		super("계정 데이터베이스연동");
		init();
		setComponents();
		addListener();
		setFrame();
	}

	private void init() {
		setupViewSignIn();
		setupViewLogin();
		setupViewProfile();
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(cardLayout);
		this.panel1.setBackground(new Color(255, 255, 255));
		c.add(this.panel1, "sign in");
		this.panel2.setBackground(new Color(255, 255, 255));
		c.add(this.panel2, "login");
		this.panel3.setBackground(new Color(255, 255, 255));
		c.add(this.panel3, "profile");

	}

	private void addListener() {

		btnInsertAccount.addActionListener(e -> {
			insertAccount();
		});

		btnLogin.addActionListener(e -> {
			login();
		});

		pfLoginPasswd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});

		btnSignIn.addActionListener(e -> {
			cardLayout.show(c, "sign in");
			Ex3.this.setSize(347, 593);
		});

		tfSignInId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String signInId = tfSignInId.getText().trim();

				int count = dao.getCountById(signInId);

				if (count > 0) {
					lblWrongId.setText("이미 사용중이거나 탈퇴한 아이디입니다.");
					lblWrongId.setForeground(Color.red);
				} else {
					lblWrongId.setText("멋진 아이디네요!");
					lblWrongId.setForeground(Color.GREEN);
				}
			}
		});

		btnLogout.addActionListener(e -> {
			cardLayout.show(c, "login");
		});

		pfSignInPasswd1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				JTextField tf = (JTextField) e.getSource();
				int num = tf.getText().length();
				if (num < 4) {
					lblWrongPasswd1.setText("4자 이상 입력해주세요");
				} else {
					lblWrongPasswd1.setText("");
				}
			}
		});

		pfSignInPasswd2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField tf = (JTextField) e.getSource();
				String passwd2 = tf.getText();

				String passwd1 = new String(pfSignInPasswd1.getPassword());

				if (passwd1.equals(passwd2)) {
					lblWrongPasswd2.setText("");
				} else {
					lblWrongPasswd2.setText("비밀번호가 일치하지 않습니다.");
				}
			}
		});
	}

	private void insertAccount() {
		MemberVO member = new MemberVO();
		String id = tfSignInId.getText().trim();
		String passwd = new String(pfSignInPasswd1.getPassword());
		String name = tfSignInName.getText().trim();
		String email = tfSignInEmail.getText().trim();
		String recvEmail = rdbtnRecvYes.isSelected() ? "Y" : "N";

		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);
		member.setRecvEmail(recvEmail);
		member.setRegDate(new Timestamp(System.currentTimeMillis()));

		dao.insert(member);

		cardLayout.show(c, "login");
		Ex3.this.setSize(347, 400);

		tfSignInId.setText("");
		lblWrongId.setText("");
		pfSignInPasswd1.setText("");
		pfSignInPasswd2.setText("");
		tfSignInName.setText("");
		tfSignInEmail.setText("");
		rdbtnRecvNo.setSelected(true);

	}

	private void login() {
		String id = tfLoginId.getText().trim();
		String passwd = new String(pfLoginPasswd.getPassword());

		if (dao.getCountById(id) > 0) {
			if (passwd.equals(dao.getMemberById(id).getPasswd())) {
				cardLayout.show(c, "profile");
				Ex3.this.setSize(347, 593);

				tfLoginId.setText("");
				pfLoginPasswd.setText("");
				lblWrongUser.setText("");

				paintProfile(id);

			} else
				lblWrongUser.setText("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		} else
			lblWrongUser.setText("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
	}

	private void paintProfile(String id) {
		MemberVO member = dao.getMemberById(id);

		lblGetId.setText(member.getId());
		lblGetPasswd.setText(member.getPasswd());
		lblGetName.setText(member.getName());
		lblGetEmail.setText(member.getEmail());
		String recvEmail;
		if (member.getRecvEmail() == "Y")
			recvEmail = "예";
		else
			recvEmail = "아니오";
		
		lblGetRecvEmail.setText(recvEmail);
		lblGetTimestamp.setText(String.valueOf(member.getRegDate()));
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(347, 595);
		setLocationByPlatform(true);

		cardLayout.show(c, "login");
		setVisible(true);
	}

	private void setupViewSignIn() {

		this.panel1.setLayout(null);
		this.panel1.add(this.lblSignInId);
		this.lblSignInId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInId.setBounds(65, 28, 57, 15);

		this.panel1.add(this.tfSignInId);
		this.tfSignInId.setBounds(65, 53, 203, 21);
		this.tfSignInId.setColumns(10);

		this.panel1.add(this.lblWrongId);
		this.lblWrongId.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongId.setForeground(Color.RED);
		this.lblWrongId.setBounds(65, 84, 203, 15);

		this.panel1.add(this.lblSignInPasswd1);
		this.lblSignInPasswd1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd1.setBounds(65, 109, 57, 15);

		this.panel1.add(this.pfSignInPasswd1);
		this.pfSignInPasswd1.setBounds(65, 134, 203, 21);

		this.panel1.add(this.lblWrongPasswd1);
		this.lblWrongPasswd1.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd1.setForeground(Color.RED);
		this.lblWrongPasswd1.setBounds(65, 165, 203, 15);

		this.panel1.add(this.lblSignInPasswd2);
		this.lblSignInPasswd2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd2.setBounds(65, 190, 116, 15);

		this.panel1.add(this.pfSignInPasswd2);
		this.pfSignInPasswd2.setBounds(65, 215, 203, 21);

		this.panel1.add(this.lblWrongPasswd2);
		this.lblWrongPasswd2.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd2.setForeground(Color.RED);
		this.lblWrongPasswd2.setBounds(65, 246, 203, 15);

		this.panel1.add(this.lblSignInName);
		this.lblSignInName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInName.setBounds(65, 271, 57, 15);

		this.panel1.add(this.tfSignInName);
		this.tfSignInName.setBounds(65, 296, 203, 21);
		this.tfSignInName.setColumns(10);

		this.panel1.add(this.lblSignInEmail);
		this.lblSignInEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInEmail.setBounds(65, 338, 57, 15);

		this.panel1.add(this.tfSignInEmail);
		this.tfSignInEmail.setBounds(65, 363, 203, 21);
		this.tfSignInEmail.setColumns(10);

		this.panel1.add(this.tfRecvEmail);
		this.tfRecvEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.tfRecvEmail.setBounds(65, 407, 57, 15);

		this.panel1.add(this.rdbtnRecvYes);
		this.rdbtnRecvYes.setBackground(new Color(255, 255, 255));
		this.rdbtnRecvYes.setBounds(65, 428, 62, 23);

		g.add(rdbtnRecvYes);
		g.add(rdbtnRecvNo);

		this.panel1.add(this.rdbtnRecvNo);
		this.rdbtnRecvNo.setBackground(new Color(255, 255, 255));
		this.rdbtnRecvNo.setSelected(true);
		this.rdbtnRecvNo.setBounds(147, 428, 121, 23);

		this.panel1.add(this.btnInsertAccount);
		this.btnInsertAccount.setFont(new Font("굴림", Font.PLAIN, 20));
		this.btnInsertAccount.setForeground(new Color(255, 255, 255));
		this.btnInsertAccount.setBackground(new Color(51, 204, 51));
		this.btnInsertAccount.setBounds(65, 477, 196, 50);

	}

	private void setupViewLogin() {
		this.panel2.setLayout(null);

		this.panel2.add(this.lblLoginId);
		this.lblLoginId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblLoginId.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblLoginId.setBounds(62, 61, 57, 15);

		this.panel2.add(this.tfLoginId);
		this.tfLoginId.setBounds(131, 58, 127, 21);
		this.tfLoginId.setColumns(10);

		this.panel2.add(this.lblLoginPasswd);
		this.lblLoginPasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblLoginPasswd.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblLoginPasswd.setBounds(62, 104, 57, 15);

		this.panel2.add(this.pfLoginPasswd);
		this.pfLoginPasswd.setBounds(133, 101, 127, 21);

		this.panel2.add(this.btnLogin);
		this.btnLogin.setForeground(Color.WHITE);
		this.btnLogin.setFont(new Font("굴림", Font.PLAIN, 12));
		this.btnLogin.setBackground(new Color(51, 204, 51));
		this.btnLogin.setBounds(62, 174, 196, 50);

		this.panel2.add(this.btnSignIn);
		this.btnSignIn.setBounds(113, 234, 97, 23);
		this.btnSignIn.setBackground(new Color(255, 255, 255));
		this.btnSignIn.setFont(new Font("굴림", Font.PLAIN, 12));
		
		this.panel2.add(this.lblWrongUser);
		this.lblWrongUser.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblWrongUser.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblWrongUser.setForeground(Color.RED);
		this.lblWrongUser.setBounds(12, 136, 307, 15);

	}

	private void setupViewProfile() {

		this.panel3.setLayout(null);

		this.panel3.add(this.lblProfile);
		this.lblProfile.setBackground(new Color(255, 255, 255));
		this.lblProfile.setFont(new Font("굴림", Font.PLAIN, 20));
		this.lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblProfile.setBounds(81, 48, 165, 52);

		this.panel3.add(this.lblProfileId);
		this.lblProfileId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileId.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileId.setBounds(41, 110, 57, 15);

		this.panel3.add(this.lblProfilePasswd);
		this.lblProfilePasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfilePasswd.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfilePasswd.setBounds(41, 155, 57, 15);

		this.panel3.add(this.lblGetId);
		this.lblGetId.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetId.setBounds(120, 110, 126, 15);

		this.panel3.add(this.lblGetPasswd);
		this.lblGetPasswd.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetPasswd.setBounds(120, 155, 126, 15);

		this.panel3.add(this.lblProfileName);
		this.lblProfileName.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileName.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileName.setBounds(41, 199, 57, 15);

		this.panel3.add(this.lblProfileEmail);
		this.lblProfileEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileEmail.setBounds(41, 240, 57, 15);

		this.panel3.add(this.lblProfileRecvEmail);
		this.lblProfileRecvEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileRecvEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileRecvEmail.setBounds(41, 282, 57, 15);

		this.panel3.add(this.lblGetName);
		this.lblGetName.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetName.setBounds(120, 199, 126, 15);

		this.panel3.add(this.lblGetEmail);
		this.lblGetEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetEmail.setBounds(120, 240, 126, 15);

		this.panel3.add(this.lblGetRecvEmail);
		this.lblGetRecvEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetRecvEmail.setBounds(120, 282, 126, 15);

		this.panel3.add(this.btnUpdateProfile);
		this.btnUpdateProfile.setBackground(Color.LIGHT_GRAY);
		this.btnUpdateProfile.setBounds(104, 371, 115, 23);

		this.panel3.add(this.btnLogout);
		this.btnLogout.setBackground(Color.WHITE);
		this.btnLogout.setBounds(222, 10, 97, 23);

		this.panel3.add(this.lblProfileTimpstamp);
		this.lblProfileTimpstamp.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblProfileTimpstamp.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblProfileTimpstamp.setBounds(41, 326, 57, 15);

		this.panel3.add(this.lblGetTimestamp);
		this.lblGetTimestamp.setFont(new Font("굴림", Font.PLAIN, 12));
		this.lblGetTimestamp.setBounds(120, 326, 126, 15);

	}

	public static void main(String[] args) {

		new Ex3();

	} // end of main
}
