package com.xjtu.play;

/**
 * ������ѭ����С��������С��ת��Ϊ������ʾ��ʽ������Ҫ�������ʾ��ʽ��������ʽ
 * @author 22847
 */
public class FloatTofenshu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1.555555";
		String result=floatTofenshu(str);
		System.out.println(result);
	}
	/***�ܼ��������ͣ�һ������С����һ��������ѭ��С����������������ʽ���ٿ��ǵķ�Χ֮��
	 * ��������С�� 0.3��ֱ��ת����
	 * ��������ѭ����С�� 0.312(333),С�����б�ʾΪѭ����
	 * @param n
	 * @return
	 */
	public static String floatTofenshu(String str){
		//�����ж��ǲ�������ѭ����С��
		int fzi=0;
		int fmu=0;
		int com=0;
		if(str.charAt(str.length()-1)==')'){//����ѭ��С������ʽ
			//�Ҵ�ѭ��С����ѭ���ڲ���
			int begin=str.indexOf('(');
			String cir=str.substring(begin+1,str.length()-1);//ȡ��ѭ���ڲ��ֵ�����
			String []tmp=str.split("\\.");//tmp0���������֣�tmp1��С������(��ѭ���ں�ѭ����)
			String xiao=tmp[1].substring(0,tmp[1].indexOf('('));

			fzi=(int) (Integer.parseInt(xiao)*Math.pow(10,cir.length())+Integer.parseInt(cir));
			fmu=(int) ((Math.pow(10,cir.length())-1)*Math.pow(10,xiao.length()));
			com=Gcd.gcd(fzi, fmu);
			fmu=fmu/com;
			fzi=fzi/com+Integer.parseInt(tmp[0])*fmu;
		}else{//����С��
			String []tmp=str.split("\\.");//tmp[0]���������֣�tmp[1]��С������
			fmu=(int) Math.pow(10, tmp[1].length());//��ĸ����ֱ��ת��Ϊ�ٷ�֮��ʽ
			fzi=Integer.parseInt(tmp[1]);//��ԭ���ķ���ת��Ϊ������ʽ
			com=Gcd.gcd(fzi, fmu);//�����Լ��
			fmu=fmu/com;//�����ĸ
			fzi=fzi/com+Integer.parseInt(tmp[0])*fmu;//������ӣ����������ֲ�Ϊ0��ת��Ϊ�ٷ�����ʽ
		}
		return fzi+"/"+fmu;//�Է�������ʽ��������ֵ
	}
}
