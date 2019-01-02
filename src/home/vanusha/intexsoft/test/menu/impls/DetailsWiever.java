package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.entities.Clerk;
import home.vanusha.intexsoft.test.entities.Recruit;
import home.vanusha.intexsoft.test.entities.Worker;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class DetailsWiever implements ICommand{

	@Override
	public void execute() {
		if(Utils.getRepository().size()==0) {
			System.err.println("No employees recruited yet...");
			return;
		}
		System.out.println("Insert last name of employee...");
		String lastName = Utils.getStringFromUser();
		Recruit recruit = Utils.getDetails(lastName);
		if(recruit==null) {
			System.err.println("No employee found for inserted last name");
			return;
		}
		if(recruit instanceof Worker) {
			Worker worker = (Worker) recruit;
			System.out.println(worker);
			return;
		}
		Clerk clerk = (Clerk) recruit;
		System.out.println(clerk);
	}

	@Override
	public String getName() {
		
		return "employeeDetails";
	}

}
