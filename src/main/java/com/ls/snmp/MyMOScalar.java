package com.ls.snmp;

import org.snmp4j.agent.MOAccess;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.Variable;

public class MyMOScalar<V extends Variable> extends MOScalar<Variable>{
  public MyMOScalar(OID id, MOAccess access, V value) {
    super(id, access, value);
    this.oid = id;
    this.access = access;
  }
  public Variable getValue() {
    return MyMIB.getValue(this.getOid());
  }
}
