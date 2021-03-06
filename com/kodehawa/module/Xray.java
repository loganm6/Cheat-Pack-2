package com.kodehawa.module;

import java.util.ArrayList;

import net.minecraft.src.PotionEffect;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.event.Event;
import com.kodehawa.event.EventHandler;
import com.kodehawa.event.events.EventBlockRender;

public class Xray extends Module {
    public static ArrayList< Integer > xrayBlocks = new ArrayList< Integer >( );
    
    public Xray( ) {
        super( "Xray", "See the valuable stuff", Keyboard.KEY_X, EnumGuiCategory.VISION );
        // TODO Auto-generated constructor stub
        
        
        xrayBlocks.add( 8 );
        xrayBlocks.add( 9 );
        xrayBlocks.add( 10 );
        xrayBlocks.add( 11 );
        xrayBlocks.add( 14 );
        xrayBlocks.add( 15 );
        xrayBlocks.add( 16 );
        xrayBlocks.add( 89 );
        xrayBlocks.add( 57 );
        xrayBlocks.add( 73 );
        xrayBlocks.add( 74 );
        xrayBlocks.add( 152 );
        xrayBlocks.add( 153 );
        xrayBlocks.add( 56 );
        xrayBlocks.add( 41 );
        xrayBlocks.add( 42 );
        xrayBlocks.add( 133 );
        xrayBlocks.add( 129 );
        xrayBlocks.add( 137 );
        xrayBlocks.add( 120 );
        xrayBlocks.add( 97 );
        xrayBlocks.add( 88 );
        xrayBlocks.add( 89 );
        xrayBlocks.add( 112 );
    }
    
    @Override
    public void render( ) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void tick( ) {
        // TODO Auto-generated method stub
    	CheatingEssentials.getMinecraftInstance( ).gameSettings.gammaSetting = 9F;
    }
    
    @Override
    public void toggle( ) {
        super.toggle( );
       CheatingEssentials.getMinecraftInstance( ).renderGlobal.loadRenderers( );
        if( getActive( ) ) {
        	CheatingEssentials.getCheatingEssentials().getModWrapper().getEventHandler().registerListener( EventBlockRender.class, this );
        } else {
            CheatingEssentials.getMinecraftInstance( ).gameSettings.gammaSetting = 0.2F;
            CheatingEssentials.getCheatingEssentials().getModWrapper().getEventHandler().unRegisterListener( EventBlockRender.class, this );
        }
    }
    
    @Override
    public void onEvent( Event e ) {
        super.onEvent( e );
        
        if( e instanceof EventBlockRender ) {
            EventBlockRender rEvent = ( EventBlockRender ) e;
            if( rEvent.getType( ).equals( EventBlockRender.EventType.RENDER_XRAY ) ) {
                rEvent.setCancelled( getActive( ) ? true : false );
            }
        }
    }
}
