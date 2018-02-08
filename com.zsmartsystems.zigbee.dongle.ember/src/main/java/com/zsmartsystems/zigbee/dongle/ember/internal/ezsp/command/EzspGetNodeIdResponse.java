/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameResponse;

/**
 * Class to implement the Ember EZSP command <b>getNodeId</b>.
 * <p>
 * Returns the 16-bit node ID of the local node.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGetNodeIdResponse extends EzspFrameResponse {
	public static int FRAME_ID = 0x27;

	/**
	 * The 16-bit ID.
	 * <p>
	 * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
	 */
	private int nodeId;

	/**
	 * Response and Handler constructor
	 */
	public EzspGetNodeIdResponse(int[] inputBuffer) {
		// Super creates deserializer and reads header fields
		super(inputBuffer);

		// Deserialize the fields
		nodeId = deserializer.deserializeUInt16();
	}

	/**
	 * The 16-bit ID.
	 * <p>
	 * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
	 *
	 * @return the current nodeId as {@link int}
	 */
	public int getNodeId() {
		return nodeId;
	}

	/**
	 * The 16-bit ID.
	 *
	 * @param nodeId
	 *            the nodeId to set as {@link int}
	 */
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(49);
		builder.append("EzspGetNodeIdResponse [nodeId=");
		builder.append(nodeId);
		builder.append(']');
		return builder.toString();
	}
}