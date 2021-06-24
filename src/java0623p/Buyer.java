package java0623p;

import java.util.List;
import java.util.ArrayList;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	List<Product> cart = new ArrayList<>();
	int i = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -= p.price;
		bonusPoint += p.bonusPoint;
		cart.add(p);
		System.out.println(p + "를 구매하였습니다.");
	}

	void summary() {
		int sum = 0;
		String itemList = "";

		for (int i = 0; i < cart.size(); ++i) {
			if (cart.get(i) == null)
				break;
			sum += cart.get(i).price;
			itemList += (i == 0) ? "" + cart.get(i) : ", " + cart.get(i);
		}

		System.out.println("구입하신 물품의 총 금액 : " + sum);
		System.out.println("구입 물품 리스트 : " + itemList);
	}
}
