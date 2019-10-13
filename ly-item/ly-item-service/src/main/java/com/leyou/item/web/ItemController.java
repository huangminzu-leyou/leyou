package com.leyou.item.web;

import com.leyou.item.pojo.Item;
import com.leyou.item.service.ItemService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyi
 * @date 2019/10/13 9:10
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    ItemService itemService;
    public Item saveItem(Item item) {

        if(item.getPrice() == null) {
            throw new RuntimeException("价格不能为空");
        }

        return  itemService.saveItem(item);
    }
}
