package com.sz.check.common.exception;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zyh
 * @doc springboot异常监听
 * @fileName ApplicationFailureListener
 * @date 2025/3/3
 */
@Component
public class ApplicationExceptionHandler implements ApplicationListener<ApplicationFailedEvent> {

    /**
     * springboot启动异常监听
     * @param event 监听事件
     * @author zyh
     * @date 2025/03/03
     */
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        // 捕获启动异常
        Throwable exception = event.getException();
        System.out.println("警告：" + exception.getMessage());
    }
}