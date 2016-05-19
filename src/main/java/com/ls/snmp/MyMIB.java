package com.ls.snmp;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class MyMIB {

  public static final String HOST_TABLE_ROOT_ID = ".1.3.6.1.4.1.99999.1.1";
  public static final String CAPACITY_TOTAL = ".1.3.6.1.4.1.99999.2.1";
  public static final String CAPACITY_USED = ".1.3.6.1.4.1.99999.2.2";
  public static final String CAPACITY_FREE = ".1.3.6.1.4.1.99999.2.3";
  public static final String SERVER_MODE = ".1.3.6.1.4.1.99999.3.1.0";
  
  /*-----------------------------------------------------------------------------------*/
  
  public static final String AP_CLUSTER_MINUTE_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.1.1";
  public static final String AP_CLUSTER_MINUTE_FILE_READ = ".1.3.6.1.4.1.99999.4.1.2";
  public static final String AP_CLUSTER_MINUTE_FILE_WRITE = ".1.3.6.1.4.1.99999.4.1.3";
  public static final String AP_CLUSTER_MINUTE_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.1.4";
  public static final String AP_CLUSTER_MINUTE_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.1.5";
  public static final String AP_CLUSTER_MINUTE_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.1.6";

  public static final String AP_CLUSTER_HOUR_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.2.1";
  public static final String AP_CLUSTER_HOUR_FILE_READ = ".1.3.6.1.4.1.99999.4.2.2";
  public static final String AP_CLUSTER_HOUR_FILE_WRITE = ".1.3.6.1.4.1.99999.4.2.3";
  public static final String AP_CLUSTER_HOUR_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.2.4";
  public static final String AP_CLUSTER_HOUR_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.2.5";
  public static final String AP_CLUSTER_HOUR_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.2.6";

  public static final String AP_CLUSTER_DAY_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.3.1";
  public static final String AP_CLUSTER_DAY_FILE_READ = ".1.3.6.1.4.1.99999.4.3.2";
  public static final String AP_CLUSTER_DAY_FILE_WRITE = ".1.3.6.1.4.1.99999.4.3.3";
  public static final String AP_CLUSTER_DAY_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.3.4";
  public static final String AP_CLUSTER_DAY_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.3.5";
  public static final String AP_CLUSTER_DAY_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.3.6";

  public static final String AP_CLUSTER_WEEK_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.4.1";
  public static final String AP_CLUSTER_WEEK_FILE_READ = ".1.3.6.1.4.1.99999.4.4.2";
  public static final String AP_CLUSTER_WEEK_FILE_WRITE = ".1.3.6.1.4.1.99999.4.4.3";
  public static final String AP_CLUSTER_WEEK_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.4.4";
  public static final String AP_CLUSTER_WEEK_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.4.5";
  public static final String AP_CLUSTER_WEEK_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.4.6";

  public static final String AP_CLUSTER_MONTH_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.5.1";
  public static final String AP_CLUSTER_MONTH_FILE_READ = ".1.3.6.1.4.1.99999.4.5.2";
  public static final String AP_CLUSTER_MONTH_FILE_WRITE = ".1.3.6.1.4.1.99999.4.5.3";
  public static final String AP_CLUSTER_MONTH_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.5.4";
  public static final String AP_CLUSTER_MONTH_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.5.5";
  public static final String AP_CLUSTER_MONTH_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.5.6";

  public static final String AP_CLUSTER_YEAR_FILE_READANDWRITE = ".1.3.6.1.4.1.99999.4.6.1";
  public static final String AP_CLUSTER_YEAR_FILE_READ = ".1.3.6.1.4.1.99999.4.6.2";
  public static final String AP_CLUSTER_YEAR_FILE_WRITE = ".1.3.6.1.4.1.99999.4.6.3";
  public static final String AP_CLUSTER_YEAR_FILE_CREATEANDDELETE = ".1.3.6.1.4.1.99999.4.6.4";
  public static final String AP_CLUSTER_YEAR_DIR_CTEATEANDDELETE = ".1.3.6.1.4.1.99999.4.6.5";
  public static final String AP_CLUSTER_YEAR_FILE_QUEYR = ".1.3.6.1.4.1.99999.4.6.6";
  
  /*--------------------------------------------------------------------------------------*/

  public static final String MEAT_CLUSTER_MINUTE_NETWORK_IO = ".1.3.6.1.4.1.99999.5.1.1";
  public static final String MEAT_CLUSTER_MINUTE_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.1.2";
  public static final String MEAT_CLUSTER_MINUTE_NETWORK_OUTPUT = " .1.3.6.1.4.1.99999.5.1.3";
  public static final String MEAT_CLUSTER_MINUTE_LOAD = ".1.3.6.1.4.1.99999.5.1.4";
  public static final String MEAT_CLUSTER_MINUTE_CPU = ".1.3.6.1.4.1.99999.5.1.5";

  public static final String MEAT_CLUSTER_HOUR_NETWORK_IO = ".1.3.6.1.4.1.99999.5.2.1";
  public static final String MEAT_CLUSTER_HOUR_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.2.2";
  public static final String MEAT_CLUSTER_HOUR_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.5.2.3";
  public static final String MEAT_CLUSTER_HOUR_LOAD = ".1.3.6.1.4.1.99999.5.2.4";
  public static final String MEAT_CLUSTER_HOUR_CPU = ".1.3.6.1.4.1.99999.5.2.5";

  public static final String MEAT_CLUSTER_DAY_NETWORK_IO = ".1.3.6.1.4.1.99999.5.3.1";
  public static final String MEAT_CLUSTER_DAY_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.3.2";
  public static final String MEAT_CLUSTER_DAY_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.5.3.3";
  public static final String MEAT_CLUSTER_DAY_LOAD = ".1.3.6.1.4.1.99999.5.3.4";
  public static final String MEAT_CLUSTER_DAY_CPU = ".1.3.6.1.4.1.99999.5.3.5";

  public static final String MEAT_CLUSTER_WEEK_NETWORK_IO = ".1.3.6.1.4.1.99999.5.4.1";
  public static final String MEAT_CLUSTER_WEEK_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.4.2";
  public static final String MEAT_CLUSTER_WEEK_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.5.4.3";
  public static final String MEAT_CLUSTER_WEEK_LOAD = ".1.3.6.1.4.1.99999.5.4.4";
  public static final String MEAT_CLUSTER_WEEK_CPU = ".1.3.6.1.4.1.99999.5.4.5";

  public static final String MEAT_CLUSTER_MONTH_NETWORK_IO = ".1.3.6.1.4.1.99999.5.5.1";
  public static final String MEAT_CLUSTER_MONTH_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.5.2";
  public static final String MEAT_CLUSTER_MONTH_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.5.5.3";
  public static final String MEAT_CLUSTER_MONTH_LOAD = ".1.3.6.1.4.1.99999.5.5.4";
  public static final String MEAT_CLUSTER_MONTH_CPU = ".1.3.6.1.4.1.99999.5.5.5";

  public static final String MEAT_CLUSTER_YEAR_NETWORK_IO = ".1.3.6.1.4.1.99999.5.6.1";
  public static final String MEAT_CLUSTER_YEAR_NETWORK_INPUT = ".1.3.6.1.4.1.99999.5.6.2";
  public static final String MEAT_CLUSTER_YEAR_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.5.6.3";
  public static final String MEAT_CLUSTER_YEAR_LOAD = ".1.3.6.1.4.1.99999.5.6.4";
  public static final String MEAT_CLUSTER_YEAR_CPU = ".1.3.6.1.4.1.99999.5.6.5";

  /*------------------------------------------------------------------------------------*/
  
  public static final String STORAGE_CLUSTER_MINUTE_NETWORK_IO = ".1.3.6.1.4.1.99999.6.1.1";
  public static final String STORAGE_CLUSTER_MINUTE_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.1.2";
  public static final String STORAGE_CLUSTER_MINUTE_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.1.3";
  public static final String STORAGE_CLUSTER_MINUTE_LOAD = ".1.3.6.1.4.1.99999.6.1.4";
  public static final String STORAGE_CLUSTER_MINUTE_CPU = ".1.3.6.1.4.1.99999.6.1.5";

  public static final String STORAGE_CLUSTER_HOUR_NETWORK_IO = ".1.3.6.1.4.1.99999.6.1.1";
  public static final String STORAGE_CLUSTER_HOUR_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.2.2";
  public static final String STORAGE_CLUSTER_HOUR_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.2.3";
  public static final String STORAGE_CLUSTER_HOUR_LOAD = ".1.3.6.1.4.1.99999.6.2.4";
  public static final String STORAGE_CLUSTER_HOUR_CPU = ".1.3.6.1.4.1.99999.6.2.5";

  public static final String STORAGE_CLUSTER_DAY_NETWORK_IO = ".1.3.6.1.4.1.99999.6.3.1";
  public static final String STORAGE_CLUSTER_DAY_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.3.2";
  public static final String STORAGE_CLUSTER_DAY_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.3.3";
  public static final String STORAGE_CLUSTER_DAY_LOAD = ".1.3.6.1.4.1.99999.6.3.4";
  public static final String STORAGE_CLUSTER_DAY_CPU = ".1.3.6.1.4.1.99999.6.3.5";

  public static final String STORAGE_CLUSTER_WEEK_NETWORK_IO = ".1.3.6.1.4.1.99999.6.4.1";
  public static final String STORAGE_CLUSTER_WEEK_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.4.2";
  public static final String STORAGE_CLUSTER_WEEK_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.4.3";
  public static final String STORAGE_CLUSTER_WEEK_LOAD = ".1.3.6.1.4.1.99999.6.4.4";
  public static final String STORAGE_CLUSTER_WEEK_CPU = ".1.3.6.1.4.1.99999.6.4.5";

  public static final String STORAGE_CLUSTER_MONTH_NETWORK_IO = ".1.3.6.1.4.1.99999.6.5.1";
  public static final String STORAGE_CLUSTER_MONTH_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.5.2";
  public static final String STORAGE_CLUSTER_MONTH_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.5.3";
  public static final String STORAGE_CLUSTER_MONTH_LOAD = ".1.3.6.1.4.1.99999.6.5.4";
  public static final String STORAGE_CLUSTER_MONTH_CPU = ".1.3.6.1.4.1.99999.6.5.5";

  public static final String STORAGE_CLUSTER_YEAR_NETWORK_IO = ".1.3.6.1.4.1.99999.6.6.1";
  public static final String STORAGE_CLUSTER_YEAR_NETWORK_INPUT = ".1.3.6.1.4.1.99999.6.6.2";
  public static final String STORAGE_CLUSTER_YEAR_NETWORK_OUTPUT = ".1.3.6.1.4.1.99999.6.6.3";
  public static final String STORAGE_CLUSTER_YEAR_LOAD = ".1.3.6.1.4.1.99999.6.6.4";
  public static final String STORAGE_CLUSTER_YEAR_CPU = ".1.3.6.1.4.1.99999.6.6.5";

  private Set<String> oids = null;

  public Set<String> getOIDS() {
    if (oids == null) {
      oids = new HashSet<String>();
      initOids(oids);
    }
    return oids;
  }

  public void initOids(Set<String> oids) {
    Class<MyMIB> cls = MyMIB.class;
    Field[] fields = cls.getFields();
    for (Field c : fields) {
      try {
        oids.add((String) c.get(c.getName()));
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }
  
}
