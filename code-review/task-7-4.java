/** Example 0 */

/** this isn't needed anymore right? */

// Manual revision
public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT , factory . isSecure ( ) ) ) ;
}


// Suggested Revision A
public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException , KeeperException . NoNodeException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT ) ) ;
}


// Suggested Revision B
public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException , KeeperException . NoNodeException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT , factory . isSecure ( ) ) ) ;
}


==========================this is the dividing line=============================



/** Example 1 */

/** [optional] maybe this method can be static and should be moved to end of the class */

// Manual revision
private String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


// Suggested Revision A
static String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


// Suggested Revision B
public static String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


==========================this is the dividing line=============================



/** Example 2 */

/** Could you use `List#of` or `Collections#singletonList`? */

// Manual revision
public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = List . of ( factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

// Suggested Revision A
public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

// Suggested Revision B
public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = Arrays . of ( factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

==========================this is the dividing line=============================



/** Example 3 */

/** this will affect the sorting also on the webadmin - but on webadmin we support sortable columns.  Please move this logic to UserPortalTemplateListModel. */

// Manual revision
public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( value ) ;
}


// Suggested Revision A
public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( sortTemplates ( value ) ) ;
}


// Suggested Revision B
public void setItems ( Collection value ) {
  genVersionToBaseTemplate ( value ) ;
  super . setItems ( sortedValues ) ;
}


==========================this is the dividing line=============================



/** Example 4 */

/** I don't think the logic is necessary. We can have the default visibility as `GONE`. */

// Manual revision
public void setUpCallToAction ( String callToActionText ) {
  if ( callToActionText != null ) {
    callToActionContainer . setVisibility ( VISIBLE ) ;
    callToActionTextView . setText ( callToActionText ) ;
  }
  else {
    callToActionContainer . setVisibility ( GONE ) ;
  }
}


// Suggested Revision A
public void setUpCallToAction ( String callToActionText ) {
  callToActionContainer . setVisibility ( callToActionText == null ? GONE : VISIBLE ) ;
  callToActionTextView . setText ( callToActionText ) ;
}


// Suggested Revision B
public void setUpCallToAction ( String callToActionText ) {
  callToActionContainer . setVisibility ( VISIBLE ) ;
  callToActionTextView . setText ( callToActionText ) ;
}


==========================this is the dividing line=============================



/** Example 5 */

/** Should "planner.enable_hashagg" be set to **false** ?  "planner.enable_streamagg" defaults to **true** anyway. */

// Manual revision
public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . baselineValues ( 177819 ) . build ( ) . run ( ) ;
}


// Suggested Revision A
public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . optionSettingQueriesForTestQuery ( "alter session set `%s` = true" , PlannerSettings . STREAMAGG . getOptionName ( ) ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . build ( ) . run ( ) ;
}


// Suggested Revision B
public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . optionSettingQueriesForTestQuery ( "alter session set `%s` = true" , PlannerSettings . STREAMAGG . getOptionName ( ) ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . baselineValues ( 177819 ) . build ( ) . run ( ) ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** The last `null` is interpreted as a null `Flag`, not as a null `Flag[]`, and is causing some NPEs in the test suite: http://ci.infinispan.org/viewLog.html?buildId=6702&buildTypeId=bt9 */

// Manual revision
public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null ) ;
}


// Suggested Revision A
public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null , new Flag [ ] {
  }
  ) ;
}


// Suggested Revision B
public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null , null ) ;
}


==========================this is the dividing line=============================



/** Example 7 */

/** just for consistency, can we use `final int`? */

// Manual revision
void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  final int referencePosition = getDndListComponent ( ) . getPositionY ( elementReference ) ;
  getDndListComponent ( ) . setPositionY ( newElement , referencePosition ) ;
}


// Suggested Revision A
void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  final int referencePosition = getDndListComponent ( ) . getPositionY ( elementReference ) ;
  getDndListComponent ( ) . setPositionY ( newElement , referencePosition ) ;
}


// Suggested Revision B
void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  getDndListComponent ( ) . setPositionY ( newElement , elementReference ) ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** the second part of the OR is redundant: byte[].class != obj.getClass() */

// Manual revision
public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( obj == null ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( obj , otherByteArray ) ;
}


// Suggested Revision A
public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( byte [ ] . class != obj . getClass ( ) ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] byteArray = obj ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( byteArray , otherByteArray ) ;
}


