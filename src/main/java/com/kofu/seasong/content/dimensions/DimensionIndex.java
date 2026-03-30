package com.kofu.seasong.content.dimensions;

import java.lang.reflect.Array;
import java.util.ArrayList;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class DimensionIndex {

    private static ArrayList<ResourceKey<Level>> Indexed = new ArrayList<ResourceKey<Level>>();

    private static void Initialize() {
        Indexed.add(ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath("seasong", "surface_depths")));
        Indexed.add(ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath("seasong", "twilight_depths")));
        Indexed.add(ResourceKey.create(Registries.DIMENSION,
                ResourceLocation.fromNamespaceAndPath("seasong", "thalassic_abyss")));
    }

    public static ArrayList<ResourceKey<Level>> GetIdx() {
        if (Indexed.isEmpty())
            Initialize();

        return Indexed;
    }

}
