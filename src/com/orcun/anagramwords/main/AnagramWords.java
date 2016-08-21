package com.orcun.anagramwords.main;

import java.util.Scanner;
import java.util.HashMap;

public class AnagramWords {

	private static HashMap<String, Integer> mappedValue;
	
	public AnagramWords() {
		// TODO Auto-generated constructor stub
	}
	
	private static int calculateWordValue(String word) {
		int calculateValue = 0;
		char[] letterChar = word.toCharArray();
		
		for(char temp : letterChar) {
			if(mappedValue.containsKey(String.valueOf(temp))){
				calculateValue = calculateValue + mappedValue.get(String.valueOf(temp));
			}
		}
		
		return calculateValue;
	}
	
	public static HashMap<String, Integer> createPrimeNumberList() {
		
		HashMap<String, Integer> primeNumbers = new HashMap<>();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toLowerCase();
		
		char[] alphabetList = alphabet.toCharArray();
		int limit = 100;
		int index = 0;
		int i = 0;
		boolean isPrime = true;
		
		for(i = 2; i < limit; i++) {
			isPrime = true;
			
			for(int j = 2; j < i; j++) {
				if(i%j == 0) {
					isPrime = false;
					break;
				}
			}
			
			// Printing the number
			if(isPrime){
				try{
					primeNumbers.put(String.valueOf(alphabetList[index]), i);
					//System.out.println(i + " ");
					index++;
				}catch(ArrayIndexOutOfBoundsException ex){
					return primeNumbers;
				}
			}
		}
		
		return primeNumbers;
	}
	
	static boolean isAnagram(String firstWord, String secondWord){
		
		if(firstWord.length() != secondWord.length())
			return false;
		else{
            if (calculateWordValue(firstWord) != calculateWordValue(secondWord)) {
                return false;
            } else {
                return true;
            }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String firstWord = scanner.next();
		String secondWord = scanner.next();
		scanner.close();
		
		mappedValue = createPrimeNumberList();
		boolean	result = isAnagram(firstWord, secondWord);
		
		System.out.println(result ? "Words are anagram" : "Words are not anagram");

	}

}
