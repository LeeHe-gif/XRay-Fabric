package pro.mikey.fabric.xray.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractScreen extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/recipe_book.png");

    AbstractScreen(Component title) {
        super(title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);

        //    RenderSystem.pushMatrix();
        //    RenderSystem.translatef(0.0F, 0.0F, 100.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int i = (this.width - 147) / 2;
        int j = (this.height - 166) / 2;

        guiGraphics.blit(TEXTURE, i, j, 1, 1, 147, 166);
        //    RenderSystem.popMatrix();
    }
}
