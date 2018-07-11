package com.interview;

public class ReviewPrintArray {
	private static int count=0;

	/**
	 * ����Ҫ���ӡ����
	 * ʹ������ͼ��ʵ��
	 * @param array int
	 * 				��������
	 */
	private static void printArray(int []array){
		int len=array.length;
		//���ȸ�������Ĵ�С����������ͼ���ڽӾ����ʾ
		int [][]graph=buildGraph(len);
		//��������Ƿ���ʹ�
		boolean []visited=new boolean[len];
		//�Ӳ�ͬ�Ľڵ��ͼ����һ��������ȱ���
		for(int i=0; i<len; i++){
			//����ַ����������ÿ����ȱ���֮��Ľ��
			String str="";
			DFS(graph, i, array, visited, str);
		}
	}
	
	/**
	 * ͼ��������ȱ���
	 * @param graph int[][]
	 * 					ͼ���ڽӾ���
	 * @param start int
	 * 					��ʼ�ڵ���±�
	 */
	private static void DFS(int [][]graph, int start, int []array, boolean []visited, String str){
		//���������λ��û�б�������
		visited[start]=true;
		str=str+array[start];
		//�ݹ����
		if(str.length()==6 && str.indexOf('4')!=2){
			System.out.println(str);
			count++;
			//����return��䲻��������ʹ�õ�
//			return;
		}
		//�鿴�����ʼ�ڵ����������ڵĽڵ�
		for(int j=0; j<6; j++){
			//�����ǰ�ڵ�û�б����ʹ�,���Һ������Ľڵ�֮�������·
			if(graph[start][j]==1 && !visited[j]){
				DFS(graph, j, array, visited, str);
			}
		}
		//�������һ���ַ�
		str=str.substring(0, str.length()-1);
		visited[start]=false;
	}
	
	/**
	 * ����ͼ���ڽӾ���
	 * @param n int
	 * 			����ĳ���
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
		//��Ϊ3��5Ԫ�ز�������
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
