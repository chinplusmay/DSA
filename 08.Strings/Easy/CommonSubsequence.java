import java.util.*;
public class CommonSubsequence {
    public boolean commonSubseq(String s1, String s2) {
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        
        Set<Character> set = new HashSet<>();
        
        for(char c : s1.toCharArray()){
            set.add(c);
        }
        
        for(char c : s2.toCharArray()){
            if(set.contains(c)) return true;
        
        }
        
        return false;
      
        
    }

    public static void main(String[] args) {
        CommonSubsequence ob = new CommonSubsequence();
        String s1 = "abc";
        String s2 = "efac";

        System.out.println(ob.commonSubseq(s1, s2));
    }
}
