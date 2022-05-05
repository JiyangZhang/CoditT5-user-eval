/** Example 0 */

/** this isn't needed anymore right? */

public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException , KeeperException . NoNodeException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT , factory . isSecure ( ) ) ) ;
}


public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException , KeeperException . NoNodeException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT , factory . isSecure ( ) ) ) ;
}


public static void startServerInstance ( File dataDir , ServerCnxnFactory factory , String hostPort ) throws IOException , InterruptedException , KeeperException . NoNodeException {
  final int port = getPort ( hostPort ) ;
  LOG . info ( "STARTING server instance 127.0.0.1:{
}" , port ) ;
  ZooKeeperServer zks = new ZooKeeperServer ( dataDir , dataDir , 3000 ) ;
  factory . startup ( zks ) ;
  Assert . assertTrue ( "waiting for server up" , ClientBase . waitForServerUp ( "127.0.0.1:" + port , CONNECTION_TIMEOUT , factory . isSecure ( ) ) ) ;
}


*************************this is the dividing line*****************************



/** Example 1 */

/** [optional] maybe this method can be static and should be moved to end of the class */

String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


String encode ( String segment ) {
  return URL . encodeQueryString ( type . replacePathSeparator ( segment ) ) ;
}


*************************this is the dividing line*****************************



/** Example 2 */

/** Could you use `List#of` or `Collections#singletonList`? */

public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = Arrays . asList ( factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = Arrays . asList ( factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

public void whenTemplateWithGivenInputTemplate_String_shouldRenderBlobAsIt ( ) throws IOException {
  TemplateSourceDocument templateSrc = createTemplateSourceDoc ( "We are introducing ${
myStringInCtxt}
 !" , WEBVIEW_RENDITION ) ;
    TemplateBasedDocument templateBase = createTemplateBasedDoc ( templateSrc . getAdaptedDoc ( ) ) ;
    List < TemplateInput > params = Arrays . asList ( factory ( "myStringInCtxt" , StringValue , "Beautiful String" ) ) ;
    templateBase . saveParams ( TEMPLATE_NAME , params , true ) ;
    Blob result = templateBase . renderWithTemplate ( TEMPLATE_NAME ) ;
    assertNotNull ( result ) ;
    assertEquals ( "We are introducing Beautiful String !" , result . getString ( ) ) ;
  }
  

*************************this is the dividing line*****************************



/** Example 3 */

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



/** Example 4 */

/** I don't think the logic is necessary. We can have the default visibility as `GONE`. */

public void setUpCallToAction ( String callToActionText ) {
  if ( callToActionText == null ) {
    callToActionContainer . setVisibility ( GONE ) ;
  }
  else {
    callToActionContainer . setVisibility ( VISIBLE ) ;
    callToActionTextView . setText ( callToActionText ) ;
  }
}


public void setUpCallToAction ( String callToActionText ) {
  if ( callToActionText == null ) {
    callToActionContainer . setVisibility ( GONE ) ;
  }
  else {
    callToActionContainer . setVisibility ( VISIBLE ) ;
    callToActionTextView . setText ( callToActionText ) ;
  }
}


public void setUpCallToAction ( String callToActionText ) {
  if ( callToActionText == null ) {
    callToActionContainer . setVisibility ( GONE ) ;
  }
  else {
    callToActionContainer . setVisibility ( VISIBLE ) ;
    callToActionTextView . setText ( callToActionText ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 5 */

/** Should "planner.enable_hashagg" be set to **false** ?  "planner.enable_streamagg" defaults to **true** anyway. */

public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . optionSettingQueriesForTestQuery ( "alter session set `%s` = true" , PlannerSettings . STREAMAGG . getOptionName ( ) ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . baselineValues ( 177819 ) . build ( ) . run ( ) ;
}


public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . optionSettingQueriesForTestQuery ( "alter session set `%s` = true" , PlannerSettings . STREAMAGG . getOptionName ( ) ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . baselineValues ( 177819 ) . build ( ) . run ( ) ;
}


public void testMultipleBatchesLateral_WithStreamingAgg ( ) throws Exception {
  String sql = "SELECT t2.maxprice FROM (SELECT customer.c_orders AS c_orders FROM " + "dfs.`lateraljoin/multipleFiles/` customer) t1, LATERAL (SELECT CAST(MAX(t.ord.o_totalprice)" + " AS int) AS maxprice FROM UNNEST(t1.c_orders) t(ord) GROUP BY t.ord.o_orderstatus) t2" ;
  testBuilder ( ) . optionSettingQueriesForTestQuery ( "alter session set `%s` = true" , PlannerSettings . STREAMAGG . getOptionName ( ) ) . sqlQuery ( sql ) . unOrdered ( ) . baselineColumns ( "maxprice" ) . baselineValues ( 367190 ) . baselineValues ( 316347 ) . baselineValues ( 146610 ) . baselineValues ( 306996 ) . baselineValues ( 235695 ) . baselineValues ( 177819 ) . build ( ) . run ( ) ;
}


*************************this is the dividing line*****************************



/** Example 6 */

/** The last `null` is interpreted as a null `Flag`, not as a null `Flag[]`, and is causing some NPEs in the test suite: http://ci.infinispan.org/viewLog.html?buildId=6702&buildTypeId=bt9 */

public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null , null ) ;
}


public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null , null ) ;
}


public DecoratedCache ( AdvancedCache < K , V > delegate , ClassLoader classLoader ) {
  this ( delegate , classLoader , null , null ) ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** just for consistency, can we use `final int`? */

void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  int referencePosition = getDndListComponent ( ) . getPositionY ( elementReference ) ;
  getDndListComponent ( ) . setPositionY ( newElement , referencePosition ) ;
}


void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  int referencePosition = getDndListComponent ( ) . getPositionY ( elementReference ) ;
  getDndListComponent ( ) . setPositionY ( newElement , referencePosition ) ;
}


