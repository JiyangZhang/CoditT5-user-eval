/** Example 0 */

/** ['why is there a `newArrayList`?', 'why is there a `newArrayList`?'] */

// option 0 
public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = Lists . newArrayList ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}




// option 1 
public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = Lists . newArrayList ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}




*************************this is the dividing line*****************************



/** Example 1 */

/** ['why not `list.stream().forEach`?', 'why not `list.stream().forEach`?', 'why not `list.stream().forEach`?'] */

// option 0 
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  Set < T > uniques = new HashSet < > ( ) ;
  for ( T t : list ) {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  return duplicates ;
}




// option 1 
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  Set < T > uniques = new HashSet < > ( ) ;
  for ( T t : list ) {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  return duplicates ;
}




// option 2 
private static < T > Set < T > findDuplicates ( Collection < T > list ) {
  Set < T > duplicates = new HashSet < > ( ) ;
  Set < T > uniques = new HashSet < > ( ) ;
  for ( T t : list ) {
    if ( ! uniques . add ( t ) ) {
      duplicates . add ( t ) ;
    }
  }
  return duplicates ;
}




*************************this is the dividing line*****************************



/** Example 2 */

/** ["This isn't right.", "This isn't right."] */

// option 0 
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




// option 1 
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




*************************this is the dividing line*****************************



/** Example 3 */

/** ["Hmm, this feels like premature optimization. The offsets map is more likely to be a problem. Also, I'm not sure we should restrict the usage. It is possible today to send offsets for multiple groups. Is there a good reason to restrict this even if it doesn't make sense in streams?", "Hmm, this feels like premature optimization. The offsets map is more likely to be a problem. Also, I'm not sure we should restrict the usage. It is possible today to send offsets for multiple groups. Is there a good reason to restrict this even if it doesn't make sense in streams?"] */

// option 0 
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




// option 1 
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




*************************this is the dividing line*****************************



/** Example 4 */

/** ['The issue we found was when the original `reason` could not be logged due to an error in its `toString`. Do we have any concern that logging the _new_ error might have the same issue? Would it be better to have two stages to this?  1. Catch the logging error, then try to log that error. 2. Catch _that_ error if it happens, and log a generic, static message.', 'The issue we found was when the original `reason` could not be logged due to an error in its `toString`. Do we have any concern that logging the _new_ error might have the same issue? Would it be better to have two stages to this?  1. Catch the logging error, then try to log that error. 2. Catch _that_ error if it happens, and log a generic, static message.'] */

// option 0 
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




// option 1 
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




*************************this is the dividing line*****************************



/** Example 5 */

/** ['the connection configuration is never serialized.', 'the connection configuration is never serialized.'] */

// option 0 
protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}




// option 1 
protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}




*************************this is the dividing line*****************************



/** Example 6 */

/** ['I\'m probably missing something, but it seems like this is part of the next case (isn\'t `queue.size() >= 0` an invariant?). Is this called out just to emphasize that setting `0` => "no queuing"?', 'I\'m probably missing something, but it seems like this is part of the next case (isn\'t `queue.size() >= 0` an invariant?). Is this called out just to emphasize that setting `0` => "no queuing"?'] */

// option 0 
private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}




// option 1 
private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}




*************************this is the dividing line*****************************



/** Example 7 */

/** ['Use add(ProjectConfig) method here instead of repeating the same code?', 'Use add(ProjectConfig) method here instead of repeating the same code?'] */

// option 0 
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




// option 1 
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




*************************this is the dividing line*****************************



/** Example 8 */

/** ["There's a re-declaration error here, that got fixed on the parent branch. That needs to get merged in here.", "There's a re-declaration error here, that got fixed on the parent branch. That needs to get merged in here."] */

