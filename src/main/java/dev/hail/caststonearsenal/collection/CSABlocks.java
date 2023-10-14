package dev.hail.caststonearsenal.collection;

import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.CopperBlockSet;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import dev.hail.caststonearsenal.CastStoneArsenal;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.Tags;

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
                .transform(pickaxeOnly())
                .tag(BlockTags.NEEDS_STONE_TOOL)
                .tag(Tags.Blocks.STORAGE_BLOCKS)
                .transform(tagBlockAndItem("storage_blocks/cast_stone"))
                .tag(Tags.Items.STORAGE_BLOCKS)
                .build()
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
    public static final BlockEntry<Block> CAST_STONE_TILE = castStonePattern("cast_stone_tile",Block::new);
    public static final BlockEntry<StairBlock> CAST_STONE_TILE_STAIRS = castStonePattern("cast_stone_tile_stairs",prop->new StairBlock(CAST_STONE_BLOCK.getDefaultState(),prop));
    public static final BlockEntry<SlabBlock> CAST_STONE_TILE_SLAB = castStonePattern("cast_stone_tile_slab",SlabBlock::new);
    public static final BlockEntry<WallBlock> CAST_STONE_TILE_WALL = castStonePattern("cast_stone_tile_wall",WallBlock::new);

    public static void register() {

    }
}
