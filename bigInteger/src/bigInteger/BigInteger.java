package bigInteger;

import java.util.ArrayList;
import java.util.LinkedList;

public class BigInteger {

public static String bigNumbers(String number1,String number2){
	char sign ='+';//符号默认为加法
	char sign1=number1.charAt(0);
	char sign2=number2.charAt(0);
	String numbers1;
	String numbers2;
//去掉符号；
if(sign1 == '-'||sign1 == '+'){
	numbers1 = number1.substring(1);//从符号后一位开始
	}else{
		sign1='+';
		numbers1 =number1.substring(0);
	}
if(sign2=='-'||sign2=='+'){
	numbers2=number2.substring(1);
	
}else{
	sign2='+';
	numbers2=number2.substring(0);
}
int length1=numbers1.length();
int length2=numbers2.length();
int length;
if(length1>=length2){
	length=length1+1;
}else{
	length=length2+1;
}
int[] result = new int[length];

 

