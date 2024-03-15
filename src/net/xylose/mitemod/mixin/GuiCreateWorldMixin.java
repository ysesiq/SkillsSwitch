package net.xylose.mitemod.mixin;

import net.minecraft.GuiButton;
import net.minecraft.GuiCreateWorld;
import net.minecraft.GuiScreen;
import net.minecraft.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiCreateWorld.class)
public class GuiCreateWorldMixin extends GuiScreen {

    private GuiButton button_skills;
    private boolean moreOptions;

    @Inject(method = {"drawScreen"}, at = {@At("RETURN")})
    private void InjectDrawScreen(int par1, int par2, float par3, CallbackInfo ci) {
        if (this.moreOptions) {
            this.drawString(this.fontRenderer, I18n.getString("selectWorld.professions.info"), this.width / 2 + 6, 136, 10526880);
        }
    }

    @Inject(method = {"func_82288_a"}, at = {@At("RETURN")})
    private void InjectButtons(boolean par1, CallbackInfo callbackInfo) {
        this.moreOptions = par1;
        this.button_skills.drawButton = this.moreOptions;
    }

}
