//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Submission {
    private Node root = null;

    public Submission() {
    }

    public void insert(int key) {
        this.root = this.insertRecursive(this.root, key);
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
            return new Node(key);
        } else {
            if (key == current.key) {
                ++current.count;
            } else if (key < current.key) {
                current.leftChild = this.insertRecursive(current.leftChild, key);
            } else {
                current.rightChild = this.insertRecursive(current.rightChild, key);
            }

            return current;
        }
    }

    public void search(int key) {
        Node result = this.findNode(key);
        if (result != null) {
            System.out.println(result.key + "(" + result.count + ")");
        } else {
            System.out.println("" + key + "(0)");
        }

    }

    public void findMax() {
        if (this.root == null) {
            System.out.println("0(0)");
        } else {
            Node maxNode = this.findMaxNode(this.root);
            System.out.println(maxNode.key + "(" + maxNode.count + ")");
        }
    }

    private Node findMaxNode(Node node) {
        while(node.rightChild != null) {
            node = node.rightChild;
        }

        return node;
    }

    public void findMin() {
        if (this.root == null) {
            System.out.println("0(0)");
        } else {
            Node minNode = this.findMinNode(this.root);
            System.out.println(minNode.key + "(" + minNode.count + ")");
        }
    }

    private Node findMinNode(Node node) {
        while(node.leftChild != null) {
            node = node.leftChild;
        }

        return node;
    }

    public void printPreorder() {
        this.preorderTraversal(this.root);
        System.out.println();
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + "(" + node.count + ") ");
            this.preorderTraversal(node.leftChild);
            this.preorderTraversal(node.rightChild);
        }

    }

    public void printPostorder() {
        this.postorderTraversal(this.root);
        System.out.println();
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            this.postorderTraversal(node.leftChild);
            this.postorderTraversal(node.rightChild);
            System.out.print(node.key + "(" + node.count + ") ");
        }

    }

    public void printInorder() {
        this.inorderTraversal(this.root);
        System.out.println();
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            this.inorderTraversal(node.leftChild);
            System.out.print(node.key + "(" + node.count + ") ");
            this.inorderTraversal(node.rightChild);
        }

    }

    public void delete(int key) {
        this.root = this.deleteRecursive(this.root, key);
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        } else {
            if (key < current.key) {
                current.leftChild = this.deleteRecursive(current.leftChild, key);
            } else if (key > current.key) {
                current.rightChild = this.deleteRecursive(current.rightChild, key);
            } else if (current.count > 1) {
                --current.count;
            } else {
                if (current.leftChild == null) {
                    return current.rightChild;
                }

                if (current.rightChild == null) {
                    return current.leftChild;
                }

                Node successor;
                if (current.leftChild != null && current.rightChild != null) {
                    successor = this.findMaxNode(current.leftChild);
                    current.key = successor.key;
                    current.count = successor.count;
                    current.leftChild = this.deleteRecursive(current.leftChild, successor.key);
                } else {
                    successor = this.findMinNode(current.rightChild);
                    current.key = successor.key;
                    current.count = successor.count;
                    current.rightChild = this.deleteRecursive(current.rightChild, successor.key);
                }
            }

            return current;
        }
    }

    private Node findNode(int key) {
        Node focusNode = this.root;

        while(focusNode != null && focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
        }

        return focusNode;
    }

    public static void main(String[] args) {
        Submission bst = new Submission();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    int insertElement = scanner.nextInt();
                    bst.insert(insertElement);
                    break;
                case 2:
                    int searchElement = scanner.nextInt();
                    bst.search(searchElement);
                    break;
                case 3:
                    bst.findMax();
                    break;
                case 4:
                    bst.findMin();
                    break;
                case 5:
                    bst.printPreorder();
                    break;
                case 6:
                    bst.printPostorder();
                    break;
                case 7:
                    bst.printInorder();
                    break;
                case 8:
                    int remove = scanner.nextInt();
                    bst.delete(remove);
            }
        }
    }
}
