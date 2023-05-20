import java.util.List;

import javax.xml.transform.SourceLocator;

/**
 * LInkedList_imp
 */
public class LInkedList_imp {
    static class ListNode{
        // data
        private int data;

        // direction | address
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

        public int getData(){
            return this.data;
        }

        public ListNode getNext(){
            return next;
        }

        public void setData(int data){
            this.data = data;
        }

        public void setNext(ListNode next){
            this.next = next;
        }
    } 
    
    // traversal
    public static void traversal(ListNode head){
        if(head == null){
            return;
        }

        while(head != null){
            System.out.print(head.data + " ->");
            head = head.getNext();
        }
    }


    // length of LinkedList
    public static int lengthOfLL(ListNode head){
        if(head == null){
            return 0;
        }
        int counter = 0;

        while(head != null){
            counter++;
            head = head.getNext();
        }

        return counter;
    }


    // add first in LL
    public static ListNode addFirst(ListNode head,int data,int k){
        // validate k
        if(k<0 || k>lengthOfLL(head)){
            System.out.println("k is not correct");
            return head;
        }

        if(k == 0){
            // we want to insert it first
            ListNode node = new ListNode(data);
            node.setNext(head);
            head = node;
        }else{
            ListNode node = new ListNode(data);

            // find k-1th node
            ListNode temp = head;
            int count = 0;
            while(count< k){
                temp = temp.getNext();
                count++;
            }

            // temp will be the node
            node.setNext(temp.getNext());
            temp.setNext(node);
        }

        return head;
    }

    // add mid
    // public static ListNode addMid(ListNode head,int data, int k){

    // }


    // loop exits or not
    public boolean hasLoop(ListNode head){
        if(head == null){
            return false;
        }

        ListNode s = head;
        ListNode f = head;

        while(f != null && f.getNext() != null){
            s = s.getNext();
            f = f.getNext().getNext();

            if(s == f){
                return true;
            }
        }
        return false; // no loop
    }


    // find starting Node of Loop
    public static ListNode loopStart(ListNode head){
        if(head == null){
            return null;
        }

        boolean hasLoop = false;

        ListNode s = head;
        ListNode f = head;

        while(f!= null && f.getNext() != null){
            s = s.getNext();
            f = f.getNext().getNext();

            if(s == f){
                hasLoop = true;
                break;
            }
        }

        if(hasLoop == false){
            System.out.println("There is not loop");
            return null;
        }

        ListNode left = head;
        ListNode right = s;

        while(left != right){
            left = left.getNext();
            right= right.getNext().getNext();
        }


    }


    public static void main(String[] args) {
        // ListNode ll = new ListNode();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.setNext(node2);
        node2.setNext(node3);

        traversal(head);
        int len = lengthOfLL(head);
        System.out.println();
        System.out.println(len);
    }
}