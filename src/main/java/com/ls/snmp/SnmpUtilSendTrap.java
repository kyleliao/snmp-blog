package com.ls.snmp;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TimeTicks;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpUtilSendTrap {  
  
  private Snmp snmp = null;  
  private Address targetAddress = null;  
    
  public static void main(String[] args) {  
      try {  
          SnmpUtilSendTrap util = new SnmpUtilSendTrap("udp","127.0.0.1","162");  
          util.sendPDU(MyMIB.ServerError,new OctetString("ffffff"));  
      } catch (IOException e) {  
          e.printStackTrace();  
      }  
  }  

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public  SnmpUtilSendTrap(String protocal,String ip,String port) throws IOException {  
      targetAddress = GenericAddress.parse(protocal.toLowerCase()+":"+ip+"/"+port);  
      TransportMapping transport = new DefaultUdpTransportMapping();  
      snmp = new Snmp(transport);  
      transport.listen();  
  }  

  /** 
   * 向管理进程发送Trap报文 
   *  
   * @throws IOException 
   */  
  public void sendPDU(String snmpTrapOID,Variable value) throws IOException {  
     
      CommunityTarget target = new CommunityTarget();  
      target.setAddress(targetAddress);  
      target.setRetries(2);  
      target.setTimeout(1000 * 5);
      target.setVersion(SnmpConstants.version2c);
    
      PDU pdu = new PDU();
      TimeTicks sysUpTime = new TimeTicks((long)(System.currentTimeMillis()/1000));
      pdu.add(new VariableBinding(SnmpConstants.sysUpTime, sysUpTime));
      pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, new OID("." + snmpTrapOID)));
      pdu.add(new VariableBinding(new OID("." + snmpTrapOID + ".0"),value));
      pdu.setType(PDU.TRAP);  
     
      snmp.send(pdu, target);
  }     
} 
