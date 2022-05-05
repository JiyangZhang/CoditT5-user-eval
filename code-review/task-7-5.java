/** Example 0 */

/** You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ``` */

// Manual revision
public void visitNode ( Tree tree ) {
  if ( ! hasSemantic ( ) ) {
    return ;
  }
  SwitchStatementTree switchStatementTree = ( SwitchStatementTree ) tree ;
  if ( getDefaultLabel ( switchStatementTree ) ) {
    if ( ! isSwitchOnEnum ( switchStatementTree ) ) {
      reportIssue ( switchStatementTree . switchKeyword ( ) , "Add a default case to this switch." ) ;
    }
    else if ( missingCasesOfEnum ( switchStatementTree ) ) {
      reportIssue ( switchStatementTree . switchKeyword ( ) , "Complete cases by adding the missing enum constants or add a default case to this switch." ) ;
    }
  }
}


// Suggested Revision A
public void visitNode ( Tree tree ) {
  SwitchStatementTree switchStatementTree = ( SwitchStatementTree ) tree ;
  Optional < CaseLabelTree > defaultLabel = getDefaultLabel ( switchStatementTree ) ;
  if ( ! defaultLabel . isPresent ( ) ) {
    if ( ! isSwitchOnEnum ( switchStatementTree ) ) {
      reportIssue ( switchStatementTree . switchKeyword ( ) , "Add a default case to this switch." ) ;
    }
    else if ( missingCasesOfEnum ( switchStatementTree ) ) {
      reportIssue ( switchStatementTree . switchKeyword ( ) , "Complete cases by adding the missing enum constants or add a default case to this switch." ) ;
    }
  }
}


// Suggested Revision B
public void visitNode ( Tree tree ) {
  if ( ! hasSemantic ( ) ) {
    return ;
  }
  SwitchStatementTree switchStatementTree = ( SwitchStatementTree ) tree ;
  Optional < CaseLabelTree > defaultLabel = getDefaultLabel ( switchStatementTree ) ;
  if ( ! defaultLabel . isPresent ( ) ) {
    reportIssue ( switchStatementTree . switchKeyword ( ) , "Add a default case to this switch." ) ;
  }
  else if ( missingCasesOfEnum ( switchStatementTree ) ) {
    reportIssue ( switchStatementTree . switchKeyword ( ) , "Complete cases by adding the missing enum constants or add a default case to this switch." ) ;
  }
}


==========================this is the dividing line=============================



/** Example 1 */

/** [minor] Split into two asserts or add a message showing what the offending value actually is? */

// Manual revision
protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
  assertTrue ( project . getState ( ) != null ) ;
  assertTrue ( project . getState ( ) != Project . State . UNRECOGNIZED ) ;
}


// Suggested Revision A
protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
  assertTrue ( project . getState ( ) != null && project . getState ( ) != Project . State . UNRECOGNIZED ) ;
}


// Suggested Revision B
protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 2 */

/** This is not really relevant IMO. It's not data of that rules, just an internal helper. In practice this is always going to be true anyway since it's a singleton component. */

// Manual revision
public boolean equals ( Object object ) {
  if ( object == this ) {
    return true ;
  }
  if ( ! ( object instanceof XarSecurityRule ) ) {
    return false ;
  }
  XarSecurityRule rhs = ( XarSecurityRule ) object ;
  return new EqualsBuilder ( ) . append ( this . right , rhs . right ) . append ( this . simple , rhs . simple ) . isEquals ( ) ;
}


// Suggested Revision A
public boolean equals ( Object object ) {
  if ( ! ( object instanceof XarSecurityRule ) ) {
    return false ;
  }
  XarSecurityRule rhs = ( XarSecurityRule ) object ;
  return new EqualsBuilder ( ) . append ( this . right , rhs . right ) . append ( this . simple , rhs . simple ) . append ( this . securityTool , rhs . securityTool ) . isEquals ( ) ;
}


// Suggested Revision B
public boolean equals ( Object object ) {
  if ( object == this ) {
    return true ;
  }
  if ( ! ( object instanceof XarSecurityRule ) ) {
    return false ;
  }
  XarSecurityRule rhs = ( XarSecurityRule ) object ;
  return new EqualsBuilder ( ) . append ( this . right , rhs . right ) . append ( this . simple , rhs . simple ) . append ( this . securityTool , rhs . securityTool ) . isEquals ( ) ;
}


==========================this is the dividing line=============================



/** Example 3 */

/** Since you are at it, can you please change this to `long` primitive type? :) */

// Manual revision
public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  long id = Long . parseLong ( issueId + "0" + newCommentId ) ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , null , id ) ;
}


