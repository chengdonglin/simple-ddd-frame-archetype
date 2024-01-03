#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.enums;

import java.util.EnumSet;
import java.util.Objects;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:12
 * @PackageName:${package}.base.enums
 * @ClassName: BaseEnum
 * @Description: 枚举通用接口
 * @Version 1.0
 */
public interface BaseEnum<T> {

    /**
     * 根据枚举值和枚举类获取枚举
     *
     * @param value 枚举值
     * @param clazz 枚举类型
     * @param <E>
     * @return 枚举
     */
    static <E extends Enum<E> & BaseEnum> E getEnumByValue(Object value, Class<E> clazz) {
        Objects.requireNonNull(value);

        EnumSet<E> allEnums = EnumSet.allOf(clazz);
        return allEnums.stream().filter(e -> value.equals(e.getValue())).findFirst().orElse(null);
    }

    /**
     * 根据枚举值和枚举类获取枚举标签
     *
     * @param value
     * @param clazz
     * @param <E>
     * @return
     */
    static <E extends Enum<E> & BaseEnum> String getLabelByValue(Object value, Class<E> clazz) {
        E matchEnum = getEnumByValue(value, clazz);
        String lable = null;
        if (Objects.nonNull(matchEnum)) {
            lable = matchEnum.getLabel();
        }
        return lable;
    }

    /**
     * 根据枚举标签和枚举类获取枚举
     *
     * @param label 枚举标签
     * @param clazz 枚举类型
     * @param <E>
     * @return
     */
    static <E extends Enum<E> & BaseEnum> E getEnumByLabel(String label, Class<E> clazz) {
        Objects.requireNonNull(label);
        // 获取类型下的所有枚举
        EnumSet<E> allEnums = EnumSet.allOf(clazz);
        return allEnums.stream().filter(e -> label.equals(e.getLabel())).findFirst().orElse(null);
    }

    /**
     * 根据枚举标签和枚举类获取枚举值
     *
     * @param label 枚举标签
     * @param clazz 枚举类型
     * @return 枚举值
     */
    static <E extends Enum<E> & BaseEnum> Object getValueByLabel(String label, Class<E> clazz) {
        E matchEnum = getEnumByLabel(label, clazz);
        Object value = null;
        if (Objects.nonNull(matchEnum)) {
            value = matchEnum.getValue();
        }
        return value;
    }

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    T getValue();

    /**
     * 获取枚举标签
     *
     * @return 枚举标签
     */
    String getLabel();
}
