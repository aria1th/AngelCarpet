package aria1th.angelcarpet.mixin.renewableCalcite;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static aria1th.angelcarpet.carpet.CarpetExtensionSettings.allayDuping;
import static aria1th.angelcarpet.carpet.CarpetExtensionSettings.allayDupingWithItems;

@Mixin(AllayEntity.class)
public abstract class allayEntityMixin{
	@Unique
	private long breedCoolDown = 400L;

	@Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
	private void dupeWithAmethyst(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir){
		if (!allayDuping && !allayDupingWithItems || this.breedCoolDown > 0){
			return;
		}
		ItemStack stack = player.getStackInHand(hand);
		if (stack.isOf(Items.AMETHYST_SHARD)){
			World world = player.getEntityWorld();
			AllayEntity base = ((AllayEntity)(Object)this);
			if (!hasNearbyJukebox(world, base)){
				return;
			}
			AllayEntity entity = new AllayEntity(EntityType.ALLAY, world);
			entity.setPos(base.getX(), base.getY(), base.getZ());
			if (allayDupingWithItems){
				entity.readCustomDataFromNbt(base.writeNbt(new NbtCompound()));
			}
			world.spawnEntity(entity);
			double d = base.getRandom().nextGaussian() * 0.02D;
			double e = base.getRandom().nextGaussian() * 0.02D;
			double f = base.getRandom().nextGaussian() * 0.02D;
			world.addParticle(ParticleTypes.HEART, base.getParticleX(1.0D), base.getRandomBodyY() + 0.5D, base.getParticleZ(1.0D), d, e, f);
			this.breedCoolDown = 400L;
			stack.decrement(1);
			cir.setReturnValue(ActionResult.SUCCESS);
		}
	}
	private boolean hasNearbyJukebox(World world, Entity entity){
		return BlockPos.streamOutwards(entity.getBlockPos(), 4, 4, 4).anyMatch(a ->
		{BlockState state = world.getBlockState(a); return state.isOf(Blocks.JUKEBOX) && state.get(JukeboxBlock.HAS_RECORD);});
	}

	@Inject(method = "mobTick", at = @At("HEAD"))
	private void tickCoolDown(CallbackInfo ci){
		if (!allayDuping && !allayDupingWithItems){
			return;
		}
		if (this.breedCoolDown > 0)
			this.breedCoolDown--;
	}
}
