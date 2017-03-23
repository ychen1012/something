
package test;

public class Sort {
	public void sorts(double[] a){
		boolean s=false;
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
			if(a[j]>a[1+j]){
				double tmp;
				tmp=a[j];
				a[j]=a[j+1];
				a[j+1]=tmp;
			}
			}
		}
			for(int i1=0;i1<a.length;i1++){
				System.out.println(a[i1]+" ");
			}
		}
	
			
			
		
		public static void main(String[] args){
			
		
			Sort sw=new Sort();
			double[] ss={8,7,4,5,1};
			sw.sorts(ss);
		}
		
	}


