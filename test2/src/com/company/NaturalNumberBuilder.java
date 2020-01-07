package com.company;

public class NaturalNumberBuilder {

    // Node representerar en nod
    private static class Node {
        public int digit;
        public Node next;

        public Node (int digit) {
            this.digit = digit;
            this.next = null;
        }
    }

    // referens till den första noden
    private Node first = null;
    public NaturalNumberBuilder (int... digits)
            throws java.lang.IllegalArgumentException {

        for (int pos = 0; pos < digits.length; pos++) {
            if (!(digits[pos] >= 0 && digits[pos] <= 9))
                throw new java.lang.IllegalArgumentException(
                        "not a digit: " + digits[pos]);
        }

        if (digits.length > 0) {
            first = new Node (digits[0]);
            Node n = first;

            for (int pos = 1; pos < digits.length; pos++) {
                n.next = new Node (digits[pos]);
                n = n.next;
            }
        }
    }

    public String toString () {
        StringBuilder sb = new StringBuilder ("<");
        Node n = first;
        while (n != null) {
            sb.append (n.digit);
            if (n.next != null)
                sb.append (", ");
            n = n.next;
        }

        sb.append (">");
        return sb.toString ();
    }

    // getNumber returnerar det naturliga heltalet som finns i det här byggaren.
    // Om byggaren är tom, kastas ett undantag av typen java.lang.IllegalStateException.
    public int getNumber() {
        if(first == null){
            throw new java.lang.IllegalStateException("no number");
        }
        Node n = first;
        StringBuilder numberString = new StringBuilder();
         while(n != null){
             numberString.append(String.valueOf(n.digit));
             n = n.next;
         }

         int number = Integer.parseInt(numberString.toString());
         return number;
    }
    // append lägger till en given siffra på slutet av talet i byggaren.
    // Om ett heltal som inte är en siffra anges som argument, kastar metoden ett undantag
    // av typen java.lang.IllegalArgumentException.
    public void append(int number) {
        if(!(number >= 0 && number <= 9)) {
            throw new java.lang.IllegalArgumentException("not a digit " + number);
        }

        if(first == null) {
            first = new Node(number);
        }

        Node n = first;             //skapa referens
        while( n != null) {         //så länge vår nästa referns inte pekar ut mot intet
            n = n.next;             //går igenom hela linked listen
        }
        //n.next är pekaren som pekar ut mot inget
        n.next = new Node (number);  //skapar ny nod som sist referensen pekar mot
    }
}