// Suggested Revision A
public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  Long id = Long . parseLong ( issueId + "0" + newCommentId ) ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , id ) ;
}


// Suggested Revision B
public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  long id = issueId + "0" + newCommentId ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , id ) ;
}


==========================this is the dividing line=============================



/** Example 4 */

/** If it's interrupted you might want to return too, rather than getting stuck in another park. */

// Manual revision
public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  boolean interrupted = false ;
  while ( ! changeset . isProcessed ( ) && ! interrupted ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      interrupted = true ;
    }
  }
  if ( interrupted ) {
    Thread . currentThread ( ) . interrupt ( ) ;
  }
}


// Suggested Revision A
public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  while ( ! changeset . isProcessed ( ) ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      interrupted = true ;
    }
  }
}


// Suggested Revision B
public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  while ( ! changeset . isProcessed ( ) ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      return ;
    }
  }
  Thread . currentThread ( ) . interrupt ( ) ;
}


==========================this is the dividing line=============================



/** Example 5 */

/** This will create a new object every time the method is called. Is this wanted? If not it'd be better to store the object once and always return it (static field). */

// Manual revision
public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return null ;
}


// Suggested Revision A
public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return new SnapshotInfo ( EMPTY_STRING ) ;
}


// Suggested Revision B
public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return null ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** Missing `final` (was indicated on the previous patch as well). */

// Manual revision
private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  final Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) . putExtra ( Intents . EXTRA_GEOCODE , destCode ) . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


// Suggested Revision A
private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  final Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) ;
  launchIntent . putExtra ( Intents . EXTRA_GEOCODE , destCode ) ;
  final launchIntent . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) ;
  launchIntent . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


// Suggested Revision B
private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) ;
  launchIntent . putExtra ( Intents . EXTRA_GEOCODE , destCode ) ;
  launchIntent . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) ;
  launchIntent . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


==========================this is the dividing line=============================



/** Example 7 */

/** Looking at other HandlerUtil.getVariable() calls, the usual logic is to look for an instance of what you were looking for (in this case Boolean) and to treat any other situation as if null was provided.  This would remove the need to check for Boolean in checkForCompositeRename and having code to issue an error log message which should never occur. */

// Manual revision
public Object execute ( ExecutionEvent event ) throws ExecutionException {
  Object checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename instanceof Boolean ) {
    return checkForCompositeRename ( event ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


// Suggested Revision A
public Boolean execute ( ExecutionEvent event ) throws ExecutionException {
  Boolean checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename != null ) {
    return checkForCompositeRename ( event , checkCompositeRename ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


// Suggested Revision B
public Object execute ( ExecutionEvent event ) throws ExecutionException {
  Object checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename instanceof Boolean ) {
    return checkForCompositeRename ( event , checkCompositeRename ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** Maybe pass the layout inflater as a param to the adapter. */

// Manual revision
public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  return new ChannelViewHolder ( ( ChannelView ) inflater . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


// Suggested Revision A
public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  return new ChannelViewHolder ( ( ChannelView ) parent . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


// Suggested Revision B
public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  LayoutInflater inflater = LayoutInflater . from ( parent . getContext ( ) ) ;
  return new ChannelViewHolder ( ( ChannelView ) inflater . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** why the newArrayList?  Iterables.filter already returns an iterable. */

// Manual revision
public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ;
}


// Suggested Revision A
public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ;
}


// Suggested Revision B
public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ) ;
}


==========================this is the dividing line=============================



/** Example 10 */

/** I think tuple size used to be 3. I'll fix it. */

// Manual revision
public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) + 2 ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


// Suggested Revision A
public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


// Suggested Revision B
public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) + 2 ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


==========================this is the dividing line=============================



/** Example 11 */

/** @qeesung: nit you can merge the above 2 lines as `checkNotNull` returns `channelClass`. */

// Manual revision
public B channel ( Class < ? extends C > channelClass ) {
  return channelFactory ( new ReflectiveChannelFactory < C > ( ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ) ) ;
}


// Suggested Revision A
public B channel ( Class < ? extends C > channelClass ) {
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


// Suggested Revision B
public B channel ( Class < ? extends C > channelClass ) {
  channelClass = ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


==========================this is the dividing line=============================



/** Example 12 */

/** I think this should be reverted, so it would still take into account additions from pre-`TransientActionFactory` implementations. */

// Manual revision
public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getActions ( ) , type ) ;
  for ( TransientActionFactory < ? > taf : TransientActionFactory . factoriesFor ( getClass ( ) , type ) ) {
    _actions . addAll ( Util . filter ( createFor ( taf ) , type ) ) ;
  }
  return Collections . unmodifiableList ( _actions ) ;
}


// Suggested Revision A
public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getPersistedActions ( ) , type ) ;
  return Collections . unmodifiableList ( _actions ) ;
}


// Suggested Revision B
public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getPersistedActions ( ) , type ) ;
  for ( TransientActionFactory < ? > taf : TransientActionFactory . factoriesFor ( getClass ( ) , type ) ) {
    _actions . addAll ( Util . filter ( createFor ( taf ) , type ) ) ;
  }
  return Collections . unmodifiableList ( _actions ) ;
}


