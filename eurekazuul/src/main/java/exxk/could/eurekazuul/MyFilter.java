package exxk.could.eurekazuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";  //pre:路由之前,routing:路由之时,post:路由之后,error:发送错误调用
    }

    @Override
    public int filterOrder() {
        return 0;  //filterOrder:过滤的顺序
    }

    @Override
    public boolean shouldFilter() {
        return true;  //shouldFilter:这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    }

    @Override
    public Object run() throws ZuulException {
        //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        System.out.print("method:"+request.getMethod()+",url:"+request.getRequestURL().toString());
        Object token=request.getParameter("token");
        if (token==null){
            System.out.print("token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        System.out.print("ok");
        return null;
    }
}
