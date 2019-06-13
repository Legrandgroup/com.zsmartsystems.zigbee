/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspDeserializer;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspSerializer;
import com.zsmartsystems.zigbee.greenpower.GpAddress;

/**
 * Class to implement the Ember Structure <b>EmberGpAddress</b>.
 * <p>
 * A GP address structure.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EmberGpAddress implements GpAddress{

    /**
     * The GPD's EUI64.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress gpdIeeeAddress;

    /**
     * The GPD's source ID.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     */
    private int sourceId;

    /**
     * The GPD Application ID.
     * <p>
     * EZSP type is <i>EmberGpApplicationId</i> - Java type is {@link EmberGpApplicationId}
     */
    private EmberGpApplicationId applicationId;

    /**
     * The GPD endpoint.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int endpoint;

    /**
     * Default Constructor
     */
    public EmberGpAddress() {
    }

    public EmberGpAddress(EzspDeserializer deserializer) {
        deserialize(deserializer);
    }

    /**
     * The GPD's EUI64.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current gpdIeeeAddress as {@link IeeeAddress}
     */
    public IeeeAddress getGpdIeeeAddress() {
        return gpdIeeeAddress;
    }

    /**
     * The GPD's EUI64.
     *
     * @param gpdIeeeAddress the gpdIeeeAddress to set as {@link IeeeAddress}
     */
    public void setGpdIeeeAddress(IeeeAddress gpdIeeeAddress) {
        this.gpdIeeeAddress = gpdIeeeAddress;
    }

    /**
     * The GPD's source ID.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     *
     * @return the current sourceId as {@link int}
     */
    public int getSourceId() {
        return sourceId;
    }

    /**
     * The GPD's source ID.
     *
     * @param sourceId the sourceId to set as {@link int}
     */
    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * The GPD Application ID.
     * <p>
     * EZSP type is <i>EmberGpApplicationId</i> - Java type is {@link EmberGpApplicationId}
     *
     * @return the current applicationId as {@link EmberGpApplicationId}
     */
    public EmberGpApplicationId getApplicationId() {
        return applicationId;
    }

    /**
     * The GPD Application ID.
     *
     * @param applicationId the applicationId to set as {@link EmberGpApplicationId}
     */
    public void setApplicationId(EmberGpApplicationId applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * The GPD endpoint.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current endpoint as {@link int}
     */
    public int getEndpoint() {
        return endpoint;
    }

    /**
     * The GPD endpoint.
     *
     * @param endpoint the endpoint to set as {@link int}
     */
    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Serialise the contents of the EZSP structure.
     *
     * @param serializer the {@link EzspSerializer} used to serialize
     */
    public int[] serialize(EzspSerializer serializer) {
        // Serialize the fields
        serializer.serializeEmberEui64(gpdIeeeAddress);
        serializer.serializeUInt32(sourceId);
        serializer.serializeEmberGpApplicationId(applicationId);
        serializer.serializeUInt8(endpoint);
        return serializer.getPayload();
    }

    /**
     * Deserialise the contents of the EZSP structure.
     *
     * @param deserializer the {@link EzspDeserializer} used to deserialize
     */
    public void deserialize(EzspDeserializer deserializer) {
        // Deserialize the fields
        gpdIeeeAddress = deserializer.deserializeEmberEui64();
        sourceId = deserializer.deserializeUInt32();
        applicationId = deserializer.deserializeEmberGpApplicationId();
        endpoint = deserializer.deserializeUInt8();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(117);
        builder.append("EmberGpAddress [gpdIeeeAddress=");
        builder.append(gpdIeeeAddress);
        builder.append(", sourceId=");
        builder.append(sourceId);
        builder.append(", applicationId=");
        builder.append(applicationId);
        builder.append(", endpoint=");
        builder.append(endpoint);
        builder.append(']');
        return builder.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
    	
    	if (obj == null || this.getClass() != obj.getClass()) {
    		return false;
    	}
    	
    	EmberGpAddress address = (EmberGpAddress) obj;

    	if (!address.getGpdIeeeAddress().equals(this.getGpdIeeeAddress())) {
    		System.out.println("failed: different gpdIeeeAddress");
    		System.out.println(this.getGpdIeeeAddress());
    		System.out.println(address.getGpdIeeeAddress());
    		return false;
    	}
    	
    	if (address.getSourceId() != this.getSourceId()) {
    		System.out.println("failed: different sourceId");
    		return false;
    	}
    	
    	if (address.getApplicationId() != this.getApplicationId()) {
    		System.out.println("failed: different ApplicationId");
    		System.out.println(this.getApplicationId());
    		System.out.println(address.getApplicationId());
    		return false;
    	}
    	
    	if (address.getEndpoint() != this.getEndpoint()) {
    		System.out.println("failed: different endpoint");
    		return false;
    	}
    	
    	return true;
    }
}
