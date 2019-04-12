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
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EmberPowerMode;

/**
 * Class to implement the Ember EZSP command <b>mfglibSetPower</b>.
 * <p>
 * First select the transmit power mode, and then include a method for selecting the radio
 * transmit power. The valid power settings depend upon the specific radio in use. Ember radios
 * have discrete power settings, and then requested power is rounded to a valid power setting;
 * the actual power output is available to the caller via mfglibGetPower().
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspMfglibSetPowerRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x8C;

    /**
     * Power mode.
     * <p>
     * EZSP type is <i>EmberPowerMode</i> - Java type is {@link EmberPowerMode}
     */
    private EmberPowerMode txPowerMode;

    /**
     * Power in units of dBm. Refer to radio data sheet for valid range.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     */
    private int power;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspMfglibSetPowerRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * Power mode.
     * <p>
     * EZSP type is <i>EmberPowerMode</i> - Java type is {@link EmberPowerMode}
     *
     * @return the current txPowerMode as {@link EmberPowerMode}
     */
    public EmberPowerMode getTxPowerMode() {
        return txPowerMode;
    }

    /**
     * Power mode.
     *
     * @param txPowerMode the txPowerMode to set as {@link EmberPowerMode}
     */
    public void setTxPowerMode(EmberPowerMode txPowerMode) {
        this.txPowerMode = txPowerMode;
    }

    /**
     * Power in units of dBm. Refer to radio data sheet for valid range.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     *
     * @return the current power as {@link int}
     */
    public int getPower() {
        return power;
    }

    /**
     * Power in units of dBm. Refer to radio data sheet for valid range.
     *
     * @param power the power to set as {@link int}
     */
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeEmberPowerMode(txPowerMode);
        serializer.serializeInt8S(power);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(78);
        builder.append("EzspMfglibSetPowerRequest [txPowerMode=");
        builder.append(txPowerMode);
        builder.append(", power=");
        builder.append(power);
        builder.append(']');
        return builder.toString();
    }
}
