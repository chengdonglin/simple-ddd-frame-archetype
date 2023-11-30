package cn.dmai.frame.base.model;

/**
 * @Author linchengdong
 * @Date 2023-11-29 18:48
 * @PackageName:cn.dmai.frame.base.model
 * @ClassName: CommonCache
 * @Description: TODO
 * @Version 1.0
 */
public abstract class CommonCache {

    //缓存数据是否存在
    protected boolean exist;

    //缓存版本号
    protected Long version;

    //稍后再试
    protected boolean retryLater;


    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isRetryLater() {
        return retryLater;
    }

    public void setRetryLater(boolean retryLater) {
        this.retryLater = retryLater;
    }
}
