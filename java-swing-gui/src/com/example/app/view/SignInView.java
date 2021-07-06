package com.example.app.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;

public class SignInView implements Viewable {

	public static final String VIEW_NAME = "sign in";

	private MemberDAO memberDAO = MemberDAO.getInstance();

	private CardLayout cardLayout;
	private Container container;
	private JPanel panelSignIn;

	private JLabel lblSignInId;
	private JTextField tfSignInId;
	private JLabel lblWrongId;
	private JLabel lblSignInPasswd1;
	private JPasswordField pfSignInPasswd1;
	private JLabel lblWrongPasswd1;
	private JLabel lblSignInPasswd2;
	private JPasswordField pfSignInPasswd2;
	private JLabel lblWrongPasswd2;
	private JLabel lblSignInName;
	private JTextField tfSignInName;
	private JLabel lblSignInEmail;
	private JTextField tfSignInEmail;
	private JLabel tfRecvEmail;
	private ButtonGroup g;
	private JRadioButton rdbtnRecvYes;
	private JRadioButton rdbtnRecvNo;
	private JButton btnInsertAccount;

	public SignInView(CardLayout cardLayout, Container container) {
		this.cardLayout = cardLayout;
		this.container = container;

		init();
		setComponents();
		addListener();
	}

	@Override
	public JPanel getView() {
		return panelSignIn;
	}

	private void init() {
		panelSignIn = new JPanel();

		lblSignInId = new JLabel("아이디");
		tfSignInId = new JTextField();
		lblWrongId = new JLabel("");
		lblSignInPasswd1 = new JLabel("비밀번호");
		pfSignInPasswd1 = new JPasswordField();
		lblWrongPasswd1 = new JLabel("");
		lblSignInPasswd2 = new JLabel("비밀번호 재확인");
		pfSignInPasswd2 = new JPasswordField();
		lblWrongPasswd2 = new JLabel("");
		lblSignInName = new JLabel("이름");
		tfSignInName = new JTextField();
		lblSignInEmail = new JLabel("이메일");
		tfSignInEmail = new JTextField();
		tfRecvEmail = new JLabel("메일 수신");
		g = new ButtonGroup();
		rdbtnRecvYes = new JRadioButton("예");
		rdbtnRecvNo = new JRadioButton("아니오");
		btnInsertAccount = new JButton("가입하기");
	}

	private void setComponents() {
		this.panelSignIn.setLayout(null);
		this.panelSignIn.add(this.lblSignInId);
		this.lblSignInId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInId.setBounds(65, 28, 57, 15);

		this.panelSignIn.add(this.tfSignInId);
		this.tfSignInId.setBounds(65, 53, 203, 21);
		this.tfSignInId.setColumns(10);

		this.panelSignIn.add(this.lblWrongId);
		this.lblWrongId.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongId.setForeground(Color.RED);
		this.lblWrongId.setBounds(65, 84, 203, 15);

		this.panelSignIn.add(this.lblSignInPasswd1);
		this.lblSignInPasswd1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd1.setBounds(65, 109, 57, 15);

		this.panelSignIn.add(this.pfSignInPasswd1);
		this.pfSignInPasswd1.setBounds(65, 134, 203, 21);

		this.panelSignIn.add(this.lblWrongPasswd1);
		this.lblWrongPasswd1.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd1.setForeground(Color.RED);
		this.lblWrongPasswd1.setBounds(65, 165, 203, 15);

		this.panelSignIn.add(this.lblSignInPasswd2);
		this.lblSignInPasswd2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInPasswd2.setBounds(65, 190, 116, 15);

		this.panelSignIn.add(this.pfSignInPasswd2);
		this.pfSignInPasswd2.setBounds(65, 215, 203, 21);

		this.panelSignIn.add(this.lblWrongPasswd2);
		this.lblWrongPasswd2.setFont(new Font("굴림", Font.PLAIN, 11));
		this.lblWrongPasswd2.setForeground(Color.RED);
		this.lblWrongPasswd2.setBounds(65, 246, 203, 15);

		this.panelSignIn.add(this.lblSignInName);
		this.lblSignInName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInName.setBounds(65, 271, 57, 15);

		this.panelSignIn.add(this.tfSignInName);
		this.tfSignInName.setBounds(65, 296, 203, 21);
		this.tfSignInName.setColumns(10);

		this.panelSignIn.add(this.lblSignInEmail);
		this.lblSignInEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.lblSignInEmail.setBounds(65, 338, 57, 15);

		this.panelSignIn.add(this.tfSignInEmail);
		this.tfSignInEmail.setBounds(65, 363, 203, 21);
		this.tfSignInEmail.setColumns(10);

		this.panelSignIn.add(this.tfRecvEmail);
		this.tfRecvEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		this.tfRecvEmail.setBounds(65, 407, 57, 15);

		this.panelSignIn.add(this.rdbtnRecvYes);
		this.rdbtnRecvYes.setBackground(new Color(255, 255, 255));
		this.rdbtnRecvYes.setBounds(65, 428, 62, 23);

		g.add(rdbtnRecvYes);
		g.add(rdbtnRecvNo);

		this.panelSignIn.add(this.rdbtnRecvNo);
		this.rdbtnRecvNo.setBackground(new Color(255, 255, 255));
		this.rdbtnRecvNo.setSelected(true);
		this.rdbtnRecvNo.setBounds(147, 428, 121, 23);

		this.panelSignIn.add(this.btnInsertAccount);
		this.btnInsertAccount.setFont(new Font("굴림", Font.PLAIN, 20));
		this.btnInsertAccount.setForeground(new Color(255, 255, 255));
		this.btnInsertAccount.setBackground(new Color(51, 204, 51));
		this.btnInsertAccount.setBounds(65, 477, 196, 50);
	}

	private void addListener() {
		btnInsertAccount.addActionListener(e -> {
			String id = tfSignInId.getText().trim();
			if (id.length() == 0) {
				insertAccountError();
			} else {
				insertAccount();
			}
		});

		tfSignInId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String signInId = tfSignInId.getText().trim();

				int count = memberDAO.getCountById(signInId);

				if (count > 0) {
					lblWrongId.setText("이미 사용중이거나 탈퇴한 아이디입니다.");
					lblWrongId.setForeground(Color.red);
				} else {
					lblWrongId.setText("멋진 아이디네요!");
					lblWrongId.setForeground(Color.GREEN);
				}
			}
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

	} // addListener

	private void insertAccountError() {
		JOptionPane.showMessageDialog(container, "아이디는 필수 입력 요소입니다.", "Error", JOptionPane.WARNING_MESSAGE);
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

		memberDAO.insert(member);

		cardLayout.show(container, "login");

		tfSignInId.setText("");
		lblWrongId.setText("");
		pfSignInPasswd1.setText("");
		pfSignInPasswd2.setText("");
		tfSignInName.setText("");
		tfSignInEmail.setText("");
		rdbtnRecvNo.setSelected(true);
	}

}
