package org.microservices.uigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

public class LoggingFilter extends ZuulFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FORWARD_TO_KEY); // if another filter hasn't already forwarded
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        LOGGER.info(ctx.getRequest().getRequestURL().toString());

        return null;
    }
}
