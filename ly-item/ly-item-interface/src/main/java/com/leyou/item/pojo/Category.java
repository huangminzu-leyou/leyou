package com.leyou.item.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * @author huangyi
 * @date 2019/10/15 11:26
 */
@Table(name="tb_category")
@Data
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
}
