/*
https://www.dailycodingproblem.com/blog/lockable-binary-trees/

This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.
*/
class Node {
    int val;
    Node left;
    Node right;
    Node parent;
    boolean isLocked;
    int lockedDescCount;
    
    public Node (int val, Node left, Node right, Node parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.isLocked = false;
        this.lockDescCount = 0;
    }
}
public class Main {
    
    public static int isLocked(Node n) {
        return n.isLocked;
    }
    
    public static boolean lock(Node n) {
        if(canLockUnlock(n)) {
            // lock the node and update all of it's ancestor
            n.isLocked = true;
            
            Node curr = n.parent;
            while (curr != null) {
                curr.lockedDescCount += 1;
                curr = curr.next;
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean unLock (Node n) {
        if (canLockUnlock(n)) {
            n.isLocked = false;
            
            // Update all the ancestor 
            Node curr = n.parent;
            while (curr != null) {
                curr.lockedDescCount -= 1;
                curr = curr.next;
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    public static canLockUnlock(Node n) {
        if (n.lockedDescCount > 0) {
            return false;
        }
        Node curr = curr.parent;
        while (curr != null) {
            if (curr.isLocked) return false;
            curr = curr.parent;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}