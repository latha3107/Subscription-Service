import java.util.Arrays;

public class Array {
	public static void main(String[] args){
		String[] array = new String[3]; //declare array & initialize it & allocate memory
		String[] arr = {"A","B","C"};
		for (int i=0; i<array.length; i++) {
			array[i]= arr[i];
			System.out.println("array[i]: "+Arrays.toString(array));
		}
		
		System.out.println("array: "+Arrays.toString(array));
	}
}
