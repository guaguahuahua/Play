package com.xjtu.structure;

import java.util.ArrayList;
import java.util.List;

public class AdjMGraph {
	public int maxVertex=20;//���Ķ�����Ŀ
	
	public List <Integer>vertice=new ArrayList<Integer>();//��Ž��ı�	
	public int [][]edge=new int[maxVertex][maxVertex];//�ڽӾ��󣬴�ű߼���
	public int numOfEdges; //��űߵ���Ŀ
}
