import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] monthToDate = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; //3월 1일: 60, 11월 30일 334
		int endDate = 60;
		int minFlower = 0;
		List<ArrayList<Integer>> flowers = new ArrayList<ArrayList<Integer>>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(monthToDate[Integer.parseInt(st.nextToken())] + Integer.parseInt(st.nextToken()));
			tempList.add(monthToDate[Integer.parseInt(st.nextToken())] + Integer.parseInt(st.nextToken()));
			flowers.add(tempList);
		}
		
		Collections.sort(flowers, (o1, o2)->{
			return Integer.compare(o1.get(0), o2.get(0));
		});
		
		boolean flag = false;
		int tempMaxEndDate = 0; 
		for (int i = 0; i < N; i++) {
			if (flowers.get(i).get(0) <= endDate) {
				flag = true;
				tempMaxEndDate = Math.max(tempMaxEndDate, flowers.get(i).get(1));
			}
			
			else {
				if (!flag) break;
				i--;
				endDate = tempMaxEndDate;
				flag = false;
				minFlower++;
				if (endDate > 334) {
					flag = true;
					break;
				}
			}
		}
		
		if (endDate <= 334) {
			if (tempMaxEndDate > 334) {
				minFlower++;
				flag = true;
			}
			else {
				flag = false;
			}
		}
	
		System.out.println(flag? minFlower: 0);
	}

}