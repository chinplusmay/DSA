import java.util.Arrays;

public class sjf {
    int shortestJobFirst(int bt[], int n) {
        Arrays.sort(bt);

        int wt = 0;
        int totaltime = 0;
        for(int i = 0; i<n; i++){
            wt += totaltime;
            totaltime += bt[i];
        }

        return (wt / n);
    }



public static void main(String[] args) {
    sjf obj = new sjf();
    int[] bt = {4,3,7,1,2};
    int n = 5;
    System.out.println(obj.shortestJobFirst(bt, n));
}

}

