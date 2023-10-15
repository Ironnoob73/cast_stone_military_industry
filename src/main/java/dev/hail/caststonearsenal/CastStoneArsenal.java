package dev.hail.caststonearsenal;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.hail.caststonearsenal.collection.CSABlocks;
import dev.hail.caststonearsenal.collection.CSAItems;
import dev.hail.caststonearsenal.infrastructure.data.CSADatagen;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static com.simibubi.create.AllBlocks.*;
import static com.simibubi.create.AllItems.*;
import static dev.hail.caststonearsenal.collection.CSABlocks.*;
import static dev.hail.caststonearsenal.collection.CSAItems.*;

@Mod(CastStoneArsenal.MODID)
public class CastStoneArsenal
{
    public static final String MODID = "cast_stone_arsenal";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CastStoneArsenal.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> CSA_TAB = CREATIVE_MODE_TABS.register("csa_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("cast_stone_arsenal.name"))
            .icon(() -> CAST_STONE_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CAST_STONE_INGOT.get());
                output.accept(CAST_STONE_BRICKS.get());
                output.accept(CAST_STONE_BRICK_STAIRS.get());
                output.accept(CAST_STONE_BRICK_SLAB.get());
                output.accept(CAST_STONE_BRICK_WALL.get());
                output.accept(CAST_STONE_BLOCK.get());
                output.accept(CAST_STONE_STAIRS.get());
                output.accept(CAST_STONE_SLAB.get());
                output.accept(CAST_STONE_WALL.get());
                output.accept(CAST_STONE_PANEL.get());
                output.accept(CAST_STONE_PANEL_STAIRS.get());
                output.accept(CAST_STONE_PANEL_SLAB.get());
                output.accept(CAST_STONE_PANEL_WALL.get());
                output.accept(CAST_STONE_TILES.get());
                output.accept(CAST_STONE_TILE_STAIRS.get());
                output.accept(CAST_STONE_TILE_SLAB.get());
                output.accept(CAST_STONE_TILE_WALL.get());
                output.accept(LAYERED_CAST_STONE.get());
                output.accept(CAST_STONE_PILLAR.get());
                output.accept(MOLTEN_BASALT.get());
                //Hidden Item
                //output.accept(Blocks.AIR);
                output.accept(CHROMATIC_COMPOUND.get());
                output.accept(SHADOW_STEEL.get());
                output.accept(REFINED_RADIANCE.get());
                output.accept(SHADOW_STEEL_CASING.get());
                output.accept(REFINED_RADIANCE_CASING.get());
            }).build());

    public CastStoneArsenal()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);

        REGISTRATE.registerEventListeners(modEventBus);
        CSAItems.register();
        CSABlocks.register();
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        modEventBus.addListener(EventPriority.LOWEST, CSADatagen::gatherData);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
