package source;

// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;
// import java.util.Iterator;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;
   private int listSize = 0;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         listSize--;
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;

      //update listSize
      listSize++;
   }

   /* Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }
   */


   public String toString()
   {

      String output = ""; //beginning string to be added to 
      Node current = new Node(); //newNode to traverse contents

      current = first; //starting node

      if (first == null) //if the list is empty
      {

         output += "{ }\n";

      }
      else //start of the concat of Strings
      {

         output += "{ ";

         while (current != null) //while we still have elements they are added
         {

            output += current.data.toString() + " ";
            current = current.next; //iterates over the linkedList

         }

         output += "}\n"; //close the output

      }

      return output; 

   } //end toString() method

   public int size()
   {

      return listSize;
      
   } //end of size() method

   public void addElement(Object element)
   {

      //node made to contain information for the first item
      Node newNode = new Node();
      newNode.data = element;

      if (first == null) //if the list is empty
      {

         //first item in the list should be set to this new Node
         first = newNode;
         listSize++;

      }
      else if (first.data.toString().compareToIgnoreCase(element.toString()) >= 0)
      {

         //the next node gets added to the front
         newNode.next = first;
         first = newNode;
         listSize++;

      }
      else
      {

         //create nodes to iterate over the linkedList
         //used Nodes to iterate rather than listIterator
         Node move;
         Node previous;
         move = first.next;
         previous = first;
         listSize++;

         //if we can still move through the list and if this added data is closer to a, we add before
         while (move != null && move.data.toString().compareToIgnoreCase(element.toString()) < 0)
         {

            previous = move;
            move = move.next;

         }

         //if not we want to keep iterating through the list
         newNode.next = move;
         previous.next = newNode;

      }
      

   } //end addElement method

   public void removeElementsAtEvenIndices()
   {

      //count to traverse evenly
      int count = 0;
      
      if (first != null)
      {

      //node to remove and node to keep track of previous (listIterator)
        Node remove = first.next;
        Node previous = first;
        listSize = listSize / 2;

        //remove first
        first = first.next;
        
        while (remove != null)
        {

         //keep counting to track even list
         count++;

         if (count % 2 == 0)
         {

            //remove the element
            previous.next = remove.next;

         }

         //iterate further
         previous = remove;
         remove = remove.next;

        }


      }


   } //end removeElementsAtEvenIndices() method

   public int howManyAppearBefore(Object element)
   {

      //start before index
      int before = 1;
      

      //if the linkedList is empty
      if (first == null)
      {

         before = -1;

      }
      else if (first.data.toString().equalsIgnoreCase(element.toString())) //check first node
      {

         //if the first element is being searched there are 0 before
         before = 0;
         return before;

      }
      else
      {

         //traverse through the list
         Node traversal = first.next;
         boolean found = false;
         

         while (traversal != null)
         {

            //if the element has been found, boolean = true
            if (traversal.data.toString().equals(element.toString()))
            {

               found = true;

            }

            //iterate
            if (traversal.data.toString().compareToIgnoreCase(element.toString()) != 0)
            {

               if (found) //if the string has already been found, dont iterate further
                  break;

               before++;

               

            }

            //traverse one step further
            traversal = traversal.next;

         }

         //if not found
         if (found == false)
            before = -1;

         

         return before;

      }

      return -1; //final case; not found

   } //end howManyAppearBefore(Object element) method

   public int indexOfLast(Object element)
   {

      //current node and node to check ahead 
      Node current = first;
      Node check = first.next;
      int index = 0;

      while (current != null)
      {

         //if the current string matches but it is not the last version
         if (current.data.toString().equals(element.toString()) && check.data.toString().equals(element.toString()))
         {

            index++;
            current = current.next;
            
            //if search is not present or searched is last element
            if (check.next != null)
               check = check.next;
            else if (check.next == null && current.data.toString().equalsIgnoreCase(element.toString()))
               return index;
            else
               return -1;
            

         }
         //if the current search is not found at this index
         else if (!current.data.toString().equals(element.toString()))
         {

            //increment index
            index++;
            current = current.next;

            //if search is not present or searched is last element
            if (check.next != null)
               check = check.next;
            else if (check.next == null && current.data.toString().equalsIgnoreCase(element.toString()))
               return index;
            else
               return -1;

            

         }
         //if index is found and is the last iteration of that element
         else if (current.data.toString().equals(element.toString()) && !check.data.toString().equals(element.toString()))
         {

            return index; //return where it was found

         }

      }

      return -1; //base case; not found

   } //end indexOfLast(Object element) method

   public void duplicateEach()
   {

      //recursive duplicate each element method
      if (first != null)
      {

         //double the listSize int
         listSize *= 2;

         //call created method
         duplicate(first);

      }

   } //end duplicateEach() method

   public void duplicate(Node newNode)
   {

      //if the node we are duplicating is valid
      if (newNode.next != null)
      {

         //call method
         duplicate(newNode.next);

      }

      //create new duplicate node
      Node duplicate = new Node();
      duplicate.data = newNode.data;

      //duplicate the data
      duplicate.next = newNode.next;
      newNode.next = duplicate;

   }

   public Object removeElementAt(int index)
   {

      //create node that returns what we are removing
      Node returnNode = new Node();

      if (first == null) //if the linkedList is empty
      {

         IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
         throw ex;

      }
      //if we are removing the first element
      else if (index == 0)
      {

         //set return node to first
         returnNode = first;
         //we are removing the first from the list
         first = first.next;

         //update listSize
         listSize--;

         //return the original first
         return returnNode.data.toString();
          
      }
      //removing any other index
      else
      {

         //it is not the first element in the string
         //must traverse to the element

         Node remove = first.next;
         Node previous = first;
         int count = 1;

         


         //while we are able to remove an element
         while (count != index && remove != null)
         {

            count++; //count to keep iterating
            previous = remove; 
            remove = remove.next;
            

         }

         if (remove != null){ //remove element
      
            returnNode = previous.next;
            previous.next = remove.next;
            listSize--; //update listSize
            return returnNode.data.toString(); //return the element we removed

         }
         else
         {

            //if the index search was > linkedList size
            IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
            throw ex;

         }

      }

   } //end removeElementAt(int index) method




   /*
   nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }


      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class

   */ 

   
} //end of LinkedList class
