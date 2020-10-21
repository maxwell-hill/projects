/*************************************************************
 ****************CODAKID MINECRAFT MODDING********************
 *************************************************************/

package mymod;

import org.apache.logging.log4j.Logger;

import mymod.CodakidFiles.Codakid;
import mymod._03_MagicArmor.CustomArmor;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, useMetadata = true)
public class Main {

    public static final String MODID = "foundations";
    public static final String MODNAME = "YOUR MOD NAME HERE";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "mymod.CodakidFiles.ClientProxy", serverSide = "mymod.CodakidFiles.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance
    public static Main instance;
    public static Logger logger;
    
    //************* DECLARE VARIABLES ***************
    public static CustomArmor myHelmet;
    public static CustomArmor myChestplate;
    public static CustomArmor myLeggings;
    public static CustomArmor myBoots;
    public static ArmorMaterial myArmorMaterial;
    
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	
    	//************* INITIALIZE MATERIALS ***************
    	myArmorMaterial = EnumHelper.addArmorMaterial("magic ore", MODID + ":my_armor", 999999999, new int[] {20, 20, 20, 20}, 999999999, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, 111);
    	
    	
    	//************* INITIALIZE VARIABLES ***************
    	myHelmet = new CustomArmor(1, EntityEquipmentSlot.HEAD);
    	myChestplate = new CustomArmor(1, EntityEquipmentSlot.CHEST);
    	myLeggings = new CustomArmor(2, EntityEquipmentSlot.LEGS);
    	myBoots = new CustomArmor(1, EntityEquipmentSlot.FEET );
    	
    	
    	
    	
        proxy.preInit(event);
    }
    

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	Codakid.initModels();
    }

}