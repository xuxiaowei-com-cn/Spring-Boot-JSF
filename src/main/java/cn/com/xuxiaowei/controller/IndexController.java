package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.configuration.ViewConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * JSF Controller
 *
 * @author xuxiaowei
 */
@Component
@Scope(ViewConfiguration.SCOPE)
public class IndexController {

    public String getIndex() {
        return this.toString();
    }

    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }

}
