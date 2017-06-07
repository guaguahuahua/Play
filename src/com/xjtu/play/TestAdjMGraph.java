package com.xjtu.play;

import com.xjtu.structure.AdjMGraph;

public class TestAdjMGraph {
	public static void main(String []args){
		AdjMGraphMethods graph=new AdjMGraphMethods();
		AdjMGraph start=new AdjMGraph();
		//测试图的初始化方法
		System.out.println("测试图的初始化方法:");
		graph.initial(start);
		//测试插入顶点
		for(int i=0;i<4;i++){
			graph.insertVertex(start,i);
		}
		//插入边测试
		System.out.println("插入边测试");
		graph.insertEdge(start, 0, 1, 5);
		graph.insertEdge(start, 1, 0, 5);
		graph.insertEdge(start, 1, 2, 8);
		graph.insertEdge(start, 2, 1, 8);
		graph.insertEdge(start, 1, 3, 6);
		graph.insertEdge(start, 3, 1, 6);
		graph.insertEdge(start, 2, 3, 9);
		graph.insertEdge(start, 3, 2, 9);
		//顶点删除测试
//		System.out.println("顶点删除测试");
//		graph.deleteVertex(start, 0);
		//边删除测试
//		System.out.println("边删除测试");
//		graph.deleteEdge(start, 0, 1);
		//获得邻接顶点测试
		System.out.println("获得邻接顶点测试");
		int r1=graph.getFirstVertex(start, 2);
		System.out.println("获得第一个顶点："+r1);
		//测试获取下一个邻接顶点
		System.out.println("测试获取下一个邻接顶点");
		int r2=graph.getNextVertex(start, 2, r1);
		System.out.println("下一个邻接顶点是："+r2);
		//对当前节点进行深度优先遍历
		System.out.println("联通图的深度优先遍历：");
		int []visited=new int[start.vertice.size()];//根据顶点的数目确定标记数组的长度

/*		graph.depthFirstTraverse(start, 0, visited);
		//非连通图进行遍历
		System.out.println("非连通图进行遍历");
		graph.depthFTraverse(start);
*/		//广度优先遍历
		System.out.println("广度优先遍历");
		graph.broadFirstTravers(start, 0, visited);
		//非连通图的广度优先遍历
		System.out.println("非连通图的广度优先遍历");
		graph.broadFTraverse(start);
	}

}
