package com.xjtuse.huff;

public class HuffNode {
	public int weight;
	public int flag;
	public int parent;
	public int leftChild;
	public int rightChild;
	public char value;
	
	public HuffNode(){
		this.weight=0;
		this.flag=0;
		this.parent=0;
		this.leftChild=0;
		this.rightChild=0;
	}
}
