/*
 * Copyright (C) 2021 PugzAreCute
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.pugzarecute.rougeloaderspigot;

import com.google.gson.Gson;
import com.pugzarecute.rougeloaderspigot.update.SelfUpdateJSONTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class RougeUpdater {
    public static void checkForUpdates() throws IOException {
        URL remoteUpdateFile = new URL("https://update.pugzarecute.com/rougeloader/spigot.json") ;
        ReadableByteChannel rbc = Channels.newChannel(remoteUpdateFile.openStream());
        FileOutputStream fos = new FileOutputStream("RougeLoader-UpdateJSON.cache");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        File selfUpateUrl = new File("RougeLoader-UpdateJSON.cache");
        SelfUpdateJSONTemplate parsed = new Gson().fromJson(new FileReader(selfUpateUrl), SelfUpdateJSONTemplate.class);
        System.out.println(parsed.getLatestDevBuild());
        selfUpateUrl.delete();
    }
    public static void main(String[] args) throws IOException {
        checkForUpdates();
    }
}
