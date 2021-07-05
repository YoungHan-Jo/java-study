package java0705;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.repository.MemberDAO;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
/*
 * ========회원가입화면 (첫번째 화면)========
 * tfId		jtextfield
 * lblId	jlabel
 * 
 * pfPasswd1	jpasswordfield
 * pfpasswd2	jpasswordfield
 * lblpasswd	jlabel
 * 
 * tfName 	jtextfield
 * tfEmail 	jtextfield
 * tfrecvEmail(rdbtnRecvYes,rdbtnRecvNo )	라디오버튼
 *  
 * btnJoin 가입하기 버튼
 * 
 * =========로그인 화면 (두번째화면) ========
 * 아이디
 * 비밀번호
 * btnLogin 로그인 버튼
 * 
 * =========회원정보 (세번째 화면) =========
 * 레이블로 메인화면 텍스트 보여주기
 * 
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ex3 extends JFrame {
	
	private MemberDAO dao = MemberDAO.getInstance();

	private CardLayout cardLayout = new CardLayout(0, 0);
	private final JPanel panel1 = new JPanel();
	private final JPanel panel2 = new JPanel();
	private final JPanel panel3 = new JPanel();
	
	private final JLabel lblSignInId = new JLabel("아이디");
	private final JTextField tfSignInId = new JTextField();
	private final JLabel lblWrongId = new JLabel("New label");
	
	private final JLabel lblSignInPasswd1 = new JLabel("비밀번호");
	private final JPasswordField pfSignInPasswd1 = new JPasswordField();
	private final JLabel lblWrongPasswd1 = new JLabel("New label");
	private final JLabel lblSignInPasswd2 = new JLabel("비밀번호 재확인");
	private final JPasswordField pfSignInPasswd2 = new JPasswordField();
	private final JLabel lblWrongPasswd2 = new JLabel("New label");
	
	private final JLabel lblSignInName = new JLabel("이름");
	private final JTextField tfSignInName = new JTextField();
	
	private final JLabel lblSignInEmail = new JLabel("이메일");
	private final JTextField tfSignInEmail = new JTextField();
	
	private final JLabel tfRecvEmail = new JLabel("메일 수신");
	private final ButtonGroup g = new ButtonGroup();
	private final JRadioButton rdbtnRecvYes = new JRadioButton("예");
	private final JRadioButton rdbtnRecvNo = new JRadioButton("아니오");
	
	private final JButton btnJoin = new JButton("가입하기");
	private final JTextField tfLoginId = new JTextField();
	private final JTextField tfLoginPasswd = new JTextField();
	private final JButton btnLogin = new JButton("로그인");
	private final JLabel lblLoginId = new JLabel("아이디");
	private final JLabel lblLoginPasswd = new JLabel("비밀번호");
	private final JButton btnSignIn = new JButton("회원가입");

	Container c;
	
	public Ex3() {

		super("카드레이아웃 화면전환");
		init();
		setComponents();
		addListener();
		setFrame();

	}
	
	private void init() {
		this.tfLoginPasswd.setBounds(142, 101, 116, 21);
		this.tfLoginPasswd.setColumns(10);
		this.tfLoginId.setToolTipText("");
		this.tfLoginId.setBounds(142, 58, 116, 21);
		this.tfLoginId.setColumns(10);
		this.tfSignInEmail.setBounds(65, 363, 196, 21);
		this.tfSignInEmail.setColumns(10);
		this.tfSignInName.setBounds(65, 296, 203, 21);
		this.tfSignInName.setColumns(10);
		
//		this.tfSignInId.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				String signInId = tfSignInId.getText().trim();
//				
//				int count = dao.getCountById(signInId);
//				
//				if(count >0) {
//					lblWrongId.setText("이미 사용중이거나 탈퇴한 아이디입니다.");
//					lblWrongId.setForeground(Color.red);
//				}else {
//					lblWrongId.setText("멋진 아이디네요!");
//					lblWrongId.setForeground(Color.green);
//				}
//			}
//		});
		
		tfSignInId.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String signInId = tfSignInId.getText().trim();
				
				int count = dao.getCountById(signInId);
				
				if(count >0) {
					lblWrongId.setText("이미 사용중이거나 탈퇴한 아이디입니다.");
					lblWrongId.setForeground(Color.red);
				}else {
					lblWrongId.setText("멋진 아이디네요!");
					lblWrongId.setForeground(Color.GREEN);
				}
				
			}
			
		});
		
		
		this.tfSignInId.setBounds(65, 53, 203, 21);
		this.tfSignInId.setColumns(10);
	}

	private void setComponents() {
		c = getContentPane();
		c.setLayout(cardLayout);
		c.add(this.panel1, "sign in");
		c.add(this.panel2, "login");
		c.add(this.panel3, "profile");
		
		setupViewSignIn();
		setupViewLogin();
		setupViewProfile();
	}

	private void addListener() {
		
		btnJoin.addActionListener(e ->{
			cardLayout.show(c, "login");
			Ex3.this.setSize(347, 400);
		});
		
		btnLogin.addActionListener(e -> {
			cardLayout.show(c, "profile");
			Ex3.this.setSize(347, 593);
		});
		
		btnSignIn.addActionListener(e -> {
			cardLayout.show(c, "sign in");
			Ex3.this.setSize(347, 593);
		});
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
		this.lblSignInId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInId.setBounds(65, 28, 57, 15);
		
		this.panel1.add(this.lblSignInId);
		
		this.panel1.add(this.tfSignInId);
		this.lblWrongId.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongId.setForeground(Color.RED);
		this.lblWrongId.setBounds(65, 84, 203, 15);
		
		this.panel1.add(this.lblWrongId);
		this.lblSignInPasswd1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd1.setBounds(65, 109, 57, 15);
		
		this.panel1.add(this.lblSignInPasswd1);
		this.pfSignInPasswd1.setBounds(65, 134, 203, 21);
		
		this.panel1.add(this.pfSignInPasswd1);
		this.lblWrongPasswd1.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd1.setForeground(Color.RED);
		this.lblWrongPasswd1.setBounds(65, 165, 203, 15);
		
		this.panel1.add(this.lblWrongPasswd1);
		this.lblSignInPasswd2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd2.setBounds(65, 190, 116, 15);
		
		this.panel1.add(this.lblSignInPasswd2);
		this.pfSignInPasswd2.setBounds(65, 215, 203, 21);
		
		this.panel1.add(this.pfSignInPasswd2);
		this.lblWrongPasswd2.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd2.setForeground(Color.RED);
		this.lblWrongPasswd2.setBounds(65, 246, 203, 15);
		
		this.panel1.add(this.lblWrongPasswd2);
		this.lblSignInName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInName.setBounds(65, 271, 57, 15);
		
		this.panel1.add(this.lblSignInName);
		
		this.panel1.add(this.tfSignInName);
		this.lblSignInEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInEmail.setBounds(65, 338, 57, 15);
		
		this.panel1.add(this.lblSignInEmail);
		
		this.panel1.add(this.tfSignInEmail);
		this.tfRecvEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.tfRecvEmail.setBounds(65, 407, 57, 15);
		
		this.panel1.add(this.tfRecvEmail);
		this.rdbtnRecvYes.setBounds(65, 428, 62, 23);
		
		g.add(rdbtnRecvYes);
		g.add(rdbtnRecvNo);

		this.panel1.add(this.rdbtnRecvYes);
		this.rdbtnRecvNo.setSelected(true);
		this.rdbtnRecvNo.setBounds(147, 428, 121, 23);
		
		this.panel1.add(this.rdbtnRecvNo);
		this.btnJoin.setFont(new Font("굴림", Font.PLAIN, 20));
		this.btnJoin.setForeground(new Color(255, 255, 255));
		this.btnJoin.setBackground(new Color(51, 204, 51));
		this.btnJoin.setBounds(65, 477, 196, 50);
		
		this.panel1.add(this.btnJoin);
	
		
	}
	
	private void setupViewLogin() {
this.panel2.setLayout(null);
		
		this.panel2.add(this.tfLoginId);
		
		this.panel2.add(this.tfLoginPasswd);
		this.btnLogin.setForeground(Color.WHITE);
		this.btnLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		this.btnLogin.setBackground(new Color(51, 204, 51));
		this.btnLogin.setBounds(62, 174, 196, 50);
		
		this.panel2.add(this.btnLogin);
		this.lblLoginId.setBounds(62, 61, 57, 15);
		
		this.panel2.add(this.lblLoginId);
		this.lblLoginPasswd.setBounds(62, 104, 57, 15);
		
		
		this.panel2.add(this.lblLoginPasswd);
		this.btnSignIn.setBounds(113, 234, 97, 23);
		this.panel2.add(this.btnSignIn);
		
		
	}
	
	private void setupViewProfile() {
		this.panel3.setLayout(null);
		
	}
	
	

	public static void main(String[] args) {

		new Ex3();

	} // end of main
}
