package default_package;

public class ArrayIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds!");
        }
	}

}
