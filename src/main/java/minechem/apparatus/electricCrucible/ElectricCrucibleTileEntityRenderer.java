package minechem.apparatus.electricCrucible;

import minechem.Compendium;
import minechem.apparatus.prefab.renderer.BasicTileEntityRenderer;

public class ElectricCrucibleTileEntityRenderer extends BasicTileEntityRenderer<ElectricCrucibleTileEntity, ElectricCrucibleModel>
{

    public ElectricCrucibleTileEntityRenderer()
    {
        super(0.24F, 0.0625F);

        setOffset(0.5D, 0.36D, 0.5D);

        model = new ElectricCrucibleModel();
        texture = Compendium.Resource.Model.electricCrucible;
    }

}
