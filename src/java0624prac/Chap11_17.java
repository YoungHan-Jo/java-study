package java0624prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Chap11_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Object> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		
		Queue<Object> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!st.empty())
			System.out.println(st.pop());
		
		System.out.println("===================");
		
		while(!q.isEmpty())
			System.out.println(q.poll());
		
		
		
		
		
	} // main

}
