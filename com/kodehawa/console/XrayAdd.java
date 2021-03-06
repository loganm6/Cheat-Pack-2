package com.kodehawa.console;

import java.util.ArrayList;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.mods.ModuleXray;
import com.kodehawa.mods.Vars;
import com.kodehawa.util.ChatColour;

public class XrayAdd implements BaseCommand{

    public int id;
    public String endres = "";

    @Override
    public void onRun(String[ ] cmd)
    {
        // TODO Auto-generated method stub
        
        endres = output(cmd);
    }

    @Override
    public String getName()
    {
        // TODO Auto-generated method stub
        return "xrayAddBlock";
    }

    @Override
    public String showHelp()
    {
        // TODO Auto-generated method stub
        return new String(ChatColour.RED + "Usage: " + ChatColour.AQUA + this.getName() + " <block id>");
    }

    @Override
    public String output()
    {
        // TODO Auto-generated method stub
       return endres;
    }
		
        String output(String[ ] cmd){
        
        	try
            {
        		Integer blockID = Integer.parseInt( cmd[ 1 ] );
            	ModuleXray.xrayBlocks.add( blockID );
            	CheatingEssentials.getCheatingEssentials().getMinecraftInstance().renderGlobal.loadRenderers();
                System.out.println(ModuleXray.xrayBlocks.size());
                CheatingEssentials.getCheatingEssentials().saveXrayList();
            	CheatingEssentials.getCheatingEssentials().CELogAgent.logInfo("You've added a block to the X-Ray list: " + blockID);
                return "Block ID added to Int: " + blockID;
            }
            catch (Exception e)
            {
               return showHelp();
            }
        }
   }