// Suggested Revision B
public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( obj == null || byte [ ] . class != obj . getClass ( ) ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] byteArray = obj ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( byteArray , otherByteArray ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** Message needs changed. What does Retrofit do? Do we care if people overwrite this? I don't, and it breaks your `newBuilder()` desire. */

// Manual revision
public Builder client ( @ NonNull OkHttpClient client ) {
  if ( client == null ) {
    throw new NullPointerException ( "client == null" ) ;
  }
  downloader = new OkHttp3Downloader ( client , client . cache ( ) , true ) ;
  return this ;
}


// Suggested Revision A
public Builder client ( @ NonNull OkHttpClient client ) {
  if ( client == null ) {
    throw new NullPointerException ( "client == null" ) ;
  }
  downloader = new OkHttp3Downloader ( client , client . cache ( ) , true ) ;
  return this ;
}


// Suggested Revision B
public Builder client ( @ NonNull OkHttpClient client ) {
  if ( client == null ) {
    throw new NullPointerException ( "client == null" ) ;
  }
  if ( downloader != null ) {
    throw new IllegalArgumentException ( "Downloader already set." ) ;
  }
  downloader = new OkHttp3Downloader ( client , client . cache ( ) , true ) ;
  return this ;
}


==========================this is the dividing line=============================



/** Example 10 */

/** you don't need to do that if you're already calling `loadProperties` in the public constructor, right? https://github.com/caelum/vraptor4/pull/973/files#diff-b7b62c45c7478eb642acfb81c12a4227R82 */

// Manual revision
private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  DefaultEnvironment defaultEnvironment = new DefaultEnvironment ( environmentType ) ;
  return defaultEnvironment ;
}


// Suggested Revision A
private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  return defaultEnvironment ;
}


// Suggested Revision B
private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  DefaultEnvironment defaultEnvironment = new DefaultEnvironment ( environmentType ) ;
  defaultEnvironment . setup ( ) ;
  return defaultEnvironment ;
}


==========================this is the dividing line=============================



/** Example 11 */

/** macToLong returns 'long' */

// Manual revision
private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( ( int ) count ) ;
  }
}


// Suggested Revision A
private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( count ) ;
  }
}


// Suggested Revision B
private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( count . intValue ( ) ) ;
  }
}


==========================this is the dividing line=============================



/** Example 12 */

/** This shouldn't call `getAllConfigBag()`. It should use the `config` passed in, otherwise we lose the local values passed in to the obtain() method. Do you agree? */

// Manual revision
private CloudMachineNamer getCloudMachineNamer ( ConfigBag config ) {
  String namerClass = config . get ( LocationConfigKeys . CLOUD_MACHINE_NAMER_CLASS ) ;
  if ( namerClass != null ) {
    try {
      return ( CloudMachineNamer ) getManagementContext ( ) . getCatalog ( ) . getRootClassLoader ( ) . loadClass ( namerClass ) . getDeclaredConstructor ( ConfigBag . class ) . newInstance ( config ) ;
    }
    catch ( Exception e ) {
      throw Exceptions . propagate ( e ) ;
    }
  }
  else {
    return new JcloudsMachineNamer ( config ) ;
  }
}


// Suggested Revision A
private CloudMachineNamer getCloudMachineNamer ( ConfigBag config ) {
  String namerClass = config . get ( LocationConfigKeys . CLOUD_MACHINE_NAMER_CLASS ) ;
  if ( namerClass != null ) {
    try {
      return ( CloudMachineNamer ) getManagementContext ( ) . getCatalog ( ) . getRootClassLoader ( ) . loadClass ( namerClass ) . getDeclaredConstructor ( ConfigBag . class ) . newInstance ( config ) ;
    }
    catch ( Exception e ) {
      throw Exceptions . propagate ( e ) ;
    }
  }
  else {
    return new JcloudsMachineNamer ( config ) ;
  }
}


// Suggested Revision B
private CloudMachineNamer getCloudMachineNamer ( ConfigBag config ) {
  String namerClass = config . get ( LocationConfigKeys . CLOUD_MACHINE_NAMER_CLASS ) ;
  if ( namerClass != null ) {
    try {
      return ( CloudMachineNamer ) getManagementContext ( ) . getCatalog ( ) . getRootClassLoader ( ) . loadClass ( namerClass ) . getDeclaredConstructor ( ConfigBag . class ) . newInstance ( config ) ;
    }
    catch ( Exception e ) {
      throw Exceptions . propagate ( e ) ;
    }
  }
  else {
    return new JcloudsMachineNamer ( getAllConfigBag ( ) ) ;
  }
}


==========================this is the dividing line=============================



/** Example 13 */

/** I would simplify to "return isValid(buf,off) && (buf[off] & X_BIT != 0) && (buf[off+1] & I_BIT) != 0)" */

// Manual revision
public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  return isValid ( buf , off , len ) && ( buf [ off ] & X_BIT ) != 0 && ( buf [ off + 1 ] & I_BIT ) != 0 ;
}


// Suggested Revision A
public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  if ( ! isValid ( buf , off ) ) return false ;
  return ( ( buf [ off ] & X_BIT != 0 ) && ( buf [ off + 1 ] & I_BIT ) != 0 ) ;
}


// Suggested Revision B
public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  return isValid ( buf , off ) && ( buf [ off ] & X_BIT ) && ( buf [ off + 1 ] & I_BIT ) ;
}


