import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val;this.next=next;}
    }
    int size;
    ListNode dummyhead;
    public  MyLinkedList(){
        size=0;
        dummyhead=new ListNode(0);
    }
    public int get(int index){
        ListNode cur = dummyhead;
        if(index < 0 || index > size){
            return -1;
        }
        while (index != 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = dummyhead.next;
        dummyhead.next = newNode;
        size++;
    }
    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyhead;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }
    public void addIndex(int val, int index){
        ListNode cur = dummyhead;
        ListNode newNode = new ListNode(val);
        if(index < 0 || index > size){return;}
        while(index != 0){
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    public void deleteIndex(int index){
        ListNode cur = dummyhead;
        if(index < 0 || index > size){
            return;
        }
        while(index != 0){
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur.next != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }
    public ListNode swapElement(ListNode head){
        ListNode cur = dummyhead;
        while(cur.next != null & cur.next.next != null){
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = temp;
            cur = temp;
        }
        return cur;

    }

    public  void print(MyLinkedList myLinkedList){
        for(int i = 1; i <= myLinkedList.size; i++){
            System.out.println(myLinkedList.get(i));
        }
    }

    public static ListNode createListNode(int[] input){
        if (input.length == 0) return null;
        ListNode head = new ListNode();
        head.val = input[0];
        ListNode pre = head;
        for (int i = 1; i < input.length; i++){
            ListNode newNode = new ListNode();
            newNode.val = input[i];
            pre.next = newNode;
            pre = newNode;
        }
        return  head;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode a = headA;
        ListNode b = headB;
        int lenOfa = 0;
        while(a!=null){
            lenOfa++;
            a = a.next;
        }
        int lenOfb = 0;
        while(b!=null){
            lenOfb++;
            b = b.next;
        }
        if(lenOfb > lenOfa){
            int temp = lenOfa;
            lenOfa = lenOfb;
            lenOfb = temp;
            a = headB;
            b = headA;
        }
        int diffLen = lenOfa - lenOfb;
        while(diffLen-- > 0 && a !=null){
            a = a.next;
            diffLen--;
        }
        while(a != b){
            if(a == null || b == null){
                return null;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }
//    public  boolean hashCompare(String a, String b){
//        for(int i=0; i<=a.length(); i++){
//
//        }
//    }
    public static void main(String[] args){
//        MyLinkedList obj=new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(2);
//        obj.addAtTail(9);
//        obj.addIndex(7, 2);
//        obj.print(obj);
        System.out.println('b'-'a');

    }
}
