package ro.fishmc;

import eu.raspberrymods.fishlib.ObsidianTool;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(FishMC.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item OBSIDIAN_CLAYMORE = register(new SwordItem(ObsidianTool.INSTANCE, new Item.Settings().maxCount(1).fireproof().attributeModifiers(
            SwordItem.createAttributeModifiers(
                    ObsidianTool.INSTANCE,
                    12, -1f))), "obsidian_claymore");
    public static void initialize() {
    }
}
