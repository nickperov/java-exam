package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationExmpls {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		serializeResoreAnimals();
		
		serializeRestoreChildClass();

	}
	
	private static void serializeResoreAnimals() throws IOException, ClassNotFoundException {
		System.out.println("====== Animals list serialization/desiarialization =======");
		
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Tommy tiger", 2, 'T'));
		animals.add(new Animal("Petter penguin", 3, 'P'));
		
		File dataFile = new File("src/resources/animal.data");
		
		createAnimalFile(animals, dataFile);
		
		System.out.println(getAnimals(dataFile));
	}
	
	private static void serializeRestoreChildClass() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("====== Serialization/desiarialization of class chain A - B =======");
		
		File dataFile = new File("src/resources/B.data");
		
		B origB = new B();
		
		// Serialize class
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			out.writeObject(origB);
			out.flush();
		}
		
		B restoredB = null;
		
		// Restore class
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			try {
				Object o = in.readObject();
				if (o instanceof B)
					restoredB = (B)o;
			} catch (EOFException e) {
				
			}
		}
		
		System.out.print(origB + " ---> " + restoredB);
	}
	
	private static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Animal)
					animals.add((Animal)object);
			}
		} catch (EOFException e) {
			// File end reached
		}
		return animals;
	}
	
	private static void createAnimalFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for (Animal animal : animals)
				out.writeObject(animal);
		}
	}
	
	/**
	 * Non-serializable class
	 */
	public static class A {
		// Must contains default accessible constructor
		
		// No private constructor
		/*private A() {
			
		}*/
		
	}
	
	public static class B extends A implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		public B() {
			
		}
		
	}
	
	public static class Animal implements Serializable {
		private static final long serialVersionUID = 1l;
		
		public Animal(String name, int age, char type) {
			this.name = name;
			this.age = age;
			this.type = type;
		}
		
		public Animal() {
		}

		private String name;
		private int age;
		private char type;
		
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
		public char getType() {
			return type;
		}
		
		@Override
		public String toString() {
			return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
		}
	}
}
