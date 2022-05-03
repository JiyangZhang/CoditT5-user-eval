/** Example 0 */

/** why is there a `newArrayList`? */

public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = Lists . newArrayList ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = Lists . newArrayList ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = Lists . newArrayList ( mLockList . getInodes ( ) ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


*************************this is the dividing line*****************************



/** Example 1 */

/** why not `list.stream().forEach`? */

public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


public synchronized Inode < ? > getInodeOrNull ( ) {
  if ( ! fullPathExists ( ) ) {
    return null ;
  }
  List < Inode < ? >> inodeList = mLockList . getInodes ( ) ;
  return inodeList . get ( inodeList . size ( ) - 1 ) ;
}


*************************this is the dividing line*****************************



/** Example 2 */

/** This isn't right. */

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



/** Example 3 */

/** Hmm, this feels like premature optimization. The offsets map is more likely to be a problem. Also, I'm not sure we should restrict the usage. It is possible today to send offsets for multiple groups. Is there a good reason to restrict this even if it doesn't make sense in streams? */

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


*************************this is the dividing line*****************************



/** Example 4 */

/** The issue we found was when the original `reason` could not be logged due to an error in its `toString`. Do we have any concern that logging the _new_ error might have the same issue? Would it be better to have two stages to this?  1. Catch the logging error, then try to log that error. 2. Catch _that_ error if it happens, and log a generic, static message. */

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



/** Example 5 */

/** the connection configuration is never serialized. */

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


*************************this is the dividing line*****************************



/** Example 6 */

/** I'm probably missing something, but it seems like this is part of the next case (isn't `queue.size() >= 0` an invariant?). Is this called out just to emphasize that setting `0` => "no queuing"? */

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



/** Example 7 */

/** Use add(ProjectConfig) method here instead of repeating the same code? */

public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  sendOffsetsToTransaction ( offsets , new ConsumerGroupMetadata ( consumerGroupId ) ) ;
}


public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  sendOffsetsToTransaction ( offsets , new ConsumerGroupMetadata ( consumerGroupId ) ) ;
}


public void sendOffsetsToTransaction ( Map < TopicPartition , OffsetAndMetadata > offsets , String consumerGroupId ) throws ProducerFencedException {
  sendOffsetsToTransaction ( offsets , new ConsumerGroupMetadata ( consumerGroupId ) ) ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** There's a re-declaration error here, that got fixed on the parent branch. That needs to get merged in here. */

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



/** Example 9 */

/** The same question, how "column supports filtering" relates to "has multiple values"? */

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


*************************this is the dividing line*****************************



/** Example 10 */

/** This won't work? You wait until the node is powered on when you want to resume it. This will take forever. */

protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


protected void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** Why are these registered at all? What invokes them? */

private void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


private void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


private void writeJDBCStoreConnection ( XMLExtendedStreamWriter writer , SimpleConnectionFactoryConfiguration configuration ) throws XMLStreamException {
  writer . writeStartElement ( Element . SIMPLE_CONNECTION ) ;
  writeOptional ( writer , Attribute . CONNECTION_URL , configuration . connectionUrl ( ) ) ;
  writeOptional ( writer , Attribute . DRIVER_CLASS , configuration . driverClass ( ) ) ;
  writeOptional ( writer , Attribute . USERNAME , configuration . username ( ) ) ;
  writeOptional ( writer , Attribute . PASSWORD , configuration . password ( ) ) ;
  writer . writeEndElement ( ) ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** I'm thinking that new thread is not needed for the reconnect task. This thread should be dead already by the time a new reconnect is needed and I see `Timer` instance serving the purpose of this thread. What do you think? */

private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


private boolean checkForJournalFlush ( ) {
  if ( QueueBatchSize == 0 ) return true ;
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** Couldn't this actually depend on the class and generate the name from that? */

private boolean checkForJournalFlush ( ) {
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


private boolean checkForJournalFlush ( ) {
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


private boolean checkForJournalFlush ( ) {
  if ( queue . size ( ) >= QueueBatchSize ) return true ;
  boolean journalSizeFlush = ( JournalThresholdSize > 0 && journal . size ( ) > JournalThresholdSize ) ;
  if ( journalSizeFlush ) return true ;
  return false ;
}


*************************this is the dividing line*****************************



/** Example 14 */

/** We should handle maxIdle as well */

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



/** Example 15 */

/** @Lars Do you think that for consistency (and maybe another slight performance enhancement) this line should be changed as well? */

private ProjectState newProjectState ( ProjectConfig local ) {
  add ( local ) ;
  return all . get ( local . getProject ( ) . getNameKey ( ) ) ;
}


private ProjectState newProjectState ( ProjectConfig local ) {
  add ( local ) ;
  return all . get ( local . getProject ( ) . getNameKey ( ) ) ;
}


private ProjectState newProjectState ( ProjectConfig local ) {
  add ( local ) ;
  return all . get ( local . getProject ( ) . getNameKey ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 16 */

/** yeah let's remove this :) */

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



/** Example 17 */

/** 🐜 De-facto we process errors in the logging handler. E.g. logging constructs the string, and it may cause OutOfMemoryError, which suppresses the original one. I'd rather vote that Errors are being rethrown without any processing */

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


*************************this is the dividing line*****************************



/** Example 18 */

/** These two logs could be `Logger.v()`. That's all, good to go! */

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



/** Example 19 */

/** Ditto `input != null` */

public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  return column != null && column . getCapabilities ( ) . hasMultipleValues ( ) ;
}


public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  return column != null && column . getCapabilities ( ) . hasMultipleValues ( ) ;
}


public boolean hasMultipleValues ( final String dimension ) {
  if ( isVirtualColumn ( dimension ) ) {
    return virtualColumns . getVirtualColumn ( dimension ) . capabilities ( dimension ) . hasMultipleValues ( ) ;
  }
  final Column column = index . getColumn ( dimension ) ;
  return column != null && column . getCapabilities ( ) . hasMultipleValues ( ) ;
}


*************************this is the dividing line*****************************



