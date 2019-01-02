package home.vanusha.intexsoft.test.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import home.vanusha.intexsoft.test.entities.Recruit;
import home.vanusha.intexsoft.test.enums.RateOfPay;

public class Utils {
	private static List<Recruit> repository = new LinkedList<Recruit>();
	private final static int STORE_LIMIT = 3;

	public static int getStoreLimit() {
		return STORE_LIMIT;
	}

	public static List<Recruit> getRepository() {
		return repository;
	}

	private Utils() {
		super();
	}

	public static String getStringFromUser() {
		Scanner scanner = new Scanner(System.in);
		String stringFromUser = scanner.nextLine();

		return stringFromUser;

	}

	public static String getValidString() {
		String validString;
		while (true) {
			validString = getStringFromUser();
			if (validString.length() > 0 && !(validString.matches(".*\\d+.*"))) {
				break;
			} else {
				System.err.println("No numbers, no empty string please.");
			}
		}
		return validString;
	}

	public static boolean isUniqueLastName(String lastName) {
		boolean unique = true;
		if (repository.size() == 0) {
			return unique;
		}
		for (Recruit recruit : repository) {
			if (recruit.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				unique = false;
			}
		}
		return unique;

	}

	public static RateOfPay getRateOfPay() {
		RateOfPay rate = null;
		while (true) {
			String stringRate = Utils.getStringFromUser();
			switch (stringRate.toLowerCase()) {
			case ("half"):
				rate = RateOfPay.HALF;
				break;
			case ("full"):
				rate = RateOfPay.FULL;
				break;
			case ("increased"):
				rate = RateOfPay.INCREASED;
				break;
			default:
				System.out.println("Incorrect data, try again");
			}
			if (rate != null) {
				break;
			}
		}
		return rate;
	}

	public static double getValidDouble() {
		double value = -1;
		while (true) {
			String stringFromUser = Utils.getStringFromUser();
			try {
				value = Double.parseDouble(stringFromUser);
			} catch (NumberFormatException e) {
				System.err.println("Use numbers only please.");
			}
			if (value < 0) {
				System.err.println("No negative values please.");
			} else {
				break;
			}
		}
		return value;
	}

	public static void save(Recruit recruit) {
		repository.add(recruit);

	}

	public static void fireEmployee(String lastName) {

		List<Recruit> newRepository = new LinkedList<Recruit>();
		for (Recruit recruit : repository) {
			if (recruit.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				continue;
			}
			newRepository.add(recruit);
		}
		repository = newRepository;
	}

	public static Recruit getDetails(String lastName) {
		for (Recruit recruit : repository) {
			if (recruit.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
				return recruit;
			}
		}
		return null;
	}
}
