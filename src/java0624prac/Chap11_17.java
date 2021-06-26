package java0624prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Chap11_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Object> st = new Stack<>();
		Queue<Object> q = new LinkedList<>();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("== stack ==");
		while(!st.empty())
			System.out.println(st.pop());
		
		System.out.println("== queue ==");
		while(!q.isEmpty())
			System.out.println(q.poll());
		
		
		
		
		
		
	} // main

}
