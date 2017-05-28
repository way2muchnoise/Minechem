package minechem.item.chemical;

import minechem.chemical.ChemicalBase;
import minechem.helper.Jenkins;
import minechem.item.prefab.BasicItem;
import minechem.registry.CreativeTabRegistry;
import minechem.registry.ItemRegistry;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ChemicalItem extends BasicItem
{
    public ChemicalItem()
    {
        super("chemical");
        setCreativeTab(CreativeTabRegistry.TAB_CHEMICALS);
    }

    @SideOnly(Side.CLIENT)
    public void initModels() {
        ModelResourceLocation dust = new ModelResourceLocation(getRegistryName() + "_dust", "inventory");
        ModelResourceLocation liquid = new ModelResourceLocation(getRegistryName() + "_liquid", "inventory");
        ModelResourceLocation gas = new ModelResourceLocation(getRegistryName() + "_gas", "inventory");
        ModelResourceLocation plasma = new ModelResourceLocation(getRegistryName() + "_plasma", "inventory");

        ModelBakery.registerItemVariants(this, dust, liquid, gas, plasma);

        ModelLoader.setCustomMeshDefinition(this, stack -> {
            ChemicalBase chemical = getChemicalBase(stack);
            switch (chemical.form) {
                case solid:
                    return dust;
                case liquid:
                    return liquid;
                case gas:
                    return gas;
                case plasma:
                    return plasma;
                default:
                    return null;
            }
        });
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack)
    {
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("fullName"))
        {
            return itemStack.getTagCompound().getString("fullName");
        } else
        {
            return "Generic ChemicalItem";
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List tooltip, boolean bool)
    {
        super.addInformation(itemStack, player, tooltip, bool);
        ChemicalBase chemicalBase = getChemicalBase(itemStack);
        if (chemicalBase != null)
        {
            tooltip.addAll(chemicalBase.getToolTip());
        }
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        ItemStack itemStack;
        NBTTagCompound tagCompound;
        for (ChemicalBase element : Jenkins.getAll())
        {
            itemStack = new ItemStack(this);
            tagCompound = new NBTTagCompound();
            element.writeToNBT(tagCompound);
            itemStack.setTagCompound(tagCompound);
            subItems.add(itemStack);
        }
    }

    public static ChemicalBase getChemicalBase(ItemStack itemStack)
    {
        return ChemicalBase.readFromNBT(itemStack.getTagCompound());
    }

    public static ItemStack getItemStackForChemical(ChemicalBase chemicalBase)
    {
        ItemStack itemStack = new ItemStack(ItemRegistry.chemicalItem);
        NBTTagCompound tag = new NBTTagCompound();
        chemicalBase.writeToNBT(tag);
        itemStack.setTagCompound(tag);
        return itemStack;
    }
}
