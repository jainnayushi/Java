Collection Framework
Generics
Thread - MultiThreading
Oops
Abstract class and Interface
File Handling
Java 8 features
Arrays and Strings
---
---

># 1. Basic
# Java Basics
* We can  have only one public class in a single java file
* Name of the file should be same as the same of public class
* In absence of public class, any class name can be given to the file name
* WORA - Write Once Run Anywhere
* Java code (.java) -> Compiler-Javac -> Byte Code(.class)
* NO Linker here
* JIT - Just-In-Time compiler - Converts Byte code into machine code
* JIT is like Interpreter though is a compiler, It does not converts all the file in one go like compiler, but converts each line and while it is processed converts another line and stores like interpreter.
* Not in one go - unlike compiler but yet sends before fully converting
* Line by line - like interpreter but also keeps sending line as it converts and stores next

### Run Commands
```java
javac Hello.java
java Hello
or
java Hello.java
```

# JDK, JRE, JVM
* JDK - Java Development Kit - `JRE + Tool` for Java lang - javac, jar | Physically exists
* JRE - Java Runtime Environment - `JVM + Inbuilt-extra libraries-classes` | Physically exists
* JVM - Java Virtual Machine - Virtual layer | `Code executes here` | Virtually exists
* All are platform dependent.
* Java is platform Independent.

# Data Types
1. Integer
    - int : 4 bytes
    - long : 8 bytes
    - short : 2 bytes
    - byte : 1 bytes : 2^7 to 2^7-1 : -128 to 127
2. Float
    - float : 4 bytes : 5.6f
    - double : 8 bytes : 5.6
3. Character : 2 bytes | UNICODE
4. Boolean : Machine dependent | true/false | NO 0/1

# Extra
```java
// System.out.println(10/0); // Exception in thread "main" java.lang.ArithmeticException: / by zero
System.out.println(10/0.0); // Infinity
System.out.println(-10/0.0); // -Infinity

// System.out.println(0/0); // Exception in thread "main" java.lang.ArithmeticException: / by zero
System.out.println(0/0.0); // NaN : Undefined
System.out.println(0.0/0.0); // NaN : Undefined
System.out.println(-0.0/0.0); // NaN : Undefined

System.out.println(Float.NaN == Float.NaN ); // false 
System.out.println(Float.NaN != Float.NaN ); // true

int i=1; 
i+=++i + i++ + ++i + i++; // i=i + ++i + i++ + ++i + i++ 
System.out.println(i); //13 
```

# Literals
* int num = 0x7E : `Hexadecimal`
* int num1 = 0b101 : `Binary`
* int num2 = 10_00_00_000 :`_ For 0 seperation`
* int double num3= `12e10/1.2e11`
* long l=5854`l`;
* float f=5.8`f`;

```java
public class hello {
	public static void main(String[] args) {
		int num1=9;
		byte by=127;
		short sh=558;
		long l=5854l;
		
		float f=5.8f;
		double d=5.8;
		
		char c='k';
		
		boolean b=true;
	}
}
```

# Type Conversion and Casting
byt b = 127;
int a = 12;

### Conversion
    - Lower to upper
    - a=b : Conversion
### Casting
    - Upper to lower
    - b=a NO => b = (byte)a : Casting
    - `Explicitly`
    - In case of out of bound : `number%Range`
byt b = 127;
int a = 257; : byte max can be 128
- b = (byte)a : b will be 1 (257%256)

```java
public class Basic {
    public static void main(String args[]){
        int a = 257;
        byte b = 127;
        System.out.println("a - "+a+" b - "+b); // a - 257 b - 127
        // a=b;
        System.out.println("a - "+a+" b - "+b); // a - 127 b - 127
        // b=a; // Error
        b=(byte)a;
        System.out.println("a - "+a+" b - "+b); // a - 257 b - 1

        int a2=2567;
		byte b2=(byte)a2;
		System.out.println("b2 - "+b2); // b2 - 7

        float f=5.6f;
		int t=(int)f;
        System.out.println("t - "+t); // t - 5
		
		byte a3=10;
		byte b4=20;
		int t1=a3*b4;
		System.out.println("t - "+t1); // t1 - 200
    }
}
```
---

># 2. Wrapper Classes
* Java is not said to be 100% Object Oriented due to its non-object primitive types.
* As a solution to this problem, Java allows us to `include the primitives in the family of objects` by using what are called as Wrapper classes.
* There is a wrapper class for every primitive data types in Java.
```java
int -> Integer
byte -> Byte
```

# Methods of wrapper Classes
* valueOf() - Integer.valueOf() - Static method - Object reference of that class
* parseXXX() - Integer.parseInt() - Static Method - returns XXX type value
* XXXValue() - Integer.intValue() - Instance Method - returns XXX primitive type
---

># Packages and Import
* Its nothing more than the way we `organize files into different directories` according to their functionality, usability, category they should belong to!
* Different package have different functionality
* java.io - IO related, java.net - Network related
* Help us _avoid class name collision_
* Provides ease of maintenance, organization and increase collaboration among developers
* Create package in java file - `package folderName;`
* Compile - `javac -d . fileName.java`
* Run - `java packageName.fileName`
* `import packageName.ClassName`
---

># 5. Abstract
# Abstract Classes
* An abstract class `cannot be instantiated`, i.e Object can't be made
* `We can create Reference variable of abstract class`
* Made by using abstract keyword in Java
* Abstract class in Cpp making - virtual keyword
* Example - `Person abstract class, Student and Faculty - SubClass`
* No need of Person object here, what we just need is common methods and properties of Student and Faculty at a single place to avoid repeatability.
* Used to declare common characteristics of sub classes
* Abstract class does not compulsorily have Abstract method
* `It can have constructor` - No object so why constructor? For instance variables. And this constructor can be called by concrete classes as super()

# Abstract Methods
* Methods that contain `no implementation`
* If a class has any Abstract method, entire class will be made abstract class.
* If parent is abstract class, and subclass is not implementing abstract method, it has to be made abstract too and then its subclass has to implement.
* Declaration must end with semicolon rather than block.
* Example - Account has method calculateInterest() - Abstract class,  Saving Acccount is now forced to override calculateInterest()

```java
abstract class A{
    int x;
    abstract void func1();
    abstract void func2(int i);
    void func3(){
        ...
    }
}
abstract class B extends A{
    ....
}
class C extends A{
    abstract void func1(){
        ...
    }
    abstract void func2(int i){
        ...
    }
}
class D{
    public static void main(String[] args){
        A a = new A(); // NO
        B b = new B(); // NO
        C c = new C(); // YES
    }
}
```
---

># 6. Interface
* Keyword is interface
* It `cannot be instantiated`
* `Method` declarations are implicitly - `public abstract`. `public static abstract` in java 8
* `Variable` are implicitly - `public static final`
* `It does not have constructor` - No object so why constructor? Since static variables, so no role of object?
* Like pure virtual function in C++
* If parent is abstract class, and subclass is not implementing abstract method, it has to be made abstract too and then its subclass has to implement.
* We just know prototype.
* Example - Admission, Student, Employee - make function definitions as per need
* Multiple Inheritence possible - Implementing class would
* interface I3 extends I1, I2
* class B extends A implements I3, I4
* 3 types of interfaces :
1. Normal Interfaces
2. Functional Interfaces / SAM - Single abstract method - Feature of lambda expression
3. Marker Interface - Empty interface - It delivers the run-time type information about an object. It is the reason that the JVM and compiler have additional information about an object. Ex - Serializable and Cloneable

```java
interface A{
    int x;
    void func1();
    void func2(int i);
}
abstract class B implements A{
    ....
}
class C implements A{
    public void func1(){
        ...
    }
    public void func2(int i){
        ...
    }
    public void func3(int i){
        ...
    }
}
class D{
    public static void main(String[] args){
        A a = new A(); // NO - Can't create object of interface
        B b = new B(); // NO - Can't create object of interface
        C c = new C(); // YES
    }
}
```

# Object Reference
* Object reference of interface can refer to any of its subclass type
* `Object Reference of Interface - Functions in parent class only can be called`
```java
interface I1{
    void func1();
}
interface I2{
    void func2(int i);
}
class A implements I1, I2{
    public void func1(){
        ...
    }
    public void func2(int i){
        ...
    }
    public void func3(int i){
        ...
    }
}
class Example{
    public static void main(String[] args){
        // 1. Object Reference of class
        A obj1 = new A();
        obj1.f1(); // YES
        obj1.f2(); // YES
        obj1.f3(); // YES

        // 2. Object Reference of Interface - Functions in parent class only can be called
        I1 obj2 = new A();
        obj2.f1(); // YES
        obj2.f2(); // NO - error
        obj2.f3(); // NO - error

        I1 obj3 = new A();
        obj3.f1(); // NO - error
        obj3.f2(); // YES
        obj3.f3(); // NO - error
    }
}
```

