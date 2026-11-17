import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree {

    Node root;

    // 1. SORU: AĞACA ELEMAN EKLEME

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        }
        else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    // 1. SORU: AĞAÇTA ELEMAN ARAMA

    boolean search(int data) {

        Node current = root;

        while (current != null) {

            if (data == current.data) {
                return true;
            }

            if (data < current.data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        return false;
    }

    // 1. SORU: AĞAÇTA ELEMAN SİLME

    void delete(int data) {
        root = deleteRecursive(root, data);
    }

    Node deleteRecursive(Node current, int data) {

        if (current == null) {
            return null;
        }

        if (data < current.data) {
            current.left = deleteRecursive(current.left, data);
        }

        else if (data > current.data) {
            current.right = deleteRecursive(current.right, data);
        }

        else {

            // Çocuğu olmayan düğüm
            if (current.left == null && current.right == null) {
                return null;
            }

            // Sadece sağ çocuğu varsa
            if (current.left == null) {
                return current.right;
            }

            // Sadece sol çocuğu varsa
            if (current.right == null) {
                return current.left;
            }

            // İki çocuğu varsa
            int minValue = findMin(current.right);

            current.data = minValue;

            current.right = deleteRecursive(current.right, minValue);
        }

        return current;
    }

    // Minimum değeri bulma
    int findMin(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // Maksimum değeri bulma
    int findMax(Node current) {

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

}