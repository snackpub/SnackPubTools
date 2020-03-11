package com.snackpub.core.log.event;

import com.snackpub.core.launch.props.RisesinProperties;
import com.snackpub.core.launch.server.ServerInfo;
import com.snackpub.core.log.constant.EventConstant;
import com.snackpub.core.log.feign.ILogClient;
import com.snackpub.core.log.model.LogUsual;
import com.snackpub.core.log.utils.LogAbstractUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * 异步监听日志事件
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class UsualLogListener {

    private final ILogClient logService;
    private final ServerInfo serverInfo;
    private final RisesinProperties risesinProperties;

    @Async
    @Order
    @EventListener(UsualLogEvent.class)
    public void saveUsualLog(UsualLogEvent event) {
        Map<String, Object> source = (Map<String, Object>) event.getSource();
        LogUsual logUsual = (LogUsual) source.get(EventConstant.EVENT_LOG);
        LogAbstractUtil.addOtherInfoToLog(logUsual, risesinProperties, serverInfo);
        logService.saveUsualLog(logUsual);
    }

}