# Difference Between Abstract Class and Interface
1. Abstract can have any `access modifier` for members | Interface can have only public members.
2. Abstract class may or may not contain `abstract method` | Interface cannot have defined methods. (Changed now)
3. Abstract class can have `static or non-static` members | Interfaces can have only static member variables.
4. Abstract class can have `final or non-final` members | Interfaces can have only final member variables.
5. Abstract class can have `constructor` | Interface can't have constructor
6. Abstract class can have `0 to 100% abstraction` | Interface have `100% abstraction`
7. Abstract class doesn't support `multiple inheritance` | Interface support `multiple inheritance`
---

># 7. Input from User
* System.in responsible for _Keyboard -> Buffer_
* Scanner's method nextInt() _Buffer -> Variable_

# Scanner Class
* Used to get data from Buffer
* We can read input from _System.in_ object
* Scanner is _final class_, this cannot be extended
* Scanner class is a part of java.util package
* Picks from buffer till delimiter(space, tab) is found
* `Scanner sc = new Scanner(System.in)`
* `x = sc.nextInt()` - buffer data to int
* `x = sc.nextFloat()` etc.
* `x = sc.next()` - one word string `no space`
* `x = sc.next()` - one line words

```java
import java.util.Scanner; // Import the Scanner class
public class Input {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        System.out.print("Enter a number - ");

    	int num = sc.nextInt(); // Read user input
    	System.out.println("You Entered - "+num);
        sc.close();
    }
}
```
### `System.out.println()`
    - System is a class
    - PrintStream is a class
    - out is an object in PrintStream class
    - println is a method in PrintStream class

# 3 Input Ways - User Input using BufferReader and Scanner
1. System.in.read()
    - reads ASCII | So do num-48 | But fails for big numbers
2. BufferReader
    - import java.io.BufferedReader;
    - import java.io.IOException;
    - import java.io.InputStreamReader;
    - InputStreamReader in = new InputStreamReader(System.in);
    - BufferedReader bf = new BufferedReader(in);
    - int num = Integer.parseInt(bf.readLine());
    - System.out.println(num);
3. `Scanner`
    - import java.util.Scanner; import java.io.IOException;
    - Scanner sc = new Scanner(System.in);
    - int num = sc.nextInt();
    - System.out.println(num);

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException{   	
    	
   	System.out.println("Enter a number");
//      1
   	int num=System.in.read(); 
 	System.out.println(num);
   	System.out.println(num-48);
//      2
   	InputStreamReader in=new InputStreamReader(System.in);
   	BufferedReader bf=new BufferedReader(in);
   	int num=Integer.parseInt(bf.readLine());
   	System.out.println(num);
 	BufferedReader bf=new BufferedReader(null);
	System.out.println(num-48);
//      3   	
    Scanner sc=new Scanner(System.in);
    int num=sc.nextInt();
    System.out.println(num);
    }
}
```

># 10. Exception Handling
# Types of error:-
1. Complile - time error
2. Runtime error -> Exception handling
3. Logical error

# Exception Hierarchy
1. Object
2. Throwable
3. Error
    1. Thread Death
    2. Virtual Machine error (Out of memory)
    3. IO Error
3. Exception
    1. Runtime Exception  (Unchecked Exception)
    2. SQL Exception   (Checked Exception)
    3. IO Exception  (Checked Exception)

# Error is divided into :-
1. Thread Death
2. Virtual Machine error ( Out of memory)
3. IO Error

# Exception is divided into:-
* Unchecked Exception - It is your choose to handle or not
* `Checked Exception - Mandatory to handle`
1. Runtime Exception  (Unchecked Exception)
* It is your choose to handle or not
    - Arithmetic
    - ArrayIndexOutOfBound
    - Null POinter
2. SQL Exception   (Checked Exception)
- It is necessary to handle
3. IO Exception  (Checked Exception)
- It is necessary to handle

### Compile Time Error
```java
public class Demo {
    public static void main(String[] args) { 
 	System.out.Println();
    }
}
```

### Logical Error
```java
public class Demo {
    public static void main(String[] args) { 
    System.out.println(2+2); /// 4 Needed 5
    }
}
```

# try with multiple catch block
* `Parent Exception should be last`
```java
public class Demo {
    public static void main(String[] args) {
    	
    	int i=2;
  //  	int i=0;
    	int j=0;
    	
    	int nums[]=new int[5];
    	String str=null;
    	
    	try
    	{
    		j=18/i; // ArithmeticException
    		System.out.println(str.length());
    		System.out.println(nums[1]);
    		System.out.println(nums[5]); // ArrayIndexOutOfBoundsException
    	}
//    	catch(Exception e)
//    	{
//    		System.out.println("Something went wrong."+e);
//    	}
    	catch(ArithmeticException e)
    	{
    		System.out.println("Cannot divide by zero");
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println("Stay in your limit.");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Something went wrong."+e);
    	}
    	System.out.println(j);
    	System.out.println("Bye");
    }
}
```

# throw keyword
* `throw new ArithmeticException("message");`
* throw keyword is used `throw an exception explicitly` in the code, `inside the function or the block of code`.
```java
public class Demo {
    public static void main(String[] args) {
//    	int i=2;
    	int i=0;
    	int j=0;
 
    	try{
    		j=18/i;
    		if(j==0)
    			throw new ArithmeticException("I don't want to do print zero");
    	}

    	catch(ArithmeticException e){
    		j=18/i;
    		System.out.println("that is default output"+e);
//    		System.out.println("Cannot divide by zero");
    	}
    	
    	catch(Exception e){
    		System.out.println("Something went wrong."+e);
    	}
    	System.out.println(j);
    	System.out.println("Bye");
    }
}
```

# Custom Exception
```java
// Syntax
class AyushiException extends Exception{
	public AyushiException(String string){
		super(string);
	}
}

throw new AyushiException("I don't want to do print zero");
```

```java
class AyushiException extends Exception{
	public AyushiException(String string){
		super(string);
	}
}
public class Demo {
    public static void main(String[] args) {
//    	int i=2;
//   	int i=0;
    	int i=20;
    	int j=0;
    	try{
    		j=18/i;
    		if(j==0)
//    			throw new Exception("I don't want to do print zero");
    			throw new AyushiException("I don't want to do print zero");
    	}
        catch(AyushiException e){
            System.out.println("Custom Exception...."+e);
        }
    	catch(ArithmeticException e){
    		j=18/i;
    		System.out.println("that is default output"+e);
//    		System.out.println("Cannot divide by zero");
    	}
    	catch(Exception e){
    		System.out.println("Something went wrong."+e);
    	}
    	System.out.println(j);
    	System.out.println("Bye");
    }
}
```

# throws - Ducking Exception using throws
* Someone will have to handle the exception
* `If you just do throws Exception, parent or parent of parent will ahve to try catch ie handle it `
* throws - public void show() throws ClassNotFoundException or do try-catch
* throws keyword is `used in the method signature` to declare an `exception which might be thrown by the function` while the execution of the code.

```java
class AyushiException extends Exception{
	public AyushiException(String string){
		super(string);
	}
}

class A{
	public void show() throws ClassNotFoundException{
//    	try{
//    		Class.forName("Calc");
//    	}
//    	catch(ClassNotFoundException e){
//    		System.out.println("Not able to find theh class");
//    	}
		Class.forName("Calc"); // throws for this
	}
}

public class Demo {
	static {
		System.out.println("Class Loader");
	}
    public static void main(String[] args) {
    	
//    	try{
//    		Class.forName("Class");
//    	}
//    	catch(ClassNotFoundException e){
//    		System.out.println("Not able to find theh class");
//    	}
    	
    	A obj=new A();
    	try {
    		obj.show();
            throw new AyushiException("I don't want to do print zero");
    	}
        catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    }
}
```

# try with resources
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws NumberFormatException {   
    	
    	int i=0;
    	int j=0;
    	try{
    		j=18/i;
    	}
    	catch(Exception e){
    		System.out.println("Someting went wrong.");
    		System.out.println("Bye");
    	}
    	finally{
    		System.out.println("Bye");
    	}
    	
    	int num=0;
    	//BufferedReader br=null;
    	try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
//    		InputStreamReader in =new InputStreamReader(System.in);
//    		BufferedReader br=new BufferedReader(in);
    		num=Integer.parseInt(br.readLine());
    		System.out.println(num);
    	}
    	finally{
    		//br.close();
}}}
```

# Final TryCatchFinallyThrowThrows
```java
class AyushiException extends RuntimeException{
	public AyushiException(String string){
		super(string);
	}
}
public class TryCatchFinallyThrowThrows throws ClassNotFoundException{
    public static void main(String[] args) {
        // 0 - no exp
        // int i=2;
        // int j=20;        
        // 1 - /0 exp
        // int i=0;
        // int j=10;
        // 2 j-0 throw exp - not working
        int i=2;
         int j=0;
        try{
   		    // Class.forName("Calc");
            // j=18/i;
            if(j==0)
                throw new AyushiException("I don't want to do print zero");
        }

        catch(ArithmeticException e){
            // j=18/i;
            // System.out.println("that is default output"+e);
            System.out.println("Cannot divide by zero...."+e);
        }
        catch(AyushiException e){
            System.out.println("Custom Exception...."+e);
        }
        catch(Exception e){
            System.out.println("Something went wrong."+e);
        }
        finally{
        System.out.println(j);
        System.out.println("Bye");
        }
    }
}
```
---

