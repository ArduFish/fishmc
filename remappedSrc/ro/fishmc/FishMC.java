package ro.fishmc;

import net.fabric_extras.ranged_weapon.api.CustomBow;
import net.fabric_extras.ranged_weapon.api.RangedConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishMC implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "fishmc";
    public static final Logger LOGGER = LoggerFactory.getLogger("fishmc");
	public static final Potion DECAY =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "decay"),
					new Potion(
							new MobEffectInstance(
									MobEffects.WITHER,
									3600,
									1)));
	public static final Potion BLINDNESS =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "blindness"),
					new Potion(
							new MobEffectInstance(
									MobEffects.BLINDNESS,
									3600,
									0)));
	public static final Potion GLOWING =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "glowing"),
					new Potion(
							new MobEffectInstance(
									MobEffects.GLOWING,
									800,
									0)));
	public static final Potion LEVITATION =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "levitation"),
					new Potion(
							new MobEffectInstance(
									MobEffects.LEVITATION,
									3600,
									0)));
	public static final Potion STUNNED =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "stunned"),new Potion(new MobEffectInstance[]{new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 200), new MobEffectInstance(MobEffects.WEAKNESS, 400, 200), new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 200)}));
	public static final Potion SHULKERCRAFT =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "shulkercraft"),new Potion(new MobEffectInstance[]{new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 200), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2)}));
	public static final Potion CRAFTABLE_DECAY =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "craftable_decay"),
					new Potion(
							new MobEffectInstance(
									MobEffects.WITHER,
									400,
									1)));
	public static final Potion CRAFTABLE_BLINDNESS =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "craftable_blindness"),
					new Potion(
							new MobEffectInstance(
									MobEffects.BLINDNESS,
									400,
									0)));
	public static final Potion CRAFTABLE_GLOWING =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "craftable_glowing"),
					new Potion(
							new MobEffectInstance(
									MobEffects.GLOWING,
									400,
									0)));
	public static final Potion CRAFTABLE_LEVITATION =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "craftable_levitation"),
					new Potion(
							new MobEffectInstance(
									MobEffects.LEVITATION,
									400,
									0)));
	public static final Potion CRAFTABLE_STUNNED =
			Registry.register(
					BuiltInRegistries.POTION,
					ResourceLocation.fromNamespaceAndPath("fishmc", "craftable_stunned"),new Potion(new MobEffectInstance[]{new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 200), new MobEffectInstance(MobEffects.WEAKNESS, 400, 200), new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 400, 200)}));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Welcome to FishMC!");
		var bow = new CustomBow(
				new Item.Properties().durability(150),
				new RangedConfig(3, -0.7F, 5),
				() -> Ingredient.of(Items.OAK_WOOD)
		);
		Registry.register(
				BuiltInRegistries.ITEM,
				ResourceLocation.fromNamespaceAndPath(FishMC.MOD_ID, "shortbow"),
				bow
		);
		ModItems.initialize();
		//Registry.registerPotionRecipe(Potions.WATER, Items.POTATO, DECAY);
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.WITHER_ROSE,
					// Output potion.
					Holder.direct(CRAFTABLE_DECAY)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.FERMENTED_SPIDER_EYE,
					// Output potion.
					Holder.direct(CRAFTABLE_BLINDNESS)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.GLOW_BERRIES,
					// Output potion.
					Holder.direct(CRAFTABLE_GLOWING)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.SHULKER_SHELL,
					// Output potion.
					Holder.direct(CRAFTABLE_LEVITATION)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.OMINOUS_BOTTLE,
					// Output potion.
					Holder.direct(CRAFTABLE_STUNNED)
			);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.addMix(
					// Input potion.
					Potions.AWKWARD,
					// Ingredient
					Items.SHULKER_BOX,
					// Output potion.
					Holder.direct(SHULKERCRAFT)
			);
		});
	}
}
