package aria1th.angelcarpet.mixin.renewableCalcite;

import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static aria1th.angelcarpet.carpet.CarpetExtensionSettings.renewableCalcite;

@Mixin(BoneMealItem.class)
public class BonemealItemMixin {
	@Inject(method = "useOnFertilizable", at = @At("HEAD") , cancellable = true)
	private static void onUseOnCobblestone(ItemStack stack, World world, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
		if (renewableCalcite && world.getBlockState(pos).isOf(Blocks.COBBLESTONE)){
			world.setBlockState(pos, Blocks.CALCITE.getDefaultState());
			stack.decrement(1);
			cir.setReturnValue(true);
		}
	}
}