package cs2s03;

import java.util.function.Predicate;

class AList {
   public AList(final char a, final int b, final AList ll) {
      this.head = a;
      this.priority = b;
      this.tail = ll;
   }

   public String toString() {
     String result = new String();
     result += '[';
     AList p = this;
     while (p != null) {
        result += '(' + String.valueOf(p.head) + ", " 
           + String.valueOf(p.priority) + ")";
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

   // Helper functions.
   public static int getPriority(final AList list) {
      return list.priority;
   }

   public static char getHead(final AList list) {
      return list.head;
   }

   // front
   static char front(final AList list) throws EmptyContainerException {
      if (list == null)
         throw new EmptyContainerException("Empty AList.");
      return list.head;
   }

   static AList copy(final AList list) {
      if (list == null) return null;
      return new AList(list.head, list.priority, copy(list.tail));
   }

   // front
   static AList remove(final AList list) {
      if (list == null) return null;
      if (list.tail == null) return null;
      return new AList(list.tail.head, list.tail.priority, 
            copy(list.tail.tail));
   }

   static boolean isEmpty(final AList list) {
      if (list == null) return true;
      return false;
   }

   // Returns the index of the first occurrence of a "priority"
   // that satisfies the Predicate defined by tester,
   // or -1 if this list does not contain priorities satisfying tester.
   static int indexOf(final Predicate<AList> tester, final AList list) {
      if (list == null) return -1;
      if (tester.test(list)) return 0;
      if (indexOf(tester, list.tail) == -1)
         return -1;
      return 1 + indexOf(tester, list.tail);
   }

   // Inserting to a null list returns a new list made up of the 
   // insert element.
   static AList insertAt(final int i, final char head, final int priority,
      final AList list) throws EmptyContainerException {
      if (i == 0) return new AList(head, priority, copy(list));
      if (list == null) {
         // Insert at the back if i < 0
         if (i < 0)
            return new AList(head, priority, null);
         throw new EmptyContainerException("Insert index > list length.");
      }
      return new AList(list.head, list.priority, 
            insertAt(i-1, head, priority, list.tail));
   }

   private char head;
   private int priority;
   private AList tail;
}
