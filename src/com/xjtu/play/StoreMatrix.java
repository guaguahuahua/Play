package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.structure.TripleNode;

public class StoreMatrix {
	/**
	 * 这块测试将稀疏矩阵中的非零元素以三元组的结构存储起来，但是有个问题就是用这种形式存放的话，
	 * 每次获得的单个节点的访问会出现问题，如果直接使用静态存储的方式，那么首先需要遍历矩阵，得到非0元素的个数之后才能够申请
	 * 确切的空间。也就是时间复杂度会变成o(2*N^2)；
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums={{0,0,11,0,17,0,0},{0,25,0,0,0,0,0},{0,0,0,0,0,0,0},{19,0,0,0,0,0,0},{0,0,0,37,0,0,0},{0,0,0,0,0,0,50}};
		List <TripleNode>result=new ArrayList<TripleNode>();
		for(int i=0;i<nums.length;i++){//行标
			for(int j=0;j<nums[i].length;j++){//列标
				if(nums[i][j]!=0){
					TripleNode node=new TripleNode(i,j,nums[i][j]);
					result.add(node);//将所有的元素存放在一个动态的链表中
				}
			}
		}
		//将得到的元素输出
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).getRow()+" ,"+result.get(i).getCol()+" ,"+result.get(i).getValue());
		}
		
	}

}
