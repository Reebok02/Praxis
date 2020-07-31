package practicesb.day3and4and5;

public class LList<E> {
    private Node root;

    public void add(E element) {
        if (element == null) {
            return;
        }
        Node node = new Node(element);
        Node last = getLast();
        if (last == null) {
            root = node;
        } else {
            last.next = node;
        }
    }

    public boolean contains(E element) {
        if (element == null || this.size() == 0) {
            return false;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (element.equals(this.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (root == null) {
            return 0;
        } else {
            int count = 1;
            Node currentNode = root;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                count++;
            }
            return count;
        }
    }

    public E get(int index) {
        if (index < 0 || index + 1 > size()) {
            throw new IndexException("Неправильно указан индекс");
        } else {
            Node currentNode = root;
            int i = 0;
            while (index != i) {
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
        private E data;
        private Node next;

        public Node(E elem) {
            this.data = elem;
        }
    }


}