// option 0 
public static Collection < PersonaAccount > getPersonaAccountsForAccount ( long accountId ) throws CentralRepoException {
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




// option 1 
public static Collection < PersonaAccount > getPersonaAccountsForAccount ( long accountId ) throws CentralRepoException {
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




*************************this is the dividing line*****************************



/** Example 9 */

/** ['The same question, how "column supports filtering" relates to "has multiple values"?', 'The same question, how "column supports filtering" relates to "has multiple values"?'] */

// option 0 
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




// option 1 
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




*************************this is the dividing line*****************************



/** Example 10 */

/** ["This won't work? You wait until the node is powered on when you want to resume it. This will take forever.", "This won't work? You wait until the node is powered on when you want to resume it. This will take forever."] */

// option 0 
public void resumeNode ( String id ) {
  waitServerUntilAvailable . apply ( getNode ( id ) ) ;
  api . serverApi ( ) . updateStatus ( id , Server . UpdateStatus . create ( Types . ServerAction . POWER_ON , Types . ServerActionMethod . HARDWARE ) ) ;
}




// option 1 
public void resumeNode ( String id ) {
  waitServerUntilAvailable . apply ( getNode ( id ) ) ;
  api . serverApi ( ) . updateStatus ( id , Server . UpdateStatus . create ( Types . ServerAction . POWER_ON , Types . ServerActionMethod . HARDWARE ) ) ;
}




*************************this is the dividing line*****************************



/** Example 11 */

/** ['Why are these registered at all? What invokes them?', 'Why are these registered at all? What invokes them?'] */

// option 0 
public void registerOperations ( ManagementResourceRegistration resourceRegistration ) {
  if ( showResources ) {
    resourceRegistration . registerOperationHandler ( ShowJaxrsResourcesHandler . DEFINITION , new ShowJaxrsResourcesHandler ( ) ) ;
  }
  else {
    resourceRegistration . registerOperationHandler ( ADD_DEFINITION , JaxrsSubsystemAdd . INSTANCE ) ;
    resourceRegistration . registerOperationHandler ( REMOVE_DEFINITION , ReloadRequiredRemoveStepHandler . INSTANCE ) ;
  }
}




// option 1 
public void registerOperations ( ManagementResourceRegistration resourceRegistration ) {
  if ( showResources ) {
    resourceRegistration . registerOperationHandler ( ShowJaxrsResourcesHandler . DEFINITION , new ShowJaxrsResourcesHandler ( ) ) ;
  }
  else {
    resourceRegistration . registerOperationHandler ( ADD_DEFINITION , JaxrsSubsystemAdd . INSTANCE ) ;
    resourceRegistration . registerOperationHandler ( REMOVE_DEFINITION , ReloadRequiredRemoveStepHandler . INSTANCE ) ;
  }
}




*************************this is the dividing line*****************************



/** Example 12 */

/** ["I'm thinking that new thread is not needed for the reconnect task. This thread should be dead already by the time a new reconnect is needed and I see `Timer` instance serving the purpose of this thread. What do you think?", "I'm thinking that new thread is not needed for the reconnect task. This thread should be dead already by the time a new reconnect is needed and I see `Timer` instance serving the purpose of this thread. What do you think?"] */

// option 0 
public void run ( ) {
  if ( thread == null || ! Thread . currentThread ( ) . equals ( thread ) ) {
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




// option 1 
public void run ( ) {
  if ( thread == null || ! Thread . currentThread ( ) . equals ( thread ) ) {
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




*************************this is the dividing line*****************************



/** Example 13 */

/** ["Couldn't this actually depend on the class and generate the name from that?", "Couldn't this actually depend on the class and generate the name from that?"] */

// option 0 
public void checkProperties ( Properties properties ) {
  properties . setProperty ( "log4j.shutdownCallbackRegistry" , "io.druid.common.config.Log4jShutdown" ) ;
  properties . setProperty ( "log4j.shutdownHookEnabled" , "true" ) ;
}




// option 1 
public void checkProperties ( Properties properties ) {
  properties . setProperty ( "log4j.shutdownCallbackRegistry" , "io.druid.common.config.Log4jShutdown" ) ;
  properties . setProperty ( "log4j.shutdownHookEnabled" , "true" ) ;
}




*************************this is the dividing line*****************************



/** Example 14 */

/** ['We should handle maxIdle as well', 'We should handle maxIdle as well'] */

// option 0 
private EmbeddedExpirableMetadata ( long lifespan , TimeUnit lifespanUnit , long maxIdle , TimeUnit maxIdleUnit , EntryVersion version ) {
  super ( version ) ;
  this . lifespan = lifespan < 0 ? lifespan : lifespanUnit . toMillis ( lifespan ) ;
  this . maxIdle = maxIdleUnit . toMillis ( maxIdle ) ;
}




// option 1 
private EmbeddedExpirableMetadata ( long lifespan , TimeUnit lifespanUnit , long maxIdle , TimeUnit maxIdleUnit , EntryVersion version ) {
  super ( version ) ;
  this . lifespan = lifespan < 0 ? lifespan : lifespanUnit . toMillis ( lifespan ) ;
  this . maxIdle = maxIdleUnit . toMillis ( maxIdle ) ;
}




*************************this is the dividing line*****************************



/** Example 15 */

/** ['@Lars Do you think that for consistency (and maybe another slight performance enhancement) this line should be changed as well?', '@Lars Do you think that for consistency (and maybe another slight performance enhancement) this line should be changed as well?'] */

// option 0 
protected void setMatcherString ( String pattern ) {
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




// option 1 
protected void setMatcherString ( String pattern ) {
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




*************************this is the dividing line*****************************



/** Example 16 */

/** ["yeah let's remove this :)", "yeah let's remove this :)"] */

// option 0 
public DefaultEditorSession ( final ManagedSession session , final CanvasCommandManager < AbstractCanvasHandler > canvasCommandManager , final @ Session SessionCommandManager < AbstractCanvasHandler > sessionCommandManager , final @ Request SessionCommandManager < AbstractCanvasHandler > requestCommandManager , final ClientCommandRegistry < org . kie . workbench . common . stunner . core . command . Command < AbstractCanvasHandler , CanvasViolation >> clientCommandRegistry ) {
  this . session = session ;
  this . commandRegistry = clientCommandRegistry . setSession ( session ) ;
  this . sessionCommandManager = sessionCommandManager ;
  this . requestCommandManager = requestCommandManager ;
  this . canvasCommandManager = canvasCommandManager ;
}




// option 1 
public DefaultEditorSession ( final ManagedSession session , final CanvasCommandManager < AbstractCanvasHandler > canvasCommandManager , final @ Session SessionCommandManager < AbstractCanvasHandler > sessionCommandManager , final @ Request SessionCommandManager < AbstractCanvasHandler > requestCommandManager , final ClientCommandRegistry < org . kie . workbench . common . stunner . core . command . Command < AbstractCanvasHandler , CanvasViolation >> clientCommandRegistry ) {
  this . session = session ;
  this . commandRegistry = clientCommandRegistry . setSession ( session ) ;
  this . sessionCommandManager = sessionCommandManager ;
  this . requestCommandManager = requestCommandManager ;
  this . canvasCommandManager = canvasCommandManager ;
}




*************************this is the dividing line*****************************



/** Example 17 */

/** ["🐜 De-facto we process errors in the logging handler. E.g. logging constructs the string, and it may cause OutOfMemoryError, which suppresses the original one. I'd rather vote that Errors are being rethrown without any processing", "🐜 De-facto we process errors in the logging handler. E.g. logging constructs the string, and it may cause OutOfMemoryError, which suppresses the original one. I'd rather vote that Errors are being rethrown without any processing"] */

// option 0 
private static void fireOnFailure ( final NodeProvisioner . PlannedNode plannedNode , final Throwable cause ) {
  for ( CloudProvisioningListener cl : CloudProvisioningListener . all ( ) ) {
    try {
      cl . onFailure ( plannedNode , cause ) ;
    }
    catch ( Throwable e ) {
      LOGGER . log ( Level . SEVERE , "Unexpected uncaught exception encountered while " + "processing onFailure() listener call in " + cl + " for agent " + plannedNode . displayName , e ) ;
      if ( e instanceof Error ) {
        throw e ;
      }
    }
  }
}




// option 1 
private static void fireOnFailure ( final NodeProvisioner . PlannedNode plannedNode , final Throwable cause ) {
  for ( CloudProvisioningListener cl : CloudProvisioningListener . all ( ) ) {
    try {
      cl . onFailure ( plannedNode , cause ) ;
    }
    catch ( Throwable e ) {
      LOGGER . log ( Level . SEVERE , "Unexpected uncaught exception encountered while " + "processing onFailure() listener call in " + cl + " for agent " + plannedNode . displayName , e ) ;
      if ( e instanceof Error ) {
        throw e ;
      }
    }
  }
}




*************************this is the dividing line*****************************



/** Example 18 */

/** ["These two logs could be `Logger.v()`. That's all, good to go!", "These two logs could be `Logger.v()`. That's all, good to go!"] */

// option 0 
public synchronized boolean isLastMQNotifLongAgo ( ) {
  long delay = 18 * 3600 ;
  long threshold = sharedPreferences . getLong ( getCurrentModeName ( ) + LAST_MORNING_Q_TIMESTAMP , - delay ) + delay ;
  if ( threshold < Calendar . getInstance ( ) . getTimeInMillis ( ) ) {
    Logger . d ( TAG , "{}
 - Last MQ notif was yesterday" , getCurrentModeName ( ) ) ;
    return true ;
  }
  else {
    Logger . d ( TAG , "{}
 - Last MQ notif was recent, do not notify" , getCurrentModeName ( ) ) ;
    return false ;
  }
}




// option 1 
public synchronized boolean isLastMQNotifLongAgo ( ) {
  long delay = 18 * 3600 ;
  long threshold = sharedPreferences . getLong ( getCurrentModeName ( ) + LAST_MORNING_Q_TIMESTAMP , - delay ) + delay ;
  if ( threshold < Calendar . getInstance ( ) . getTimeInMillis ( ) ) {
    Logger . d ( TAG , "{}
 - Last MQ notif was yesterday" , getCurrentModeName ( ) ) ;
    return true ;
  }
  else {
    Logger . d ( TAG , "{}
 - Last MQ notif was recent, do not notify" , getCurrentModeName ( ) ) ;
    return false ;
  }
}




*************************this is the dividing line*****************************



/** Example 19 */

/** ['Ditto `input != null`', 'Ditto `input != null`'] */

// option 0 
public CrewMember apply ( org . atlasapi . media . entity . CrewMember input ) {
  if ( input instanceof org . atlasapi . media . entity . Actor ) {
    return translateLegacyActor ( ( org . atlasapi . media . entity . Actor ) input ) ;
  }
  else if ( Objects . nonNull ( input ) ) {
    return translateLegacyCrewMember ( input ) ;
  }
  else {
    return null ;
  }
}




// option 1 
public CrewMember apply ( org . atlasapi . media . entity . CrewMember input ) {
  if ( input instanceof org . atlasapi . media . entity . Actor ) {
    return translateLegacyActor ( ( org . atlasapi . media . entity . Actor ) input ) ;
  }
  else if ( Objects . nonNull ( input ) ) {
    return translateLegacyCrewMember ( input ) ;
  }
  else {
    return null ;
  }
}




*************************this is the dividing line*****************************



