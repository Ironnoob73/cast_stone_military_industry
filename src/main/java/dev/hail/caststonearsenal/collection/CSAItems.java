package dev.hail.caststonearsenal.collection;

import com.simibubi.create.AllItems;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.hail.caststonearsenal.CastStoneArsenal;
import net.minecraft.world.item.Item;

import static dev.hail.caststonearsenal.CastStoneArsenal.REGISTRATE;

public class CSAItems extends AllItems {
    static {
        CastStoneArsenal.REGISTRATE.setCreativeTab(CastStoneArsenal.CSA_TAB);
    }
    public static final ItemEntry<Item> CAST_STONE_INGOT = REGISTRATE.item("cast_stone_ingot", Item::new).register();
    public static final ItemEntry<Item> MOLTEN_BASALT = REGISTRATE.item("molten_basalt", Item::new).register();

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }
    public static void register() {

    }
}
