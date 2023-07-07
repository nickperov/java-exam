package com.nickperov.study.ocp_1Z0_809.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test5 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		question15();
		question17();
		question29();
		question34();
		question44();
		question50();
		question69();
	//	testClassInit();
	}

	interface Base {
		static int f = 5;
		static void makeSomeStuff() {
			
		}
	}
	
	interface Classic extends Base {
	    int version = 1;
	    public void read() ;
	}

	static class MediaReader implements Classic{
	    int version = 2;
	    public void read() {
	        //Insert code here
	    }
	}
	
	private static void question15() {
		MediaReader mr = new MediaReader();
		mr.read();
		
		System.out.println(((Classic)mr).version);
		System.out.println(((Base)mr).f);
		Base.makeSomeStuff();
	}
	

	
	private static void question17() throws IOException, ClassNotFoundException {
		Boo boo = new Boo();
		boo.si++;
		System.out.println(boo.ti+" "+boo.si);
		FileOutputStream fos = new FileOutputStream("c:\\1\\boo.ser");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(boo);
		os.close();
	        
		FileInputStream fis = new FileInputStream("c:\\1\\boo.ser");
		ObjectInputStream is = new ObjectInputStream(fis);
		boo = (Boo) is.readObject();
		is.close();            
		System.out.println(boo.ti+" "+boo.si);
	}
	
	static class Person {
	    private String name;
	    public Person(String name) {  this.name = name;    }
	    public String getName() { return name;  }
	    public void setName(String name) { this.name = name; }

	    public String toString() { return name; }
	}

	static class Helper {
	    public void helpPeople(Queue people, Queue helped) {
	        do {
	            Person p = (Person) people.poll();
	            System.out.println("Helped : " + p + " ");
	            helped.offer(p.getName());
	        } while (!people.isEmpty());
	    }
	}
	
	private static void question29() {
		Queue<Person> q = new LinkedList<Person>();
        q.offer(new Person("Pope"));
        q.offer(new Person("John"));
        Queue<Person> helpedQ = new LinkedList<Person>();
        Helper h = new Helper();
        h.helpPeople(q, helpedQ);
	}
	
	private static void question34() {
		Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
		Path p2 = Paths.get("c:\\personal\\index.html");
		Path p21 = Paths.get("c:\\personal\\..\\..\\.\\.\\index.html");
		Path p3 = p1.relativize(p2);
		Path p4 = p1.normalize().relativize(p2);
		Path p5 = p1.relativize(p21);
		
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p21.normalize());
		
	}
	
	private static void question44() {
		List<String> strs = Arrays.asList("803", "808", "809");
		String finalStr = strs.stream().collect(Collectors.joining("<--->"));
		
		System.out.println(finalStr);
	}
	
	private static void question50() {
		Path p1 = Paths.get("\\photos\\vacation\\2");
		Path p2 = Paths.get("\\yellowstone\\1");
		System.out.println(p1.resolve(p2)+"  " +p1.relativize(p2));
	}
	
	private static void question69() {
		
		class Resource {
			private String data = "DATA";
			String getData(){
				return data;
			}

			void setData(String data){
				this.data = data == null ? "" : data;
			}
			
			boolean equals(Resource r){
				return (r != null && r.getData().equals(this.getData()));
			}
		}
		
		boolean checkEq = new Resource().equals(new Resource());
		System.out.println(checkEq);
	}
	
	private static void testClassInit() {
		StaticTest st1;                    //1
		System.out.println(" 1 ");
		st1 = new StaticTest();            //2
		System.out.println(" 2 ");
		StaticTest st2 = new StaticTest(); //3
	}
	
}
class StaticTest
{
   static
   {
      System.out.println("In static");
   }
   {
      System.out.println("In non - static");
   }
}

class Boo implements Serializable {
    transient int ti = 10;
    static int si = 20;
}