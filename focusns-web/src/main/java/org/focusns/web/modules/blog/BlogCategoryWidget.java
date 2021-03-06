package org.focusns.web.modules.blog;

/*
 * #%L
 * FocusSNS Web
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


import org.focusns.model.blog.BlogCategory;
import org.focusns.model.core.Project;
import org.focusns.service.blog.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogCategoryWidget {
    
    @Autowired
    private BlogCategoryService blogCategoryService;

    @RequestMapping("/category-list")
    public String list(Project project, Model model) {
        //
    	Long projectId = project.getId();
    	//
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setLabel("未分类");
        blogCategory.setProjectId(projectId);
        List<BlogCategory> blogCategories = blogCategoryService.getBlogCategories(projectId);
        blogCategories.add(0, blogCategory);
        model.addAttribute("blogCategories", blogCategories);
        //
        return "modules/blog/category-list";
    }
    
}