void setNewElementYPosition ( final Element elementReference , final Element newElement ) {
  int referencePosition = getDndListComponent ( ) . getPositionY ( elementReference ) ;
  getDndListComponent ( ) . setPositionY ( newElement , referencePosition ) ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** the second part of the OR is redundant: byte[].class != obj.getClass() */

public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( obj == null || byte [ ] . class != obj . getClass ( ) ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] byteArray = obj ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( byteArray , otherByteArray ) ;
}


public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( obj == null || byte [ ] . class != obj . getClass ( ) ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] byteArray = obj ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( byteArray , otherByteArray ) ;
}


public boolean equals ( byte [ ] obj , Object otherObj ) {
  if ( obj == otherObj ) return true ;
  if ( obj == null || byte [ ] . class != obj . getClass ( ) ) return false ;
  if ( otherObj == null || byte [ ] . class != otherObj . getClass ( ) ) return false ;
  byte [ ] byteArray = obj ;
  byte [ ] otherByteArray = ( byte [ ] ) otherObj ;
  return Arrays . equals ( byteArray , otherByteArray ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** Message needs changed. What does Retrofit do? Do we care if people overwrite this? I don't, and it breaks your `newBuilder()` desire. */

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


*************************this is the dividing line*****************************



/** Example 10 */

/** you don't need to do that if you're already calling `loadProperties` in the public constructor, right? https://github.com/caelum/vraptor4/pull/973/files#diff-b7b62c45c7478eb642acfb81c12a4227R82 */

private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  DefaultEnvironment defaultEnvironment = new DefaultEnvironment ( environmentType ) ;
  defaultEnvironment . setup ( ) ;
  return defaultEnvironment ;
}


private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  DefaultEnvironment defaultEnvironment = new DefaultEnvironment ( environmentType ) ;
  defaultEnvironment . setup ( ) ;
  return defaultEnvironment ;
}


