package com.yudong80.java;

/**
 * ���� ��� ���� (���ÿ�, ����)
 * ��ó: https://blog.naver.com/scent77cho/221328807691
 * 1~200 , 910 , 93.3 
 * 201~ 400, 1600, 187.9
 * 401~ , 7300, 280.6 
 * 
 * ��) 
 * 100kWh = 910 + 93.3 * 100 = 10,240 �� 
 * 300kWh = 1600 + 93.3 * 200 + 187.9 * 100 = 39,050��
 */
public class ElectricBills {
	static double getBasicFee(double amount) {
		if (amount <= 200) return 910;
		else if (amount <= 400) return 1600;
		return 7300;
	}

	static double getFirstDegree(double amount) {
		if (amount <= 200) return amount;
		return 200;
	}
	
	static double getSecondDegree(double amount) {
		if (amount <= 400) {
			return amount - getFirstDegree(amount);
		}
		return 200;
	}
	
	static double getThirdDegree(double amount) {
		if (amount <= 400) {
			return 0;
		}
		
		return amount - 400;
	}
	
	public static void main(String[] args) {
		//��1: 100 -> 10240�� 
		double v = 100;
		double price = getBasicFee(v) + 
				getFirstDegree(v) * 93.3 + 
				getSecondDegree(v) * 187.9 + 
				getThirdDegree(v) * 280.6;
		System.out.println(price);
		
		//��2: 300 -> 39050��
		v = 300;
		price = getBasicFee(v) + 
				getFirstDegree(v) * 93.3 + 
				getSecondDegree(v) * 187.9 + 
				getThirdDegree(v) * 280.6;
		System.out.println(price);		
	}
}
