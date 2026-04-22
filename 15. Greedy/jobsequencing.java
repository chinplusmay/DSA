import java.util.*;

public class jobsequencing {

    static class Job{
        int id;	 // Job Id
        int deadline; // Deadline of job
        int profit; // Profit if job is over before or on deadline
    };
    
    int[] JobScheduling(Job arr[], int n){

        int count = 0;
        int profit = 0;

        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

        int mxdead = arr[0].deadline;
        for(int i = 0; i<n; i++){
            mxdead = Integer.max(mxdead, arr[i].deadline);
        }

        //slots Array 
        int[] slots = new int[mxdead+1];
        Arrays.fill(slots, -1);


        for(int i = 0; i<n; i++){
            for(int j = arr[i].deadline; j>=1; j--){
                if(slots[j] == -1){
                    slots[j] = arr[i].id;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{count, profit};
    }

    public static void main(String[] args) {

        int n = 4;
        Job[] arr = new Job[] {
            new Job() {{id = 1; deadline = 4; profit = 20;}},
            new Job() {{id = 2; deadline = 1; profit = 10;}},
            new Job() {{id = 3; deadline = 2; profit = 40;}},
            new Job() {{id = 4; deadline = 2; profit = 30;}}
        };

        jobsequencing obj = new jobsequencing();
        int[] ans = obj.JobScheduling(arr, n);

        System.out.println(ans[0] + " " + ans[1]);
    }

}
