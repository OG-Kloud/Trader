package net.kloudspace.real.trade.compat.event;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.eydamos.backpack.item.ItemsBackpack;

public class BackpackEvents {
		
	private Random random = new Random();
	@SubscribeEvent
	public void spawnBackpack(EntityJoinWorldEvent event) {

		if(event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 0/* && random.nextInt(0) == 0*/) {
			((EntityVillager)event.entity).setProfession(11);
			((EntityVillager)event.entity).setCurrentItemOrArmor(0, new ItemStack(ItemsBackpack.backpack));
			((EntityVillager)event.entity).setCurrentItemOrArmor(1, new ItemStack(ItemsBackpack.backpack));
			((EntityVillager)event.entity).setCurrentItemOrArmor(2, new ItemStack(ItemsBackpack.backpack));
			((EntityVillager)event.entity).setCurrentItemOrArmor(3, new ItemStack(ItemsBackpack.backpack));
		}
		if(event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 11) {
			((EntityVillager)event.entity).setCurrentItemOrArmor(1, new ItemStack(ItemsBackpack.backpack));
		}
		
	}

}
