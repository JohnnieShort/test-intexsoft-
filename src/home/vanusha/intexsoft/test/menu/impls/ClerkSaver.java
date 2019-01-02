package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.entities.Clerk;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class ClerkSaver implements ICommand {
	@Override
	public void execute() {
		if (Utils.getRepository().size() == Utils.getStoreLimit()) {
			throw new UnsupportedOperationException(
					String.format("New employee cannot be recruited - recruited: %d limit: %d",
							Utils.getRepository().size(), Utils.getStoreLimit()));
		}
		Clerk clerk = new Clerk();
		System.out.println("Insert new clerk last name...");
		while (true) {
			String lastName = Utils.getValidString();
			if (Utils.isUniqueLastName(lastName)) {
				clerk.setLastName(lastName);
				break;
			}
			System.err.println("Last name must be unique. Try agein...");
		}

		System.out.println("Insert new clerk name...");
		clerk.setName(Utils.getValidString());

		System.out.println(
				"Choose from \"half\" \"full\" or \"increased\" and print you're choice to set rate of pay...");
		clerk.setRateOfPay(Utils.getRateOfPay());

		System.out.println("Insert bonus...");
		clerk.setBonusPercentage((int) Utils.getValidDouble());

		Utils.save(clerk);
		System.out.println("New clerk added: " + clerk);

	}

	@Override
	public String getName() {

		return "saveClerk";
	}

}
