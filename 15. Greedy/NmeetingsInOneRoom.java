import java.util.*;

class Pair{
    int start;// start
    int end;// end
    Pair(int a, int b){
        this.start = a;
        this.end = b;
    }
}
public class NmeetingsInOneRoom {
    // find the max profit can be done
    
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        // sort both arrays in order of end time so that we can have more maxMeetings
        Pair[] pairs = new Pair[n];
        for(int i = 0; i<n; i++){
            pairs[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.end, p2.end));
        // compare the prev end time with next start time
        // prev end time should be less than the nxt start time
        int meetings = 1;
        int prevEnd = pairs[0].end;
        for(int i = 1; i<n; i++){
            if(prevEnd < pairs[i].start){
                meetings++;
                prevEnd = pairs[i].end;
            }
        }
        return meetings;
    }


    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        // ans = 4: (1,2) (3,4) (5,7) (8,9)

        NmeetingsInOneRoom obj = new NmeetingsInOneRoom();

        int ans = obj.maxMeetings(start, end);
        System.out.println(ans);
    }
}


