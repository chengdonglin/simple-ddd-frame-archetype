package cn.dmai.frame.base.util.id;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:07
 * @PackageName:cn.dmai.frame.base.util.date
 * @ClassName: JodaDateTimeUtils
 * @Description: 雪花算法工厂
 * @Version 1.0
 */
public class SnowFlakeFactory {

    /**
     * 默认数据中心id
     */
    private static final long DEFAULT_DATACENTER_ID = 1;
    /**
     * 默认的机器id
     */
    private static final long DEFAULT_MACHINE_ID = 1;

    /**
     * 默认的雪花算法句柄
     */
    private static final String DEFAULT_SNOW_FLAKE = "snow_flake";

    /**
     * 缓存SnowFlake对象
     */
    private static ConcurrentMap<String, SnowFlake> snowFlakeCache = new ConcurrentHashMap<>(2);

    public static SnowFlake getSnowFlake(long datacenterId, long machineId) {
        return new SnowFlake(datacenterId, machineId);
    }

    public static SnowFlake getSnowFlake() {
        return new SnowFlake(DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID);
    }

    public static SnowFlake getSnowFlakeFromCache() {
        SnowFlake snowFlake = snowFlakeCache.get(DEFAULT_SNOW_FLAKE);
        if (snowFlake == null) {
            snowFlake = new SnowFlake(DEFAULT_DATACENTER_ID, DEFAULT_MACHINE_ID);
            snowFlakeCache.put(DEFAULT_SNOW_FLAKE, snowFlake);
        }
        return snowFlake;
    }

    /**
     * 根据数据中心id和机器id从缓存中获取全局id
     *
     * @param dataCenterId: 取值为1~31
     * @param machineId:    取值为1~31
     */
    public static SnowFlake getSnowFlakeByDataCenterIdAndMachineIdFromCache(Long dataCenterId, Long machineId) {
        if (dataCenterId > SnowFlake.getMaxDataCeneterNum() || dataCenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > SnowFlake.getMaxMachineNum() || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        String key = DEFAULT_SNOW_FLAKE.concat("_").concat(String.valueOf(dataCenterId)).concat("_").concat(String.valueOf(machineId));
        SnowFlake snowFlake = snowFlakeCache.get(key);
        if (snowFlake == null) {
            snowFlake = new SnowFlake(dataCenterId, machineId);
            snowFlakeCache.put(key, snowFlake);
        }
        return snowFlake;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getSnowFlakeFromCache().nextId());
        }
    }
}
