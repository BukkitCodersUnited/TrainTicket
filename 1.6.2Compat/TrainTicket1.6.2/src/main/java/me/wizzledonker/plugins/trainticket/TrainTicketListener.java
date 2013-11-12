/*    */ package me.wizzledonker.plugins.trainticket;
/*    */ 
/*    */ import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleEvent;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.vehicle.VehicleEnterEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class TrainTicketListener
/*    */   implements Listener
/*    */ {
/*    */   public static Trainticket plugin;
/*    */ 
/*    */   public TrainTicketListener(Trainticket instance)
/*    */   {
/* 17 */     plugin = instance;
/*    */   }
/*    */ 
/*    */   @EventHandler
/*    */   public void onVehicleEnter(VehicleEnterEvent event) {     
             if ((event.getVehicle().getType() == EntityType.HORSE)) {
                 return;             
             }
             if ((event.getVehicle().getType() == EntityType.PIG)) {
                 return;             
             }
             if ((event.getEntered() instanceof Player)) {
/* 23 */       	Player player = (Player)event.getEntered();
/* 24 */       	if (player.hasPermission("TrainTicket.exempt.cart")) {
/* 25 */         		return;
/*    */       		}
                if ((event.getVehicle().getType() == EntityType.BOAT) && player.hasPermission("TrainTicket.exempt.boat")) {
                		return;
                }
/* 27 */       	if (player.isInsideVehicle()) {
/* 28 */         		player.sendMessage(plugin.handleMessages(Integer.valueOf(2)));
/* 29 */         		return;
/*    */       		}
/* 31 */       if ((player.getItemInHand().getTypeId() == plugin.ticketDataValue) && (plugin.hasTicket(player))) 
					{
/* 32 */         plugin.setTicket(player, false);
/* 33 */         player.sendMessage(plugin.handleMessages(Integer.valueOf(1)));
/* 34 */         player.setItemInHand(null);
/*    */       } 
					else {
/* 36 */         player.sendMessage(plugin.handleMessages(Integer.valueOf(3)));
/* 37 */         event.setCancelled(true);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\DrkMatr\Desktop\TrainTicket-1.4.jar
 * Qualified Name:     me.wizzledonker.plugins.trainticket.TrainTicketListener
 * JD-Core Version:    0.6.2
 */