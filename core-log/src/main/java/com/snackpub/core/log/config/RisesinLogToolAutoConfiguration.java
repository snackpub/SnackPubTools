/**
 * Copyright (c) 2018-2028, Chill Zhuang (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.snackpub.core.log.config;

import com.snackpub.core.launch.props.RisesinProperties;
import com.snackpub.core.launch.server.ServerInfo;
import com.snackpub.core.log.aspect.ApiLogAspect;
import com.snackpub.core.log.event.ApiLogListener;
import com.snackpub.core.log.event.ErrorLogListener;
import com.snackpub.core.log.event.UsualLogListener;
import com.snackpub.core.log.feign.ILogClient;
import com.snackpub.core.log.logger.RisesinLogger;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 日志工具自动配置
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class RisesinLogToolAutoConfiguration {

    private final ILogClient logService;
    private final ServerInfo serverInfo;
    private final RisesinProperties risesinProperties;

    @Bean
    public ApiLogAspect apiLogAspect() {
        return new ApiLogAspect();
    }

    @Bean
    public RisesinLogger risesinLogger() {
        return new RisesinLogger();
    }

    @Bean
    public ApiLogListener apiLogListener() {
        return new ApiLogListener(logService, serverInfo, risesinProperties);
    }

    @Bean
    public ErrorLogListener errorEventListener() {
        return new ErrorLogListener(logService, serverInfo, risesinProperties);
    }

    @Bean
    public UsualLogListener bladeEventListener() {
        return new UsualLogListener(logService, serverInfo, risesinProperties);
    }

}
