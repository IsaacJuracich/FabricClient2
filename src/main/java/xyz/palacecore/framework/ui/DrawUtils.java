package xyz.palacecore.framework.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class DrawUtils {

    public static void setup2DRender(boolean disableDepth) {
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        if (disableDepth)
            RenderSystem.disableDepthTest();
    }

    public static void end2DRender() {
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
        RenderSystem.enableDepthTest();
    }

    public static void setup3DRender(boolean disableDepth) {
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        if (disableDepth)
            RenderSystem.disableDepthTest();
        RenderSystem.depthMask(MinecraftClient.isFabulousGraphicsOrBetter());
        RenderSystem.enableCull();
    }

    public static void end3DRender() {
        RenderSystem.enableTexture();
        RenderSystem.disableCull();
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
    }

    public static void drawRoundedRect(MatrixStack matrices, float left, float top, float right, float bottom, float smooth, Color color){
        fill(matrices, left - smooth / 2, top - smooth, right + smooth / 2, bottom + smooth, color.getRGB());
        fill(matrices, left - smooth, top - smooth / 2, right + smooth, bottom + smooth / 2, color.getRGB());
        drawFilledCircle(matrices, left - smooth, top - smooth, smooth, color);
        drawFilledCircle(matrices, right, top - smooth, smooth, color);
        drawFilledCircle(matrices, right, bottom, smooth, color);
        drawFilledCircle(matrices, left - smooth, bottom, smooth, color);
    }

    public static void drawFilledCircle(MatrixStack matrices, double xx, double yy, float radius, Color color) {
        RenderSystem.setShaderColor(color.getRed() / 255f, color.getGreen() / 255f,
                color.getBlue() / 255f, color.getAlpha() / 255f);
        bindTexture(new Identifier("palace", "ui/circle.png"));
        RenderSystem.enableBlend();
        drawTexture(matrices, (float) xx, (float)yy, radius, radius, 0, 0, radius, radius, radius, radius);
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }

    public static void drawDropShadow(MatrixStack matrices, double xx, double yy, double width, double height, boolean elipse) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 0.5f);
        bindTexture(new Identifier("hypnotic", "textures/" + (elipse ? "circle" : "") + "shadow.png"));
        RenderSystem.enableBlend();
        drawTexture(matrices, (float) xx, (float)yy, (float)width, (float)height, 0, 0, (float)width, (float)height, (float)width, (float)height);
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
    }

    public static void bindTexture(Identifier identifier) {
        RenderSystem.setShaderTexture(0, identifier);
    }

    public static void drawTexture(MatrixStack matrices, float x, float y, float u, float v, float width, float height, int textureWidth, int textureHeight) {
        RenderSystem.enableBlend();
        drawTexture(matrices, x, y, width, height, u, v, width, height, textureWidth, textureHeight);
        RenderSystem.disableBlend();
    }

    public static void drawTexture(MatrixStack matrices, float x, float y, float width, float height, float u, float v, float regionWidth, float regionHeight, float textureWidth, float textureHeight) {
        drawTexture(matrices, x, x + width, y, y + height, 0, regionWidth, regionHeight, u, v, textureWidth, textureHeight);
    }

    public static void drawTexture(MatrixStack matrices, float x0, float y0, float x1, float y1, int z, float regionWidth, float regionHeight, float u, float v, float textureWidth, float textureHeight) {
        drawTexturedQuad(matrices.peek().getPositionMatrix(), x0, y0, x1, y1, z, (u + 0.0F) / (float)textureWidth, (u + (float)regionWidth) / (float)textureWidth, (v + 0.0F) / (float)textureHeight, (v + (float)regionHeight) / (float)textureHeight);
    }

    public static void drawTexturedQuad(Matrix4f matrices, float x0, float x1, float y0, float y1, float z, float u0, float u1, float v0, float v1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrices, (float)x0, (float)y1, (float)z).texture(u0, v1).next();
        bufferBuilder.vertex(matrices, (float)x1, (float)y1, (float)z).texture(u1, v1).next();
        bufferBuilder.vertex(matrices, (float)x1, (float)y0, (float)z).texture(u1, v0).next();
        bufferBuilder.vertex(matrices, (float)x0, (float)y0, (float)z).texture(u0, v0).next();
        bufferBuilder.end();
        BufferRenderer.draw(bufferBuilder);
    }

    public static void fill(MatrixStack matrixStack, double x1, double y1, double x2, double y2, int color) {
        Matrix4f matrix = matrixStack.peek().getPositionMatrix();
        double j;
        if (x1 < x2) {
            j = x1;
            x1 = x2;
            x2 = j;
        }

        if (y1 < y2) {
            j = y1;
            y1 = y2;
            y2 = j;
        }

        float f = (float)(color >> 24 & 255) / 255.0F;
        float g = (float)(color >> 16 & 255) / 255.0F;
        float h = (float)(color >> 8 & 255) / 255.0F;
        float k = (float)(color & 255) / 255.0F;
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(matrix, (float)x1, (float)y2, 0.0F).color(g, h, k, f).next();
        bufferBuilder.vertex(matrix, (float)x2, (float)y2, 0.0F).color(g, h, k, f).next();
        bufferBuilder.vertex(matrix, (float)x2, (float)y1, 0.0F).color(g, h, k, f).next();
        bufferBuilder.vertex(matrix, (float)x1, (float)y1, 0.0F).color(g, h, k, f).next();
        bufferBuilder.end();
        BufferRenderer.draw(bufferBuilder);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    public static void drawShape(Border region, MatrixStack poseStack, Color color, int curve, boolean fill, float lineWidth) {
        RenderSystem.assertOnRenderThread();
        RenderSystem.enableDepthTest();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        Tessellator tesselator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tesselator.getBuffer();
        Matrix4f matrix4f = poseStack.peek().getPositionMatrix();
        if (!fill) {
            bufferBuilder.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        }
        else
            bufferBuilder.begin(VertexFormat.DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
        drawRoundedSquare(bufferBuilder, matrix4f, region, curve, color);
        if (!fill) {

        }
        tesselator.draw();
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
    }

    public static void drawRoundedSquare(BufferBuilder wr, Matrix4f matrix, Border region, int curve, Color c) {
        wr.vertex(matrix, (float) region.x, (float) (region.y + curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        wr.vertex(matrix, (float) region.x, (float) (region.getBottom() - curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        if (curve != 0)
            addArch(wr, matrix, region.x + curve, region.getBottom() - curve, curve, 270, 360, c);
        wr.vertex(matrix, (float) (region.x + curve), (float) region.getBottom(), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        wr.vertex(matrix, (float) (region.getRight() - curve), (float) region.getBottom(), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        if (curve != 0)
            addArch(wr, matrix, region.getRight() - curve, region.getBottom() - curve, curve, 0, 90, c);
        wr.vertex(matrix, (float) region.getRight(), (float) (region.getBottom() - curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        wr.vertex(matrix, (float) region.getRight(), (float) (region.y + curve), 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        if (curve != 0)
            addArch(wr, matrix, region.getRight() - curve, region.y + curve, curve, 90, 180, c);
        wr.vertex(matrix, (float) (region.getRight() - curve), (float) region.y, 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        wr.vertex(matrix, (float) (region.x + curve), (float) region.y, 0.0F)
                .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        if (curve != 0)
            addArch(wr, matrix, region.x + curve, region.y + curve, curve, 180, 270, c);
    }

    public static void addArch(BufferBuilder wr, Matrix4f matrix, int x, int y, int radius, int startAngle, int endAngle, Color c) {
        for (int i = startAngle; i < endAngle; i++) {
            wr.vertex(matrix, (float) (x + Math.sin(i * Math.PI / 180) * radius), (float) (y + Math.cos(i * Math.PI / 180) * radius), 0.0F)
                    .color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha()).next();
        }
    }

    public static void shaderColor(int hex) {
        float alpha = (hex >> 24 & 0xFF) / 255.0F;
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        RenderSystem.setShaderColor(red, green, blue, alpha);
    }
}

