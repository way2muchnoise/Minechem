package minechem.helper;

import java.util.Random;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHelper
{
    public static void throwItemStack(World world, ItemStack itemStack, BlockPos pos) {
        throwItemStack(world, itemStack, pos.getX(), pos.getY(), pos.getZ());
    }

    public static void throwItemStack(World world, ItemStack itemStack, double x, double y, double z)
    {
        if (itemStack != null)
        {
            Random random = new Random();
            float xFloat = random.nextFloat() * 0.8F + 0.1F;
            float yFloat = random.nextFloat() * 0.8F + 0.1F;
            float zFloat = random.nextFloat() * 0.8F + 0.1F;
            float motionMultiplier = 0.05F;

            EntityItem entityitem = new EntityItem(world, (float) x + xFloat, (float) y + yFloat, (float) z + zFloat, itemStack);

            entityitem.motionX = (float) random.nextGaussian() * motionMultiplier;
            entityitem.motionY = (float) random.nextGaussian() * motionMultiplier + 0.2F;
            entityitem.motionZ = (float) random.nextGaussian() * motionMultiplier;

            world.spawnEntity(entityitem);
        }
    }
}
