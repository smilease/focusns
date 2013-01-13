/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package org.focusns.service.event;

import org.focusns.model.event.EventCategory;
import org.focusns.service.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class EventCategoryServiceTest extends AbstractServiceTest {

    @Autowired
    private EventCategoryService eventCategoryService;

    @Test
    public void testCreateEventCategory() {
         EventCategory category = new EventCategory();
        category.setLabel("任务");
        category.setCreateAt(new Date());
        category.setProjectId(1);
        category.setCreateById(1);
        //
        eventCategoryService.createEventCategory(category);
    }

}
