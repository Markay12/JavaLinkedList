_Information for Program Including Notes and Explanation of LinkedLists_

# **Table of Contents**

* [About me](https://github.com/Markay12/JavaLinkedList#about-me)
* [Program Information](https://github.com/Markay12/JavaLinkedList#program-information)
* [Data Structures](https://github.com/Markay12/JavaLinkedList#data-structures)
* [Linked Lists](https://github.com/Markay12/JavaLinkedList#linked-lists)
* [Linked List UML Diagram](https://github.com/Markay12/JavaLinkedList#linked-list-uml-diagram)
* [Linked List Effeciency](https://github.com/Markay12/JavaLinkedList#linked-list-effeciency_)



## **_About Me_**
At the time of writing this program I am a Freshman at Arizona State University studing Computer Systems Engineering in my second semester. Due to the recent events of COVID-19 and complications with living at home and working on all classes from home I have extra time to work on these programs and develop a more understandable version of programs that I have developed.\
Hopefully all explanations here work... if not feel free to contact me at:\
`ashinhust.brass@gmail.com`

## **_Program Information_**
This program displays a menu of _choices_ which allows the user to develop a list\
Once this list is developed the user can perform operations on this list which are provided\
\
**Choices**
```Java

"A Add String"
"C Count Strings"
"D Duplicate Each"
"H How Many Appear Before"
"I Index Of Last"
"L List Strings"
"Q Quit"
"R Remove from Even Indices"
"S Remove String at some Index"
"? Display Help"

```


## **_Data Structures_**
To understand LinkedLists you must first understand data structures and how they are used within lists\

### **Static Vs. Dynamic Data Structures**
* A _static_ data structure has a fixed size (Arrays) `int[] numbers = new int[size]`
* _Dynamic_ data structures grow and shrink as required by the information it contains (LinkedLists)

\
An object _reference_ is a var that stores the address of an object\
A reference is also called a _pointer_\
Object references can be used to create _links_ between objects

![Data Structure Tree](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/dataStructure.png)


## **_Linked Lists_**
Consider an object that contains a reference to another object of the same type:

```Java

class Node
{

    String name;
    Node pointer;

}

```
1. This can construct a _linked list_
![Name to Pointer](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/namePointer.png)

2. **Delete** an entry from a linked list
![DeleteEntry](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/DeleteEntry.png)

3. Insert an element into the linked list
![addElement](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/DeleteEntry.png)


### Below is the basic information for constructing a linked list

_Note:_ You need to be careful in boundary cases such as
operations at the beginning and the end of a list.

```Java

//This Linked List class shows how some of its commonly used methods are implemented. 
// A linked list is a sequence of nodes with efficient element insertion and removal.
// This class contains a subset of the methods of the standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{

    private class Node //nested class to represent a node

    {

        public Object data;
        public Node next;

    }

    private Node first; //only instance variable that points to the first node.

    // Constructs an empty linked list.
    public LinkedList()
    {

        first = null;

    }

    //Returns the first element in the linked list.
    public Object getFirst()
    {

        if (first == null)
        {

            NoSuchElementException ex = new NoSuchElementException();
            throw ex;

        }

        else
            return first.data; //returns object of the first element


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
            first = first.next;  //change the reference since it's removed  
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

    }   

    // Returns an iterator for iterating through this list.
    public ListIterator listIterator()
    {

        return new LinkedListIterator();

    }

    //nested class to define its iterator
    private class LinkedListIterator implements ListIterator
    {

        private Node position; //current position
        private Node previous; //it is used for remove() method

        // Constructs an iterator that points to the front of the linked list.
        public LinkedListIterator()
        {
            position = null;
            previous = null;
        }

        // Tests if there is an element past the iterator position.
        public boolean hasNext()
        {
            if (position == null) //not traversed yet
            {

                if (first != null)  return true;
                else   return false;
            }
            else
            {
                if (position.next != null)  return true;
                else  return false;
            }
        }

        // Moves the iterator to the next element, and returns
        // the traversed element's data.
        public Object next()
        {

            if (!hasNext()) {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            }
            else {

                previous = position; // Remember for remove
                if (position == null)   position = first;
                else     position = position.next;
                return position.data;
            }
        }

        // Adds an element past the iterator position
        // and moves the iterator to point to
        //  the inserted element.
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
                    removeFirst();

                else
                    previous.next = position.next; //removing

                //stepping back
                //this also means that remove() cannot be called twice in a row
                position = previous;

            }

        }

        // Sets the last traversed element to a different value
        public void set(Object element)
        {

            if (position == null)  {

                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            }
            else
                position.data = element;
        }
            
    } //end of LinkedListIterator class
} //end of LinkedList class


// The ListIterator interface allows access of a position in a linked list.
// This interface contains a subset of the methods of the standard java.util.ListIterator interface. 
// The methods for backward traversal are not included.

public interface ListIterator
{

    //Move Moves the iterator past the next element.
    Object next();

    // Tests if there is an element after the iterator position.
    boolean hasNext();

    // Adds an element before the iterator position
    // and moves the iterator past the inserted element.
    void add(Object element);

    // Removes the last traversed element. This method may only be called after a call to the next() method.
    void remove();

    // Sets the last traversed element to a different value.
    void set(Object element);

} //end of ListIterator

```

## **_Linked List UML Diagram_**

This UML Diagram explains the reference from LinkedList to LinkedListIterator and listIterator

![LinkedListUML](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/linkedListUML.png)


## **_Linked List Effeciency_**

Let's compare the effeciency of using a linkedList compared to an ArrayList\

![ListEffeciency](https://raw.githubusercontent.com/Markay12/JavaLinkedList/master/edu/ListEffeciency.png)

* In ArrayList, we can access any element by specifying its index in constant time. – O(1)
* In LinkedList, we need to go through n/2 elements on average to get to an element. – O(n)

* In ArrayList, adding or removing an element can take O(n)   (=O(n/2) on average) because of shifting all elements.
* In LinkedList, adding or removing an element can be done in constant time, assuming that the iterator is already in the right position – O(1)

**NOTE:** This all depends on the algorithm that we are writing and what it calls for









