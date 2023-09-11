import java.util.Scanner;

/*
 * 피보나치 수열이란 처음 두 항을 1과 1로 한 후, 
 * 그 다음 항부터는 바로 앞의 두 개의 항을 더해 만드는 수열을 말한다.
*/

//public class fibo {
//	public int fibonacci(int n) {
//		if(n < 0) {
//			System.out.println(n);
//			return n;	
//		}
//		if(n <= 1) {
//			System.out.println(n);
//			return n;
//		}
//		int f1 = 0;
//		int f2 = 1;
//		int fn = 0;
//		for(int i=2; i<=n; i=i+1) {
//			fn = f1+f2;
//			f1 = f2;
//			f2 = fn;
//		}
//		return fn;
//	}
//	
//	public static void main(String[] args) {
//		fibo fb = new fibo();
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("n 입력 : ");
//		int n = sc.nextInt();
//		 
//		fb.fibonacci(n);
//	}
//}

public class fibo {
	public int fibonacci(int n) {
		if(n < 0) {
			System.out.println(n);
			return n;	
		}
		if(n <= 1) {
			System.out.println(n);
			return n;
		}
		int f1 = 0;
		int f2 = 1;
		int fn = 0;
		for(int i=2; i<=n; i=i+1) {
			fn = f1+f2;
			f1 = f2;
			f2 = fn;
		}
		return fn;
	}
	
	public static void main(String[] args) {
		fibo fb = new fibo();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("n 입력 : ");
		int n = sc.nextInt();
		 
		fb.fibonacci(n);
	}
}
