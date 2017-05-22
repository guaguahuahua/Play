package com.xjtu.play;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ActorCount {

	/**
	 * 统计男性和女性演员中各自搜索热度最高的演员
	 */
	public static void count(){
		
		String path="D:/Temp/eclipseTemp/actor.txt";
		String hotF="";
		String hotM="";
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			String line="";
			while((line=bf.readLine())!=null){
				String []infor=line.split("\\s+");//0：姓名		1：性别		2:搜索数目				
				if(infor[1].equals("female")){//如果是女性，那么和当前最大的值进行比较
					String []female=hotF.split("\\s+");
					if(hotF.equals("")){
						hotF=line;
					}else{
						if(Integer.parseInt(female[2])<Integer.parseInt(infor[2])){
							hotF=line;
						}
					}
				}else{//如果是男性，那么需要和男性当前的最大值进行比较
					String []male=line.split("\\s+");
					if(hotM.equals("")){
						hotM=line;
					}else{
						if(Integer.parseInt(male[2])<Integer.parseInt(infor[2])){
							hotM=line;
						}
					}

				}
			}
			bf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hotF);
		System.out.println(hotM);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count();
	}

}
