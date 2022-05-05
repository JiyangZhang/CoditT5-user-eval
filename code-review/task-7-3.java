/** Example 0 */

/** if repository is null, this will throw an NPE. */

// Manual revision
boolean isProjectStyle ( ) {
  if ( myIsFrameworkStyle ) {
    return false ;
  }
  ProjectResourceRepository repository = ProjectResourceRepository . getProjectResources ( myConfiguration . getModule ( ) , true ) ;
  assert repository != null : myConfiguration . getModule ( ) . getName ( ) ;
  return repository . hasResourceItem ( ResourceType . STYLE , myStyleName ) ;
}


// Suggested Revision A
boolean isProjectStyle ( ) {
  if ( myIsFrameworkStyle ) {
    return false ;
  }
  ProjectResourceRepository repository = ProjectResourceRepository . getProjectResources ( myConfiguration . getModule ( ) , true ) ;
  assert repository != null : repository . getDisplayName ( ) ;
  return repository . hasResourceItem ( ResourceType . STYLE , myStyleName ) ;
}


// Suggested Revision B
boolean isProjectStyle ( ) {
  if ( myIsFrameworkStyle ) {
    return false ;
  }
  ProjectResourceRepository repository = ProjectResourceRepository . getProjectResources ( myConfiguration . getModule ( ) , true ) ;
  return repository . hasResourceItem ( ResourceType . STYLE , myStyleName ) ;
}


==========================this is the dividing line=============================



/** Example 1 */

/** Should this be done in `OutputCommitter#setupTask` instead of here? This method could be called more than once, but we want to ensure we set up the environment config just one time per task. The `setupTask` methods seems like a good place, unless you have a reason to do it here? */

// Manual revision
private static < E > View < E > load ( JobContext jobContext ) {
  Configuration conf = Hadoop . JobContext . getConfiguration . invoke ( jobContext ) ;
  Class < E > type = getType ( jobContext ) ;
  String outputUri = conf . get ( KITE_OUTPUT_URI ) ;
  return Datasets . < E , View < E >> load ( outputUri , type ) ;
}


// Suggested Revision A
private static < E > View < E > load ( JobContext jobContext ) {
  Configuration conf = Hadoop . JobContext . getConfiguration . invoke ( jobContext ) ;
  Class < E > type = getType ( jobContext ) ;
  String outputUri = conf . get ( KITE_OUTPUT_URI ) ;
  DefaultConfiguration . set ( conf ) ;
  return Datasets . < E , View < E >> load ( outputUri , type ) ;
}


// Suggested Revision B
private static < E > View < E > load ( JobContext jobContext ) {
  Configuration conf = Hadoop . JobContext . getConfiguration . invoke ( jobContext ) ;
  Class < E > type = getType ( jobContext ) ;
  String outputUri = conf . get ( KITE_OUTPUT_URI ) ;
  return Datasets . < E , View < E >> load ( outputUri , type ) ;
}


==========================this is the dividing line=============================



/** Example 2 */

/** redundant */

// Manual revision
ShardRewriter createShardRewriter ( FileSystemContext fileSystemContext , FileSystem fileSystem , long transactionId , OptionalInt bucketNumber , UUID shardUuid , int shardRowCount , Optional < UUID > deltaShardUuid , boolean tableSupportsDeltaDelete , Map < String , Type > columns ) {
  if ( tableSupportsDeltaDelete ) {
    return new DeltaShardRewriter ( shardUuid , shardRowCount , deltaShardUuid , deletionExecutor , transactionId , bucketNumber , this , fileSystemContext , fileSystem ) ;
  }
  return new InplaceShardRewriter ( shardUuid , columns , deletionExecutor , transactionId , bucketNumber , nodeId , this , fileSystem , storageService , shardRecorder , backupManager ) ;
}


// Suggested Revision A
ShardRewriter createShardRewriter ( FileSystemContext fileSystemContext , FileSystem fileSystem , long transactionId , OptionalInt bucketNumber , UUID shardUuid , int shardRowCount , Optional < UUID > deltaShardUuid , boolean tableSupportsDeltaDelete , Map < String , Type > columns ) {
  if ( tableSupportsDeltaDelete ) {
    return new DeltaShardRewriter ( shardUuid , shardRowCount , deltaShardUuid , deletionExecutor , transactionId , bucketNumber , this , fileSystemContext , fileSystem ) ;
  }
  else {
    return new InplaceShardRewriter ( shardUuid , columns , deletionExecutor , transactionId , bucketNumber , nodeId , this , fileSystem , fileSystem , storageService , shardRecorder , backupManager ) ;
  }
}


