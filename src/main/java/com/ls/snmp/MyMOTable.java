package com.ls.snmp;

import java.util.ArrayList;
import java.util.List;

import org.snmp4j.agent.MOScope;
import org.snmp4j.agent.mo.DefaultMOMutableRow2PC;
import org.snmp4j.agent.mo.DefaultMOTable;
import org.snmp4j.agent.mo.MOColumn;
import org.snmp4j.agent.mo.MOMutableTableModel;
import org.snmp4j.agent.mo.MOTableIndex;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.Variable;

@SuppressWarnings("rawtypes")
public class MyMOTable<R, C, M> extends DefaultMOTable {
  private List<Variable[]> tableRows = new ArrayList<Variable[]>();
  private int currentRow = 0;
  private int currentCol = 0;
  @SuppressWarnings({ "unchecked"})
  public MyMOTable(OID oid, MOTableIndex indexDef, MOColumn[] columns) {
    super(oid, indexDef, columns);
    
  }
  public MOScope getScope() {    
    MOMutableTableModel model = (MOMutableTableModel) this.getModel();
    model.clear();
    tableRows.clear();
    currentRow = 0;
    currentCol = 0;
    MyMIB.fillData(this);
    updateData(model);
    return this;
  }
  
  public void addRowValue(Variable variable) {
    if (tableRows.size() == currentRow) {
      tableRows.add(new Variable[5]);
    }
    tableRows.get(currentRow)[currentCol] = variable;
    currentCol++;
    if (currentCol >= 5) {
      currentRow++;
      currentCol = 0;
    }
  }
  
  @SuppressWarnings("unchecked")
  public void updateData(MOMutableTableModel model){
    int i = 1;
    for (Variable[] variables : tableRows) {
      model.addRow(new DefaultMOMutableRow2PC(new OID(String.valueOf(i)),
          variables));
      i++;
    }
  }
}
