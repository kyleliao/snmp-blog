package com.ls.snmp;

import java.util.Random;

import org.snmp4j.agent.MOAccess;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;

public class MyMOScalar<V extends Variable> extends MOScalar<Variable>{
  public MyMOScalar(OID id, MOAccess access, V value) {
    super(id, access, value);
    this.oid = id;
    this.access = access;
  }
  public Variable getValue() {
    return new OctetString(""+new Random().nextInt(100));
  }
}
