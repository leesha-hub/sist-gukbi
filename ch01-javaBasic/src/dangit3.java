import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 N	stages	result
 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 4	[4,4,4,4,4]					[4,1,2,3]
*/

public class dangit3 {
	public static void main(String[] args) {
		int n = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int n = 4;
//		int[] stages = {4,4,4,4,4};

		Solution2 ss = new Solution2();
		ss.solution(n, stages);
	}
}

class Solution2 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[][] failRateArr = new float[N][2];
        
    	int failPersonCount = stages.length;
        for(int i=1; i<=N; i++) {
//        	failRateArr[i-1][0] = new float();
//        	failRateArr[i-1][1] = new ArrayList<Float>();
//        	
        	float failRate = 0.0f;
        	int failStageCount = 0;

        	for(int j=0; j<=stages.length-1; j++) {
        		if(stages[j] == i) {
        			failStageCount ++;
        		}  
        	}      
    		failRate = (float)failStageCount/failPersonCount;
    		failRateArr[i-1][0] = (i*1.0f);
    		failRateArr[i-1][1] = failRate;
    		
    		// 초기화
    		failPersonCount -= failStageCount;
    		failStageCount = 0;
		}
     
        // 정렬된 2차원 배열 출력
        for (int i = 0; i < N; i++) {
//        	System.out.println(failRateArr[i][0]);
        	System.out.println(failRateArr[i][0] + " / " + failRateArr[i][1]);
        	//answer[i] = failRateArr[i][0];
        }
        
        System.out.println("====================================");
       
        // 2차원 배열 정렬
        //sortTwoDArray(failRateArr);
       
        Arrays.sort(failRateArr, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
            	return (int) (o2[1]-o1[1]); // 배열의 0번 int값을 비교하여 오름차순 구현
            }
        });
        
        // 정렬된 2차원 배열 출력
        for (int i = 0; i < N; i++) {
//        	System.out.println(failRateArr[i][0]);
        	System.out.println(failRateArr[i][0] + " / " + failRateArr[i][1]);
        	//answer[i] = failRateArr[i][0];
        }
        return answer;
    }
    
//    public static void sortTwoDArray(List<Float>[][] array) {
//        // 각 행을 정렬
//        for (int i = 0; i < array.length; i++) {
//            Arrays.sort(array[i][0].toArray());
//            Arrays.sort(array[i][1].toArray());
//        }
//
//        // 전체 배열을 정렬
//        Arrays.sort(array, new Comparator<List<Float>[]>() {
//            @Override
//            public int compare(List<Float>[] o1, List<Float>[] o2) {
//                // 첫 번째 열의 첫 번째 값으로 비교 (원하는 비교 기준에 따라 변경 가능)
//                return Float.compare(o2[1].get(0), o1[1].get(0));
//            }
//        });
//    }
}