public class Main {
    //链表值相加 先存个位，然后十位，之后类推
    //两个链表变成整数再变成链表存储 返回  day22
    static  class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
    public  static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int sum=0;
        int i=0;
        for(ListNode cur=a;cur!=null;cur=cur.next){
            sum=sum+cur.val*(int)Math.pow(10,i);
            i++;
        }
        int count=0;
        int j=0;
        for(ListNode cur=b;cur!=null;cur=cur.next){
            count=count+cur.val*(int)Math.pow(10,j);
            j++;
        }
        ListNode newList=null;
        int r=sum+count;
        for(i=r;i>0;i/=10){
            int c=i%10;
            ListNode newNode=new ListNode(c);
            //尾插
            newList=getLast(newList,newNode);
        }
        return newList;
    }
    public static ListNode getLast(ListNode newList,ListNode node){
        if(newList==null){
            newList=node;
            return newList;
        }
        ListNode cur=newList;
        //找到最后一个结点
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        return newList;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(2);
        ListNode n6=new ListNode(1);

        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        ListNode node=plusAB(n1,n4);

        for(;node!=null;node=node.next){
            System.out.print(node.val);
        }
    }
}
