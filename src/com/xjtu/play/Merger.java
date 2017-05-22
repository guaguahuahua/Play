package com.xjtu.play;

import java.util.ArrayList;
import java.util.List;

public class Merger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []left= {1,4,6};
//		int []right={2,8,9};
		int []left= {2,1,3};
		int []right={3,2,9};
		merger(left,right);
	}
	/**
	 * 合并函数，将多个区间合并成，尽可能减少区间个数
	 * 传递进来两个参数，一个是区间的左边界，一个是区间的右边界
	 * 算法缺点：主要是针对区间已经是有序的才可用，如果区间是无序的，那么算法是无效的。如果要使用，那么需要提前进行排序
	 * @param left  
	 * @param right
	 */
	public static void merger(int []left,int []right){
		List result=new ArrayList();
		int l=left[0],r=right[0];
		for(int i=1;i<left.length;i++){
			if(left[i-1]<left[i] && right[i-1]>left[i]){        //主要是为了说明当前区间的左边界位于上个区间中间
				l=left[i-1];
				r=right[i];
			}else if(left[i-1]<right[i] && right[i]<right[i-1]){//这主要是说明当前区间的右边界位于上个区间内
				l=left[i];
				r=right[i-1];
			}else{												//主要说明了当下两个区间之间没有交集
				result.add("["+l+","+r+"]");
			}
		}
		result.add("["+l+","+r+"]");//这段主要是为了解决循环结束时，合并过的区间
		//test para
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+"\t");
		}
	}

}
