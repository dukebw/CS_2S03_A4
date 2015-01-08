package cs2s03;

class SnocQueue implements MyQueue {
   // front
   public char peek() throws EmptyContainerException {
      return SnocList.front(this.list);
   }

   // front
   public void dequeue() {
      this.list = SnocList.remove(this.list);
   }

   // back
   public void enqueue(char c) {
      this.list = SnocList.add(c, this.list);
   }

   public boolean isEmpty() {
      return SnocList.isEmpty(this.list);
   }

   public String toString() {
      if (this.list == null) 
         return "[]";
      return this.list.toString();
   }

   public boolean equals(final Object object) {
      return this.toString().equals(object.toString());
   }

   private SnocList list;
}
