/*
 *     Copyright (C) 2021 PugzAreCute
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
 */

package com.pugzarecute.rougeloaderspigot.update;

import com.google.gson.Gson;
import com.pugzarecute.rougeloaderspigot.RougeloaderSpigot;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;

public class RougeUpdater {
    public static void checkForUpdates() throws IOException {
        //URL of the update JSON file from my servers
        URL remoteUpdateFile = new URL("https://update.pugzarecute.com/rougeloader/spigot.json") ;
        ReadableByteChannel rbc = Channels.newChannel(remoteUpdateFile.openStream());
        FileOutputStream fos = new FileOutputStream("RougeLoader-UpdateJSON.cache");
        //Save remoteUpdateFile to a local file
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        File selfUpateUrl = new File("RougeLoader-UpdateJSON.cache");
        //Use GSON to parse the JSON
        SelfUpdateJSONTemplate parsed = new Gson().fromJson(new FileReader(selfUpateUrl), SelfUpdateJSONTemplate.class);
        if(parsed.getLatestStableBuildCodeVersion() > RougeloaderSpigot.CODE_VERSION){
            //Log if the build is outdated
            Bukkit.getLogger().log(Level.WARNING,"This build of RougeLoader is outdated. Current Version: "+parsed.getVersions().get(parsed.getLatestStableBuildCodeVersion().toString())+"("+parsed.getVersions().get(parsed.getLatestStableBuildCodeVersion().toString()).getDisplayName()+"). Latest version:"+parsed.getVersions().get(RougeloaderSpigot.CODE_VERSION.toString())+"("+parsed.getVersions().get(RougeloaderSpigot.CODE_VERSION.toString()).getDisplayName()+" You may find the latest build at: "+parsed.getVersions().get(parsed.getLatestStableBuildCodeVersion().toString()).getDownloadURL());
        }
        //Delete the local file
        selfUpateUrl.delete();
    }
}
