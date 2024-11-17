package ro.fishmc;

import eu.raspberrymods.fishlib.ObsidianTool;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(FishMC.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item OBSIDIAN_CLAYMORE = register(new SwordItem(ObsidianTool.INSTANCE, new Item.Properties().stacksTo(1).fireResistant().attributes(
            SwordItem.createAttributes(
                    ObsidianTool.INSTANCE,
                    12, -0.5f))), "obsidian_claymore");
    public static void initialize() {
    }
}
