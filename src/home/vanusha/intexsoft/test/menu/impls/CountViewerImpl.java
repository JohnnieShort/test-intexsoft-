package home.vanusha.intexsoft.test.menu.impls;

import home.vanusha.intexsoft.test.entities.Clerk;
import home.vanusha.intexsoft.test.entities.Recruit;
import home.vanusha.intexsoft.test.entities.Worker;
import home.vanusha.intexsoft.test.menu.interfaces.ICommand;
import home.vanusha.intexsoft.test.utils.Utils;

public class CountViewerImpl implements ICommand{

	@Override
	public void execute() {
		if(Utils.getRepository().size()==0) {
			System.err.println("No employees recruited yet...");
			return;
		}
		int workersCount = 0;
		int clerksCount = 0;
		for(Recruit recruit: Utils.getRepository()) {
			if(recruit instanceof Worker) {
				workersCount++;
			}
			if(recruit instanceof Clerk) {
				clerksCount++;
			}
		}
		String count = String.format("Number of workers - %d%nNumber of clerks - %d%n", workersCount, clerksCount);
		System.out.println(count);
	}

	@Override
	public String getName() {
		
		return "showCount";
	}

}
