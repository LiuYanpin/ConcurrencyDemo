public class Main2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode zero = new ListNode(0);
        zero.next=head;
        ListNode tmp=zero;
        while (tmp.next!=null){
            if(tmp.next.val==val){
                tmp.next=tmp.next.next;
            }else {
                tmp=tmp.next;
            }

        }


        return zero.next;

    }

    public static ListNode removeDup(ListNode head) {
        ListNode zero = new ListNode(0);
        zero.next=head;
        ListNode tmp=zero;
        boolean mark=false;
        while (tmp.next!=null && tmp.next.next!=null){
            if(tmp.next.val==tmp.next.next.val){
                tmp.next=tmp.next.next;
                mark=true;
            }else{
                if(mark){
                    tmp.next=tmp.next.next;
                    mark=false;
                }else{
                    tmp=tmp.next;
                }
            }

        }


        return zero.next;

    }

    public static boolean checkCycle(ListNode list){
        ListNode l1=list;
        ListNode l2=list;
        if(l2==null || l2.next==null || l2.next.next==null){
            return false;
        }
        l1=l1.next;
        l2=l2.next.next;
        while (l1!=l2){
            if(l2.next==null || l2.next.next==null){
                return false;
            }
            l1=l1.next;
            l2=l2.next.next;
        }
        return true;
    }



    public static void main(String[] args) {
        ListNode node_1 = new ListNode(6);
        ListNode node_2 = new ListNode(3);
        ListNode node_6 = new ListNode(3);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6_v2 = new ListNode(6);
        node_1.next=node_2;
        node_2.next=node_6;
        node_6.next=node_3;
        node_3.next=node_4;
        node_4.next=node_5;
        node_5.next=node_6_v2;
//        printList(node_1);
//        ListNode listNode = removeElements(node_1, 6);
//        printList(listNode);
//
//        printList(removeDup(listNode));

        System.out.println(checkCycle(node_1));
        node_6_v2.next=node_4;
        System.out.println(checkCycle(node_1));
    }

    public static void printList(ListNode one) {
        ListNode tmp=one;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;
        }
        System.out.println("======================");
    }

}
