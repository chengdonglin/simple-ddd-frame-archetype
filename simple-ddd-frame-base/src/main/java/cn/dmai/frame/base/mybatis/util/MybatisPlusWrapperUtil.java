package cn.dmai.frame.base.mybatis.util;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author linchengdong
 * @Date 2023-12-04 14:15
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: MybatisPlusWrapperUtil
 * @Description: 通用wrapper构造器
 * @Version 1.0
 */
public class MybatisPlusWrapperUtil {

    public static <T> QueryWrapper<T> queryWrapperHandler(Q<T> q) {
        try {
            // 获取查询对象的类和字段
            Class<?> qClass = q.getClass();
            Field[] fields = qClass.getDeclaredFields();

            QueryWrapper<T> queryWrapper = new QueryWrapper<>();
            Map<String, Field[]> betweenFieldMap = new HashMap<>();

            // 处理@SelectColumn
            SelectColumn selectColumn = qClass.getAnnotation(SelectColumn.class);
            if (selectColumn != null && selectColumn.value() != null && selectColumn.value().length > 0) {
                // 转换字段名为下划线风格并设置为选择字段
                String[] strings = selectColumn.value();
                for (int i = 0; i < strings.length; i++) {
                    strings[i] = StrUtil.toUnderlineCase(strings[i]);
                }
                queryWrapper.select(strings);
            }

            // 处理排序字段
            String sortColumn = "";
            String sortOrder = "";

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(q);

                // 判断属性是否存在值
                if (Objects.isNull(value) || String.valueOf(value).equals("null") || value.equals("")) {
                    continue;
                }

                // 处理@QuerySort注解
                QuerySort querySort = field.getDeclaredAnnotation(QuerySort.class);
                String paramValue = (String) field.get(q);
                sortColumn = querySort != null ? querySort.value() : "";

                // 处理@QueryOrder注解
                QueryOrder queryOrder = field.getDeclaredAnnotation(QueryOrder.class);
                sortOrder = queryOrder != null ? queryOrder.value() : "";

                // 处理@Query注解
                Query query = field.getDeclaredAnnotation(Query.class);
                if (query == null) {
                    continue;
                }

                // 获取列名
                String columnName = StrUtil.isBlank(query.column()) ? StrUtil.toUnderlineCase(field.getName()) : query.column();

                // 根据注解生成查询条件
                switch (query.expression()) {
                    case EQ:
                        queryWrapper.eq(columnName, value);
                        break;
                    case NE:
                        queryWrapper.ne(columnName, value);
                        break;
                    case LIKE:
                        queryWrapper.like(columnName, value);
                        break;
                    case GT:
                        queryWrapper.gt(columnName, value);
                        break;
                    case GE:
                        queryWrapper.ge(columnName, value);
                        break;
                    case LT:
                        queryWrapper.lt(columnName, value);
                        break;
                    case LE:
                        queryWrapper.le(columnName, value);
                        break;
                    case IN:
                        queryWrapper.in(columnName, value);
                        break;
                    case NOT_IN:
                        queryWrapper.notIn(columnName, value);
                        break;
                    case IS_NULL:
                        queryWrapper.isNull(columnName);
                        break;
                    case NOT_NULL:
                        queryWrapper.isNotNull(columnName);
                        break;
                    case IS_NOT_NULL:
                        queryWrapper.isNotNull(columnName);
                    case BETWEEN:
                        // 处理BETWEEN注解
                        if (betweenFieldMap.containsKey(columnName)) {
                            Field[] f = betweenFieldMap.get(columnName);
                            Field[] tempList = new Field[2];
                            tempList[0] = f[0];
                            tempList[1] = field;
                            betweenFieldMap.put(columnName, tempList);
                        } else {
                            betweenFieldMap.put(columnName, new Field[]{field});
                        }
                        break;
                }
            }

            // 处理BETWEEN注解
            Set<String> keySet = betweenFieldMap.keySet();
            for (String key : keySet) {
                Field[] itemFieldList = betweenFieldMap.get(key);
                if (itemFieldList.length != 2){
                    throw new IllegalArgumentException("查询参数数量对应异常");
                }

                Field field1 = itemFieldList[0];
                Field field2 = itemFieldList[1];

                Query query1 = field1.getDeclaredAnnotation(Query.class);

                if (field1.get(q) instanceof Date) {
                    // 处理日期类型
                    if (query1.left()) {
                        queryWrapper.apply("date_format(" + key + ",'%y%m%d') >= date_format({0},'%y%m%d')", field1.get(q));
                        queryWrapper.apply("date_format(" + key + ",'%y%m%d') <= date_format({0},'%y%m%d')", field2.get(q));
                    } else {
                        queryWrapper.apply("date_format(" + key + ",'%y%m%d') <= date_format({0},'%y%m%d')", field1.get(q));
                        queryWrapper.apply("date_format(" + key + ",'%y%m%d') >= date_format({0},'%y%m%d')", field2.get(q));
                    }
                } else {
                    // 处理非日期类型
                    if (query1.left()) {
                        queryWrapper.between(key, field1.get(q), field2.get(q));
                    } else {
                        queryWrapper.between(key, field2.get(q), field1.get(q));
                    }
                }
            }

            // 处理排序字段
            if (sortOrder.equalsIgnoreCase("desc")) {
                queryWrapper.orderByDesc(StrUtil.isNotBlank(sortColumn), StrUtil.toUnderlineCase(sortColumn));
            } else {
                queryWrapper.orderByAsc(StrUtil.isNotBlank(sortColumn), StrUtil.toUnderlineCase(sortColumn));
            }

            return queryWrapper;
        } catch (Exception e) {
            e.printStackTrace();
            throw new  RuntimeException(e.getMessage());
        }
    }


    public static void main(String[] args) {
//        NameQuery query = new NameQuery();
//        query.setName("test");
//        QueryWrapper<LiveServicePO> wrapper = queryWrapperHandler(query);
    }
}
