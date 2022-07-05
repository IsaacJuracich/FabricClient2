package xyz.palacecore.framework.event.events;
import xyz.palacecore.framework.event.Event;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public class EventBlockEntityRender extends Event {

	public static class Single extends EventBlockEntityRender {

		protected BlockEntity blockEntity;
		protected MatrixStack matrices;
		protected VertexConsumerProvider vertexConsumers;

		public BlockEntity getBlockEntity() {
			return blockEntity;
		}

		public MatrixStack getMatrices() {
			return matrices;
		}

		public VertexConsumerProvider getVertexConsumers() {
			return vertexConsumers;
		}

		public static class Pre extends Single {

			public Pre(BlockEntity blockEntity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
				this.blockEntity = blockEntity;
				this.matrices = matrices;
				this.vertexConsumers = vertexConsumers;
			}

			public void setBlockEntity(BlockEntity blockEntity) {
				this.blockEntity = blockEntity;
			}

			public void setMatrices(MatrixStack matrices) {
				this.matrices = matrices;
			}

			public void setVertexConsumers(VertexConsumerProvider vertexConsumers) {
				this.vertexConsumers = vertexConsumers;
			}
		}

		public static class Post extends Single {
			public Post(BlockEntity blockEntity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
				this.blockEntity = blockEntity;
				this.matrices = matrices;
				this.vertexConsumers = vertexConsumers;
			}
		}
	}

	public static class PreAll extends EventEntityRender {
	}

	public static class PostAll extends EventEntityRender {
	}
}
