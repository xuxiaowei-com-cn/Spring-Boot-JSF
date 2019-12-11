package cn.com.xuxiaowei.configuration;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

/**
 * JSF 配置
 *
 * @author xuxiaowei
 */
@Configuration
public class ViewConfiguration implements ServletContextAware {

    public static final String SCOPE = "View";

    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        ImmutableMap.Builder<String, Object> stringObjectBuilder = new ImmutableMap.Builder<>();
        stringObjectBuilder.put(SCOPE, new ViewScope());
        ImmutableMap<String, Object> build = stringObjectBuilder.build();

        configurer.setScopes(build);

        return configurer;
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        FacesServlet facesServlet = new FacesServlet();
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(facesServlet, "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
    }

}
