package aria1th.angelcarpet.mixin.plantableWitherRoseInNetherBricks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WitherRoseBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static aria1th.angelcarpet.carpet.CarpetExtensionSettings.plantableWitherRoseOnNetherBricks;

@Mixin(WitherRoseBlock.class)
public abstract class WitherRoseBlockMixin {
	@Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
	private void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
		if (plantableWitherRoseOnNetherBricks && (floor.isOf(Blocks.NETHER_BRICKS) || floor.isOf(Blocks.RED_NETHER_BRICKS))){
			cir.setReturnValue(true);
		}
	}
}