package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class PersonalWiever implements ICommand {

	@Override
	public void execute() {
		if (Utils.getRepository().size() == 0) {
			System.err.println("No employees recruited yet...");
			return;
		}
		for (int i = 0; i < Utils.getRepository().size(); i++) {
			System.out.println(i+1 + ". " + Utils.getRepository().get(i));
		}
	}

	@Override
	public String getName() {

		return "employeesList";
	}

}
