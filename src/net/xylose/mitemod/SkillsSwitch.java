package net.xylose.mitemod;

import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.classloading.Mod;
import net.xiaoyu233.fml.config.InjectionConfig;
import net.xiaoyu233.fml.util.ModInfo;
import net.xylose.mitemod.mixin.MixinMarkar;
import org.spongepowered.asm.mixin.MixinEnvironment;

import javax.annotation.Nonnull;
import javax.swing.*;

@Mod
public class SkillsSwitch extends AbstractMod {

    private static final int MOD_LOADER_MIN_VER_NUM = 200;
    private static final String MOD_LOADER_MIN_VER_STRING = "v2.0.0";

    public void preInit() {
    }

    @Nonnull
    public InjectionConfig getInjectionConfig() {
        return InjectionConfig.Builder.of("SkillsSwitch", MixinMarkar.class.getPackage(), MixinEnvironment.Phase.INIT).setRequired().build();
    }

    @Override
    public void postInit() {
        ModInfo modLoader = FishModLoader.getModsMap().get("FishModLoader");
        int modLoaderNum = modLoader.getModVerNum();
        if (modLoaderNum < MOD_LOADER_MIN_VER_NUM){
            JFrame diaFrame = new JFrame();
            diaFrame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(diaFrame,"职业开关MOD加载错误: 模组加载器版本过低\nFishModLoader模组加载器需要至少" + MOD_LOADER_MIN_VER_STRING + "版本 \n当前版本:" + modLoader.getModVerStr(),"错误", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public String modId() {
        return "SkillsSwitch";
    }

    public int modVerNum() {
        return 100;
    }

    public String modVerStr() {
        return "v1.0.0";
    }
}