># 17. Collection
1. Collection API / Collection Framework- Concept
2. Collection - Interface - List, Set
3. Collections - Class

# Collection Framework
* Collection Framework is a `Java API` which `provides architecture` to store and manipulate group of objects.
* Well designed `set of collection interfaces and classes for storing and manipulationg group of data as a single unit`, as collection
* It contains :-
1. `Interfaces` - abstract data types that represent collection
2. `Classes` - Implementation - These are the concrete implementations of collection interfaces
3. `Algorithms` - Methods for computation on objects

# Collection
* Interface - Root Interface
* `Group of objects as single unit`

```java
Interface I1{
    void f1();
    int f2(int a);
}

Class A implements I1{
    public void f1(){
        ...
    }
    public int f2(int a){
        ...
    }
}
```

# Array V/S Collection : Why Collection?
### Array
- Similar type of data collection
- Already size is known mostly
- Operations - have to define methods for each operation
- Due to `fast execution` it `consumes more memory`
- `Better when Size is known` - better choice in terms of performance(but takes more time)
* Limitations of Array :
1. To Use Array concept compulsorily we should `Know the Size in Advance` which May Not be Possible Always.
2. Arrays can hold Only `Homogeneous Data Type` Elements.
3. `NO Readymade Methods Support` as array concept is Not implemented based on Some Standard Data Structure

# Collection
- Group of Individual Objects as a Single Entity
- Size expandable - `Takes more time`
- Homogenous + Heterogenous Data `Except TreeSet and TreeMap`
- Operations - Can use classes - abstract data type - structure + methods
- Flexibility in memory (but increases with also increase in time)
* Advantages Of Collection :
1. Collections are `Growable` in Nature. That is based on Our Requirement we can Increase OR
   Decrease the Size.
1. Collections can `Hold Both Homogeneous and Heterogeneous` Elements.
2. Every Collection Class is implemented based on Some Standard Data Structure. Hence for Every Requirement `Readymade Method Support is Available`. Being a Programmer we have to Use those Methods and we are Not Responsible to Provide Implementation.
* To Hold and Transfer Data (Objects) form One Location to Another Location - Every Collection Class Implements Serializable and Cloneable Interfaces.

># Collection
* Interface
* Root Interface of Collection Framework
* There's no concrete class which implements Collection Interface directly.
* `Collection` -> `List` - `Set` - `Queue`
* `List` -> ArrayList - LinkedList - Vector -> Stack
* `Set` -> HashSet -> LinkedHashSet - `SortedSet` -> `NavigableSet` -> TreeSet
* `Queue` -> PriorityQueue - BlockingQueue -> PriorityBlockingQueue - LinkedBlockingQueue
* `Map` -> HashMap -> LinkedHashMap - WeakHashMap - IdentityHashMap - Hashtable-> Properties - `SortedMap`-> `NavigableMap`-> TreeMap
* Only TreeMap and TreeSet can't contain heterogenous

# List
* Interface - child of Collection Interface
* `Duplicates allowed`
* `Insertion order Preserved`
* Index will Play Very Important Role in List
* `ArrayList and Vector Classes Implements RandomAccess Interface`. So that we can Access any Random Element with the Same Speed. `RandomAccess Interface` Present in java.util Package and it doesn't contain any Methods. Hence it is a Marker Interface
* ArrayList, LinkedList, Vector -> Stack are the Implementation classes

# ArrayList
* Defined using dynamic arrays - Resizable Array or Growable Array
* `Duplicates allowed`
* `Insertion order Preserved`
* `Null Insertion possible`
* `Heterogenous objects allowed`
* Contiguous memory allocation - have to shift before inserting reduces performance
* It is resizable
* ArrayList is `Best Suitable` if Our Frequent Operation is `Retrieval Operation due to RandomAccess Interface`.
* ArrayList is `Worst Choice` if Our Frequent Operation is `Insertion OR Deletion in the Middle`. Because it required Several Shift Operations Internally.
* default capacity "10"
* If reaches max capacity : New Capacity=(current capacity*3/2)+1
* Non – Synchronized : two or more threads can access the methods of that particular class at any given time
* NOT Thread safe : different threads can access the same resources with exposing erroneous behavior or producing unpredictable results
* `ArrayList lst = new ArrayList()`
* `ArrayList lst = new ArrayList(int initialCapacity)`
* `ArrayList lst = new ArrayList(Collection c)`
* Get Synchronized Version of ArrayList Object by using the following Method of Collections Class
```java
ArrayList lst = new ArrayList();
List l = Collections.synchronizedList(lst);
// lst - Non - Synchronized Version
// l - Synchronized Version
```
*

# LinkedList
* Uses Doubly Linked List
* `Duplicates allowed`
* `Insertion order Preserved`
* `Null Insertion possible`
* `Heterogenous objects allowed`
* Logically contiguous, but actually not - no need to shift, just create another node - cost of inserting less
* Implements Serializable and Cloneable Interfaces but Not RandomAccess Interface.
* `Best Choice` if Our Frequent Operation is `Insertion OR Deletion in the Middle`.
* `Worst Choice` if Our Frequent Operation is `Retrieval` - Accessing nth element is costly
* We can Use LinkedList to Implement Stacks and Queues - 6 methods
* `LinkedList llst = new LinkedList()`
* `LinkedList llst = new LinkedList(Collection c)`

# Vector
* Defined using dynamic arrays - Resizable Array or Growable Array
* `Duplicates allowed`
* `Insertion order Preserved`
* `Null Insertion possible`
* `Heterogenous objects allowed`
* Low performance than arrayList
* Introduced in 1.0, reengineered in 1.2 as Legacy class
* Has `Enumeration` loop option
* Implements Serializable, Cloneable and RandomAccess interfaces.
* `Every Method is Synchronized` so `Thread safe`
* Vector is the `Best Choice` if Our Frequent Operation is `Retrieval`.
* `Worst Choice` if Our Frequent Operation is `Insertion OR Deletion` in the Middle
* Default Initial Capacity "10"
* New Capacity = Current Capacity * 2
* `Vector v = new Vector()`
* `Vector v = new Vector(int initialCapacity)`
* `Vector v = new Vector(int initialCapacity, int incrementalCapacity);`
* `Vector v = new Vector(Collection c)`

# Stack
* LIFO principle
* Subclass of Vector class
* `Stack stk = new Stack()`

# Set
* Interface - child of Collection Interface
* `Duplicates NOT allowed`
* `Insertion order NOT Preserved`
* HashSet, LinkedHashSet are the Implementation classes
* Has only methods of Collection, `NO new method`
* `Insertion Order not preserved except in LinkedHashSet`
* `NULL insertion not allowed only in TreeSet`

# HashSet
* Class - child of Set Interface
* Uses Hash Table data structure
* `Insertion order NOT Preserved` - But, `Inserted based on Hash Code`
* `Heterogenous objects allowed`
* `Null Insertion possible`
* `Provides efficient searching`
* _If you do add and try to insert duplicate object - Returns false and not error_
* HashSet implements Serializable and Cloneable Interfaces but Not RandomAccess.
* If Our `Frequent Operation is Search Operation, then HashSet is the Best Choice`
* Default capacity - "16"
* After 75% is filled, it grows dynamically - Fill Ratio/ Load factor - 0.75
* Load Factor/Fill Ratio 0.75 Means After Filling 75% Automatically a New HashSet Object will be Created.
* `HashSet hset = new HashSet()`
* `HashSet hset = new HashSet(int capacity)`
* `HashSet hset = new HashSet(int capacity, float loadFactor)`
* `HashSet hset = new HashSet(Collection c)`
* hset.add("Z"); System.out.println(hset.add("Z")); // false and not error
* No set() method here

# LinkedHashSet
* SubClass - subclass of HashSet Class
* Uses `Hash Table + Doubly Linked List` data structure
* `**Insertion order Preserved**`
* `Heterogenous objects allowed`
* `Null Insertion possible`
* `Provides efficient searching`
* _If you do add and try to insert duplicate object - Returns false and not error_
* Default capacity - "16"
* After 75% is filled, it grows dynamically - Fill Ratio/ Load factor - 0.75
* `LinkedHashSet hset = new LinkedHashSet()`
* `LinkedHashSet hset = new LinkedHashSet(int capacity)`
* `LinkedHashSet hset = new LinkedHashSet(int capacity, float loadFactor)`
* `LinkedHashSet hset = new LinkedHashSet(Collection c)`
- We can Use LinkedHashSet and LinkedHashMap to `Develop Cache Based Applications` where `Duplicates are Not Allowed` and `Insertion Order Must be Preserved`.

# SortedSet
* Interface - child of Set Interface
* `Duplicates NOT allowed`
* `Insertion order NOT Preserved`
* `Some Logical Sorted order` : Sorting can be Either Default Natural Sorting OR Customized Sorting Order (For String Objects Default Natural Sorting is Alphabetical Order. For Numbers Default Natural Sorting is Ascending Order.)
* 6 new methods

