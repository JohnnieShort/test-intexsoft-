package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.entities.Worker;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class WorkerSaverImpl implements ICommand {

	@Override
	public void execute() {
		if (Utils.getRepository().size() == Utils.getStoreLimit()) {
			throw new UnsupportedOperationException(
					String.format("New employee cannot be recruited - recruited: %d limit: %d",
							Utils.getRepository().size(), Utils.getStoreLimit()));
		}
		Worker worker = new Worker();
		System.out.println("Insert new worker last name...");
		while (true) {
			String lastName = Utils.getValidString();
			if (Utils.isUniqueLastName(lastName)) {
				worker.setLastName(lastName);
				break;
			}
			System.err.println("Last name must be unique. Try agein...");
		}

		System.out.println("Insert new worker name...");
		worker.setName(Utils.getValidString());

		System.out
				.println("Choose from \"half\" \"full\" or \"increased\" and print youre choice to set rate of pay...");
		worker.setRateOfPay(Utils.getRateOfPay());
		
		System.out.println("Insert hourly rate...");
		worker.setHourlyRate((int)Utils.getValidDouble());
		
		System.out.println("Insert quantity of hours...");
		worker.setHoursQuantity(Utils.getValidDouble());
		
		Utils.save(worker);
		System.out.println("New worker added: " + worker);
	}

	@Override
	public String getName() {

		return "saveWorker";
	}

}
