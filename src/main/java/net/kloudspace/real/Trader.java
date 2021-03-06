package net.kloudspace.real;

import net.kloudspace.real.trade.TradeEvent;
import net.kloudspace.real.trade.TradeHandler;
import net.kloudspace.real.trade.compat.BackpacksCompat;
import net.kloudspace.real.trade.compat.event.BackpackEvents;
import net.kloudspace.real.utils.Reference;
import net.kloudspace.version.proxy.CommonProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.VillagerRegistry;

/*
 * @Author: Kloud
 */
/*
 * @Date: 2/28/2015 7:28p PST
 */


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Trader {
	
	public final String VERSION = Reference.VERSION;
	public static String MINECRAFT = "minecraft";
	public ResourceLocation farmer = new ResourceLocation(MINECRAFT, "textures/entity/villager/farmer.png");
	public ResourceLocation librarian = new ResourceLocation(MINECRAFT, "textures/entity/villager/librarian.png");
	public ResourceLocation priest = new ResourceLocation(MINECRAFT, "textures/entity/villager/priest.png");
	public ResourceLocation blacksmith = new ResourceLocation(MINECRAFT, "textures/entity/villager/smith.png");
	public ResourceLocation butcher = new ResourceLocation(MINECRAFT, "textures/entity/villager/butcher.png");
	
	@SidedProxy(clientSide ="net.kloudspace.version.proxy.ClientProxy", serverSide = "net.kloudspace.version.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		VillagerRegistry.instance().registerVillagerId(6);
		VillagerRegistry.instance().registerVillagerId(7);
		VillagerRegistry.instance().registerVillagerId(8);
		VillagerRegistry.instance().registerVillagerId(9);
		VillagerRegistry.instance().registerVillagerId(10);
		VillagerRegistry.instance().registerVillagerId(11);

		VillagerRegistry.instance().registerVillageTradeHandler(6, new TradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(7, new TradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(8, new TradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(9, new TradeHandler());
		VillagerRegistry.instance().registerVillageTradeHandler(10, new TradeHandler());
		VillagerRegistry.instance().registerVillagerSkin(6, farmer);
		VillagerRegistry.instance().registerVillagerSkin(7, librarian);
		VillagerRegistry.instance().registerVillagerSkin(8, priest);
		VillagerRegistry.instance().registerVillagerSkin(9, blacksmith);
		VillagerRegistry.instance().registerVillagerSkin(10, butcher);
		VillagerRegistry.instance().registerVillagerSkin(11, priest);
		MinecraftForge.EVENT_BUS.register(new TradeEvent());
		
		if(Loader.isModLoaded("Backpack")) {
			System.out.println("Found Backpack Mod");
			System.out.println("Registering Backpack Villager");
			VillagerRegistry.instance().registerVillageTradeHandler(11, new BackpacksCompat());
			MinecraftForge.EVENT_BUS.register(new BackpackEvents());
			}
		System.out.println("No Additional Mods Loaded");
		}
	
	@EventHandler
	public void post(FMLPostInitializationEvent event) {
		proxy.post(event);
	}
	

}

/*
 * Added Backpack Support
 */
