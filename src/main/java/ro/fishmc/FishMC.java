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
	public static final Potion BLINDNESS =
			Registry.register(
					Registries.POTION,
					new Identifier("fishmc", "blindness"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.BLINDNESS,
									3600,
									0)));
	public static final Potion GLOWING =
			Registry.register(
					Registries.POTION,
					new Identifier("fishmc", "glowing"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.GLOWING,
									800,
									0)));
	public static final Potion LEVITATION =
			Registry.register(
					Registries.POTION,
					new Identifier("fishmc", "levitation"),
					new Potion(
							new StatusEffectInstance(
									StatusEffects.LEVITATION,
									3600,
									0)));
	public static final Potion STUNNED =
			Registry.register(
					Registries.POTION,
					new Identifier("fishmc", "stunned"),new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 200), new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 200)}));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Welcome to FishMC!");
		//BrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Items.POTATO, DECAY);
	}
}
