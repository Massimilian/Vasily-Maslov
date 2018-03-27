package ru.job4j.tracker2.start;

public class ValidateInput implements InputSecond {
	private final InputSecond input;
	
	public ValidateInput(final InputSecond input) {
		this.input = input;
	}
	
	@Override
	public String ask(String question) {
		return this.input.ask(question);
	}
	
	@Override
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = this.input.ask(question, range);
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