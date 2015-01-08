package cs2s03;

class SnocList {
   public SnocList (char c, SnocList l) {
      this.c = c;
      this.l = l;
   }

   // Helper functions (package cs2s03 only).
   static SnocList add(final char c, final SnocList l) {
      if (l == null) return new SnocList(c, null);
      return new SnocList(c, add(l.c, l.l));
   }

   // Removes front of the SnocList as if it were a queue.
   static SnocList remove(final SnocList l) {
      if (l == null) return null;
      if (l.l == null) return null;
      return new SnocList(l.c, remove(l.l));
   }

   // Returns front of the SnocList as if it were a queue.
   static char front(final SnocList l) throws EmptyContainerException {
      if (l == null) throw new EmptyContainerException("Empty list."); 
      if (l.l == null) return l.c;
      return front(l.l);
   }

   static boolean isEmpty(final SnocList l) {
      if (l == null) return true;
      return false;
   }

   // Front of the list is to the left, e.g. in "[A, a]" A is the front of
   // the list (next in the queue).
   public String toString() {
     String reverse = new String();
     SnocList p = this;
     while (p != null) {
        reverse += p.c;
        p = p.l;
     }
     
     String result = new String();
     result += '[';
     if (reverse.length() > 0) {
        for (int i=reverse.length() - 1; i > 0; --i)
           result += reverse.charAt(i) + ", ";
        result += reverse.charAt(0);
     }
     result += ']'; 
     return result;
   }

   public boolean equals(final Object object) {
      return this.l.toString().equals(object.toString());
   }

   private char c;
   private SnocList l;
}
