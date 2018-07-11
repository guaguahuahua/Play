package com.interview;

import java.util.ArrayList;

public class PrintArray {

	private int[]array={1, 2, 2, 3, 4, 5};
	private int n=array.length;
	private int [][]graph=new int[n][n];
	private boolean []visited=new boolean[n];
	private String str="";
	private static int count=0;
	
	private void allCombines(){
		buildGraph();
		for(int i=0; i<n; i++){
			this.DFS(i);
		}
	}
	
	private void buildGraph(){
		for(int row=0; row<graph.length; row++){
			for(int col=0; col<graph[row].length; col++){
				if(row!=col){
					graph[row][col]=1;
				}
			}
		}
		graph[3][5]=0;
		graph[5][3]=0;
	}
	
	private void DFS(int start){
		visited[start]=true;
		str=str+array[start];
		
		if(str.length()==n && str.indexOf('4')!=2){
			System.out.println(str);
			count++;
		}
		
		for(int j=0; j<n; j++){
			if(graph[start][j]==1 && visited[j]==false){
				DFS(j);
			}
		}
		
		str=str.substring(0, str.length()-1);
		visited[start]=false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintArray p=new PrintArray();
		p.allCombines();
		System.out.println("组合的数量为："+count);
	}

}
