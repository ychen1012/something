package bigInteger;

 public class BigInteger2{
	

public static String bigNumberSum(String num1, String num2) {  
        // ���ķ���  
        char sign = '+';  
  
        char sign1 = num1.charAt(0);  
        char sign2 = num2.charAt(0);  
  
        String number1 = "";  
        String number2 = "";  
  
        // ȥ����λ����  
        if (sign1 == '-' || sign1 == '+') {  
            number1 = num1.substring(1);  
        } else {  
            sign1 = '+';  
            number1 = num1;  
        }  
        // ȥ����λ����  
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
        // ������ӽ���Ϊ��������ĳ���+1
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
  
        // ͬ����ֱ�����  
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
            // �����λ  
            for (int i = 0; i < len; i++) {  
                if (result[i] >= 10) {  
                    result[i + 1] += result[i] / 10;  
                    result[i] = result[i] % 10;  
                }  
            }  
  
        } else {// ������,���length1>length2,�ó�������ȥС����  
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
                    // �ô������ȥС����  
                 
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
            // �����λ  
            for (int i = 0; i < len; i++) {  
                if (result[i] < 0) {  
                    result[i] += 10;  
                    result[i + 1]--;  
                }  
            }  
  
        }  
  
        // ���û�н�λʱ��0����  
        boolean flag = true;  
        StringBuffer resultStr = new StringBuffer();  
  
        for (int i = result.length - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            }  
            	flag = false;  
            resultStr.append(result[i]);  
        }  
  
        // ���Ŵ���  
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
