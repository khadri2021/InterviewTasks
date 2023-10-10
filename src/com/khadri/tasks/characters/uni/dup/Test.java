package com.khadri.tasks.characters.uni.dup;

import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		String input = "KHADRI SOFTWARE INSTITUTION";

		withOutJava8Duplicates(input);

		withOutJava8Unique(input);

		System.out.println("===========================================");

		withJava8Duplicates(input);
		withJava8Unique(input);

	}// main

	private static void withJava8Unique(String input) {

		Map<Character, Long> mapCharCount = input.chars().mapToObj(eachValue -> (char) eachValue).filter(c -> c != ' ')
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		mapCharCount.forEach((k, v) -> {
			if (v == 1)
				System.out.println(k + " = " + v);
		});
	}

	private static void withJava8Duplicates(String input) {
		Map<Character, Long> mapCharCount = input.chars().mapToObj(eachValue -> (char) eachValue).filter(c -> c != ' ')
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		mapCharCount.forEach((k, v) -> {
			if (v > 1)
				System.out.println(k + " = " + v);
		});
	}

	private static void withOutJava8Duplicates(String input) {
		char[] charArray = input.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			int match = 1;

			char findChar = charArray[i];

			if (findChar != ' ') {
				for (int j = i + 1; j < charArray.length; j++) {

					if (findChar == charArray[j]) {
						match++;
						charArray[j] = '0';
					}

				}
			}

			if (match > 1 && charArray[i] != '0') {
				System.out.println(charArray[i] + " ---> " + match);
			}

		}
	}

	private static void withOutJava8Unique(String input) {
		char[] charArray = input.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			int match = 1;

			char findChar = charArray[i];

			if (findChar != ' ') {
				for (int j = i + 1; j < charArray.length; j++) {

					if (findChar == charArray[j]) {
						match++;
						charArray[j] = '0';
					}

				}
			}

			if ((match == 1 && !Character.isWhitespace(charArray[i])) && charArray[i] != '0') {
				System.out.println("Unique " + charArray[i] + " ---> " + match);
			}

		}
	}
}// class
