package com.nickperov.oca_1Z0_803.tests;

public class Test4 {

	public static void main(String[] args) throws Exception {
   //     Data d = new Data(1, 1);
        //add code here
        
   //     Test4 t4 = new Test4(); // Default constructor
   //     testSB();
        
        Integer a = 4; new Test4().probe(a); //5
        int b = 4; new Test4().probe(b); //6
        
   //     System.out.println(Sub.ID);
  //      Sub.doSmth();
        
        //==============================
        
        Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat bat = new Bat();
        
        if(f instanceof Flyer) System.out.println("f is a Flyer");
        if(e instanceof Bird) System.out.println("e is a Bird");
       // if(bat instanceof Bird) System.out.println("b is a Bird"); //incompatible types
        
    }
	
    void probe(int... x) { System.out.println("In ..."); }  //1
     
    void probe(Integer x) { System.out.println("In Integer"); } //2
    
    void probe(long x) { System.out.println("In long"); } //3 
    
    void probe(Long x) { System.out.println("In LONG"); } //4
    
    
  
    
	
	public static void testSB() {
		StringBuilder sb = new StringBuilder("12345678");
		sb.setLength(5);
		sb.setLength(10);
		sb.append("A");
		
		System.out.println(sb.length());
		System.out.println(sb);
	}

	void crazyLoop(){
		int c = 0;
		JACK: while (c < 8){
			JILL: System.out.println(c);
			if (c > 3) break JACK; else c++;
		}
	}
	
	public void Test4(long l) { // method
		
	}
	
}

class Super { 
	static String ID = "QBANK";
	static void doSmth() {
		
	}
}

class Sub extends Super{
   static { System.out.print("In Sub"); }
   
   static void doSmth() {
		
	}
}

class Data {
    private int x = 0, y = 0;
    public Data(int x, int y){
        this.x = x; this.y = y;
    }
}

interface Flyer{ }
class Bird implements Flyer { }
class Eagle extends Bird { }
class Bat { }