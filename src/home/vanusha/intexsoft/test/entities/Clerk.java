package home.vanusha.intexsoft.test.entities;

import home.vanusha.intexsoft.test.enums.RateOfPay;
import home.vanusha.intexsoft.test.enums.Role;

public class Clerk extends Recruit {
	private int bonusPercentage;
	private Role role=Role.CLERK;
	
	public Clerk() {
		super();
	}

	public Clerk(Clerk clerk) {
		super(clerk.getName(), clerk.getLastName(),  clerk.getRateOfPay());
	}

	public Clerk(String name, String lastName, Role role, RateOfPay rateOfPay, int bonus) {
		super(name, lastName, rateOfPay);
		this.bonusPercentage = bonus;

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getBonusPercentage() {
		return bonusPercentage;
	}

	public void setBonusPercentage(int bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}

	@Override
	public double calculateSalary() {
		double salary = 0;
		salary = COMMONWAGE * rateOfPay.getRate();
		double bonus = (salary / 100) * bonusPercentage;
		return salary + bonus;
	}

	@Override
	public String toString() {
		return "Employee [bonusPercentage=" + bonusPercentage + ", name=" + name + ", lastName=" + lastName + ", role="
				+ role.name() + ", rateOfPay=" + rateOfPay + "]";
	}

}
