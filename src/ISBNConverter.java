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
		int[] userScan = new int[isbn.length()];
		if (userScan.length != 13)
			return false;

		int sum = 0;

		int j = 1;
		int k = 3;

		// loop through scan to capture each digit as it's own position in array userScan
		for (int i = 0; i < userScan.length; i++) {

			// capture each digit in userInput
			int loc = userScan[i];

			//IMPORTANT. Makes sure that loop knows to only look for values between 0-10. Still need to figure out how to calculate x as last digit
			if (loc < '0' || loc > '9')
			{
				throw new IllegalArgumentException("Invalid input");
			}

			//check last digit for x
			char lastdigit = userScan.[i];

			if (lastdigit == 'X') {
				sum += 10;
			} else
				sum += (isbn.charAt(9) - 4);
		}

		return (sum % 11 == 0);
	}

	public static void main (String[] args){

		Scanner in = new Scanner(System.in);

		System.out.println("Enter ISBN: ");

		String isbn = in.next();

		if (ValidISBN10(isbn))
			System.out.print("Valid 10-digit ISBN");
		else
			System.out.print("Invalid 10-digit ISBN");
	}
}