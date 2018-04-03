package ru.job4j.tracker2.start;

public class StubInputSecond implements InputSecond {
	private String[] answers;
	private int position = 0;
	
	public StubInputSecond(String[] answers) {
		this.answers = answers;
	}
	
	public String ask(String question) {
		return answers[position++];
	}
	
	public int ask(String question, int[] range) {
//		throw new UnsupportedOperationException("Unsupported operation");
//		return -1;
		return Integer.parseInt(answers[position++]);
	}
}