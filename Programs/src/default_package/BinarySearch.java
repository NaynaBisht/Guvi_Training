package default_package;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 6, 7, 17, 29, 31, 8, 67, 89, 101};
        int key = 8;
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
        	System.out.print(arr[i] + " ");
        }
        System.out.println();

        int low = 0;
        int high = arr.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                System.out.println(key + " found at index " + mid);
                found = true;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println(key + " not found");
        }
	}

}
