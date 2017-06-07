package com.xjtu.play;

public class Dijkstra {

	public static void dijkstra(){
		int [][]e=new int[10][10];
		int []dis=new int[10];
		int []book=new int[10];
		int min=0,inf=999999;
		int n=6;//�������
		int m=9;//�ߵ�����
		for(int i=1;i<=n;i++){//���ڽӾ�����г�ʼ��
			for(int j=1;j<=n;j++){
				if(i==j){
					e[i][j]=0;
				}else{
					e[i][j]=inf;
				}
			}
		}
		e[1][2]=1;//����ǶԱ߽��г�ʼ��
		e[1][3]=12;
		e[2][3]=9;
		e[2][4]=3;
		e[3][5]=5;
		e[4][3]=4;
		e[4][5]=13;
		e[4][6]=15;
		e[5][6]=4;
		book[1]=1;//��ʾ��һ�������Ѿ���ӽ���p����
		for(int i=1;i<=n;i++){//��dis������г�ʼ��,֮����ʹ�ñ߼��ϵ�һ�������У�����Ϊ�Ӷ���1�������������̾���
			dis[i]=e[1][i];
		}
		
		//dijkstra core
		int u=0;
		for(int i=1;i<=n-1;i++){//�������Ϊ�ӵ�һ���ڵ㵽ʣ��ڵ��ֻ��n-1��
			min=inf;
			//Ѱ�����һ���ڵ�����Ľڵ�
			for(int j=1;j<=n;j++){
				if(book[j]==0 && dis[j]<min){
					min=dis[j];
					u=j;
					System.out.println("����������Ԫ�أ�"+dis[j]);
				}
			}
			book[u]=1;
			for(int v=1;v<=n;v++){
				if(e[u][v]<inf){//�������бߴ��ڵ�
					if(dis[v]>dis[u]+e[u][v]){//��ʽ�����ֱ�Ӵ�Դ�㵽Ŀ��Ϊֹ�ľ��룬�ұ������Ǵ����ҵ��Ķ����������Ŀ�궥��ľ��룬��һ�ĸ��µ�ÿ������ľ��룬�����̵�
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
