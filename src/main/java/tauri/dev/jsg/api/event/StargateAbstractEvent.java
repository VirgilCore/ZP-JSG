package tauri.dev.jsg.api.event;

import tauri.dev.jsg.stargate.network.StargateAddress;
import tauri.dev.jsg.stargate.network.SymbolTypeEnum;
import tauri.dev.jsg.tileentity.stargate.StargateAbstractBaseTile;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Parent event for all stargate-related events in JSG
 */
public abstract class StargateAbstractEvent extends Event {
    protected final StargateAbstractBaseTile tile;

    public StargateAbstractEvent(StargateAbstractBaseTile tile){
        this.tile = tile;
    }

    /**
     * Get stargate that posted this event
     * @return stargate tileentity
     */
    public StargateAbstractBaseTile getTile() {
        return tile;
    }

    /**
     * Get address of stargate that posted this event
     * @return stargate address by stargate type
     */
    public StargateAddress getAddress(){
        return getAddress(tile.getSymbolType());
    }

    /**
     * Get address of stargate that posted this event
     * @param type address type
     * @return stargate address
     */
    public StargateAddress getAddress(SymbolTypeEnum type){
        return tile.getStargateAddress(type);
    }

    /**
     * Post event to MinecraftForge.EVENT_BUS. Internal use only
     * @return true if event canceled, false if not
     */
    public boolean post(){
        return MinecraftForge.EVENT_BUS.post(this);
    }
}