# NavigableSet
* Interface - child of SortedSet Interface
* `Duplicates NOT allowed`
* `Insertion order NOT Preserved`
* `Some Logical Sorted order`
* Defines methods for navigation purposes
* TreeSet is a Implementation class
* 6 new methods

# TreeSet
* Interface - child of NavigableSet Interface
* TreeSet is a Implementation class
* Defines methods for navigation purposes
* `Duplicates NOT allowed`
* `Insertion order NOT Preserved`
* `Some Logical Sorted order` - Natural Order - Integer asc, String dictionary, StringBuffer not
* `_Heterogenous elements NOT allowed_` : have to be Homogenous else `classCastException`
* Implements Serializable and Cloneable Interfaces but Not RandomAccess Interface.
* **Null Insertion NOT allowed**
* `TreeSet tset = new TreeSet()` : empty + sorted in natural order
* `TreeSet tset = new TreeSet(Comparator c)` : empty + sorted in specified comparator order : Comparator c object, either in same class or diff
* `TreeSet tset = new TreeSet(Collection c)` : Collection ele + sorted in natural order
* `TreeSet tset = new TreeSet(SortedSet s)` : new TreeSet with same logic as s - same Collection ele + same sorted order
* By default before adding any element, compareTo() of `Comparable` Interface is called and then arranged - Wrapper Classes, Integer, String or by a `Comparator`.
* StringBuffer Class doesn't Implement Comparable Interface. Hence we get ClassCastException
* t.add(new StringBuffer("B")); System.out.println(t) // ClassCastException
* `Exception` : If we are defining Our Own Sorting by Comparator then Objects Need Not be Homogeneous and Comparable. That is `we can Add Heterogeneous Non Comparable Objects to the TreeSet`.

# Queue
* Interface - child of Collection Interface
* `Duplicates allowed`
* `Null Insertion NOT allowed`
* `Heterogenous elements allowed`
* Orders in FIFO principle - But Based on Our Requirement we can Implement Our Own Priorities Also (PriorityQueue)
* LinkedList based Implementation of Queue always follows FIFO Order
* If we want to `Represent a Group of Individual Objects Prior to Processing then we should go for Queue`.
* Eg: Before sending a Mail we have to Store All MailID’s in Some Data Structure and in which Order we added MailID’s in the Same Order Only Mails should be delivered (FIFO). For this Requirement Queue is Best Suitable.
* From 1.5 Version onwards LinkedList also implements Queue Interface
* PriorityQueue, BlockingQueue -> PriorityBlockingQueue, LinkedBlockingQueue are the Implementation classes

# PriorityQueue
* PriorityQueue - Implementation class of Queue. Actually, Queue Interface -> AbstractQueue(implementing class of Queue) -> ProrityQueue
* `Null Insertion NOT allowed`
* `NOT Thread Safe`
* `Use PriorityBlockingQueue for Thread Safe`
* Natural Order of sorting by `Comparable` or sorted by a `Comparator` provided at Queue Construction Time.
* Default capacity "11"
* `PriorityQueue pq = new PriorityQueue()`
* `PriorityQueue pq = new PriorityQueue(Collection c)`
* `PriorityQueue pq = new PriorityQueue(int capacity)`
* `PriorityQueue pq = new PriorityQueue(int capacity, Comparator c)`
* `PriorityQueue pq = new PriorityQueue(SortedSet s)`
* `PriorityQueue pq = new PriorityQueue(PriorityQueue p)`
* Offer order - Can be any order
* `Poll Order - Natural Sorting Order`

# Map
* Interface - `NOT a child of Collection Interface`
* Represents group of objects as `key-value pairs`
* Key value both are objects - `Key unique`
* Duplicate Keys are Not allowed. But Values can be Duplicated.
* Each Key - Value Pair is Called an Entry
* HashMap -> LinkedHashMap, WeakHashMap, IdentityHashMap, Hashtable-> Properties, SortedMap-> NavigableMap-> TreeMap are the Implementation classes
* All map implementation classes `should provide two "Standard" constructors` : ??
1. A void `no arguments` constructor which creates an empty map
2. A constructor with a `Single argument` of type Map, which creates a new map with the same key-value mappings as its argument.

# Map.Entry
* Inner Interface of Map Interface
* A map entry(key-value pair)
* Without existing Map Object there is No Chance of existing Entry Object. Hence Interface Entry is Define Inside Map Interface.
* 2 methods - getKey() and getValue() and setValue(Object new) ??

# HashMap
* Hash Table used as data structure
* `Contains only Unique keys`
* `Heterogeneous Objects allowed` for Both Keys and Values.
* `Insertion Order NOT preserved` and `it is based on hash code of the keys`.
* `NULL value allowed ONCE for keys`
* It may have _one null key and multiple null values_ - Next attempt to enter null as key, it simply discards without any error
* Initial capacity "16"
* Default Fill Ratio/loadFactor = "0.75"
* `HashMap hmap = new HashMap()`
* `HashMap hmap = new HashMap(int capacity)`
* `HashMap hmap = new HashMap(int capacity, float loadFactor)`
* `HashMap hmap = new HashMap(Map<? extends K,? extends V> m)`
* Non-Synchronized by default.
* Get Synchronized Version of HashMap by using the following Method of Collections Class
```java
HashMap hmap = new HashMap();
HashMap h = Collections.synchronizedMap(hmap);
// hmap - Non - Synchronized Version
// h - Synchronized Version
```

# LinkedHashMap
* Subclass of HashMap
* `Insertion order preserved`
* Slower insertion and deletion
* Hybrid DS - DLL + Hash Table
* * We can Use LinkedHashSet and LinkedHashMap to _Develop Cache Based Applications_ where Duplicates are Not Allowed and Insertion Order Must be Preserved.

# IdentityHashMap
* `It is exactly same as HashMap, except` the following difference.
* In HashMap JVM will Use .equals() to Identify Duplicate Keys,  which is Meant for Content Comparision.
* `In IdentityHashMap JVM will uses ==` Operator to Identify Duplicate Keys, which is `Meant for Reference Comparison`.
```java
// HashMap - equals() - Content Comparison.
hmap.put(new Integer(10),"Pawan");
hmap.put(new Integer(10),"Kalyan");
System.out.println(m); //{10=Kalyan} // Because I1 and I2 are Duplicate as I1.equals(I2) Returns true.

// IdentityHashMap - == - Reference Comparison
ihmap.put(new Integer(10),"Pawan"); 
ihmap.put(new Integer(10),"Kalyan");
System.out.println(m); //{10=Pawan, 10=Kalyan} // Because I1 and I2 are Not Duplicate as I1 == I2 Returns false.
```

* WeakHashMap
* It is `exactly same as HashMap Except` the following difference :
* In Case of HashMap, `HashMap dominates Garbage Collector`. That is `if Object doesn’t have any Reference `Still it is `Not Eligible for Garbage Collector if it is associated with HashMap`.
* In Case of WeakHashMap, `Garbage Collector Dominates WeakHashMap`.That is if an Object doesn't contain any References then it is `Always Eligible for GC Even though it is associated with WeakHashMap`.
```java
import java.util.HashMap;
class WeakHashMapDemo {
        public static void main(String[] args) throws InterruptedException {
        HashMap m = new HashMap();
        Temp t = new Temp();
        m.put(t, "Durga");
        System.out.println(m);
        t = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(m);
        }
    }
    class Temp {
        public String toString() {
            return "temp";
        }
        public void finalize() {
            System.out.println("finalize() Called");
        }
}

// With HashMap
{temp=Durga}
{temp=Durga}
// With WeakHashMap
{temp=Durga}
finalize() Called
```

