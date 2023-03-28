package telran.arrays;

import java.util.Arrays;

public class MyArraysInt {
	
	public static int[] addNumber(int[] array, int num) {
		int arrRes[] = Arrays.copyOf(array, array.length + 1); //1234
		arrRes[arrRes.length - 1] = num;
		return arrRes;		
	}
	
	public static int[] removeNumber (int[] array, int index) {
		
		int arDest[] = new int[array.length - 1]; 
		
		if(index < 0 || index > array.length - 1) {
			return array;
		}
		
		if(index == array.length - 1) { 
			System.arraycopy(array, 0, arDest, 0, array.length - 1);
		}
		
		if(index == 0) {         
			System.arraycopy(array, 1, arDest, 0, array.length - 1);
		}
		
		if (index > 0 && index < array.length - 1 ) {   
			System.arraycopy(array, index + 1, arDest, index, array.length - 1 - index);
			System.arraycopy(array, 0, arDest, 0, index );			
		}
		
		if (array.length == 1) {
			int empty[] = {};
			return empty;
		}
		return arDest;
		
	}
	
	public static int[] insertNumber(int[] array, int index, int num) {
		
		int[] arDest = new int [array.length + 1];  //arDest= 0, 0, 0, 0, 0 
		if(index < 0 || index > array.length) {
			return array;
		}
		// ind=2, num=5  array=1, 2, 3, 4 -> 0,0,0,0,0 -> arDest=1, 2, 0, 0, 0
		System.arraycopy(array, 0, arDest, 0, index); //1, 2, 3 -> 0,0,0,0 -> 1,2,0,0
		arDest[index] = num; // arDest=1, 2, 5, 0, 0
		System.arraycopy(array, index, arDest, index + 1, array.length - index);
		//1,2,3,4 -> 3, 4 -> 1,2,5,3,4
		return arDest;
		
	}
}
