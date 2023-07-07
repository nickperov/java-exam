package com.nickperov.study.ocp_1Z0_809.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Test1 {
	
	public static void main(String[] args) {
		question02();
		
		question07();
		
		question11();
		
		question13();
		
		question14();
		
		question24();
		
		question26();
		
		question36();
		
		question39();
		
		question42();
		
		question58();
		
		question72();
		
		question80();
	}
	
	private static void question02() {
		Map hm = new ConcurrentHashMap<>();
	/*	hm.put(null, "value"); 
		hm.put("key", null);*/ // NullPointerException
		
		hm = new HashMap<>();
		hm.put(null, "value");
		hm.put("key", null);
		
		List list = new CopyOnWriteArrayList<>();
		list.add(null);
	}
	
	private static void question07() {
		
		AtomicInteger ai = new AtomicInteger();
		ai.set(5);
		
		System.out.println("GetAndIncrement: " + ai.getAndIncrement());
		System.out.println("Get: " + ai.get());
		System.out.println("GetAndSet 10: " + ai.getAndSet(10));
		System.out.println("Get: " + ai.get());
	}
	
	private static void  question11() {
		class Account {
		    private String id;
		    public Account(String id){ this.id = id; }
		    //accessors not shown
		}
		
		class BankAccount extends Account {
			private double balance;
		    public BankAccount(String id, double balance){ super(id); this.balance = balance;}
		    
		    public double getBalance() {
		    	return balance;
		    }
		}
		
		Map<String, Account> myAccts = new HashMap<>();
		myAccts.put("111", new Account("111"));
		myAccts.put("222", new BankAccount("111", 200.0));
	        
		BiFunction<String, Account, Account> bif =
				(a1, a2)-> a2 instanceof BankAccount?new BankAccount(a1, 300.0):new Account(a1); //1
	        
		myAccts.computeIfPresent("222", bif);//2
		BankAccount ba = (BankAccount) myAccts.get("222");
		System.out.println(ba.getBalance());
	}
	
	
	
	private static void  question13() {
		
		// wait - notify examples
		
		class ThreadA extends Thread {
		    int total;
		    @Override
		    public void run() {
		        synchronized(this){
		            for (int i=0; i<100 ; i++) {
		                total += i;
		            }
		            notify();
		        }
		    }
		}
		
        ThreadA b = new ThreadA();
        b.start();
 
        synchronized(b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
       }
	}
	
	static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };
	
	private static void  question14() {
		
		// Stream without terminal operation
		// peek would not be called if stream does not have terminal operation
		
		class Movie {
			private Genre genre;
			private String name;
		    private char rating = 'R';
		    Movie(String name, Genre genre, char rating) {
		    	this.name = name; this.genre = genre; this.rating = rating;
		    }
		    //accessors not shown
		    
		    public char getRating() {
		    	return rating;
		    }
		    
		    public String getName() {
		    	return name;
		    }
		}
		
        List<Movie> movies = Arrays.asList(
                new Movie("Titanic", Genre.DRAMA, 'U'),
                new Movie("Psycho", Genre.THRILLER, 'U'),
                new Movie("Oldboy", Genre.THRILLER, 'R'),
                new Movie("Shining", Genre.HORROR, 'U'));
        
        movies.stream()
        	.filter(mov->mov.getRating()=='R')
        	.peek(mov->System.out.println(mov.getName()))
        	.map(mov->mov.getName())/*.collect(Collectors.toList())*/;
	}
	
	private static void  question24() {
		class MyProcessor {
		    Integer value;
		    public MyProcessor(Integer value) {
		        this.value = value;
		    }
		    public void process() {
		        System.out.println(value+" ");
		    }
		}
		
		List<Integer> ls = Arrays.asList(1, 2, 3);
		ls.stream().map(MyProcessor::new).forEach(MyProcessor::process);
	}
	
	private static void  question26() {
		
		// Queue - Deque - Stack
		Deque<Integer> d = new ArrayDeque<>();
		d.add(1);
		d.push(2);
		d.pop();
		d.offerFirst(3);
		d.remove();
		System.out.println(d);
	}
	
	private static void question36() {
		// Try HashMap without has code
		class Book {
		    private String isbn;
		    public Book(String isbn){ this.isbn = isbn; }
		    
		    public boolean equals(Object o){
		        return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
		    }
		    // ... setters and getters
		    
		    public int hashCode() {
		    	return 111; //Any hashcode
		    };
		}
		
		class BookStore {
			Map<Book, Integer> map = new HashMap<Book, Integer>();
			
		    public BookStore(){
		        Book b = new Book("A111");
		        map.put(b, 10);
		        b = new Book("B222");
		        map.put(b, 5);
		    }
		    
		    Integer getNumberOfCopies(Book b){
		        return map.get(b);
		    }
		}
		
		BookStore bs = new BookStore();
        Book b = new Book("A111");
        System.out.println(bs.getNumberOfCopies(b));  //1
	}
	
	private static void question39() {
		Path p1 = Paths.get("c:\\..\\temp\\test.txt");
		System.out.println(p1.normalize().toUri());
	}
	
	private static void question42() {
		
		// Input - output streams 
		String records1 = "c:\\temp\\test1.txt";
		String records2 = "c:\\temp\\test2.txt";
		
        try {
            InputStream is = new FileInputStream(records1);
            OutputStream os = new FileOutputStream(records2);
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                System.out.println("Read and written bytes " + bytesRead);
            }
        } catch (IOException | /*FileNotFoundException | */IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
	}
	
	private static void question58() {
		class Names{
			private List<String> list;
		    public List<String> getList() {
		        return list;
		    }
		    public void setList(List<String> list) {
		        this.list = list;
		    }
		    public void printNames(){
		        System.out.println(getList());
		    }
		}
		
	    List<String> namesList = Arrays.asList(
	    		"Bob Hope",
	    		"Bob Dole",
	    		"Bob Brown"
	    		);

	    Names n = new Names();
	    n.setList(namesList.stream().collect(Collectors.toList()));
	    // n.getList().forEach(Names::printNames);
	}
	
	private static void question72() {
		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Duration.ofDays(1));
		System.out.println(date);
		
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Period.ofDays(1));
		System.out.println(date);
	}
	
	private static void question80() {
		Period p = Period.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
		System.out.println(p);
		// Duration d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1)); exception 
		Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 1, 0, 0)); // time component
		System.out.println(d);
	}
	
}