# Hashtable
* `_Thread safe_` version of HashMap
* `Duplicate Keys NOT Allowed`
* `Insertion Order NOT Preserved`
* Unsorted and Unordered
* `NO Sorting`
* `Order NOT preserved
* `NULL value not allowed` for Both Key and Values. Otherwise we will get Runtime Exception Saying NullPointerException.unlike HashMap
* Default Initial Capacity "11"
* Default Fill Ratio "0.75"
* `Hashtable h = new Hashtable();`
  *` Hashtable h = new Hashtable(int initialcapacity);`
* `Hashtable h = new Hashtable(int initialcapacity, float fillRatio);`
* `Hashtable h = new Hashtable(Map m);`
* Table data print : Top to Bottom, Right to Left

# Properties
* SubClass - Child of Hashtable
* Properties can be used to Represent a Group of Key – Value Pairs where Both Key and Value should be String Type.
* In Our Program if `anything which Changes Frequently` (Like Database User Name, Password, Database URLs Etc) Never Recommended to Hard Code in Java Program. Because for Every Change in Source File we have to Recompile, Rebuild and Redeploying Application and Sometimes Server Restart Also Required, which Creates Business Impact to the Client.
* To Overcome this Problem we have to Configure Such Type of Properties in Properties File.
* The Main Advantage in this Approach is if a there is a Change in Properties File, to Reflect that Change Just Redeployment is Enough, which won't Create any Business Impact.
* We can Use Properties Object to Hold Properties which are coming from Properties File.
* `Properties p = new Properties();`
*

# SortedMap
* Interface - child of Map Interface
* `Some Sorting order`
* `Sorting logic applies on keys`

# NavigableMap
* Interface - child of SortedMap Interface
* Defines methods for navigation purposes
* TreeMap is a Implementation class

# TreeMap
* Class - child of NavigableMap Interface
* Red-Black tree based.
* `NOT Thread Safe`
* `Insertion order NOT Preserved`
* `Some Logical Sorted order` - Natural Order - Integer asc, String dictionary, (StringBuffer is not) or use comparator
* `_Heterogenous keys NOT allowed-Heterogenous Values allowed_` : have to be Homogenous else `classCastException`
* `Null Insertion possible in Empty TreeSet only once, not in Non-empty/Null Empty TreeSet till version 6` otherwise mostly not possible >6 version ??
* `TreeMap tmap = new TreeMap()` : empty + sorted in natural order
* `TreeMap tmap = new TreeMap(Comparator c)` : empty + sorted in specified comparator order : Comparator c object, either in same class or diff
* `TreeMap tmap = new TreeMap(Collection c)` : Collection ele + sorted in natural order
* `TreeMap tmap = new TreeMap(SortedMap m)` : Inter Conversion between Map Objects.
* `TreeMap tmap = new TreeMap(Map m)` : Inter Conversion between Map Objects.
* By default before adding any element, compareTo() of `Comparable` Interface is called and then arranged - Wrapper Classes, Integer, String or by a `Comparator` `on keys`.

## Comparable - Sorting
* Interface
* `default sorting`

## Comparator - Sorting
* Interface
* `Customized sorting`

## Utility Classes
* Collections
* Arrays

## Legacy Classes
* Vector
* Stack
1. Enumeration (I)
2. Dictionary (Abstract Class)
3. Vector (Concrete Class)
4. Stack (Concrete Class)
5. Hashtable (Concrete Class)
6. Properties (Concrete Class)

># Methods

# Methods of Collection
* boolean add(Object o); - l.add("Red")
* boolean addAll(Collection c); - l.addAll(lst)
* boolean remove(Object o); - l.remove("Red")
* boolean removeAll(Collection c); - l.removeAll(lst)
* boolean retainAll(Collection c)); - l.retainAll(lst) : To Remove All Objects Except those Present in c.
* int size(); - l.size()
* boolean contains(Object o); - l.contains("Red")
* boolean containsAll(Collection c) - l.containsAll(lst)
* void clear(); - l.clear()
* boolean isEmpty(); - l.isEmpty()
* Object[] toArray()
* Iterator<E> iterator()
```java
Iterator itr = lst.iterator();
while(itr.hasNext()){
    Sout(itr.next());
}
```

# Methods of List
* void add(int index, E element) : shifts and insert
* E set(int index, E element) : replace and insert
* E get(int index)
* int indexOf(Object o) : first Occurence : if -1: element not present
* int lastIndexOf(Object o) : last Occurence : if -1: element not present
* E remove(int index)
* list<E> subList(int fromIndex, int toIndex) : returns portion of list (from,to]

# Methods of LinkedList
* void addFirst(Object o)
* void addLast(Object o)
* Objects.getFirst()
* Objects.getLast()
* Objects.removeFirst()
* Objects.removeLast()

# Methods of Vector
1. To Add Elements:
* add(Object o) : Collection
* add(int index, Object o) : List
* addElement(Object o) : Vector
2. To Remove Elements:
* remove(Object o) : Collection
* remove(int index) : List
* removeElement(Object o) : Vector
* removeElementAt(int index) : Vector
* clear() : Collection
* removeAllElements() : Vector
3. To Retrive Elements:
* Object get(int index) : List
* Object elementAt(int index) : Vector
* Object firstElement() : Vector
* Object lastElement() : Vector
4. Some Other Methods:
* int size()
* int capacity()
* Enumeration element()

# Methods of Stack
* boolean empty()
* E peek() - Return Top of the Stack without Removal
* E pop() -  Remove and Return Top of the Stack
* E push(E element)
* int search(Object o) - `Returns *Offset* if the Element is Available Otherwise Returns -1`
* Ele : A B C
* Index : 0 1 2
* Offset : 3 2 1 : Top has 1, then bottom 2

# Methods of Sorted Set
* Object first() : first as per sorted order
* Object last() : last as per sorted order
* SortedSet headSet(E toElement) : Portion less than toElement
* SortedSet tailSet(E fromElement) : Portion greater than or equal to fromElement
* SortedSet subSet(E fromElement, E toElement) : Portion [fromElement, toElement)
* Comparator comparator() - returns comparator (used to order elements in this set), or null (if this set uses natural ordering of its elements)
---

# Methods of NavigableSet
* ceiling(E e) : greatest ele >= e or null(if not present)
* floor(E e) : lowest <= e or null(if not present)
* higher(E e) : greater ele strictly > e or null(if not present)
* lower(E e) : lower ele strictly < e or null(if not present)
* pollFirst() : retrieves and removes first(lowest) ele or null(if not present)
* pollLast() : retrieves and removes last(highest) ele or null(if not present)
* `descendingSet()` : It Returns NavigableSet in Reverse Order.

# Methods of TreeSet
* TreeSet tset = new TreeSet(Comparator c)

# Methods of Queue
* `Returns special value(null or false) ON Fail`
* boolean offer(E e)
* E poll()
* E peek() : view element
* `Throws exception ON Fail`
* boolean add(E e)
* E remove()
* E element() : view element

# Methods of Entry
* Object getKey() : used to obtain key
* Object getValue() : used to obtain value
* Object setValue(Object new)

# Methods of Map
* Object put(Object key, Object value) : inserts an entry in this map : To Add One Key - Value Pair. If the specified Key is Already Available then Old Value will be Replaced with New Value and Returns Old Value.
* Object putAll(Map map) : inserts specified map in this map
* Object remove(Object key) : deletes an entry for specified key
* Object get(Object key) : returns the value for specified key
* boolean containsKey(Object key) :
* boolean containsKey(Object key)
* boolean containsValue(Object value)
* boolean isEmpty()
* int size()
* void clear()
* Collection Views of Map -
* Set keySet() : Set view containing `all the keys`
* Set entrySet() : Set view containing `all the keys and values`
* Collection values()

# Methods of HashMap
* int size() - # of key-value pairs
* boolean isEmpty()
* V get(Object key) : returns the value for specified key or null if no mapping for the key

# Methods of SortedMap
* Object firstKey();
* Object lastKey();
* SortedMap headMap(Object key)
* SortedMap tailMap(Object key)
* SortedMap subMap(Object key1, Object key2)
* Comparator comparator()

# Methods of NavigableMap
* ceiling(E e) : greatest ele >= e or null(if not present)
* floor(E e) : lowest <= e or null(if not present)
* higher(E e) : greater ele strictly > e or null(if not present)
* lower(E e) : lower ele strictly < e or null(if not present)
* pollFirst() : retrieves and removes first(lowest) ele or null(if not present)
* pollLast() : retrieves and removes last(highest) ele or null(if not present)
* `descendingSet()` : It Returns NavigableSet in Reverse Order.

# Methods of Properties
* public String getProperty(String pname); To Get the Value associated with specified Property.
* public String setProperty(String pname, String pvalue); To Set a New Property.
* public Enumeration propertyNames(); It Returns All Property Names.
* public void load(InputStream is); To Load Properties from Properties File into Java Properties Object.
* public void store(OutputStream os, String comment); To Store Properties from Java Properties Object into Properties File.
---

># Cursor
* Interface actually, here its a way to retrieve data from collection object one by one
* 3 cursors in java
* Facility Order :- `ListIterator > Iterator > Enumeration`

# 1. Enumeration
* Introduced in 1.0 for legacy classes - Vector, stack
* Enumeration Concept is Applicable Only for Legacy Classes and it is Not a Universal Cursor
* Limitations -
1. `Forward Cursor` (Single direction)
2. `Only read operation available`
3. `Unable to add or replace any element`

```java
public interface Enumeration<E>{
    boolean hasMoreElements();
    E nextElement();
}

public Enumeration elements() 
```
* `v` - vector object (Vector v = new Vector())
* `Enumeration` - Interface
* `elements()` - Method of collection classes
* `v.elements()` - Object of enumeration implementing class
* `Enumeration e` - Reference of enumeration interface
* `e.hasMoreElements()` - Calling method - gives boolean res if ele is present or not
* `e.nextElement()` - Calling method - give ele
* Have to typecast based on object type

```java
Enumeration e = v.elements(); 
while(e.hasMoreElements()){
    Sout(e.nextElement())
    String str = (String)e.nextElement();
}
```

# 2. Iterator
* Available for all collection implemented classes.
* We can Apply Iterator Concept for any Collection Object. Hence it is Universal Cursor.
* `void remove(); : Not availabe in Enumeration`
* Limitations -
1. `Forward Cursor` (Single direction)
2. `Only read and remove operation available`
3. `Unable to add or replace any element`
```java
public interface Iterator<E>{
    boolean hasNext();
    Object next();
    void remove(); // Not availabe in Enumeration
}

