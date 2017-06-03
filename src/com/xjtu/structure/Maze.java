package com.xjtu.structure;

import java.util.Stack;

public class Maze {

	/**
	 * 寻找入口和出口
	 * @param map
	 * @return
	 */
	public static PointPos[] findMarkedPos(int [][]map){
		PointPos exit = new PointPos();
		PointPos entrance = new PointPos();
		boolean f1=true,f2=true;
		for(int row=0;row<map.length;row++){
			for(int col=0;col<map[row].length;col++){
				if(map[row][col]==2 && f1){//如果是入口，那么标记
					entrance.x=row;
					entrance.y=col;
					f1=false;
				}else if(map[row][col]==3 && f2){//如果是出口，标记
					exit.x=row;
					exit.y=col;
					f2=false;
				}
				if(!f1 && !f2){//如果找到了入口和出口
					return new PointPos[]{entrance,exit};
				}
			}
		}
		return null;//没找到，返回null
	}
	/**
	 * 传入入口和出口参数以及迷宫地图
	 * @param pos 里面包含了两个参数，入口和出口，入口是第一个，出口时第二个
	 * @param map
	 */
	public static int[][] DFstack(PointPos []pos,int [][]map){
		//用来存储碰到的可以通行的节点
		Stack <PointPos>stack=new Stack<PointPos>();
		PointPos pointtmp;
//		PointPos pointPos=new PointPos();//这个不能声明为全局变量，否则入栈的时候如果该节点有多个路口，那么后面的路口信息会更改前面的路口信息
		//造成最后一个入栈元素将修改所有的栈内元素信息。
		int flag=4;//主要是用来标记遍历过的元素
		stack.push(pos[0]);//将入口元素放入堆栈之中
		
		while(!stack.isEmpty()){//当堆栈不为空时循环执行
			pointtmp=stack.peek();
			stack.pop();//将栈顶元素出栈，判断
			System.out.println("栈长度为："+stack.size());
			int row=pointtmp.x;
			int col=pointtmp.y;
			System.out.println("出栈坐标为："+pointtmp.x+", "+pointtmp.y);
			int count=0;
			//这块主要是将出栈的元素，也就是已经遍历过的元素进行标记，，让其值为flag,可以避免重复判断是否可以左移右移等等的步骤
			if(map[row][col]==0){
				map[row][col]=flag;
			}
			//判断是否能上下移动
			if(row<map.length-1 && row>=1){
				//判断是否可以上移
				if(map[row-1][col]==0){//如果可以上移，那么添加到堆栈中
					PointPos pointPos=new PointPos();
					pointPos.x=row-1;
					pointPos.y=col;
					System.out.println("入栈坐标为："+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row-1][col]==3){//这块需要将3最后改正为出口的值
					break;
				}
				//判断是否可以下移
				if(map[row+1][col]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row+1;
					pointPos.y=col;
					System.out.println("入栈坐标为："+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row+1][col]==3){//如果是到了出口，那么直接结束循环
					break;
				}
			}
			//判断是否可以进行左右移动
			if(col>=1 && col<map[0].length-1){//因为迷宫是规则的矩形，所以可以直接使用第一行的列数来标记其他行的列数
				//能左移
				if(map[row][col-1]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row;
					pointPos.y=col-1;
					System.out.println("入栈坐标为："+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row][col-1]==3){
					break;
				}
				//能右移
				if(map[row][col+1]==0){
					PointPos pointPos=new PointPos();
					pointPos.x=row;
					pointPos.y=col+1;
					System.out.println("入栈坐标为："+pointPos.x+", "+pointPos.y);
					stack.push(pointPos);
					++count;
				}else if(map[row][col+1]==3){
					break;
				}
			}
			if(count>1){
				++flag;
			}
		}
		System.out.print("寻找所有合适的路径："+"\n");
		show(map);
		return map;
	}
	/**
	 * 输出函数，将遍历过的迷宫输出
	 * @param map
	 */
	public static void show(int [][]map){
		for(int row=0;row<map.length;row++){
			for(int col=0;col<map[row].length;col++){
				
				System.out.print(map[row][col]+"\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	/**
	 * 经过遍历之后，迷宫中的路径都被遍历并且标记过了，现在要做的就是在这些标记过的路径中找到可以通向出口的路径
	 * 方法比较简单，原因是在开始遍历所有可行路径的时候，路径上面的都被标记过整数，越靠后的路径被标记的整数值越大
	 * 因此只要从入口开始每次寻找较大的值的方向进行寻找即可找到出口
	 * @param r 入口，出口的位置
	 * @param map 迷宫的地图
	 */
	public static void markWay(PointPos []r,int [][]map){
		int px,py,nx = 0,ny = 0;
		px=r[0].x;//将开始节点的坐标代入
		py=r[0].y;
		int max=map[px][py];//假定入口节点的值是最大的,节点入口值是 2
		
		//寻找通向出口的路径，从上下左右四个方向依次的，寻找到最大的值
		while(map[px][py]!=3){
			//判断是否可以上下移动
			if(px>0 && px<map.length-1){//也就说整个遍历过程是在墙内的，所谓的墙，就是迷宫的边界，人为的添加了的
				//判断下面的节点是否为路径的一部分
				if(map[px+1][py]>max){
					nx=px+1;
					ny=py;
					max=map[nx][ny];
				}else if(map[px+1][py]==3){
					break;
				}
				//判断上面的节点是否为路径的一部分
				if(map[px-1][py]>max){
					nx=px-1;
					ny=py;
					max=map[nx][ny];
				}else if(map[px-1][py]==3){
					break;
				}
			}
			//判断左右是否是路径的一部分
			if(py>0 && py<map[0].length-1){
				//判断左边是否为路径
				if(map[px][py-1]>max){
					nx=px;
					ny=py-1;
					max=map[nx][ny];
				}else if(map[px][py-1]==3){
					break;
				}
				//判断右边是否为路径
				if(map[px][py+1]>max){
					nx=px;
					ny=py+1;
					max=map[nx][ny];
				}else if(map[px][py+1]==3){
					break;
				}
			}
			map[nx][ny]=-1;//将可以通向出口的路径标记为-1
			max=3;
			px=nx;//以当前节点为开始再次遍历
			py=ny;
		}
		System.out.print("路径以-1标出："+"\n");
		show(map);
	}
	
}
