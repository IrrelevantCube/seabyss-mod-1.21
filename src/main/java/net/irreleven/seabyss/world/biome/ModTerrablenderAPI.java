package net.irreleven.seabyss.world.biome;

import net.irreleven.seabyss.ShoreEbbAbyss;
import net.irreleven.seabyss.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegions(Identifier.of(ShoreEbbAbyss.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, ShoreEbbAbyss.MOD_ID, ModMaterialRules.makeRules());
    }
}
