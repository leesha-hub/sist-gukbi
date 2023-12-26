package kr.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class AdminModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {//로그인 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		Integer user_auth = (Integer)session.getAttribute("user_auth");
		if(user_auth != 9) {//관리자로 로그인하지 않은 경우
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		int order_num = Integer.parseInt(
				          request.getParameter("order_num"));
		
		OrderDAO orderDao = OrderDAO.getInstance();
		OrderVO db_order = orderDao.getOrder(order_num);
		if(db_order.getStatus()>1) {
			//관리자가 주문정보를 수정하기 전에 사용자가 배송상태를 주문취소로 변경해서
			//배송지정보 수정 불가능
			request.setAttribute("notice_msg", 
				"사용자가 배송상태를 변경해서 관리자가 배송지정보를 수정할 수 없음");
			request.setAttribute("notice_url", 
					request.getContentType()
					+"/order/adminDetail.do?order_num="+order_num);
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		OrderVO order = new OrderVO();
		order.setOrder_num(order_num);
		order.setReceive_name(request.getParameter("receive_name"));
		order.setReceive_post(request.getParameter("receive_post"));
		order.setReceive_address1(
				       request.getParameter("receive_address1"));
		order.setReceive_address2(
				       request.getParameter("receive_address2"));
		order.setReceive_phone(
				       request.getParameter("receive_phone"));
		order.setNotice(request.getParameter("notice"));
		
		//배송지정보 수정
		orderDao.updateOrder(order);
		
		request.setAttribute("notice_msg", "정상적으로 수정되었습니다.");
		request.setAttribute("notice_url", 
				request.getContextPath()
				+"/order/adminDetail.do?order_num="+order.getOrder_num());
		
		return "/WEB-INF/views/common/alert_singleView.jsp";
	}

}



