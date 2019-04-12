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
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EzspNetworkScanType;

/**
 * Class to implement the Ember EZSP command <b>startScan</b>.
 * <p>
 * This function will start a scan.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspStartScanRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x1A;

    /**
     * Indicates the type of scan to be performed. Possible values are: EZSP_ENERGY_SCAN and
     * EZSP_ACTIVE_SCAN. For each type, the respective callback for reporting results is:
     * energyScanResultHandler and networkFoundHandler. The energy scan and active scan report
     * errors and completion via the scanCompleteHandler
     * <p>
     * EZSP type is <i>EzspNetworkScanType</i> - Java type is {@link EzspNetworkScanType}
     */
    private EzspNetworkScanType scanType;

    /**
     * Bits set as 1 indicate that this particular channel should be scanned. Bits set to 0 indicate
     * that this particular channel should not be scanned. For example, a channelMask value of
     * 0x00000001 would indicate that only channel 0 should be scanned. Valid channels range from
     * 11 to 26 inclusive. This translates to a channel mask value of 0x07FFF800. As a convenience, a
     * value of 0 is reinterpreted as the mask for the current channel.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     */
    private int channelMask;

    /**
     * Sets the exponent of the number of scan periods, where a scan period is 960 symbols. The scan
     * will occur for ((2^duration) + 1) scan periods.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int duration;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspStartScanRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * Indicates the type of scan to be performed. Possible values are: EZSP_ENERGY_SCAN and
     * EZSP_ACTIVE_SCAN. For each type, the respective callback for reporting results is:
     * energyScanResultHandler and networkFoundHandler. The energy scan and active scan report
     * errors and completion via the scanCompleteHandler
     * <p>
     * EZSP type is <i>EzspNetworkScanType</i> - Java type is {@link EzspNetworkScanType}
     *
     * @return the current scanType as {@link EzspNetworkScanType}
     */
    public EzspNetworkScanType getScanType() {
        return scanType;
    }

    /**
     * Indicates the type of scan to be performed. Possible values are: EZSP_ENERGY_SCAN and
     * EZSP_ACTIVE_SCAN. For each type, the respective callback for reporting results is:
     * energyScanResultHandler and networkFoundHandler. The energy scan and active scan report
     * errors and completion via the scanCompleteHandler
     *
     * @param scanType the scanType to set as {@link EzspNetworkScanType}
     */
    public void setScanType(EzspNetworkScanType scanType) {
        this.scanType = scanType;
    }

    /**
     * Bits set as 1 indicate that this particular channel should be scanned. Bits set to 0 indicate
     * that this particular channel should not be scanned. For example, a channelMask value of
     * 0x00000001 would indicate that only channel 0 should be scanned. Valid channels range from
     * 11 to 26 inclusive. This translates to a channel mask value of 0x07FFF800. As a convenience, a
     * value of 0 is reinterpreted as the mask for the current channel.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     *
     * @return the current channelMask as {@link int}
     */
    public int getChannelMask() {
        return channelMask;
    }

    /**
     * Bits set as 1 indicate that this particular channel should be scanned. Bits set to 0 indicate
     * that this particular channel should not be scanned. For example, a channelMask value of
     * 0x00000001 would indicate that only channel 0 should be scanned. Valid channels range from
     * 11 to 26 inclusive. This translates to a channel mask value of 0x07FFF800. As a convenience, a
     * value of 0 is reinterpreted as the mask for the current channel.
     *
     * @param channelMask the channelMask to set as {@link int}
     */
    public void setChannelMask(int channelMask) {
        this.channelMask = channelMask;
    }

    /**
     * Sets the exponent of the number of scan periods, where a scan period is 960 symbols. The scan
     * will occur for ((2^duration) + 1) scan periods.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current duration as {@link int}
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the exponent of the number of scan periods, where a scan period is 960 symbols. The scan
     * will occur for ((2^duration) + 1) scan periods.
     *
     * @param duration the duration to set as {@link int}
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeEzspNetworkScanType(scanType);
        serializer.serializeUInt32(channelMask);
        serializer.serializeUInt8(duration);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(98);
        builder.append("EzspStartScanRequest [scanType=");
        builder.append(scanType);
        builder.append(", channelMask=");
        builder.append(channelMask);
        builder.append(", duration=");
        builder.append(duration);
        builder.append(']');
        return builder.toString();
    }
}
