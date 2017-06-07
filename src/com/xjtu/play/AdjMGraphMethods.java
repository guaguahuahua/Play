package com.xjtu.play;

import java.util.ArrayList;

import com.xjtu.structure.AdjMGraph;

public class AdjMGraphMethods {

	/**
	 * ���Դ��ݹ����ľ�����г�ʼ��
	 * @param graph  ����Ǵ��ݹ��������ݽṹ
	 */
	public static void initial(AdjMGraph graph){
		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				if(i==j){
					graph.edge[i][j]=0;//�Խ����ϵ�Ԫ��
				}else{
					graph.edge[i][j]=-1;//�����������ֵ�Ԫ�أ�������Ϊ-1
				}
			}
		}
		graph.numOfEdges=0;//������Ϊ0
		//test para
/*		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				System.out.print(graph.edge[i][j]+"\t");
			}
			System.out.println();
		}*/
	}
	/**
	 * ���붥��
	 * @param graph
	 * @param vertex
	 */
	public static void insertVertex(AdjMGraph graph,int vertex){
		graph.vertice.add(vertex);
		//test para
		System.out.println("�鿴������Ŀ��"+graph.vertice.size());
		for(int i=0;i<graph.vertice.size();i++){
			System.out.print(graph.vertice.get(i)+"\t");
		}
		System.out.println();
	}
	/**
	 * ��ͼ�в����
	 * @param graph
	 * @param v1 �ߵ��ڽӶ���
	 * @param v2 �ߵ��ڽӶ���
	 * @param weight ����ߵ�Ȩ��
	 */
	public static void insertEdge(AdjMGraph graph,int v1,int v2,int weight){
		if(v1<0 || v1>graph.maxVertex || v2<0 || v2>graph.maxVertex){
			System.out.println("v1,v2,����Խ�磡");
			return;
		}
		graph.edge[v1][v2]=weight;
		graph.numOfEdges++;//�ߵ���Ŀ��1
		
		//test para
		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				System.out.print(graph.edge[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * ɾ��һ������
	 * @param graph
	 * @param vertex 
	 */
	public static void deleteVertex(AdjMGraph graph,int vertex){
		graph.vertice.remove(vertex);//�����ڱߵļ�����ɾ���ýڵ�
		for(int col=0;col<graph.maxVertex;col++){//���㱻ɾ���ı�
			if(graph.edge[vertex][col]!=0 && graph.edge[vertex][col]!=-1){
				graph.numOfEdges--;
			}
		}
		for(int row=0;row<graph.maxVertex;row++){//���㱻ɾ���ı�
			if(graph.edge[row][vertex]!=0 && graph.edge[row][vertex]!=-1){
				graph.numOfEdges--;
			}
		}
		
		for(int row=vertex+1;row<graph.maxVertex;row++){//���ڽӾ����"ɾ����"���и��ǣ������ε�����ƽ�ƾ�����
			for(int col=0;col<graph.maxVertex;col++){
				graph.edge[row-1][col]=graph.edge[row][col];
			}
		}
		for(int col=vertex+1;col<graph.maxVertex;col++){//��ɾ���н���ƽ�ƣ�����ԭ����
			for(int row=0;row<graph.maxVertex;row++){
				graph.edge[row][col-1]=graph.edge[row][col];
			}
		}
		
		//test para
		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				System.out.print(graph.edge[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * ɾ��ͼ�е�ĳ����
	 * @param graph
	 * @param v1
	 * @param v2
	 */
	public static void deleteEdge(AdjMGraph graph,int v1,int v2){
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("v1����Խ�磡");
			return;
		}
		if(v2<0 || v2>graph.maxVertex){
			System.out.println("v2����Խ�磡");
			return;
		}
		graph.numOfEdges--;
		graph.edge[v1][v2]=-1;
		
		//test para
		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				System.out.print(graph.edge[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * �ҵ�����v1�ĵ�һ���ڽӶ���
	 * @param graph
	 * @param v1
	 */
	public static int getFirstVertex(AdjMGraph graph,int v1){
		
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("����v1Խ�磡");
			return -1;
		}
		for(int col=0;col<graph.maxVertex;col++){
			if(graph.edge[v1][col]!=-1 && graph.edge[v1][col]!=0){
				return col;
			}
		}
		return -1;//��ʾû���Ҵ�ýڵ�
	}
	/**
	 * ��ö���v1���ڽӶ���v2����һ���ڽӶ���
	 * @param graph
	 * @param v1
	 * @param v2 ֱ�ӴӶ���v2��ʼ��ԭ�������еĶ��㶼�ǰ���˳�����еģ����ڴ�v2��ʼ˵��֮ǰ�Ķ����Ѿ�����������
	 * @return
	 */
	public static int getNextVertex(AdjMGraph graph,int v1,int v2){
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("����v1Խ�磡");
			return -1;
		}
		if(v2<0 || v2>graph.maxVertex){
			System.out.println("����v2Խ�磡");
			return -1;
		}
		for(int col=v2+1;col<graph.maxVertex;col++){//��v2�ұ߿�ʼѰ�����������ĺͶ���v1�ڽӵĽڵ�
			if(graph.edge[v1][col]!=-1 && graph.edge[v1][col]!=0){
				return col;
			}
		}
		return -1;
	}
	/**
	 * ��ͨͼ��������ȱ���
	 * @param graph ��Ҫ��������ͼ
	 * @param init ��ʼ�ڵ�
	 * @param visited ���飬������������Ƿ񱻷��ʹ�
	 */
	public static void depthFirstTraverse(AdjMGraph graph,int init,int[] visited){
		if(!graph.vertice.contains(init)){//���ͼ�Ķ��㼯��û�е�ǰ�ĳ�ʼ���
			System.out.println("��ʼ�ڵ����");
			return;
		}
		if(visited[init]==0){//�����Ҫ��Ϊ�˷�ֹ���������Ķ����ظ������ֻ�е��ýڵ�û�б�������ʱ��Ž��б���
			visited[init]=1;
			visited(init);
		}
		int sec=getFirstVertex(graph,init);
		while(sec!=-1){//�����ǰ�ڵ����ڽӶ���
			//�����һֱ���½��б�����ȡÿ������ĵ�һ���ڽӶ��㣬ֱ�����һ������û���ڽӶ���Ϊֹ
			if(visited[sec]==0){//��ǰ�ڵ�û�б�������
				visited[sec]=1;
				visited(sec);
				depthFirstTraverse(graph,sec,visited);//ֱ��ȡ�ҵ�ǰ�ڵ���¸��ڽӶ�����еݹ�
			}
			//��һ���ڽӶ������ȱ����Ѿ�������
			sec=getNextVertex(graph, init, sec);//������ʼ�ڵ����һ���ڽӶ���
		}
		
	}
	/**
	 * ����ǰ���ʶ���������
	 * @param node
	 */
	public static void visited(int node){
		System.out.println("��ǰ���ʶ��㣺"+node);
	}
	/**
	 * ��Է���ͨͼ�ĵݹ����
	 * @param graph
	 * @param init
	 * @param visited
	 */
	public static void depthFTraverse(AdjMGraph graph){
		int []visited=new int[graph.vertice.size()];//���ó�ʼ��������������ʱ���Ѿ���ʼ����
		for(int i=0;i<graph.vertice.size();i++){
			if(visited[i]!=1){
				/**
				 * ������Ҳ�ǿ��Եģ�Ҳ���ǽ�ÿһ���ڵ㵱����ʼ�����б���
				 */
				depthFirstTraverse(graph,0,visited);
			}
		}
	}
	/**
	 * ͼ�Ĺ�����ȱ���,��Ե�����ͨͼ
	 * @param graph
	 * @param init
	 * @param visit
	 */
	public static void broadFirstTravers(AdjMGraph graph,int init,int[]visit){
		
		ArrayList<Integer> queue=new ArrayList<Integer>();//����ģ�����
		visit[init]=1;
		visited(init);	
		queue.add(init);
		while(!queue.isEmpty()){//�����в�Ϊ�յ�ʱ��
			int tmp=queue.remove(0);//����ͷ������
			int sec=getFirstVertex(graph, tmp);//ȡ��ͷ�ڵ���¸��ڵ�
			while(sec!=-1){//���ýڵ�����ڽӶ����ʱ��
				if(visit[sec]!=1){//����ýڵ�û�б�������
					visited(sec);
					visit[sec]=1;
					queue.add(sec);//����Ϊ�ڶ���Բ��׼��
				}
				sec=getNextVertex(graph, tmp, sec);//Ѱ�Ҷ�ͷ�ڵ����һ���ڽӶ���
			}
		}
	}
	/**
	 * ����ͨͼ�Ĺ�����ȱ���
	 * @param graph
	 */
	public static void broadFTraverse(AdjMGraph graph){
		int []visit=new int[graph.vertice.size()];
		
		for(int i=0;i<graph.vertice.size();i++){
			if(visit[i]!=1){
				broadFirstTravers(graph, i, visit);
			}
		}
	}

	
}
