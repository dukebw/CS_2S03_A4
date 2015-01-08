// File: cs2s03/ListChar.java
// Last Modified: Nov. 15/14
// Author: Brendan Duke 0770590
// A wrapper for a list of characters, which implements the MyStack interface.
package cs2s03;

class ListChar implements MyStack {
   public ListChar() {}

   public ListChar(final List list) {
      this.list = list;
   } 

   // Retrieves the value in the head of the list.
   public char top() throws EmptyContainerException {
     if (this.list == null) 
        throw new EmptyContainerException("top() on empty list.");
     return this.list.head;
   }

   // Removes the head of the list if it exists.
   public void pop() {
     if (this.list != null)
        this.list = this.list.tail;
   }

   // Pushes a new head on the list, with value "c".
   public void push(char c) {
     this.list = new List(c, this.list);
   }

   public boolean isEmpty() {
     return (this.list == null) ? true : false;
   }

   // In the toString() method, the leftmost element is at the top of the
   // stack.
   // E.g. converts list "abcde" to ['a', 'b', 'c', 'd', 'e']
   public String toString() {
     String result = new String();
     result += '[';
     List p = this.list;
     while (p != null) {
        result += p.head;
        if (p.tail != null)
           result += ", ";
        p = p.tail;
     }
     result += ']'; 
     return result;
   }

   public boolean equals(final Object object) {
      return this.toString().equals(object.toString());
   }

   private List list;
}
