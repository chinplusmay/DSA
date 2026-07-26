import java.io.IOException;
import java.util.*;

public class temp {
    
    public static void main(String[] args) throws IOException {
  

        Scanner sc = new Scanner(System.in);

        String l1 = sc.nextLine();
        String l2 = sc.nextLine();

        String[] ls1 = l1.trim().split(" ");
        String[] ls2 = l2.trim().split(" ");

        int[] arr1 = new int[ls1.length]; 
        int[] arr2 = new int[ls2.length]; 

        for(int i = 0; i<ls1.length; i++){
            arr1[i] = Integer.parseInt(ls1[i]);
        }
        
        for(int i = 0; i<ls2.length; i++){
            arr2[i] = Integer.parseInt(ls2[i]);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;

        int n = arr1.length + arr2.length;
        int[] ans = new int[n];

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2){
            ans[k++] = arr1[i++];
            ans[k++] = arr2[j++];

        }

        while(i < n1){
            ans[k++] = arr1[i++];
        }

        while(j < n2){
            ans[k++] = arr2[j++];
        }

        // List<Integer> even = new ArrayList<>();
        // for(int l = 0; l<n; l++){
        //     if(ans[l] % 2 == 0){
        //         even.add(ans[l]);
        //     }
        // }
        // System.out.println(Arrays.toString(ans));

        // Collections.sort(even);

        // int e = 0;
        // for(int l = 0; l<n; l++){
        //     if(ans[l] % 2 == 0){
        //         ans[l] = even.get(e++);
        //     }
        // }

        for(int pass = 0; pass < n-1; pass++){

            for(int e = 0; e<n-1-pass; e++){

                if(ans[e] % 2 == 0){

                    int nextInd = e+1;

                    while (nextInd > n && ans[nextInd] % 2 == 0) {
                        nextInd++;
                    }

                    if(nextInd < n && ans[e] > ans[nextInd]){
                        ans[e] = ans[e] + ans[nextInd];
                        ans[nextInd] = ans[e] - ans[nextInd];
                        ans[e] = ans[e] - ans[nextInd];
                    }
                }
            }
        }





       System.out.println(Arrays.toString(ans));
    //    System.out.println(even);

        


    }
}
