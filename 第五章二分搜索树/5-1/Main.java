public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);
        //结果
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
        bst.preOrder2();

        bst.levelOrder();


        System.out.println();

        System.out.println(bst);
    }
}