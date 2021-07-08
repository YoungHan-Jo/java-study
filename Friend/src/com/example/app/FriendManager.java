package com.example.app;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.example.domain.FriendVO;
import com.example.repository.FriendDAO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FriendManager extends JFrame {

	private FriendDAO friendDAO = FriendDAO.getInstance();

	private JSplitPane splitPaneHorizontal;
	Container container;
	private JPanel panelLeft;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblBirth;
	private JTextField tfBirth;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblAddress;
	private JTextField tfAddress;
	private JButton btnShowTotal;
	private JButton btnInsertFriend;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnUpdateFriend;
	private JButton btnDeleteFriend;
	private JSplitPane splitPaneVertical;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JComboBox comboBox;
	private JTextField tfSearch;
	private JButton btnSearch;

	public FriendManager() {
		super("친구관리 프로그램");

		container = getContentPane();
		container.add(getSplitPaneHorizontal(), BorderLayout.CENTER);

		addListener();
		setFrame();
	}

	private void addListener() {

		btnShowTotal.addActionListener(e -> {
			showTotal();
		});

		btnInsertFriend.addActionListener(e -> {
			insertFriend();
			clearTextField();
			showTotal();
		});

		btnUpdateFriend.addActionListener(e -> {
			updateFriend();
			clearTextField();
			showTotal();
		});

		btnDeleteFriend.addActionListener(e -> {
			deleteFriend();
			clearTextField();
			showTotal();
		});

		btnSearch.addActionListener(e -> {
			searchFriend();
			clearTextField();
		});

		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchFriend();
					clearTextField();
				}
			}
		});

	}// end of addListener

	private void clearTextField() {
		tfName.setText("");
		tfBirth.setText("");
		tfPhone.setText("");
		tfAddress.setText("");
		tfNum.setText("");
		tfSearch.setText("");
	}

	private void searchFriend() {

		int selectedIndex = comboBox.getSelectedIndex();
		if (selectedIndex == 0) {
			JOptionPane.showMessageDialog(this, "검색항목을 선택하세요", "에러", JOptionPane.ERROR_MESSAGE);
		} else {

			String word = tfSearch.getText();

			if (word.isEmpty()) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요", "에러", JOptionPane.ERROR_MESSAGE);
			} else {
				textArea.setText("");

				List<FriendVO> list = friendDAO.searchFriend(selectedIndex, word);

				if (list.size() > 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

					for (FriendVO friend : list) {
						textArea.append(String.format("번호 : %d\n", friend.getNum()));
						textArea.append(String.format("이름 : %s\n", friend.getName()));
						textArea.append(String.format("생일 : %s\n", friend.getBirth()));
						textArea.append(String.format("전화번호 : %s\n", friend.getPhone()));
						textArea.append(String.format("주소 : %s\n", friend.getAddress()));
						String strRegDate = sdf.format(friend.getRegDate());
						textArea.append(String.format("등록일 : %s\n\n", strRegDate));
					}
				} else {
					textArea.append("검색 결과 없음");
				}
			}
		}
	}

	private void deleteFriend() {
		int num = Integer.parseInt(tfNum.getText());

		friendDAO.deleteFriendByNum(num);
	}

	private void updateFriend() {
		Integer num = Integer.parseInt(tfNum.getText());
		String name = tfName.getText();

		FriendVO friendVO = new FriendVO();
		friendVO.setNum(num);
		friendVO.setName(tfName.getText());
		friendVO.setBirth(tfBirth.getText());
		friendVO.setPhone(tfPhone.getText());
		friendVO.setAddress(tfAddress.getText());
		friendVO.setRegDate(new Timestamp(System.currentTimeMillis()));

		friendDAO.updateFriend(friendVO);
	}

	private void showTotal() {

		textArea.setText("");

		List<FriendVO> list = friendDAO.getFriends();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

		for (FriendVO friend : list) {
			textArea.append(String.format("번호 : %d\n", friend.getNum()));
			textArea.append(String.format("이름 : %s\n", friend.getName()));
			textArea.append(String.format("생일 : %s\n", friend.getBirth()));
			textArea.append(String.format("전화번호 : %s\n", friend.getPhone()));
			textArea.append(String.format("주소 : %s\n", friend.getAddress()));
			String strRegDate = sdf.format(friend.getRegDate());
			textArea.append(String.format("등록일 : %s\n\n", strRegDate));
		}
	}

	private void insertFriend() {
		String name = tfName.getText();

		FriendVO friendVO = new FriendVO();
		friendVO.setName(tfName.getText());
		friendVO.setBirth(tfBirth.getText());
		friendVO.setPhone(tfPhone.getText());
		friendVO.setAddress(tfAddress.getText());

		if (name.length() == 0) {
			JOptionPane.showMessageDialog(this, "이름은 필수입력 요소입니다", "Message", JOptionPane.INFORMATION_MESSAGE);
		} else {
			friendDAO.insertFriend(friendVO);
			JOptionPane.showMessageDialog(this, "친구등록을 성공했습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void setFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 450);
		setLocationByPlatform(true);

		setVisible(true);
	}// end of setFrame

	// ======================================================================================================
	// ==============================================main()==================================================
	// ======================================================================================================
	public static void main(String[] args) {
		new FriendManager();
	} // end of main

	private JSplitPane getSplitPaneHorizontal() {
		if (splitPaneHorizontal == null) {
			splitPaneHorizontal = new JSplitPane();
			splitPaneHorizontal.setDividerLocation(230);
			splitPaneHorizontal.setLeftComponent(getPanelLeft());
			splitPaneHorizontal.setRightComponent(getSplitPaneVertical());
		}
		return splitPaneHorizontal;
	}

	private JPanel getPanelLeft() {
		if (panelLeft == null) {
			panelLeft = new JPanel();
			panelLeft.setLayout(null);
			panelLeft.add(getLblName());
			panelLeft.add(getTfName());
			panelLeft.add(getLblBirth());
			panelLeft.add(getTfBirth());
			panelLeft.add(getLblPhone());
			panelLeft.add(getTfPhone());
			panelLeft.add(getLblAddress());
			panelLeft.add(getTfAddress());
			panelLeft.add(getBtnShowTotal());
			panelLeft.add(getBtnInsertFriend());
			panelLeft.add(getLblNum());
			panelLeft.add(getTfNum());
			panelLeft.add(getBtnUpdateFriend());
			panelLeft.add(getBtnDeleteFriend());
		}
		return panelLeft;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setBounds(12, 37, 55, 18);
		}
		return lblName;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(105, 35, 114, 22);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JLabel getLblBirth() {
		if (lblBirth == null) {
			lblBirth = new JLabel("생일");
			lblBirth.setBounds(12, 82, 55, 18);
		}
		return lblBirth;
	}

	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(105, 80, 114, 22);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}

	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("전화번호");
			lblPhone.setBounds(12, 125, 55, 18);
		}
		return lblPhone;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(105, 123, 114, 22);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소");
			lblAddress.setBounds(12, 165, 55, 18);
		}
		return lblAddress;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setBounds(12, 186, 207, 22);
			tfAddress.setColumns(10);
		}
		return tfAddress;
	}

	private JButton getBtnShowTotal() {
		if (btnShowTotal == null) {
			btnShowTotal = new JButton("전체보기");
			btnShowTotal.setBounds(12, 238, 98, 28);
		}
		return btnShowTotal;
	}

	private JButton getBtnInsertFriend() {
		if (btnInsertFriend == null) {
			btnInsertFriend = new JButton("친구등록");
			btnInsertFriend.setBounds(121, 238, 98, 28);
		}
		return btnInsertFriend;
	}

	private JLabel getLblNum() {
		if (lblNum == null) {
			lblNum = new JLabel("번호");
			lblNum.setBounds(12, 311, 55, 18);
		}
		return lblNum;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(103, 309, 114, 22);
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	private JButton getBtnUpdateFriend() {
		if (btnUpdateFriend == null) {
			btnUpdateFriend = new JButton("수정하기");
			btnUpdateFriend.setBounds(12, 354, 98, 28);
		}
		return btnUpdateFriend;
	}

	private JButton getBtnDeleteFriend() {
		if (btnDeleteFriend == null) {
			btnDeleteFriend = new JButton("삭제하기");
			btnDeleteFriend.setBounds(121, 354, 98, 28);
		}
		return btnDeleteFriend;
	}

	private JSplitPane getSplitPaneVertical() {
		if (splitPaneVertical == null) {
			splitPaneVertical = new JSplitPane();
			splitPaneVertical.setDividerLocation(250);
			splitPaneVertical.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPaneVertical.setLeftComponent(getScrollPane());
			splitPaneVertical.setRightComponent(getPanel());
		}
		return splitPaneVertical;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getComboBox());
			panel.add(getTfSearch());
			panel.add(getBtnSearch());
		}
		return panel;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "선택..", "이름", "주소" }));
			comboBox.setBounds(23, 52, 65, 20);
		}
		return comboBox;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(115, 51, 114, 22);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(76, 95, 98, 28);
		}
		return btnSearch;
	}
}
