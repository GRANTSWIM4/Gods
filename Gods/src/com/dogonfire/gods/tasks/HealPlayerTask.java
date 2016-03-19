package com.dogonfire.gods.tasks;

import com.dogonfire.gods.GodManager;
import com.dogonfire.gods.Gods;
import com.dogonfire.gods.LanguageManager;
import com.dogonfire.gods.LanguageManager.LANGUAGESTRING;
import java.util.Random;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealPlayerTask
  implements Runnable
{
  private Gods plugin;
  private Player player = null;
  private String godName = null;
  private LanguageManager.LANGUAGESTRING languageString;
  
  public HealPlayerTask(Gods instance, String god, Player p, LanguageManager.LANGUAGESTRING speak)
  {
    this.plugin = instance;
    this.player = p;
    this.godName = new String(god);
    this.languageString = speak;
  }
  
  private boolean healPlayer()
  {
    this.player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 10, 1));
    
    this.player.getLocation().getWorld().playEffect(this.player.getLocation(), Effect.MOBSPAWNER_FLAMES, 4);
    return true;
  }
  
  public void run()
  {
    Random random = new Random();
    if (healPlayer())
    {
      this.plugin.getLanguageManager().setPlayerName(this.player.getName());
      this.plugin.getGodManager().GodSay(this.godName, this.player, this.languageString, 2 + random.nextInt(10));
      
      this.plugin.log(this.godName + " healed " + this.player.getName());
    }
  }
}


/* Location:           C:\temp\Gods.jar
 * Qualified Name:     com.dogonfire.gods.tasks.HealPlayerTask
 * JD-Core Version:    0.7.0.1
 */