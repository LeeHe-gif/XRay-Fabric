package pro.mikey.fabric.xray.screens.forge;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import org.lwjgl.opengl.GL11;

/**
 * A bare bones implementation of the without the background or borders. With GL_SCISSOR to crop out
 * the overflow
 *
 * <p>This is how an abstract implementation should look... :cry:
 */
public class ScrollingList<E extends AbstractSelectionList.Entry<E>> extends AbstractSelectionList<E> {
    ScrollingList(int x, int y, int width, int height, int slotHeightIn) {
        super(
                Minecraft.getInstance(),
                width,
                height,
                y - (height / 2),
                (y - (height / 2)) + height,
                slotHeightIn);
        this.setLeftPos(x - (width / 2));
        this.setRenderTopAndBottom(false);
        this.setRenderBackground(false); // removes background
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        double scale = this.minecraft.getWindow().getGuiScale();

        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor(
                (int) (this.x0 * scale),
                (int) (this.minecraft.getWindow().getHeight() - ((this.y0 + this.height) * scale)),
                (int) (this.width * scale),
                (int) (this.height * scale));

        super.render(stack, mouseX, mouseY, partialTicks);

        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }

    @Override
    protected int getScrollbarPosition() {
        return (this.x0 + this.width) - 6;
    }

    @Override
    public void updateNarration(NarrationElementOutput builder) {

    }
}
