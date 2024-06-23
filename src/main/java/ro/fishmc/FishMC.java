package ro.fishmc;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishMC implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("fishmc");
	public static final Potion DECAY =
			Registry.register(
					Registries.POTION,
					new Identifier("fishmc", "decay"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.WITHER,
									3600,
									1)));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Welcome to FishMC!");
		//BrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Items.POTATO, DECAY);
	}
}