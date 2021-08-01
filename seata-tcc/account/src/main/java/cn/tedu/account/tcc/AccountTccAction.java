package cn.tedu.account.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

import java.math.BigDecimal;

/**
 * @Author Wu Yong
 * @Date 2021/7/31 19:50
 * @Description
 */
@LocalTCC
public interface AccountTccAction {
    @TwoPhaseBusinessAction(name = "accountTccAction", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepareDecreaseAccount(BusinessActionContext businessActionContext,
                                   @BusinessActionContextParameter(paramName = "userId") Long userId,
                                   @BusinessActionContextParameter(paramName = "money") BigDecimal money);

    boolean commit(BusinessActionContext businessActionContext);

    boolean rollback(BusinessActionContext businessActionContext);

}
