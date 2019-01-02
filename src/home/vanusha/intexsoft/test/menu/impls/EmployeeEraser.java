package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class EmployeeEraser implements ICommand{

	@Override
	public void execute() {
		if(Utils.getRepository().size()==0) {
			System.err.println("No employees recruited yet...");
			return;
		}
		System.out.println("Insert last name of fired employee...");
		String lastName = Utils.getStringFromUser();
		Utils.fireEmployee(lastName);
	}

	@Override
	public String getName() {
		
		return "fireEmployee";
	}

}
