package kr.s11.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookAdminMain {
	private BufferedReader br;
	private BookDAO daoBook;
	private MemberDAO daoMember;
	private ReservationDAO daoReservation;
	private String me_id;
	private boolean admin_flag;//관리자 여부
	
	public BookAdminMain(String meId) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			daoBook = new BookDAO();
			daoMember = new MemberDAO();
			daoReservation = new ReservationDAO();
			me_id = meId;
			admin_flag = daoMember.adminCheck(me_id);
			//메뉴 호출
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	//메뉴
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1.도서 등록, 2.도서 목록, 3.대출 목록, 4.회원 목록, 5.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//도서 등록
					System.out.print("도서명:");
					String bk_name = br.readLine();
					System.out.print("카테고리:");
					String bk_category = br.readLine();

					boolean flag = daoBook.registerBook(bk_name, bk_category);
					if (!flag) {
						System.out.println("도서 등록 실패");
					}
				} else if (no == 2) {// 도서 목록
					daoBook.allBookList();
				}else if(no == 3) {//대출 목록
					daoReservation.loanList(admin_flag, me_id);
				}else if(no == 4) {//회원 목록
					daoMember.allMemberList();					
				}else if(no == 5) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}
		}
	}
	
//	public static void main(String[] args) {
//		new BookAdminMain();
//	}
}






