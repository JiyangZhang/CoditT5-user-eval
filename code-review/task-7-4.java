/** Example 0 */

/** why is there a `newArrayList`? */

// Manual revision
public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


// Suggested Revision A
public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


// Suggested Revision B
public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = new ArrayList < Inode < ? >> ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


==========================this is the dividing line=============================



/** Example 1 */

/** why not `list.stream().forEach`? */

// Manual revision
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  Set < T > uniques = new HashSet < > ( ) ;
  list . stream ( ) . forEach ( t -> {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  ) ;
  return duplicates ;
}


// Suggested Revision A
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  return findDuplicates ( list . stream ( ) ) ;
}


// Suggested Revision B
public static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  Set < T > uniques = new HashSet < > ( ) ;
  for ( T t : list ) {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  return duplicates ;
}


// Suggested Revision C
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  for ( T t : list ) {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  return duplicates ;
}


==========================this is the dividing line=============================



/** Example 2 */

/** This isn't right. */

// Manual revision
public boolean next ( ) throws IOException {
  for ( ;
  ;
  ) {
    LogQueueEntry t = queue . poll ( ) ;
    if ( t == null ) {
      return false ;
    }
    refName = t . lc . getRefName ( ) ;
    updateIndex = t . lc . getUpdateIndex ( ) ;
    entry = t . lc . getReflogEntry ( ) ;
    boolean include = includeDeletes || entry != null ;
    skipShadowed ( refName , updateIndex ) ;
    add ( t ) ;
    if ( include ) {
      return true ;
    }
  }
}


// Suggested Revision A
public boolean next ( ) throws IOException {
  for ( ;
  ;
  ) {
    LogQueueEntry t = queue . poll ( ) ;
    if ( t == null ) {
      return false ;
    }
    refName = t . lc . getRefName ( ) ;
    updateIndex = t . lc . getUpdateIndex ( ) ;
    entry = t . lc . getReflogEntry ( ) ;
    skipShadowed ( refName , updateIndex ) ;
    add ( t ) ;
    if ( include ) {
      return true ;
    }
    return true ;
  }
}


// Suggested Revision B
public boolean next ( ) throws IOException {
  for ( ;
  ;
  ) {
    LogQueueEntry t = queue . poll ( ) ;
    if ( t == null ) {
      return false ;
    }
    refName = t . lc . getRefName ( ) ;
    updateIndex = t . lc . getUpdateIndex ( ) ;
    entry = t . lc . getReflogEntry ( ) ;
    boolean include = includeDeletes || entry != null ;
    skipShadowed ( refName , updateIndex ) ;
    add ( t ) ;
    if ( include ) {
      return true ;
    }
    return true ;
  }
}


==========================this is the dividing line=============================



/** Example 3 */

/** Hmm, this feels like premature optimization. The offsets map is more likely to be a problem. Also, I'm not sure we should restrict the usage. It is possible today to send offsets for multiple groups. Is there a good reason to restrict this even if it doesn't make sense in streams? */

// Manual revision
public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  sendOffsetsToTransaction ( offsets , new ConsumerGroupMetadata ( consumerGroupId ) ) ;
}


// Suggested Revision A
public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  if ( ! cachedGroupMetadata . groupId ( ) . equals ( consumerGroupId ) ) {
    log . warn ( "Cached consumer groupId changed from {
}
 to {
}
. If the old group id is not empty, this indicates an abuse of this API" , cachedGroupMetadata . groupId ( ) , consumerGroupId ) ;
    cachedGroupMetadata = new ConsumerGroupMetadata ( consumerGroupId , JoinGroupRequest . UNKNOWN_GENERATION_ID , JoinGroupRequest . UNKNOWN_MEMBER_ID , Optional . empty ( ) ) ;
  }
  sendOffsetsToTransactionInternal ( offsets , cachedGroupMetadata , true ) ;
}


