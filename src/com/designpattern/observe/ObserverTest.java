package com.designpattern.observe;

/**
 * 观察者模式中，增加或者是删除观察者都是独立的，只要增加或者删除类即可达到，
 * 不用修改源代码
 * @author 22847
 *
 */
public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub=new MySubject();
		Observer1 observer1=new Observer1();
		sub.add(observer1);
		sub.add(new Observer2());
		sub.operations();
		sub.del(observer1);
		sub.operations();
	}

}
