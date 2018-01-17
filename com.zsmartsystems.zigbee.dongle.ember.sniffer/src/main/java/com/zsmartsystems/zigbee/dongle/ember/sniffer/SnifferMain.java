package com.zsmartsystems.zigbee.dongle.ember.sniffer;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.LoggerFactory;

import com.zsmartsystems.zigbee.ExtendedPanId;
import com.zsmartsystems.zigbee.ZigBeeKey;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.ZigBeeNetworkMeshMonitor;
import com.zsmartsystems.zigbee.ZigBeeNetworkStateSerializer;
import com.zsmartsystems.zigbee.ZigBeeProfileType;
import com.zsmartsystems.zigbee.dongle.ember.ZigBeeDongleEzsp;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EzspConfigId;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EzspDecisionId;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EzspPolicyId;
import com.zsmartsystems.zigbee.serial.ZigBeeSerialPort;
import com.zsmartsystems.zigbee.serialization.DefaultDeserializer;
import com.zsmartsystems.zigbee.serialization.DefaultSerializer;
import com.zsmartsystems.zigbee.transport.TransportConfig;
import com.zsmartsystems.zigbee.transport.TransportConfigOption;
import com.zsmartsystems.zigbee.transport.ZigBeePort;
import com.zsmartsystems.zigbee.transport.ZigBeeTransportTransmit;
import com.zsmartsystems.zigbee.transport.ZigBeePort.FlowControl;
import com.zsmartsystems.zigbee.zcl.clusters.ZclIasZoneCluster;

public class SnifferMain {
    /**
     * The {@link org.slf4j.Logger}.
     */
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SnifferMain.class);


    /**
     * The main method.
     *
     * @param args the command arguments
     */
    public static void main(final String[] args) {
        
        final String serialPortName = "/dev/ttyUSB0";
        final int serialBaud = 57600;
        final FlowControl flowControl = FlowControl.FLOWCONTROL_OUT_XONOFF;

        System.out.println("Create Serial Port");
        final ZigBeePort serialPort = new ZigBeeSerialPort(serialPortName, serialBaud, flowControl);

        System.out.println("Create ezsp dongle");
        final ZigBeeDongleEzsp dongle = new ZigBeeDongleEzsp(serialPort);

        System.out.println("ASH Init");
        if( dongle.initializeEzspProtocol() ) {

            System.out.println("Configure stack");
            dongle.setStackConfigurationValue( EzspConfigId.EZSP_CONFIG_ADDRESS_TABLE_SIZE, 100 );
            dongle.applyStackConfiguration();
            
            System.out.println("Configure policy");
            dongle.setStackPolicyValue( EzspPolicyId.EZSP_POLL_HANDLER_POLICY, EzspDecisionId.EZSP_POLL_HANDLER_IGNORE );
            dongle.applyStackPolicy();
            
            System.out.println("Add endpoint");
            dongle.addEndpoint(1, 0x0007, ZigBeeProfileType.HOME_AUTOMATION.getId(), new int[] { 0 }, new int[] { 0 });
            
            System.out.println("Start network");
            dongle.initializeZigbeeNetwork();
        	
        	
        	System.out.println("Wait loop");
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        dongle.shutdown();
        System.out.println("Sniffer closed.");
    }

}
