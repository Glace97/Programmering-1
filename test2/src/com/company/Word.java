package com.company;

public class Word {

    // Node representerar en nod
    //Bara omslutande klassen kan skapa obj av Node
    private class Node {
        public char c;
        public Node next;

        public Node (char c) {
            this.c = c;
            this.next = null;
        }
    }

    // första noden i nodsekvensen
    private Node first = null;

    // append lägger till ett givet tecken i slutet av ordet
    public void append(char c) {
        if(first == null) {
            first = new Node(c);
        }
        else{
            Node next = new Node(c);
        }
    }

    // toArray returnerar ordets tecken i en vektor
    public char[] toArray () {
        int charCount = 0;
        Node node = first;

        while (node != null) {
            charCount++;
            node = node.next;
        }

        char[] a = new char[charCount];
        node = first;
        int pos = 0;
        while (node != null) {
            a[pos++] = node.c;
            node = node.next;
        }

        return a;
    }

}
