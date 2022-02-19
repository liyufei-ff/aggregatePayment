package org.juhepay.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.juhepay.transaction.entity.AppPlatformChannel;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 说明了应用选择了平台中的哪些支付渠道 Mapper 接口
 * </p>
 *
 * @author lily
 * @since 2021-01-25
 */
@Repository
public interface AppPlatformChannelMapper extends BaseMapper<AppPlatformChannel> {

}
