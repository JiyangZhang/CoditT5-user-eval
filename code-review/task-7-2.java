/** Example 0 */

/** Let's avoid `null` and rework to empty string */

// Manual revision
public Optional < String > getLinkAt ( int offset ) {
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . contains ( offset ) ) {
      return Optional . of ( hrefs . get ( i ) ) ;
    }
  }
  return Optional . empty ( ) ;
}


// Suggested Revision A
public String getLinkAt ( int offset ) {
  if ( offset < 0 ) {
    return "" ;
  }
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . isOffsetInRange ( offset ) ) {
      return hrefs . get ( i ) ;
    }
  }
  return "" ;
}


// Suggested Revision B
public String getLinkAt ( int offset ) {
  for ( int i = 0 ;
  i < linkRanges . size ( ) ;
  i ++ ) {
    if ( linkRanges . get ( i ) . isOffsetInRange ( offset ) ) {
      return hrefs . get ( i ) ;
    }
  }
  return "" ;
}


==========================this is the dividing line=============================



/** Example 1 */

/** Could we merge RESTORING and SUSPENDED? */

// Manual revision
private void maybeScheduleCheckpoint ( ) {
  switch ( state ( ) ) {
    case RESTORING : case SUSPENDED : this . checkpoint = checkpointableOffsets ( ) ;
    break ;
    case RUNNING : if ( ! eosEnabled ) {
      this . checkpoint = checkpointableOffsets ( ) ;
    }
    break ;
    case CREATED : case CLOSED : throw new IllegalStateException ( "Illegal state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
    default : throw new IllegalStateException ( "Unknown state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
  }
}


// Suggested Revision A
private void maybeScheduleCheckpoint ( ) {
  switch ( state ( ) ) {
    case SUSPENDED : this . checkpoint = checkpointableOffsets ( ) ;
    break ;
    case RUNNING : if ( ! eosEnabled ) {
      this . checkpoint = checkpointableOffsets ( ) ;
    }
    break ;
    case CREATED : case CLOSED : throw new IllegalStateException ( "Illegal state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
    default : throw new IllegalStateException ( "Unknown state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
  }
}


// Suggested Revision B
private void maybeScheduleCheckpoint ( ) {
  switch ( state ( ) ) {
    case RESTORING : this . checkpoint = checkpointableOffsets ( ) ;
    break ;
    case RUNNING : if ( ! eosEnabled ) {
      this . checkpoint = checkpointableOffsets ( ) ;
    }
    break ;
    case CREATED : case CLOSED : throw new IllegalStateException ( "Illegal state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
    default : throw new IllegalStateException ( "Unknown state " + state ( ) + " while scheduling checkpoint for active task " + id ) ;
  }
}


==========================this is the dividing line=============================



/** Example 2 */

/** Edge case of duplicate code ;) It could be extracted to a common private method with two params for id and type. Up to you if you want to change it or not ;) */

// Manual revision
public List < Document > getClientDocuments ( String clientId ) throws MambuApiException {
  if ( clientId == null || clientId . trim ( ) . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "ClientId ID must not be null or empty" ) ;
  }
  return new DocumentsService ( mambuAPIService ) . getDocuments ( CLIENTS , clientId ) ;
}


// Suggested Revision A
private List < Document > getClientDocuments ( String clientId ) throws MambuApiException {
  if ( clientId == null || clientId . trim ( ) . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "ClientId ID must not be null or empty" ) ;
  }
  return DocumentsService . getDocuments ( mambuAPIService , CLIENTS , clientId ) ;
}


// Suggested Revision B
public List < Document > getClientDocuments ( String clientId ) throws MambuApiException {
  if ( clientId == null || clientId . trim ( ) . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "ClientId ID must not be null or empty" ) ;
  }
  return DocumentsService . getDocuments ( mambuAPIService , CLIENTS , clientId ) ;
}


==========================this is the dividing line=============================



/** Example 3 */

/** Rollback should be done after each test case (i.e., with an @After notation, not an @AfterClass notataion), and I think we should preserve the current behavior od tearDownTestCase().  I suggest creating a new tearDown() method for performing the rollback. */

// Manual revision
public static void tearDownTestCase ( ) throws Exception {
}


// Suggested Revision A
public static void tearDownTestCase ( ) throws Exception {
}


// Suggested Revision B
public static void tearDownTestCase ( ) throws Exception {
  if ( dataSource != null ) {
    Connection con = dataSource . getConnection ( ) ;
    if ( con != null ) {
      con . rollback ( ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 4 */

/** I would use a couple of assert equals since they give better output in case of failure.  (Remember that the expected value should be the first one) */

// Manual revision
private void testUpdateInterface ( Guid interface_id ) {
  VdsNetworkInterface iface = dao . get ( interface_id ) ;
  iface . setName ( iface . getName ( ) . toUpperCase ( ) ) ;
  iface . setQos ( newQos ) ;
  dao . updateInterfaceForVds ( iface ) ;
  VdsNetworkInterface ifaced = dao . get ( interface_id ) ;
  assertEquals ( iface . getName ( ) , ifaced . getName ( ) ) ;
  assertEquals ( iface . getQos ( ) , ifaced . getQos ( ) ) ;
}


// Suggested Revision A
private void testUpdateInterface ( Guid interface_id ) {
  VdsNetworkInterface iface = dao . get ( interface_id ) ;
  iface . setName ( iface . getName ( ) . toUpperCase ( ) ) ;
  iface . setQos ( newQos ) ;
  dao . updateInterfaceForVds ( iface ) ;
  VdsNetworkInterface ifaced = dao . get ( interface_id ) ;
  assertEquals ( ifaced . getName ( ) , iface . getName ( ) ) && ifaced . getQos ( ) . equals ( iface . getQos ( ) ) ;
}


// Suggested Revision B
private void testUpdateInterface ( Guid interface_id ) {
  VdsNetworkInterface iface = dao . get ( interface_id ) ;
  iface . setName ( iface . getName ( ) . toUpperCase ( ) ) ;
  iface . setQos ( newQos ) ;
  dao . updateInterfaceForVds ( iface ) ;
  VdsNetworkInterface ifaced = dao . get ( interface_id ) ;
  assertEquals ( ifaced . getName ( ) , iface . getName ( ) ) ;
  assertEquals ( ifaced . getQos ( ) , iface . getQos ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 5 */

/** It seems this could be changed to `return !command.hasFlag(Flag.SKIP_REMOTE_LOOKUP))` */

// Manual revision
protected boolean writeNeedsRemoteValue ( InvocationContext ctx , WriteCommand command , Object key ) {
  if ( command . hasFlag ( Flag . CACHE_MODE_LOCAL ) ) {
    return false ;
  }
  if ( ctx . isOriginLocal ( ) ) {
    if ( ! command . readsExistingValues ( ) ) {
      return false ;
    }
    return ! command . hasFlag ( Flag . SKIP_REMOTE_LOOKUP ) ;
  }
  else {
    return command . alwaysReadsExistingValues ( ) ;
  }
}


// Suggested Revision A
protected boolean writeNeedsRemoteValue ( InvocationContext ctx , WriteCommand command , Object key ) {
  if ( command . hasFlag ( Flag . CACHE_MODE_LOCAL ) ) {
    return false ;
  }
  if ( ctx . isOriginLocal ( ) ) {
    return ! command . readsExistingValues ( ) ;
  }
  else {
    return ! command . alwaysReadsExistingValues ( ) ;
  }
}


// Suggested Revision B
protected boolean writeNeedsRemoteValue ( InvocationContext ctx , WriteCommand command , Object key ) {
  if ( command . hasFlag ( Flag . CACHE_MODE_LOCAL ) ) {
    return false ;
  }
  if ( ctx . isOriginLocal ( ) ) {
    return ! readsExistingValues ( ) ;
  }
  return ! alwaysReadsExistingValues ( ) ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** Declare the logger at the top of the class: ```java private static final Logger log = Logger.get(GlueHiveMetastore.class); ``` (you might see the inline `Logger.get()` pattern in some tests, but it's not the normal way) */

// Manual revision
private static void deleteDir ( HdfsContext context , HdfsEnvironment hdfsEnvironment , Path path , boolean recursive ) {
  try {
    hdfsEnvironment . getFileSystem ( context , path ) . delete ( path , recursive ) ;
  }
  catch ( Exception e ) {
    log . warn ( e , "Failed to delete path: " + path . toString ( ) ) ;
  }
}


// Suggested Revision A
private static void deleteDir ( HdfsContext context , HdfsEnvironment hdfsEnvironment , Path path , boolean recursive ) {
  try {
    hdfsEnvironment . getFileSystem ( context , path ) . delete ( path , recursive ) ;
  }
  catch ( Exception e ) {
    final Logger log = Logger . get ( GlueHiveMetastore . class ) ;
    Logger . get ( GlueHiveMetastore . class ) . warn ( e , "Failed to delete path: " + path . toString ( ) ) ;
  }
}


// Suggested Revision B
private static void deleteDir ( HdfsContext context , HdfsEnvironment hdfsEnvironment , Path path , boolean recursive ) {
  try {
    hdfsEnvironment . getFileSystem ( context , path ) . delete ( path , recursive ) ;
  }
  catch ( Exception e ) {
    log . warn ( e , "Failed to delete path: " + path . toString ( ) ) ;
  }
}


==========================this is the dividing line=============================



/** Example 7 */

/** I think I saw multiple ppc types in the enum: ppc, ppc64, ppcle, ppc64le */

// Manual revision
private boolean clusterHasPpcArchitecture ( ) {
  Cluster cluster = getModel ( ) . getSelectedCluster ( ) ;
  return cluster != null && cluster . getArchitecture ( ) != null && ArchitectureType . ppc == cluster . getArchitecture ( ) . getFamily ( ) ;
}


// Suggested Revision A
private boolean clusterHasPpcArchitecture ( ) {
  Cluster cluster = getModel ( ) . getSelectedCluster ( ) ;
  return cluster != null && cluster . getArchitecture ( ) != null && ArchitectureType . ppc . getFamily ( ) == cluster . getArchitecture ( ) . getFamily ( ) ;
}


// Suggested Revision B
private boolean clusterHasPpcArchitecture ( ) {
  Cluster cluster = getModel ( ) . getSelectedCluster ( ) ;
  return cluster != null && cluster . getArchitecture ( ) != null && cluster . getArchitecture ( ) . getFamily ( ) == cluster . getArchitecture ( ) . getFamily ( ) ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** Shouldn't this line be something like AssertTrue(allergy.hasSameValues(allergy())); ? */

// Manual revision
public void hasSameValues_checkingAgainstSameInstanceOfAllergy_shouldInterpretAsSameValues ( ) {
  Allergy allergy = allergy ( ) ;
  assertThat ( allergy . hasSameValues ( allergy ( ) ) , is ( true ) ) ;
}


// Suggested Revision A
public void hasSameValues_checkingAgainstSameInstanceOfAllergy_shouldInterpretAsSameValues ( ) {
  Allergy allergy = allergy ( ) ;
  allergy . hasSameValues ( allergy ( ) ) ;
}


// Suggested Revision B
public void hasSameValues_checkingAgainstSameInstanceOfAllergy_shouldInterpretAsSameValues ( ) {
  AssertTrue ( allergy ( ) . hasSameValues ( allergy ( ) ) ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** same as above. we shouldn't be throwing run-time exceptions when close is called. */

// Manual revision
public void close ( ) {
  try {
    Await . result ( beam . close ( ) ) ;
  }
  catch ( Exception e ) {
    LOG . error ( "Error while closing Druid beam client" , e ) ;
  }
}


// Suggested Revision A
public void close ( ) {
  try {
    Await . result ( beam . close ( ) ) ;
  }
  catch ( Exception e ) {
    final String errorMsg = "Error while closing Druid beam client" ;
    LOG . error ( errorMsg , e ) ;
    throw new RuntimeException ( errorMsg ) ;
  }
}


// Suggested Revision B
public void close ( ) {
  Await . result ( beam . close ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 10 */

/** If we're all agreed on letting users choose system protocols in the browser, then I suppose we should not have this condition. */

// Manual revision
public boolean isValidValue ( final Object element ) {
  boolean result = super . isValidValue ( element ) ;
  if ( result ) {
    EObject eObject = EMFHelper . getEObject ( element ) ;
    result = ( ProtocolUtils . isProtocol ( eObject ) && ! SystemElementsUtils . isBaseProtocol ( ( Collaboration ) eObject ) ) ;
  }
  return result ;
}


// Suggested Revision A
public boolean isValidValue ( final Object element ) {
  boolean result = super . isValidValue ( element ) ;
  if ( result ) {
    EObject eObject = EMFHelper . getEObject ( element ) ;
    result = ( ! SystemElementsUtils . isSystemProtocol ( ( Collaboration ) eObject ) && ! SystemElementsUtils . isBaseProtocol ( ( Collaboration ) eObject ) ) ;
  }
  return result ;
}


// Suggested Revision B
public boolean isValidValue ( final Object element ) {
  boolean result = super . isValidValue ( element ) ;
  if ( result ) {
    EObject eObject = EMFHelper . getEObject ( element ) ;
    result = ! ProtocolUtils . isProtocol ( eObject ) && ! SystemElementsUtils . isSystemProtocol ( ( Collaboration ) eObject ) && ! SystemElementsUtils . isBaseProtocol ( ( Collaboration ) eObject ) ;
  }
  return result ;
}


==========================this is the dividing line=============================



/** Example 11 */

/** I wouldn't implement this (just return null). A long has a fixed size, and we can use putLong() in HTInterval to write them to the file.  This method was more for string, structs, etc. that we want to serialize. */

// Manual revision
public byte [ ] toByteArray ( ) {
  return null ;
}


// Suggested Revision A
public byte [ ] toByteArray ( ) {
  return null ;
}


// Suggested Revision B
public byte [ ] toByteArray ( ) {
  return ByteBuffer . allocate ( 8 ) . putLong ( valueLong ) . array ( ) ;
}


==========================this is the dividing line=============================



/** Example 12 */

/** why not calling isAppConfiguredInSourceServerXml(fileName) to make sure the app installed to the dropins location is not configured? */

// Manual revision
private void validateAppConfig ( String fileName ) throws Exception {
  String appsDir = getAppsDirectory ( ) ;
  if ( appsDir . equalsIgnoreCase ( "apps" ) && ! isAppConfiguredInSourceServerXml ( fileName ) ) {
    applicationXml . createWebApplicationElement ( fileName ) ;
  }
  else if ( appsDir . equalsIgnoreCase ( "dropins" ) && isAppConfiguredInSourceServerXml ( fileName ) ) throw new MojoExecutionException ( messages . getString ( "error.install.app.dropins.directory" ) ) ;
}


// Suggested Revision A
private void validateAppConfig ( String fileName ) throws Exception {
  String appsDir = getAppsDirectory ( ) ;
  if ( appsDir . equalsIgnoreCase ( "apps" ) ) {
    applicationXml . createWebApplicationElement ( fileName ) ;
  }
  else if ( appsDir . equalsIgnoreCase ( "dropins" ) && isAnyAppConfiguredInSourceServerXml ( ) ) throw new MojoExecutionException ( messages . getString ( "error.install.app.dropins.directory" ) ) ;
}


// Suggested Revision B
private void validateAppConfig ( String fileName ) throws Exception {
  String appsDir = getAppsDirectory ( ) ;
  if ( appsDir . equalsIgnoreCase ( "apps" ) && isAnyAppConfiguredInSourceServerXml ( ) ) {
    applicationXml . createWebApplicationElement ( fileName ) ;
  }
  else if ( appsDir . equalsIgnoreCase ( "dropins" ) && isAppConfiguredInSourceServerXml ( fileName ) ) {
    throw new MojoExecutionException ( messages . getString ( "error.install.app.dropins.directory" ) ) ;
  }
}


==========================this is the dividing line=============================



/** Example 13 */

/** I'd just assert that it contains the created VM. */

// Manual revision
public void testList ( ) {
  List < VirtualMachine > list = api ( ) . list ( ) ;
  VirtualMachine vm = api ( ) . get ( getName ( ) ) ;
  assertTrue ( list . contains ( vm ) ) ;
}


// Suggested Revision A
public void testList ( ) {
  List < VirtualMachine > list = api ( ) . list ( ) ;
  for ( VirtualMachine machine : list ) {
    assertTrue ( ! machine . name ( ) . isEmpty ( ) ) ;
  }
}


// Suggested Revision B
public void testList ( ) {
  List < VirtualMachine > list = api ( ) . list ( ) ;
}


==========================this is the dividing line=============================



/** Example 14 */

/** These two logs could be `Logger.v()`. That's all, good to go! */

// Manual revision
public synchronized boolean isLastMQNotifLongAgo ( ) {
  long delay = 18 * 3600 ;
  long threshold = sharedPreferences . getLong ( getCurrentModeName ( ) + LAST_MORNING_Q_TIMESTAMP , - delay ) + delay ;
  if ( threshold < Calendar . getInstance ( ) . getTimeInMillis ( ) ) {
    Logger . v ( TAG , "{}
 - Last MQ notif was yesterday" , getCurrentModeName ( ) ) ;
    return true ;
  }
  else {
    Logger . v ( TAG , "{}
 - Last MQ notif was recent, do not notify" , getCurrentModeName ( ) ) ;
    return false ;
  }
}


// Suggested Revision A
public synchronized boolean isLastMQNotifLongAgo ( ) {
  long delay = 18 * 3600 ;
  long threshold = sharedPreferences . getLong ( getCurrentModeName ( ) + LAST_MORNING_Q_TIMESTAMP , - delay ) + delay ;
  if ( threshold < Calendar . getInstance ( ) . getTimeInMillis ( ) ) {
    Logger . v ( TAG , "{}
 - Last MQ notif was yesterday" , getCurrentModeName ( ) ) ;
    return true ;
  }
  else {
    Logger . v ( TAG , "{}
 - Last MQ notif was recent, do not notify" , getCurrentModeName ( ) ) ;
    return false ;
  }
}


// Suggested Revision B
public synchronized boolean isLastMQNotifLongAgo ( ) {
  long delay = 18 * 3600 ;
  long threshold = sharedPreferences . getLong ( getCurrentModeName ( ) + LAST_MORNING_Q_TIMESTAMP , - delay ) + delay ;
  if ( threshold < Calendar . getInstance ( ) . getTimeInMillis ( ) ) {
    Logger . v ( TAG , "{}
 - Last MQ notif was yesterday" , getCurrentModeName ( ) ) ;
    return true ;
  }
  else {
    Logger . d ( TAG , "{}
 - Last MQ notif was recent, do not notify" , getCurrentModeName ( ) ) ;
    return false ;
  }
}


==========================this is the dividing line=============================



/** Example 15 */

/** these fields are already set by AOP in RetireSaveHandler and this needs to delegate to saveOrderType instead of calling the DAO just in case there is extra logic in the save method we don't want to by pass */

// Manual revision
public OrderType retireOrderType ( OrderType orderType , String reason ) {
  orderType . setRetired ( true ) ;
  orderType . setRetireReason ( reason ) ;
  return saveOrderType ( orderType ) ;
}


// Suggested Revision A
public OrderType retireOrderType ( OrderType orderType , String reason ) {
  orderType . setRetired ( true ) ;
  orderType . setRetireReason ( reason ) ;
  return saveOrderType ( orderType ) ;
}


// Suggested Revision B
public OrderType retireOrderType ( OrderType orderType , String reason ) {
  return saveOrderType ( orderType ) ;
}


==========================this is the dividing line=============================



/** Example 16 */

/** You can change the 28 case to a default case, and remove this. */

// Manual revision
public static int mapApiToArtVersion ( int api ) {
  if ( api < 19 ) {
    return NO_VERSION ;
  }
  switch ( api ) {
    case 19 : case 20 : return 7 ;
    case 21 : return 39 ;
    case 22 : return 45 ;
    case 23 : return 64 ;
    case 24 : case 25 : return 79 ;
    case 26 : return 124 ;
    case 27 : return 131 ;
    default : return 144 ;
  }
}


// Suggested Revision A
public static int mapApiToArtVersion ( int api ) {
  if ( api < 19 ) {
    return NO_VERSION ;
  }
  switch ( api ) {
    case 19 : case 20 : return 7 ;
    case 21 : return 39 ;
    case 22 : return 45 ;
    case 23 : return 64 ;
    case 24 : case 25 : return 79 ;
    case 26 : return 124 ;
    case 27 : return 131 ;
    default : return 144 ;
  }
  return 143 ;
}


// Suggested Revision B
public static int mapApiToArtVersion ( int api ) {
  if ( api < 19 ) {
    return NO_VERSION ;
  }
  switch ( api ) {
    case 19 : case 20 : return 7 ;
    case 21 : return 39 ;
    case 22 : return 45 ;
    case 23 : return 64 ;
    case 24 : case 25 : return 79 ;
    case 26 : return 124 ;
    case 27 : return 131 ;
  }
  return 143 ;
}


==========================this is the dividing line=============================



/** Example 17 */

/** I think that it is ok, although I am not sure how I feel about including the "\n". */

// Manual revision
private String extractDefinitionLine ( String typeDeclaration ) {
  String typeLine = "" ;
  String [ ] lines = typeDeclaration . split ( "\n" ) ;
  for ( String line : lines ) {
    typeLine = line ;
    if ( line . contains ( "{" ) ) {
      break ;
    }
  }
  return typeLine ;
}


// Suggested Revision A
private String extractDefinitionLine ( String typeDeclaration ) {
  String typeLine = "" ;
  String [ ] lines = typeDeclaration . split ( "\n" ) ;
  for ( String line : lines ) {
    typeLine = typeLine + "\n" + line ;
    if ( line . contains ( "{" ) ) {
      break ;
    }
  }
}
return typeLine ;
}


// Suggested Revision B
private String extractDefinitionLine ( String typeDeclaration ) {
  String typeLine = "" ;
  String [ ] lines = typeDeclaration . split ( "\n" ) ;
  for ( String line : lines ) {
    typeLine = typeLine + "\n" + line ;
    if ( line . contains ( "{" ) ) {
      break ;
    }
  }
  return typeLine ;
}


==========================this is the dividing line=============================



/** Example 18 */

/** We can slightly simplify: ```java return result != null && Objects.equals(CommandResult.Type.ERROR, result.getType()); ``` */

// Manual revision
public boolean hasError ( ) {
  return result != null && CommandResult . Type . ERROR . equals ( result . getType ( ) ) ;
}


// Suggested Revision A
public boolean hasError ( ) {
  return result != null && Objects . equals ( result . getType ( ) , CommandResult . Type . ERROR ) ;
}


// Suggested Revision B
public boolean hasError ( ) {
  return result != null && Objects . equals ( CommandResult . Type . ERROR , result . getType ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 19 */

/** Technically, you should `queryRunner.close()` (or t-w-r). This would ensure proper cleanup of any temp files (or whatevers) it might have created */

// Manual revision
public static void main ( String [ ] args ) {
  LocalQueryRunner queryRunner = createLocalQueryRunner ( ImmutableMap . of ( "reorder_joins" , "false" ) ) ;
  new SqlConsecutiveJoinBenchmark ( queryRunner ) . runBenchmark ( new SimpleLineBenchmarkResultWriter ( System . out ) ) ;
  queryRunner . close ( ) ;
}


// Suggested Revision A
public static void main ( String [ ] args ) {
  LocalQueryRunner queryRunner = createLocalQueryRunner ( ImmutableMap . of ( "reorder_joins" , "false" ) ) ;
  new SqlConsecutiveJoinBenchmark ( queryRunner ) . runBenchmark ( new SimpleLineBenchmarkResultWriter ( System . out ) ) ;
}


// Suggested Revision B
public static void main ( String [ ] args ) {
  try ( LocalQueryRunner queryRunner = createLocalQueryRunner ( ImmutableMap . of ( "reorder_joins" , "false" ) ) ) {
    new SqlConsecutiveJoinBenchmark ( queryRunner ) . runBenchmark ( new SimpleLineBenchmarkResultWriter ( System . out ) ) ;
  }
}


==========================this is the dividing line=============================



