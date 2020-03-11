package com.snackpub.core.log.feign;

import com.snackpub.core.launch.constant.AppConstant;
import com.snackpub.core.log.model.LogApi;
import com.snackpub.core.log.model.LogError;
import com.snackpub.core.log.model.LogUsual;
import com.snackpub.core.tools.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Feign接口类
 */
@FeignClient(
        value = AppConstant.APPLICATION_LOG_NAME,
        fallback = LogClientFallback.class
)
public interface ILogClient {
    String API_PREFIX = "/log";

    /**
     * 保存错误日志
     *
     * @param log 日志实体
     * @return boolean
     */
    @PostMapping({"/log/saveUsualLog"})
    R<Boolean> saveUsualLog(@RequestBody LogUsual log);

    /**
     * 保存操作日志
     *
     * @param log 日志实体
     * @return boolean
     */
    @PostMapping({"/log/saveApiLog"})
    R<Boolean> saveApiLog(@RequestBody LogApi log);

    /**
     * 保存错误日志
     *
     * @param log 日志实体
     * @return boolean
     */
    @PostMapping({"/log/saveErrorLog"})
    R<Boolean> saveErrorLog(@RequestBody LogError log);

}
