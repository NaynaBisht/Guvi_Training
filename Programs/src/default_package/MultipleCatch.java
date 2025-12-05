package default_package;

public class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            int[] arr = new int[5];
            arr[6] = 10 / 0; // May cause Arithmetic or ArrayIndexOutOfBounds
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception caught");
        } catch (Exception e) {
            System.out.println("General Exception caught");
        }
	}

}
