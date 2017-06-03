package com.xjtuse.huff;

import java.util.ArrayList;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class TestHuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		//����huffman����ʼ������
		HuffmanCode huffcode=new HuffmanCode();
		int []weight={1,3,5,7};//Ȩ������
		HuffNode []node=new HuffNode[2*weight.length-1];//�����ڵ�
		for(int i=0;i<2*weight.length-1;i++){//�Խڵ���г�ʼ��
			node[i]=new HuffNode();
		}
		//���Գ�ʼ��
		System.out.println("���Գ�ʼ��");
		HuffNode []huffnode=huffcode.initHuffmanTree(weight, node);
		//����huffman���Ľ�����
		System.out.println("����huffman������");
		System.out.println("huffnode.length:"+huffnode.length);
		HuffNode []treenode=huffcode.constructHuffTree(huffnode);
		
		//����huffman����Ĺ���
		System.out.println("����huffman����");
		Code []code=new Code[(treenode.length+1)/2];
		for(int i=0;i<code.length;i++){//�Դ�ű����������г�ʼ����
			code[i]=new Code();
		}
		Code []huffmanCode=huffcode.huffCode(treenode, (treenode.length+1)/2,code);
		for(int i=0;i<huffmanCode.length;i++){//��huffman����������
			System.out.print("Ȩ��Ϊ��"+huffmanCode[i].weight+"\t");
			System.out.print("����Ϊ��");
			for(int j=huffmanCode[i].start;j<huffmanCode[i].MaxN;j++){//���εĴ�huffman���������ж�������
				System.out.print(huffmanCode[i].bit[j]);
			}
			System.out.println();
		}*/
		//���Դӱ��ض����ļ�
		System.out.println("���Դӱ��ض����ļ�");
		CountNum cn=new CountNum();
		ArrayList wordWeight=(ArrayList) cn.count();
		char []word=(char[])wordWeight.get(0);//ȡ���ַ�
		int []weight=(int[])wordWeight.get(1);//ȡ��Ƶ��
		//���Գ�ʼ��
		System.out.println("���Գ�ʼ��");
		HuffmanCode huffcode=new HuffmanCode();
		HuffNode []node=new HuffNode[2*weight.length-1];//�����ڵ�
		for(int i=0;i<2*weight.length-1;i++){//�Խڵ���г�ʼ��
			node[i]=new HuffNode();
		}
		HuffNode []huffnode=huffcode.initHuffmanTree(weight, node, word);
		//test para
//		for(int i=0;i<huffnode.length;i++){
//			System.out.println(huffnode[i].leftChild+", "+huffnode[i].rightChild+", "+"value:"+huffnode[i].value+", "+"weight: "+huffnode[i].weight);
//		}
		
		
		//�������Ľ���
		System.out.println("����huffman������");
		System.out.println("huffnode.length:"+huffnode.length);
		HuffNode []treenode=huffcode.constructHuffTree(huffnode);
		//����huffman����
		System.out.println("����huffman����");
		Code []code=new Code[(treenode.length+1)/2];
		for(int i=0;i<code.length;i++){//�Դ�ű����������г�ʼ����
			code[i]=new Code();
		}
		Code []huffmanCode=huffcode.huffCode(treenode, (treenode.length+1)/2,code);
		/**
		 * ����漰��huffman���������ĵĲ��֣�Ҳ���ǵõ���ÿ���ַ���huffman����֮�����ȥ���ԭ����ͳһ��8λ��ASCII����
		 * ���ǵ������ǽ�huffman���밴��˳����룬Ҳ����һ��8λ�Ķ��������У�Ȼ��Ҫ���ľ��ǽ��������������ת��ΪASCII����
		 * �����֮ǰͳһ����8λ�����ĳЩԪ�ش�8λ���߸��࣬����Щ�������1��2λ�͹��ˣ����Ա�ʾ��
		 * ������Ҫ���ľ��Ƕ��ļ�����ÿ���ַ��Ķ�Ӧ��huffman����õ�����������ת��Ϊʮ���ƺ���
		 */
		
		
		for(int i=0;i<huffmanCode.length;i++){//��huffman����������
			System.out.print("�ַ���"+word[i]+"\t");
			System.out.print("Ȩ��Ϊ��"+huffmanCode[i].weight+"\t");
			System.out.print("����Ϊ��");
			for(int j=huffmanCode[i].start;j<huffmanCode[i].MaxN;j++){//���εĴ�huffman���������ж�������
				System.out.print(huffmanCode[i].bit[j]);
			}
			System.out.println();
		}
		//�����ļ�����ѹ��
		System.out.println("�����ļ�����ѹ��");
		cn.writeFile(word, huffmanCode);
		//���ļ����н�ѹ��
		cn.decompression(treenode);
		
		
//		char r='6';
//		cn.decToBinary(r);
		
		
		
		
		
		
		//���Զ�������ʮ����ת������
//		String s="01001001";
//		int r=cn.binaryToDec(s);
//		System.out.println("binary to dec:"+r);
//	
	}

}
