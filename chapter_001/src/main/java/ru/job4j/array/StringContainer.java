package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 12/01/2018
 */
 
 public class StringContainer {
	 
	 /**
	 * To prepare the matrix with multiplied integers;
	 * @param 2 Strings;
	 * @return true or false;
	 */
	 
	 boolean contains(String origin, String sub) {
		 if (origin.equals(sub)) {
			 return true;
		 }
		 String[] originArray = origin.split("");
		 String[] subArray = sub.split("");
		 if (subArray.length > originArray.length) {
			 return false;
		 }
		 for (int i = 0; i <= originArray.length - subArray.length; i++) {
			 int allLetters = 0;
			 for (int j = 0; j < subArray.length; j++) {
				 if (originArray[i + j].equals(subArray[j])) {
					 allLetters++;
				 } else {
					 break;
				 }
				 if (allLetters == subArray.length) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
 }