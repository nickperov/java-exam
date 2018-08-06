package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamMethodOverriding002 {
	public static void main(String args[]){ start(new OrderManager()); }
	static void start(CorbaComponent cc){ cc.print(); }
}


class CorbaComponent{
    String ior;
    CorbaComponent(){ startUp("IOR"); }
    void startUp(String s){ ior  =  s; }
    void print(){ System.out.println(ior); }
}

class OrderManager extends CorbaComponent{
   OrderManager(){  }
   void startUp(String s){  ior = getIORFromURL(s);   }
   String getIORFromURL(String s){  return "URL://"+s; }
}