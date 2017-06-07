package com.xjtu.play;

import java.util.ArrayList;

import com.xjtu.structure.AdjMGraph;

public class AdjMGraphMethods {

	/**
	 * 这块对传递过来的矩阵进行初始化
	 * @param graph  这块是传递过来的数据结构
	 */
	public static void initial(AdjMGraph graph){
		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				if(i==j){
					graph.edge[i][j]=0;//对角线上的元素
				}else{
					graph.edge[i][j]=-1;//对于其他部分的元素，将其置为-1
				}
			}
		}
		graph.numOfEdges=0;//边数置为0
		//test para
/*		for(int i=0;i<graph.maxVertex;i++){
			for(int j=0;j<graph.maxVertex;j++){
				System.out.print(graph.edge[i][j]+"\t");
			}
			System.out.println();
		}*/
	}
	/**
	 * 插入顶点
	 * @param graph
	 * @param vertex
	 */
	public static void insertVertex(AdjMGraph graph,int vertex){
		graph.vertice.add(vertex);
		//test para
		System.out.println("查看顶点数目："+graph.vertice.size());
		for(int i=0;i<graph.vertice.size();i++){
			System.out.print(graph.vertice.get(i)+"\t");
		}
		System.out.println();
	}
	/**
	 * 给图中插入边
	 * @param graph
	 * @param v1 边的邻接顶点
	 * @param v2 边的邻接顶点
	 * @param weight 插入边的权重
	 */
	public static void insertEdge(AdjMGraph graph,int v1,int v2,int weight){
		if(v1<0 || v1>graph.maxVertex || v2<0 || v2>graph.maxVertex){
			System.out.println("v1,v2,参数越界！");
			return;
		}
		graph.edge[v1][v2]=weight;
		graph.numOfEdges++;//边的数目加1
		
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
	 * 删除一个顶点
	 * @param graph
	 * @param vertex 
	 */
	public static void deleteVertex(AdjMGraph graph,int vertex){
		graph.vertice.remove(vertex);//首先在边的集合中删除该节点
		for(int col=0;col<graph.maxVertex;col++){//计算被删除的边
			if(graph.edge[vertex][col]!=0 && graph.edge[vertex][col]!=-1){
				graph.numOfEdges--;
			}
		}
		for(int row=0;row<graph.maxVertex;row++){//计算被删除的边
			if(graph.edge[row][vertex]!=0 && graph.edge[row][vertex]!=-1){
				graph.numOfEdges--;
			}
		}
		
		for(int row=vertex+1;row<graph.maxVertex;row++){//将邻接矩阵的"删除行"进行覆盖，，依次的向上平移矩阵行
			for(int col=0;col<graph.maxVertex;col++){
				graph.edge[row-1][col]=graph.edge[row][col];
			}
		}
		for(int col=vertex+1;col<graph.maxVertex;col++){//对删除列进行平移，覆盖原数据
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
	 * 删除图中的某条边
	 * @param graph
	 * @param v1
	 * @param v2
	 */
	public static void deleteEdge(AdjMGraph graph,int v1,int v2){
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("v1参数越界！");
			return;
		}
		if(v2<0 || v2>graph.maxVertex){
			System.out.println("v2参数越界！");
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
	 * 找到顶点v1的第一个邻接顶点
	 * @param graph
	 * @param v1
	 */
	public static int getFirstVertex(AdjMGraph graph,int v1){
		
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("参数v1越界！");
			return -1;
		}
		for(int col=0;col<graph.maxVertex;col++){
			if(graph.edge[v1][col]!=-1 && graph.edge[v1][col]!=0){
				return col;
			}
		}
		return -1;//表示没有找打该节点
	}
	/**
	 * 获得顶点v1的邻接顶点v2的下一个邻接顶点
	 * @param graph
	 * @param v1
	 * @param v2 直接从顶点v2开始的原因是所有的顶点都是按照顺序排列的，现在从v2开始说明之前的顶点已经被遍历过了
	 * @return
	 */
	public static int getNextVertex(AdjMGraph graph,int v1,int v2){
		if(v1<0 || v1>graph.maxVertex){
			System.out.println("参数v1越界！");
			return -1;
		}
		if(v2<0 || v2>graph.maxVertex){
			System.out.println("参数v2越界！");
			return -1;
		}
		for(int col=v2+1;col<graph.maxVertex;col++){//从v2右边开始寻找满足条件的和顶点v1邻接的节点
			if(graph.edge[v1][col]!=-1 && graph.edge[v1][col]!=0){
				return col;
			}
		}
		return -1;
	}
	/**
	 * 联通图的深度优先遍历
	 * @param graph 将要被遍历的图
	 * @param init 起始节点
	 * @param visited 数组，用来标记数据是否被访问过
	 */
	public static void depthFirstTraverse(AdjMGraph graph,int init,int[] visited){
		if(!graph.vertice.contains(init)){//如果图的顶点集中没有当前的初始结点
			System.out.println("初始节点错误！");
			return;
		}
		if(visited[init]==0){//这块主要是为了防止将遍历过的顶点重复输出，只有当该节点没有被遍历的时候才进行遍历
			visited[init]=1;
			visited(init);
		}
		int sec=getFirstVertex(graph,init);
		while(sec!=-1){//如果当前节点有邻接顶点
			//这块是一直向下进行遍历，取每个顶点的第一个邻接顶点，直到最后一个顶点没有邻接顶点为止
			if(visited[sec]==0){//当前节点没有被遍历过
				visited[sec]=1;
				visited(sec);
				depthFirstTraverse(graph,sec,visited);//直接取找当前节点的下个邻接顶点进行递归
			}
			//第一个邻接顶点的深度遍历已经结束了
			sec=getNextVertex(graph, init, sec);//遍历初始节点的下一个邻接顶点
		}
		
	}
	/**
	 * 将当前访问顶点进行输出
	 * @param node
	 */
	public static void visited(int node){
		System.out.println("当前访问顶点："+node);
	}
	/**
	 * 针对非连通图的递归遍历
	 * @param graph
	 * @param init
	 * @param visited
	 */
	public static void depthFTraverse(AdjMGraph graph){
		int []visited=new int[graph.vertice.size()];//不用初始化，创建变量的时候已经初始化了
		for(int i=0;i<graph.vertice.size();i++){
			if(visited[i]!=1){
				/**
				 * 这样做也是可以的，也就是将每一个节点当作初始结点进行遍历
				 */
				depthFirstTraverse(graph,0,visited);
			}
		}
	}
	/**
	 * 图的广度优先遍历,针对的是连通图
	 * @param graph
	 * @param init
	 * @param visit
	 */
	public static void broadFirstTravers(AdjMGraph graph,int init,int[]visit){
		
		ArrayList<Integer> queue=new ArrayList<Integer>();//用来模拟队列
		visit[init]=1;
		visited(init);	
		queue.add(init);
		while(!queue.isEmpty()){//当队列不为空的时候
			int tmp=queue.remove(0);//将队头出队列
			int sec=getFirstVertex(graph, tmp);//取队头节点的下个节点
			while(sec!=-1){//当该节点存在邻接顶点的时候
				if(visit[sec]!=1){//如果该节点没有被遍历过
					visited(sec);
					visit[sec]=1;
					queue.add(sec);//这是为第二层圆做准备
				}
				sec=getNextVertex(graph, tmp, sec);//寻找对头节点的下一个邻接顶点
			}
		}
	}
	/**
	 * 非连通图的广度优先遍历
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
