package ru.job4j.tracker2.start;

public class ValidateInput extends ConsoleInputSecond {
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				System.out.println("Please enter valid data again.");
			} catch (MenuOutException moe) {
				moe.printStackTrace();
				System.out.println("Please select correct menu.");
			}
		} while (invalid);
		return value;
	}
}