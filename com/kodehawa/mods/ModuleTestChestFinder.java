package com.kodehawa.mods;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.Minecraft;
import net.minecraft.src.RenderManager;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.ChestESP.AltAxisAlignedBB;
import com.kodehawa.ChestESP.ChestFinderContainer;
import com.kodehawa.event.Event;
import com.kodehawa.util.Tickable;

public class ModuleTestChestFinder extends Mod implements Tickable
{
    protected Minecraft minecraft;
    protected CheatingEssentials cb;

    /**
     * I need OpenGL for this. Dammit!
     * @param mod
     * @param c
     * @param m
     */

    public ModuleTestChestFinder(CheatingEssentials c, Minecraft m)
    {
        super(Mods.ChestESP);
        cb = c;
        minecraft = m;
        // TODO Auto-generated constructor stub
    }
    

    
    public void render(double x, double y, double z){
    	for( Object o : Minecraft.getMinecraft( ).theWorld.loadedTileEntityList ) {
            TileEntity e = ( TileEntity ) o;
            if( e instanceof TileEntityChest ) {
               // this.drawESP( ( TileEntityChest ) e, e.xCoord, e.yCoord, e.zCoord, 0 );
                GL11.glPushMatrix();
                GL11.glTranslated(x, y, z);
                GL11.glEnable( GL11.GL_BLEND );
                GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
                GL11.glColor4f( 0.0F,
                		0.0F,
                		0.0F,
                		1F );
                GL11.glLineWidth( 2.0F );
                GL11.glDisable( GL11.GL_TEXTURE_2D );
                GL11.glDepthMask( false );
                GL11.glEnable( GL11.GL_LINE_SMOOTH );
                GL11.glBlendFunc( 770, 771 );
                GL11.glDisable( GL11.GL_TEXTURE_2D );
                GL11.glDisable( GL11.GL_DEPTH_TEST );
                GL11.glDepthMask( false );
                GL11.glEnable( GL11.GL_LINE_SMOOTH );
                ChestFinderContainer.drawOutlinedBoundingBox( new AltAxisAlignedBB( x + 1, y + 1, z + 1, x , y , z));
                GL11.glColor4f(0.0F,
                		0.0F,
                		255F,
                		0.4F); 
                ChestFinderContainer.drawBoundingBox( new AltAxisAlignedBB( x + 1, y + 1, z + 1, x, y, z ) );
                //GL11.glRotated( x, y, z, f );
                GL11.glDepthMask( true );
                GL11.glEnable( GL11.GL_TEXTURE_2D);
                GL11.glEnable( GL11.GL_DEPTH_TEST);
                GL11.glColor4f( 255, 255, 255, 255 );
                GL11.glPopMatrix();

            }
        }
    }

    @Override
    public void tick()
    {
        // TODO Auto-generated method stub
    	render(RenderManager.renderPosX, RenderManager.renderPosY, RenderManager.renderPosZ);
    }
    

    
    @Override
    public void onEnable()
    {
    	Vars.ChestESP = true;
    	//CheatingEssentials.getCheatingEssentials().addToTick(this);
        // TODO Auto-generated method stub
    }

    
   
    @Override
    public void onDisable()
    {
       Vars.ChestESP = false;
        // TODO Auto-generated method stub
    	//CheatingEssentials.getCheatingEssentials().removeFromCurrentTick(this);
    }
    /**
     * It just know how get bugged.
     * @param chest
     * @param x
     * @param y
     * @param z
     * @param f
     */
    
    public void drawESP( TileEntityChest chest, double x, double y, double z, float f ) {
        if( isActive( ) ) {
            Minecraft mc = Minecraft.getMinecraft();
            if( !( ( chest.xCoord == 0 ) && ( chest.yCoord == 0 ) && ( chest.zCoord == 0 ) ) ) {
                ChestFinderContainer.drawChestESP(
                		x - RenderManager.renderPosX,
                        y - RenderManager.renderPosY,
                        z - RenderManager.renderPosZ,
                        0.0F,
                        1.0F - ( chest.getDistanceFrom( mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ ) / 20000 ),
                        1.0F );
                         
            }
        }
    }

	
}

