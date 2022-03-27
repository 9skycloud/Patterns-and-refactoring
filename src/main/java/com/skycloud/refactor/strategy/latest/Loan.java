package com.skycloud.refactor.strategy.latest;

import java.util.Date;
import java.util.List;

import com.skycloud.refactor.strategy.old.Payment;
import com.skycloud.refactor.strategy.old.RiskFactor;
import com.skycloud.refactor.strategy.old.UnusedRiskFactors;

/**
 * 贷款业务
 * @author QQ445161315
 *
 */
public class Loan {
	  // 承诺金额
	  private double commitment;
	  // 未偿贷款
	  private double outstanding;
	  // 有效日
	  private Date expiry;
	  // 到期日
	  private Date maturity;
	  // 风险评级
	  private int riskRating;

	  private Date today;
	  private Date start;
	  
	  private AbstractStrategy strategy;

	  private static final long MILLIS_PER_DAY = 24 * 3600 * 1000;
	  private static final long DAYS_PER_YEAR = 365;
	  
	  private List<Payment> payments;

	  public Loan(double commitment,
			  double outstanding,
			  Date start,
			  Date expiry,
			  Date maturity,
	    int riskRating,AbstractStrategy strategy){
	    this.commitment = commitment;
	    this.outstanding = outstanding;
	    this.start = start;
	    this.expiry = expiry;
	    this.maturity = maturity;
	    this.riskRating = riskRating;
	    this.strategy = strategy;
	  }

	  /**
	   * 资金计算
	   * @return
	   */
	  public double capital() {
		  return strategy.capital(this);
	  }


	/**
	   * 未用额度
	 * @return 
	   */
	  int getUnusedPercentage() {
	    return 1;
	  }

	  public double duration() {
	    return strategy.daration(this);
	  }

	  public long yearsTo(Date endDate) {
	    Date beginDate = this.today == null ? this.start : this.today;
	    return (
	      (endDate.getTime() - beginDate.getTime()) /
	      this.MILLIS_PER_DAY /
	      this.DAYS_PER_YEAR
	    );
	  }

	  double riskFactor() {
	    return RiskFactor.getFactors().forRating(this.riskRating);
	  }

	  int unusedRiskFactor() {
	    return UnusedRiskFactors.getFactors().forRating(this.riskRating);
	  }

	  double weightedAverageDuration() {
		  double duration = 0;
		  double weightedAverage = 0;
		  double sumOfPayments = 0;
//		  Iterator loanPayments = payments.iterator();
//		  while(loanPayments.hasNext()){
//			  Payment payment = (Payment) loanPayments.next();
//			  sumOfPayments += payment.amount();
//			  weightedAverage += yearsTo(payment.date())*payment.amount();
//		  }
//		  if(commitment != 0)
//			  duration = weightedAverage / sumOfPayments;
//		  return duration;
		  return 1;
	  }

	  /**
	   * 未用风险金额
	 * @return 
	   */
	  double unusedRiskAmount() {
	    return this.commitment - this.outstanding;
	  }
	  /**
	   * 未清风险金额
	 * @return 
	   */
	  double outstandingRiskAmount() {
	    return this.outstanding;
	  }

	public double getCommitment() {
		return commitment;
	}

	public void setCommitment(double commitment) {
		this.commitment = commitment;
	}

	public double getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
	}

	public int getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(int riskRating) {
		this.riskRating = riskRating;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	  
	}

