package cn.dmai.frame.config;

import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author linchengdong
 * @Date 2023-11-29 18:53
 * @PackageName:cn.dmai.frame.config
 * @ClassName: CorsFilter
 * @Description: 跨域
 * @Version 1.0
 */
@WebFilter(urlPatterns = "*")
public class CorsFilter implements Filter {

    private static final String HTTP_METHOD_OPTIONS = "OPTIONS";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
         * 跨域请求头服务端配置：
         * 1.Access-Control-Allow-Origin：设置允许跨域的配置， 响应头指定了该响应的资源是否被允许与给定的origin共享
         * 2.Access-Control-Allow-Credentials：响应头表示是否可以将对请求的响应暴露给页面（cookie）。返回true则可以，其他值均不可以。
         * 3.Access-Control-Allow-Headers:用于预检请求中，列出了将会在正式请求的 Access-Control-Request-Headers 字段中出现的首部信息。（自定义请求头）
         * 4.Access-Control-Allow-Methods：在对 预检请求的应答中明确了客户端所要访问的资源允许使用的方法或方法列表。
         */
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, access-token");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, PUT, DELETE, POST, OPTIONS");
        if (HTTP_METHOD_OPTIONS.equals(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpStatus.ACCEPTED.value());
            httpResponse.getWriter().close();
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
