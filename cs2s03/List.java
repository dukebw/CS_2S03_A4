// File: cs2s03/List.java
// Modified: Nov. 15/14
// Author: Brendan Duke 0770590
// Implements a general linked list class.
package cs2s03;

class List {
   List(final char head, final List tail) {
      this.head = head;
      this.tail = tail;
   }

   char head;
   List tail;
}
