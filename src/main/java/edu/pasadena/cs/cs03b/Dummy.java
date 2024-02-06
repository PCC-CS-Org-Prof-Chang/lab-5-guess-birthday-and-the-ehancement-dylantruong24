package edu.pasadena.cs.cs03b;

import java.util.Scanner;

public class Dummy {

	public static void main(String[] args) {
		int N, userNum, setCount;
		int[][] setArray;
		int[] binaryArray, currentSet;

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---------------------------");
		System.out.print("Choose the max number (1 - 255) for the range of the sets: ");
		N = scanner.nextInt() + 1;

		setCount = (int) Math.ceil((Math.log(N) / Math.log(2)));

		setArray = generateSet(setCount);
		binaryArray = new int[setCount];

		for (int i = 0; i < setCount; i++) {
			for (int j = 0; j < Math.ceil(N / 2); j++) {
				System.out.print(setArray[i][j] + ", ");
			}
			System.out.println("");
			System.out.print("Input the number you selected (auto-search): ");
			userNum = scanner.nextInt();
			currentSet = setArray[i];
			
			if (checkSet(currentSet, userNum)) {
				System.out.println("Your number was within the set.");
				binaryArray[setCount - i - 1] = 1;
			}
			else {
				System.out.println("Your number was not within the set.");
				binaryArray[setCount - i - 1] = 0;
			}
			System.out.println("---------------------------");
		}

		System.out.println("Your selected number is: " + binaryToInt(binaryArray));
		System.out.println("---------------------------");
	}

	public static int[][] generateSet(int setCount) {
		int length;
		int[][] sets;
		length = (int) Math.pow(2, setCount);
		sets = new int[setCount][length / 2];

		for (int i = 0; i < setCount; i++) {
			int temp = 0;
			for (int j = 0; j < length; j++) {
				if ((j & (int) Math.pow(2, i)) != 0) {
					sets[i][temp] = j;
					temp++;
				}
			}
		}
		return sets;
	}
	
	public static boolean checkSet(int set[], int num){
		for (int i = 0; i < set.length; i++) {
			if (set[i] == num) {
				return true;
			}
		}
		return false;
	}

	public static int binaryToInt(int[] binaryArray) {
		int num = 0, length;
		length = binaryArray.length - 1;
		for (int i = length; i >= 0; i--) {
			if (binaryArray[length - i] == 1) {
				num += Math.pow(2, i);
			}
		}
		return num;
	}
}