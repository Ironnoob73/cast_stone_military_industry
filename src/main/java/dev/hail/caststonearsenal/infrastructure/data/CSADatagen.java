package dev.hail.caststonearsenal.infrastructure.data;

import com.simibubi.create.foundation.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.infrastructure.data.CreateDatagen;
import dev.hail.caststonearsenal.foundation.data.recipe.CSASequencedAssemblyRecipeGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

public class CSADatagen extends CreateDatagen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        if (event.includeServer()) {
            generator.addProvider(true, new CSASequencedAssemblyRecipeGen(output));
        }
    }
}
