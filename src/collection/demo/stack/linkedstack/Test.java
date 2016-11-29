package collection.demo.stack.linkedstack;

import collection.demo.stack.SequenceStack;

/**
 * 堆栈的应用
 * 括号匹配问题
 * 假设算术表达式中包含圆括号，方括号，和花括号三种类型。
 * 使用栈数据结构编写一个算法判断表达式中括号是否正确匹配，并设计一个主函数测试。
 * 比如：
 * {a+[b+(c*a)/(d-e)]}    正确
 * ([a+b)-(c*e)]+{a+b}    错误
 */
public class Test {

	public static String[] expToStringArray(String exp) {
		int n = exp.length();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = exp.substring(i, i + 1);
		}
		return arr;
	}


	public static void signCheck(String exp) throws Exception {
		SequenceStack stack = new SequenceStack();
		String[] arr = Test.expToStringArray(exp);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{")) {
				stack.push(arr[i]);
			} else if (arr[i].equals(")") && !stack.isEmpty() && stack.getTop().equals("(")) {
				stack.pop();
			} else if (arr[i].equals(")") && !stack.isEmpty() && !stack.getTop().equals("(")) {
				System.out.println("左右括号匹配次序不正确！");
				return;
			} else if (arr[i].equals("]") && !stack.isEmpty() && stack.getTop().equals("[")) {
				stack.pop();
			} else if (arr[i].equals("]") && !stack.isEmpty() && !stack.getTop().equals("[")) {
				System.out.println("左右括号匹配次序不正确！");
				return;
			} else if (arr[i].equals("}") && !stack.isEmpty() && stack.getTop().equals("{")) {
				stack.pop();
			} else if (arr[i].equals("}") && !stack.isEmpty() && !stack.getTop().equals("{")) {
				System.out.println("左右括号匹配次序不正确！");
				return;
			} else if (arr[i].equals(")") || arr[i].equals("]") || arr[i].equals("}") && stack.isEmpty()) {
				System.out.println("右括号多于左括号！");
				return;
			}

		}
		if (!stack.isEmpty()) {
			System.out.println("左括号多于右括号！");
		} else {
			System.out.println("括号匹配正确！");
		}
	}

	public static void main(String[] args) throws Exception {
		String str = "([(a+b)-(c*e)]+{a+b}";
		Test.signCheck(str);
	}

}