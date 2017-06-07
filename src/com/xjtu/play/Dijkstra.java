package com.xjtu.play;

public class Dijkstra {

	public static void dijkstra(){
		int [][]e=new int[10][10];
		int []dis=new int[10];
		int []book=new int[10];
		int min=0,inf=999999;
		int n=6;//顶点个数
		int m=9;//边的条数
		for(int i=1;i<=n;i++){//对邻接矩阵进行初始化
			for(int j=1;j<=n;j++){
				if(i==j){
					e[i][j]=0;
				}else{
					e[i][j]=inf;
				}
			}
		}
		e[1][2]=1;//这块是对边进行初始化
		e[1][3]=12;
		e[2][3]=9;
		e[2][4]=3;
		e[3][5]=5;
		e[4][3]=4;
		e[4][5]=13;
		e[4][6]=15;
		e[5][6]=4;
		book[1]=1;//表示第一个顶点已经添加进了p集合
		for(int i=1;i<=n;i++){//对dis数组进行初始化,之所以使用边集合第一行来进行，是因为从顶点1到其他顶点的最短距离
			dis[i]=e[1][i];
		}
		
		//dijkstra core
		int u=0;
		for(int i=1;i<=n-1;i++){//这块是因为从第一个节点到剩余节点的只有n-1个
			min=inf;
			//寻找离第一个节点最近的节点
			for(int j=1;j<=n;j++){
				if(book[j]==0 && dis[j]<min){
					min=dis[j];
					u=j;
					System.out.println("符合条件的元素："+dis[j]);
				}
			}
			book[u]=1;
			for(int v=1;v<=n;v++){
				if(e[u][v]<inf){//首先是有边存在的
					if(dis[v]>dis[u]+e[u][v]){//等式左边是直接从源点到目标为止的距离，右边是这是从新找到的顶点出发，到目标顶点的距离，逐一的更新到每个顶点的距离，变成最短的
						dis[v]=dis[u]+e[u][v];
					}
				}
			}
		}
		for(int i=1;i<=n;i++){
			System.out.print(dis[i]+"\t");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dijkstra();
	}

}
