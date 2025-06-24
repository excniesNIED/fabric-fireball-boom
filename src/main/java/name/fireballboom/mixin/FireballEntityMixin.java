package name.fireballboom.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireballEntity.class)
public class FireballEntityMixin {
    @Redirect(method = "onCollision",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/explosion/Explosion$DestructionType;)Lnet/minecraft/world/explosion/Explosion;"))
    Explosion redirectExplosionWithCorrectEntity(World instance, Entity entity, double x, double y, double z, float power, boolean createFire, Explosion.DestructionType destructionType){
        return instance.createExplosion((Entity)(Object)this,x,y,z,power,createFire,destructionType);
    }
}
