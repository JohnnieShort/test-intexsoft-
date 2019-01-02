package home.vanusha.intexsoft.test.entities;

import home.vanusha.intexsoft.test.enums.RateOfPay;

public abstract class Recruit {
	protected String name;
	protected String lastName;
	protected RateOfPay rateOfPay;
	
	public static final int COMMONHOURSQUANTITY = 176;
	public static final int COMMONWAGE = 500;
	
	public Recruit() {
	}
	
	public Recruit(String name, String lastName, RateOfPay rateOfPay) {
		this.name = name;
		this.lastName = lastName;
		this.rateOfPay = rateOfPay;
		
	}

	public abstract double calculateSalary();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public RateOfPay getRateOfPay() {
		return rateOfPay;
	}
	public void setRateOfPay(RateOfPay rateOfPay) {
		this.rateOfPay = rateOfPay;
	}
	
	
}
