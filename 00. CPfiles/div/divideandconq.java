import java.util.*; 

public class divideandconq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb =  new StringBuilder();

        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();


            if(x % y == 0){
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}

