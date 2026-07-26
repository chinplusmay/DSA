import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsequences {
    public static List<String> getSubsequences(String s) {
        int n = s.length();
        int total = 1 << n; //2^n

    List<String> subsequences = new ArrayList<>();
        for(int mask = 0; mask<total; mask++){
            StringBuilder subseq  = new StringBuilder();

            for(int i = 0; i<n; i++){
                if((mask & (1 << i)) != 0){
                    subseq.append(s.charAt(i));
                }
            }

            subsequences.add(subseq.toString());
        }

        return subsequences;
    }


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(getSubsequences(s));
    }
}
//   101  (mask = 5)
// & 001  (1 << 0)    ith bit 0
// -------
//   001  (Not zero! -> Append 'a') ith bit is set so add s[i]