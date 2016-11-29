package collection.demo.list.cyclelinkedlist;

/**
 * 循环链表应用
 * 游戏规则：N个人围成一个圈，从第一个人开始传花，当数到M时，该人退出游戏，直到剩下最后一个人。
 */
public class Game {

	//单向循环链表
	CycleLinkedList list = new CycleLinkedList();
	//总人数
	int num;
	//数到几退出
	int key;

	//游戏初始化方法
	public Game(int num,int key)
	{
		this.num = num;
		this.key = key;
	}

	public void play() throws Exception
	{
		for(int i=0;i<num;i++)
		{
			list.add(i, i);
		}

		System.out.println("\n-------游戏开始之前---------\n");
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
		System.out.println("\n-------游戏开始---------\n");
		int iCount=num; //开始等于总人数num
		int j=0; //累加器，计算是否能被key整除。

		Node node = list.head;
		while(iCount!=1)
		{
			if(node.getElement()!=null&& Integer.parseInt(node.getElement().toString())!=-1)
			{
				j++;
				if(j%key==0)
				{
					node.setElement(-1);
					iCount--;
					System.out.println();
					for(int i=0;i<list.size();i++)
					{
						System.out.print(list.get(i)+" ");
					}
				}
			}
			node = node.next;
		}
		System.out.println("\n-------游戏结束---------\n");
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
	}

}