package com.xjtu.structure;

import java.util.ArrayList;
import java.util.List;

public class AdjMGraph {
	public int maxVertex=20;//最大的顶点数目
	
	public List <Integer>vertice=new ArrayList<Integer>();//存放结点的表	
	public int [][]edge=new int[maxVertex][maxVertex];//邻接矩阵，存放边集合
	public int numOfEdges; //存放边的数目
}
