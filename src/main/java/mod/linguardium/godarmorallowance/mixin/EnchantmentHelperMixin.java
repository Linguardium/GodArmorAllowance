package mod.linguardium.godarmorallowance.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    // Roadblock inject to prevent failure but also to force logic
    @Inject(at=@At("HEAD"),method="isCompatible",cancellable = true)
    private static void alwaysCompatible(Collection<Enchantment> existing, Enchantment candidate, CallbackInfoReturnable<Boolean> cir) {
        for (Enchantment enchantment : existing) {
            if (enchantment != candidate) continue;
            cir.setReturnValue(false);
        }
        cir.setReturnValue(true);
    }
}
