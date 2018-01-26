package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 12/01/2018
 */
 
 public class StringContainer {
	 
	 /**
	 * To look the equal part of String without casting to char;
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

	 /**
	 * To look the equal part of String;
	 * @param 2 Strings;
	 * @return true or false;
	 */
	 
	 boolean containsVersionOne(String origin, String sub) {
		 char[] originArray = origin.toCharArray();
		 char[] subArray = sub.toCharArray();
		 boolean isThisWordIsAPartOfString = false;
		 int count = 0;
		 if (subArray.length <= originArray.length) {
			for (int i = 0; i <= originArray.length - subArray.length; i++) {
				for (int j = 0; j < subArray.length; j++) {
					if (originArray[i + j] != subArray[j]) {
						break;
					} else {
						count++;
					}
					if (count == subArray.length) {
						isThisWordIsAPartOfString = true;
						break;
						}
					}
					if (isThisWordIsAPartOfString) {
						break;
					}
				}
			} 
		return isThisWordIsAPartOfString;
	}
 }