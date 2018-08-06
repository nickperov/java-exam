package com.nickperov.study.ocp_1Z0_809.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nickperov.study.ocp_1Z0_809.tests.TestOuter.TestInner;

public class Test3 {
	
	public static void main(String[] args) {
		
		question13();
		
		question15();
		
		question17();
		
		question23();
		
		question24();
		
		question27();
		
		question47();
		
		question56();
		
		question74();
		
		question88();
		
		testAssert();
	}
	
	private static void question13() {
		class Course{
		    private String id;
		    private String category;

		    public Course(String id, String category){
		        this.id = id; this.category = category;
		    }
		    
		    public String toString(){
		        return id+" "+category;
		    }
		    
		    public String getCategory() {
		    	return category;
		    }
		}
		
		List<Course> s1 = Arrays.asList(
		        new Course("OCAJP", "Java"),
		        new Course("OCPJP", "Java"),
		        new Course("C#", "C#"),
		        new Course("OCEJPA", "Java")
		);
		
		s1.stream()
	       .collect(Collectors.groupingBy(c->c.getCategory()))
	       .forEach((m, n)->System.out.println(n));
	}
	
	private static void question15() {
		TestInner ti01 = new TestOuter.TestInner();
	}
	
	private static void question17() {
		Book b = new Encyclopedia();
		System.out.println(b.pages);
	}

	private static void question23() {
		
		//Predicate even = (Integer i)-> i%2==0; 
		Predicate<Integer> even1 = (Integer i)-> { 
			return i%2==0; 
		};
		Predicate<Integer> even2 = (Integer i)-> i%2==0;
		
		Predicate even3 = (Object i)-> ((Integer)i)%2==0;
		Predicate even4 = i -> ((Integer)i)%2==0;
	}
	
	private static void question24() {
		class MyStringComparator implements Comparator {
		    public int compare(Object o1, Object o2) {
		      int s1 = ((String) o1).length();
		      int s2 = ((String) o2).length();
		      return s1 - s2;
		    }
		}
		
		String[] sa = { "d", "bbb", "aaaa" };
		
		System.out.println("Search cc: " + Arrays.binarySearch(sa, "cc", new MyStringComparator()));
		
		System.out.println("Search c: " + Arrays.binarySearch(sa, "c", new MyStringComparator())); 
		
	}
	
	private static void question27() {
		Properties p = new Properties();
		p.setProperty("user", "USERNAME");
		p.setProperty("password", "PASSWORD");
		try {
			Connection c = DriverManager.getConnection("urls", p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}	
	}
	
	private static void question37() {
		class Book {
			private String name;
			private double price;
			public Book(String name, double price) {
				this.name = name;
				this.price = price;
			}
			
			public String getTitle() {
				return name;
			}
			
			public double getPrice() {
				return price;
			}
			
		}
		
		List<Book> books = Arrays.asList(
		        new Book("Atlas Shrugged", 10.0),
		        new Book("Freedom at Midnight", 5.0),
		        new Book("Gone with the wind", 5.0)
		);
		
		Map<String, Double> bookMap = books.stream().collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice()));
		BiConsumer<String, Double> func = (a, b) -> {
			if	(a.startsWith("A")) {
				System.out.println(b);
			}
		};
		
