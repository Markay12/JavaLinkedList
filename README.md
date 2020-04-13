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

[LinkedList Code](https://github.com/Markay12/JavaLinkedList/blob/359f527b60388e42c9471aae04d667647c4823dc/source/LinkedList.java#L11)

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









