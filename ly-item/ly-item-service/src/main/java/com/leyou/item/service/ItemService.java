package com.leyou.item.service;

import com.leyou.item.pojo.Item;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 * @author huangyi
 * @date 2019/10/13 9:08
 */
@Service
public class ItemService {
    public Item saveItem(Item item) {
        int id = new Random().nextInt(100);
        item.setId(id);
        return item;

    }
}
