package org.focusns.web.modules.admin;

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
import org.focusns.model.blog.BlogPost;
import org.focusns.model.core.Project;
import org.focusns.model.core.ProjectFeature;
import org.focusns.service.blog.BlogCategoryService;
import org.focusns.service.blog.BlogPostService;
import org.focusns.web.helper.ActionHelper;
import org.focusns.web.helper.WebRequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class BlogAdminController {
    
    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private BlogCategoryService blogCategoryService;
     
    @RequestMapping("/blog/post/edit")
    public String editPost(@RequestParam String action, BlogPost blogPost, WebRequest webRequest) {
        Project project = WebRequestHelper.getProject(webRequest);
        ProjectFeature feature = WebRequestHelper.getProjectFeature(webRequest);
        //
        if(ActionHelper.isCreate(action)) {
            blogPostService.createBlogPost(blogPost);
        }
        if(ActionHelper.isModify(action)) {
            blogPostService.modifyBlogPost(blogPost);
        }
        if(ActionHelper.isRemove(action)) {
            blogPostService.removeBlogPost(blogPost);
        }
        //
        return "redirect:/"+project.getCode()+"/"+feature.getCode()+"/blog/post-edit";
    }
    @RequestMapping("/blog/category/edit")
    public String editCategory(@RequestParam String action, BlogCategory blogCategory, WebRequest webRequest) {
        //
        Project project = WebRequestHelper.getProject(webRequest);
        ProjectFeature feature = WebRequestHelper.getProjectFeature(webRequest);
        //
        if(ActionHelper.isCreate(action)) {
            blogCategoryService.createBlogCategory(blogCategory);
        }
        if(ActionHelper.isModify(action)) {
            blogCategoryService.modifyBlogCategory(blogCategory);
        }
        if(ActionHelper.isRemove(action)) {
            blogCategoryService.removeBlogCategory(blogCategory);
        }
        //
        return "redirect:/"+project.getCode()+"/"+feature.getCode()+"/blog/category-edit";
    }
    
}
