#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @Author linchengdong
 * @Date 2023-11-29 18:51
 * @PackageName:${package}.base.model
 * @ClassName: CommonCacheBuilder
 * @Description: TODO
 * @Version 1.0
 */
public class CommonCacheBuilder {

    /**
     * Json泛型化处理
     */
    public static <T> BusinessCache<T> getBusinessCache(Object object, Class<T> clazz){
        if (object == null){
            return null;
        }
        return JSON.parseObject(object.toString(), new TypeReference<BusinessCache<T>>(clazz){});
    }

    /**
     * Json泛型化处理
     */
    public static <T> BusinessCache<List<T>> getBusinessCacheList(Object object, Class<T> clazz){
        if (object == null){
            return null;
        }
        return JSON.parseObject(object.toString(), new TypeReference<BusinessCache<List<T>>>(clazz){});
    }
}
