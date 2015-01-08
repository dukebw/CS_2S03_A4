// cs2s03/TestingA4.java
// November 15/14.
// Brendan Duke 0770590
// 10 test scenarios each for the following classes:
// ListChar, StackChar, SnocList, SnocQueue, AList and AListPQueue.
package cs2s03;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class TestingA4 {
   // Test list for all ListChar tests.
   private ListChar myListChar;
   private StackChar myStackChar;
   private SnocList mySnocList;
   private SnocQueue mySnocQueue;
   private AList myAList;
   private AListPQueue myPQueue;

   @Rule 
   public ExpectedException exception = ExpectedException.none();

   @Before
   public void setUp() {
      myListChar = new ListChar();
      myStackChar = new StackChar();
      mySnocQueue = new SnocQueue();
      myPQueue = new AListPQueue();
   }

   @After
   public void tearDown() {
      myListChar = null;
      myStackChar = null;
      mySnocList = null;
      mySnocQueue = null;
      myAList = null;
      myPQueue = null;
   }

   // ListChar tests.
   @Test
   public void listCharTest1() {
      myListChar = new ListChar(new List('a', new List('p', 
                  new List('p', null))));
      assertEquals("[a, p, p]", myListChar.toString());
   }

   @Test
   public void listCharTest2() {
      char start = 'z';
      for (int i=0; i<26; ++i)
         myListChar.push(start--);
      assertEquals("[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, "
            + "s, t, u, v, w, x, y, z]", myListChar.toString());
   }

   @Test
   public void listCharTest3() {
      assertEquals("[]", myListChar.toString());
   }

   @Test
   public void listCharTest4() {
      if (myListChar.isEmpty())
         myListChar.push('a');
      assertEquals("[a]", myListChar.toString());
   }

   @Test
   public void listCharTest5() {
      myListChar.push('a');
      myListChar.pop();
      myListChar.push('b');
      myListChar.pop();
      myListChar.push('c');
      myListChar.pop();
      myListChar.push('d');
      myListChar.pop();
      myListChar.push('e');
      myListChar.pop();
      myListChar.push('f');
      myListChar.pop();
      myListChar.push('g');
      myListChar.pop();
      myListChar.push('h');
      myListChar.pop();
      myListChar.push('i');
      assertEquals("[i]", myListChar.toString());
   }

   @Test
   public void listCharTest6() throws EmptyContainerException {
      myListChar.push('r');
      myListChar.push('a');
      myListChar.push('b');
      myListChar.push('o');
      myListChar.push('o');
      myListChar.push('f');
      myListChar.push(' ');
      myListChar.push('f');
      myListChar.push('r');
      myListChar.push('o');
      myListChar.push('d');
      myListChar.push('o');
      for (int i=0; i<5; ++i) myListChar.pop();
      if (myListChar.top() == ' ') myListChar.push('$');
      assertEquals("[$,  , f, o, o, b, a, r]", myListChar.toString());
   }

   @Test
   public void listCharTest7() {
      myListChar.pop();
      assertEquals("[]", myListChar.toString());
   }

   @Test
   public void listCharTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      myListChar.top();
   }

   @Test
   public void listCharTest9() throws EmptyContainerException {
      myListChar.push('a');
      myListChar.pop();
      exception.expect(EmptyContainerException.class);
      myListChar.top(); 
   }

   @Test
   public void listCharTest10() throws EmptyContainerException {
      myListChar.pop();
      myListChar.pop();
      exception.expect(EmptyContainerException.class);
      myListChar.top(); 
   }

   // StackChar tests.
   @Test
   public void stackCharTest1() {
      ArrayList<Character> x = new ArrayList<>();
      x.add('p');
      x.add('p');
      x.add('a');
      myStackChar = new StackChar(x);
      assertEquals("[a, p, p]", myStackChar.toString());
   }

   @Test
   public void stackCharTest2() {
      char start = 'z';
      for (int i=0; i<26; ++i)
         myStackChar.push(start--);
      assertEquals("[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, "
            + "s, t, u, v, w, x, y, z]", myStackChar.toString());
   }

   @Test
   public void stackCharTest3() {
      assertEquals("[]", myStackChar.toString());
   }

   @Test
   public void stackCharTest4() {
      if (myStackChar.isEmpty())
         myStackChar.push('a');
      assertEquals("[a]", myStackChar.toString());
   }

   @Test
   public void stackCharTest5() {
      myStackChar.push('a');
      myStackChar.pop();
      myStackChar.push('b');
      myStackChar.pop();
      myStackChar.push('c');
      myStackChar.pop();
      myStackChar.push('d');
      myStackChar.pop();
      myStackChar.push('e');
      myStackChar.pop();
      myStackChar.push('f');
      myStackChar.pop();
      myStackChar.push('g');
      myStackChar.pop();
      myStackChar.push('h');
      myStackChar.pop();
      myStackChar.push('i');
      assertEquals("[i]", myStackChar.toString());
   }

   @Test
   public void stackCharTest6() throws EmptyContainerException {
      myStackChar.push('r');
      myStackChar.push('a');
      myStackChar.push('b');
      myStackChar.push('o');
      myStackChar.push('o');
      myStackChar.push('f');
      myStackChar.push(' ');
      myStackChar.push('f');
      myStackChar.push('r');
      myStackChar.push('o');
      myStackChar.push('d');
      myStackChar.push('o');
      for (int i=0; i<5; ++i) myStackChar.pop();
      if (myStackChar.top() == ' ') myStackChar.push('$');
      assertEquals("[$,  , f, o, o, b, a, r]", myStackChar.toString());
   }

   @Test
   public void stackCharTest7() {
      myStackChar.pop();
      assertEquals("[]", myStackChar.toString());
   }

   @Test
   public void stackCharTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      myStackChar.top();
   }

   @Test
   public void stackCharTest9() throws EmptyContainerException {
      myStackChar.push('a');
      myStackChar.pop();
      exception.expect(EmptyContainerException.class);
      myStackChar.top(); 
   }

   @Test
   public void stackCharTest10() throws EmptyContainerException {
      myStackChar.pop();
      myStackChar.pop();
      exception.expect(EmptyContainerException.class);
      myStackChar.top(); 
   }

   // SnocList tests.
   @Test
   public void snocListTest1() {
      mySnocList = new SnocList('a', new SnocList('p', 
               new SnocList('p', null)));
      assertEquals("[p, p, a]", mySnocList.toString());
   }

   @Test
   public void snocListTest2() {
      mySnocList = new SnocList('A', null);
      assertEquals("[A, a]", SnocList.add('a', mySnocList).toString());
   }

   @Test
   public void snocListTest3() {
      mySnocList = new SnocList('O', new SnocList('D', new SnocList('O', 
                  new SnocList('R', new SnocList('F', 
                  new SnocList('$', null))))));
      assertEquals("[F, R, O, D, O]", SnocList.remove(mySnocList).toString());
   }

   @Test
   public void snocListTest4() throws EmptyContainerException {
      mySnocList = new SnocList('i', null);
      mySnocList = SnocList.add('I', mySnocList);
      mySnocList = SnocList.add(SnocList.front(mySnocList), mySnocList);
      assertEquals("[i, I, i]", mySnocList.toString());
   }

   @Test
   public void snocListTest5() {
      String s = "Frodo Baggins";
      for (int i=0; i<s.length(); ++i)
         mySnocList = SnocList.add(s.charAt(i), mySnocList);
      assertEquals("[F, r, o, d, o,  , B, a, g, g, i, n, s]", 
            mySnocList.toString());
   }

   @Test
   public void snocListTest6() {
      if (SnocList.isEmpty(mySnocList))
         for (char c='a'; c<='z'; ++c)
            mySnocList = SnocList.add(c, mySnocList);
      assertEquals("[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, "
            + "t, u, v, w, x, y, z]", mySnocList.toString());
   }

   @Test
   public void snocListTest7() {
      mySnocList = new SnocList('$', null);
      for (int i=0; i<17; ++i)
         mySnocList = SnocList.add('$', mySnocList);
      for (int i=0; i<17; ++i)
         mySnocList = SnocList.remove(mySnocList);
      assertEquals("[$]", mySnocList.toString());
   }

   @Test
   public void snocListTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      SnocList.front(mySnocList);
   }

   @Test
   public void snocListTest9() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      SnocList.front(SnocList.remove(new SnocList('\t', null)));
   }

   @Test
   public void snocListTest10() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      SnocList.front(SnocList.remove(SnocList.add('@', mySnocList)));
   }

   @Test
   public void snocQueueTest1() {
      assertEquals("[]", mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest2() {
      mySnocQueue.dequeue();
      assertEquals("[]", mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest3() {
      mySnocQueue.enqueue('A');
      assertEquals("[A]", mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest4() {
      mySnocQueue.enqueue('A');
      if (mySnocQueue.isEmpty())
         mySnocQueue.enqueue('B');
      assertEquals("[A]", mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest5() throws EmptyContainerException {
      mySnocQueue.enqueue('$');
      if (mySnocQueue.peek() == '$')
         mySnocQueue.enqueue('$');
      mySnocQueue.enqueue('\t');
      mySnocQueue.enqueue('F');
      mySnocQueue.enqueue('R');
      mySnocQueue.enqueue('O');
      mySnocQueue.enqueue('D');
      mySnocQueue.enqueue('O');
      mySnocQueue.enqueue(' ');
      mySnocQueue.enqueue('B');
      mySnocQueue.enqueue('A');
      mySnocQueue.enqueue('G');
      mySnocQueue.enqueue('G');
      mySnocQueue.enqueue('I');
      mySnocQueue.enqueue('N');
      mySnocQueue.enqueue('S');
      mySnocQueue.dequeue();
      mySnocQueue.dequeue();
      mySnocQueue.dequeue();
      assertEquals("[F, R, O, D, O,  , B, A, G, G, I, N, S]", 
            mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest6() {
      mySnocQueue.enqueue('G');
      mySnocQueue.enqueue('A');
      mySnocQueue.enqueue('S');
      for (int i=0; i<15; ++i)
         mySnocQueue.enqueue('G');
      assertEquals("[G, A, S, G, G, G, G, G, G, G, G, G, G, G, G, G, G, G]",
            mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest7() throws EmptyContainerException {
      if (mySnocQueue.isEmpty()) {
         mySnocQueue.enqueue('M');
         mySnocQueue.enqueue('A');
         mySnocQueue.enqueue('N');
      }
      String s = mySnocQueue.toString();
      for (int i=0; i<s.length(); ++i)
         mySnocQueue.enqueue(s.charAt(i));
      mySnocQueue.enqueue(mySnocQueue.peek());
      mySnocQueue.enqueue(mySnocQueue.peek());
      mySnocQueue.enqueue(mySnocQueue.peek());
      assertEquals("[M, A, N, [, M, ,,  , A, ,,  , N, ], M, M, M]", 
            mySnocQueue.toString());
   }

   @Test
   public void snocQueueTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      mySnocQueue.peek();
   }

   @Test
   public void snocQueueTest9() throws EmptyContainerException {
      mySnocQueue.enqueue('a');
      mySnocQueue.dequeue();
      exception.expect(EmptyContainerException.class);
      mySnocQueue.peek();
   }

   @Test
   public void snocQueueTest10() throws EmptyContainerException {
      if (!mySnocQueue.isEmpty())
         mySnocQueue.enqueue('a');
      exception.expect(EmptyContainerException.class);
      mySnocQueue.peek();
   }

   @Test
   public void aListTest1() {
      myAList = new AList('b', 3, new AList('a', 2, null));
      assertEquals("[(b, 3), (a, 2)]", myAList.toString());
   }

   @Test
   public void aListTest2() throws EmptyContainerException {
      assertEquals("[(a, 0)]", AList.insertAt(0, 'a', 0, myAList).toString());
   }

   @Test
   public void aListTest3() throws EmptyContainerException {
      myAList = AList.insertAt(0, 'G', 2, myAList);
      myAList = AList.insertAt(1, 'A', 3, myAList);
      myAList = AList.insertAt(2, 'N', 5, myAList);
      myAList = AList.insertAt(3, 'D', 7, myAList);
      myAList = AList.insertAt(4, 'A', 11, myAList);
      myAList = AList.insertAt(5, 'L', 13, myAList);
      myAList = AList.insertAt(6, 'F', 17, myAList);
      assertEquals("[(G, 2), (A, 3), (N, 5), (D, 7), (A, 11), (L, 13), "
            + "(F, 17)]", myAList.toString());
   }

   @Test
   public void aListTest4() throws EmptyContainerException {
      myAList = AList.insertAt(0, 'W', -1, myAList);
      myAList = AList.insertAt(1, 'I', -2, myAList);
      myAList = AList.insertAt(2, 'Z', -3, myAList);
      myAList = AList.insertAt(3, 'A', -4, myAList);
      myAList = AList.insertAt(4, 'R', -5, myAList);
      myAList = AList.insertAt(5, 'D', -6, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == -1,
               myAList), 'W', 0, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == 0,
               myAList), 'I', 1, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == 1,
               myAList), 'Z', 2, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == 2,
               myAList), 'A', 3, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == 3,
               myAList), 'R', 4, myAList);
      myAList = AList.insertAt(AList.indexOf(l -> AList.getPriority(l) == 4,
               myAList), 'D', 5, myAList);
      assertEquals("[(D, 5), (R, 4), (A, 3), (Z, 2), (I, 1), (W, 0), (W, -1), "
            + "(I, -2), (Z, -3), (A, -4), (R, -5), (D, -6)]", 
            myAList.toString());
   }

   @Test
   public void aListTest5() throws EmptyContainerException {
      myAList = AList.insertAt(0, 'S', 0, myAList);
      myAList = AList.insertAt(0, 'A', 0, myAList);
      myAList = AList.insertAt(0, 'M', 0, myAList);
      myAList = AList.insertAt(0, 'T', 0, myAList);
      myAList = AList.insertAt(0, 'S', 0, myAList);
      myAList = AList.insertAt(0, 'I', 0, myAList);
      myAList = AList.insertAt(0, 'R', 0, myAList);
      myAList = AList.insertAt(0, 'H', 0, myAList);
      myAList = AList.insertAt(0, 'C', 0, myAList);
      myAList = AList.insertAt(0, ' ', 0, myAList);
      myAList = AList.insertAt(0, 'Y', 0, myAList);
      myAList = AList.insertAt(0, 'R', 0, myAList);
      myAList = AList.insertAt(0, 'R', 0, myAList);
      myAList = AList.insertAt(0, 'E', 0, myAList);
      myAList = AList.insertAt(0, 'M', 0, myAList);
      assertEquals("[(M, 0), (E, 0), (R, 0), (R, 0), (Y, 0), ( , 0), (C, 0), "
            + "(H, 0), (R, 0), (I, 0), (S, 0), (T, 0), (M, 0), (A, 0), "
            +"(S, 0)]", myAList.toString());
   }

   @Test
   public void aListTest6() throws EmptyContainerException {
      myAList = AList.insertAt(0, 'R', 299792458, myAList);
      myAList = AList.insertAt(0, 'A', 19, myAList);
      myAList = AList.insertAt(0, 'E', 18, myAList);
      myAList = AList.insertAt(0, 'Y', 17, myAList);
      myAList = AList.insertAt(0, ' ', 16, myAList);
      myAList = AList.insertAt(0, 'W', 15, myAList);
      myAList = AList.insertAt(0, 'E', 14, myAList);
      myAList = AList.insertAt(0, 'N', 13, myAList);
      myAList = AList.insertAt(0, ' ', 12, myAList);
      myAList = AList.insertAt(0, 'Y', 11, myAList);
      myAList = AList.insertAt(0, 'P', 10, myAList);
      myAList = AList.insertAt(0, 'P', 9, myAList);
      myAList = AList.insertAt(0, 'A', 8, myAList);
      myAList = AList.insertAt(0, 'H', 7, myAList);
      myAList = AList.insertAt(0, ' ', 6, myAList);
      myAList = AList.insertAt(0, 'Y', 5, myAList);
      myAList = AList.insertAt(0, 'P', 4, myAList);
      myAList = AList.insertAt(0, 'P', 3, myAList);
      myAList = AList.insertAt(0, 'A', 2, myAList);
      myAList = AList.insertAt(0, 'H', 1, myAList);
      assertEquals("[(H, 1), (A, 2), (P, 3), (P, 4), (Y, 5), ( , 6), (H, 7), "
            + "(A, 8), (P, 9), (P, 10), (Y, 11), ( , 12), (N, 13), (E, 14), "
            + "(W, 15), ( , 16), (Y, 17), (E, 18), (A, 19), (R, 299792458)]", 
            myAList.toString());
   }

   @Test
   public void aListTest7() throws EmptyContainerException {
      myAList = AList.insertAt(0, '$', 9999, null);
      assertEquals("[($, 9999)]", myAList.toString());
   }

   @Test
   public void aListTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      myAList = AList.insertAt(1, '$', 314159265, null);
   }

   @Test
   public void aListTest9() throws EmptyContainerException {
      myAList = AList.insertAt(0, '$', 9999, null);
      exception.expect(EmptyContainerException.class);
      myAList = AList.insertAt(2, 'C', 1, myAList);
   }

   @Test
   public void aListTest10() throws EmptyContainerException {
      myAList = AList.insertAt(-1, '!', 0, null);
      exception.expect(EmptyContainerException.class);
      myAList = AList.insertAt(9, '#', 11, myAList);
   }

   @Test
   public void aListPQueueTest1() {
      assertEquals("[]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest2() {
      myPQueue.insertItem(1, 'A');
      assertEquals("[(A, 1)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest3() {
      myPQueue.insertItem(1, 'A');
      myPQueue.insertItem(2, 'B');
      assertEquals("[(B, 2), (A, 1)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest4() {
      myPQueue.insertItem(1, 'z');
      myPQueue.insertItem(1, 'A');
      myPQueue.insertItem(1, 'Z');
      assertEquals("[(A, 1), (Z, 1), (z, 1)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest5() {
      myPQueue.insertItem(9, 'A');
      myPQueue.insertItem(9, 'C');
      myPQueue.insertItem(8, 'G');
      myPQueue.insertItem(8, 'a');
      myPQueue.insertItem(6, 'a');
      myPQueue.insertItem(7, 'd');
      myPQueue.insertItem(8, 'n');
      myPQueue.insertItem(5, 'f');
      myPQueue.insertItem(6, 'l');
      myPQueue.insertItem(4, ' ');
      myPQueue.insertItem(3, 'h');
      myPQueue.insertItem(4, 't');
      myPQueue.insertItem(2, 'e');
      myPQueue.insertItem(1, ' ');
      myPQueue.insertItem(0, 'r');
      myPQueue.insertItem(0, 'G');
      myPQueue.insertItem(-1, 'e');
      myPQueue.insertItem(-1, 'y');
      myPQueue.deleteItem();
      myPQueue.deleteItem();
      assertEquals("[(G, 8), (a, 8), (n, 8), (d, 7), (a, 6), (l, 6), (f, 5), "
            + "( , 4), (t, 4), (h, 3), (e, 2), ( , 1), (G, 0), (r, 0), "
            + "(e, -1), (y, -1)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest6() {
      myPQueue.insertItem(1, 'Z');
      myPQueue.insertItem(1, 'Y');
      myPQueue.insertItem(1, 'X');
      myPQueue.insertItem(2, 'w');
      myPQueue.insertItem(3, 'V');
      myPQueue.insertItem(3, 'U');
      myPQueue.insertItem(4, 'T');
      myPQueue.insertItem(4, 'S');
      myPQueue.insertItem(5, 'R');
      myPQueue.insertItem(5, 'Q');
      myPQueue.insertItem(6, 'P');
      myPQueue.insertItem(6, 'O');
      myPQueue.insertItem(6, 'N');
      myPQueue.insertItem(6, 'M');
      myPQueue.insertItem(7, 'L');
      myPQueue.insertItem(7, 'K');
      myPQueue.insertItem(7, 'J');
      myPQueue.insertItem(7, 'I');
      myPQueue.insertItem(8, 'H');
      myPQueue.insertItem(8, 'G');
      myPQueue.insertItem(8, 'F');
      myPQueue.insertItem(8, 'E');
      myPQueue.insertItem(9, 'D');
      myPQueue.insertItem(9, 'C');
      myPQueue.insertItem(9, 'B');
      myPQueue.insertItem(9, 'A');
      assertEquals("[(A, 9), (B, 9), (C, 9), (D, 9), (E, 8), (F, 8), (G, 8), "
            + "(H, 8), (I, 7), (J, 7), (K, 7), (L, 7), (M, 6), (N, 6), "
            + "(O, 6), (P, 6), (Q, 5), (R, 5), (S, 4), (T, 4), (U, 3), (V, 3), "
            + "(w, 2), (X, 1), (Y, 1), (Z, 1)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest7() throws EmptyContainerException {
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      if (myPQueue.isEmpty())
         myPQueue.insertItem(999, '$');
      myPQueue.insertItem(888, myPQueue.next());
      assertEquals("[($, 999), ($, 888)]", myPQueue.toString());
   }

   @Test
   public void aListPQueueTest8() throws EmptyContainerException {
      exception.expect(EmptyContainerException.class);
      myPQueue.next();
   }

   @Test
   public void aListPQueueTest9() throws EmptyContainerException {
      myPQueue.deleteItem();
      exception.expect(EmptyContainerException.class);
      myPQueue.next();
   }

   @Test
   public void aListPQueueTest10() throws EmptyContainerException {
      myPQueue.insertItem(1, 'A');
      myPQueue.deleteItem();
      exception.expect(EmptyContainerException.class);
      myPQueue.next();
   }
}
