package com.snackpub.core.secure;

import lombok.Data;

/**
 * TokenInfo
 *
 * @author Administrator
 */
@Data
public class TokenInfo {
    /**
     * 令牌
     */
    private String token;
    /**
     * 过期秒数
     */
    private int expire;
}
