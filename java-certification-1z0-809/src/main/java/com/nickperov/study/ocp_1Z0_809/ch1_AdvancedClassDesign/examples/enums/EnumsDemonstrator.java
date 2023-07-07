package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.enums;

public class EnumsDemonstrator {
	
	public enum Season {
		WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
		
		private String expectedVisitors;
		
		private Season(String expectedVisitors) {
			this.expectedVisitors = expectedVisitors;
		}
		
		public void printExpectedVisitors() {
			System.out.println(expectedVisitors);
		}
	}
	
	public enum Season2 {
		WINTER {
			public void printHours() {
				System.out.println("9am - 3 pm");
			}
		},
		SPRING {
			public void printHours() {
				System.out.println("9am - 5 pm");
			}
		},
		SUMMER {
			public void printHours() {
				System.out.println("9am - 7 pm");
			}
		},
		FALL {
			public void printHours() {
				System.out.println("9am - 5 pm");
			}
		};
		
		public abstract void printHours();
	}
	
	public enum Season3 {
		WINTER {
			public void printHours() {
				System.out.println("9am - 3 pm");
			}
		},
		SPRING {
			public void printHours() {
				System.out.println("9am - 5 pm");
			}
		},SUMMER,FALL;
		
		public void printHours() {
			System.out.println("Default hours");
		}
	}
	
	public enum OnlyOne {
		ONCE(true);
		
		private OnlyOne(boolean b) {
			System.out.println("Constructing");
		}
	}
	
	public static void main(String[] args) {
		
		for (Season s : Season.values()) {
			System.out.println(s + " : " + s.ordinal());
		}
		
		Season.SUMMER.printExpectedVisitors();
		
		@SuppressWarnings("unused")
		OnlyOne firstCall = OnlyOne.ONCE; // First prints "Constructing"
		@SuppressWarnings("unused")
		OnlyOne seconCall = OnlyOne.ONCE; // Second call doesn't print anything
		
	}
}