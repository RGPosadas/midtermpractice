import java.sql.SQLOutput;
import java.util.Stack;
import java.lang.Math;
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
        //Push root to Stack
        myStack.push(index);
        //Push all the left children to Stack
        while (hasLeftChild(index)) {
            index = leftChild(index);
//            System.out.println("\nPushing to stack my index " + index);
            myStack.push(index);

        }

        //Do inorder on left subtree but keep root unpopped
        while (myStack.size() != 1) {
            int node = myStack.pop();
//            System.out.println("Popped out index " + node);
            System.out.print(arr[node] + " ");
            if (hasRightChild(node)) {
//                System.out.println("Index " + node + " has a right  child and is at popped from index " + rightChild(node));
                myStack.push(rightChild(node));
            }
        }

        //Now SOP root
        index = myStack.pop(); //array is now empty
        System.out.print(arr[index] + " ");

        //Time to do inorder on right subtree starting from right leaf or root
        index = rightChild(index);
        myStack.push(index);
        while (hasLeftChild(index)) {
            index = leftChild(index);
//            System.out.println("\nPushing to stack my index " + index);
            myStack.push(index);

        }

        //Do inorder on right subtree and pop until empty this time
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
        //Push root to stack
        myStack.push(index);
//        System.out.println("Pushed " + index);

        //Push all left children to stack
//        while (hasLeftChild(index)) {
//            int node = index;
//            index = rightChild(node);
//            System.out.println("\nPushing to stack my index " + index);
//            myStack.push(index);
//            index = leftChild(node);
//            System.out.println("\nPushing to stack my index " + index);
//            myStack.push(index);
//            //Advance to next subtree
//            index = leftChild(node);
//
//        }

        //Do left tree first by gathering left children
        while (hasLeftChild(index)) {
            index = leftChild(index);
//            System.out.println("\nPushing to stack my index " + index);
            myStack.push(index);

        }


        //Time to pop some left children then right children, don't pop root just yet
        while (myStack.size() != 1) {
//        while (!myStack.isEmpty()) {
            int node = myStack.pop();
            System.out.print(arr[node] + " ");
            int parent = parent(node);
            if (hasRightChild(parent) && parent != 0)
                System.out.print(arr[rightChild(parent)] + " ");

        }

        //Push right child of root to stack
        index = 2;
        myStack.push(2);
        while (hasLeftChild(index)) {
            index = leftChild(index);
//            System.out.println("\nPushing to stack my index " + index);
            myStack.push(index);

        }

        //Time to pop some left children then right children as well as root
//        while (myStack.size() != 1) {
        while (!myStack.isEmpty()) {
            int node = myStack.pop();
            System.out.print(arr[node] + " ");
            int parent = parent(node);
            if (hasRightChild(parent) && parent != 0)
                System.out.print(arr[rightChild(parent)] + " ");

        }
        myStack.clear();
    }

    public static int parent(int index) {
        return (int) Math.floor((index-1)/2);
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

        System.out.print("\nIterative post-order: ");
        postorderIterative(0);
    }
}
