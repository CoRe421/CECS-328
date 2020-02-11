/**
 * Cory Reardon CECS 328-01
 * 017590909
 */
public class InsertionSortCoryReardon {
    /**
     * The Node class
     */
    public static class Node {
        private Node mPrev;
        private Node mNext;
        private String mData;
        public Node(String data) {
            mPrev = null;
            mNext = null;
            mData = data;
        }

        /**
         * Sets the current node's previous node instance variable to the one given.
         * @param n The node to be pointed to.
         */
        public void setPrev(Node n) {
            mPrev = n;
        }
        /**
         * Sets the current node's next node instance variable to the one given.
         * @param n The node to be pointed to.
         */
        public void setNext(Node n) {
            mNext = n;
        }

        /**
         * Sets the current node's data.
         * @param data The data for the node to have.
         */
        public void setData(String data) {
            mData = data;
        }
    }

    /**
     * The main function.
     * @param args The arguments being submitted through the command line.
     */
    public static void main(String[] args) {
        /**
         * Checks to see if the list has more than one element to sort.
         */
        if (args.length > 1) {
            Node Head = new Node(args[0].toLowerCase());
            /**
             * Iterates through the list, creating a doubly linked list out of the given parameters.
             */
            for (int i = 1; i < args.length; i++) {
                Node n = new Node(args[i].toLowerCase());
                if (Head.mNext == null) {
                    Head.setNext(n);
                    Head.setPrev(n);
                    n.setNext(Head);
                    n.setPrev(Head);
                } else {
                    Head.mPrev.setNext(n);
                    n.setPrev(Head.mPrev);
                    n.setNext(Head);
                    Head.setPrev(n);
                }
            }
            Node iter = Head;
            /**
             * Compares the data at the current node being pointed to with the one before it, switching them if the data is in the wrong order until it reaches the top of the list.
             */
            while (iter.mNext != Head) {
                Node backIter = iter;
                while (backIter != Head.mPrev) {
                    if (backIter.mData.compareTo(backIter.mNext.mData) > 0) {
                        String temp = backIter.mData;
                        backIter.mData = backIter.mNext.mData;
                        backIter.mNext.mData = temp;
                        backIter = backIter.mPrev;
                    }
                    else {
                        break;
                    }
                }
                iter = iter.mNext;
            }
            Node print = Head;
            /**
             * Prints the sorted doubly linked list.
             */
            while (print.mNext != Head) {
                System.out.print(print.mData + " ");
                print = print.mNext;
                if (print.mNext == Head) {
                    System.out.println(print.mData);
                }
            }
        }
        else if (args.length == 1) {
            System.out.println(args[0]);
        }
        else {
            System.out.println("Sorry your input could not be understood");
        }
    }
}