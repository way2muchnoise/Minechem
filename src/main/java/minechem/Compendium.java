package minechem;

import net.afterlifelochie.fontbox.api.FontboxManager;
import net.afterlifelochie.fontbox.api.tracer.ITracer;
import net.minecraftforge.fml.common.ModMetadata;
import java.util.Arrays;

import minechem.helper.LogHelper;
import minechem.helper.StringHelper;
import net.minecraft.util.ResourceLocation;

/*
 * A compendium of all constants for the mod, such as the modID and ResourceLocations, as well as more general things like color codes
 */
public class Compendium
{
    public static final class Color
    {
        public static final class TextFormat
        {
            public static final String black = "\u00A70";
            public static final String darkBlue = "\u00A71";
            public static final String darkCyan = "\u00A73";
            public static final String darkGreen = "\u00A72";
            public static final String darkGrey = "\u00A78";
            public static final String darkRed = "\u00A74";
            public static final String lightBlue = "\u00A79";
            public static final String lightCyan = "\u00A7b";
            public static final String lightGreen = "\u00A7a";
            public static final String lightGrey = "\u00A77";
            public static final String lightRed = "\u00A7c";
            public static final String orange = "\u00A76";
            public static final String pink = "\u00A7d";
            public static final String purple = "\u00A75";
            public static final String white = "\u00A7f";
            public static final String yellow = "\u00A7e";
        }

        public static final class TrueColor
        {
            public static final int black = -16777216;
            public static final int blue = -16776961;
            public static final int cyan = -16711681;
            public static final int darkGrey = -12303292;
            public static final int grey = -7829368;
            public static final int green = -16711936;
            public static final int lightGrey = -3355444;
            public static final int magenta = -65281;
            public static final int red = -65536;
            public static final int transparent = 0;
            public static final int white = -1;
            public static final int yellow = -256;
        }

    }

    public static final class Config
    {
        public static final String configPrefix = "config/minechem/";
        public static final String assetPrefix = "/assets/minechem/";
        public static final String dataJsonPrefix = "data/";
        public static final String elementsDataJson = "elements_data.json";
        public static final String moleculesDataJson = "molecules_data.json";
        public static final String researchPagesJson = "pages.json";
        public static final String reactionsJson = "reactions.json";
        public static final String playerResearchData = "minechem/research_data.json";
    }

    public static final class MetaData
    {
        public static final String patreon = "https://www.patreon.com/jakimfett";

        /**
         * Setup mod metadata
         *
         * @param metadata
         * @return edited metadata object
         */
        public static ModMetadata init(ModMetadata metadata)
        {
            metadata.modId = Compendium.Naming.id;
            metadata.name = Compendium.Naming.name;
            metadata.description = Compendium.Naming.name + " is a mod about chemistry, allowing you to research blocks and items, and then break them down into their base compounds and elements.";
            metadata.url = "http://www.minechemmod.com/";
            metadata.logoFile = "assets/" + Compendium.Naming.id + "/logo.png";
            metadata.version = Compendium.Version.full;
            metadata.authorList = Arrays.asList("jakimfett", "hilburn", "way2muchnoise");
            metadata.credits = "View a full list of contributors on our site!";
            metadata.autogenerated = false;
            return metadata;
        }
    }

    public static final class Naming {
        public static final String id = "minechem";
        public static final String name = "Minechem";
        public static final String fontBox = "fontbox";
        public static final String chemicals = "chemicals";
        public static final String opticalMicroscope = "optical_microscope";
        public static final String electrolysis = "electrolysis";
        public static final String electricCrucible = "electric_crucible";
        public static final String centrifuge = "centrifuge";
        public static final String journal = "journal";
        public static final String light = "light";
        public static final String redstone = "redstone";
    }

    public static final class Fontbox
    {
        private static FontboxManager manager;

        public static FontboxManager getManager() {
            if (manager == null) {
                manager = new FontboxManager();
                manager.setTracer(new Tracer());
            }
            return manager;
        }

        public static final class Tracer implements ITracer
        {
            @Override
            public void trace(Object... params)
            {
                LogHelper.debug("Fontbox trace: " + StringHelper.toString(", ", params));
            }

            @Override
            public void warn(Object... params)
            {
                LogHelper.warn("Fontbox warn: " + StringHelper.toString(", ", params));
            }

            @Override
            public boolean enableAssertion()
            {
                return false;
            }
        }
    }

    public static final class Resource
    {
        public static final class Icon
        {
            public static final ResourceLocation patreon = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Icon.patreon);
        }

