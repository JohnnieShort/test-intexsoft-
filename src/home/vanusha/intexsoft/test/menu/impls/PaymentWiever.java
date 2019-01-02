package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.entities.Clerk;
import home.vanusha.intexsoft.test.entities.Recruit;
import home.vanusha.intexsoft.test.entities.Worker;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class PaymentWiever implements ICommand {

	@Override
	public void execute() {
		if (Utils.getRepository().size() == 0) {
			System.err.println("No employees recruited yet...");
			return;
		}
		double payment = 0.0;
		double workers = 0.0;
		double clerks = 0.0;
		for (Recruit recruit : Utils.getRepository()) {
			if (recruit instanceof Worker) {
				Worker worker = (Worker) recruit;
				payment = payment + worker.calculateSalary();
				workers = workers + worker.calculateSalary();
			}
			if (recruit instanceof Clerk) {
				Clerk clerk = (Clerk) recruit;
				payment = payment + clerk.calculateSalary();
				clerks = clerks + clerk.calculateSalary();
			}
		}
		String report = String.format("common payment - %s%n workers payment - %s%n clerks payment - %s%n", payment, workers, clerks);
		System.out.println(report);

	}

	@Override
	public String getName() {

		return "showPayments";
	}

}
