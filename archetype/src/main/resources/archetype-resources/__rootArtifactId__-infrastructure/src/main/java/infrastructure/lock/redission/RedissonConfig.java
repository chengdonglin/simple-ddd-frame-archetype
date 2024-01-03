#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.lock.redission;

import ${package}.base.constants.SystemConstants;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author linchengdong
 * @Date 2023-11-30 10:14
 * @PackageName:${package}.infrastructure.lock.redission
 * @ClassName: RedissionConfig
 * @Description: Redisson配置
 * @Version 1.0
 */
@Configuration
@ConditionalOnProperty(name = "distributed.lock.type", havingValue = SystemConstants.REDISSON_LOCK)
public class RedissonConfig {

    @Value("${symbol_dollar}{spring.redis.address}")
    private String redisAddress;

    @Bean(name = "redissonClient")
    @ConditionalOnProperty(name = "redis.arrange.type", havingValue = "single")
    public RedissonClient singleRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisAddress).setDatabase(0);
        return Redisson.create(config);
    }


    @Bean(name = "redissonClient")
    @ConditionalOnProperty(name = "redis.arrange.type", havingValue = "cluster")
    public RedissonClient clusterRedissonClient(){
        Config config = new Config();
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        clusterServersConfig.setNodeAddresses(Arrays.asList(redisAddress));
        return Redisson.create(config);
    }

}
