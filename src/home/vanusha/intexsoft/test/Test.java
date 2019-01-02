package home.vanusha.intexsoft.test;

import java.util.ArrayList;
import java.util.List;

import home.vanusha.intexsoft.test.menu.impls.ClerkSaver;
import home.vanusha.intexsoft.test.menu.impls.CountWiever;
import home.vanusha.intexsoft.test.menu.impls.DetailsWiever;
import home.vanusha.intexsoft.test.menu.impls.EmployeeEraser;
import home.vanusha.intexsoft.test.menu.impls.PaymentWiever;
import home.vanusha.intexsoft.test.menu.impls.PersonalWiever;
import home.vanusha.intexsoft.test.menu.impls.WorkerSaver;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class Test {

	public static void main(String[] args) {
		List<ICommand> menu = new ArrayList<ICommand>();
		ICommand saveWorker = new WorkerSaver();
		ICommand saveClerk = new ClerkSaver();
		ICommand fireEmloyee = new EmployeeEraser();
		ICommand countWiever = new CountWiever();
		ICommand showDetails = new DetailsWiever();
		ICommand showPayments = new PaymentWiever();
		ICommand showList = new PersonalWiever();
 		menu.add(saveWorker);
		menu.add(saveClerk);
		menu.add(fireEmloyee);
		menu.add(countWiever);
		menu.add(showDetails);
		menu.add(showPayments);
		menu.add(showList);
		
		while(true) {
			for(ICommand command: menu) {
				System.out.println(command.getName());
			}
			System.out.println("Choose and print command(-quit to exit)");
			String stringFromUser = Utils.getStringFromUser();
			if("-quit".equals(stringFromUser)) {
				break;
			}
			for(ICommand command: menu) {
				if(command.getName().equals(stringFromUser)) {
					try {
					command.execute();
					} catch(UnsupportedOperationException e) {
						System.err.println(e.getMessage());
					}
				}
			}
			
			System.out.println("Please, choose");
		}
		
	}

}
