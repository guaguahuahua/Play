package com.xjtuse.rebuildHuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 这块是对文本扫描信息进一步的处理，提纯，对后面仅提供与文本相关的信息
 * @author 22847
 */
public class Extract {
	/**
	 * 仅仅抽取文本字符信息，
	 * @param hash
	 */
	public static List extractInfor(int []hash){

		//使用map进行过滤，文本添加的过程为，ascII值和出现频率
		Map <Character,Integer>map=new HashMap<Character,Integer>();
		for(int i=0;i<hash.length;i++){
			if(hash[i]!=0){	//该字符在文本中出现过
				map.put((char)i,hash[i]);
			}
		}
		System.out.println();
		System.out.println("map size="+map.size());
		char []ch=new char[map.size()];
		int  []weight=new int[map.size()];
		
		//从map中将元素挨个提取出来
		Set key=map.keySet();
		Iterator it=key.iterator();
		int count=0;
		while(it.hasNext()){
			char tmp=(char) it.next();
			ch[count]=tmp;//将字符取出
			weight[count++]=(int)map.get(tmp);//将字符的频率取出来
		}

		//将结果用list封装好返回给下个调用方法
		List result=new ArrayList();
		result.add(ch);
		result.add(weight);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="D:/Temp/eclipseTemp/huffman.txt";
		Scanning scan=new Scanning();
		extractInfor(scan.scanning(filePath));
	}

}
