package com.xjtu.play;

import com.xjtu.structure.AdjMGraph;

public class TestAdjMGraph {
	public static void main(String []args){
		AdjMGraphMethods graph=new AdjMGraphMethods();
		AdjMGraph start=new AdjMGraph();
		//����ͼ�ĳ�ʼ������
		System.out.println("����ͼ�ĳ�ʼ������:");
		graph.initial(start);
		//���Բ��붥��
		for(int i=0;i<4;i++){
			graph.insertVertex(start,i);
		}
		//����߲���
		System.out.println("����߲���");
		graph.insertEdge(start, 0, 1, 5);
		graph.insertEdge(start, 1, 0, 5);
		graph.insertEdge(start, 1, 2, 8);
		graph.insertEdge(start, 2, 1, 8);
		graph.insertEdge(start, 1, 3, 6);
		graph.insertEdge(start, 3, 1, 6);
		graph.insertEdge(start, 2, 3, 9);
		graph.insertEdge(start, 3, 2, 9);
		//����ɾ������
//		System.out.println("����ɾ������");
//		graph.deleteVertex(start, 0);
		//��ɾ������
//		System.out.println("��ɾ������");
//		graph.deleteEdge(start, 0, 1);
		//����ڽӶ������
		System.out.println("����ڽӶ������");
		int r1=graph.getFirstVertex(start, 2);
		System.out.println("��õ�һ�����㣺"+r1);
		//���Ի�ȡ��һ���ڽӶ���
		System.out.println("���Ի�ȡ��һ���ڽӶ���");
		int r2=graph.getNextVertex(start, 2, r1);
		System.out.println("��һ���ڽӶ����ǣ�"+r2);
		//�Ե�ǰ�ڵ����������ȱ���
		System.out.println("��ͨͼ��������ȱ�����");
		int []visited=new int[start.vertice.size()];//���ݶ������Ŀȷ���������ĳ���

/*		graph.depthFirstTraverse(start, 0, visited);
		//����ͨͼ���б���
		System.out.println("����ͨͼ���б���");
		graph.depthFTraverse(start);
*/		//������ȱ���
		System.out.println("������ȱ���");
		graph.broadFirstTravers(start, 0, visited);
		//����ͨͼ�Ĺ�����ȱ���
		System.out.println("����ͨͼ�Ĺ�����ȱ���");
		graph.broadFTraverse(start);
	}

}
