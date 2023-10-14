package dev.hail.caststonearsenal.foundation.data.recipe;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public abstract class CSARecipeProvider extends CreateRecipeProvider {
    public CSARecipeProvider(PackOutput output) {
        super(output);
    }

    protected static class I {

        static TagKey<Item> csiMaterial() {
            return AllTags.forgeItemTag("csi_material");
        }
    }
}
