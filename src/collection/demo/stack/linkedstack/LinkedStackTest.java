package collection.demo.stack.linkedstack;

import collection.demo.stack.Stack;

import java.util.Scanner;
public class LinkedStackTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack stack=new LinkedStack();
		Scanner in = new Scanner(System.in);
		int temp;
		for(int i=0;i<10;i++)
		{
			System.out.println("请输入第"+(i+1)+"个整数：");
			temp = in.nextInt();
			stack.push(temp);
		}

		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}

	}

}