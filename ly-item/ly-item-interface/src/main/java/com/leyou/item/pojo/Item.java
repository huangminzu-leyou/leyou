package com.leyou.item.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangyi
 * @date 2019/10/13 9:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    Integer id;
    String name;
    Integer price;
}
