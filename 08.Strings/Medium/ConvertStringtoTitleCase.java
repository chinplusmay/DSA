import java.util.Scanner;

public class ConvertStringtoTitleCase {

// Input:
// 5
// hello world
// this is a CODECHEF problem
// WELCOME to the JUNGLE
// the quick BROWN fOx
// programming in PYTHON

// Output:
// Hello World
// This Is A CODECHEF Problem
// WELCOME To The JUNGLE
// The Quick BROWN Fox
// Programming In PYTHON


public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();

    while(t-- > 0){
        StringBuilder res = new StringBuilder();
        String[] words = sc.nextLine().split("\\s+");

        for(String word : words){ // for acronyms "CAT"
            if(word.equals(word.toUpperCase())){
                res.append(word).append(" ");
            }

            else{ // for normal "hello"
                char First = Character.toUpperCase(word.charAt(0));
                String Rest = word.substring(1).toLowerCase();

                res.append(First).append(Rest).append(" ");
            }

        }
        System.out.println(res.toString().trim());
    }

}
}
