package com.xjtuse.rebuildHuff;

import java.util.ArrayList;
import java.util.List;

/**
 * �����Ҫ����huffman���Ĺ�����huffman��������ɹ���
 * @author 22847
 */
public class Initiation {
	/**
	 * �����÷���ָ�뽨��huffman��
	 * @param hash 
	 * @return
	 */
	public static HuffNode[] initHuffTree(List result){		
		//���ϲ��������Ľ������huffman��
		char []ch=(char[])result.get(0);	//�ַ�   
		int []weight=(int [])result.get(1);//Ȩ�ؼ�
		//����huffman�����ص���Եõ��ܹ��Ľڵ���Ϊ2k-1���ܺ����huffman��ֻ�ж�Ϊ0�Ͷ�Ϊ2�Ľڵ㣬ͬʱ���ݶ�Ϊ0�Ͷ�Ϊ2�ڵ�Ĺ�ϵ
		HuffNode []node=new HuffNode[2*ch.length-1];
		
		//��ʼ��huffman���Ľڵ�
		for(int i=0;i<node.length;i++){
			node[i]=new HuffNode();
			if(i<ch.length){//Ҷ�ڵ�
				node[i].value=ch[i];
				node[i].weight=weight[i];
			}
			//��Ҷ�ڵ�
			node[i].leftChild=-1;
			node[i].rightChild=-1;
			node[i].parent=-1;
			node[i].flag=0;
		}
//		System.out.println("�ڵ������"+node.length);
//		for(int i=0;i<node.length;i++){
//			System.out.println(node[i].value+", "+node[i].weight+", "+node[i].leftChild+", "+node[i].rightChild+", "+node[i].parent);
//		}
		return node;
	}
	/**
	 * huffman��������ɣ�
	 * @param node ���еĽڵ㣬���������ʽ����
	 */
	public static HuffNode[] treeBuilding(HuffNode []node){
		int noleaf=(node.length+1)/2-1;//�����Ҷ�ڵ�ĸ���
		int index1=0,index2=0;
		for(int i=0;i<noleaf;i++){//huffman���Ľ���
			
			int min=Integer.MAX_VALUE,secmin=Integer.MAX_VALUE;
			for(int j=0;j<noleaf+1+i;j++){//������Χһ��ʼֻ��Ҷ�ڵ㣬�𽥵���չ���˷�Ҷ�ڵ�
				if(node[j].flag==0 && node[j].weight<min){//��������С
					secmin=min;		//�����Ҫ���������˸�С��ֵ���õ�ǰ��С���´���С
					index2=index1;
					
					min=node[j].weight;
					index1=j;
				}else if(node[j].flag==0 && node[j].weight<secmin){//�����Ŵ���С
					secmin=node[j].weight;
					index2=j;
				}
			}
			node[index1].flag=1;
			node[index2].flag=1;
			node[noleaf+1+i].weight=node[index1].weight+node[index2].weight;
			node[noleaf+1+i].leftChild=index1;
			node[noleaf+1+i].rightChild=index2;
			node[index1].parent=noleaf+1+i;
			node[index2].parent=noleaf+1+i;
		}
		//test para
		System.out.println("����֮��"+node.length);
		for(int i=0;i<node.length;i++){
			System.out.println(node[i].value+", "+node[i].weight+", "+node[i].leftChild+", "+node[i].rightChild+", "+node[i].parent+", "+node[i].flag);
		}
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		Scanning scan=new Scanning();
		Extract extract=new Extract();
		
		List r1=extract.extractInfor(scan.scanning(filePath));
		HuffNode []nodes=initHuffTree(r1);
		treeBuilding(nodes);
/*		char []ch={'a','b','c','d'};
		int []weight={1,3,5,7};
		ArrayList result=new ArrayList();
		result.add(ch);
		result.add(weight);
		HuffNode []nodes=initHuffTree(result);
		treeBuilding(nodes);*/
	}

}
