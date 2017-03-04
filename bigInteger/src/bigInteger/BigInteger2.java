package bigInteger;

 public class BigInteger2{
	

public static String bigNumberSum(String num1, String num2) {  
        // 最后的符号  
        char sign = '+';  
  
        char sign1 = num1.charAt(0);  
        char sign2 = num2.charAt(0);  
  
        String number1 = "";  
        String number2 = "";  
  
        // 去符号位操作  
        if (sign1 == '-' || sign1 == '+') {  
            number1 = num1.substring(1);  
        } else {  
            sign1 = '+';  
            number1 = num1;  
        }  
        // 去符号位操作  
        if (sign2 == '-' || sign2 == '+') {  
            number2 = num2.substring(1);  
        } else {  
            sign2 = '+';  
            number2 = num2;  
        }  
  
     
  
        char[] chars1 = new StringBuffer(number1).reverse().toString().toCharArray();  
        char[] chars2 = new StringBuffer(number2).reverse().toString().toCharArray();  
  
        int length1 = number1.length();  
        int length2 = number2.length();  
        // 两数相加结果最长为求最长的数的长度+1
        int len;
        if(length1>=length2){
        	len=length1+1;
        }
        else{
        	len =length2+1;
        }
       // int len = length1 > length2 ? length1 + 1 : length2 + 1;  
        int[] result = new int[len];  
  
        
        boolean bigger;
if(length1>length2){
	bigger=true;
}else {
	bigger=false;
}
        //boolean longerIs1 = length1 > length2 ? true : false;
boolean longer =false;
if(length1>length2){
	longer=true;
}
  
        // 同号则直接相加  
        if (sign1 == sign2) {  
            sign = sign1;  
            if (bigger) {  
                for (int i = 0; i < length2; i++) {  
                    result[i] = (chars1[i] - '0') + (chars2[i] - '0');  
                }  
                for (int j = length2; j < length1; j++) {  
                    result[j] = (chars1[j] - '0');  
                }  
            } else {  
                for (int i = 0; i < length1; i++) {  
                    result[i] = (chars1[i] - '0') + (chars2[i] - '0');  
                }  
                for (int j = length1; j < length2; j++) {  
                    result[j] = (chars2[j] - '0');  
                }  
            }  
            // 处理进位  
            for (int i = 0; i < len; i++) {  
                if (result[i] >= 10) {  
                    result[i + 1] += result[i] / 10;  
                    result[i] = result[i] % 10;  
                }  
            }  
  
        } else {// 异号相加,如果length1>length2,拿长的数减去小的数  
            if (bigger) {  
                sign = sign1;  
                for (int i = 0; i < length2; i++) {  
                    result[i] = (chars1[i] - '0') - (chars2[i] - '0');  
                }  
  
                for (int j = length2; j < length1; j++) {  
                    result[j] = chars1[j] - '0';  
                }  
            } else {  
                if (length1 == length2) {  
                    // 拿大的数减去小的数  
                 
                	boolean lager =false;
                	if(number1.compareTo(number2)>0){
                		lager=true;
                	}
                    if (lager) {  
                        sign = sign1;  
                        for (int i = 0; i < length1; i++) {  
                            result[i] = (chars1[i] - '0') - (chars2[i] - '0');  
                        }  
                    } else {  
                        sign = sign2;  
                        for (int i = 0; i < length1; i++) {  
                            result[i] = (chars2[i] - '0') - (chars1[i] - '0');  
                        }  
                    }  
                } else {// length1<length2  
                    sign = sign2;  
                    for (int i = 0; i < length1; i++) {  
                        result[i] = (chars2[i] - '0') - (chars1[i] - '0');  
                    }  
  
                    for (int j = length1; j < length2; j++) {  
                        result[j] = chars2[j] - '0';  
                    }  
  
                }  
            }  
            // 处理借位  
            for (int i = 0; i < len; i++) {  
                if (result[i] < 0) {  
                    result[i] += 10;  
                    result[i + 1]--;  
                }  
            }  
  
        }  
  
        // 结果没有进位时的0处理  
        boolean flag = true;  
        StringBuffer resultStr = new StringBuffer();  
  
        for (int i = result.length - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            }  
            	flag = false;  
            resultStr.append(result[i]);  
        }  
  
        // 符号处理  
        if (sign == '-') {  
            return "-" + resultStr.toString();  
        } else {  
            return resultStr.toString();  
        }  
  
    }
public static void main(String[] args){
	BigInteger2 b=new BigInteger2();
	System.out.println(b.bigNumberSum("123", "321"));
	
}
}
