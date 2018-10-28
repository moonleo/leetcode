package utils;

public class ArraysUtil {
	public static int[] create(int... args) {
		int[] result = new int[args.length];
		for(int i=0; i<args.length; i++) {
			result[i] = args[i];
		}
		return result;
	}

	public static void print(int[] array) {
		for(int i: array) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
