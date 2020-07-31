package practicesb.day3and4;

import java.util.LinkedList;
import java.util.List;

public class LList {
    private Node root;

    public void add(Object obj) {
        if (obj == null) {
            return;
        }
        Node node = new Node(obj);
        Node last = getLast();
        if (last == null) {
            root = node;
        } else {
            last.next = node;
        }
    }
    public boolean contains(Object obj){
        if (obj == null || this.size() ==0){
            return false;
        } else {
            for (int i = 0; i < this.size(); i++){
                if (obj.equals(this.get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty(){
        if (this.size() == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        if (root == null){
            return 0;
        } else {
            int count = 1;
            Node currentNode = root;
            while (currentNode.next != null){
                currentNode = currentNode.next;
                count++;
            }
            return count;
        }
    }

    public Object get (int index){
        if (index < 0 || index + 1 > size()) {
            throw new IndexException("Неправильно указан индекс");
        } else {
            Node currentNode = root;
            int i = 0;
            while (index != i){
                currentNode = currentNode.next;
                i++;
            }
            return currentNode.data;
        }

    }

    private Node getLast() {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private class Node {
        Object data;
        Node next;

        public Node(Object item) {
            this.data = item;
        }
    }


}
class MainTaskLList {
    public static void main(String[] args) {
        LList list = new LList();
        list.add("String 1");
        list.add("String 2");
        list.add(123);
        list.add("String 4");
        list.add("String 5");
        list.add("String 6");
        list.add("String 7");
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.contains(null));
        System.out.println(list.contains(123));
        System.out.println(list.contains("String 5"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}

