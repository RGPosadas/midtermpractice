import java.util.Stack;
public class midtermDriver {


    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5,6,7};
        int[] newArr = new int[intArr.length];
        int i = 0;
        int j = intArr.length;
        for (i = 0, j = intArr.length-1 ; i < intArr.length && j >= 0; i++, j-- ) {
            newArr[j] = intArr[i];
        }

        for (int k = 0; k < newArr.length; k++)
            System.out.println(newArr[k] + " ");
    }
}
