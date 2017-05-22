package com.xjtu.play;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Weibo {

	public static void countWeibo(){
		String path="D:/Temp/eclipseTemp/weibo.txt";
		FileReader reader;
		Map<String,Integer> fans=new HashMap<String,Integer>();
		Map<String,Integer> focus=new HashMap<String,Integer>();
		Map<String,Integer> weibo=new HashMap<String,Integer>();
		try {
			reader = new FileReader(path);
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			String line="";
			
			while((line=bf.readLine())!=null){//��Ҫ����ʵ���ݵĶ���
				//������һ������
				String []data=line.split("\\s+"); //0:����   	1��΢����		2����˿��   3:��ע��		4��΢����
				fans.put(data[0], Integer.parseInt(data[2]));
				focus.put(data[0],Integer.parseInt(data[3]));
				weibo.put(data[0], Integer.parseInt(data[4]));
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//���ݵ�value����
		List<Map.Entry<String,Integer>> fansSort=new ArrayList<Map.Entry<String,Integer>>(fans.entrySet());
		List<Map.Entry<String, Integer>> focusSort=new ArrayList<Map.Entry<String,Integer>>(focus.entrySet());
		List<Map.Entry<String, Integer>> weiboSort=new ArrayList<Map.Entry<String, Integer>>(weibo.entrySet());
		
		List []array={fansSort,focusSort,weiboSort}; 
		//��value��������,ѭ���ĶԷ�˿����ע����΢������������
		for(List K:array){
			
			Collections.sort(K,new Comparator<Map.Entry<String, Integer>>(){
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
					return o2.getValue()-o1.getValue();//���յ���˳��õ����
				}
			} );
		}

//		for(int i=0;i<fansSort.size();i++){
//			System.out.println(fansSort.get(i).getKey()+"::"+fansSort.get(i).getValue());
//		}
		
		//���ļ�������������Ϊ�������
		String fansFile="D:/Temp/eclipseTemp/fans.txt";
		String focusFile="D:/Temp/eclipseTemp/focus.txt";
		String weiboFile="D:/Temp/eclipseTemp/weiboFile.txt";
		String []paths={fansFile,focusFile,weiboFile};
		//���ź�����ļ��������
		try {
			for(int i=0;i<paths.length;i++){
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paths[i]),"UTF-8"));
				for(int j=0;j<array[i].size();j++){
					
					String str=((Entry<String, Integer>) array[i].get(j)).getKey();  //��list��ȡ���Ź��������
					str=str+":  "+((Entry<String, Integer>) array[i].get(j)).getValue();
					bw.write(str);
					bw.flush();
					bw.newLine();
				}
				bw.close();
			}
			System.out.println("executing at here!");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countWeibo();
	}

}
