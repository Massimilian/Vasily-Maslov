package ru.job4j.tracker;

import java.util.*;
/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 06/02/2018
 */
 
 public class ConsoleInput {
	 Scanner scanner = new Scanner(System.in);
	 
	 public String ask(String question) {
		 System.out.printf(question);
		 return scanner.nextLine();
	 }
 }