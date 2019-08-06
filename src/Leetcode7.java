import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Leetcode7 {

    public static void main(String[] args) {
    }


    public ListNode partition(ListNode head, int x) {

        ListNode biggerHead = null;
        ListNode bp = biggerHead;
        ListNode smallerNode = null;
        ListNode sp = smallerNode;

        while (head != null) {
            if (head.val >= x) {
                if (bp == null) {
                    bp = head;
                    biggerHead = head;
                } else {
                    bp.next = head;
                    bp = bp.next;


                }

            } else {
                if (sp == null) {
                    sp = head;
                    smallerNode = head;

                } else {
                    sp.next = head;
                    sp = sp.next;

                }
            }
            head = head.next;
        }

        if (bp != null) {
            bp.next = null;
        }
        if (sp != null) {
            sp.next = biggerHead;

            return smallerNode;
        } else {
            return biggerHead;
        }


    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
