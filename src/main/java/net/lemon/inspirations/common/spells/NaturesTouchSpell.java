package net.lemon.inspirations.common.spells;

import net.lemon.inspirations.common.Inspirations;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class NaturesTouchSpell extends Spell {

    public NaturesTouchSpell(int cooldown, int expCost, SpellType type, String name) {
        super(cooldown, expCost, type, name);
    }

    @Override
    public void useSpell(World world, PlayerEntity user) {

        int radius = 3;
        for(int i = -radius; i < radius; i++) {
            for(int j = -radius; j < radius; j++) {
                BlockPos pos = new BlockPos(user.getPos().getX() + i, user.getY() + 1, user.getPos().getZ() + j);

                BlockState blockState = world.getBlockState(pos);
                if (blockState.getBlock() instanceof Fertilizable) {
                    Fertilizable fertilizable = (Fertilizable) blockState.getBlock();
                    if (fertilizable.isFertilizable(world, pos, blockState, world.isClient)) {
                        if (world instanceof ServerWorld) {
                            if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                                fertilizable.grow((ServerWorld) world, world.random, pos, blockState);
                            }
                        }
                    }
                }
            }
        }
    }
}