		bookMap.forEach(func);
	}
	
	private static void question47() {
		class Book{
		    String isbn;
		    String title;
		    public Book(String isbn, String title){
		        this.isbn = isbn;
		        this.title = title;
		    }
		    public int compareTo(Book b){
		        return this.isbn.compareTo(b.isbn);
		    }
		    
		    public String getTitle() {
		    	return title;
		    }
		}
		
		List<Book> books = Arrays.asList(new Book("152612873", "Java 24h"), new Book("832822", "Computer science"));
		Collections.sort(books, (b1, b2)->b1.getTitle().compareTo(b2.getTitle())); //1
		// Collections.sort((List)books); Exception
		// Collections.sort(books); not compiled
		
		Stream<Book> bs = books.stream();
		//bs.sorted().collect(Collectors.toList()); - exception at runtime
	}
	
	interface I1 {
		void m1() throws java.io.IOException;
	}
	interface I2 {
		void m1() throws java.sql.SQLException;
	}
	
	class A implements I1, I2 {
		@Override
		public void m1() { // no exception at all
		}
	}
	
	private static void question53() {
//		Map<Object, ? super ArrayList> m = new LinkedHashMap<Object, ArrayList>(); 
		Map<Object, ? super List> m = new LinkedHashMap<Object, List>();
	//	Map<Object, ?> m = new LinkedHashMap<Object, Object>();
		
		//m.put("2", new LinkedList());
		m.put("1", new ArrayList());    //1
		//m.put(1, new Object());    //2
		//m.put(1.0, "Hello");     //3
		System.out.println(m);
	}
	
	
    private static void question56(String records1, String records2) throws IOException {
        try (
                InputStream is = new FileInputStream(records1);
                OutputStream os = new FileOutputStream(records2);) {
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException | java.io.InvalidClassException e) {
            e.printStackTrace();
        }
    }
    
    private static void question56() {
    	class Book {
    		Book (String title, String genre, String author) {
    			this.title = title;
    			this.genre = genre;
    			this.author = author;
    		}
    		
    		private int id;
    		private String title;
    		private String genre;
    		private String author;
    		private double price;

    		String getGenre() {
    			return genre;
    		}
    		
    		String getAuthor() {
    			return author;
    		}
    	}
    	
    	List<Book> books = Arrays.asList(
    			new Book("There is a hippy on the highway", "Thriller", "James Hadley Chase"),
    			new Book("Coffin from Hongkong", "Thriller", "James Hadley Chase"),
    			new Book("The Client", "Thriller", "John Grisham"),
    			new Book("Gone with the wind", "Fiction", "Margaret Mitchell") );

    	Map<String, Map<String, List<Book>>> classified = null;
    	
    	Function<Book, String> getGenre = x->x.getGenre();
    	Function<Book, String> getAuthor = x->x.getAuthor();
    	Collector<Book, ?, Map<String, List<Book>>>  byAuthor = Collectors.groupingBy(getAuthor);
    	
    	Collector<Book, ?, List<String>> mappingByAuthor = Collectors.mapping(Book::getAuthor, Collectors.toList());
    	
    	Collector<Book, ?, Map<String, Map<String, List<Book>>>> byGenreAuthor = Collectors.groupingBy(getGenre, byAuthor);
    	
    	
    	 
    	classified = books.stream().collect(byGenreAuthor);
    	List<String> sList = books.stream().collect(mappingByAuthor);
    	System.out.println(sList);
    	//this is fine as well.         Book::getGenre, Collectors.groupingBy(Book::getAuthor) ));
    	
    }
    
    private static void question74() {
		class Book {
			private String name;
			private double price;
			public Book(String name, double price) {
				this.name = name;
				this.price = price;
			}
			
			public String getTitle() {
				return name;
			}
			
			public double getPrice() {
				return price;
			}
		}
    	
    	List<Book> books = Arrays.asList(
    	        new Book("Gone with the wind", 5.0),
    	        new Book("Gone with the wind", 10.0),
    	        new Book("Atlas Shrugged", 15.0)
    	);
    	
    	try {
	    	books.stream().collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice()))
	    	                        .forEach((a, b)->System.out.println(a+" "+b));
    	} catch(IllegalStateException e) {
    		System.out.println(e.getMessage()); // Duplicate key
    	}

    	books.stream().collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice(), (v1, v2) -> v1 + v2))
    		.forEach((a, b)->System.out.println(a+" "+b));	
    	
    }
    
    private static void question78() {
    	class PrintWriteTester {
    		void usePrintWriter(PrintWriter pw) throws IOException{
    	    	boolean bval = true;
    	    	pw.print(bval);
    	    }
    	}
    }
    
    private static void question88() {
    	LocalDateTime ldt = LocalDateTime.of(2017, 12, 02, 6, 0, 0);
    	ZoneId nyZone = ZoneId.of("America/New_York");
    	ZoneId laZone = ZoneId.of("America/Los_Angeles");
    	ZonedDateTime nyZdt = ldt.atZone(nyZone);
    	ZonedDateTime laZdt = ldt.atZone(laZone);
    	Duration d = Duration.between(nyZdt, laZdt);
    	System.out.println(d);
    }
    
    
    private static void testAssert() {
    	//assert false : "BlaBlaBla";
    }
    
}