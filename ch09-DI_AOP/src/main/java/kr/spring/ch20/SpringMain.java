package kr.spring.ch20;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		// applicationContext3.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAOP.xml");

		// 프로퍼티 이름을 이용한 의존관계 자동설정
		Product p = (Product) context.getBean("product");
		p.launch();

		context.close();
	}
}