// Suggested Revision B
ShardRewriter createShardRewriter ( FileSystemContext fileSystemContext , FileSystem fileSystem , long transactionId , OptionalInt bucketNumber , UUID shardUuid , int shardRowCount , Optional < UUID > deltaShardUuid , boolean tableSupportsDeltaDelete , Map < String , Type > columns ) {
  if ( tableSupportsDeltaDelete ) {
    return new DeltaShardRewriter ( shardUuid , shardRowCount , deltaShardUuid , deletionExecutor , transactionId , bucketNumber , this , fileSystemContext , fileSystem ) ;
  }
  else {
    return new InplaceShardRewriter ( shardUuid , columns , deletionExecutor , transactionId , bucketNumber , nodeId , this , fileSystem , storageService , shardRecorder ) ;
  }
}


==========================this is the dividing line=============================



/** Example 3 */

/** Instanceof nightmare? */

// Manual revision
protected IMicroblockContainerTile getMicroblockTile ( IBlockAccess world , BlockPos pos ) {
  TileEntity tile = world . getTileEntity ( pos ) ;
  if ( tile == null ) {
    return null ;
  }
  return getMicroblockTile ( tile ) ;
}


// Suggested Revision A
protected IMicroblockContainerTile getMicroblockTile ( IBlockAccess world , BlockPos pos ) {
  TileEntity tile = world . getTileEntity ( pos ) ;
  return tile instanceof IMicroblockContainerTile ? ( IMicroblockContainerTile ) tile : null ;
}


// Suggested Revision B
protected IMicroblockContainerTile getMicroblockTile ( IBlockAccess world , BlockPos pos ) {
  TileEntity tile = world . getTileEntity ( pos ) ;
  return tile ;
}


==========================this is the dividing line=============================



/** Example 4 */

/** This will always return true, did you want cuEinvoiceDao instead of null here */

// Manual revision
private CuEinvoiceDao getCuEinvoiceDao ( ) {
  if ( ObjectUtils . isNull ( cuEinvoiceDao ) ) {
    cuEinvoiceDao = SpringContext . getBean ( CuEinvoiceDaoOjb . class ) ;
  }
  return cuEinvoiceDao ;
}


// Suggested Revision A
private CuEinvoiceDao getCuEinvoiceDao ( ) {
  return SpringContext . getBean ( CuEinvoiceDaoOjb . class ) ;
}


// Suggested Revision B
private CuEinvoiceDao getCuEinvoiceDao ( ) {
  if ( ObjectUtils . isNull ( cuEinvoiceDao ) ) {
    cuEinvoiceDao = SpringContext . getBean ( CuEinvoiceDaoOjb . class ) ;
  }
  return cuEinvoiceDao ;
}


==========================this is the dividing line=============================



/** Example 5 */

/** ```suggestion requestData = request; ``` */

// Manual revision
protected String contentFrom ( FitNesseContext context , Request request , WikiPage requestedPage ) {
  return prepareResponseDocument ( context ) . html ( request ) ;
}


// Suggested Revision A
protected String contentFrom ( FitNesseContext context , Request request , WikiPage requestedPage ) {
  requestData = request ;
  return prepareResponseDocument ( context ) . html ( ) ;
}


// Suggested Revision B
protected String contentFrom ( FitNesseContext context , Request request , WikiPage requestedPage ) {
  return prepareResponseDocument ( context ) . html ( ) ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** Currently when the test fails with any error then there is no stacktrace to the original failure, which I think makes pinpointing the culprit easier?  That being said, this is just preference, so feel free to ignore :) */

// Manual revision
public void testValidateDataStreamsNoConflicts ( ) {
  Metadata metadata = createIndices ( 5 , 10 , "foo-datastream" ) . metadata ;
  validateDataStreams ( metadata . getIndicesLookup ( ) , ( DataStreamMetadata ) metadata . customs ( ) . get ( DataStreamMetadata . TYPE ) ) ;
}


// Suggested Revision A
public void testValidateDataStreamsNoConflicts ( ) {
  Metadata metadata = createIndices ( 5 , 10 , "foo-datastream" ) . metadata ;
  validateDataStreams ( metadata . getIndicesLookup ( ) , ( DataStreamMetadata ) metadata . customs ( ) . get ( DataStreamMetadata . TYPE ) ) ;
}


