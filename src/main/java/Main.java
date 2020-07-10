public class Main {

    public final  static  class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Node one=new Node(1);
        Node two=new Node(2);
        Node th=new Node(3);
        Node fou=new Node(4);
        one.setNext(two);
        two.setNext(th);
        th.setNext(fou);

        System.out.println(find(2,one).getData());
        printList(one);
        Node fi=new Node(5);
        Node list=insertX(one,fi,2);
        printList(list);
        deleteX(list,3);
        printList(list);
    }

    public static void printList(Node one) {
        Node tmp=one;
        while(tmp!=null){
            System.out.println(tmp.getData());
            tmp=tmp.getNext();
        }
        System.out.println("======================");
    }

    public Node insertFirst(Node linkedlist,Node ele){
        ele.setNext(linkedlist);
        return ele;
    }

    public Node insertSecond(Node linkedlist,Node ele){
        Node first=linkedlist;
        ele.setNext(first.getNext());
        first.setNext(ele);
        return first;
    }

    public static Node insertX(Node linkedlist,Node ele,int index){
        Node zero=new Node(0);
        zero.setNext(linkedlist);
        Node tmp = find(index, zero);
        if(tmp==null){
            throw new RuntimeException("");
        }
        ele.setNext(tmp.getNext());
        tmp.setNext(ele);
        return zero.getNext();
    }

    public static Node deleteX(Node linkedlist,int index){
        Node zero=new Node(0);
        zero.setNext(linkedlist);
        Node tmp = find(index, zero);
        if(tmp==null){
            throw new RuntimeException("");
        }
        if(tmp.getNext()==null){
            return zero.getNext();
        }
        tmp.setNext(tmp.getNext().getNext());
        return zero.getNext();
    }

    private static Node find(int index, Node zero) {
        Node tmp = zero;
        for (int i = 0; i < index; i++) {
            if (tmp == null) {
                break;
            }
            tmp = tmp.getNext();
        }
        return tmp;
    }


}