// Suggested Revision B
public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  if ( ! cachedGroupMetadata . groupId ( ) . equals ( consumerGroupId ) ) {
    log . warn ( "Cached consumer groupId changed from {
}
 to {
}
. If the old group id is not empty, this indicates an abuse of this API" , cachedGroupMetadata . groupId ( ) , consumerGroupId ) ;
    cachedGroupMetadata = new ConsumerGroupMetadata ( consumerGroupId , JoinGroupRequest . UNKNOWN_GENERATION_ID , JoinGroupRequest . UNKNOWN_MEMBER_ID , Optional . empty ( ) ) ;
  }
  sendOffsetsToTransactionInternal ( offsets , cachedGroupMetadata , false ) ;
}


==========================this is the dividing line=============================



/** Example 4 */

/** The issue we found was when the original `reason` could not be logged due to an error in its `toString`. Do we have any concern that logging the _new_ error might have the same issue? Would it be better to have two stages to this?  1. Catch the logging error, then try to log that error. 2. Catch _that_ error if it happens, and log a generic, static message. */

// Manual revision
public boolean cancel ( final Exception rootReason ) {
  if ( transitionCancel ( rootReason ) ) {
    final Exception reason = new CancellationException ( rootReason ) ;
    try {
      traceFailure ( reason ) ;
    }
    catch ( Throwable ex ) {
      LOGGER . warn ( "Exception thrown in logging trace for failure!" , ex ) ;
    }
    finally {
      getSettableDelegate ( ) . fail ( reason ) ;
    }
    return true ;
  }
  return false ;
}


// Suggested Revision A
public boolean cancel ( final Exception rootReason ) {
  if ( transitionCancel ( rootReason ) ) {
    final Exception reason = new CancellationException ( rootReason ) ;
    getSettableDelegate ( ) . fail ( reason ) ;
    return true ;
  }
  return false ;
}


// Suggested Revision B
public boolean cancel ( final Exception rootReason ) {
  if ( transitionCancel ( rootReason ) ) {
    final Exception reason = new CancellationException ( rootReason ) ;
    try {
      traceFailure ( reason ) ;
    }
    catch ( Throwable ex ) {
      LOGGER . warn ( "Exception thrown in logging trace for failure!" , ex ) ;
    }
    getSettableDelegate ( ) . fail ( reason ) ;
    return true ;
  }
  return false ;
}


==========================this is the dividing line=============================



/** Example 5 */

/** the connection configuration is never serialized. */

// Manual revision
private void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


// Suggested Revision A
protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


// Suggested Revision B
protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** I'm probably missing something, but it seems like this is part of the next case (isn't `queue.size() >= 0` an invariant?). Is this called out just to emphasize that setting `0` => "no queuing"? */

