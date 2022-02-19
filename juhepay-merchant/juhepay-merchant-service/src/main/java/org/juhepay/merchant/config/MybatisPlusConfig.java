package org.juhepay.merchant.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * @Description
 * @Author lily
 * @Date 2021/1/21 2:39 下午
 * @Version 1.0
 */
@Configuration
@MapperScan("org.juhepay.**.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件，自动识别数据库类型
     * */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /**
     * 启用性能分析插件 */
    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }
}