public Iterator iterator()
```

* `Iterator` - Interface
* `iterator()` - Method of classes
* Have to typecast based on object type
```java
Iterator itr = lst.iterator(); 
while(itr.hasNext()){
    Sout(itr.next())
    String str = (String)itr.next();
    if(str=="Abc"){ itr.remove() }
}
```

# 3. ListIterator
* Interface - Child Interface of iterator
* `Forward+Backward : BiDirectional Cursor`
* The `Most Powerful Cursor` is ListIterator
* Limitation -
1. It is `Only applicable for List Objects`
```java
public interface ListIterator<E>{
    // Forward direction
    boolean hasNext();
    Object next();
    int nextIndex(); // Not availabe in Enumeration and Iterator
    // Forward direction
    boolean hasPrevious(); // Not availabe in Enumeration and Iterator
    Object previous(); // Not availabe in Enumeration and Iterator
    int previousIndex(); // Not availabe in Enumeration and Iterator
    //
    void remove(); // Not availabe in Enumeration
    void set(E e) // Replace & Insert - Not availabe in Enumeration and Iterator
    void add(E e) // Shift & Insert - Not availabe in Enumeration and Iterator
}

public ListIterator listIterator()
```

* `ListIterator` - Interface
* `listIterator()` - Method of classes
* Have to typecast based on object type
```java
ListIterator litr = lst.listIterator(); 
while(litr.hasNext()){
    Sout(litr.next())
    String str = (String)itr.next();
    if(str=="Abc"){ litr.remove() }
    if(str=="A"){ litr.set("A1") } // Replace A with A1
    if(str=="B"){ litr.add("C") } // Add C after B
}
```

># Sorting
* If we are Depending on `Natural Sorting Order` then the Objects should be `Homogeneous and Comparable` otherwise we will get `ClassCastException`.
* If we are defining Our Own `Sorting by Comparator` then the Objects Need Not be `Homogeneous and Comparable`.

### When we go for Comparable and When we go for Comparator: Comparable Vs Comparator:
* For Predefined Comparable Classes (Like String) Default Natural Sorting Order is Already Available. If we are Not satisfied with that we can Define Our Own Sorting by Comparator Object.
* For Predefine Non - Comparable Classes (Like StringBuffer) Default Natural Sorting Order is Not Already Available. If we want to Define Our Own Sorting we can Use Comparator Object.
* For Our Own Classes (Like Employee) the Person who is writing Employee Class he is Responsible to Define Default Natural Sorting Order implementing Comparable Interface.
* The Person who is using Our Own Class if he is Not satisfied with Default Natural Sorting Order he can Define his Own Sorting by using Comparator Object.
* If Person is satisfied with Default Natural Sorting Order then he can Use Directly Our Class.

# Comparable
* Interface
* Comparable Interface Present in java.lang Package
* Has `1 method` - compareTo(Object o)
* `Natural Sorting Order`
* Wrapper Classes have implemented Comparable Interface and have compareTo(). So `only Wrapper Classes have natural sorted order` facility.(StringBuffer ahs not implemented so natural order isn't there and gives classCastException)
* `Default natural sorting works for` :
1. `Homogenous` Objects
2. `Comparable` Objects
* System.out.println("Z".compareTo(null)); //RE: java.lang.NullPointerException
```java
interface Comparable{
    int compareTo(Object obj)
}
```
* Whenever we are Depending on Default Natural Sorting Order and if we are trying to Insert Elements then `Internally JVM will Call compareTo()` to Identify Sorting Order.
1. Returns –ve if and Only if obj1 has to Come Before obj2
2. Returns +ve if and Only if obj1 has to Come After obj2
3. Returns 0 if and Only if obj1 and obj2 are Equal

- Comparable : Default Natural Sorting Order | gives power to class to compare its obj
- Comparator : Customized Sorting Order | logic to custom sort

# Comparator
* Interface in java.util.package
* Used for `Custom sorting order`
* Whenever we are implementing Comparator Interface, `Compulsory we should Provide Implementation for compare()`.
* Has `2 method` -
1. compare(Object obj1, Object obj2) - Compulsory
2. equals() - Optional
* `NOT compulsory to override equals()` Since equals() is already inherited from Object class
```java
interface Comparator{
    int compare(Object obj1, Object obj2); // -ve if Obj1<Obj2, +ve if Obj1>Obj2, Zero if Obj1==Obj2
    equals(); // Optional to implement 
}

TreeSet t = new TreeSet(new MyComparator());
class MyComparator implements Comparator {
    public int compare(Object obj1, Object obj2) {
        }}
```
* If we are Not Passing Comparator Object as an Argument then Internally JVM will Call compareTo(), which is Meant for Default Natural Sorting Order (Ascending Order)
* `If we are Passing Comparator Object then JVM will Call compare() Instead of compareTo()`, which is Meant for Customized Sorting.

* Various Possible Implementations of compare():
```java
public int compare(Object obj1, Object obj2) {
    Integer I1 = (Integer)obj1;
    Integer I2 = (Integer)obj2;
    return I1.compareTo(I2); //[0, 5, 10, 15, 20] Ascending Order
    return -I1.compareTo(I2); //[20, 15, 10, 5.0] Descending Order
    return I2.compareTo(I1); //[20, 15, 10, 5.0]
    return -I2.compareTo(I1); //[0, 5, 10, 15, 20]
    return +1; //[10, 0, 15, 5, 20, 20] Insertion Order
    return -1; //[20, 20, 5, 15, 0, 10] Reverse of Insertion Order
    return 0; //[10] Only 1st Inserted Element Present And All Remaining Elements Treated as Duplicates
}
```
---

># Collections
* Class in java.util package
* `Defines Several Utility Methods for Collection Objects`.
* It consists exclusively of static methods that operate on collections or return collections.
* `Searching Points `:-
* Internally the Above Search Methods will Use Binary Search Algorithm.
* `Before performing Search` Operation `Compulsorily List should be Sorted`. Otherwise we will get Unpredictable Results.
* Successful Search Returns Index.
* Unsuccessful Search Returns Insertion Point. (Insertion Point is the Location where we can Insert the Target Element in the SortedList.)
* If the List is Sorted according to Comparator then at the Time of Search Operation, Also we should Pass the Same Comparator Object. Otherwise we will get Unpredictable Results.
* Note: For the List of n Elements | A B Z : 0 1 2 ??
    1. Successful Result Range: 0 To n-1
    2. Unsuccessful Result Range: -(n+1) To -1
    3. Total Result Range: -(n+1) To n-1
* Eg: For the List of 3 Elements | A B Z : -1 -2 -3
    1. Range of Successful Search: 0 To 2
    2. Range of Unsuccessful Search: -4 To -1
    3. Total Result Range: -4 To 2

# Methods of Collections
* public static void sort(List lst) - List should Not contain null Otherwise we will get NullPointerException.
* public static void sort(List lst, Comparator c)
* public static int binarySearch(List lst, T key) : returns index
* public static int binarySearch(List lst, T key, Comparator c) : returns index
* public static void reverse(List lst)
* public static void shuffleswap(List lst)
* public static void sort(List lst, int index1, int index2)
* public static void copy(List dest, List src)
* public static T min(Collection c)
* public static T min(Collection c, Comparator comp)
* public static T max(Collection c)
* public static T max(Collection c, Comparator comp)
* reverse() Vs reverseOrder():
* We can Use reverse() to Reverse Order of Elements of List.
* We can Use reverseOrder() to get Reversed Comparator.
* Comparator c1 = Collecctions.reverseOrder(Comparator c);
* c1 - descending, c - ascending
```java
Collections.sort(lst);
Collections.sort(lst,cmp);
```

># Arrays
* Class in java.util package
* `Defines Several Utility Methods for Array`
* It consists exclusively of static methods for manipulating array - for different primittive types

# Methods of Arrays
- Polymorphic versions of sort() :-
* public static void sort(primitive[] p); To Sort According to Natural Sorting Order.
* public static void sort(primitive[] a, int fromIndex, int toIndex)
* public static void sort(Object[] o); To Sort According to Natural Sorting Order.
* public static void sort(Object[] o, Comparator c); To Sort According to Customized Sorting Order
* public static void sort(int[] a)
* public static void sort(int[] a, int f\romIndex, int toIndex)
* public static void sort(long[] a)
* public static void sort(long[] a, int fromIndex, int toIndex)
- Search :-
* public static int binarySearch(primitive[] p, primitive target); - If the Primitive Array Sorted According to Natural Sorting Order then we have to Use this Method.
* public static int binarySearch(Object[] a, Object target); - If the Primitive Array Sorted According to Natural Sorting Order then we have to Use this Method.
* public static int binarySearch(Object[] a, Object target, Comparator c); - If the Object Array Sorted According to Comparator then we have to Use this Method.
* public static int binarySearch(long[] a, long key) : returns index
* public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) : returns index
* public static boolean equals(int[] a1, int[] a2) : if corresponding index ele are equal
* public static void fill(int[] a, int val)
* public static void fill(int[] a, int fromIndex, int toIndex2, int val)
* public static void copy(List dest, List src)
* public static T min(Collection c)
* public static T min(Collection c, Comparator comp)
* public static T max(Collection c)
* public static T max(Collection c, Comparator comp)
* `asList()` - Conversion of Array to List
```java
Collections.sort(lst);
Collections.sort(lst,cmp);
```

# Conversion of Array to List
* Arrays Class contains `asList()`
* this Method `won't Create an Independent List Object`, Just we are Viewing existing Array in List Form
* By using Array Reference if we Perform any Change Automatically that Change will be reflected to List Reference.
* Similarly by using List Reference if we Perform any Change Automatically that Change will be reflected to Array.
* By using List Reference if we are trying to Perform any Operation which `Varies the Size` then we will get Runtime Exception Saying `UnsuportedOperationException`.
* By using List Reference if we are trying to `Replace with Heterogeneous Objects` then we will get Runtime Exception Saying `ArrayStoreException`.
* `List lst = Arrays.asList(arr);`

