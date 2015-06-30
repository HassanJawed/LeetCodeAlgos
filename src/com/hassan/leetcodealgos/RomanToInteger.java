package com.hassan.leetcodealgos;

/**
 * Created by Trikster on 6/27/2015.
 */
public class RomanToInteger {

	private static final char ONE          = 'i';
	private static final char FIVE         = 'v';
	private static final char TEN          = 'x';
	private static final char FIFTY        = 'l';
	private static final char HUNDRED      = 'c';
	private static final char FIVE_HUNDRED = 'd';
	private static final char THOUSAND     = 'm';

	enum LITERALS {
		ONE( 'i', 1 ),
		FIVE( 'v', 5 ),
		TEN( 'x', 10 ),
		FIFTY( 'l', 50 ),
		HUNDRED( 'c', 100 ),
		FIVE_HUNDRED( 'd', 500 ),
		THOUSAND( 'm', 1000 ),;

		char LETTER;
		int VALUE;

		LITERALS (char letter, int value) {
			LETTER = letter;
			VALUE = value;
		}

		public static LITERALS valueOf (char letter) {
			for (LITERALS literal : values()) {
				if(literal.LETTER == letter) return literal;
			}
			return null;
		}
	}

	public static void main (String[] args) {
		System.out.println( romanToInt( "XIV" ) );
		System.out.println( romanToInt( "IX" ) );
		System.out.println( romanToInt( "v" ) );
		System.out.println( romanToInt( "XX" ) );
		System.out.println( romanToInt( "XXXIX" ) );
		System.out.println( romanToInt( "XXXX" ) );
		System.out.println( romanToInt( "MM" ) );
		System.out.println( romanToInt( "MCD" ) );
		System.out.println( romanToInt( "MMMCMXCIX" ) );
		System.out.println( romanToInt( "MMCDXXXIX" ) );
	}

	public static int romanToInteger (String no) {
		int result = 0;
		char[] noArr = no.toLowerCase().toCharArray();
		LITERALS lastLetter = null, thisLetter;
		for (char letter : noArr) {
			thisLetter = RomanToInteger.LITERALS.valueOf( letter );
			if (LITERALS.ONE.LETTER == letter) {
				result += thisLetter.VALUE;
			} else {
				result += thisLetter.VALUE;
				if (lastLetter != null && lastLetter.VALUE < thisLetter.VALUE) {
					result = result - 2 * lastLetter.VALUE;
				}
			}
			lastLetter = RomanToInteger.LITERALS.valueOf( letter );
		}
		return result;
	}

	public static int romanToInt (String no) {
		int result = 0;
		char[] noArr = no.toLowerCase().toCharArray();
		int lastValue = 0,  thisValue;
		for (char letter : noArr) {
			thisValue = getValueOfLetter( letter );
			if (thisValue == 0) return 0;

			result += thisValue;
			if (lastValue != 0 && lastValue < thisValue) {
				result -= (2 * lastValue);
			}
			lastValue = thisValue;

		}
		return result;
	}

	private static int getValueOfLetter (char letter) {
		switch (letter) {
			case ONE:
				return 1;

			case FIVE:
				return 5;

			case TEN:
				return 10;

			case FIFTY:
				return 50;

			case HUNDRED:
				return 100;

			case FIVE_HUNDRED:
				return 500;

			case THOUSAND:
				return 1000;

			default:
				return 0;
		}
	}
}
