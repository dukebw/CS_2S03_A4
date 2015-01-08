package cs2s03;

import java.util.ArrayList;

class StackChar implements MyStack {
   // Constructors don't allow this.list to be null.
   public StackChar() {
     this.list = new ArrayList<Character>();
   }

   public StackChar(final ArrayList<Character> list) {
      if (list == null)
         this.list = new ArrayList<Character>();
      else this.list = list;
   }

   // The top of the stack is the last element (size()-1) of the ArrayList.
   public char top() throws EmptyContainerException {
      if (this.list.isEmpty())
         throw new EmptyContainerException("Empty StackChar.");
      return this.list.get(this.list.size() - 1);
   }

   // Removes the top of the stack if the stack is not empty.
   public void pop() {
      if (!this.list.isEmpty())
         this.list.remove(this.list.size() - 1);
   }

   // Pushes a new top on the stack.
   public void push(char c) {
      this.list.add(c);
   }

   public boolean isEmpty() {
      return this.list.isEmpty();
   }

   // In the toString() method, the leftmost element is at the top of the
   // stack.
   public String toString() {
      String result = new String();
      result += '[';
      // Commas and spaces between middle elements.
      if (this.list.size() > 0) {
         for (int i=this.list.size() - 1; i>0; --i)
            result += this.list.get(i) + ", ";
         result += this.list.get(0);
      }
      result += ']';
      return result;
   }

   public boolean equals(final Object object) {
      return this.toString().equals(object.toString());
   }

   private ArrayList<Character> list;
}
