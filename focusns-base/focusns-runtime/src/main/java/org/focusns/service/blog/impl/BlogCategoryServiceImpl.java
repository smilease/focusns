package org.focusns.service.blog.impl;

/*
 * #%L
 * FocusSNS Runtime
 * %%
 * Copyright (C) 2011 - 2013 FocusSNS
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */


import org.focusns.dao.blog.BlogCategoryDao;
import org.focusns.model.blog.BlogCategory;
import org.focusns.service.blog.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Autowired
    private BlogCategoryDao categoryDao;

    @Override
    public BlogCategory getBlogCategory(long categoryId) {
        return categoryDao.select(categoryId);
    }

    public void createBlogCategory(BlogCategory category) {
        if(category.getCreateAt()==null) {
            category.setCreateAt(new Date());
        }
        categoryDao.insert(category);
    }

    public void modifyBlogCategory(BlogCategory category) {
        categoryDao.update(category);
    }

    public void removeBlogCategory(BlogCategory category) {
        categoryDao.delete(category.getId());
    }

    public List<BlogCategory> getBlogCategories(long projectId) {
        return categoryDao.selectByProjectId(projectId);
    }

    @Override
    public List<BlogCategory> getBlogCategories() {
        return categoryDao.selectByProjectId(0);
    }

}
