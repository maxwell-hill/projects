package mymod._03_MagicArmor;

import mymod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CustomArmor extends  ItemArmor {
	public CustomArmor(int renderIndex, EntityEquipmentSlot armorType ) {
		super(Main.myArmorMaterial, renderIndex, armorType);
	this.setCreativeTab(CreativeTabs.COMBAT);

	
	
	
	
	}
	@Override
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack itemIn)  {
	playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 50));	
	playerIn.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 20, 13));
	playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 20, 7));
	playerIn.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 20, 7));
	playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20, 14));
	
	}
	


}


