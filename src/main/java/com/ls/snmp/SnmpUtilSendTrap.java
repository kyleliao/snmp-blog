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
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpUtilSendTrap {  
  
  private Snmp snmp = null;  
  private Address targetAddress = null;  
    
  public static void main(String[] args) {  
      try {  
          SnmpUtilSendTrap util = new SnmpUtilSendTrap("udp:127.0.0.1/162");  
          util.sendPDU();  
      } catch (IOException e) {  
          e.printStackTrace();  
      }  
  }  

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public  SnmpUtilSendTrap(String attr) throws IOException {  
      targetAddress = GenericAddress.parse(attr);  
      TransportMapping transport = new DefaultUdpTransportMapping();  
      snmp = new Snmp(transport);  
      transport.listen();  
  }  

  /** 
   * 向管理进程发送Trap报文 
   *  
   * @throws IOException 
   */  
  public void sendPDU() throws IOException {  
      // 设置 target  
      CommunityTarget target = new CommunityTarget();  
      target.setAddress(targetAddress);  
      // 通信不成功时的重试次数  
      target.setRetries(2);  
      // 超时时间  
      target.setTimeout(1000 * 5);
      // snmp版本  
      target.setVersion(SnmpConstants.version2c);  
      // 创建 PDU  
      PDU pdu = new PDU();
      
      TimeTicks sysUpTime = new TimeTicks((long)(System.currentTimeMillis()/1000));
      pdu.add(new VariableBinding(SnmpConstants.sysUpTime, sysUpTime));

      pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, new OID(".1.3.6.1.4.1.99999.7.1")));
      pdu.add(new VariableBinding(new OID("."+MyMIB.ServerError),new OctetString("aaaa")));  
      pdu.setType(PDU.TRAP);  
      // 向Agent发送PDU，并接收Response  
      snmp.send(pdu, target);
  }     
} 
