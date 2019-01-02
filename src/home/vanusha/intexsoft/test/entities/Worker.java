package home.vanusha.intexsoft.test.entities;

import home.vanusha.intexsoft.test.enums.RateOfPay;
import home.vanusha.intexsoft.test.enums.Role;

public class Worker extends Recruit {
	private int hourlyRate;
	private double hoursQuantity;
	private Role role=Role.WORKER;

	public Worker() {
		super();
	}

	public Worker(Worker worker) {
		super(worker.getName(), worker.getLastName(), worker.getRateOfPay());
		this.hourlyRate = worker.hourlyRate;
		this.hoursQuantity = worker.hoursQuantity;
	}

	public Worker(String name, String lastName, Role role, RateOfPay rateOfPay, int hourlyRate, double hoursQuantity) {
		super(name, lastName, rateOfPay);
		this.hourlyRate = hourlyRate;
		this.hoursQuantity = hoursQuantity;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursQuantity() {
		return hoursQuantity;
	}

	public void setHoursQuantity(double hoursQuantity) {
		this.hoursQuantity = hoursQuantity;
	}

	@Override
	public double calculateSalary() {
		double salary = 0;
		double normalWorkTime = COMMONHOURSQUANTITY * rateOfPay.getRate();
		if (normalWorkTime < hoursQuantity) {
			salary = hoursQuantity * hourlyRate;
			return salary;
		}
		double additionalWorkTime = hoursQuantity - normalWorkTime;
		salary = (normalWorkTime * hourlyRate) + (additionalWorkTime * hourlyRate * 1.5);
		return salary;

	}

	@Override
	public String toString() {
		return "Employee [hourlyRate=" + hourlyRate + ", hoursQuantity=" + hoursQuantity + ", name=" + name
				+ ", lastName=" + lastName + ", role=" + role.name() + ", rateOfPay=" + rateOfPay + "]";
	}

}
