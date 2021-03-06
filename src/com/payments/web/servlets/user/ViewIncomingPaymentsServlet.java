package com.payments.web.servlets.user;

import com.payments.model.User;
import com.payments.utilites.Pages;
import com.payments.service.impl.IncomingPaymentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ViewIncomingPaymentsServlet
 */
public class ViewIncomingPaymentsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2960672444859549101L;
	
	private static final IncomingPaymentServiceImpl INCOMING_PAYMENT_SERVICE = IncomingPaymentServiceImpl.getInstance();

    private static final String DEFAULT_ORDER_BY = "date";
    private static final String JSP_REFERENCE = "/WEB-INF/user/viewIncomingPayments.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = ((User) request.getSession().getAttribute("user")).getId();
        Pages.doPagination(request, INCOMING_PAYMENT_SERVICE, userId,DEFAULT_ORDER_BY, "incoming_payments");
        request.getRequestDispatcher(JSP_REFERENCE).forward(request, response);
    }
}
