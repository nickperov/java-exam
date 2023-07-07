package com.nickperov.study.ocp_1Z0_809.tests;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {
	
	public static void main(String[] args) {
		question07();
		
		question34();
		
		question35();
		
		question38();
		
		question39();
		
		question40();
		
		question51();
		
		question58();
		
		question60();
		
		question84();
	}
	
	private static void question07() {
		
		// Work with parallel stream
		
		AtomicInteger ai = new AtomicInteger();
		Stream<String> stream = Stream.of("old", "king", "cole", "was", "a", "merry", "old", "soul").parallel();
		stream.filter( e->{
			ai.incrementAndGet();
			return e.contains("o");
		}).allMatch(x->x.indexOf("o")>0);
	        
		System.out.println("AI = "+ai);

	}
	
	private static void question34() {
		class Outer {
			private void Outer() {} // this is OK, it is not a constructor
			
			class Inner {
				
			}
		}
	}
	
	private static void question35() {  
		class MyRunnable implements Runnable {
			MyRunnable(String name) {
				new Thread(this, name).start(); // Start new Thread "MyRunnable" --> print MyRunnable
			}
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}
		
		Thread.currentThread().setName("MainThread");
		MyRunnable mr = new MyRunnable("MyRunnable");
		mr.run(); // Run in the same thread --> print MainThread
	}
	
	static class TestClass {
		public <E extends CharSequence> Collection<E> getWordsStartingWith(Collection<E> input, char ch) {
			
			Collection<E> returnValue = new ArrayList<E>();
			for(E e : input) {
				if (e.charAt(0) == ch)
					returnValue.add(e);
				}
			return returnValue;
		}
	}
	
	private static void question38() {
		// Check test class method
		List<String> a = new ArrayList<String>();
		a.add("apple");
		a.add("cherry");
		Set<StringBuffer> b = new HashSet<StringBuffer>();
		b.add(new StringBuffer("pineapple"));
		
		TestClass tc = new TestClass();
		
		Collection<String> ac = tc.getWordsStartingWith(a, 'a');
		Collection<StringBuffer> bc = tc.getWordsStartingWith(b, 'b');
		
		Set<CharSequence> cs = new HashSet<>();

		Collection<? super CharSequence> bcsc = tc.getWordsStartingWith(cs, 'b');
		
		bcsc.add(new String());
		
		Collection<? extends CharSequence> csss = tc.getWordsStartingWith(cs, 'b');
		
		for (CharSequence chSeq : csss) {
			
		}
	}
	
	private static void question39() {
		class Book{
		    String isbn;
		    String title;
		    public Book(String isbn, String title){
		        this.isbn = isbn;
		        this.title = title;
		    }
		    
		    public String getIsbn() {
		    	return isbn;
		    }
		    //accessors not shown

		   //assume appropriate implementations of equals and hashCode based on isbn property
		}
		
		List<Book> books = Arrays.asList(new Book("132254523", "Book1"), new Book("52423912", "Book2"));
		try {
			books.stream().sorted().forEach(b->System.out.println(b.getIsbn())); //1
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void question40() {
		Object v1 = IntStream.rangeClosed(10, 15)
		        .boxed()
		        .filter(x->x>12)
		        .parallel()
		        .findAny();

		Object v2 = IntStream.rangeClosed(10, 15)
		        .boxed()
		        .filter(x->x>12)
		        .sequential()
		        .findAny();

		System.out.println(v1+":"+v2);
	}
	
	static AtomicInteger ai = new AtomicInteger(0);
	
	private static void question45() {
		ai.incrementAndGet();
		ai.getAndSet(5);
		ai.addAndGet(10);
	}
	
	private static void question51() {
		class Item {
			private String name;
			private String category;
			private double price;
	        
	        public Item(String name, String category, double price){
	            this.name = name;
	            this.category = category;
	            this.price = price;
	        }
	        
	        private double getPrice() {
	        	return price;
	        }
	        
	        private String getCategory() {
	        	return category;
	        }
		}
		
		List<Item> items = Arrays.asList(
		        new Item("Pen", "Stationery", 3.0),
		        new Item("Pencil", "Stationery", 2.0),
		        new Item("Eraser", "Stationery", 1.0),
		        new Item("Milk", "Food", 2.0),
		        new Item("Eggs", "Food", 3.0)
		);
		
		ToDoubleFunction<Item> priceF = Item::getPrice;
		
		items.stream()
			.collect(Collectors.groupingBy(Item::getCategory)) //2
			.forEach((a, b)-> {
				double av = b.stream().collect(Collectors.averagingDouble(priceF)); //3
				System.out.println(a+" : "+av);
			});
	}
	
	private static void question58() {
		class A implements Serializable {
			
			private void readObject(java.io.ObjectInputStream stream) {
				
			}
			
			
		}
	}
	
	private static void question60() {
		class JerkyThread extends Thread
		{
		    private int data = 0;
		    private boolean done = false;
		    public JerkyThread(int x){
		        super(); this.data = x;
		    }
		    public synchronized int getData(){
		        return data;   
		    }    
		    public synchronized boolean isDone(){ return done; }
		    
		    public synchronized void run() {
		    	
		    	//synchronized(JerkyThread.class) {
			    	System.out.println("Start run " + data);
			    	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        data += data;
			        done = true;
			        
			        System.out.println("Finish run " + data);
		    //	}
		    }
		    
		}
		
		JerkyThread[] jta = new JerkyThread[3];
        for(int i=0; i<3; i++) {
            jta[i] = new JerkyThread(i); jta[i].start();
        }
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(JerkyThread jt : jta) {
            if(jt.isDone()) System.out.println(jt.getData());
        }
	}
	
	interface Carnivore{
	    default int calories(List<String> food){
	        return food.size()*100;
	    }
	    int eat(List<String> foods);
	}
	
	public static int size(List<String> names){
        return names.size()*2;
    }
    public static void process(List<String> names, Carnivore c){
        c.eat(names);
    }
	
	private static void question84() {
		class Tiger implements Carnivore{
		    public int eat(List<String> foods){
		        System.out.println("Eating "+foods);
		        return foods.size()*200;
		    }
		}
		
		List<String> fnames = Arrays.asList("a", "b", "c");
        Tiger t = new Tiger();
       
        process(fnames, t::eat);
        process(fnames, t::calories);
        process(fnames, Test2::size);
	}
}