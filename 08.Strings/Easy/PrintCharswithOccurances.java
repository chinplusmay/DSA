import java.util.*;

// Find Character Frequencies in Order of Occurrence
public class PrintCharswithOccurances {
    static String modifyString(String s) {
        Map<Character, Integer> mp = new LinkedHashMap<>(); //sorted the way inserted

        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        mp.forEach((k, v) -> {
            res.append(k).append(v).append(" ");
        });

        return res.toString().trim();

    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";   // g2 e4 k2 s2 f1 o1 r1
        System.out.println(modifyString(s));
    }
}
