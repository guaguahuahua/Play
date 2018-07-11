package com.interview;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

	//需要存放起止时间，初始化的过程就是初始化存放集合，判断过程就是不断的比对和集合中的元素是否有冲突
//	private List<String> schedual;
	//这块比较耳目一新，因为是在list当中添加了数组作为元素，这样对于一些有序数对或者是其他的情形都是比较好的解决方案
	private List<int[]> schedual;
	
    public MyCalendar() {
        schedual=new ArrayList<int[]>();
    }
    
    /**
     * 下面这个算法最终会导致测试用例出现问题，无法完全通过
     * @param start
     * @param end
     * @return
     */
/*    public boolean book_1(int start, int end) {
    	//如果当前的集合为空，那么直接将需要添加的元素添加到集合中，并返回为true
    	if(schedual.size()==0){
    		schedual.add(start+" "+end);
    		return true;
    	//否则对集合中的元素挨个进行一个判断	
    	}else{
    		for(int i=0; i<schedual.size(); i++){
        		String temp=schedual.get(i);
        		String[]times=temp.split("\\s+");
        		int s=Integer.parseInt(times[0]);
        		int e=Integer.parseInt(times[1]);
        		if((s<=start && start<e) || (s<end && end<=e)){
        			return false;
        		}
        	}
    		//判断的整个过程都没有退出说明是合理的，添加到日程表，并返回true
    		schedual.add(start+" "+end);
    		return true;
    	}    	        
    }*/
	
    public boolean book(int start, int end) {
    	//如果结果集是空的，直接将日程添加进去，并return true
    	if(schedual.size()==0){
    		schedual.add(new int[]{start, end});
    		return true;

    	//如果结果集不为空，那么将所有的元素和要新建的日程进行比较，比较过后，如果不发生冲突，那么添加进入，否则返回false	
    	}else{
    		for(int i=0; i<schedual.size(); i++){
    			int []time=schedual.get(i);
    			int s=time[0];
    			int e=time[1];
    			//不冲突的情形，添加日程没有在任何之内
    			if(end<=s || start>=e){
    				continue;
    			}
    			return false;
    		}
    		schedual.add(new int[]{start, end});
    		return true;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalendar obj=new MyCalendar();
		
		boolean res1=obj.book(47, 50);
		boolean res2=obj.book(33, 41);
		boolean res3=obj.book(39, 45);
		boolean res4=obj.book(33, 42);
		boolean res5=obj.book(25, 32);		
		boolean res6=obj.book(26, 35);
		boolean res7=obj.book(19, 25);
		boolean res8=obj.book(3, 8);
		boolean res9=obj.book(8, 13);
		boolean res10=obj.book(18, 27);
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		System.out.println(res4);
		System.out.println(res5);
		System.out.println(res6);
		System.out.println(res7);
		System.out.println(res8);
		System.out.println(res9);
		System.out.println(res10);
		
	}

}
