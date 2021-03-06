package minechem.apparatus.electrolysis;

import minechem.Compendium;
import minechem.apparatus.prefab.renderer.BasicTileEntityRenderer;

public class ElectrolysisTileEntityRenderer extends BasicTileEntityRenderer<ElectrolysisTileEntity, ElectrolysisModel>
{
    public ElectrolysisTileEntityRenderer()
    {
        super(0.4F, 0.0625F);

        setOffset(0.5D, 0.6D, 0.5D);

        model = new ElectrolysisModel();
        texture = Compendium.Resource.Model.electrolysis;
    }

    public void applyChangesToModel(ElectrolysisTileEntity tileEntity) {
        model.setLeftTube(true);
        model.setRightTube(true);
    }

}
