package common.exception.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.CustomException;

/**
 * Servlet implementation class ExceptionHandler
 */
@WebServlet("/exception")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExceptionHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CustomException이 발생면 /exception 으로 요청이 재지정되어 해당 서블릿의 doGet이 호출
		//request 객체의 "javax.servlet.error.exception" 속성에 발생한 예외가 저장
		//Exception객체를 반환받아서 해당 객체에 저장되어있는 ErrorCode enum을 꺼내
		//사용자에게 보여줄 메세지와 이동시킬 페이지를 알 수 있다.
		
		CustomException e = (CustomException)request.getAttribute("javax.servlet.error.exception");
		
		request.setAttribute("msg", e.error.errMsg);
		request.setAttribute("url", e.error.url);
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
