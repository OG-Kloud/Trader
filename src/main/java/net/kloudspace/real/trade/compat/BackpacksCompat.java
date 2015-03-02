package net.kloudspace.real.trade.compat;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import shukaro.artifice.ArtificeItems;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import de.eydamos.backpack.item.ItemsBackpack;

public class BackpacksCompat implements IVillageTradeHandler{

	@Override
	public void manipulateTradesForVillager(EntityVillager villager,
			MerchantRecipeList recipe, Random random) {
		switch(villager.getProfession()) {
		case 11:
			recipe.add(new MerchantRecipe(new ItemStack(ArtificeItems.itemCoin,1,3), (new ItemStack(ItemsBackpack.backpack,1,0 + random.nextInt(15)))));
			recipe.add(new MerchantRecipe(new ItemStack(ArtificeItems.itemCoin,2,2), (new ItemStack(ItemsBackpack.boundLeather,3 + random.nextInt(4)))));
			recipe.add(new MerchantRecipe(new ItemStack(ArtificeItems.itemCoin,1,2), (new ItemStack(ItemsBackpack.tannedLeather,3 + random.nextInt(7)))));
		}
	}

}
