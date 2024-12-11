import java.io.*;
import java.util.*;
public class ReverseDLL {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
        public DoublyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode prev = null;
        while (current != null) {
            DoublyLinkedListNode next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void printList(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine().trim());  
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());  
            DoublyLinkedListNode head = null;
            DoublyLinkedListNode current = null;
            for (int j = 0; j < n; j++) {
                int data = Integer.parseInt(bufferedReader.readLine().trim());
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                if (head == null) {
                    head = node;
                    current = node;
                } else {
                    current.next = node;
                    node.prev = current;
                    current = node;
                }
            }
            DoublyLinkedListNode reversedHead = reverse(head);
            printList(reversedHead);
            bufferedWriter.write("\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}