// Suggested Revision B
public void testValidateDataStreamsNoConflicts ( ) {
  Metadata metadata = createIndices ( 5 , 10 , "foo-datastream" ) . metadata ;
  try {
    validateDataStreams ( metadata . getIndicesLookup ( ) , ( DataStreamMetadata ) metadata . customs ( ) . get ( DataStreamMetadata . TYPE ) ) ;
  }
  catch ( Exception e ) {
    fail ( "did not expect exception when validating a system without indices that would conflict with future backing indices: " + e ) ;
  }
}


==========================this is the dividing line=============================



/** Example 7 */

/** if you use AppiumDriver<?> driver = (AppiumDriver<?>) getDriverSafe(); then there is no sense in if (driver instanceof AppiumDriver) */

// Manual revision
private WebDriver getDriverSafe ( ) {
  WebDriver driver = getDriver ( ) ;
  if ( driver instanceof EventFiringWebDriver ) {
    driver = ( ( EventFiringWebDriver ) driver ) . getWrappedDriver ( ) ;
  }
  return driver ;
}


// Suggested Revision A
private AppiumDriver getDriverSafe ( ) {
  WebDriver < ? > driver = getDriver ( ) ;
  if ( driver instanceof EventFiringWebDriver ) {
    driver = ( ( EventFiringWebDriver ) driver ) . getWrappedDriver ( ) ;
    if ( driver instanceof AppiumDriver ) {
      return ( AppiumDriver ) driver ;
    }
  }
  throw new ClassCastException ( "Appium Driver can not be casted from the actual driver." ) ;
}


