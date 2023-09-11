package kr.s24.object.supertest;

//부모클래스
class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return "x:" + x + ",y:" + y;
	}
}
//자식클래스
class Point3D extends Point{
	int z;
	
	public Point3D(int x, int y, int z) {
		super(x,y);
		
		this.z = z;
	}
	
	//메서드 오버라이딩
	@Override
	public String getLocation() {
		return "x:" + x + ", y:" + y + ", z:" + z;
	}
}
public class SuperMain06 {
	public static void main(String[] args) {
		//객체 선언 및 생성
		Point3D p3 = new Point3D(10,20,30);
		//getLocation 메서드 호출
		System.out.println(p3.getLocation());
	}
}




