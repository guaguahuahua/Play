package com.xjtu.play;

public class Floyd {

	/**
	 * ʵ��floyd�㷨�����Լ���ѧԺ
	 */
	public static void floyd(){
		int [][]e=new int[10][10];
		int inf=999999;
		int n=4;//�������
		int m=8;//�ߵ�����
		for(int i=1;i<=m;i++){//���ڽӾ�����г�ʼ��
			for(int j=1;j<=m;j++){
				if(i!=j){
					e[i][j]=inf;
				}else{
					e[i][j]=0;
				}
			}
		}
		//��ӱ�
		e[1][2]=2;
		e[1][3]=6;
		e[1][4]=4;
		e[2][3]=3;
		e[3][1]=7;
		e[3][4]=1;
		e[4][1]=5;
		e[4][3]=12;
		//floyd core
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){//����ʾ���Ǿ�����k���ڵ�����·����k���Ա������еĽڵ�
				for(int k=1;k<=n;k++){
					if(e[i][k]!=inf && e[k][j]!=inf && e[i][j]>e[i][k]+e[k][j]){
						e[i][j]=e[i][k]+e[k][j];
					}
				}
			}
		}
		//����㷨
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				System.out.print(e[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		floyd();
	}

}