==========================this is the dividing line=============================



/** Example 14 */

/** Are you sure about that cast operation? You are asking for a service interface and cast it to a concrete implementation without instanceof check. You perform that check in the tracker that is only added to a SaveablesList. */

// Manual revision
public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  ISaveablesLifecycleListener saveables = getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  if ( saveables instanceof SaveablesList ) {
    ( ( SaveablesList ) saveables ) . removeModelLifecycleListener ( saveablesTracker ) ;
  }
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


// Suggested Revision A
public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  SaveablesList saveables = ( SaveablesList ) getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  saveables . removeModelLifecycleListener ( saveablesTracker ) ;
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


// Suggested Revision B
public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  SaveablesList saveables = getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  if ( saveables != null ) {
    saveables . removeModelLifecycleListener ( saveablesTracker ) ;
  }
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


==========================this is the dividing line=============================



/** Example 15 */

/** We use Java7, so you should use the try-with-resources feature. */

// Manual revision
protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  try ( Reader reader = new FileReader ( fileName ) ) {
    resultLineNumbers = grep ( reader , regexp , resultLines ) ;
  }
  catch ( IOException e ) {
    e . printStackTrace ( ) ;
  }
  return resultLineNumbers ;
}


// Suggested Revision A
protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  try ( Reader reader = new FileReader ( fileName ) ) {
    resultLineNumbers = grep ( reader , regexp , resultLines ) ;
  }
  catch ( IOException e ) {
    e . printStackTrace ( ) ;
  }
  return resultLineNumbers ;
}


// Suggested Revision B
protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  try ( Reader reader = new FileReader ( fileName ) ) {
    resultLineNumbers = grep ( reader , regexp , resultLines ) ;
  }
  catch ( IOException e ) {
    e . printStackTrace ( ) ;
  }
  finally {
    closeQuietly ( reader ) ;
  }
  return resultLineNumbers ;
}


==========================this is the dividing line=============================



/** Example 16 */

/** nit: Formatting */

// Manual revision
private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  final List < ActionParametersBase > setupNetworksParams = new ArrayList < > ( createNetworkClustersToSetupNetworksParametersTransformer ( ) . transform ( param . getAttachments ( ) , param . getDetachments ( ) , param . getUpdates ( ) ) ) ;
  HostSetupNetworksParametersBuilder . updateParametersSequencing ( setupNetworksParams ) ;
  setupNetworksParams . forEach ( this :: withRootCommandInfo ) ;
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams ) ;
}


// Suggested Revision A
private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams , getContext ( ) . getExecutionContext ( ) ) ;
}


// Suggested Revision B
private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  final List < ActionParametersBase > setupNetworksParams = new ArrayList < > ( createNetworkClustersToSetupNetworksParametersTransformer ( ) . transform ( param . getAttachments ( ) , param . getDetachments ( ) , param . getUpdates ( ) ) ) ;
  HostSetupNetworksParametersBuilder . updateParametersSequencing ( setupNetworksParams ) ;
  setupNetworksParams . forEach ( this :: withRootCommandInfo ) ;
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams , getContext ( ) . getExecutionContext ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 17 */

/** I don't understand the need of this test. We have the next one which tests serialization and deserialization if I am not wrong. Or does this tests something more than the next one ? */

// Manual revision
public void testDeserialization ( ) throws Exception {
  composedBlobIdAndDeserialize ( version ) ;
}


// Suggested Revision A
public void testDeserialization ( ) throws Exception {
  for ( Short version : versions ) {
    composedBlobIdAndDeserialize ( version ) ;
  }
}


// Suggested Revision B
private void testDeserialization ( ) throws Exception {
  for ( Short version : versions ) {
    composedBlobIdAndDeserialize ( version ) ;
  }
}


==========================this is the dividing line=============================



/** Example 18 */

/** Maybe `beanProp.getReadMethod().getAnnotationsByType(Optional.class).length > 0` should be checked before calling getField ? Method getField modifies field via reflection and optionally recursively calls itself, so it could be costly. */

// Manual revision
private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  if ( beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ) {
    return true ;
  }
  Field field = getField ( beanClass , beanProp . getName ( ) ) ;
  return field != null && field . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


// Suggested Revision A
private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  return beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


// Suggested Revision B
private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  Field field = getField ( beanClass , beanProp . getName ( ) ) ;
  return beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


==========================this is the dividing line=============================



/** Example 19 */

/** One of these two trace lines should be removed. */

// Manual revision
public JClogin ( ) {
  logger . trace ( "JClogin(constructor) called." ) ;
}


// Suggested Revision A
public JClogin ( ) {
}


// Suggested Revision B
public JClogin ( ) {
  logger . trace ( "JClogin(constructor) called." , constructor ) ;
}


==========================this is the dividing line=============================



