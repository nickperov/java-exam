package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExmpls {
	
	public static void main(String[] args) {
		
		concurCollectionExmpls();

		blockingQueueExmpl();
		
		blockingDequeExmpl();
		
		copyOnWriteCollectionExmpls();
	}
	
	private static void blockingQueueExmpl() {
		System.out.println("============ Blocking queue example ============");
		
		try {
			BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
			
			blockingQueue.offer(35433, 100, TimeUnit.MILLISECONDS);
			
			System.out.println(blockingQueue.poll(100, TimeUnit.MILLISECONDS));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void blockingDequeExmpl() {
		System.out.println("============ Blocking deque example ============");
		
		try {
			BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
			
			blockingDeque.offerFirst(736453, 100, TimeUnit.MILLISECONDS);
			blockingDeque.offerLast(999, 100, TimeUnit.MILLISECONDS);
			blockingDeque.offer(112342, 100, TimeUnit.MILLISECONDS);
			
			System.out.println(blockingDeque.poll(100, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollLast(100, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollFirst(100, TimeUnit.MILLISECONDS));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void copyOnWriteCollectionExmpls() {
		System.out.println("============ Copy on write collections example ============");
		
		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(3,4,5679,896,45,8,22));
		
		for (Integer item : list) {
			System.out.println(item + " ");
			list.add(9);
		}
		System.out.println();
		System.out.println("Size; " + list.size());
	}
	
	private static void concurCollectionExmpls() {
		System.out.println("============ Concurrent collections example ============");
		
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put(" zebra", 52);
		map.put(" elephant", 10);
		System.out.println(map.get(" elephant"));
		
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek());
		System.out.println(deque.pop());
	}

}
