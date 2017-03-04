package bigInteger;
//关于String类型转成 Int的方法；

import java.util.ArrayList;
import java.util.LinkedList;

public class bb {
	public static void main(String[] args){
		String a="12234";
		StringBuffer f=new StringBuffer(a);
		LinkedList azzz=new LinkedList();
		for(int i=0;i<f.length();i++){
			azzz.add(f.charAt(i));
			System.out.println(Integer.parseInt(azzz.get(i).toString()));
		}
		

		//f.toString().toCharArray();
		
	}

}
