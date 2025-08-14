package yuiopd.com.skyblockitems1214.teleport;

import net.minecraft.block.AirBlock;
import net.minecraft.entity.EntityType;

import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import static net.minecraft.entity.Entity.RemovalReason.KILLED;

public class Aote extends Item {

    public Aote(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }

        HitResult h = user.raycast(8,1,true);
        Vec3d p = h.getPos();
        VexEntity m = new VexEntity(EntityType.VEX, world);
        m.setPosition(p);
        world.spawnEntity(m);
        var e = m.getPos();
        if (p.y % 1 == 0) {
            System.out.println("tp");
            user.setPosition(p);
            System.out.println("tp");
        } else if (p.x % 1 == 0) {
            Vec3d l;
            if (user.getFacing() == Direction.EAST) {
                l = new Vec3d(p.x - 0.5, p.y, p.z);
            } else if (user.getFacing() == Direction.WEST) {
                l = new Vec3d(p.x + 0.5, p.y, p.z);
            } else if (user.getFacing() == Direction.NORTH) {
                l = new Vec3d(p.x - 0.5, p.y, p.z);
            } else if (user.getFacing() == Direction.SOUTH) {
                l = new Vec3d(p.x + 0.5, p.y, p.z);
            } else {
                l = p;
            }
            user.setPosition(l);
        } else if (p.z % 1 == 0) {
            Vec3d l;
            if (user.getFacing() == Direction.NORTH) {
                l = new Vec3d(p.x, p.y, p.z + 0.5);
            } else if (user.getFacing() == Direction.SOUTH) {
                l = new Vec3d(p.x, p.y, p.z - 0.5);
            } else if (user.getFacing() == Direction.EAST) {
                l = new Vec3d(p.x, p.y, p.z + 0.5);
            } else if (user.getFacing() == Direction.WEST) {
                l = new Vec3d(p.x, p.y, p.z - 0.5);
            } else {
                l = p;
            }
            user.setPosition(l);


        } else {
            user.setPos(p.x,p.y+2,p.z);
        }
        m.remove(KILLED);//TODO: fix right click on blocks not working

        return ActionResult.SUCCESS;
    }
}
