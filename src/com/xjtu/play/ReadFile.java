package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadFile {

	public static void myReadFile(){
		String path="D:/Temp/eclipseTemp/job.txt";
		List<String> tmp=new ArrayList<String>();
		try {
			FileReader reader=new FileReader(path);
			BufferedReader bf=new BufferedReader(reader);
			String line="";
			while((line=bf.readLine())!=null){
				tmp.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//对于得到的数据 ：“美团    3-5年经验   15-30k 北京”进行分割，并作出归并
		Map <String,String>map=new HashMap<String,String>();
		for(int i=0;i<tmp.size();i++){
			
			String []job=tmp.get(i).split("\\s+");//得到：3-5年经验   15-30k
			if(map.size()==0){//当map为空的时候，直接写入
				map.put(job[1], job[2]);
				continue;
			}
			boolean t_pan=map.get(job[1])==null ? false : true;
			if(!t_pan){//如果没有该项，那么直接存储到map集合中，如果有，那么对value的上下界进行修改
				map.put(job[1], job[2]);
			}else{
				String salary=map.get(job[1]);//取出之前存储的value，也就是工资的范围值，做些更新
				salary=salary.substring(0, salary.length()-1);//这是为了消除最后的 字符‘k’
				String []pre=salary.split("\\-");//获得之前的工资范围值
				
				salary=job[2].substring(0, job[2].length()-1);//这是为了消除最后的 字符‘k’
				String []present=salary.split("\\-");//的工资范围值
				
				if(Integer.parseInt(present[0])<Integer.parseInt(pre[0])){//如果存在比当前工资下线还要小的，那么更新一下
					pre[0]=present[0];
				}
				if(Integer.parseInt(present[1])>Integer.parseInt(pre[1])){//若存在比当前工资上限还要高的，也要更新一下
					pre[1]=present[1];
				}
				map.put(job[1],pre[0]+"-"+pre[1]+"k");
			}
		}
		
		Set key=map.keySet();
		Iterator it=key.iterator();
		while(it.hasNext()){
			String year=(String) it.next();
			String sal=map.get(year);
			System.out.println(year+"   "+sal);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myReadFile();
	}

}
