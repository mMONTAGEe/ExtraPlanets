package com.mjr.extraplanets.proxy;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.handlers.KeyHandlerClient;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.client.model.bosses.ModelEvolvedIceSlimeBoss;
import com.mjr.extraplanets.client.model.monsters.ModelEvolvedIceSlime;
import com.mjr.extraplanets.client.render.block.*;
import com.mjr.extraplanets.client.render.entities.RenderFireBombPrimed;
import com.mjr.extraplanets.client.render.entities.RenderNuclearBombPrimed;
import com.mjr.extraplanets.client.render.entities.bosses.*;
import com.mjr.extraplanets.client.render.entities.bosses.defaultBosses.*;
import com.mjr.extraplanets.client.render.entities.monsters.*;
import com.mjr.extraplanets.client.render.entities.rockets.*;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderMarsRover;
import com.mjr.extraplanets.client.render.entities.vehicles.RenderVenusRover;
import com.mjr.extraplanets.client.render.item.*;
import com.mjr.extraplanets.client.render.tile.*;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.*;
import com.mjr.extraplanets.entities.bosses.defaultBosses.*;
import com.mjr.extraplanets.entities.monsters.*;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.entities.rockets.*;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.extraplanets.handlers.MainHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;
import com.mjr.extraplanets.tileEntities.treasureChest.*;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import micdoodle8.mods.galacticraft.core.client.render.item.ItemRendererKey;
import micdoodle8.mods.galacticraft.planets.asteroids.client.render.item.ItemRendererThermalArmor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ClientProxy extends CommonProxy {

	public static int renderIdMachine;
	public static int treasureT4ChestID;
	public static int treasureT5ChestID;
	public static int treasureT6ChestID;
	public static int treasureT7ChestID;
	public static int treasureT8ChestID;
	public static int treasureT9ChestID;
	public static int treasureT10ChestID;
	public static int renderIdLandingPad;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		// Register Entity Renders/Models
		registerEntityRendersAndModels();
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		// Register Client Sky Provider Handler
		FMLCommonHandler.instance().bus().register(new SkyProviderHandler());

		// Register Client Key Handler
		FMLCommonHandler.instance().bus().register(new KeyHandlerClient());

		ClientRegistry.registerKeyBinding(KeyHandlerClient.openFuelGui);
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// Register Client Main Handler
		FMLCommonHandler.instance().bus().register(new MainHandler());

		// Register TileEntity Special Renderers
		renderBlocksTileEntitySpecialRenderers();

		// Register Item Renderers
		renderItemsRenders();
		super.postInit(event);
	}

	@SideOnly(Side.CLIENT)
	private void registerEntityRendersAndModels() {
		if (Config.venus) {
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossVenus.class, new RenderCreeperBossVenus());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCubeBoss.class, new RenderEvolvedMagmaCubeBoss());
		}
		if (Config.jupiter)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossJupiter.class, new RenderCreeperBossJupiter());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedFireBatBoss.class, new RenderEvolvedFireBatBoss());
		if (Config.saturn)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossSaturn.class, new RenderCreeperBossSaturn());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGhastBoss.class, new RenderEvolvedGhastBoss());
		if (Config.uranus) {
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossUranus.class, new RenderCreeperBossUranus());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlimeBoss.class, new RenderEvolvedIceSlimeBoss(new ModelEvolvedIceSlimeBoss(16), new ModelEvolvedIceSlimeBoss(0), 0.25F));
		}
		if (Config.neptune)
			if (Config.useDefaultBosses)
				RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossNeptune.class, new RenderCreeperBossNeptune());
			else
				RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedSnowmanBoss.class, new RenderEvolvedSnowmanBoss());
		if (Config.pluto)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossPluto.class, new RenderCreeperBossPluto());
		if (Config.eris)
			RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBossEris.class, new RenderCreeperBossEris());

		if (Config.evolvedMagmaCube)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMagmaCube.class, new RenderEvolvedMagmaCube());
		if (Config.evolvedIceSlime)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedIceSlime.class, new RenderEvolvedIceSlime(new ModelEvolvedIceSlime(16), new ModelEvolvedIceSlime(0), 0.25F));
		if (Config.evolvedWitch)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedWitch.class, new RenderEvolvedWitch());
		if (Config.evolvedEnderman)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedEnderman.class, new RenderEvolvedEnderman());
		if (Config.evolvedBlaze)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		if (Config.evolvedBlueCreeper)
			RenderingRegistry.registerEntityRenderingHandler(EntityBlueCreeper.class, new RenderEvolvedBlueCreeper());
		if (Config.evolvedRedCreeper)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedRedCreeper.class, new RenderEvolvedRedCreeper());
		if (Config.evolvedPowerSkeleton)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedPowerSkeleton.class, new RenderEvolvedPowerSkeleton());
		if (Config.evolvedGiantSpider)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedGiantSpider.class, new RenderEvolvedGiantSpider());
		if (Config.evolvedMiniEnderman)
			RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedMiniEnderman.class, new RenderEvolvedMiniEnderman());

		RenderingRegistry.registerEntityRenderingHandler(EntitySmallSnowball.class, new RenderSnowball(Items.snowball));

		if (Config.nuclearBomb)
			RenderingRegistry.registerEntityRenderingHandler(EntityNuclearBombPrimed.class, new RenderNuclearBombPrimed());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireBombPrimed.class, new RenderFireBombPrimed());

		if (Config.morePlanetsCompatibilityAdv143 == false) {
			if (Config.venus) {
				IModelCustom rocketModelTier4 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket4Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier4Rocket.class, new RenderTier4Rocket(rocketModelTier4, Constants.ASSET_PREFIX, "blank_rocket"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier4Rocket, new ItemRendererTier4Rocket(rocketModelTier4));
			}
			if (Config.jupiter) {
				IModelCustom rocketModelTier5 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket5Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier5Rocket.class, new RenderTier5Rocket(rocketModelTier5, Constants.ASSET_PREFIX, "blank_rocket_white"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier5Rocket, new ItemRendererTier5Rocket(rocketModelTier5));
			}
			if (Config.saturn) {
				IModelCustom rocketModelTier6 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket6Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier6Rocket.class, new RenderTier6Rocket(rocketModelTier6, Constants.ASSET_PREFIX, "blank_rocket"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier6Rocket, new ItemRendererTier6Rocket(rocketModelTier6));
			}
			if (Config.uranus) {
				IModelCustom rocketModelTier7 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket7Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier7Rocket.class, new RenderTier7Rocket(rocketModelTier7, Constants.ASSET_PREFIX, "blank_rocket_white"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier7Rocket, new ItemRendererTier7Rocket(rocketModelTier7));
			}
			if (Config.neptune) {
				IModelCustom rocketModelTier8 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket8Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier8Rocket.class, new RenderTier8Rocket(rocketModelTier8, Constants.ASSET_PREFIX, "blank_rocket_white"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier8Rocket, new ItemRendererTier8Rocket(rocketModelTier8));
			}
			if (Config.pluto) {
				IModelCustom rocketModelTier9 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket9Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier9Rocket.class, new RenderTier9Rocket(rocketModelTier9, Constants.ASSET_PREFIX, "blank_rocket_white"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier9Rocket, new ItemRendererTier9Rocket(rocketModelTier9));
			}
			if (Config.eris) {
				IModelCustom rocketModelTier10 = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/Rocket10Tier.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityTier10Rocket.class, new RenderTier10Rocket(rocketModelTier10, Constants.ASSET_PREFIX, "blank_rocket_white"));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier10Rocket, new ItemRendererTier10Rocket(rocketModelTier10));
			}
			if (Config.marsRover) {
				IModelCustom marsRover = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityMarsRover.class, new RenderMarsRover(marsRover));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.marsRover, new ItemRendererMarsRover(marsRover));
			}
			if (Config.venusRover) {
				IModelCustom venusRover = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/VenusRover.obj"));
				RenderingRegistry.registerEntityRenderingHandler(EntityVenusRover.class, new RenderVenusRover(venusRover));
				MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.venusRover, new ItemRendererVenusRover(venusRover));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static void renderBlocksTileEntitySpecialRenderers() {
		if (Config.venus) {
			treasureT4ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier4TreasureChest(treasureT4ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT4TreasureChest.class, new TileEntityT4TreasureChestRenderer());
		}
		if (Config.jupiter) {
			treasureT5ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier5TreasureChest(treasureT5ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT5TreasureChest.class, new TileEntityT5TreasureChestRenderer());
		}
		if (Config.saturn) {
			treasureT6ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier6TreasureChest(treasureT6ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT6TreasureChest.class, new TileEntityT6TreasureChestRenderer());
		}
		if (Config.uranus) {
			treasureT7ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier7TreasureChest(treasureT7ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT7TreasureChest.class, new TileEntityT7TreasureChestRenderer());
		}
		if (Config.neptune) {
			treasureT8ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier8TreasureChest(treasureT8ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT8TreasureChest.class, new TileEntityT8TreasureChestRenderer());
		}
		if (Config.pluto) {
			treasureT9ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier9TreasureChest(treasureT9ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT9TreasureChest.class, new TileEntityT9TreasureChestRenderer());
		}
		if (Config.eris) {
			treasureT10ChestID = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new BlockRendererTier10TreasureChest(treasureT10ChestID));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityT10TreasureChest.class, new TileEntityT10TreasureChestRenderer());
		}
		ClientProxy.renderIdMachine = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRendererMachine(renderIdMachine));
		renderIdLandingPad = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRendererCustomLandingPad(renderIdLandingPad));

		if (Config.solarPanels)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolar.class, new TileEntitySolarPanelRenderer());
	}

	@SideOnly(Side.CLIENT)
	private static void renderItemsRenders() {
		if (Config.venus) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T4key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t4.png")));
		}
		if (Config.jupiter) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T5key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t5.png")));
		}
		if (Config.saturn) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T6key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t6.png")));
		}
		if (Config.uranus) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T7key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t7.png")));
		}
		if (Config.neptune) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T8key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t8.png")));
		}
		if (Config.pluto) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T9key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t9.png")));
		}
		if (Config.eris) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.T10key, new ItemRendererKey(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/treasure_t10.png")));
		}
		if (Config.thermalPaddings) {
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier2ThermalPadding, new ItemRendererThermalArmor());
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier3ThermalPadding, new ItemRendererThermalArmor());
			MinecraftForgeClient.registerItemRenderer(ExtraPlanets_Items.tier4ThermalPadding, new ItemRendererThermalArmor());
		}
	}

	@SideOnly(Side.CLIENT)
	public static int getBlockRender(Block blockID) {
		if (blockID == ExtraPlanets_Machines.advancedRefinery) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.ultimateRefinery) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.advancedFuelLoader) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.ultimateFuelLoader) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.advancedOxygenCompressor) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Machines.ultimateOxygenCompressor) {
			return ClientProxy.renderIdMachine;
		}
		if (blockID == ExtraPlanets_Blocks.advancedLaunchPadFull) {
			return ClientProxy.renderIdLandingPad;
		}
		if (blockID == ExtraPlanets_Machines.chargingBlock) {
			return ClientProxy.renderIdMachine;
		}
		return -1;
	}
}
