package com.mjr.extraplanets.planets.Kepler22b.worldgen.biome;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;

public class BiomeGenKepler22bBlueMapleForest extends Kepler22bBiomes {
	@SuppressWarnings("unchecked")
	public BiomeGenKepler22bBlueMapleForest() {
		super(Config.kepler22bBlueForestBiomeID);
		this.enableRain = true;
		this.enableSnow = true;
		this.setTemperatureRainfall(0.8F, 0.9F);
		this.topBlock = ExtraPlanets_Blocks.kepler22bBlueGrass;
		this.topMeta = 0;
		this.fillerBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.fillerMeta = 0;
		this.stoneBlock = ExtraPlanets_Blocks.kepler22bBlocks;
		this.stoneMeta = 1;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));

		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));

		this.getBiomeDecorator().blueTreesPerChunk = 5;
		this.getBiomeDecorator().blueShortGrassPerChunk = 90;
		this.getBiomeDecorator().blueMedGrassPerChunk = 90;
		this.getBiomeDecorator().blueTallGrassPerChunk = 90;
		this.getBiomeDecorator().blueBigTreesPerChunk = 50;
		this.getBiomeDecorator().blueTowerPerChunk = 10;
	}
}