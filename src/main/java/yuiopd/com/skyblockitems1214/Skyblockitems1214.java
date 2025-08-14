package yuiopd.com.skyblockitems1214;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import yuiopd.com.skyblockitems1214.a.ModItems;
import yuiopd.com.skyblockitems1214.teleport.Aote;



public class Skyblockitems1214 implements ModInitializer {
    public static final Item aote = ModItems.register("aote", Aote::new, new Aote.Settings());
    @Override
    public void onInitialize() {

        ModItems.initialize();


    }
}
