package com.skycloud.refactor.strategy.old;

import java.util.Date;
import java.util.List;

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

	  private static final long MILLIS_PER_DAY = 24 * 3600 * 1000;
	  private static final long DAYS_PER_YEAR = 365;
	  
	  private List<Payment> payments;

	  public Loan(double commitment,
			  double outstanding,
			  Date start,
			  Date expiry,
			  Date maturity,
	    int riskRating){
	    this.commitment = commitment;
	    this.outstanding = outstanding;
	    this.start = start;
	    this.expiry = expiry;
	    this.maturity = maturity;
	    this.riskRating = riskRating;
	  }

	  /**
	   * 资金计算
	   * @return
	   */
	  public double capital() {
//		  定期贷款
	    if (this.expiry == null && this.maturity != null) {
	      return this.commitment * this.duration() * this.riskFactor();
	    }

	    if (this.expiry != null && this.maturity == null) {
//	    	循环贷款
	      if (this.getUnusedPercentage() != 1) {
	        return (
	          this.commitment *
	          this.getUnusedPercentage() *
	          this.duration() *
	          this.riskFactor()
	        );
	      } else {
//	    	  建议信用额度贷款
	        return (
	          this.outstandingRiskAmount() * this.duration() * this.riskFactor() +
	          this.unusedRiskAmount() * this.duration() * this.unusedRiskFactor()
	        );
	      }
	    }
	    return 0;
	  }


	/**
	   * 未用额度
	 * @return 
	   */
	  int getUnusedPercentage() {
	    return 1;
	  }

	  public double duration() {
	    if (this.expiry == null && this.maturity != null) {
	      return this.weightedAverageDuration();
	    } else if (this.expiry != null && this.maturity == null) {
	      return this.yearsTo(this.expiry);
	    }
	    return 0;
	  }

	  public long yearsTo(Date endDate) {
	    Date beginDate = this.today == null ? this.start : this.today;
	    return (
	      (endDate.getTime() - beginDate.getTime()) /
	      this.MILLIS_PER_DAY /
	      this.DAYS_PER_YEAR
	    );
	  }

	  private double riskFactor() {
	    return RiskFactor.getFactors().forRating(this.riskRating);
	  }

	  private int unusedRiskFactor() {
	    return UnusedRiskFactors.getFactors().forRating(this.riskRating);
	  }

	  private double weightedAverageDuration() {
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
	  private double unusedRiskAmount() {
	    return this.commitment - this.outstanding;
	  }
	  /**
	   * 未清风险金额
	 * @return 
	   */
	  private double outstandingRiskAmount() {
	    return this.outstanding;
	  }
	}

