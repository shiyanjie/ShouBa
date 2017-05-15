/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.shouba.shouba.db;


import com.shouba.shouba.R;
import com.shouba.shouba.app.AppApplication;
import com.shouba.shouba.bean.ShouBaChannelTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShouBaChannelTableManager {

    /**
     * 加载瘦吧类型
     * @return
     */
    public static List<ShouBaChannelTable> loadShouBaChannelsMine() {
        List<String> channelName = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.shouba_channel_name));
        List<String> channelId = Arrays.asList(AppApplication.getAppContext().getResources().getStringArray(R.array.shouba_channel_id));
        ArrayList<ShouBaChannelTable> shoubaChannelTables=new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            ShouBaChannelTable entity = new ShouBaChannelTable(channelId.get(i), channelName.get(i));
            shoubaChannelTables.add(entity);
        }
        return shoubaChannelTables;
    }

}
