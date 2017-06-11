package com.xjtuse.rebuildHuff;

import java.util.List;

public class Encoding {
	/**
	 * 根据建立的huffman树进行huffman编码
	 * @param node
	 * @return 返回所有叶节点的编码数组
	 */
	public static Code[] encoding(HuffNode []node){
		//对n个叶节点进行遍历，得到对应的huffman编码
		int leaf=(node.length+1)/2;//得到叶节点的个数
		Code []code=new Code[leaf];//用来存放叶节点的编码
		for(int i=0;i<code.length;i++){
			code[i]=new Code();
		}
		for(int i=0;i<leaf;i++){
			
			StringBuilder sb=new StringBuilder();
			int child=i;
			int parent=node[child].parent;
			while(parent!=-1){
				if(node[parent].leftChild==child){
					sb.append('0');
				}else if(node[parent].rightChild==child){
					sb.append('1');
				}
				child=parent;
				parent=node[child].parent;
			}
			
			code[i].ch=node[i].value;
			code[i].bincode=sb.reverse().toString();
			code[i].weight=node[i].weight;
		}
		System.out.println("查看编码的效果：");
		for(int i=0;i<code.length;i++){
			System.out.print(code[i].ch+", "+code[i].bincode);
			System.out.println();
		}
		return code;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		Scanning scan=new Scanning();
		Extract extract=new Extract();
		Initiation init=new Initiation();
		List r1=extract.extractInfor(scan.scanning(filePath));
		HuffNode []nodes=init.initHuffTree(r1);
		HuffNode []node=init.treeBuilding(nodes);
		encoding(node); 
	}

}
