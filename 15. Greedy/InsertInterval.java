import java.util.*;
public class InsertInterval {

    int[][] insert(int[][] intervals, int[] newInterval){
        ArrayList<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        //left
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //overlapping
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Integer.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Integer.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        //right
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        int[][] ans = res.toArray(new int[res.size()][]);
        return ans;
    }




    public static void main(String[] args) {
    InsertInterval obj = new InsertInterval();
    int[][] intervals = {{1,2},{3,5}, {6,7}, {8,10}, {12,16}};
    int[] newInterval = {4,8};
    int[][] result = obj.insert(intervals, newInterval);

    System.out.println(Arrays.deepToString(result));
}
}
