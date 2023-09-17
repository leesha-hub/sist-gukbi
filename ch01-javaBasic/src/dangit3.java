import java.util.Arrays;

/*
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
*/

public class dangit3 {
	public static void main(String[] args) {
		int[] lost = {1,2,3,4};
		int[] reserve = {4,3,2,1};
		
		Solution ss = new Solution();
		ss.solution(5, lost, reserve);
	}
}

class Solution {
   public int solution(int n, int[] lost, int[] reserve) {
      int answer = 0;

      int[] list = new int[n];
      for (int i = 0; i <= n-1; i++) {
         if (i <= lost.length - 1) {
            int findIndex = Arrays.binarySearch(reserve, lost[i]);
             if(findIndex >= 0) {
                list[reserve[findIndex]-1] = 1;
             } else {
                list[lost[i] - 1] = -1;
             }
         }
         if (i <= reserve.length - 1) {
            int findIndex = Arrays.binarySearch(lost, reserve[i]);
             if(findIndex >= 0) {
                list[lost[findIndex]-1] = 1;
             } else {
                list[reserve[i] - 1] = 2;
             }
         } 
         if(list[i] == 0) {
            list[i] = 1;
         }
//          System.out.println(list[i]);
      }
      
      for (int j = 0; j <= n-1; j++) { 
         boolean borrowYN = false;
         
         if(list[j] == -1) {
            // 앞 확인
            if (j > 0) {
               if (list[j-1] == 2) {
                  list[j] = 1;
                  list[j-1] = 1;
                  borrowYN = true;
                       continue;
               }
            }
            // 뒤 확인
            if (!borrowYN && j < list.length-1) {
               if (list[j+1] == 2) {
                  list[j] = 1;
                  list[j+1] = 1;
                  borrowYN = true;
                       continue;
               }
            }
         }
      }
      
      for (int i = 0; i <= list.length - 1; i++) {
         if (list[i] > 0) {
            answer++;
         }
      }
      return answer;
   }
}