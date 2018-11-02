import java.sql.SQLOutput;
import java.util.Stack;
public class Traversals {

    public static int[] arr = {1,2,3,4,5,6,7,8,9};

    public static Stack<Integer> myStack = new Stack<>();

    public static boolean hasLeftChild(int index) {
        if (index*2+1 >= arr.length)
            return false;
        return true;
    }

    public static boolean hasRightChild(int index) {
        if (index*2+2 >= arr.length)
            return false;
        return true;
    }

    public static void inorderRecursive(int index) {
        if (hasLeftChild(index))
            inorderRecursive(index*2+1);
        System.out.print(arr[index] + " ");
        if (hasRightChild(index))
            inorderRecursive(index*2+2);
    }

    public static void postorderRecursive(int index) {
        if (hasLeftChild(index))
            postorderRecursive(index*2+1);
        if (hasRightChild(index))
            postorderRecursive(index*2+2);
        System.out.print(arr[index] + " ");

    }

    public static void preorderRecursive(int index) {
        System.out.print(arr[index] + " ");
        if (hasLeftChild(index))
            preorderRecursive(index*2+1);
        if (hasRightChild(index))
            preorderRecursive(index*2+2);
    }

    public static int leftChild(int index) {
        return 2*index+1;
    }

    public static int rightChild(int index) {
        return 2*index+2;
    }

    public static void inorderIterative(int index) {
        //Push root and then every node's left child to the stack
        while (hasLeftChild(index)) {
//            System.out.println("\nPushing to stack my index " + index);
            myStack.push(index);
            index = leftChild(index);

            //Only happens ONCE when the node does not have a left child but is not popped to stack
            if (!hasLeftChild(index)) {
                myStack.push(index);
//                System.out.println("\nhehPushing to stack my index " + index);

            }
        }

        //While popping all the left children (they're also parents) from the stack, print yourself then push right child
        while (!myStack.isEmpty()) {
            int node = myStack.pop();
//            System.out.println("Popped out index " + node);
            System.out.print(arr[node] + " ");
            if (hasRightChild(node)) {
//                System.out.println("Index " + node + " has a right  child and is at popped from index " + rightChild(node));
                myStack.push(rightChild(node));
            }
        }
        myStack.clear();
    }

    public static void preorderIterative(int index) {
        //Pop root to stack
        myStack.push(index);

        //While stack is not empty, pop the stack and print the node, push right then left child to stack, repeat until stack is not empty
        while (!myStack.isEmpty()) {
            int node = myStack.pop();
            System.out.print(arr[node] + " ");
            //Push right children first so the left child gets processed first from stack
            if (hasRightChild(node)) {
//                System.out.println("\nPushing to stack my index as right child " + index);
                myStack.push(rightChild(node));
            }
            if (hasLeftChild(node)) {
                myStack.push(leftChild(node));
            }
        }
        myStack.clear();
    }

    public static void postorderIterative(int index) {

    }

    public static void main(String[] args) {

        System.out.print("Recursive inorder: ");
        inorderRecursive(0);

        System.out.print("\nRecursive pre-order: ");
        preorderRecursive(0);

        System.out.print("\nRecursive post-order: ");
        postorderRecursive(0);

        System.out.println("");

        System.out.print("\nIterative inorder: ");
        inorderIterative(0);

        System.out.print("\nIterative pre-order: ");
        preorderIterative(0);

        System.out.println("\nIterative post-order: ");
        postorderIterative(0);
    }
}
