//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.snackpub.core.log.logger;

import com.snackpub.core.log.publisher.UsualLogPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * 日志工具类
 *
 * @author honey
 * @date 2019/12/1
 */
@Slf4j
public class RisesinLogger implements InitializingBean {
    @Value("${spring.application.name}")
    private String serviceId;

    public void info(String id, String data) {
        UsualLogPublisher.publishEvent("info", id, data);
    }

    public void debug(String id, String data) {
        UsualLogPublisher.publishEvent("debug", id, data);
    }

    public void warn(String id, String data) {
        UsualLogPublisher.publishEvent("warn", id, data);
    }

    public void error(String id, String data) {
        UsualLogPublisher.publishEvent("error", id, data);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(serviceId + ": SnackPubLogger init success!");
    }
}
