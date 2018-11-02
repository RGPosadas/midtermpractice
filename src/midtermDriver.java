import java.util.Stack;
public class midtermDriver {

    public static void push(String str, String[] arr) {
        int pushTo = size(arr) + 1;
        arr[pushTo] = str;
    }

    public static String pop(String[] arr) {
        int toPop = size(arr);
        String temp = arr[toPop];
        arr[toPop] = "I'M EMPTY";
        return temp;
    }

    public static boolean hasLeftChild(int node, String[] arr){
        if (node*2+1 > size(arr))
            return false;
        return true;

    }

    public static int size(String[] arr) {
        int i = -1;
        for (i = 0; i < arr.length; i++) {
            if (arr[i].equals("I'M EMPTY"))
                break;
        }
        return i;
    }

    public static int leftChild(int index, String[] arr) {
        int newIndex = 2*index + 1;
        int size = size(arr);
        if (newIndex > size)
            return -1;
        else
            return newIndex;
    }

    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E", "F"};
//        Stack<String> myStack = new Stack<>();
        String[] myStack = new String[10];
        for (int i = 0; i < myStack.length; i++) {
            myStack[i] = "I'M EMPTY";
        }

        String father = arr[0];
        int fatherIndex = 0;

        while (hasLeftChild(fatherIndex, arr)) {
            System.out.println("Pushing " + father + " to stack" );
            push(father, myStack);
            int newLeftChildIndex = leftChild(fatherIndex, arr);
            // increment father
            if (newLeftChildIndex == -1)
                break;
            father = arr[newLeftChildIndex];
            fatherIndex = newLeftChildIndex;
//            System.out.println(father);
        }

        for (int i = 0; i < myStack.length; i++) {
            System.out.println(myStack[i]);
        }

//        System.out.println(pop(myStack));
    }
}
