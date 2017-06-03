package com.xjtu.play;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class HuffmanCode {
	
/**
 * 初始化huffman树，其中前n个节点作为叶节点，存在权重，后n-1个节点是非叶节点暂时没有权重，
 * 将n-1个非页节点初始为0
 * @param weight
 * @param node
 * @param return 将初始化完成之后的节点返回
 */
public static HuffNode[] initHuffmanTree(int []weight,HuffNode []node,char []ch){
	int n=weight.length;
	for(int i=0;i<2*n-1;i++){
		if(i<n){//针对n个叶节点
			node[i].weight=weight[i];
			node[i].value=ch[i];
		}else{//非叶节点
			node[i].weight=0;
		}
		//这段代码是从判断语句中提出来的，为了是简化流程，增强可读性
		node[i].parent=-1;
		node[i].leftChild=-1;
		node[i].rightChild=-1;
		node[i].flag=0;			//等于0说明是没有使用过
	}
	return node;
}
/**
 * 
 * huffman树的构建，
 * @param node
 * @return
 */
public static HuffNode[] constructHuffTree(HuffNode []node){
	int n=(node.length+1)/2;		//这是获得叶节点的个数
	
	for(int i=0;i<n-1;i++){
		int w1=Integer.MAX_VALUE,w2=Integer.MAX_VALUE;
		int index1=-1,index2=-1;
		//寻找权值最小的两个节点，因为每次取两个权值最小的节点之后，就会增加一个新的带权值的父节点，
		//而每次将带权值的父节点的放置在n个带权值的子节点之后的节点中，所以每次遍历长度会增加。
		for(int j=0;j<n+i;j++){
			if(node[j].flag==0){//如果当前节点没有参与二叉树构造,说明可以使用该节点				
				if(node[j].weight<w1){//如果一个节点的权值较小,w1存放最小的权值
					
					w2=w1;
					index2=index1;
					w1=node[j].weight;
					index1=j;
				}else if(node[j].weight<w2){//w2存放较大的权值
					
					w2=node[j].weight;
					index2=j;
				}
			}
		}
		//根据寻找到的节点进行构建
		node[n+i].weight=node[index1].weight+node[index2].weight;//新的节点的权值是两个最小权值之和
		node[n+i].leftChild=index1;//将新节点的两个孩子标注为权值最小的两个
		node[n+i].rightChild=index2;
		node[index1].flag=1; //将这两个权值最小的节点标记为已使用
		node[index2].flag=1;
		node[index1].parent=n+i; //将这两个节点的父节点标记为新节点的索引
		node[index2].parent=n+i;
	}
//	System.out.println("节点集合：");
//	String s="11011";
//	HuffNode traverse=new HuffNode();;
//	traverse=node[node.length-1];//最后一个节点就是根节点
//	for(int i=0;i<s.length();i++){
//		if(s.charAt(i)=='1'){//左0 	右1
//			traverse=node[traverse.rightChild];//如果为1那么找到这个节点的右孩子，
//		}else{
//			traverse=node[traverse.leftChild];//如果为0，那么找到这个节点的左孩子，
//		}
//	}
//	System.out.println("当前结点的权值："+traverse.weight);
	return node;
}
/**
 * 根据huffman树生成huffman编码 
 * @param node  这是n个叶节点
 * @param n 叶节点的个数
 * @param code 保存huffman编码的
 */
public static Code[] huffCode(HuffNode []node, int n, Code []code){
	Code cd=new Code();//创建一个存放临时编码的
	int child,parent;
	for(int i=0;i<n;i++){//获得n个叶节点的huffman编码
		cd.start=cd.MaxN-1;//获取到数组的最大长度，这样使得编码倒着存放在数组中
		cd.weight=node[i].weight;
		child=i;
		parent=node[child].parent;
		while(parent!=-1){
			//不断的写入0和1
			if(node[parent].leftChild==child){//左分支为0
				cd.bit[cd.start]=0;
			}else{                            //右分支为1
				cd.bit[cd.start]=1;
			}
			cd.start--;//编码数组存放点向左移动 
			child=parent;
			parent=node[child].parent;//再次取当前节点的父节点
		}
		for(int j=cd.start+1;j<cd.MaxN;j++){//将刚刚存放在零时数组中的编码取出
			code[i].bit[j]=cd.bit[j];//也就是在正常的编码中，也不是从0位置开始的
		}
		code[i].start=cd.start+1;//给存放编码的数组做开始标记
		code[i].weight=cd.weight;//存储权重
	}
	return code;
}
}
