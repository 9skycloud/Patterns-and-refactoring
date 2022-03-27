package com.skycloud.refactor.strategy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.skycloud.refactor.strategy.old.Loan;
public class StrategyTest {

	/**
	 * 循环信用定期贷款
	 * @throws ParseException
	 */
	@Test
	public void testRCTL() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = df.parse("2020-12-20 12:19:19");
		Date expiry = df.parse("2021-12-20 12:19:19");
		//df.parse("2021-3-20 12:19:19")
		Date maturity = null;
		int riskRating = 0;
		double commitment = 100000;
		double outstanding = 0;
		Loan loan = new Loan(commitment, 0, start, expiry, null, riskRating);
		double capital = loan.capital();
		System.out.println("信用定期循环贷款额度："+capital);
		
		System.out.println(loan.yearsTo(df.parse("2020-12-22 12:19:19")));
		
	}
	
	/**
	 * 循环代码（信用卡）
	 * @throws ParseException
	 */
	@Test
	public void testRevolver() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = df.parse("2020-12-20 12:19:19");
		Date expiry = df.parse("2021-12-20 12:19:19");
		//df.parse("2021-3-20 12:19:19")
		Date maturity = null;
		int riskRating = 0;
		double commitment = 100000;
		double outstanding = 0;
		Loan loan = new Loan(commitment, 0, start, expiry, null, riskRating);
		double capital = loan.capital();
		System.out.println("循环贷款额度："+capital);
		
		System.out.println(loan.yearsTo(df.parse("2020-12-22 12:19:19")));
	}
	
	/**
	 * 定期贷款
	 * @throws ParseException
	 */
	@Test
	public void testTermLoan() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = df.parse("2020-12-20 12:19:19");
		Date expiry = null;
//				df.parse("2021-12-20 12:19:19");
		Date maturity = df.parse("2021-3-20 12:19:19");
		int riskRating = 0;
		double commitment = 100000;
		double outstanding = 0;
		Loan loan = new Loan(commitment, outstanding, start, null, maturity, riskRating);
		double capital = loan.capital();
		System.out.println("定期贷款额度："+capital);
		
		
		System.out.println(loan.yearsTo(df.parse("2020-12-22 12:19:19")));
	}
	
	
	
}
