package com.xjtuse.rebuildHuff;
/**
 * huffman 树节点的构建
 * 这是对之前工作的重构
 * @author 22847
 *
 */
public class HuffNode {
	public char value;	 	//节点存放的值
	public int leftChild;	//节点的左孩子
	public int rightChild; 	//节点的右孩子
	public int parent;  	//节点的父节点
	public int weight;		//节点的权重
	public int flag;
	
}
