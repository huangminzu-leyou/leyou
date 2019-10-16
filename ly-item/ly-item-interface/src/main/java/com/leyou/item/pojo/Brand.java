package com.leyou.item.pojo;

import javax.persistence.Table;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

@Table(name = "tb_brand")
@Data
public class Brand {
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌图片
     */
    private String image;

    private Character letter;
}
