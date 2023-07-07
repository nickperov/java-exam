package com.nickperov.oca_1Z0_803.ch8_polymorphism;

public class StudExamPolymorphism {

    public static void main(String[] args) {
        
    	testPolymorphism001();
       
    }
    
    private static void testPolymorphism001() {
    	Flyer f = new Eagle();
        Eagle e = new Eagle();
        Bat b = new Bat();
        Bat vb = new VampireBat();
        Bat sb = new SmallBat();
        @SuppressWarnings("unused")
		SmallBat smb = new SmallBat();
        if(f instanceof Bird) System.out.println("f is a Bird");
        if(e instanceof Flyer) System.out.println("e is a Flyer");
        if(b instanceof Flyer) System.out.println("b is a Flyer"); // b (Bat) could be instance of Bat sub class (which could implement Flyer interface)
        if(vb instanceof Flyer) System.out.println("vb is a Flyer");
        
        // Wrong because vb is Bat is not a superclass of Bird, could not be instance of Bird
        // if(vb instanceof Bird) System.out.println("vb is a Flyer");
        
        if(sb instanceof Flyer) System.out.println("sb is a Flyer");
        // Wrong because smb is instance of SmallBat - final class could not be a superclass
        //if(smb instanceof Flyer) System.out.println("sb is a Flyer"); 
        
    }
}


interface Flyer{ }
class Bird implements Flyer { }
class Eagle extends Bird { }
class Bat { }
final class SmallBat extends Bat {
}
class  VampireBat extends Bat implements Flyer {
}