---

># Concurrent Collections
* Already existing Thread Safe Collections :-
* Vector
* Hashtable
* synchronizedList()
* synchronizedSet()
* synchronizedMap()
* Problems with traditional collections :
1. Performance wise Not Upto the Mark(Because for Every Operation Even for Read Operation Also Total Collection will be loaded by Only One Thread at a Time and it Increases waiting Time of Threads)
2. While One Thread iterating Collection, the Other Threads are Not allowed to Modify Collection Object simultaneously if we are
   trying to Modify then we will get `ConcurrentModificationException`.
```java
while (itr.hasNext()) {
String s = (String)itr.next();
System.out.println(s);
al.add("D"); // RE: java.util.ConcurrentModificationException
}
```
* Hence these Traditional Collection Objects are Not Suitable for Scalable Multi Threaded Applications.
- Advantages of Thread Safe :
1. Concurrent Collections are `Always Thread Safe`.
2. When compared with Traditional Thread Safe Collections `Performance is More` because of different Locking Mechanism.
3. `While One Thread interacting` Collection the `Other Threads are allowed to Modify Collection` in Safe Manner.
* Hence Concurrent Collections `Never throw ConcurrentModificationException`.
* The Important Concurrent Classes are
* ConcurrentHashMap : Map -> ConcurrentMap -> ConcurrentHashMap
* CopyOnWriteArrayList
* CopyOnWriteArraySet

# ConcurrentMap
* Interface
* 3 methods :-
1. `Object putIfAbsent(Object Key, Object Value)` : To Add Entry to the Map if the specified Key is Not Already Available.
```java
ConcurrentHashMap m = new ConcurrentHashMap();
m.put(101, "Durga");
m.put(101, "Ravi");
System.out.println(m); //{101=Ravi}
m.putIfAbsent(101, "Siva");
System.out.println(m); //{101=Ravi}
```
* `put()` : If the Key is Already Available, Old Value will
  be replaced with New Value and Returns Old Value.
* `putIfAbsent()` : If the Key is Already Present then Entry won’t
  be added and Returns Old associated Value. If the Key is Not Available then Only Entry will be added.
2. `boolean remove(Object key, Object value)` : Removes the Entry if the Key associated with specified Value Only.
```java
ConcurrentHashMap m = new ConcurrentHashMap();
m.put(101, "Durga");
m.remove(101, "Ravi"); //Value Not Matched with Key So Not Removed
System.out.println(m); //{101=Durga}
m.remove(101, "Durga");
System.out.println(m); //{}
```
3. `boolean replace(Object key, Object oldValue, Object newValue)` : If the Key Value Matched then Replace with newValue
```java
ConcurrentHashMap m = new ConcurrentHashMap();
m.put(101, "Durga");
m.replace(101, "Ravi", "Siva");
System.out.println(m); //{101=Durga} // Value Not Matched with Key So Not Replaced
m.replace(101, "Durga", "Ravi");
System.out.println(m); //{101=Ravi}
```

# ConcurrentHashMap
* DS Used is Hashtable
* ConcurrentHashMap allows `Concurrent Read and Thread Safe Update Operations`.
* To Perform Read Operation Thread won’t require any Lock. But to Perform Update Operation Thread requires Lock but it is the Lock of Only a Particular Part of Map (`Bucket Level Lock`).
* Instead of Whole Map Concurrent Update achieved by _Internally dividing Map into Smaller Portion_ which is defined by _Concurrency Level_.
* Default Concurrency Level "16"
* Default Fill Ratio "0.75"
* That is ConcurrentHashMap Allows simultaneous Read Operation and _simultaneously 16 Write (Update) Operations_.
* `NULL insertion NOT Allowed for Both Keys and Values`.
* While One Thread iterating the Other Thread can Perform Update Operation and ConcurrentHashMap Never throw ConcurrentModificationException.
* `ConcurrentHashMap m = new ConcurrentHashMap();`
* `ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity);`
* `ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity, float fillRatio);`
* `ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity, float fillRatio, int concurrencyLevel);`
* `ConcurrentHashMap m = new ConcurrentHashMap(Map m);`
* If we Replace ConcurrentHashMap with HashMap then we will get
  ConcurrentModificationException.
* In the Case of ConcurrentHashMap iterator creates a Read Only Copy of Map Object and iterates over that Copy if any Changes to the Map after getting iterator it won’t be affected/reflected.
```java
ConcurrentHashMap m = new ConcurrentHashMap();
m.put(101, "A");
m.put(102, "B");
Iterator itr = m.keySet().iterator();
m.put(103, "C");
while (itr.hasNext()) {
Integer I1 = (Integer) itr.next();
System.out.println(I1+"............."+m.get(I1));
Thread.sleep(3000);
}
System.out.println(m);

// 102.............B ??
// 101.............A
// {103=C, 102=B, 101=A}
```

# CopyOnWriteArrayList
* Class of List Interface
* `Thread Safe Version of ArrayList`
* `Update Operation will be performed on cloned Copy` there is No Effect for the Threads which performs Read Operation
* It is `Costly to Use` because for every Update Operation a cloned Copy will be Created.
* CopyOnWriteArrayList is the Best Choice if Several Read Operations and Less Number of Write Operations are required to Perform.
* `Insertion Order Preserved`
* `Duplicate Objects Allowed`
* `Heterogeneous Objects Allowed`
* `null Insertion Possible`
* It implements Serializable, Clonable and RandomAccess Interfaces.
* While One Thread iterating CopyOnWriteArrayList, the Other Threads are allowed to Modify and we `won’t get ConcurrentModificationException`. That is `iterator is Fail Safe`.
* Iterator of ArrayList can Perform Remove Operation but `Iterator of CopyOnWriteArrayList can’t Perform Remove Operation`. Otherwise we will get RuntimeException Saying `UnsupportedOperationException`.
* CopyOnWriteArrayList l = new CopyOnWriteArrayList();
* CopyOnWriteArrayList l = new CopyOnWriteArrayList(Collection c);
* CopyOnWriteArrayList l = new CopyOnWriteArrayList(Object[] a);
- Methods -
* `boolean addIfAbsent(Object o)` : The Element will be Added if and Only if List doesn’t contain this Element
* `int addAllAbsent(Collection c)`: The Elements of Collection will be Added to the List if Elements are Absent and Returns Number of Elements Added.
* If we Replace CopyOnWriteArrayList with ArrayList then we will get ConcurrentModificationException.
* Every Update Operation will be performed on Separate Copy Hence After getting iterator if
  we are trying to Perform any Modification to the List it won’t be reflected to the iterator.
```java
import java.util.concurrent.CopyOnWriteArrayList;

CopyOnWriteArrayList l = new CopyOnWriteArrayList();
l.add("A");
l.add("B");
l.add("C");
Iterator<String> itr = l.iterator();
l.add("D");
while (itr.hasNext()) {
String s = itr.next();
System.out.println(s); 
} 

// A
// B
// C
```
* In the Above Program if we Replace CopyOnWriteArrayList with ArrayList then we will get RuntimeException: java.util.ConcurrentModificationException.

# CopyOnWriteArraySet
* Child Class of Set Interface
* `Thread Safe Version of ArrayList`
* Internally implemented by CopyOnWriteArrayList.
* `Insertion Order Preserved`.
* `Duplicate Objects NOT allowed`.
* Multiple Threads can Able to Perform Read Operation simultaneously but for `Every Update Operation a Separate cloned Copy` will be Created.
* As for Every `Update Operation` a Separate cloned Copy will be Created which is `Costly`. Hence if `Multiple Update Operation are required then it is Not recommended` to Use CopyOnWriteArraySet.
* While One Thread iterating Set the Other Threads are allowed to Modify Set and we `won’t get ConcurrentModificationException`.
* Iterator of CopyOnWriteArraySet can Perform Only Read Operation and `won’t Perform Remove Operation`. Otherwise we will get RuntimeException: `UnsupportedOperatonException`.
- Methods :-
* `CopyOnWriteArraySet s = new CopyOnWriteArraySet ();` : Creates an Empty CopyOnWriteArraySet Object.
* `CopyOnWriteArraySet s = new CopyOnWriteArraySet(Collection c);` : Creates CopyOnWriteArraySet Object which is Equivalent to given Collection Object.
- Methods :
* Methods Present in Collection and Set Interfaces are the Only Methods Applicable for CopyOnWriteArraySet and there are No Special Methods.

