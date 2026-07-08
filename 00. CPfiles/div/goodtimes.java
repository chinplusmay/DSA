import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class goodtimes {

    public static boolean isGood(long num) {
        if (num == 0) return true;
        Set<Long> uniqueDigits = new HashSet<>();
        
        while (num > 0) {
            uniqueDigits.add(num % 10); 
            num /= 10;                  
        }
        
        return uniqueDigits.size() <= 2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb =  new StringBuilder();

        while(t-- > 0){
            long x = sc.nextLong();

            for(long y = 2; y<1000000000L; y++){
                if(isGood(y)){
                    if(isGood(x*y)){
                        sb.append(y).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
