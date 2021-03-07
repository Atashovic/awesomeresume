package com.company.resume.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "JspFileFilter", urlPatterns = {"*.jsp"})
public class JspFileFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try{
            res.sendRedirect("error?msg=not found");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}


