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



/** Example 2 */

/** IMHO it does not need to be public */

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



/** Example 3 */

/** parts[1].isEmpty */

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



/** Example 4 */

/** this will affect the sorting also on the webadmin - but on webadmin we support sortable columns.  Please move this logic to UserPortalTemplateListModel. */

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



/** Example 5 */

/** why you need this line? table.setRowData(new ArrayList<ListModel>()); */

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



/** Example 6 */

/** why not directly assertEquals(LOW, fCondition.min()); ? */

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


public void testBounds ( ) {
  int low = fCondition . min ( ) ;
  assertEquals ( LOW , low ) ;
  int high = fCondition . max ( ) ;
  assertEquals ( HIGH , high ) ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** Let's move this into an EnablementTester.evaluate(...) method. */

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



/** Example 8 */

/** 'null' must be first operande */

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



/** Example 9 */

/** This method can be`private`. */

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



/** Example 10 */

/** forgotten line of code? */

public String getAuthorizationUrl ( OAuthConfig config ) {
  System . out . print ( "Authorisation URL: " ) ;
  String url = String . format ( AUTHORIZE_URL , OAuthEncoder . encode ( config . getApiKey ( ) ) , OAuthEncoder . encode ( config . getCallback ( ) ) , OAuthEncoder . encode ( config . getScope ( ) ) , OAuthEncoder . encode ( config . getState ( ) ) ) ;
  return url ;
}


public String getAuthorizationUrl ( OAuthConfig config ) {
  System . out . print ( "Authorisation URL: " ) ;
  String url = String . format ( AUTHORIZE_URL , OAuthEncoder . encode ( config . getApiKey ( ) ) , OAuthEncoder . encode ( config . getCallback ( ) ) , OAuthEncoder . encode ( config . getScope ( ) ) , OAuthEncoder . encode ( config . getState ( ) ) ) ;
  return url ;
}


public String getAuthorizationUrl ( OAuthConfig config ) {
  System . out . print ( "Authorisation URL: " ) ;
  String url = String . format ( AUTHORIZE_URL , OAuthEncoder . encode ( config . getApiKey ( ) ) , OAuthEncoder . encode ( config . getCallback ( ) ) , OAuthEncoder . encode ( config . getScope ( ) ) , OAuthEncoder . encode ( config . getState ( ) ) ) ;
  return url ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** This code here should be inside the if, because we don't need to do anything if the parameter request is not PARAM_WORKER */

public Object getParameter ( String name ) {
  final HostThread currentHostThread = fCurrentHostThread ;
  if ( currentHostThread == null ) {
    return null ;
  }
  if ( name . equals ( CriticalPathModule . PARAM_WORKER ) ) {
    IAnalysisModule mod = getModule ( ) ;
    if ( ( mod != null ) && ( mod instanceof CriticalPathModule ) ) {
      LttngWorker worker = new LttngWorker ( currentHostThread , "" , 0 ) ;
      return worker ;
    }
    return currentHostThread ;
  }
  return null ;
}


public Object getParameter ( String name ) {
  final HostThread currentHostThread = fCurrentHostThread ;
  if ( currentHostThread == null ) {
    return null ;
  }
  if ( name . equals ( CriticalPathModule . PARAM_WORKER ) ) {
    IAnalysisModule mod = getModule ( ) ;
    if ( ( mod != null ) && ( mod instanceof CriticalPathModule ) ) {
      LttngWorker worker = new LttngWorker ( currentHostThread , "" , 0 ) ;
      return worker ;
    }
    return currentHostThread ;
  }
  return null ;
}


public Object getParameter ( String name ) {
  final HostThread currentHostThread = fCurrentHostThread ;
  if ( currentHostThread == null ) {
    return null ;
  }
  if ( name . equals ( CriticalPathModule . PARAM_WORKER ) ) {
    IAnalysisModule mod = getModule ( ) ;
    if ( ( mod != null ) && ( mod instanceof CriticalPathModule ) ) {
      LttngWorker worker = new LttngWorker ( currentHostThread , "" , 0 ) ;
      return worker ;
    }
    return currentHostThread ;
  }
  return null ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** Maybe `expectThrowable` for consistency? */

public static ExceptionThrowingSubTest expectThrowable ( Runnable runnable ) {
  return expectException ( runnable . toString ( ) , runnable ) ;
}


public static ExceptionThrowingSubTest expectThrowable ( Runnable runnable ) {
  return expectException ( runnable . toString ( ) , runnable ) ;
}


public static ExceptionThrowingSubTest expectThrowable ( Runnable runnable ) {
  return expectException ( runnable . toString ( ) , runnable ) ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** Can we add the name of the setting in there somewhere as well? */

public < V > Setting < V > get ( SimpleUri id , Class < V > valueType ) {
  Setting setting = settings . get ( id ) ;
  Class settingValueClass = setting . getValueClass ( ) ;
  if ( ! settingValueClass . equals ( valueType ) ) {
    throw new ClassCastException ( "Expected a Setting of type " + valueType . getName ( ) + ", found a Setting of type " + settingValueClass . getName ( ) ) ;
  }
  return ( Setting < V > ) setting ;
}


public < V > Setting < V > get ( SimpleUri id , Class < V > valueType ) {
  Setting setting = settings . get ( id ) ;
  Class settingValueClass = setting . getValueClass ( ) ;
  if ( ! settingValueClass . equals ( valueType ) ) {
    throw new ClassCastException ( "Expected a Setting of type " + valueType . getName ( ) + ", found a Setting of type " + settingValueClass . getName ( ) ) ;
  }
  return ( Setting < V > ) setting ;
}


public < V > Setting < V > get ( SimpleUri id , Class < V > valueType ) {
  Setting setting = settings . get ( id ) ;
  Class settingValueClass = setting . getValueClass ( ) ;
  if ( ! settingValueClass . equals ( valueType ) ) {
    throw new ClassCastException ( "Expected a Setting of type " + valueType . getName ( ) + ", found a Setting of type " + settingValueClass . getName ( ) ) ;
  }
  return ( Setting < V > ) setting ;
}


*************************this is the dividing line*****************************



/** Example 14 */

/** Any way we can clean this up? It seems to only be needed for example commands, but hard to check what the command is here since it's wrapped in decorators. */

private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  String expression = commandCall . getExpression ( ) ;
  if ( expression . equals ( "" ) ) {
    expression = element . getText ( ) ;
  }
  return new CommandCall ( null , commandCall . getCommand ( ) , element , expression , commandCall . getResource ( ) ) ;
}


private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  String expression = commandCall . getExpression ( ) ;
  if ( expression . equals ( "" ) ) {
    expression = element . getText ( ) ;
  }
  return new CommandCall ( null , commandCall . getCommand ( ) , element , expression , commandCall . getResource ( ) ) ;
}


private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  String expression = commandCall . getExpression ( ) ;
  if ( expression . equals ( "" ) ) {
    expression = element . getText ( ) ;
  }
  return new CommandCall ( null , commandCall . getCommand ( ) , element , expression , commandCall . getResource ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** TException is throwable, too, and treated the same -- combine the catch clauses? */

public M fromBytes ( byte [ ] messageBuffer ) {
  if ( deserializer == null ) deserializer = new ThriftBinaryDeserializer ( ) ;
  try {
    M message = typeRef . safeNewInstance ( ) ;
    deserializer . deserialize ( message , messageBuffer ) ;
    return message ;
  }
  catch ( TException e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
  catch ( Throwable e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
}


public M fromBytes ( byte [ ] messageBuffer ) {
  if ( deserializer == null ) deserializer = new ThriftBinaryDeserializer ( ) ;
  try {
    M message = typeRef . safeNewInstance ( ) ;
    deserializer . deserialize ( message , messageBuffer ) ;
    return message ;
  }
  catch ( TException e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
  catch ( Throwable e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
}


public M fromBytes ( byte [ ] messageBuffer ) {
  if ( deserializer == null ) deserializer = new ThriftBinaryDeserializer ( ) ;
  try {
    M message = typeRef . safeNewInstance ( ) ;
    deserializer . deserialize ( message , messageBuffer ) ;
    return message ;
  }
  catch ( TException e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
  catch ( Throwable e ) {
    logWarning ( "failed to deserialize" , e ) ;
    return null ;
  }
}


*************************this is the dividing line*****************************



/** Example 16 */

/** remove */

public void showPage ( Control page ) {
  if ( page . isDisposed ( ) || page . getParent ( ) != this ) {
    return ;
  }
  currentPage = page ;
  page . setVisible ( true ) ;
  layout ( true ) ;
  Control [ ] children = getChildren ( ) ;
  for ( Control element : children ) {
    Control child = element ;
    if ( child != page && ! child . isDisposed ( ) ) {
      child . setVisible ( false ) ;
    }
  }
}


public void showPage ( Control page ) {
  if ( page . isDisposed ( ) || page . getParent ( ) != this ) {
    return ;
  }
  currentPage = page ;
  page . setVisible ( true ) ;
  layout ( true ) ;
  Control [ ] children = getChildren ( ) ;
  for ( Control element : children ) {
    Control child = element ;
    if ( child != page && ! child . isDisposed ( ) ) {
      child . setVisible ( false ) ;
    }
  }
}


public void showPage ( Control page ) {
  if ( page . isDisposed ( ) || page . getParent ( ) != this ) {
    return ;
  }
  currentPage = page ;
  page . setVisible ( true ) ;
  layout ( true ) ;
  Control [ ] children = getChildren ( ) ;
  for ( Control element : children ) {
    Control child = element ;
    if ( child != page && ! child . isDisposed ( ) ) {
      child . setVisible ( false ) ;
    }
  }
}


*************************this is the dividing line*****************************



/** Example 17 */

/** Let's avoid `null` and rework to empty string */

public String getLinkAt ( int offset ) {
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . isOffsetInRange ( offset ) ) {
      return hrefs . get ( i ) ;
    }
  }
  return null ;
}


public String getLinkAt ( int offset ) {
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . isOffsetInRange ( offset ) ) {
      return hrefs . get ( i ) ;
    }
  }
  return null ;
}


public String getLinkAt ( int offset ) {
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . isOffsetInRange ( offset ) ) {
      return hrefs . get ( i ) ;
    }
  }
  return null ;
}


*************************this is the dividing line*****************************



/** Example 18 */

/** Please not here. This is not a standard SWT table. */

protected Control createControl ( Composite parent ) {
  CTConfiguration config = new CTConfiguration ( parent , CTConfiguration . STYLE_GRID ) ;
  config . setHorizontalAlignment ( SWT . CENTER ) ;
  config . setCellSelectionEnabled ( false ) ;
  config . setColumnSelectionEnabled ( false ) ;
  config . setRowSelectionEnabled ( false ) ;
  config . setColumnHeaderLayout ( CTConfiguration . COLUMN_HEADER_LAYOUT_FILL_EQUAL ) ;
  config . setRowHeaderLayout ( CTConfiguration . ROW_HEADER_LAYOUT_DEFAULT ) ;
  this . table = new ComponentTable ( parent , SWT . FULL_SELECTION , config ) ;
  return this . table . getControl ( ) ;
}


protected Control createControl ( Composite parent ) {
  CTConfiguration config = new CTConfiguration ( parent , CTConfiguration . STYLE_GRID ) ;
  config . setHorizontalAlignment ( SWT . CENTER ) ;
  config . setCellSelectionEnabled ( false ) ;
  config . setColumnSelectionEnabled ( false ) ;
  config . setRowSelectionEnabled ( false ) ;
  config . setColumnHeaderLayout ( CTConfiguration . COLUMN_HEADER_LAYOUT_FILL_EQUAL ) ;
  config . setRowHeaderLayout ( CTConfiguration . ROW_HEADER_LAYOUT_DEFAULT ) ;
  this . table = new ComponentTable ( parent , SWT . FULL_SELECTION , config ) ;
  return this . table . getControl ( ) ;
}


protected Control createControl ( Composite parent ) {
  CTConfiguration config = new CTConfiguration ( parent , CTConfiguration . STYLE_GRID ) ;
  config . setHorizontalAlignment ( SWT . CENTER ) ;
  config . setCellSelectionEnabled ( false ) ;
  config . setColumnSelectionEnabled ( false ) ;
  config . setRowSelectionEnabled ( false ) ;
  config . setColumnHeaderLayout ( CTConfiguration . COLUMN_HEADER_LAYOUT_FILL_EQUAL ) ;
  config . setRowHeaderLayout ( CTConfiguration . ROW_HEADER_LAYOUT_DEFAULT ) ;
  this . table = new ComponentTable ( parent , SWT . FULL_SELECTION , config ) ;
  return this . table . getControl ( ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** return 'true' */

public boolean isEnabled ( ) {
  return getActiveTextEditor ( ) != null ;
}


public boolean isEnabled ( ) {
  return getActiveTextEditor ( ) != null ;
}


public boolean isEnabled ( ) {
  return getActiveTextEditor ( ) != null ;
}


*************************this is the dividing line*****************************



