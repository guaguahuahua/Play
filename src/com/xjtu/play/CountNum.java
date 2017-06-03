package com.xjtu.play;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.xjtu.structure.Code;
import com.xjtu.structure.HuffNode;

public class CountNum {
	public static StringBuilder sb=new StringBuilder();
	public List count(){
		//读入文件
		String path="D:/Temp/eclipseTemp/huffman.txt";
		File file=new File(path);
//		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String line="";
			while((line=bf.readLine())!=null){
				sb.append(line);
			}
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb);
		//从文件中统计各个字符的出现频率；使用哈希表的方式
		int [][]table=new int[128][2];//将出现的字符用整数形式表示出来，使用的时候转化为char类型
		
		for(int i=0;i<sb.length();i++){//统计所有的元素,并且要统计所有使用过的元素来决定整个数组的长度
			++table[sb.charAt(i)][1];//这块使用了128*2的数组，前面的序号表示字符它们的ASCII码，后面表示该字符出现的次数
		}
		int length=0;
		for(int i=0;i<128;i++){//统计哈希表中使用过字符的个数
			if(table[i][1]!=0){
				length++;
			}
		}
		System.out.println("length="+length);
		//根据length得到长度值向主方法返回一个确定的有序权值表
		int []weight=new int[length];
		char[]word=new char[length];
		for(int i=0,j=0;i<table.length;i++){
			if(table[i][1]!=0){
				word[j]=(char)i;//存放字符
				weight[j++]=table[i][1];//存放权值
			}
		}
		List result=new ArrayList();
		result.add(word);
		result.add(weight);		
/*		//test para:success
		for(int i=0;i<word.length;i++){
			System.out.println(word[i]+"\t"+weight[i]);
			
		}
		
		//test para
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[i].length;j++){
				System.out.print(table[i][j]);
			}
			System.out.println();
		}*/
		return result;
	}
	/**
	 * 将二进制的串转化为十进制的ASCII码然后存放，因为该码一共是8位但使用的只有7位
	 * 最高位位0，所以传递参数的时候应该注意读入7位数但是第一个自动补0
	 * @param s
	 * @return
	 */
	public static int binaryToDec(String s){
		int sum=0;
		for(int i=1;i<s.length();i++){
			sum+=(s.charAt(i)-'0')*Math.pow(2,s.length()-1-i);
		}
		return sum;
	}
	/**
	 *读入原来的ASCII字符，按照huffman编码形式转化，并将结果写入文本 
	 */
	public static void writeFile(char []word,Code[] code){
		String writePath="D:/Temp/eclipseTemp/write.txt"; 	
		File file=new File(writePath);
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<sb.length();i++){//所有的ASCII字符全部存放在这里，需要挨个遍历
			
			for(int j=0;j<word.length;j++){//针对当前字符，搜索整个建树字符
				if(sb.charAt(i)==word[j]){//如果当前的字符和建树字符一致，那么将该字符对应的huffman编码书写出来
					for(int k=code[j].start;k<code[j].MaxN;k++){//得到huffman编码存放在字符串缓冲池中
						builder.append(code[j].bit[k]);
					}
					break;
				}
			}
		}
		//需要对最后遗留下来的字符串左特殊处理，不是8位，最后不会输出出来
		System.out.println("字符的huffman编码形式："+builder.toString());
		try {
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			String tmp="0";//这块人为的添加了一个0，主要是为了补齐8个位置
			int count=1;
			for(int i=0;i<builder.length();i++){//所有生成的ASCII码全部在builder中存放，现在开始每8位计算ASCII码病写入到输出文件中
				if(count%8==0){//如果是添加了7位字符
					System.out.println("输出一个裁剪过的编码："+tmp);
					int r=binaryToDec(tmp);
					System.out.println("二进制码转化为ACSCII:"+(char)r);
					bw.write((char)r);//将该数转化为ASCCII码的字符形式存入到文件中
					bw.flush();
					tmp="0";//复位
					count=1;
					--i;
				}else{
					tmp=tmp+builder.charAt(i);
					++count;
				}
			}
			//处理最后一个元素，因为最后一个元素很有可能是因为不足8位导致无法输出，所以需要做的就是进行补位，将长度
			//补充至8位之后再次进行输出
			String zero="00000000";
			tmp=zero.substring(0,8-tmp.length())+tmp;//裁剪0元素来补充tmp
			int r=binaryToDec(tmp);
			System.out.println("二进制码转化为ACSCII:"+(char)r);
			bw.write((char)r);//将该数转化为ASCCII码的字符形式存入到文件中
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 对压缩的文件进行还原
	 */
	public static void decompression(HuffNode[] treenode){
		String path="D:/Temp/eclipseTemp/write.txt";
		File file=new File(path);
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line="";
			while((line=bf.readLine())!=null){//读压缩文件将其中的字符全部获得
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("读压缩文件：");
		System.out.println(sb.toString());
		

		//将读出的字符一个一个的转化很慢，也会很复杂，所以要做的就是，将所有的字符全部转化为二进制串，然后读二进制串恢复出字符
		StringBuilder binString=new StringBuilder();
		for(int i=0;i<sb.length();i++){
			String tmp=decToBinary(sb.charAt(i));
			binString.append(tmp);
		}
		System.out.println("二进制串："+binString);
		//将上面的二进制串，根据huffman树进行还原，也就是说从
		int i=0;
		HuffNode test=new HuffNode();//测试用变量
		StringBuilder rewrite=new StringBuilder();
		while(i<binString.length()){
			HuffNode traverse=treenode[treenode.length-1];//获取到根节点
			while(i<binString.length() && traverse.leftChild!=-1 && traverse.rightChild!=-1){//遍历到根节点上面
				if(binString.charAt(i++)=='1'){
					traverse=treenode[traverse.rightChild];
				}else{
					traverse=treenode[traverse.leftChild];
				}
				test=traverse;
			}
			rewrite.append(test.value);			
//			System.out.print(test.value);//非常诡异，可能是内部机理的问题，如果提前输出了，那么文件就无法写入。			
		}
		//将文件写入到文本文档中
		String filepath="D:/Temp/eclipseTemp/decompression.txt";
		File filename=new File(filepath);
		try {
			BufferedWriter dec=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
			dec.write(rewrite.toString());
			dec.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rewrite:"+rewrite.toString());
		System.out.println();
	}
	/**
	 * 将十进制数转化为二进制串的形式
	 * @param num
	 * @return
	 */
	public static String decToBinary(int num){
		String result="";
		while(num!=0){
			int tmp=num%2;
			result=tmp+result;
			num/=2;
		}
		String zero="00000000";
		if(result.length()<7){
			result=zero.substring(0,7-result.length())+result;//将不够的位数进行不足，防止丢失0元素，因为在huffman遍历中0是必要的
		}
		System.out.println("十进制转化为二进制串："+result);		
		return result;
	}
}
