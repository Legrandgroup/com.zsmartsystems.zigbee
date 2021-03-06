package com.zsmartsystems.zigbee.greenpower;

public class ZigBeeGreenPowerFrame {

	/**
	 * Whether the GPDF as autoComissioning bit set or no.
	 */
	private boolean AutoCommissioning;

	/**
	 * The source GPD's address
	 */
	private GpAddress sourceAddress;
	
	/**
	 * The GPDF's source endpoint
	 */
	private int endpoint;
	
	/**
	 * the GPDF's sourceID
	 */
	private int sourceId;
	
	/**
	 * The security frame counter used to prevent the reception of duplicate frames.
	 */
	private int SecurityFrameCounter;
	
	/**
	 * The Command ID
	 */
	private int CommandId;

	/**
	 * The GPD command payload.
	 */
	private int[] payload;
	
	/**
	 * The frame's MIC.
	 */
	private int mic;

	public boolean isAutoCommissioning() {
		return AutoCommissioning;
	}
	public void setAutoCommissioning(boolean autoCommissioning) {
		AutoCommissioning = autoCommissioning;
	}
	public GpAddress getSourceAddress() {
		return sourceAddress;
	}
	public void setSourceAddress(GpAddress address) {
		sourceAddress = address;
	}
	public int getSecurityFrameCounter() {
		return SecurityFrameCounter;
	}
	public void setSecurityFrameCounter(int securityFrameCounter) {
		SecurityFrameCounter = securityFrameCounter;
	}
	public int getCommandId() {
		return CommandId;
	}
	public void setCommandId(int commandId) {
		CommandId = commandId;
	}
	public int[] getPayload() {
		return payload;
	}
	public void setPayload(int[] payload) {
		this.payload = payload;
	}
	public int getMic() {
		return mic;
	}
	public void setMic(int mic) {
		this.mic = mic;
	}
	public int getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(int endpoint) {
		this.endpoint = endpoint;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceid) {
		this.sourceId = sourceid;
	}
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder(164);
        builder.append("ZigBeeGreenPowerFrame [source Address=");
        builder.append(sourceAddress);
        builder.append(", SecurityFrameCounter=");
        builder.append(SecurityFrameCounter);
        builder.append(", command ID=");
        builder.append(CommandId);
        builder.append(", payload=");
        if (payload != null) {
            for (int c = 0; c < payload.length; c++) {
                if (c != 0) {
                    builder.append(' ');
                }
                builder.append(String.format("%02X", payload[c]));
            }
        }
        builder.append(", Mic=");
        builder.append(mic);
        builder.append(']');
        return builder.toString();
    }
}
