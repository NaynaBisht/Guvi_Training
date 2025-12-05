package default_package;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1002,110,23445,6789,9807,6455,75432};

	        for (int i = 1; i < arr.length; i++) {
	            int key = arr[i];
	            int j = i - 1;

	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j--;
	            }

	            arr[j + 1] = key; 
	        }

	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	}

}
