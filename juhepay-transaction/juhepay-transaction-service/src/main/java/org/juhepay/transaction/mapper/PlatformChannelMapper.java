package org.juhepay.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.juhepay.transaction.api.dto.PayChannelDTO;
import org.juhepay.transaction.entity.PlatformChannel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lily
 * @since 2021-01-25
 */
@Repository
public interface PlatformChannelMapper extends BaseMapper<PlatformChannel> {

    /**
     * 根据平台服务类型获取原始支付渠道
     * @param platformChannelCode
     * @return
     */
    @Select("SELECT " + " pay.*"+
            "FROM" +
            " pay_channel pay," +
            " platform_pay_channel pac," +
            " platform_channel pla " +
            "WHERE pay.CHANNEL_CODE = pac.PAY_CHANNEL " +
            " AND pla.CHANNEL_CODE = pac.PLATFORM_CHANNEL " + " AND pla.CHANNEL_CODE = #{platformChannelCode} ")
    public List<PayChannelDTO> selectPayChannelByPlatformChannel(String platformChannelCode) ;

}
