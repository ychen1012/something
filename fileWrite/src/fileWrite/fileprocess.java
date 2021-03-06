package fileWrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class fileprocess {
	public String readTostring(String filePath,String encoding){
		File file= new File(filePath);
	Long fileLength = new Long(file.length());
		
		byte[] fileContent = new byte[fileLength.intValue()];
		try{
			FileInputStream in =new FileInputStream(file);
			in.read(fileContent);//读文件，intValue()即文本长度；
			in.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			return new String(fileContent,encoding);
			
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			System.err.println("????????");
			return null;
		}
		
	}
	public void writeStringToFile(String filepath,String fileContent){//写入文件（路径，文件）
		File f =new File(filepath);
		FileWriter fw;
		try {
			fw=new FileWriter(f);
			fw.write(fileContent);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList readFile2ArrayList(String filePath) throws IOException{
		ArrayList wordList =new ArrayList();//arraylist 写入 文本
		File inputfile =new File(filePath);
		FileReader fr=new FileReader(inputfile);
		BufferedReader br = new BufferedReader(fr);//Bufferedreader
		String s;
		while((s=br.readLine())!=null){
			String [] words =s.split(" ");
			for(int i=0;i<words.length;i++){
				if(!wordList.contains((words)[i])){
					wordList.add(words[i]);
				}
					
				}
			
			}
		fr.close();
		File f=new File("d://arraylist.txt","utf-8");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f));
		for(int i=0;i<wordList.size();i++){
			bw1.write(wordList.get(i).toString());
			bw1.newLine();
			//System.out.println(wordList.get(i).toString());
		}
		bw1.close();
		return wordList;
			
			
	
	}
	public static boolean bigger(String s1,String s2){
		int length1= s1.length();
		int length2= s2.length();
		  int m=0;
		while(m<length1&&m<length2){
			
			if (s1.charAt(m)>s2.charAt(m)){
				return true;}
			
		
			else if(s1.charAt(m)<s2.charAt(m)){
				return false;
			}else{
				m++;
			}
	}
		
		
		
		if(m==length1){
			return false;
		}else{
			return true;
		}
		 
	 }
	public void sorts(ArrayList a){
		int i=0;
		for(i=0;i<a.size()-1;i++){
			boolean sorts=false;
			for(int j=0;j<a.size()-i-1;j++){
				if(bigger((a.get(j).toString()),(a.get(j+1).toString()))){
					String tmp=a.get(j).toString();
				
					a.set(j, a.get(j+1).toString());
					a.set(j+1, tmp);
					sorts=true;
				}
			}
			if(!sorts){
				break;
				
			}
		}
		for(int k =0;k<a.size();k++){
			System.out.println(a.get(k).toString()+" ");
		}
		
	}
	public static void main(String[] args) throws IOException{
		fileprocess f=new fileprocess();
		String fileContent =f.readTostring("D:/first.txt", "utf-8");
		System.out.println(fileContent);
		String a="1111111111";
		//f.writeStringToFile("d://22.txt",a);
		f.readFile2ArrayList("D://20150101018432.txt");
		//ArrayList s = new ArrayList();
		//s.add("app");
		//s.add("b");
		//s.add("eclipse");
		//f.sorts(s);
	}
}
