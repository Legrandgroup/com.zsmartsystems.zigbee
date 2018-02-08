/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.serializer.EzspSerializer;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EmberApsFrame;

/**
 * Class to implement the Ember EZSP command <b>sendMulticast</b>.
 * <p>
 * Sends a multicast message to all endpoints that share a specific multicast ID
 * and are within a specified number of hops of the sender.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSendMulticastRequest extends EzspFrameRequest {
	public static int FRAME_ID = 0x38;

	/**
	 * The APS frame for the message. The multicast will be sent to the groupId in
	 * this frame.
	 * <p>
	 * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
	 */
	private EmberApsFrame apsFrame;

	/**
	 * The message will be delivered to all nodes within this number of hops of the
	 * sender. A value of zero is converted to EMBER_MAX_HOPS.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 */
	private int hops;

	/**
	 * The number of hops that the message will be forwarded by devices that are not
	 * members of the group. A value of 7 or greater is treated as infinite.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 */
	private int nonmemberRadius;

	/**
	 * A value chosen by the Host. This value is used in the ezspMessageSentHandler
	 * response to refer to this message.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 */
	private int messageTag;

	/**
	 * The multicast message.
	 * <p>
	 * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
	 */
	private int[] messageContents;

	/**
	 * Serialiser used to seialise to binary line data
	 */
	private EzspSerializer serializer;

	/**
	 * Request constructor
	 */
	public EzspSendMulticastRequest() {
		frameId = FRAME_ID;
		serializer = new EzspSerializer();
	}

	/**
	 * The APS frame for the message. The multicast will be sent to the groupId in
	 * this frame.
	 * <p>
	 * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
	 *
	 * @return the current apsFrame as {@link EmberApsFrame}
	 */
	public EmberApsFrame getApsFrame() {
		return apsFrame;
	}

	/**
	 * The APS frame for the message. The multicast will be sent to the groupId in
	 * this frame.
	 *
	 * @param apsFrame
	 *            the apsFrame to set as {@link EmberApsFrame}
	 */
	public void setApsFrame(EmberApsFrame apsFrame) {
		this.apsFrame = apsFrame;
	}

	/**
	 * The message will be delivered to all nodes within this number of hops of the
	 * sender. A value of zero is converted to EMBER_MAX_HOPS.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 *
	 * @return the current hops as {@link int}
	 */
	public int getHops() {
		return hops;
	}

	/**
	 * The message will be delivered to all nodes within this number of hops of the
	 * sender. A value of zero is converted to EMBER_MAX_HOPS.
	 *
	 * @param hops
	 *            the hops to set as {@link int}
	 */
	public void setHops(int hops) {
		this.hops = hops;
	}

	/**
	 * The number of hops that the message will be forwarded by devices that are not
	 * members of the group. A value of 7 or greater is treated as infinite.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 *
	 * @return the current nonmemberRadius as {@link int}
	 */
	public int getNonmemberRadius() {
		return nonmemberRadius;
	}

	/**
	 * The number of hops that the message will be forwarded by devices that are not
	 * members of the group. A value of 7 or greater is treated as infinite.
	 *
	 * @param nonmemberRadius
	 *            the nonmemberRadius to set as {@link int}
	 */
	public void setNonmemberRadius(int nonmemberRadius) {
		this.nonmemberRadius = nonmemberRadius;
	}

	/**
	 * A value chosen by the Host. This value is used in the ezspMessageSentHandler
	 * response to refer to this message.
	 * <p>
	 * EZSP type is <i>uint8_t</i> - Java type is {@link int}
	 *
	 * @return the current messageTag as {@link int}
	 */
	public int getMessageTag() {
		return messageTag;
	}

	/**
	 * A value chosen by the Host. This value is used in the ezspMessageSentHandler
	 * response to refer to this message.
	 *
	 * @param messageTag
	 *            the messageTag to set as {@link int}
	 */
	public void setMessageTag(int messageTag) {
		this.messageTag = messageTag;
	}

	/**
	 * The multicast message.
	 * <p>
	 * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
	 *
	 * @return the current messageContents as {@link int[]}
	 */
	public int[] getMessageContents() {
		return messageContents;
	}

	/**
	 * The multicast message.
	 *
	 * @param messageContents
	 *            the messageContents to set as {@link int[]}
	 */
	public void setMessageContents(int[] messageContents) {
		this.messageContents = messageContents;
	}

	@Override
	public int[] serialize() {
		// Serialize the header
		serializeHeader(serializer);

		// Serialize the fields
		serializer.serializeEmberApsFrame(apsFrame);
		serializer.serializeUInt8(hops);
		serializer.serializeUInt8(nonmemberRadius);
		serializer.serializeUInt8(messageTag);
		serializer.serializeUInt8(messageContents.length);
		serializer.serializeUInt8Array(messageContents);
		return serializer.getPayload();
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(177);
		builder.append("EzspSendMulticastRequest [apsFrame=");
		builder.append(apsFrame);
		builder.append(", hops=");
		builder.append(hops);
		builder.append(", nonmemberRadius=");
		builder.append(nonmemberRadius);
		builder.append(", messageTag=");
		builder.append(messageTag);
		builder.append(", messageContents=");
		for (int c = 0; c < messageContents.length; c++) {
			if (c > 0) {
				builder.append(' ');
			}
			builder.append(String.format("%02X", messageContents[c]));
		}
		builder.append(']');
		return builder.toString();
	}
}