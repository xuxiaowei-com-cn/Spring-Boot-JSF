package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试 服务实现层
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Service
public class TestServiceImpl implements ITestService {

    /**
     * 测试方法
     *
     * @return 返回测试内容
     */
    @Override
    public String hi() {
        return "你好，已注入成功";
    }
}
