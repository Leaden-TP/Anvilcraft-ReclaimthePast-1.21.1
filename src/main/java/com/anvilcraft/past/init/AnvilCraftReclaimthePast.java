package com.anvilcraft.past.init;

import dev.anvilcraft.lib.v2.registrum.Registrum;
import dev.dubhe.anvilcraft.util.ModInteractionMap;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AnvilCraftReclaimthePast.MODID)
public class AnvilCraftReclaimthePast {
    public static final String MODID = "reclaimthepast";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Registrum REGISTRATE = Registrum.create(MODID);
//    public static final ModServerConfig CONFIG = ConfigManager.register(AnvilCraftReclaimingthePast.MODID, ModServerConfig::new);

    public AnvilCraftReclaimthePast(IEventBus modEventBus, ModContainer modContainer) {
//        CREATIVE_MODE_TABS.register(modEventBus);
//        ModEntities.ENTITY_TYPES.register(modEventBus);
//        BLOCKS.register(modEventBus);
//        ITEMS.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
//        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerPayload);
//        ModSounds.SOUNDS.register(modEventBus);
//        ModDamageTypes.DAMAGE_TYPES.register(modEventBus);
//
//
//        ModBlockEntity.register();
//        ModFluids.register(modEventBus);
//        ModDatagen.init();
    }

    private static void registerEvents(@NotNull IEventBus eventBus) {
        eventBus.addListener(AnvilCraftReclaimthePast::loadComplete);
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void loadComplete(@NotNull FMLLoadCompleteEvent event) {
        event.enqueueWork(ModInteractionMap::initInteractionMap);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("AnvilCraft:Reclaiming the Past initialized!");
        LOGGER.info("(*^▽^*)");
    }

    @SubscribeEvent
    public void registerPayload(@NotNull RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
//        ModNetworks.init(registrar);
    }
}
