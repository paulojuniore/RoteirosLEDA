package adt.linkedList;

import adt.linkedList.extended.ListInversionImpl;

public class Main {

   public static void main(String[] args) {
      ListInversionImpl list = new ListInversionImpl();
      list.insert(10);
      list.insert(20);
      list.insert(30);
      list.insert(40);
      list.reverseIterative();
   }

}
