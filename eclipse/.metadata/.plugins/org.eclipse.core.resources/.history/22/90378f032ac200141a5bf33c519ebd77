package net.kloudspace.version;

import net.kloudspace.real.utils.Reference;

import static net.minecraft.util.EnumChatFormatting.*;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class VersionEvents {
	
	private static final ChatStyle description = new ChatStyle();
	private static final ChatStyle version = new ChatStyle();
	private static final ChatComponentText line = new ChatComponentText("Trader is out of date,");
	private static final ChatComponentText line2 = new ChatComponentText("click");
	private static final ChatComponentText line3 = new ChatComponentText("to update");
	
	@SubscribeEvent
	public void onEvent(PlayerTickEvent event) {
		
		EntityPlayer thePlayer = event.player;
		World world =thePlayer.worldObj;
		
		if(!Version.haveWarnedOutofDate && world.isRemote && !Version.versionChecker.isLatestVersion()) {
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://mods.io/mods/1127-trader");
			ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
			ChatComponentText versionWarningChatComponent = new ChatComponentText("here");
			versionWarningChatComponent.setChatStyle(clickableChatStyle);
			event.player.addChatMessage(new ChatComponentText(GOLD + Reference.NAME + "is old. New Update. Click" + "to Update"));
			Version.haveWarnedOutofDate = true;
		}
	}

}
