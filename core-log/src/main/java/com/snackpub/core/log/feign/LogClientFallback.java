//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.snackpub.core.log.feign;

import com.snackpub.core.log.model.LogApi;
import com.snackpub.core.log.model.LogError;
import com.snackpub.core.log.model.LogUsual;
import com.snackpub.core.tools.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 日志Fallback
 *
 * @author honey
 */
@Slf4j
@Component
public class LogClientFallback implements ILogClient {

    @Override
    public R<Boolean> saveUsualLog(LogUsual log) {
        return R.fail("usual log send fail");
    }

    @Override
    public R<Boolean> saveApiLog(LogApi log) {
        return R.fail("api log send fail");
    }

    @Override
    public R<Boolean> saveErrorLog(LogError log) {
        return R.fail("error log send fail");
    }
}
