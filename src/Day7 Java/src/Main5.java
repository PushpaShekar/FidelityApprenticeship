import java.util.Scanner;

class ListElement {
    int data;
    ListElement next;

    ListElement(int data) {
        this.data = data;
        this.next = null;
    }
}

class CustomList {
    ListElement head;

    public void insertAtEnd(int data) {
        ListElement newNode = new ListElement(data);
        if(head == null) {
            head = newNode;
        } else {
            ListElement temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void reverseList() {
        ListElement prev = null;
        ListElement current = head;
        ListElement next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public void printList() {
        ListElement temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList list = new CustomList();

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int data = sc.nextInt();
            list.insertAtEnd(data);
        }
        list.reverseList();
        list.printList();
        sc.close();
    }
}
