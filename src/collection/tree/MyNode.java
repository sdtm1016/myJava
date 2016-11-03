package collection.tree;

import java.util.Arrays;

public class MyNode {
	private MyNode left;
	private MyNode right;
	private int value;
	//private int num;

	public MyNode(int value){
		this.value = value;
	}
	public void add(int value){

		if(value > this.value)
		{
			if(right != null)
				right.add(value);
			else
			{
				MyNode myNode = new MyNode(value);
				right = myNode;
			}
		}
		else{
			if(left != null)
				left.add(value);
			else
			{
				MyNode myNode = new MyNode(value);
				left = myNode;
			}
		}
	}

	public boolean find(int value){
		if(value == this.value) return true;
		else if(value > this.value){
			if(right == null) return false;
			else return right.find(value);
		}else{
			if(left == null) return false;
			else return left.find(value);
		}

	}

	public void display(){
		System.out.println(value);
		if(left != null) left.display();
		if(right != null) right.display();

	}

	/*public Iterator iterator(){

	}*/

	public static void main(String[] args){
		int[] values = new int[8];
		for(int i=0;i<8;i++){
			int num = (int)(Math.random() * 15);
			//System.out.println(num);
			//if(Arrays.binarySearch(values, num)<0)
			if(!contains(values,num))
				values[i] = num;
			else
				i--;
		}

		System.out.println(Arrays.toString(values));

		MyNode root  = new MyNode(values[0]);
		for(int i=1;i<values.length;i++){
			root.add(values[i]);
		}

		System.out.println(root.find(13));

		root.display();

	}

	public static boolean contains(int [] arr, int value){
		int i = 0;
		for(;i<arr.length;i++){
			if(arr[i] == value) return true;

		}
		return false;
	}

}