==========================this is the dividing line=============================



/** Example 13 */

/** Missing a .get() here after .getKey() as the UUID is the key in the map, not the PatchLineComment.Key object instance. */

// Manual revision
private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , parentMap . get ( c . getKey ( ) . get ( ) ) , outResult ) ;
    }
  }
}


// Suggested Revision A
private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , c . get ( ) , outResult ) ;
    }
  }
}


// Suggested Revision B
private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , parentMap . get ( c ) , outResult ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 14 */

/** `toLowerCase` */

// Manual revision
protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name ;
}


// Suggested Revision A
protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name . toLowerCase ( ) ;
}


// Suggested Revision B
protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name ;
}


==========================this is the dividing line=============================



/** Example 15 */

/** Please split this test into several, testing each case separately. */

// Manual revision
public void testGetNameFromPath ( ) {
  String path1 = "/group1" ;
  assertEquals ( HDF5Utils . getNameFromPath ( path1 ) , "group1" ) ;
}


// Suggested Revision A
public void testGetNameFromPath ( ) {
  String path1 = "/group1" ;
  String path2 = "/group1/group2/group3" ;
  String emptyPath = "" ;
  String nullPath = null ;
  String rootPath = "/" ;
  assertEquals ( HDF5Utils . getNameFromPath ( path1 ) , "group1" ) ;
  assertEquals ( HDF5Utils . getNameFromPath ( path2 ) , "group3" ) ;
  assertEquals ( HDF5Utils . getNameFromPath ( emptyPath ) , "" ) ;
  assertNull ( HDF5Utils . getNameFromPath ( nullPath ) ) ;
  assertEquals ( HDF5Utils . getNameFromPath ( rootPath ) , "" ) ;
}


// Suggested Revision B
public void testGetNameFromPath ( ) {
  String path1 = "/group1" ;
  String path2 = "/group1/group2/group3" ;
  String emptyPath = "" ;
  String nullPath = null ;
  String rootPath = "/" ;
  assertEquals ( HDF5Utils . getNameFromPath ( rootPath ) , "" ) ;
}


==========================this is the dividing line=============================



/** Example 16 */

/** Comparing with null is not enough. You might replace an existing attachment with a different instance in which case you should return true. In short if the return is different from the input then something changed. */

// Manual revision
public boolean add ( XWikiAttachment attachment ) {
  XWikiAttachment set = set ( attachment ) ;
  return set != attachment ;
}


// Suggested Revision A
public boolean add ( XWikiAttachment attachment ) {
  return add ( attachment ) ;
}


// Suggested Revision B
public boolean add ( XWikiAttachment attachment ) {
  return set ( attachment ) != attachment ;
}


==========================this is the dividing line=============================



/** Example 17 */

/** I would recommend to use <code>this()</code> in this constructor */

// Manual revision
public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  this ( format , line , hash , null ) ;
}


// Suggested Revision A
public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  this ( format , line , hash , null ) ;
}


// Suggested Revision B
public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  this ( ) ;
  set ( format , line , hash ) ;
}


==========================this is the dividing line=============================



/** Example 18 */

/** This is only required in things that render the FluidStack in a TESR. */

// Manual revision
public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  super . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


// Suggested Revision A
public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  tankManager . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


// Suggested Revision B
public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  super . writePacketData ( data ) ;
  tankManager . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 19 */

/** s/n/name/ n is always an index */

// Manual revision
private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand cmd : createCmds ) {
    ObjectId id = cmd . getNewId ( ) ;
    String name = cmd . getRefName ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , name ) ) ;
  }
}


// Suggested Revision A
private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand c : createCmds ) {
    ObjectId id = c . getNewId ( ) ;
    String s = c . getRefName ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , s ) ) ;
  }
}


// Suggested Revision B
private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand c : createCmds ) {
    ObjectId id = c . getNewId ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , c . getRefName ( ) ) ) ;
  }
}


==========================this is the dividing line=============================



