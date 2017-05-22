package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountMailbox {

	public static void countMailbox(){
		String path="D:/Temp/eclipseTemp/mail.txt";
		List<String> result=new ArrayList<String>();
		try {
			FileReader reader=new FileReader(path);
			BufferedReader bf=new BufferedReader(reader);//文件进来之后首先是放在缓冲区的。
			String line="";
			//将缓冲区的文件读入
			while((line=bf.readLine())!=null){
				///对邮箱地址进行切割仅仅取得邮箱域名
				int index=line.indexOf('@');
				line=line.substring(index+1);
				index=line.indexOf('.');
				line=line.substring(0, index);
				
				if(result.size()==0){
					result.add(line);
					continue;
				}else{
					if(result.contains(line)){//如果存在了该域名，那么 继续
						continue;
					}else{//如果之前没有该域名，直接添加
						result.add(line);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String K:result){
			System.out.println(K);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countMailbox();
	}

}
