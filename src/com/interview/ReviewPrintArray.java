package com.interview;

public class ReviewPrintArray {
	private static int count=0;

	/**
	 * 按照要求打印数组
	 * 使用无向图来实现
	 * @param array int
	 * 				输入数组
	 */
	private static void printArray(int []array){
		int len=array.length;
		//首先根据数组的大小，建立无向图的邻接矩阵表示
		int [][]graph=buildGraph(len);
		//用来标记是否访问过
		boolean []visited=new boolean[len];
		//从不同的节点对图进行一个深度优先遍历
		for(int i=0; i<len; i++){
			//这个字符串用来存放每次深度遍历之后的结果
			String str="";
			DFS(graph, i, array, visited, str);
		}
	}
	
	/**
	 * 图的深度优先遍历
	 * @param graph int[][]
	 * 					图的邻接矩阵
	 * @param start int
	 * 					开始节点的下标
	 */
	private static void DFS(int [][]graph, int start, int []array, boolean []visited, String str){
		//如果给定的位置没有被遍历过
		visited[start]=true;
		str=str+array[start];
		//递归出口
		if(str.length()==6 && str.indexOf('4')!=2){
			System.out.println(str);
			count++;
			//看来return语句不是随便可以使用的
//			return;
		}
		//查看这个开始节点其他的相邻的节点
		for(int j=0; j<6; j++){
			//如果当前节点没有被访问过,并且和其他的节点之间存在链路
			if(graph[start][j]==1 && !visited[j]){
				DFS(graph, j, array, visited, str);
			}
		}
		//削掉最后一个字符
		str=str.substring(0, str.length()-1);
		visited[start]=false;
	}
	
	/**
	 * 建立图的邻接矩阵
	 * @param n int
	 * 			数组的长度
	 */
	private static int[][] buildGraph(int n){
		int [][]graph=new int[n][n];
		for(int row=0; row<graph.length; row++){
			for(int col=0; col<graph[0].length; col++){
				if(row!=col){
					graph[row][col]=1;
				}
			}
		}
		//因为3和5元素不能相邻
		graph[3][5]=0;
		graph[5][3]=0;
		return graph;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={1, 2, 2, 3, 4, 5};
		printArray(array);
		System.out.println(count);
	}

}
