package com.xjtu.play;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class HuffmanCode {
	
/**
 * ��ʼ��huffman��������ǰn���ڵ���ΪҶ�ڵ㣬����Ȩ�أ���n-1���ڵ��Ƿ�Ҷ�ڵ���ʱû��Ȩ�أ�
 * ��n-1����ҳ�ڵ��ʼΪ0
 * @param weight
 * @param node
 * @param return ����ʼ�����֮��Ľڵ㷵��
 */
public static HuffNode[] initHuffmanTree(int []weight,HuffNode []node,char []ch){
	int n=weight.length;
	for(int i=0;i<2*n-1;i++){
		if(i<n){//���n��Ҷ�ڵ�
			node[i].weight=weight[i];
			node[i].value=ch[i];
		}else{//��Ҷ�ڵ�
			node[i].weight=0;
		}
		//��δ����Ǵ��ж������������ģ�Ϊ���Ǽ����̣���ǿ�ɶ���
		node[i].parent=-1;
		node[i].leftChild=-1;
		node[i].rightChild=-1;
		node[i].flag=0;			//����0˵����û��ʹ�ù�
	}
	return node;
}
/**
 * 
 * huffman���Ĺ�����
 * @param node
 * @return
 */
public static HuffNode[] constructHuffTree(HuffNode []node){
	int n=(node.length+1)/2;		//���ǻ��Ҷ�ڵ�ĸ���
	
	for(int i=0;i<n-1;i++){
		int w1=Integer.MAX_VALUE,w2=Integer.MAX_VALUE;
		int index1=-1,index2=-1;
		//Ѱ��Ȩֵ��С�������ڵ㣬��Ϊÿ��ȡ����Ȩֵ��С�Ľڵ�֮�󣬾ͻ�����һ���µĴ�Ȩֵ�ĸ��ڵ㣬
		//��ÿ�ν���Ȩֵ�ĸ��ڵ�ķ�����n����Ȩֵ���ӽڵ�֮��Ľڵ��У�����ÿ�α������Ȼ����ӡ�
		for(int j=0;j<n+i;j++){
			if(node[j].flag==0){//�����ǰ�ڵ�û�в������������,˵������ʹ�øýڵ�				
				if(node[j].weight<w1){//���һ���ڵ��Ȩֵ��С,w1�����С��Ȩֵ
					
					w2=w1;
					index2=index1;
					w1=node[j].weight;
					index1=j;
				}else if(node[j].weight<w2){//w2��Žϴ��Ȩֵ
					
					w2=node[j].weight;
					index2=j;
				}
			}
		}
		//����Ѱ�ҵ��Ľڵ���й���
		node[n+i].weight=node[index1].weight+node[index2].weight;//�µĽڵ��Ȩֵ��������СȨֵ֮��
		node[n+i].leftChild=index1;//���½ڵ���������ӱ�עΪȨֵ��С������
		node[n+i].rightChild=index2;
		node[index1].flag=1; //��������Ȩֵ��С�Ľڵ���Ϊ��ʹ��
		node[index2].flag=1;
		node[index1].parent=n+i; //���������ڵ�ĸ��ڵ���Ϊ�½ڵ������
		node[index2].parent=n+i;
	}
//	System.out.println("�ڵ㼯�ϣ�");
//	String s="11011";
//	HuffNode traverse=new HuffNode();;
//	traverse=node[node.length-1];//���һ���ڵ���Ǹ��ڵ�
//	for(int i=0;i<s.length();i++){
//		if(s.charAt(i)=='1'){//��0 	��1
//			traverse=node[traverse.rightChild];//���Ϊ1��ô�ҵ�����ڵ���Һ��ӣ�
//		}else{
//			traverse=node[traverse.leftChild];//���Ϊ0����ô�ҵ�����ڵ�����ӣ�
//		}
//	}
//	System.out.println("��ǰ����Ȩֵ��"+traverse.weight);
	return node;
}
/**
 * ����huffman������huffman���� 
 * @param node  ����n��Ҷ�ڵ�
 * @param n Ҷ�ڵ�ĸ���
 * @param code ����huffman�����
 */
public static Code[] huffCode(HuffNode []node, int n, Code []code){
	Code cd=new Code();//����һ�������ʱ�����
	int child,parent;
	for(int i=0;i<n;i++){//���n��Ҷ�ڵ��huffman����
		cd.start=cd.MaxN-1;//��ȡ���������󳤶ȣ�����ʹ�ñ��뵹�Ŵ����������
		cd.weight=node[i].weight;
		child=i;
		parent=node[child].parent;
		while(parent!=-1){
			//���ϵ�д��0��1
			if(node[parent].leftChild==child){//���֧Ϊ0
				cd.bit[cd.start]=0;
			}else{                            //�ҷ�֧Ϊ1
				cd.bit[cd.start]=1;
			}
			cd.start--;//���������ŵ������ƶ� 
			child=parent;
			parent=node[child].parent;//�ٴ�ȡ��ǰ�ڵ�ĸ��ڵ�
		}
		for(int j=cd.start+1;j<cd.MaxN;j++){//���ոմ������ʱ�����еı���ȡ��
			code[i].bit[j]=cd.bit[j];//Ҳ�����������ı����У�Ҳ���Ǵ�0λ�ÿ�ʼ��
		}
		code[i].start=cd.start+1;//����ű������������ʼ���
		code[i].weight=cd.weight;//�洢Ȩ��
	}
	return code;
}
}
