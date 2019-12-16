package com.ignas.ex5_filters;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// @WebFilter(filterName = "performanceFilter", urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // measuring the time
        // long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        chain.doFilter(request, response);
        // long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        // System.out.println("Time: " + (endTime - startTime) + " milliseconds");

        // logging the time and the servlet targeted in the request
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String resourceName = httpRequest.getRequestURI();
            long time = endTime - startTime;
            System.err.println("Servlet: _" + resourceName + " took: " + time + " ns");
        }
    }

    @Override
    public void destroy() { }
}