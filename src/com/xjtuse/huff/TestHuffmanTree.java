package com.xjtuse.huff;

import java.util.ArrayList;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class TestHuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		//测试huffman树初始化方法
		HuffmanCode huffcode=new HuffmanCode();
		int []weight={1,3,5,7};//权重数组
		HuffNode []node=new HuffNode[2*weight.length-1];//创建节点
		for(int i=0;i<2*weight.length-1;i++){//对节点进行初始化
			node[i]=new HuffNode();
		}
		//测试初始化
		System.out.println("测试初始化");
		HuffNode []huffnode=huffcode.initHuffmanTree(weight, node);
		//测试huffman树的建立，
		System.out.println("测试huffman树建立");
		System.out.println("huffnode.length:"+huffnode.length);
		HuffNode []treenode=huffcode.constructHuffTree(huffnode);
		
		//测试huffman编码的构建
		System.out.println("测试huffman编码");
		Code []code=new Code[(treenode.length+1)/2];
		for(int i=0;i<code.length;i++){//对存放编码的数组进行初始化，
			code[i]=new Code();
		}
		Code []huffmanCode=huffcode.huffCode(treenode, (treenode.length+1)/2,code);
		for(int i=0;i<huffmanCode.length;i++){//对huffman编码进行输出
			System.out.print("权重为："+huffmanCode[i].weight+"\t");
			System.out.print("编码为：");
			for(int j=huffmanCode[i].start;j<huffmanCode[i].MaxN;j++){//依次的从huffman编码数组中读出编码
				System.out.print(huffmanCode[i].bit[j]);
			}
			System.out.println();
		}*/
		//测试从本地读入文件
		System.out.println("测试从本地读入文件");
		CountNum cn=new CountNum();
		ArrayList wordWeight=(ArrayList) cn.count();
		char []word=(char[])wordWeight.get(0);//取得字符
		int []weight=(int[])wordWeight.get(1);//取得频率
		//测试初始化
		System.out.println("测试初始化");
		HuffmanCode huffcode=new HuffmanCode();
		HuffNode []node=new HuffNode[2*weight.length-1];//创建节点
		for(int i=0;i<2*weight.length-1;i++){//对节点进行初始化
			node[i]=new HuffNode();
		}
		HuffNode []huffnode=huffcode.initHuffmanTree(weight, node, word);
		//test para
//		for(int i=0;i<huffnode.length;i++){
//			System.out.println(huffnode[i].leftChild+", "+huffnode[i].rightChild+", "+"value:"+huffnode[i].value+", "+"weight: "+huffnode[i].weight);
//		}
		
		
		//测试树的建立
		System.out.println("测试huffman树建立");
		System.out.println("huffnode.length:"+huffnode.length);
		HuffNode []treenode=huffcode.constructHuffTree(huffnode);
		//测试huffman编码
		System.out.println("测试huffman编码");
		Code []code=new Code[(treenode.length+1)/2];
		for(int i=0;i<code.length;i++){//对存放编码的数组进行初始化，
			code[i]=new Code();
		}
		Code []huffmanCode=huffcode.huffCode(treenode, (treenode.length+1)/2,code);
		/**
		 * 这块涉及了huffman编码的最核心的部分，也就是得到了每个字符的huffman编码之后如何去替代原来的统一的8位的ASCII编码
		 * 我们的做法是将huffman编码按照顺序读入，也就是一个8位的二进制序列，然后要做的就是将这个二进制序列转换为ASCII码存放
		 * 相比于之前统一都存8位变成了某些元素存8位或者更多，而有些仅仅存放1，2位就够了，可以表示。
		 * 接下来要做的就是读文件，将每个字符的对应的huffman编码得到，将二进制转化为十进制后存放
		 */
		
		
		for(int i=0;i<huffmanCode.length;i++){//对huffman编码进行输出
			System.out.print("字符："+word[i]+"\t");
			System.out.print("权重为："+huffmanCode[i].weight+"\t");
			System.out.print("编码为：");
			for(int j=huffmanCode[i].start;j<huffmanCode[i].MaxN;j++){//依次的从huffman编码数组中读出编码
				System.out.print(huffmanCode[i].bit[j]);
			}
			System.out.println();
		}
		//将对文件进行压缩
		System.out.println("将对文件进行压缩");
		cn.writeFile(word, huffmanCode);
		//对文件进行解压缩
		cn.decompression(treenode);
		
		
//		char r='6';
//		cn.decToBinary(r);
		
		
		
		
		
		
		//测试二进制向十进制转化函数
//		String s="01001001";
//		int r=cn.binaryToDec(s);
//		System.out.println("binary to dec:"+r);
//	
	}

}