// Manual revision
private boolean checkForJournalFlush ( ) {
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


// Suggested Revision A
private boolean checkForJournalFlush ( ) {
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


// Suggested Revision B
private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


==========================this is the dividing line=============================



/** Example 7 */

/** Use add(ProjectConfig) method here instead of repeating the same code? */

// Manual revision
private ProjectState newProjectState ( ProjectConfig local ) {
  add ( local ) ;
  return all . get ( local . getProject ( ) . getNameKey ( ) ) ;
}


// Suggested Revision A
private ProjectState newProjectState ( ProjectConfig local ) {
  PrologEnvironment . Factory envFactory = null ;
  GitRepositoryManager gitMgr = null ;
  ProjectControl . AssistedFactory projectControlFactory = null ;
  RulesCache rulesCache = null ;
  SitePaths sitePaths = null ;
  List < CommentLinkInfo > commentLinks = null ;
  all . put ( local . getProject ( ) . getNameKey ( ) , new ProjectState ( sitePaths , projectCache , allProjectsName , projectControlFactory , envFactory , gitMgr , rulesCache , commentLinks , local ) ) ;
  return all . get ( local . getProject ( ) . getNameKey ( ) ) ;
}


// Suggested Revision B
private ProjectState newProjectState ( ProjectConfig local ) {
  PrologEnvironment . Factory envFactory = null ;
  GitRepositoryManager gitMgr = null ;
  ProjectControl . AssistedFactory projectControlFactory = null ;
  RulesCache rulesCache = null ;
  SitePaths sitePaths = null ;
  List < CommentLinkInfo > commentLinks = null ;
  return add ( local , new ProjectState ( sitePaths , projectCache , allProjectsName , projectControlFactory , envFactory , gitMgr , rulesCache , commentLinks , local ) ) ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** There's a re-declaration error here, that got fixed on the parent branch. That needs to get merged in here. */

// Manual revision
public static Collection < PersonaAccount > getPersonaAccountsForAccount ( long accountId ) throws CentralRepoException {
  String queryClause = PERSONA_ACCOUNTS_QUERY_CALUSE + " WHERE persona_accounts.account_id = " + accountId + "AND p.status_id != " + Persona . PersonaStatus . DELETED . getStatusId ( ) ;
  CentralRepository cr = CentralRepository . getInstance ( ) ;
  if ( cr != null ) {
    PersonaAccountsQueryCallback queryCallback = new PersonaAccountsQueryCallback ( ) ;
    cr . executeSelectSQL ( queryClause , queryCallback ) ;
    return queryCallback . getPersonaAccountsList ( ) ;
  }
  return new ArrayList < > ( ) ;
}


// Suggested Revision A
public static Collection < PersonaAccount > getPersonaAccountsForAccount ( long accountId ) {
  String queryClause = PERSONA_ACCOUNTS_QUERY_CALUSE + " WHERE persona_accounts.account_id = " + accountId + "AND p.status_id != " + Persona . PersonaStatus . DELETED . getStatusId ( ) ;
  CentralRepository cr = CentralRepository . getInstance ( ) ;
  if ( cr != null ) {
    String queryClause = PERSONA_ACCOUNTS_QUERY_CALUSE + " WHERE persona_accounts.account_id = " + accountId ;
    PersonaAccountsQueryCallback queryCallback = new PersonaAccountsQueryCallback ( ) ;
    cr . executeSelectSQL ( queryClause , queryCallback ) ;
    return queryCallback . getPersonaAccountsList ( ) ;
  }
  return new ArrayList < > ( ) ;
}


// Suggested Revision B
public static Collection < PersonaAccount > getPersonaAccountsForAccount ( long accountId ) throws CentralRepoException {
  String queryClause = PERSONA_ACCOUNTS_QUERY_CALUSE + " WHERE persona_accounts.account_id = " + accountId ;
  CentralRepository cr = CentralRepository . getInstance ( ) ;
  if ( cr != null ) {
    PersonaAccountsQueryCallback queryCallback = new PersonaAccountsQueryCallback ( ) ;
    cr . executeSelectSQL ( queryClause , queryCallback ) ;
    return queryCallback . getPersonaAccountsList ( ) ;
  }
  return new ArrayList < > ( ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** The same question, how "column supports filtering" relates to "has multiple values"? */

// Manual revision
public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  return column != null && column . getCapabilities ( ) . hasMultipleValues ( ) ;
}


// Suggested Revision A
public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  if ( column == null || ! columnSupportsFiltering ( column ) ) {
    return false ;
  }
  else {
    return column . getCapabilities ( ) . hasMultipleValues ( ) ;
  }
}


// Suggested Revision B
public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  if ( column == null ) {
    return false ;
  }
  else {
    return column . getCapabilities ( ) . hasMultipleValues ( ) ;
  }
}


==========================this is the dividing line=============================



/** Example 10 */

/** This won't work? You wait until the node is powered on when you want to resume it. This will take forever. */

// Manual revision
public void resumeNode ( String id ) {
  api . serverApi ( ) . updateStatus ( id , Server . UpdateStatus . create ( Types . ServerAction . POWER_ON , Types . ServerActionMethod . HARDWARE ) ) ;
}


// Suggested Revision A
public void resumeNode ( String id ) {
  waitServerUntilAvailable . apply ( getNode ( id ) ) ;
  api . serverApi ( ) . updateStatus ( id , Server . UpdateStatus . create ( Types . ServerAction . POWER_ON , Types . ServerActionMethod . HARDWARE ) ) ;
}


// Suggested Revision B
public void resumeNode ( String id ) {
  api . serverApi ( ) . updateStatus ( id , Server . UpdateStatus . create ( Types . ServerAction . POWER_ON , Types . ServerActionMethod . HARDWARE ) ) ;
}


==========================this is the dividing line=============================



/** Example 11 */

/** Why are these registered at all? What invokes them? */

// Manual revision
public void registerOperations ( ManagementResourceRegistration resourceRegistration ) {
  super . registerOperations ( resourceRegistration ) ;
  resourceRegistration . registerOperationHandler ( ShowJaxrsResourcesHandler . DEFINITION , new ShowJaxrsResourcesHandler ( ) ) ;
}


// Suggested Revision A
public void registerOperations ( ManagementResourceRegistration resourceRegistration ) {
  if ( showResources ) {
    resourceRegistration . registerOperationHandler ( ShowJaxrsResourcesHandler . DEFINITION , new ShowJaxrsResourcesHandler ( ) ) ;
  }
}


// Suggested Revision B
public void registerOperations ( ManagementResourceRegistration resourceRegistration ) {
  if ( showResources ) {
    resourceRegistration . registerOperationHandler ( ShowJaxrsResourcesHandler . DEFINITION , new ShowJaxrsResourcesHandler ( ) ) ;
  }
  else {
    resourceRegistration . registerOperationHandler ( ADD_DEFINITION , ReloadRequiredRemoveStepHandler . INSTANCE ) ;
  }
}


==========================this is the dividing line=============================



/** Example 12 */

/** I'm thinking that new thread is not needed for the reconnect task. This thread should be dead already by the time a new reconnect is needed and I see `Timer` instance serving the purpose of this thread. What do you think? */

// Manual revision
public void run ( ) {
  try {
    if ( logger . isInfoEnabled ( ) ) logger . info ( "Start reconnecting " + provider ) ;
    provider . register ( getUIService ( ) . getDefaultSecurityAuthority ( provider ) ) ;
  }
  catch ( OperationFailedException ex ) {
    logger . error ( "cannot re-register provider will keep going" , ex ) ;
  }
}


// Suggested Revision A
public void run ( ) {
  try {
    if ( logger . isInfoEnabled ( ) ) logger . info ( "Start reconnecting " + provider ) ;
    provider . register ( getUIService ( ) . getDefaultSecurityAuthority ( provider ) ) ;
  }
  catch ( OperationFailedException ex ) {
    logger . error ( "cannot re-register provider will keep going" , ex ) ;
  }
}


// Suggested Revision B
public void run ( ) {
  if ( thread == null ) {
    thread = new Thread ( this ) ;
    thread . start ( ) ;
  }
  else {
    try {
      if ( logger . isInfoEnabled ( ) ) logger . info ( "Start reconnecting " + provider ) ;
      provider . register ( getUIService ( ) . getDefaultSecurityAuthority ( provider ) ) ;
    }
    catch ( OperationFailedException ex ) {
      logger . error ( "cannot re-register provider will keep going" , ex ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 13 */

/** Couldn't this actually depend on the class and generate the name from that? */

// Manual revision
public void checkProperties ( Properties properties ) {
  if ( ! properties . contains ( "log4j.shutdownCallbackRegistry" ) ) {
    properties . setProperty ( "log4j.shutdownCallbackRegistry" , "io.druid.common.config.Log4jShutdown" ) ;
  }
  if ( ! properties . contains ( "log4j.shutdownHookEnabled" ) ) {
    properties . setProperty ( "log4j.shutdownHookEnabled" , "true" ) ;
  }
}


// Suggested Revision A
public void checkProperties ( Properties properties ) {
  properties . setProperty ( "log4j.shutdownCallbackRegistry" , "io.druid.common.config.Log4jShutdown" ) ;
  properties . setProperty ( "log4j.shutdownHookEnabled" , "true" ) ;
}


// Suggested Revision B
public void checkProperties ( Properties properties ) {
}


==========================this is the dividing line=============================



/** Example 14 */

/** We should handle maxIdle as well */

// Manual revision
private EmbeddedExpirableMetadata ( long lifespan , TimeUnit lifespanUnit , long maxIdle , TimeUnit maxIdleUnit , EntryVersion version ) {
  super ( version ) ;
  this . lifespan = lifespan < 0 ? - 1 : lifespanUnit . toMillis ( lifespan ) ;
  this . maxIdle = maxIdle < 0 ? - 1 : maxIdleUnit . toMillis ( maxIdle ) ;
}


// Suggested Revision A
private EmbeddedExpirableMetadata ( long lifespan , TimeUnit lifespanUnit , long maxIdle , TimeUnit maxIdleUnit , EntryVersion version ) {
  super ( version ) ;
  this . lifespan = lifespan < 0 ? lifespan : lifespanUnit . toMillis ( lifespan ) ;
}


// Suggested Revision B
private EmbeddedExpirableMetadata ( long lifespan , TimeUnit lifespanUnit , long maxIdle , TimeUnit maxIdleUnit , EntryVersion version ) {
  super ( version ) ;
  this . lifespan = lifespan < 0 ? lifespan : lifespanUnit . toMillis ( lifespan ) ;
  this . maxIdle = maxIdle < 0 ? maxIdle : maxIdleUnit . toMillis ( maxIdle ) ;
}


==========================this is the dividing line=============================



/** Example 15 */

/** @Lars Do you think that for consistency (and maybe another slight performance enhancement) this line should be changed as well? */

// Manual revision
protected void setMatcherString ( String pattern ) {
  if ( pattern . length ( ) == 0 ) {
    searchPattern = null ;
  }
  else {
    SearchPattern patternMatcher = new SearchPattern ( ) ;
    if ( pattern . indexOf ( '*' ) != 0 && pattern . indexOf ( '?' ) != 0 && pattern . indexOf ( '.' ) != 0 ) {
      pattern = '*' + pattern ;
    }
    patternMatcher . setPattern ( pattern ) ;
    searchPattern = patternMatcher ;
  }
}


// Suggested Revision A
protected void setMatcherString ( String pattern ) {
  if ( StringUtils . isEmpty ( pattern ) ) {
    searchPattern = null ;
  }
  else {
    SearchPattern patternMatcher = new SearchPattern ( ) ;
    if ( pattern . indexOf ( '*' ) != 0 && pattern . indexOf ( '?' ) != 0 && pattern . indexOf ( '.' ) != 0 ) {
      pattern = "*" + pattern ;
    }
    patternMatcher . setPattern ( pattern ) ;
    searchPattern = patternMatcher ;
  }
}


// Suggested Revision B
private void setMatcherString ( String pattern ) {
  if ( pattern . length ( ) == 0 ) {
    searchPattern = null ;
  }
  else {
    SearchPattern patternMatcher = new SearchPattern ( ) ;
    if ( pattern . indexOf ( '*' ) != 0 && pattern . indexOf ( '?' ) != 0 && pattern . indexOf ( '.' ) != 0 ) {
      pattern = "*" + pattern ;
    }
    patternMatcher . setPattern ( pattern ) ;
    searchPattern = patternMatcher ;
  }
}


==========================this is the dividing line=============================



/** Example 16 */

/** yeah let's remove this :) */

// Manual revision
public DefaultEditorSession ( final ManagedSession session , final CanvasCommandManager < AbstractCanvasHandler > canvasCommandManager , final @ Session SessionCommandManager < AbstractCanvasHandler > sessionCommandManager , final @ Request SessionCommandManager < AbstractCanvasHandler > requestCommandManager , final ClientCommandRegistry < org . kie . workbench . common . stunner . core . command . Command < AbstractCanvasHandler , CanvasViolation >> clientCommandRegistry ) {
  this . session = session ;
  this . commandRegistry = clientCommandRegistry ;
  this . sessionCommandManager = sessionCommandManager ;
  this . requestCommandManager = requestCommandManager ;
  this . canvasCommandManager = canvasCommandManager ;
}


// Suggested Revision A
public DefaultEditorSession ( final ManagedSession session , final CanvasCommandManager < AbstractCanvasHandler > canvasCommandManager , final @ Session SessionCommandManager < AbstractCanvasHandler > sessionCommandManager , final @ Request SessionCommandManager < AbstractCanvasHandler > requestCommandManager , final ClientCommandRegistry < org . kie . workbench . common . stunner . core . command . Command < AbstractCanvasHandler , CanvasViolation >> clientCommandRegistry ) {
  this . session = session ;
  this . commandRegistry = clientCommandRegistry . setSession ( session ) ;
  this . sessionCommandManager = sessionCommandManager ;
  this . requestCommandManager = requestCommandManager ;
  this . canvasCommandManager = canvasCommandManager ;
}


// Suggested Revision B
public DefaultEditorSession ( final ManagedSession session , final CanvasCommandManager < AbstractCanvasHandler > canvasCommandManager , final @ Session SessionCommandManager < AbstractCanvasHandler > sessionCommandManager , final @ Request SessionCommandManager < AbstractCanvasHandler > requestCommandManager , final ClientCommandRegistry < CanvasViolation >> clientCommandRegistry ) {
  this . session = session ;
  this . commandRegistry = clientCommandRegistry . setSession ( session ) ;
  this . sessionCommandManager = sessionCommandManager ;
  this . requestCommandManager = requestCommandManager ;
  this . canvasCommandManager = canvasCommandManager ;
}


==========================this is the dividing line=============================



/** Example 17 */

/** 🐜 De-facto we process errors in the logging handler. E.g. logging constructs the string, and it may cause OutOfMemoryError, which suppresses the original one. I'd rather vote that Errors are being rethrown without any processing */

// Manual revision
private static void fireOnFailure ( final NodeProvisioner . PlannedNode plannedNode , final Throwable cause ) {
  for ( CloudProvisioningListener cl : CloudProvisioningListener . all ( ) ) {
    try {
      cl . onFailure ( plannedNode , cause ) ;
    }
    catch ( Error e ) {
      throw e ;
    }
    catch ( Throwable e ) {
      LOGGER . log ( Level . SEVERE , "Unexpected uncaught exception encountered while " + "processing onFailure() listener call in " + cl + " for agent " + plannedNode . displayName , e ) ;
    }
  }
}


// Suggested Revision A
private static void fireOnFailure ( final NodeProvisioner . PlannedNode plannedNode , final Throwable cause ) {
  for ( CloudProvisioningListener cl : CloudProvisioningListener . all ( ) ) {
    try {
      cl . onFailure ( plannedNode , cause ) ;
    }
    catch ( Throwable e ) {
      LOGGER . log ( Level . SEVERE , "Unexpected uncaught exception encountered while " + "processing onFailure() listener call in " + cl + " for agent " + plannedNode . displayName , e ) ;
    }
  }
}


// Suggested Revision B
private static void fireOnFailure ( final NodeProvisioner . PlannedNode plannedNode , final Throwable cause ) {
  for ( CloudProvisioningListener cl : CloudProvisioningListener . all ( ) ) {
    try {
      cl . onFailure ( plannedNode , cause ) ;
    }
    catch ( Throwable e ) {
      LOGGER . log ( Level . SEVERE , "Unexpected uncaught exception encountered while " + "processing onFailure() listener call in " + cl + " for agent " + plannedNode . displayName , e ) ;
    }
  }
}
}


==========================this is the dividing line=============================



/** Example 18 */

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



/** Example 19 */

/** Ditto `input != null` */

// Manual revision
public CrewMember apply ( org . atlasapi . media . entity . CrewMember input ) {
  if ( null == input . getId ( ) ) {
    return null ;
  }
  if ( input instanceof org . atlasapi . media . entity . Actor ) {
    return translateLegacyActor ( ( org . atlasapi . media . entity . Actor ) input ) ;
  }
  else if ( null != input ) {
    return translateLegacyCrewMember ( input ) ;
  }
  else {
    return null ;
  }
}


// Suggested Revision A
public CrewMember apply ( org . atlasapi . media . entity . CrewMember input ) {
  if ( input != null ) {
    return translateLegacyCrewMember ( input ) ;
  }
  else if ( input instanceof org . atlasapi . media . entity . Actor ) {
    return translateLegacyActor ( ( org . atlasapi . media . entity . Actor ) input ) ;
  }
  else {
    return null ;
  }
}


// Suggested Revision B
public CrewMember apply ( org . atlasapi . media . entity . CrewMember input ) {
  if ( input instanceof org . atlasapi . media . entity . Actor ) {
    return translateLegacyActor ( ( org . atlasapi . media . entity . Actor ) input ) ;
  }
  else if ( input != null ) {
    return translateLegacyCrewMember ( input ) ;
  }
  else {
    return null ;
  }
}


==========================this is the dividing line=============================



