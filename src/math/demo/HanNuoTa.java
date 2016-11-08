package math.demo;

/**
 * 有三根柱子A，B，C，A柱子上有N个盘子，从小到大依次叠放，
 * 要求把A上的盘子都移到C上，B可以作为临时存放，
 * 移动的时候必须始终遵循小盘子在大盘子上面，且每次只能移动一个盘子，求其算法。
 */
public class HanNuoTa {
	public static void main(String[] args) {
		move(3, 'X', 'Y', 'Z');
	}

	public static void move(int count,char from ,char middle,char to)
	{
		if(count==1)
			System.out.println("move 1  from "+from +"---> to "+to );
		else {
			move(count-1, from, to, middle);
			System.out.println("move "+count+"  from "+from +"---> to "+to );
			move(count-1, middle, from, to);

		}
	}
}
