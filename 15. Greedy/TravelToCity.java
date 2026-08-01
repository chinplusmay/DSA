// infy pyq
// A company has 2N employees.
// The company needs to send exactly N employees to City A and exactly N employees to City B.
// The costs of sending each employee to the cities are determined as follows:
// 1. The cost to send the i-th employee to City A is given by Ali].
// 2. The cost to send the i-th employee to City B is calculated using the formula: Cost to City B = min(A[i], B[i]) + Blil
//Find the minimum total cost to send exactly N employees to City A and exactly N employees to City B.

import java.util.Arrays;
import java.util.Scanner;

public class TravelToCity{

    // take all emp(2n) to city A, then send n emp form A->B (by calculating diff b-a) select least 2 from diffs add to city a sum 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int totalemp = 2*n;
        int[] A = new int[totalemp];
        int[] B = new int[totalemp];

        for(int i = 0; i<totalemp; i++){
            A[i] = sc.nextInt();
        }
        
        for(int i = 0; i<totalemp; i++){
            B[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(A));






        Integer totalCost = 0;
        int[] extraCost = new int[totalemp];

        for(int i = 0; i<totalemp; i++){
            totalCost += A[i];

            int cityBcost = Math.min(A[i], B[i]) + B[i];
            extraCost[i] = cityBcost - A[i];

        }

        Arrays.sort(extraCost);

        for(int i = 0; i<n; i++){ 
            totalCost += extraCost[i];
        }

        System.out.println(totalCost);

    }
}