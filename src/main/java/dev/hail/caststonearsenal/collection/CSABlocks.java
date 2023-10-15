package dev.hail.caststonearsenal.collection;

import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.palettes.LayeredBlock;
import com.simibubi.create.content.decoration.palettes.PaletteBlockPattern;
import com.simibubi.create.content.logistics.vault.ItemVaultCTBehaviour;
import com.simibubi.create.foundation.block.CopperBlockSet;
import com.simibubi.create.foundation.block.connected.*;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import dev.hail.caststonearsenal.CastStoneArsenal;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.Tags;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.simibubi.create.content.decoration.palettes.PaletteBlockPattern.CTs.CAP;
import static com.simibubi.create.content.decoration.palettes.PaletteBlockPattern.STANDARD_RANGE;
import static com.simibubi.create.content.fluids.PipeConnection.r;
import static com.simibubi.create.foundation.block.connected.CTSpriteShifter.getCT;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static dev.hail.caststonearsenal.CastStoneArsenal.REGISTRATE;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

public class CSABlocks {
    static {
        CastStoneArsenal.REGISTRATE.setCreativeTab(CastStoneArsenal.CSA_TAB);
    }

    public static <T extends Block> BlockEntry<T> castStonePattern(String Name, NonNullFunction<BlockBehaviour.Properties, T> Type){
        return REGISTRATE.block(Name, Type)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(pickaxeOnly())
                .properties(p -> p.mapColor(MapColor.METAL).requiresCorrectToolForDrops())
                .tag(BlockTags.NEEDS_STONE_TOOL)
                //.tag(Tags.Blocks.STORAGE_BLOCKS)
                .transform(tagBlockAndItem("storage_blocks/cast_stone"))
                .build()
                //.onRegister(ConnectedTex)
                .register();
    }
    public static final BlockEntry<Block> CAST_STONE_BRICKS = castStonePattern("cast_stone_bricks",Block::new);
    public static final BlockEntry<StairBlock> CAST_STONE_BRICK_STAIRS = castStonePattern("cast_stone_brick_stairs",prop->new StairBlock(CAST_STONE_BRICKS.getDefaultState(),prop));
    public static final BlockEntry<SlabBlock> CAST_STONE_BRICK_SLAB = castStonePattern("cast_stone_brick_slab",SlabBlock::new);
    public static final BlockEntry<WallBlock> CAST_STONE_BRICK_WALL = castStonePattern("cast_stone_brick_wall",WallBlock::new);
    public static final BlockEntry<Block> CAST_STONE_BLOCK = castStonePattern("cast_stone_block",Block::new);
    public static final BlockEntry<StairBlock> CAST_STONE_STAIRS = castStonePattern("cast_stone_stairs",prop->new StairBlock(CAST_STONE_BLOCK.getDefaultState(),prop));
    public static final BlockEntry<SlabBlock> CAST_STONE_SLAB = castStonePattern("cast_stone_slab",SlabBlock::new);
    public static final BlockEntry<WallBlock> CAST_STONE_WALL = castStonePattern("cast_stone_wall",WallBlock::new);
    public static final BlockEntry<Block> CAST_STONE_PANEL = castStonePattern("cast_stone_panel",Block::new);
    public static final BlockEntry<StairBlock> CAST_STONE_PANEL_STAIRS = castStonePattern("cast_stone_panel_stairs",prop->new StairBlock(CAST_STONE_PANEL.getDefaultState(),prop));
    public static final BlockEntry<SlabBlock> CAST_STONE_PANEL_SLAB = castStonePattern("cast_stone_panel_slab",SlabBlock::new);
    public static final BlockEntry<WallBlock> CAST_STONE_PANEL_WALL = castStonePattern("cast_stone_panel_wall",WallBlock::new);
    public static final BlockEntry<Block> CAST_STONE_TILES = castStonePattern("cast_stone_tiles",Block::new);
    public static final BlockEntry<StairBlock> CAST_STONE_TILE_STAIRS = castStonePattern("cast_stone_tile_stairs",prop->new StairBlock(CAST_STONE_TILES.getDefaultState(),prop));
    public static final BlockEntry<SlabBlock> CAST_STONE_TILE_SLAB = castStonePattern("cast_stone_tile_slab",SlabBlock::new);
    public static final BlockEntry<WallBlock> CAST_STONE_TILE_WALL = castStonePattern("cast_stone_tile_wall",WallBlock::new);
    public static final BlockEntry<LayeredBlock> LAYERED_CAST_STONE = REGISTRATE.block("layered_cast_stone",LayeredBlock::new)
            .onRegister(CreateRegistrate.connectedTextures(()-> new SimpleCTBehaviour(getCT(AllCTTypes.OMNIDIRECTIONAL,new ResourceLocation("cast_stone_cap_connected"), new ResourceLocation("cast_stone_cap_connected")))))
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .transform(pickaxeOnly())
            .properties(p -> p.mapColor(MapColor.METAL).requiresCorrectToolForDrops())
            .tag(BlockTags.NEEDS_STONE_TOOL)
            //.tag(Tags.Blocks.STORAGE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/cast_stone"))
            .build()
            .register();
    public static final BlockEntry<RotatedPillarBlock> CAST_STONE_PILLAR = castStonePattern("cast_stone_pillar",RotatedPillarBlock::new);


    /*connectedTextures(()-> new HorizontalCTBehaviour(
            CTSpriteShifter.getCT(CAP.type, new ResourceLocation("_connected"), new ResourceLocation("_connected")),
            CTSpriteShifter.getCT(CAP.type, new ResourceLocation("_connected"), new ResourceLocation("_connected"))))*/
    public static void register() {

    }
}
