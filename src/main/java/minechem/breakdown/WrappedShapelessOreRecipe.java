package minechem.breakdown;

import minechem.api.breakdown.IReverseRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

public class WrappedShapelessOreRecipe implements IReverseRecipe {
    private List<ItemStack> inputs;
    private ItemStack output;

    public WrappedShapelessOreRecipe(ShapelessOreRecipe recipe) {
        inputs = convertInputs(recipe.getInput());
        output = recipe.getRecipeOutput().copy();
    }

    @Override
    public boolean canOutput(final ItemStack stack) {
        return OreDictionary.itemMatches(stack, output, false);
    }

    @Override
    public List<ItemStack> getInputs(ItemStack stack) {
        return inputs;
    }

    @Override
    public int getOutputAmount(ItemStack stack) {
        return output.getCount();
    }

    private List<ItemStack> convertInputs(NonNullList<Object> input) {
        List<ItemStack> inputs = new ArrayList<>();
        for (Object entry : input) {
            if (entry instanceof ItemStack) {
                inputs.add(((ItemStack) entry).copy());
            } else if (entry instanceof List) {
                inputs.add(((List<ItemStack>) entry).get(0).copy());
            }
        }
        return inputs;
    }
}
