package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.structure.TripleNode;

public class StoreMatrix {
	/**
	 * �����Խ�ϡ������еķ���Ԫ������Ԫ��Ľṹ�洢�����������и����������������ʽ��ŵĻ���
	 * ÿ�λ�õĵ����ڵ�ķ��ʻ�������⣬���ֱ��ʹ�þ�̬�洢�ķ�ʽ����ô������Ҫ�������󣬵õ���0Ԫ�صĸ���֮����ܹ�����
	 * ȷ�еĿռ䡣Ҳ����ʱ�临�ӶȻ���o(2*N^2)��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]nums={{0,0,11,0,17,0,0},{0,25,0,0,0,0,0},{0,0,0,0,0,0,0},{19,0,0,0,0,0,0},{0,0,0,37,0,0,0},{0,0,0,0,0,0,50}};
		List <TripleNode>result=new ArrayList<TripleNode>();
		for(int i=0;i<nums.length;i++){//�б�
			for(int j=0;j<nums[i].length;j++){//�б�
				if(nums[i][j]!=0){
					TripleNode node=new TripleNode(i,j,nums[i][j]);
					result.add(node);//�����е�Ԫ�ش����һ����̬��������
				}
			}
		}
		//���õ���Ԫ�����
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).getRow()+" ,"+result.get(i).getCol()+" ,"+result.get(i).getValue());
		}
		
	}

}
