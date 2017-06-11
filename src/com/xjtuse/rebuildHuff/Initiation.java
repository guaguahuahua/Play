package com.xjtuse.rebuildHuff;

import java.util.ArrayList;
import java.util.List;

/**
 * 这块主要进行huffman树的构建和huffman编码的生成过程
 * @author 22847
 */
public class Initiation {
	/**
	 * 这块采用仿真指针建立huffman树
	 * @param hash 
	 * @return
	 */
	public static HuffNode[] initHuffTree(List result){		
		//从上步中提炼的结果构建huffman树
		char []ch=(char[])result.get(0);	//字符   
		int []weight=(int [])result.get(1);//权重集
		//根据huffman树的特点可以得到总共的节点数为2k-1，很好理解huffman树只有度为0和度为2的节点，同时根据度为0和度为2节点的关系
		HuffNode []node=new HuffNode[2*ch.length-1];
		
		//初始化huffman树的节点
		for(int i=0;i<node.length;i++){
			node[i]=new HuffNode();
			if(i<ch.length){//叶节点
				node[i].value=ch[i];
				node[i].weight=weight[i];
			}
			//非叶节点
			node[i].leftChild=-1;
			node[i].rightChild=-1;
			node[i].parent=-1;
			node[i].flag=0;
		}
//		System.out.println("节点个数："+node.length);
//		for(int i=0;i<node.length;i++){
//			System.out.println(node[i].value+", "+node[i].weight+", "+node[i].leftChild+", "+node[i].rightChild+", "+node[i].parent);
//		}
		return node;
	}
	/**
	 * huffman编码的生成，
	 * @param node 所有的节点，以数组的形式传入
	 */
	public static HuffNode[] treeBuilding(HuffNode []node){
		int noleaf=(node.length+1)/2-1;//计算非叶节点的个数
		int index1=0,index2=0;
		for(int i=0;i<noleaf;i++){//huffman树的建立
			
			int min=Integer.MAX_VALUE,secmin=Integer.MAX_VALUE;
			for(int j=0;j<noleaf+1+i;j++){//搜索范围一开始只有叶节点，逐渐地扩展到了非叶节点
				if(node[j].flag==0 && node[j].weight<min){//这里存放最小
					secmin=min;		//这块主要是若碰到了更小的值，让当前最小更新次最小
					index2=index1;
					
					min=node[j].weight;
					index1=j;
				}else if(node[j].flag==0 && node[j].weight<secmin){//这里存放次最小
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
		System.out.println("建树之后："+node.length);
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
