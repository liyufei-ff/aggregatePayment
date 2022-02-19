package org.juhepay.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.juhepay.transaction.entity.PayChannelParam;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 某商户针对某一种原始支付渠道的配置参数 Mapper 接口
 * </p>
 *
 * @author lily
 * @since 2021-01-25
 */
@Repository
public interface PayChannelParamMapper extends BaseMapper<PayChannelParam> {

}
