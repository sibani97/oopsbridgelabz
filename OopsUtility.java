package com.bridgelabz.oops;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class OopsUtility {
	
	public static String replaceExpressionDemonstration(String string, String firstName, String lastName,
			String phoneNumber) {
		string = string.replaceAll("<<name>>", firstName);
		string = string.replaceAll("<<full name>>", firstName+" "+lastName);
		string = string.replaceAll("xxxxxxxxxx", phoneNumber);
		LocalDate ldate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String day = ldate.format(formatter);

		string = string.replaceAll("01/01/2016", day);
		return string;

}
	
	public class Utility {
		Scanner scanner;
		Random random;

		public Utility() {
			scanner = new Scanner(System.in);
			random = new Random();
		}

		/**
		 * Generating Random Numbers with bound
		 * 
		 * @param bound
		 * @return generated Random Number
		 */public int[][] sort(int[][] deck) {
				int size = 9;
				int[] player1 = new int[size];
				int[] player2 = new int[size];
				int[] player3 = new int[size];
				int[] player4 = new int[size];
				for(int i=0;i<4;i++) {
					for(int j=0;j<size;j++) {
						if(i==0)
							player1[j] = deck[i][j];
						else if(i==1)
							player2[j] = deck[i][j];
						else if(i==2)
							player3[j] = deck[i][j];
						else if(i==3)
							player4[j] = deck[i][j];
					}
				}
				player1 = bubbleSort(player1);
				player2 = bubbleSort(player2);
				player3 = bubbleSort(player3);
				player4 = bubbleSort(player4);
				int[][] array = new int[4][size];
				for(int i = 0;i<4;i++) {
					for(int j=0;j<size;j++) {
						if(i==0) 
							array[i][j] = player1[j];
						else if(i==1)
							array[i][j] = player2[j];
						else if(i==2)
							array[i][j] = player3[j];
						else if(i==3)
							array[i][j] = player4[j];
					}
				}

				return array;
		}
		 private int[] bubbleSort(int[] array) {
				for(int i=0;i<array.length;i++) {
					for(int j=0;j<array.length-1;j++) {
						if((array[j]%13)>(array[(j+1)])%13) {
							int temp = array[j];
							array[j] = array[j+1];
							array[j+1] = temp;
						}
					}
				}
				return array;
			}

		public int inputRandom(int bound) {
			try {
				return random.nextInt(bound);
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
		/**
		 * Generating Random Numbers without bound
		 * 
		 * @return generated Random Number
		 */
		public int inputRandom() {
			try {
				return random.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}

	public int[][] shuffle() {
		int size = 9;
		int[][] cards= new int[4][size];
		
		cards = randomArray(size);
		return cards;
}
	private int[][] randomArray(int size) {
		int r=0;
		int c=0;
		int random = 0;
		int x = 0;
		int bound = 52;
		int[][] array = new int[4][size];
		while(c<4) {
			r=0;
			x=0;
			
		while(r<size) {
			if(r==0 && c==0 )
				array[c][r] = inputRandom(bound);
			else {
				int z = 0;
				x = 0;
				while(z==0) {
					random = inputRandom(bound);
					x=0;
					z=0;
					for(int i=0;i<4;i++) {
						for(int j=0;j<size;j++) {
							if(array[i][j]==random)
								x++;
						}
					}
					if(x==0) {
						array[c][r] = random;
						z++;
					}
				}
				}
			r++;
			}
		c++;
		}
		return array;
}
	
	}

	
	}

