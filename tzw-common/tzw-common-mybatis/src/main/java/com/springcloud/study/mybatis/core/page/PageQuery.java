package com.springcloud.study.mybatis.core.page;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.study.core.utils.sql.SqlUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 描 述: 分页查询实体类
 * 作   者: 谭志伟
 * 时   间: 2022/9/21  13:42
 */
@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 8713451912215206712L;

    /**
     * 属性描述: 当前记录起始索引 默认值
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:46
     */
    public static final int DEFAULT_PAGE_NUM = 1;
    /**
     * 属性描述: 每页显示记录数 默认值 默认查全部
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:47
     */
    public static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;
    /**
     * 属性描述: 分页大小
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:45
     */
    private Integer pageSize;
    /**
     * 属性描述: 当前页数
     * 作   者: 谭志伟
     * 时   间: 2022/9/21 13:45
     */
    private Integer pageNum;
    private String orderByColumn;
    private String isAsc;

    public <T> Page<T> build() {
        Integer pageNum = ObjectUtil.defaultIfNull(getPageNum(), DEFAULT_PAGE_NUM);
        Integer pageSize = ObjectUtil.defaultIfNull(getPageSize(), DEFAULT_PAGE_SIZE);
        if (pageNum <= 0) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        Page<T> page = new Page<>(pageNum, pageSize);
        OrderItem orderItem = buildOrderItem();
        if (ObjectUtil.isNotNull(orderItem)) {
            page.addOrder(orderItem);
        }
        return page;
    }

    private OrderItem buildOrderItem() {
        // 兼容前端排序类型
        if ("ascending".equals(isAsc)) {
            isAsc = "asc";
        } else if ("descending".equals(isAsc)) {
            isAsc = "desc";
        }
        if (StrUtil.isNotBlank(orderByColumn)) {
            String orderBy = SqlUtil.escapeOrderBySql(orderByColumn);
            orderBy = StrUtil.toUnderlineCase(orderBy);
            if ("asc".equals(isAsc)) {
                return OrderItem.asc(orderBy);
            } else if ("desc".equals(isAsc)) {
                return OrderItem.desc(orderBy);
            }
        }
        return null;
    }
}
