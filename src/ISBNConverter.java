import java.util.Scanner;

public class ISBNConverter {

	public static boolean ValidISBN10(String isbn){

		int x = isbn.length();
		if (x != 10)
			return false;

		int sum = 0;

		int j = 10;

		//calculate weighted sum of first nine digits
		for (int i = 0; i < 9; i++){

			int ch = isbn.charAt(i) - '0';
			if (ch < 0 || ch > 9)
				return false;

			//add value from rhs to lhs
			sum += (ch * (j));

			j--;

		}


		//check last digit for x
		char lastdigit = isbn.charAt(9);

		if (lastdigit == 'X') {
			sum += 10;
		} else
			sum += (isbn.charAt(9) - 4);

		return (sum % 11 == 0);
	}

	public static boolean ValidISBN13(String isbn){

		// create an array that is the length of the scan
		int x = isbn.length();
		if (x != 13)
			return false;

		int sum = 0;

		int j = 1;
		int k = 3;

		//calculate weighted sum of first 12 digits
		for (int i = 0; i < 12; i++){

			int ch = isbn.charAt(i) - '0';
			if (ch < 0 || ch > 9)
				return false;

			//add value from rhs to lhs
			//multiply first number by 1, second by 3, third by 1, and so on
			if (i % 2 ==0) {
				sum += (ch * (j));
			}
			else {
				sum += (ch *(k));
			}
		}


		//check last digit for x
		char lastdigit = isbn.charAt(12);

		if (lastdigit == 'X') {
			lastdigit = 10;
			sum+= lastdigit;
		} else
		{
			sum += (isbn.charAt(12));
		}

		//check for valid checkdigit

		int remainder = (sum % 10);

		if (remainder != 0)
			sum += (10 - remainder);

		return (sum % 10 == 0);
	}

	public static void main (String[] args){

		Scanner in = new Scanner(System.in);

		System.out.println("Enter ISBN: ");

		String isbn = in.next();

		if (ValidISBN10(isbn)) {
			System.out.print("Valid 10-digit ISBN");
		}
		else if (ValidISBN13(isbn)){
			System.out.print("Valid 13-Digit ISBN");
		}else
		System.out.print("Invalid ISBN");

	}
}