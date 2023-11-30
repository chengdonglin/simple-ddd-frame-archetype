package cn.dmai.frame.base.page;

import java.io.Serializable;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:36
 * @PackageName:cn.dmai.frame.base.page
 * @ClassName: PageParam
 * @Description: 分页查询参数
 * @Version 1.0
 */
public class PageParam implements Serializable {

    /**
     * 当前页
     */
    private int current = 1;

    /**
     * 每页记录数
     */
    private int size = 10;

    public PageParam() {
    }

    public PageParam(int current, int size) {
        this.current = current;
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
