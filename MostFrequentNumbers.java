import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program Explanation: This program gets integers from text with loadNumbers function. Afterwards computeFrequency function
 * counts which numbers are repeat how many times and save them. Then with these informations, program is printing most frequent
 * numbers in the end. And show you which number occurs most in the text.
 * @author Efe Ertekin / ID: 041701006
 * @since Feb 21, 2019
 */
public class MostFrequentNumbers {

	/**
	 * Function Explanation: It checks if there is file or not. Then if there is a usable file, it makes calculations with
	 * functions. Afterwards print results.
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "data2.txt"; // assign filename

		File myFile = new File(filename);  // opens the text file

		@SuppressWarnings("unused")
		Scanner myInput = null;  // creating scanner

		try {
			myInput = new Scanner(myFile);  // creating scanner

		} catch (FileNotFoundException e) {

			System.out.println(filename + ": Input file can not be found!\nExiting program...");  // if it can't find file, print this

			System.exit(1);
		}

		int[] numbers = loadNumbers(filename);  // using loadNumbers function

		int[] frequency = computeFrequency(numbers);  // using computeFrequency function

		int mostFrequency=0;  // assign mostFrequency

		for (int a=0; a<frequency.length; a++) {  // This is calculation of most frequent's number
			if (frequency[a]>mostFrequency) {
				mostFrequency=frequency[a];
			}	
		}

		System.out.println("Most Frequent Numbers:");  // print 

		for(int i=0 ; i<frequency.length;i++ ) {  // This loop help us to print result
			if(frequency[i]==mostFrequency) {
				System.out.println("Number: " + i + ", Frequency: " + frequency[i] );
			}
		}	
	}

	/**
	 * Function Explanation: It takes data file. Turns to integer array. Than return it.
	 * @param file, data.txt
	 * @return numbersArray, is integer array that takes integers from file
	 */
	public static int[] loadNumbers(String file) {

		try {  // try

			File num = new File(file);  // creating new file

			Scanner scanner = new Scanner(num);  //new scanner

			int control = 0;  // assign control

			while (scanner.hasNextInt()) {  // while loop to have integer from text
				control++;
				scanner.nextInt();  // scanning next integer
			}

			int[] numbersArray = new int[control];

			Scanner scanner1 = new Scanner(num);

			for (int i = 0; i < numbersArray.length; i++)
				numbersArray[i] = scanner1.nextInt();

			scanner.close();  // closing scanner

			scanner1.close();  // closing scanner1

			return numbersArray;  // return integer array that has integers from file

		}
		catch(Exception e) {  // catch

			return null;  // return null if there is no try 
		}

	}

	/**
	 * Function Explanation: This functions make calculations of frequency. It takes integer array then
	 * use for get which number occur how many time. Then save these informations to freq integer array.
	 * @param array, numbers array which is integer array that keeps integers from data.txt
	 * @return freq, which is integer array. It has numbers occur times.
	 */
	public static int[] computeFrequency(int[]array) {

		int [] freq = new int[array.length];  // creating freq array

		for (int i=0; i<freq.length; i++)  // for loop to assign freq array
			freq [array[i]] ++;

		return freq;  // return freq array


	}

}