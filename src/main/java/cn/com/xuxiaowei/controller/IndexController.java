package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.configuration.ViewConfiguration;
import cn.com.xuxiaowei.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * JSF Controller
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Component
@Scope(ViewConfiguration.SCOPE)
public class IndexController {

    private ITestService testService;

    @Autowired
    public void setTestService(ITestService testService) {
        this.testService = testService;
    }

    public String getIndex() {

        log.debug(testService.hi());

        return this.toString();
    }

    public LocalDateTime getNow() {
        return LocalDateTime.now();
    }

}
