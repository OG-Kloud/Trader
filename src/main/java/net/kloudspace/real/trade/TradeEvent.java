package net.kloudspace.real.trade;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TradeEvent {
	@SubscribeEvent
	public void replaceVanillaVillagers(EntityJoinWorldEvent event){
	    if (event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 0){
	        ((EntityVillager)event.entity).setProfession(6);
	    }
	    if (event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 1) {
	    	((EntityVillager)event.entity).setProfession(7);
	    }
	    if(event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 2) {
	    	((EntityVillager)event.entity).setProfession(8);
	    }
	    if(event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 3) {
	    	((EntityVillager)event.entity).setProfession(9);
	    }
	    if(event.entity instanceof EntityVillager && ((EntityVillager)event.entity).getProfession() == 4) {
	    	((EntityVillager)event.entity).setProfession(10);
	    }
	}
	

}
