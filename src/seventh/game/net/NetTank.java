/*
 * see license.txt
 */
package seventh.game.net;

import seventh.game.Entity.Type;
import seventh.shared.SeventhConstants;
import harenet.IOBuffer;

/**
 * Tank information
 * 
 * @author Tony
 *
 */
public class NetTank extends NetVehicle {
	public byte state;
	public short turretOrientation;
	public byte primaryWeaponState;
	public byte secondaryWeaponState;
	public int operatorId;
	
	/**
	 */
	public NetTank() {
		this(Type.SHERMAN_TANK);
	}
	
	/**
	 * @param type the type of tank
	 */
	public NetTank(Type type) {
		this.type = type.netValue();
		this.operatorId = SeventhConstants.INVALID_PLAYER_ID;
	}
	
	/* (non-Javadoc)
	 * @see seventh.game.net.NetEntity#read(harenet.IOBuffer)
	 */
	@Override
	public void read(IOBuffer buffer) {	
		super.read(buffer);
		
		state = buffer.get();
		orientation = buffer.getShort();
		turretOrientation = buffer.getShort();
		primaryWeaponState = buffer.get();
		secondaryWeaponState = buffer.get();
		operatorId = buffer.getUnsignedByte();
	}
	
	/* (non-Javadoc)
	 * @see seventh.game.net.NetEntity#write(harenet.IOBuffer)
	 */
	@Override
	public void write(IOBuffer buffer) {	
		super.write(buffer);
		
		buffer.put(state);
		buffer.putShort(orientation);
		buffer.putShort(turretOrientation);
		buffer.put(primaryWeaponState);
		buffer.put(secondaryWeaponState);
		buffer.putUnsignedByte(operatorId);
	}
}
