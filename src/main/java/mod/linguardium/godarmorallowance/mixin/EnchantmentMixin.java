package mod.linguardium.godarmorallowance.mixin;

import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    // Roadblock inject to prevent failure but also to force logic

    @Inject(at=@At("HEAD"),method="canCombine",cancellable = true)
    private void GAA$allowAllEnchantments(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((Object)this != other);
    }

}
