package kr.s11.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookUserMain {
	private BufferedReader br;
	private BookDAO daoBook;
	private MemberDAO daoMember;
	private ReservationDAO daoReservation;
	private String me_id;//로그인한 아이디 저장
	private boolean flag;//로그인 여부
	private boolean admin_flag;//관리자 여부
	
	public BookUserMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			daoBook = new BookDAO();
			daoMember = new MemberDAO();
			daoReservation = new ReservationDAO();
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
			System.out.print("1.로그인, 2.회원 가입, 3.종료:");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) {// 로그인
					System.out.print("아이디:");
					me_id = br.readLine();
					System.out.print("비밀번호:");
					String me_passwd = br.readLine();
					
					flag = daoMember.loginCheck(me_id, me_passwd);
					if(flag) {
						admin_flag = daoMember.adminCheck(me_id);
						String adminStr = (admin_flag) ? "관리자 " : "";
						System.out.println(adminStr + me_id + "님 로그인 되었습니다.");
						break;
					}
					System.out.println("아이디 또는 비밀번호 불일치");
				} else if (no == 2) {// 회원 가입
					System.out.print("아이디:");
					String me_id = br.readLine();
					System.out.print("비밀번호:");
					String me_passwd = br.readLine();
					//아이디 중복 체크
					int check = daoMember.checkId(me_id);
					if(check == 1) {
						System.out.println("아이디가 중복되었습니다.");
					} else {
						System.out.print("이름:");
						String me_name = br.readLine();
						System.out.print("휴대전화번호:");
						String me_phone = br.readLine();

						boolean joinYN = daoMember.joinMember(me_id, me_passwd, me_name, me_phone);

						if (joinYN) {
							System.out.println("회원가입이 완료되었습니다.");
							break;
						}
						System.out.println("회원가입에 실패했습니다.");
					}
				}else if(no == 3) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}
		}
		if(admin_flag) {
			// 관리자로 접속한 경우, 관리자 패널 노출
			new BookAdminMain(me_id);
		} else {
			while(flag) {
				System.out.print("1.도서대출, 2.MY대출목록, 3.대출도서 반납, 4.종료>");
				try {
					int no = Integer.parseInt(br.readLine());
					if(no == 1) {//도서 대출
						daoBook.allBookList();
						System.out.println("[도서 대출하기]");
						System.out.print("도서 번호:");
						int bk_num = Integer.parseInt(br.readLine());
					
						//대출중인 도서인지 확인
						int count = daoReservation.checkLoan(bk_num);
						if(count <= 0) {
							//아닌 경우 대출로 상태 변경
							daoReservation.loanBook(me_id, bk_num);
							break;
						} 			
						System.out.println("도서 대출에 실패했습니다.");
					} else if(no == 2) {//MY대출목록
						daoReservation.loanList(admin_flag, me_id);
					}else if(no == 3) {//대출도서 반납
						daoReservation.loanList(admin_flag, me_id);
						System.out.println("[도서 반납하기]");
						System.out.print("도서 번호:");
						int bk_num = Integer.parseInt(br.readLine());
						daoReservation.givebackBook(bk_num);
					}else if(no == 4) {//종료
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
	}
	
	public static void main(String[] args) {
		new BookUserMain();
	}
}
