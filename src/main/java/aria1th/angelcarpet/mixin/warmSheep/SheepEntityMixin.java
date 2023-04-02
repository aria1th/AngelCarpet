package aria1th.angelcarpet.mixin.warmSheep;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static aria1th.angelcarpet.carpet.CarpetExtensionSettings.warmSheep;

@Mixin(LivingEntity.class)
public abstract class SheepEntityMixin {
	@Inject(method = "canFreeze", at = @At("HEAD"), cancellable = true)
	private void overrideCanFreeze(CallbackInfoReturnable<Boolean> cir){
		if (warmSheep && ((Entity)(Object)this).getType() == EntityType.SHEEP){
			cir.setReturnValue(false);
		}
	}
}
