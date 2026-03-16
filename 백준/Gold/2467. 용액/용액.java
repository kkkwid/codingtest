import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] sols=new int[N];
		
		for(int i=0; i<N; i++) {
			sols[i]=Integer.parseInt(st.nextToken());
		}

		int min=Integer.MAX_VALUE;
		int leftRes=0, rightRes=0;
		int left=0, right=N-1;
		
		while(left<right) {
			int sum=sols[left]+sols[right];
			
			if(min>Math.abs(sum)) {
				min=Math.abs(sum);
				leftRes=left;	rightRes=right;
			}
			//binary search
			if(sum>=0) {
				right--;
			}
			else {
				left++;
			}
		}
		
		System.out.println(sols[leftRes]+" "+sols[rightRes]);
	}
}