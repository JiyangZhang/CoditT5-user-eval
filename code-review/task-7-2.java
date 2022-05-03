/** Example 0 */

/** Shouldn't do this line - it's handled by the ...Optionally... bit in the Encr class. https://github.com/pentaho/pentaho-kettle/blob/master/core/src/org/pentaho/di/core/encryption/KettleTwoWayPasswordEncoder.java#L86-L91 */

private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    boolean isEncrypted = value . startsWith ( Encr . PASSWORD_ENCRYPTED_PREFIX ) ;
    if ( isPassword && isEncrypted ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    boolean isEncrypted = value . startsWith ( Encr . PASSWORD_ENCRYPTED_PREFIX ) ;
    if ( isPassword && isEncrypted ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    boolean isEncrypted = value . startsWith ( Encr . PASSWORD_ENCRYPTED_PREFIX ) ;
    if ( isPassword && isEncrypted ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 1 */

/** One use/test case is, a non-serializable pojo (user type) that is encoded as a UTF-8 byte[ ] with some string representation of it. */

private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    if ( isPassword ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    if ( isPassword ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


private static void setIfNotNullOrEmpty ( MongoProperties . Builder builder , MongoProp prop , String value ) {
  if ( value != null && value . trim ( ) . length ( ) > 0 ) {
    boolean isPassword = MongoProp . PASSWORD . equals ( prop ) ;
    if ( isPassword ) {
      value = Encr . decryptPasswordOptionallyEncrypted ( value ) ;
    }
    builder . set ( prop , value ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 2 */

/** IMHO it does not need to be public */

public Mutation toMutation ( K key ) {
  V valueFromStorage = ( V ) valueDataConversion . fromStorage ( value ) ;
  return new Mutations . ReadWriteWithValue < > ( valueFromStorage , f ) ;
}


public Mutation toMutation ( K key ) {
  V valueFromStorage = ( V ) valueDataConversion . fromStorage ( value ) ;
  return new Mutations . ReadWriteWithValue < > ( valueFromStorage , f ) ;
}


public Mutation toMutation ( K key ) {
  V valueFromStorage = ( V ) valueDataConversion . fromStorage ( value ) ;
  return new Mutations . ReadWriteWithValue < > ( valueFromStorage , f ) ;
}


*************************this is the dividing line*****************************



/** Example 3 */

/** parts[1].isEmpty */

public Mutation toMutation ( K key ) {
  return new Mutations . ReadWriteWithValue < > ( value , f ) ;
}


public Mutation toMutation ( K key ) {
  return new Mutations . ReadWriteWithValue < > ( value , f ) ;
}


public Mutation toMutation ( K key ) {
  return new Mutations . ReadWriteWithValue < > ( value , f ) ;
}


*************************this is the dividing line*****************************



/** Example 4 */

/** this will affect the sorting also on the webadmin - but on webadmin we support sortable columns.  Please move this logic to UserPortalTemplateListModel. */

public Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


public Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


public Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 5 */

/** why you need this line? table.setRowData(new ArrayList<ListModel>()); */

private Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


private Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


private Entry ( Map . Entry < String , String > e ) {
  this ( e . getKey ( ) , e . getValue ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 6 */

/** why not directly assertEquals(LOW, fCondition.min()); ? */

private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . length ( ) < 1 ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . length ( ) < 1 ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . length ( ) < 1 ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . length ( ) < 1 ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** Let's move this into an EnablementTester.evaluate(...) method. */

private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . isEmpty ( ) ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . isEmpty ( ) ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


private String parsePath ( ) throws URISyntaxException {
  String [ ] parts = uri . split ( "\\?" ) [ 0 ] . split ( ":" , 2 ) ;
  if ( parts . length < 2 || parts [ 1 ] . isEmpty ( ) ) throw new URISyntaxException ( uri , "invalid path" ) ;
  else return parts [ 1 ] ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** 'null' must be first operande */

public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  final List < VmTemplate > sortedValues = sortTemplates ( value ) ;
  super . setItems ( sortedValues ) ;
}


public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  final List < VmTemplate > sortedValues = sortTemplates ( value ) ;
  super . setItems ( sortedValues ) ;
}


public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  final List < VmTemplate > sortedValues = sortTemplates ( value ) ;
  super . setItems ( sortedValues ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** This method can be`private`. */

public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( value ) ;
}


public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( value ) ;
}


public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( value ) ;
}


*************************this is the dividing line*****************************



/** Example 10 */

/** forgotten line of code? */

public void edit ( VolumeBrickModel object ) {
  table . setRowData ( new ArrayList < ListModel > ( ) ) ;
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


public void edit ( VolumeBrickModel object ) {
  table . setRowData ( new ArrayList < ListModel > ( ) ) ;
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


public void edit ( VolumeBrickModel object ) {
  table . setRowData ( new ArrayList < ListModel > ( ) ) ;
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** This code here should be inside the if, because we don't need to do anything if the parameter request is not PARAM_WORKER */

public void edit ( VolumeBrickModel object ) {
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


public void edit ( VolumeBrickModel object ) {
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


public void edit ( VolumeBrickModel object ) {
  table . edit ( object . getBricks ( ) ) ;
  Driver . driver . edit ( object ) ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** Maybe `expectThrowable` for consistency? */

public void testBounds ( ) {
  int low = fCondition . min ( ) ;
  assertEquals ( LOW , low ) ;
  int high = fCondition . max ( ) ;
  assertEquals ( HIGH , high ) ;
}


public void testBounds ( ) {
  int low = fCondition . min ( ) ;
  assertEquals ( LOW , low ) ;
  int high = fCondition . max ( ) ;
  assertEquals ( HIGH , high ) ;
}


public void testBounds ( ) {
  int low = fCondition . min ( ) ;
  assertEquals ( LOW , low ) ;
  int high = fCondition . max ( ) ;
  assertEquals ( HIGH , high ) ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** Can we add the name of the setting in there somewhere as well? */

public void testBounds ( ) {
  assertEquals ( LOW , ( int ) fCondition . min ( ) ) ;
  assertEquals ( HIGH , ( int ) fCondition . max ( ) ) ;
}


public void testBounds ( ) {
  assertEquals ( LOW , ( int ) fCondition . min ( ) ) ;
  assertEquals ( HIGH , ( int ) fCondition . max ( ) ) ;
}


public void testBounds ( ) {
  assertEquals ( LOW , ( int ) fCondition . min ( ) ) ;
  assertEquals ( HIGH , ( int ) fCondition . max ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 14 */

/** Any way we can clean this up? It seems to only be needed for example commands, but hard to check what the command is here since it's wrapped in decorators. */

public boolean isExtensionEnabled ( ) {
  if ( enablement != null ) {
    try {
      return enablement . getExpression ( ) . evaluate ( new EvaluationContext ( null , new Object ( ) ) ) . equals ( EvaluationResult . TRUE ) ;
    }
    catch ( CoreException e ) {
    }
  }
  return true ;
}


public boolean isExtensionEnabled ( ) {
  if ( enablement != null ) {
    try {
      return enablement . getExpression ( ) . evaluate ( new EvaluationContext ( null , new Object ( ) ) ) . equals ( EvaluationResult . TRUE ) ;
    }
    catch ( CoreException e ) {
    }
  }
  return true ;
}


public boolean isExtensionEnabled ( ) {
  if ( enablement != null ) {
    try {
      return enablement . getExpression ( ) . evaluate ( new EvaluationContext ( null , new Object ( ) ) ) . equals ( EvaluationResult . TRUE ) ;
    }
    catch ( CoreException e ) {
    }
  }
  return true ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** TException is throwable, too, and treated the same -- combine the catch clauses? */

public boolean isExtensionEnabled ( ) {
  return enablement != null ? enablement . evaluate ( ) : true ;
}


public boolean isExtensionEnabled ( ) {
  return enablement != null ? enablement . evaluate ( ) : true ;
}


public boolean isExtensionEnabled ( ) {
  return enablement != null ? enablement . evaluate ( ) : true ;
}


*************************this is the dividing line*****************************



/** Example 16 */

/** remove */

public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( manager != null ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( manager != null ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( manager != null ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** Let's avoid `null` and rework to empty string */

public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( null != manager ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( null != manager ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


public ProviderNotificationManager createProviderNotificationManager ( final DiagramEventBroker diagramEventBroker , final EObject view , final NotificationListener notificationListener ) {
  if ( null != manager ) {
    return manager ;
  }
  manager = new ProviderNotificationManager ( diagramEventBroker , view , notificationListener ) {
    @ Override protected void registerListeners ( ) {
    }
  };
  return manager ;
}


*************************this is the dividing line*****************************



/** Example 18 */

/** Please not here. This is not a standard SWT table. */

public void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


public void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


public void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** return 'true' */

private void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


private void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


private void startSyncFolderOperation ( OCFile folder ) {
  long currentSyncTime = System . currentTimeMillis ( ) ;
  mSyncInProgress = true ;
  RemoteOperation synchFolderOp = new RefreshFolderOperation ( folder , currentSyncTime , false , false , false , getStorageManager ( ) , getAccount ( ) , getApplicationContext ( ) ) ;
  synchFolderOp . execute ( getAccount ( ) , this , null , null ) ;
}


*************************this is the dividing line*****************************



