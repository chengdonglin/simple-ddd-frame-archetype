#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.model;

/**
 * @Author linchengdong
 * @Date 2023-11-29 18:49
 * @PackageName:${package}.base.model
 * @ClassName: BusinessCache
 * @Description: TODO
 * @Version 1.0
 */
public class BusinessCache<T> extends CommonCache {

    private T data;


    public BusinessCache<T> with(T data){
        this.data = data;
        this.exist = true;
        return this;
    }

    public BusinessCache<T> withVersion(Long version){
        this.version = version;
        return this;
    }

    public BusinessCache<T> retryLater(){
        this.retryLater = true;
        return this;
    }

    public BusinessCache<T> notExist(){
        this.exist = false;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
