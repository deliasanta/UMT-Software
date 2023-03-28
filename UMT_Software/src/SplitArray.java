import java.util.*;

public class SplitArray {
    public static boolean SplitArray(int[] A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // We sort the array A to make the distribution into the 2 lists easier
        Arrays.sort(A);

        // We traverse the array A in reverse, adding each element to either list B or C,
        // depending on the current sum of the elements in lists B and C
        int i = A.length - 1;
        int sumB = 0;
        int sumC = 0;

        while (i >= 0) {
            if (sumB <= sumC) { //We check if the sum of the elements in B is greater than or not equal to the sum of the elements in C.
                B.add(A[i]);    //If it is not,
                sumB += A[i];   //we add the element from A to list B
            } else {
                C.add(A[i]);    //If it is ,
                sumC += A[i];   //we add the element from A to list C
            }
            i--;
        }

        // If either list B or C is empty, it means that there is no way to divide the elements
        // so that their averages are equal, so we return false
        if (B.size() == 0 || C.size() == 0) {
            return false;
        }

        // We calculate the average of the elements in lists B and C and compare them
        double avgB = (double) sumB / B.size();
        double avgC = (double) sumC / C.size();
        return avgB == avgC;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> B = new ArrayList<>(); // We create two empty arrays
        ArrayList<Integer> C = new ArrayList<>();
        boolean result = SplitArray(A, B, C);
        System.out.println(" B: " + B);
        System.out.println(" C: " + C);
        System.out.println(result);
    }
}
