package home.vanusha.intexsoft.test.enums;

public enum RateOfPay {
	HALF(0.5), FULL(1), INCREASED(1.25);
	private double rate;
	
	private RateOfPay(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
}
