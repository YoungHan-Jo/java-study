package EtfRebalancing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class Main extends JFrame {

	private JLabel lbHoldStock, lbEtfPrice, lbHoldDollar, lbHoldWon;
	private JLabel lbAddWon, lbExRateOneDollar, lbSettingRate;
	private JLabel lbResultStock, lbResultCash, lbTotal;

	private JTextField tfHoldStock, tfEtfPrice, tfHoldDollar, tfHoldWon;
	private JTextField tfAddWon, tfExRateOneDollar, tfSettingRate;
	private JTextField tfResultStock, tfResultStockPer, tfResultCash, tfResultCashPer, tfTotal;

	private JTextArea board;
	private JButton btn;

	public Main() {
		this.init();
		this.setComponents();
		this.addListener();
		this.showFrame();
	}// end of Main

	private void init() {
		this.lbHoldStock = new JLabel("보유 주식");
		lbHoldStock.setBounds(69, 24, 74, 15);
		this.lbEtfPrice = new JLabel("1주 가격");
		lbEtfPrice.setBounds(303, 24, 70, 15);
		this.lbHoldDollar = new JLabel("보유 달러");
		lbHoldDollar.setBounds(69, 58, 74, 15);
		this.lbHoldWon = new JLabel("보유 원");
		lbHoldWon.setBounds(313, 58, 60, 15);
		this.lbAddWon = new JLabel("추가 투입(원)");
		lbAddWon.setBounds(69, 95, 88, 15);
		this.lbExRateOneDollar = new JLabel("1$ 당 환율");
		lbExRateOneDollar.setBounds(299, 95, 74, 15);
		this.lbSettingRate = new JLabel("비율 설정");
		lbSettingRate.setBounds(69, 138, 74, 15);
		this.lbResultStock = new JLabel("리밸런싱 후 보유 주식");
		lbResultStock.setBounds(90, 238, 120, 15);
		this.lbResultCash = new JLabel("리밸런싱 후 보유 현금");
		lbResultCash.setBounds(93, 274, 120, 15);
		this.lbTotal = new JLabel("총 합계");
		lbTotal.setBounds(169, 316, 40, 15);

		this.tfHoldStock = new JTextField(8);
		tfHoldStock.setBounds(169, 21, 94, 21);
		this.tfEtfPrice = new JTextField(5);
		tfEtfPrice.setBounds(396, 21, 94, 21);
		this.tfHoldDollar = new JTextField(8);
		tfHoldDollar.setBounds(169, 55, 94, 21);
		this.tfHoldWon = new JTextField(8);
		tfHoldWon.setBounds(396, 52, 94, 21);
		this.tfAddWon = new JTextField(10);
		tfAddWon.setBounds(169, 92, 94, 21);
		this.tfExRateOneDollar = new JTextField(10);
		tfExRateOneDollar.setBounds(396, 92, 94, 21);
		this.tfSettingRate = new JTextField(10);
		tfSettingRate.setBounds(169, 135, 94, 21);
		this.tfResultStock = new JTextField(8);
		tfResultStock.setBounds(239, 235, 94, 21);
		this.tfResultStockPer = new JTextField(5);
		tfResultStockPer.setBounds(345, 235, 61, 21);
		this.tfResultCash = new JTextField(8);
		tfResultCash.setBounds(239, 271, 94, 21);
		this.tfResultCashPer = new JTextField(5);
		tfResultCashPer.setBounds(345, 271, 61, 21);
		this.tfTotal = new JTextField(10);
		tfTotal.setBounds(239, 313, 116, 21);

		this.board = new JTextArea(1, 50);
		board.setBounds(118, 189, 354, 24);
		board.setText("매수(매도)해야할 수량 : ");
		board.setEnabled(false);

		this.btn = new JButton("계산하기");
		btn.setBounds(391, 134, 99, 23);
	}// end of init

	private void setComponents() {
		Container c = getContentPane();
		getContentPane().setLayout(null);
		c.add(lbHoldStock);
		c.add(tfHoldStock);
		c.add(lbEtfPrice);
		c.add(tfEtfPrice);
		c.add(lbHoldDollar);
		c.add(tfHoldDollar);
		c.add(lbHoldWon);
		c.add(tfHoldWon);
		c.add(lbAddWon);
		c.add(tfAddWon);
		c.add(lbExRateOneDollar);
		c.add(tfExRateOneDollar);
		c.add(lbSettingRate);
		c.add(tfSettingRate);

		c.add(btn);
		c.add(board);

		c.add(lbResultStock);
		c.add(tfResultStock);
		c.add(tfResultStockPer);
		c.add(lbResultCash);
		c.add(tfResultCash);
		c.add(tfResultCashPer);
		c.add(lbTotal);
		c.add(tfTotal);
	}// end of setLayout

	private void addListener() {
		this.btn.addActionListener(e -> {
			Double holdStock = Double.valueOf(tfHoldStock.getText());
			Double etfPrice = Double.valueOf(tfEtfPrice.getText());
			Double holdDollar = Double.valueOf(tfHoldDollar.getText());
			Double holdWon = Double.valueOf(tfHoldWon.getText());
			Double addWon = Double.valueOf(tfAddWon.getText());
			Double exRate = Double.valueOf(tfExRateOneDollar.getText());
			Double settingRate = Double.valueOf(tfSettingRate.getText());

			Double total = holdStock + holdDollar + (holdWon + addWon) / exRate;
			Double targetStock = total * settingRate / 100;
			Integer toBuyCnt = 0;
			Integer toSellCnt = 0;
			Double resultStock = 0.0;
			Double resultCash = 0.0;

			if (targetStock >= holdStock) {
				toBuyCnt = (int) Math.round((targetStock - holdStock) / etfPrice);
				this.board.setText("매수(매도)해야할 수량 : " + toBuyCnt + "주 매수");
				resultStock = holdStock + toBuyCnt * etfPrice;
				resultCash = total - resultStock;

			} else {
				toSellCnt = (int) Math.round((holdStock - targetStock) / etfPrice);
				this.board.setText("매수(매도)해야할 수량 : " + toSellCnt + "주 매도");
				resultStock = holdStock - toSellCnt * etfPrice;
				resultCash = total - resultStock;
			}

			String resultStockPer = String.valueOf(Math.round(resultStock / total * 100 * 10) / 10.0);
			String resultCashPer = String.valueOf(100 - Math.round(resultStock / total * 100 * 10) / 10.0);

			this.tfResultStock.setText(String.valueOf("$ " + Math.round(resultStock * 10) / 10.0));
			this.tfResultStockPer.setText(resultStockPer + " %");
			this.tfResultCash.setText(String.valueOf("$ " + Math.round(resultCash * 10) / 10.0));
			this.tfResultCashPer.setText(resultCashPer + " %");
			this.tfTotal.setText("$ " + String.valueOf(Math.round(total * 10) / 10.0));
		});
	}// end of addListener

	private void showFrame() {
		setTitle("Etf 리밸런싱 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 416);
		setLocationByPlatform(true);
		setVisible(true);
	}// end of showFrame

	public static void main(String[] args) {

		new Main();

	} // end of main

}
