package com.xjtu.structure;

public class SeqNode {
	int value;
	int prior;
	
	public SeqNode(int value,int prior){
		this.prior=prior;
		this.value=value;
	}

	public int getValue() {
		return value;
	}


	public int getPrior() {
		return prior;
	}

}
