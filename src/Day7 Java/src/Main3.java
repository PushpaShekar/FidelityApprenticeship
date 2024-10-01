import java.util.Scanner;

class NodeItem {
    int data;
    NodeItem next;

    NodeItem(int data){
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    NodeItem head;

    public void insertAtPosition(int data, int position) {
        NodeItem newNode = new NodeItem(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        NodeItem current = head;
        for(int i=0; i<position-1; i++){
            if (current == null) {
                return;
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    public void printList() {
        NodeItem temp = head;
        while (temp != null) {
            System.out.print(temp.data + "");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        int firstValue = sc.nextInt();
        int secondValue = sc.nextInt();
        int thirdValue = sc.nextInt();

        list.insertAtPosition(firstValue, 0);
        list.insertAtPosition(secondValue, 1);
        list.insertAtPosition(thirdValue, 2);

        int newValue = sc.nextInt();
        int position = sc.nextInt();

        list.insertAtPosition(newValue, position);

        list.printList();
        sc.close();
    }
}
