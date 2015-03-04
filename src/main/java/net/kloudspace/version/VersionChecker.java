package net.kloudspace.version;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class VersionChecker implements Runnable{
	
	private static boolean isLatestVersion = false;
	private static String latestVersion = "";
	
	@Override
	public void run() {
		InputStream in = null;
		try {
			in = new URL("https://cdn.rawgit.com/OG-Kloud/Trader/master/src/main/java/net/kloudspace/real/version_file").openStream();
		}
		catch(MalformedURLException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try {
			latestVersion = IOUtils.readLines(in).get(0);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			IOUtils.closeQuietly(in);
		}
		System.out.println("Latest Mod Version =" + latestVersion);
		isLatestVersion = Version.MODVERSION.equals(latestVersion);
		System.out.println("Are you running the latest version =" + isLatestVersion);
	}
	
	public boolean isLatestVersion() {
		return isLatestVersion;
	}
	
	public String getLatestVersion() {
		return latestVersion;
	}

}
