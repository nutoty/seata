package cn.tedu.account.service;

import java.math.BigDecimal;

/**
 * @Author Wu Yong
 * @Date 2021/7/29 0:09
 * @Description
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