        public static final class GUI
        {
            public static final ResourceLocation journal = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.journal);
            public static final ResourceLocation opticalMicroscope = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.opticalMicroscope);
            public static final ResourceLocation centrifuge = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.centrifuge);
            public static final ResourceLocation electricCrucible = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.electricCrucible);
            public static final ResourceLocation electrolysis = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.electrolysis);
            public static final ResourceLocation achievements = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.achievements);
            public static final ResourceLocation noContent = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.noContent);
            public static final ResourceLocation guiElements = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.guiElements);

            public static ResourceLocation getResourceForStructure(String name)
            {
                return new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.compounds + name.replaceAll("\\s", "_") + ".png");
            }
        }

        public static final class Model
        {
            public static final ResourceLocation microscope = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.opticalMicroscope);
            public static final ResourceLocation electrolysis = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.electrolysis);
            public static final ResourceLocation electricCrucible = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.electricCrucible);
            public static final ResourceLocation centrifuge = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.Model.centrifuge);
        }

        public static final class Tab
        {
            public static final ResourceLocation right = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.tab_right);
            public static final ResourceLocation left = new ResourceLocation(Compendium.Naming.id, Compendium.Texture.GUI.tab_left);
        }

        public static final class Font
        {
            public static final ResourceLocation danielFont = new ResourceLocation(Compendium.Naming.fontBox, Compendium.Texture.Font.danielFont);
            public static final ResourceLocation danielMetrics = new ResourceLocation(Compendium.Naming.fontBox, Compendium.Texture.Font.danielMetrics);
            public static final ResourceLocation vanilla = new ResourceLocation("textures/font/ascii.png");
        }
    }

    public static final class Texture
    {
        public static final String prefix = Compendium.Naming.id + ":";

        public static final class IIcon
        {

        }

        public static final class Icon
        {

            private static final String prefix = "textures/icons/";
            public static final String patreon = Compendium.Texture.Icon.prefix + "patreon.png";
        }

        public static final class Item
        {

            private static final String prefix = "textures/item/";
            private static final String suffix = "Icon.png";
            public static final String augmentDefault = Compendium.Texture.Item.prefix + "augment" + Compendium.Texture.Item.suffix;
        }

        public static final class GUI
        {
            private static final String prefix = "textures/gui/";
            public static final String compounds = Compendium.Texture.GUI.prefix + "compounds/";

            public static final String blankMachine = Compendium.Texture.GUI.prefix + "blank_machine.png";
            public static final String journal = Compendium.Texture.GUI.prefix + "journal.png";
            public static final String opticalMicroscope = Compendium.Texture.GUI.prefix + "optical_microscope.png";
            public static final String centrifuge = Compendium.Texture.GUI.prefix + "centrifuge.png";
            public static final String electricCrucible = Compendium.Texture.GUI.prefix + "electric_crucible.png";
            public static final String electrolysis = Compendium.Texture.GUI.prefix + "electrolysis.png";
            public static final String tab_left = Compendium.Texture.GUI.prefix + "tabLeft.png";
            public static final String tab_right = Compendium.Texture.GUI.prefix + "tabRight.png";
            public static final String achievements = Compendium.Texture.GUI.prefix + "achievement_page.png";
            public static final String noContent = Compendium.Texture.GUI.prefix + "no_content.png";
            public static final String guiElements = Compendium.Texture.GUI.prefix + "gui_elements.png";
        }

        public static final class Model
        {
            public static final String prefix = "textures/models/";
            public static final String opticalMicroscope = Compendium.Texture.Model.prefix + "optical_microscope.png";
            public static final String electrolysis = Compendium.Texture.Model.prefix + "electrolysis.png";
            public static final String electricCrucible = Compendium.Texture.Model.prefix + "electric_crucible.png";
            public static final String centrifuge = Compendium.Texture.Model.prefix + "centrifuge.png";
        }

        public static final class Font
        {
            public static final String prefix = "textures/fonts/";
            public static final String danielFont = Compendium.Texture.Font.prefix + "daniel.png";
            public static final String danielMetrics = Compendium.Texture.Font.prefix + "daniel.metrics.xml";
        }
    }

    public static final class Version
    {
        public static final String full = "@VERSION@";
    }

    public class NBTTags
    {
        public static final int tagEnd = 0;
        public static final int tagByte = 1;
        public static final int tagShort = 2;
        public static final int tagInt = 3;
        public static final int tagLong = 4;
        public static final int tagFloat = 5;
        public static final int tagDouble = 6;
        public static final int tagByteArray = 7;
        public static final int tagString = 8;
        public static final int tagList = 9;
        public static final int tagCompound = 10;
        public static final int tagIntArray = 11;

        public static final String slot = "slot";
        public static final String stack = "stack";
        public static final String inventory = "inventory";
        public static final String timer = "timer";
        public static final String count = "count";
        public static final String reset = "reset";
        public static final String fluid = "fluid";
        public static final String fluidNull = "fluid_null";
        public static final String amount = "amount";
        public static final String capacity = "capacity";
        public static final String name = "name";
        public static final String x = "xCoord";
        public static final String y = "xCoord";
        public static final String z = "zCoord";
        public static final String nbt = "nbt";
        public static final String item = "item";
        public static final String damage = "damage";
    }
}
