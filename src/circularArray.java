import java.util.EmptyStackException;
public class circularArray {

    public static final int N = 10;
    public static int f ;
    public static int r ;
    public static int[] myArr = new int[N];

    public static int size() {
        return ((N - f + r) % N);
    }

    public static boolean isEmpty() {
        return (f == r);
    }

    public static void doubleArray() {
        int[] newArr = new int[myArr.length*2];
        //fill front
        for (int i = 0; i < newArr.length; i++) {
            if (myArr[i] != 0)
                newArr[i] = myArr[i];
            else
                break;
        }
        //fill back
        for (int i = newArr.length - 1; i >= 0; i--) {
            if (myArr[i-N] != 0)
                newArr[i] = myArr[i-N];
            else
                break;
        }

        //reset f and r
        //if front is behind r
        if (f < r)
            r = r + N;
        else
            f = r + N;
        System.out.println("f is " + f + ", r is " + r);

        myArr = newArr;
    }

    public static void enqueue(int e) {
        if (size() == N - 1) {
            doubleArray();
        }
        myArr[r] = e;
        r = (r + 1) % N;
    }

    public static int dequeue() {
        if (isEmpty())
            throw new EmptyStackException();
        int temp = myArr[f];
        myArr[f] = 0;
        f = (f + 1) % N;
        return temp;
    }

    public static void main(String[] args) {
        f = r = 0;
//        int[] myArr = new int[N];
        System.out.print("[");
        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }
        System.out.println("]");

        enqueue(1);
//        System.out.println("f is " + f + ", r is " + r);
        enqueue(2);
//        System.out.println("f is " + f + ", r is " + r);

        enqueue(3);
//        System.out.println("f is " + f + ", r is " + r);

        enqueue(4);

        dequeue();
//        System.out.println("f is " + f + ", r is " + r);
        enqueue(5);
        enqueue(6);
        enqueue(7);
        enqueue(8);
        enqueue(9);
        enqueue(10);

        dequeue();

//                System.out.println("f is " + f + ", r is " + r);
        enqueue(11);
        System.out.print("[");
        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }

//        System.out.println("f is " + f + ", r is " + r);
//
//        System.out.println("f is " + f + ", r is " + r);



        System.out.println("]");
        dequeue();
        enqueue(12);
        enqueue(13);

//        System.out.println("f is " + f + ", r is " + r);

        System.out.print("[");
        for (int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }
        System.out.println("]");




    }
}
