package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author huangyi
 * @date 2019/10/15 11:38
 */
@Service
public class CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByParentId(Long pid) {

        Category category = new Category();
        category.setParentId(pid);

        List<Category> list = categoryMapper.select(category);

        if (CollectionUtils.isEmpty(list)) {
           throw new LyException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }

        return list;
    }
}