# Fail Fast Iterator
* While One Thread iterating Collection if Other Thread trying to Perform any Structural Modification to the underlying Collection then immediately Iterator Fails by raising `ConcurrentModificationExcepion`. Such Type of Iterators are Called Fail Fast Iterators.
* : Internally Fail Fast Iterator will Use Some `Flag named with MOD` to Check underlying Collection is Modified OR Not while iterating.
```java
ArrayList l = new ArrayList();
l.add("A");
l.add("B");
Iterator itr = l.iterator();
while(itr.hasNext()) {
    String s = (String)itr.next();
    System.out.println(s); //A
    l.add("C"); // java.util.ConcurrentModificationException
}
```
* `ArrayList, Vector, HashMap, HashSet`

# Fail Safe Iterator
* While One Thread iterating if the Other Threads are allowed to Perform any Structural Changes to the underlying Collection, Such Type of Iterators are Called Fail Safe Iterators.
* Fail Safe Iterators `won’t raise ConcurrentModificationException` because Every Update Operation will be performed on `Separate cloned Copy`.
* Memory Problem
```java
CopyOnWriteArraySet l = new CopyOnWriteArraySet();
l.add("A");
l.add("B");
Iterator itr = l.iterator();
while(itr.hasNext()) {
    String s = (String)itr.next();
    System.out.println(s); //A
    l.add("C");
}
```
* `ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet`

# EnumSet

# Queue


># Generics
- Problems :-
1. Type Safety
* We `can't provide guarantee for the type of elements` present inside collections that is collections are not safe to use with respect to type.
* By mistake if we are trying to add any other type we won't get any compile time error but the program may fail at runtime - `ClassCastException`
2. Type Casting
* In the case of collection at the time of retrieval compulsory we should perform type casting otherwise we will get compile time error.
```java
String name = lst.get(0); // Compile Time Error - Incompatible  type
String name = (String)lst.get(0); // Type casting at retrieval time is mandatory
```
* Collections type casting is bigger headache

- Solution is Generics :-
1. To provide type safety to the collections.
2. To resolve type casting problems.
   ` ArrayList<String> lst = new ArrayList<String>();`
* Collections concept applicable only for objects , Hence for the parameter type we can use any class or interface name but `not primitive value(type)`.Otherwise we will get compile time error.

### No Polymorphism for parameter type
* Polymorphism concept is applicable only for the base type but `not for parameter type` [usage of parent reference to hold child object is called polymorphism].
```java
ArrayList<String> l1 = new ArrayList<String>(); // Correct
List<String> l2 = new ArrayList<String>(); // Correct
Collection<String> l3 = new ArrayList<String>(); // Correct

ArrayList<Object> l4= new ArrayList<String>(); // Compile Time Error : Imcompatible Types
```

# Generic Classes



># 20. JAVA 8 Features
# 1. Interface - Default method
* Implementation of methods is possible in interface now - `default` void show(){...}
* Problem of `multiple inheritannce` - `have to define ambiguity class` in child class, else error
* If you `override any method of Object class` - error - not allowed in interface

* Interface - `static method support` - public static abstract now
* direct now - I.show()

# 2. lambda expression
* Anonymous inner class : If work of class was just to implement a method of Functional interface
* Only for Functional interface
* The `function which doesn’t have the name,return type and access modifiers.`
* Lambda Expression also known as `anonymous functions or closures`.

# 3. forEach() - Consumer Interface
* accept()
* lst.forEach(i -> sout(i))

# 4. Stream API
* `lst.forEach(i->sout(i))` // Normal list
* `lst.stream().forEach(i->sout(i))` // Stream list
* `lst.parallelStream().forEach(i->sout(i))` // Parllel stream list - create threads as per core
* `use only once`
1. Intermediate methods - filter(), map()
2. Terminate Methods - findFirst(), forEach()
* public Stream filter(Predicate<T> t)
```java
lst.stream().filter(i->
        {sout("hi")
        return true;
        }).findFirst(); // hi (lst has 100 values);

lst.stream().filter(i->
        {sout("hi")
        return true;
        }).findFirst().orElse(0));
```

# 5. New Date Time API - Immutable
* `import java.time.LocalDate` - same for Time
```java
LocalDate d = LocalDate.now() // 2023-03-31
LocalDate d = LocalDate.of(2023, Month.MARCH, 31) // 2023-03-31 - gives errpor for leap yr
LocalDate d = LocalDate.now(ZoneId.of("Asia/Kuwait")) // 2023-03-31
Instant i = Instant.now() // // 2023-03-31T11:41:14.81Z : machine readable time
LocalDateTime dt = LocalDateTime.now() // 2023-03-31T11:41:14.800
.isBefore()
```

# 6. Optional
* `Avoids Null Pointer Exception` if(str==null){str.length()}
* import java.util.Optional
* public final class Optional<T> extends Object
* Optional class - A container object may or may not contain a non-null value.
* Create Optional :
1. of()
2. ofNullable()
3. empty()
* isPresent() - true if value is present
* get() - returns value else error
* orElse() - gives value if present, or default value

```java
String[] str = new String[5];
s[0] = "ram";
s[1] = "sam"; // s[2,3,5] = null

// Problem
sout(s[2].toUpperCase()) // Null Pointer Exception

// Solution
Optional<String> o = Optional.ofNullable(s[2]);

if(o.isPresent()){
   sout(o.get().toUpperCase())     
}else{
   sout("Value not exist");
}
```

# 7. Method Reference
* `Passing method to method`
* Method as parameter in Method - Call by method
* `lst.forEach(System.out::println)`
* Create getters setters as optional
* `functional Interface method can be mapped to our specified method` by using :: (double colon)operator. This is called method reference.
* Our specified method can be either static method or instance method.
* FunctionalInterface method and our specified method `should have same argument types` ,except this the remaining things like returntype,methodname,modifiersetc are not required to match.
```java
List<String> lst = Arrays.asList("A", "B", "C", "D")
lst.forEach(str -> System.out.println(str)) // [A,B,C,D]
~
lst.forEach(System.out::println) // Call by Method
```

# Constructor References
* We can use :: ( double colon )operator to refer constructors also
* Syntax: `classname :: new`
```java
Interf f = sample :: new; 
functional interface f referring sample class constructor 
```

# 8. Predicates and Functions
# Predicate
* A predicate is a `function with a single argument and returns boolean value`.
* `To implement conditional checks`, we should go for predicate
* Predicate interface present in java.util.function package.
* It’s a `functional interface` and it contains o`nly one method i.e., test()`
* As predicate is a functional interface and hence it can refers lambda expression.
* Predicate can take one type Parameter which represents Input argument type. `Predicate<T>`
```java
interface Predicate<T> { 
 public boolean test(T t); 
} 

Predicate<String> p = s -> (s.length() > 3); 

predicate<Integer> p = I -> (i>10); 
    System.out.println(p.test(100)); 
    System.out.println(p.test(7)); 
```
### Predicate Joining
* and(), or(), negate()
```java
int[] x = {0, 5, 10, 15, 20, 25, 30};
predicate<integer> p1 = i->i>10; 
predicate<integer> p2=i -> i%2==0;

public static void m1(predicate<integer>p, int[] x) {
    for(int x1:x) { 
        if(p.test(x1)) 
            System.out.println(x1); 
    } } 

System.out.println("The Numbers Greater Than 10:"); 
m1(p1, x); 
System.out.println("The Even Numbers Are:"); 
m1(p2, x); 
System.out.println("The Numbers Not Greater Than 10:"); 
m1(p1.negate(), x); 
System.out.println("The Numbers Greater Than 10 And Even Are:"); 
m1(p1.and(p2), x); 
System.out.println("The Numbers Greater Than 10 OR Even:" ); 
m1(p1.or(p2), x); 
```
* Predicate is a boolean valued function and(), or(), negate() are default methods present inside Predicate interface.

# Function
* Functions are exactly `same as predicates` except that functions can return any type of result but function should(can)`return only one value and that value can be any type` as per our requirement.
* To `perform certain operation And to return some result` we Should go for function.
* Function interface present in java.util.function package.
* Functional interface contains only `one method i.e., apply()`
* As predicate is a functional interface and hence it can refers lambda expression.
* Function can take 2 type Parameters.first one represent Input argument type and Second one represent return Type. `Function<T,R>`
```java
interface function(T,R) { 
 public R apply(T t); 
}

Function<String, Integer> f = s ->s.length(); 
    System.out.println(f.apply("Durga")); 
```

---

