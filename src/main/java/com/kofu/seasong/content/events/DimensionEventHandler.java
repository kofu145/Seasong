package com.kofu.seasong.content.events;

import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import com.kofu.seasong.Seasong;
import com.kofu.seasong.content.dimensions.DimensionIndex;
import com.kofu.seasong.content.dimensions.OceanDimension;

@EventBusSubscriber(modid = "seasong")
public class DimensionEventHandler {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide()) {
            if (!(DimensionIndex.GetIdx().contains(player.level().dimension())))
                return;
            var dimension = OceanDimension.fromValue(DimensionIndex.GetIdx().indexOf(player.level().dimension()));

            if (player.position().y <= 10) {

                var pos = player.position();

                if (dimension == OceanDimension.SURFACE_DEPTHS
                        || dimension == OceanDimension.TWILIGHT_DEPTHS) {

                    var ServerTwilightDepths = player.level().getServer()
                            .getLevel(DimensionIndex.GetIdx().get(dimension.ordinal() + 1));
                    player.teleportTo(ServerTwilightDepths, pos.x, 300, pos.z, RelativeMovement.ALL,
                            player.getYRot(), player.getXRot());

                }
            }
        }
    }
}
