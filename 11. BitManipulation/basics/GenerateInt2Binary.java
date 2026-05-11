import java.util.*;
public class GenerateInt2Binary {
    
    public void Int2Binary(int n){
        for(int i = 31; i>=0; i--){
            int bit = ((n >> i) & 1);
            System.out.print(bit);
        }
    }


    public static void main(String[] args) {
        GenerateInt2Binary ob = new GenerateInt2Binary();
        ob.Int2Binary(3); //011
    }
}
