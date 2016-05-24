package com.ls.snmp;

import java.util.Random;

import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.agent.mo.MOTable;
import org.snmp4j.smi.Counter64;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.Variable;

public class MyMIB {
  
  /*MyMIB root oid*/
  /*-----------------------------------------------------------------------------------*/
  public static final String ROOT_OID = "1.3.6.1.4.1.99999";
  
  /*host table oid*/
  /*-----------------------------------------------------------------------------------*/
  public static final String HOST_TABLE_ROOT_ID = ROOT_OID+".1.1";
  
  /*-----------------------------------------------------------------------------------*/
  public static final String CAPACITY_TOTAL = ROOT_OID+".2.1.0";
  public static final String CAPACITY_USED = ROOT_OID+".2.2.0";
  public static final String CAPACITY_FREE = ROOT_OID+".2.3.0";
  public static final String SERVER_MODE = ROOT_OID+".3.1.0";
  
  /*-----------------------------------------------------------------------------------*/
  
  public static final String ServerError = ROOT_OID + ".7.1";
  
  /*-----------------------------------------------------------------------------------*/
  public static final String AP_CLUSTER="4";
  public static final String META_CLUSTER="5";
  public static final String STORAGE_CLUSTER="6";
  
  public static final String MINUTE="1";
  public static final String HOUR="2";
  public static final String DAY="3";
  public static final String WEEK="4";
  public static final String MONTH="5";
  public static final String YEAR="6";
  
  public static final String FILE_READANDWRITE="1";
  public static final String FILE_READ="2";
  public static final String FILE_WRITE="3";
  public static final String FILE_CREATEANDDELETE="4";
  public static final String DIR_CTEATEANDDELETE="5";
  public static final String FILE_QUEYR="6";
  
  public static final String NETWORK_IO="1";
  public static final String NETWORK_INPUT="2";
  public static final String NETWORK_OUTPUT="3";
  public static final String LOAD="4";
  public static final String CPU="5";
 /*----------------------------------------------------------------------------------*/ 
 
  @SuppressWarnings("rawtypes")
  public static MOTable defineHostTable(){
    MOTableBuilder mob = new MOTableBuilder(new OID(MyMIB.HOST_TABLE_ROOT_ID));
    mob.addColumnType(SMIConstants.SYNTAX_INTEGER32, MOAccessImpl.ACCESS_READ_ONLY);
    mob.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
    mob.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
    mob.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
    mob.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_ONLY);
    return mob.build();
  }
  
  @SuppressWarnings("rawtypes")
  public static void fillData(MyMOTable table){
    if(MyMIB.HOST_TABLE_ROOT_ID.equals(table.getOID().toString())){      
      table.addRowValue(new Integer32(new Random().nextInt(100)));
      table.addRowValue(new OctetString("a"));
      table.addRowValue(new OctetString("b"));
      table.addRowValue(new OctetString("c"));
      table.addRowValue(new OctetString("d"));
      table.addRowValue(new Integer32(new Random().nextInt(100)));
      table.addRowValue(new OctetString("e"));
      table.addRowValue(new OctetString("f"));
      table.addRowValue(new OctetString("g"));
      table.addRowValue(new OctetString("h"));
      table.addRowValue(new Integer32(new Random().nextInt(100)));
      table.addRowValue(new OctetString("i"));
      table.addRowValue(new OctetString("j"));
      table.addRowValue(new OctetString("k"));
      table.addRowValue(new OctetString("l"));
    }
  }
  
  public static Variable getValue(OID oid){
    System.out.println(oid.toString());
    if(SERVER_MODE.equals(oid.toString())){
      return new OctetString("fuck");
    }
    if(CAPACITY_FREE.equals(oid.toString())){
      return new Counter64(100); 
    }
    if(CAPACITY_TOTAL.equals(oid.toString())){
      return new Counter64(1000);
    }
    if(CAPACITY_USED.equals(oid.toString())){
      return new Counter64(900);
    }
    return new OctetString("undefined");
  }
  
  public static void register(Agent agent){
    agent.registerManagedObject(createMyMOScalar(SERVER_MODE));
    agent.registerManagedObject(createMyMOScalar(CAPACITY_FREE));
    agent.registerManagedObject(createMyMOScalar(CAPACITY_TOTAL));
    agent.registerManagedObject(createMyMOScalar(CAPACITY_USED));
    registerCustom(agent);
    agent.registerManagedObject(defineHostTable());
  }
  
  public static MyMOScalar<Variable> createMyMOScalar(String oid){
    return new MyMOScalar<Variable>(new OID(oid), MOAccessImpl.ACCESS_READ_ONLY, null);
  }
  
  public static void registerCustom(Agent agent){
    String[] date = new String[]{MINUTE,HOUR,DAY,WEEK,MONTH,YEAR};
    String[] aptype = new String[]{FILE_READANDWRITE,FILE_READ,FILE_WRITE,FILE_CREATEANDDELETE,DIR_CTEATEANDDELETE,FILE_QUEYR};
    String[] meta_storage_type = new String[]{NETWORK_IO,NETWORK_INPUT,NETWORK_OUTPUT,LOAD,CPU};
    for(int i=0;i<date.length;i++){
      for(int j=0;j<aptype.length;j++){
        agent.registerManagedObject(createMyMOScalar(ROOT_OID+"."+AP_CLUSTER+"."+date[i]+"."+aptype[j]+".0"));
      }
      for(int j=0;j<meta_storage_type.length;j++){
        agent.registerManagedObject(createMyMOScalar(ROOT_OID+"."+META_CLUSTER+"."+date[i]+"."+meta_storage_type[j]+".0"));
        agent.registerManagedObject(createMyMOScalar(ROOT_OID+"."+STORAGE_CLUSTER+"."+date[i]+"."+meta_storage_type[j]+".0"));
      }
    }
  }
}
