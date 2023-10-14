package dev.hail.caststonearsenal.foundation.data.recipe;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.foundation.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import dev.hail.caststonearsenal.collection.CSAItems;
import dev.hail.caststonearsenal.collection.CSATags;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;

import java.util.stream.Stream;

public class CSASequencedAssemblyRecipeGen extends SequencedAssemblyRecipeGen {
    //GeneratedRecipe
    /*REINFORCED_SHEET = create("sturdy_sheet", b -> b.require(CSATags.CSAItemTags.BASALT.tag)
            .transitionTo(CSAItems.INCOMPLETE_CAST_STONE_INGOT.get())
            .addOutput(CSAItems.CAST_STONE_INGOT.get(), 1)
            .loops(1)
            .addStep(MixingRecipe::new,
                    rb -> rb.require(Ingredient.fromValues(
                            Stream.of(new Ingredient.TagValue(CSARecipeProvider.I.csiMaterial())))))
            .addStep(PressingRecipe::new, rb -> rb));*/

    public CSASequencedAssemblyRecipeGen(PackOutput p_i48262_1_) {
        super(p_i48262_1_);
    }
}