// Suggested Revision B
private AppiumDriver getDriverSafe ( ) {
  WebDriver driver = getDriver ( ) ;
  if ( driver instanceof AppiumDriver ) {
    return ( AppiumDriver ) driver ;
  }
  throw new ClassCastException ( "Appium Driver can not be casted from the actual driver." ) ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** return immediately, no need to store it in a local var */

// Manual revision
private Optional < Cookie > findCookieWithName ( String cookieName , HttpClient httpClient ) {
  return Arrays . stream ( httpClient . getState ( ) . getCookies ( ) ) . filter ( c -> cookieName . equals ( c . getName ( ) ) ) . findFirst ( ) ;
}


// Suggested Revision A
private Optional < Cookie > findCookieWithName ( String cookieName , HttpClient httpClient ) {
  Optional < Cookie > cookie = Arrays . stream ( httpClient . getState ( ) . getCookies ( ) ) . filter ( c -> cookieName . equals ( c . getName ( ) ) ) . findFirst ( ) ;
  return cookie ;
}


// Suggested Revision B
private Optional < Cookie > findCookieWithName ( String cookieName , HttpClient httpClient ) {
  return Arrays . stream ( httpClient . getState ( ) . getCookies ( ) ) . filter ( c -> cookieName . equals ( c . getName ( ) ) ) . findFirst ( ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** The expected value should be 1st, it affects error messages by junit */

// Manual revision
public void checkIPAdress ( ) {
  Set < ConstraintViolation < IPAdress >> validate = validator . validate ( new IPAdress ( address ) ) ;
  assertEquals ( expectedResult , validate . isEmpty ( ) ) ;
}


// Suggested Revision A
public void checkIPAdress ( ) {
  Set < ConstraintViolation < IPAdress >> validate = validator . validate ( new IPAdress ( address ) ) ;
  assertEquals ( validate . isEmpty ( ) , expectedResult ) ;
}


// Suggested Revision B
public void checkIPAdress ( ) {
  Set < ConstraintViolation < IPAdress >> validate = validator . validate ( new IPAdress ( address ) ) ;
  assertEquals ( validate . isEmpty ( ) , 1 ) ;
}


==========================this is the dividing line=============================



/** Example 10 */

/** the .contains() should probably be in the synchronized block too */

// Manual revision
public void notifyParameterChanged ( String name ) {
  synchronized ( fParameters ) {
    if ( ! fParameterNames . contains ( name ) ) {
      throw new RuntimeException ( String . format ( Messages . TmfAbstractAnalysisModule_InvalidParameter , name , getName ( ) ) ) ;
    }
    Object oldValue = fParameters . get ( name ) ;
    Object value = getParameter ( name ) ;
    if ( ( value != null ) && ! ( value . equals ( oldValue ) ) ) {
      parameterChanged ( name ) ;
    }
  }
}


// Suggested Revision A
public synchronized void notifyParameterChanged ( String name ) {
  if ( ! fParameterNames . contains ( name ) ) {
    throw new RuntimeException ( String . format ( Messages . TmfAbstractAnalysisModule_InvalidParameter , name , getName ( ) ) ) ;
  }
  Object oldValue = fParameters . get ( name ) ;
  Object value = getParameter ( name ) ;
  if ( ( value != null ) && ! ( value . equals ( oldValue ) ) ) {
    parameterChanged ( name ) ;
  }
}


// Suggested Revision B
public void notifyParameterChanged ( String name ) {
  if ( ! fParameterNames . contains ( name ) ) {
    throw new RuntimeException ( String . format ( Messages . TmfAbstractAnalysisModule_InvalidParameter , name , getName ( ) ) ) ;
  }
  synchronized ( fParameters ) {
    Object oldValue = fParameters . get ( name ) ;
    Object value = getParameter ( name ) ;
    if ( ( value != null ) && ! ( value . equals ( oldValue ) ) ) {
      parameterChanged ( name ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 11 */

/** But we are moving to UNJOINED anyway, so it won't affect the result right? */

// Manual revision
private synchronized void resetGeneration ( ) {
  this . rejoinNeeded = true ;
  this . generation = Generation . NO_GENERATION ;
}


// Suggested Revision A
private synchronized void resetGeneration ( ) {
  this . generation = Generation . NO_GENERATION ;
  rejoinNeeded = true ;
  if ( state != MemberState . REBALANCING ) state = MemberState . UNJOINED ;
}


// Suggested Revision B
private synchronized void resetGeneration ( ) {
  this . generation = Generation . NO_GENERATION ;
  rejoinNeeded = true ;
  state = MemberState . UNJOINED ;
}


==========================this is the dividing line=============================



/** Example 12 */

/** please remove redundant brackets (isInter...) */

// Manual revision
protected Guid getQuotaId ( ) {
  if ( getNewDisk ( ) != null && isInternalManagedDisk ( ) ) {
    return ( ( DiskImage ) getNewDisk ( ) ) . getQuotaId ( ) ;
  }
  return null ;
}


// Suggested Revision A
protected Guid getQuotaId ( ) {
  if ( getNewDisk ( ) != null && ( isInternalManagedDisk ( ) ) ) {
    return ( ( DiskImage ) getNewDisk ( ) ) . getQuotaId ( ) ;
  }
  return null ;
}


// Suggested Revision B
protected Guid getQuotaId ( ) {
  if ( getNewDisk ( ) != null && isInternalManagedDisk ( ) ) {
    return ( ( DiskImage ) getNewDisk ( ) ) . getQuotaId ( ) ;
  }
  return null ;
}


==========================this is the dividing line=============================



/** Example 13 */

/** So model change listener will be called twice for single modification? I do not like it. @monperrus Could you explain why it is good? */

// Manual revision
public < C extends CtTypedElement > C setType ( CtTypeReference < T > type ) {
  if ( type != null ) {
    type . setParent ( this ) ;
  }
  if ( getExecutable ( ) != null ) {
    getExecutable ( ) . setType ( type ) ;
  }
  return ( C ) this ;
}


// Suggested Revision A
public < C extends CtTypedElement > C setType ( CtTypeReference < T > type ) {
  if ( type != null ) {
    type . setParent ( this ) ;
  }
  if ( getExecutable ( ) != null ) {
    getExecutable ( ) . setType ( type ) ;
  }
  return ( C ) this ;
}


// Suggested Revision B
public < C extends CtTypedElement > C setType ( CtTypeReference < T > type ) {
  if ( type != null ) {
    type . setParent ( this ) ;
  }
  getExecutable ( ) . setType ( type ) ;
  return ( C ) this ;
}


==========================this is the dividing line=============================



/** Example 14 */

/** This should be ROLE_ANONYMOUS. However given the defaults in AnonymousSpec you should just delete it */

// Manual revision
public AnonymousSpec anonymous ( ) {
  if ( this . anonymous == null ) {
    this . anonymous = new AnonymousSpec ( ) ;
  }
  return this . anonymous ;
}


// Suggested Revision A
public AnonymousSpec anonymous ( ) {
  return this . anonymous . authorities ( "ROLE_USER" ) ;
}


// Suggested Revision B
public AnonymousSpec anonymous ( ) {
  return this . anonymous ;
}


==========================this is the dividing line=============================



/** Example 15 */

/** We still need to account for the probe batch size here when we are processing a spilled partition. If we try to account for it in he PostBuildCalculator it will already be too late, because we will have already prefetched the probe side batch. */

// Manual revision
public boolean shouldSpill ( ) {
  long batchSize = ( batchMemoryManager . getRecordBatchSizer ( RIGHT_INDEX ) . getRowAllocWidth ( ) + 4 ) * recordsPerBatch ;
  long reserveForOutgoing = batchMemoryManager . getOutputBatchSize ( ) ;
  long memoryAvailableNow = allocator . getLimit ( ) - allocator . getAllocatedMemory ( ) ;
  boolean needsSpill = minBatchesInAvailableMemory * batchSize > memoryAvailableNow - reserveForOutgoing ;
  if ( needsSpill ) {
    logger . debug ( "should spill now - batch size {
}, mem avail {
}, reserved for outgoing {
}" , batchSize , memoryAvailableNow , reserveForOutgoing ) ;
}
return needsSpill ;
}


// Suggested Revision A
public boolean shouldSpill ( ) {
  long batchSize = ( batchMemoryManager . getRecordBatchSizer ( RIGHT_INDEX ) . getRowAllocWidth ( ) + 4 ) * recordsPerBatch ;
  long reserveForOutgoing = batchMemoryManager . getOutputBatchSize ( ) ;
  long memoryAvailableNow = allocator . getLimit ( ) - allocator . getAllocatedMemory ( ) - reserveForOutgoing ;
  boolean needsSpill = minBatchesInAvailableMemory * batchSize > memoryAvailableNow ;
  if ( needsSpill ) {
    logger . debug ( "should spill now - batch size {
}, mem avail {
}, reserved for outgoing {
}" , batchSize , memoryAvailableNow , reserveForOutgoing ) ;
}
return needsSpill ;
}


// Suggested Revision B
public boolean shouldSpill ( ) {
  long batchSize = ( batchMemoryManager . getRecordBatchSizer ( RIGHT_INDEX ) . getRowAllocWidth ( ) + 4 ) * recordsPerBatch ;
  long memoryAvailableNow = allocator . getLimit ( ) - allocator . getAllocatedMemory ( ) - reserveForOutgoing ;
  boolean needsSpill = minBatchesInAvailableMemory * batchSize > memoryAvailableNow ;
  if ( needsSpill ) {
    logger . debug ( "should spill now - batch size {
}, mem avail {
}, reserved for outgoing {
}" , batchSize , memoryAvailableNow , reserveForOutgoing ) ;
}
return needsSpill ;
}


==========================this is the dividing line=============================



/** Example 16 */

/** Oh please, no! Don't ship a null object! :cry: */

// Manual revision
SlackService getSlackService ( final String baseUrl , final String teamDomain , final String authTokenCredentialId , final boolean botUser , final String room ) {
  return new StandardSlackService ( baseUrl , teamDomain , authTokenCredentialId , botUser , room ) ;
}


// Suggested Revision A
SlackService getSlackService ( final String baseUrl , final String teamDomain , final String authTokenCredentialId , final boolean botUser , final String room ) {
  return new StandardSlackService ( baseUrl , teamDomain , authTokenCredentialId , botUser , room ) ;
}


// Suggested Revision B
SlackService getSlackService ( final String baseUrl , final String teamDomain , final String authTokenCredentialId , final boolean botUser , final String room ) {
  return new StandardSlackService ( baseUrl , teamDomain , null , authTokenCredentialId , botUser , room ) ;
}


==========================this is the dividing line=============================



/** Example 17 */

/** TEXT datatype would be more appropriate. */

// Manual revision
public void init ( ) {
  setLabel ( "Plugin" ) ;
  addAttribute ( ID , ROLE_ID ) . setLabel ( "Identifier" ) ;
  addAttribute ( LABEL , ROLE_LABEL , ROLE_LOOKUP ) . setNillable ( false ) . setUnique ( true ) . setLabel ( "Label" ) ;
  addAttribute ( DESCRIPTION , ROLE_LOOKUP ) . setLabel ( "Description" ) ;
}


// Suggested Revision A
public void init ( ) {
  setLabel ( "Plugin" ) ;
  addAttribute ( ID , ROLE_ID ) . setLabel ( "Identifier" ) ;
  addAttribute ( LABEL , ROLE_LABEL , ROLE_LOOKUP ) . setNillable ( false ) . setUnique ( true ) . setLabel ( "Label" ) ;
  addAttribute ( DESCRIPTION , ROLE_LOOKUP ) . setLabel ( "Description" ) ;
}


// Suggested Revision B
public void init ( ) {
  setLabel ( "Plugin" ) ;
  addAttribute ( ID , ROLE_ID ) . setLabel ( "Identifier" ) ;
  addAttribute ( LABEL , ROLE_LABEL , ROLE_LOOKUP ) . setNillable ( false ) . setUnique ( true ) . setLabel ( "Label" ) ;
  addAttribute ( DESCRIPTION , ROLE_LOOKUP ) . setLabel ( "Description" ) . setDataType ( TEXT ) ;
}


==========================this is the dividing line=============================



/** Example 18 */

/** Even though these two are "CMAS Severe Alerts", shouldn't getCmasSeverity() still return CMAS_SEVERITY_EXTREME? Spec says "Severity of Extreme, Urgency of Expected..." */

// Manual revision
private int getCmasSeverity ( ) {
  switch ( messageIdentifier ) {
    case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_LIKELY : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_LIKELY : return SmsCbCmasInfo . CMAS_SEVERITY_EXTREME ;
    case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_LIKELY : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_LIKELY : return SmsCbCmasInfo . CMAS_SEVERITY_SEVERE ;
    default : return SmsCbCmasInfo . CMAS_SEVERITY_UNKNOWN ;
  }
}


// Suggested Revision A
private int getCmasSeverity ( ) {
  switch ( messageIdentifier ) {
    case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_LIKELY : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_LIKELY : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_LIKELY : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_LIKELY : return SmsCbCmasInfo . CMAS_SEVERITY_SEVERE ;
    default : return SmsCbCmasInfo . CMAS_SEVERITY_UNKNOWN ;
  }
}


// Suggested Revision B
private int getCmasSeverity ( ) {
  switch ( messageIdentifier ) {
    case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_LIKELY : return SmsCbCmasInfo . CMAS_SEVERITY_EXTREME ;
    case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_OBSERVED : case SmsCbConstants . MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_LIKELY : return SmsCbCmasInfo . CMAS_SEVERITY_UNKNOWN ;
  }
}


==========================this is the dividing line=============================



/** Example 19 */

/** This Block can be shortened to `share.setIsFolder(mPath.endsWith(FileUtils.PATH_SEPARATOR))` */

// Manual revision
private void updateData ( OCShare share ) {
  share . setPath ( mPath ) ;
  share . setIsFolder ( mPath . endsWith ( FileUtils . PATH_SEPARATOR ) ) ;
  share . setPermissions ( READ_ONLY ) ;
  getStorageManager ( ) . saveShare ( share ) ;
  OCFile file = getStorageManager ( ) . getFileByPath ( mPath ) ;
  if ( file != null ) {
    file . setShareWithSharee ( true ) ;
    getStorageManager ( ) . saveFile ( file ) ;
  }
}


// Suggested Revision A
private void updateData ( OCShare share ) {
  share . setPath ( mPath ) ;
  share . setIsFolder ( true ) ;
}
else {
  share . setIsFolder ( false ) ;
}
share . setPermissions ( READ_ONLY ) ;
getStorageManager ( ) . saveShare ( share ) ;
OCFile file = getStorageManager ( ) . getFileByPath ( mPath ) ;
if ( file != null ) {
  file . setShareWithSharee ( true ) ;
  getStorageManager ( ) . saveFile ( file ) ;
}
}


// Suggested Revision B
private void updateData ( OCShare share ) {
  share . setPath ( mPath ) ;
  share . setIsFolder ( mPath . endsWith ( FileUtils . PATH_SEPARATOR ) ) ;
  share . setPermissions ( READ_ONLY ) ;
  getStorageManager ( ) . saveShare ( share ) ;
  OCFile file = getStorageManager ( ) . getFileByPath ( mPath ) ;
  if ( file != null ) {
    file . setShareWithSharee ( true ) ;
    getStorageManager ( ) . saveFile ( file ) ;
  }
}


==========================this is the dividing line=============================



