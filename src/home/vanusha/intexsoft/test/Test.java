package home.vanusha.intexsoft.test;

import java.util.ArrayList;
import java.util.List;

import home.vanusha.intexsoft.test.menu.impls.ClerkSaverImpl;
import home.vanusha.intexsoft.test.menu.impls.CountViewerImpl;
import home.vanusha.intexsoft.test.menu.impls.DetailsViewerImpl;
import home.vanusha.intexsoft.test.menu.impls.EmployeeEraserImpl;
import home.vanusha.intexsoft.test.menu.impls.PaymentViewerImpl;
import home.vanusha.intexsoft.test.menu.impls.PersonalViewerImpl;
import home.vanusha.intexsoft.test.menu.impls.WorkerSaverImpl;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class Test {

	public static void main(String[] args) {
		List<ICommand> menu = new ArrayList<ICommand>();
		ICommand saveWorker = new WorkerSaverImpl();
		ICommand saveClerk = new ClerkSaverImpl();
		ICommand fireEmloyee = new EmployeeEraserImpl();
		ICommand countWiever = new CountViewerImpl();
		ICommand showDetails = new DetailsViewerImpl();
		ICommand showPayments = new PaymentViewerImpl();
		ICommand showList = new PersonalViewerImpl();
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
