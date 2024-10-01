import java.util.Scanner;

class ListNode {
    int value;
    ListNode next;

    ListNode (int value) {
        this.value = value;
        this.next = null;
    }
}

class CustomLinkedList {
    ListNode head;

    public void insertAtHead(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

    }

    public void printList() {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;

        }

    }

}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomLinkedList ll = new CustomLinkedList();
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int data = sc.nextInt();
            ll.insertAtHead(data);
        }

        ll.printList();
        sc.close();

    }

}

