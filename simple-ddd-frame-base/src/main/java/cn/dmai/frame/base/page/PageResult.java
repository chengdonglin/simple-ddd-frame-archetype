package cn.dmai.frame.base.page;

import cn.dmai.frame.base.response.ApiCode;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:40
 * @PackageName:cn.dmai.frame.base.page
 * @ClassName: PageResult
 * @Description: 分页响应结果
 * @Version 1.0
 */
public class PageResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private List<T> records;

    private long total;

    private long current;

    private long size;

    public PageResult() {
    }

    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(ApiCode.SUCCESS.getValue());
        result.setMsg(ApiCode.SUCCESS.getLabel());
        result.setRecords(page.getRecords());
        result.setTotal(page.getTotal());
        result.setCurrent(page.getCurrent());
        result.setSize(page.getSize());
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
