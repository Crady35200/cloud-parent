package com.crady.cloud.zuul.cloudzuul.fillter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author:Crady
 * @date:2018/7/4 15:12
 * @desc:
 **/
public class AuthorityFillter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthorityFillter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("开始校验权限...");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest servletContext = ctx.getRequest();
        String key = servletContext.getParameter("key");
        if(StringUtils.isEmpty(key)){
            logger.info("您无权限访问");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.setResponseBody(URLEncoder.encode("访问拒绝","UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;

        }
        logger.info("权限校验通过");
        return null;
    }
}
