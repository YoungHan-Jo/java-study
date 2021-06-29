package EtfRebalancing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		this.lbEtfPrice = new JLabel("1주 가격");
		this.lbHoldDollar = new JLabel("보유 달러");
		this.lbHoldWon = new JLabel("보유 원");
		this.lbAddWon = new JLabel("추가 투입(원)");
		this.lbExRateOneDollar = new JLabel("1$ 당 환율");
		this.lbSettingRate = new JLabel("비율 설정");
		this.lbResultStock = new JLabel("리밸런싱 후 보유 주식");
		this.lbResultCash = new JLabel("리밸런싱 후 보유 현금");
		this.lbTotal = new JLabel("총 합계");

		this.tfHoldStock = new JTextField(8);
		this.tfEtfPrice = new JTextField(5);
		this.tfHoldDollar = new JTextField(8);
		this.tfHoldWon = new JTextField(8);
		this.tfAddWon = new JTextField(10);
		this.tfExRateOneDollar = new JTextField(10);
		this.tfSettingRate = new JTextField(10);
		this.tfResultStock = new JTextField(8);
		this.tfResultStockPer = new JTextField(5);
		this.tfResultCash = new JTextField(8);
		this.tfResultCashPer = new JTextField(5);
		this.tfTotal = new JTextField(10);

		this.board = new JTextArea(1, 50);

		this.btn = new JButton("계산하기");
	}// end of init

	private void setComponents() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
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
				this.board.setText(toBuyCnt + "주 매수");
				resultStock = holdStock + toBuyCnt * etfPrice;
				resultCash = total - resultStock;

			} else {
				toSellCnt = (int) Math.round((holdStock - targetStock) / etfPrice);
				this.board.setText(toSellCnt + "주 매도");
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
		setSize(600, 200);
		setLocationByPlatform(true);
		setVisible(true);
	}// end of showFrame

	public static void main(String[] args) {

		new Main();

	} // end of main

}
