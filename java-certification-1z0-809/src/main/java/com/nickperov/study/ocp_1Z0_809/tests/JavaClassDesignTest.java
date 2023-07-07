package com.nickperov.study.ocp_1Z0_809.tests;
import java.util.HashMap;
import java.util.Map;

public class JavaClassDesignTest {
	
	public static void main(String[] args) {
		question08();
		
		question14();
		
		question15();
	}
	

	
	private static void question08() {
		class A {
			 private int i;
			 public void modifyOther(A a1) {
				 a1.i = 20; // valid access of private field i 
			 }
		 }
	}
	
	private static void question14() {
		class Book {
		    private String title, isbn;
		    public boolean equals(Object o){        
		       return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
		    }
		    
		    public void setIsbn(String isbn) {
		    	this.isbn = isbn;
		    }
		    // ... setters and getters for title and isbn
		}

		class BookStore {
		    Map<Book, Integer> map = new HashMap<Book, Integer>();    
		    int getNumberOfCopies(Book b){
		    	 return map.get(b); // NullPointer
		    	/*Integer integer = map.get(b);
		    	return integer != null ? integer : 0;*/ 
		    }
		    public void addBook(Book b, int numberofcopies){
		    map.put(b, numberofcopies);
		    }
		    // ... other useful methods.
		}
		
		BookStore bs = new BookStore();
		
		Book b = new Book(); b.setIsbn("111");
	    bs.addBook(b, 10);
	    System.out.println(bs.getNumberOfCopies(b));
	    
	    b = new Book(); b.setIsbn("111");
	    System.out.println(bs.getNumberOfCopies(b));
	}
	
	
	
	private static void question15() {
		/*class A
		{
		   A() {  print();   }
		   private void print() { System.out.println("A"); }
		}
		class B extends A
		{
		   int i =   Math.round(3.5f);
		   public void test(String[] args)
		   {
		      A a = new B();
		      a.print();
		   }
		   void print() { System.out.println(i); }
		}*/
	}
}