private DefaultEnvironment buildEnvironment ( EnvironmentType environmentType ) {
  DefaultEnvironment defaultEnvironment = new DefaultEnvironment ( environmentType ) ;
  defaultEnvironment . setup ( ) ;
  return defaultEnvironment ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** macToLong returns 'long' */

private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    Long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( count . intValue ( ) ) ;
  }
}


private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    Long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( count . intValue ( ) ) ;
  }
}


private void recalculateMacsCount ( ) {
  if ( ! validate ( ) ) {
    setAvailableMacsCount ( - 1 ) ;
    return ;
  }
  if ( macRange . getMacPoolId ( ) == null ) {
    String from = getLeftBound ( ) . getEntity ( ) ;
    String to = getRightBound ( ) . getEntity ( ) ;
    Long count = MacRangeValidation . macToLong ( to ) - MacRangeValidation . macToLong ( from ) + 1 ;
    setAvailableMacsCount ( count . intValue ( ) ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 12 */

/** This shouldn't call `getAllConfigBag()`. It should use the `config` passed in, otherwise we lose the local values passed in to the obtain() method. Do you agree? */

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


*************************this is the dividing line*****************************



/** Example 13 */

/** I would simplify to "return isValid(buf,off) && (buf[off] & X_BIT != 0) && (buf[off+1] & I_BIT) != 0)" */

public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  if ( ! isValid ( buf , off ) ) return false ;
  if ( ( buf [ off ] & X_BIT ) == 0 || ( buf [ off + 1 ] & I_BIT ) == 0 ) return false ;
  return true ;
}


public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  if ( ! isValid ( buf , off ) ) return false ;
  if ( ( buf [ off ] & X_BIT ) == 0 || ( buf [ off + 1 ] & I_BIT ) == 0 ) return false ;
  return true ;
}


public static boolean hasPictureId ( byte [ ] buf , int off , int len ) {
  if ( ! isValid ( buf , off ) ) return false ;
  if ( ( buf [ off ] & X_BIT ) == 0 || ( buf [ off + 1 ] & I_BIT ) == 0 ) return false ;
  return true ;
}


*************************this is the dividing line*****************************



/** Example 14 */

/** Are you sure about that cast operation? You are asking for a service interface and cast it to a concrete implementation without instanceof check. You perform that check in the tracker that is only added to a SaveablesList. */

public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  SaveablesList saveables = ( SaveablesList ) getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  if ( saveables != null ) {
    saveables . removeModelLifecycleListener ( saveablesTracker ) ;
  }
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  SaveablesList saveables = ( SaveablesList ) getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  if ( saveables != null ) {
    saveables . removeModelLifecycleListener ( saveablesTracker ) ;
  }
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


public void dispose ( ) {
  super . dispose ( ) ;
  getSite ( ) . getPage ( ) . removePostSelectionListener ( this ) ;
  RegistryFactory . getRegistry ( ) . removeListener ( this ) ;
  SaveablesList saveables = ( SaveablesList ) getSite ( ) . getService ( ISaveablesLifecycleListener . class ) ;
  if ( saveables != null ) {
    saveables . removeModelLifecycleListener ( saveablesTracker ) ;
  }
  currentPart = null ;
  currentSelection = null ;
  pinPropertySheetAction = null ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** We use Java7, so you should use the try-with-resources feature. */

protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  Reader reader = null ;
  try {
    reader = new FileReader ( fileName ) ;
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


protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  Reader reader = null ;
  try {
    reader = new FileReader ( fileName ) ;
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


protected static List < Integer > grep ( File fileName , String regexp , List < String > resultLines ) {
  List < Integer > resultLineNumbers = new ArrayList < > ( ) ;
  Reader reader = null ;
  try {
    reader = new FileReader ( fileName ) ;
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


*************************this is the dividing line*****************************



/** Example 16 */

/** nit: Formatting */

private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  final List < ActionParametersBase > setupNetworksParams = new ArrayList < > ( createNetworkClustersToSetupNetworksParametersTransformer ( ) . transform ( param . getAttachments ( ) , param . getDetachments ( ) , param . getUpdates ( ) ) ) ;
  HostSetupNetworksParametersBuilder . updateParametersSequencing ( setupNetworksParams ) ;
  setupNetworksParams . forEach ( this :: withRootCommandInfo ) ;
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams , getContext ( ) . getExecutionContext ( ) ) ;
}


private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  final List < ActionParametersBase > setupNetworksParams = new ArrayList < > ( createNetworkClustersToSetupNetworksParametersTransformer ( ) . transform ( param . getAttachments ( ) , param . getDetachments ( ) , param . getUpdates ( ) ) ) ;
  HostSetupNetworksParametersBuilder . updateParametersSequencing ( setupNetworksParams ) ;
  setupNetworksParams . forEach ( this :: withRootCommandInfo ) ;
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams , getContext ( ) . getExecutionContext ( ) ) ;
}


private void processSingleClusterChanges ( ManageNetworkClustersParameters param ) {
  final List < ActionParametersBase > setupNetworksParams = new ArrayList < > ( createNetworkClustersToSetupNetworksParametersTransformer ( ) . transform ( param . getAttachments ( ) , param . getDetachments ( ) , param . getUpdates ( ) ) ) ;
  HostSetupNetworksParametersBuilder . updateParametersSequencing ( setupNetworksParams ) ;
  setupNetworksParams . forEach ( this :: withRootCommandInfo ) ;
  runInternalMultipleActions ( ActionType . PersistentHostSetupNetworks , setupNetworksParams , getContext ( ) . getExecutionContext ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** I don't understand the need of this test. We have the next one which tests serialization and deserialization if I am not wrong. Or does this tests something more than the next one ? */

public void testDeserialization ( ) throws Exception {
  for ( Short version : versions ) {
    composedBlobIdAndDeserialize ( version ) ;
  }
}


public void testDeserialization ( ) throws Exception {
  for ( Short version : versions ) {
    composedBlobIdAndDeserialize ( version ) ;
  }
}


public void testDeserialization ( ) throws Exception {
  for ( Short version : versions ) {
    composedBlobIdAndDeserialize ( version ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 18 */

/** Maybe `beanProp.getReadMethod().getAnnotationsByType(Optional.class).length > 0` should be checked before calling getField ? Method getField modifies field via reflection and optionally recursively calls itself, so it could be costly. */

private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  Field field = getField ( beanClass , beanProp . getName ( ) ) ;
  return field != null ? field . getAnnotationsByType ( Optional . class ) . length > 0 || beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 : beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  Field field = getField ( beanClass , beanProp . getName ( ) ) ;
  return field != null ? field . getAnnotationsByType ( Optional . class ) . length > 0 || beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 : beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


private static boolean isOptionalProperty ( Class beanClass , PropertyDescriptor beanProp ) {
  Field field = getField ( beanClass , beanProp . getName ( ) ) ;
  return field != null ? field . getAnnotationsByType ( Optional . class ) . length > 0 || beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 : beanProp . getReadMethod ( ) . getAnnotationsByType ( Optional . class ) . length > 0 ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** One of these two trace lines should be removed. */

public JClogin ( ) {
  logger . trace ( "JClogin(constructor) called." ) ;
  logger . trace ( "JClogin(this={
}
) called." , this ) ;
}


public JClogin ( ) {
  logger . trace ( "JClogin(constructor) called." ) ;
  logger . trace ( "JClogin(this={
}
) called." , this ) ;
}


public JClogin ( ) {
  logger . trace ( "JClogin(constructor) called." ) ;
  logger . trace ( "JClogin(this={
}
) called." , this ) ;
}


*************************this is the dividing line*****************************



