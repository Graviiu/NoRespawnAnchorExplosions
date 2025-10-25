package graviiu.top.graviiu;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class NoRespawnAnchorExplosionsEvent implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        ItemStack item = e.getItem();
        Block block = e.getClickedBlock();

        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if (item == null && block.getType() == Material.RESPAWN_ANCHOR) {

            e.setCancelled(true);
            return;
        }


        if (item != null && item.getType() == Material.GLOWSTONE && block != null && block.getType() == Material.RESPAWN_ANCHOR) {

            RespawnAnchor anchorData = (RespawnAnchor) block.getBlockData();

            int charges = anchorData.getCharges();

            if (charges >= 0 && charges < 4) {
                anchorData.setCharges(charges + 1);
                block.setBlockData(anchorData);
            } else{
                e.setCancelled(true);
            }
        }


    }


}
