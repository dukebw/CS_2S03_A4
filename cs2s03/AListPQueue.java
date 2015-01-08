package cs2s03;

// Elements should be stored in priority order, with higher numbers
// indicating higher priority. Equal priorities should be sorted 
// alphabetically, such that 'a' is higher priority than 'b'.
// (Use Java's compareTo method on strings).
class AListPQueue implements MyPriorityQueue {
   // highest priority
   public char next() throws EmptyContainerException {
      if (this.list == null)
         throw new EmptyContainerException("Empty AListPQueue.");
      return AList.front(this.list);
   }

   // highest priority
   public void deleteItem() {
      this.list = AList.remove(this.list);
   }

   // int priority, then alphabetical
   public void insertItem(int p, char c) {
      // Lambda conditions are passed to sort by lexicographic order
      // only if the new item's priority already exists in the queue.
      int index = AList.indexOf(l -> AList.getPriority(l) == p 
            && AList.getHead(l) >= c, this.list);
      if (index == -1)
         index = AList.indexOf(l -> AList.getPriority(l) < p, this.list);

      // This try-catch is to maintain insertItem's signature (for the 
      // A5 checker). It would make more sense to just declare that
      // insertItem throws EmptyContainerException. Either way, no exception
      // should ever be thrown due to an insertItem call.
      try {
         this.list = AList.insertAt(index, c, p, this.list);
      } catch(EmptyContainerException e) {
         System.out.println("Unexpected insertItem error.");
      }
   }

   public boolean isEmpty() {
      return AList.isEmpty(this.list);
   }

   public String toString() {
      if (this.list == null) return "[]";
      return this.list.toString();
   }

   public boolean equals(final Object object) {
      return this.toString().equals(object.toString());
   }

   private AList list;
}
