package cn.dmai.frame.base.mybatis.util;

/**
 * @Author linchengdong
 * @Date 2023-12-04 15:17
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: QueryType
 * @Description: TODO
 * @Version 1.0
 */
public enum QueryType {
    EQ, NE,LIKE, GT, LT,LE, GE, GTE, LTE, IS_NULL, NOT_NULL, IS_NOT_NULL, IN, NOT_IN, BETWEEN, NOT_BETWEEN, ORDER_BY, DESC, ASC, LIMIT, OFFSET, COUNT, SUM, AVG, MAX, MIN;
}
