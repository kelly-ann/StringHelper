package org.kelly_ann.junit.example;

public class StringHelper {
	/*
	 * Remove all chars 'A' in first 2 positions of the given string
	 * Ex: "ABCD" => "BCD", "AACD" => "CD", "BACD" => "BCD", "AAAA" => "AA", "MNAA" => "MNAA"
	 */
	public String truncateAInFirst2Positions(String str) {
		if(str.length() <= 2)
			return str.replaceAll("A", "");
		
		String first2Chars = str.substring(0,2);
		String stringMinusFirst2Chars = str.substring(2);
		
		return first2Chars.replaceAll("A", "") + stringMinusFirst2Chars;
	}
	
	/*
	 * Check if first two and last two chars in the string are the same.
	 * Hint: substring method. 
	 * Ex: ""=>false, "A"=>false, "AB"=>true, "ABC" => false, "AAA" => true, "ABCAB" => true, "ABCDEBA" => false
	 */
	public boolean areFirstAndLastTwoCharactersTheSame(String str) {
		
		if(str.length() <= 1)
			return false;
		if(str.length() == 2)
			return true;
		
		String first2Chars = str.substring(0, 2);
		
		String last2Chars = str.substring(str.length() - 2);
		
		return first2Chars.equals(last2Chars);
		
	}
}
