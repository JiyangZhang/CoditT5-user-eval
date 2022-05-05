/** Example 0 */

/** You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ``` */

public void visitNode ( Tree tree ) {
  if ( ! hasSemantic ( ) ) {
    return ;
  }
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


public void visitNode ( Tree tree ) {
  if ( ! hasSemantic ( ) ) {
    return ;
  }
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


public void visitNode ( Tree tree ) {
  if ( ! hasSemantic ( ) ) {
    return ;
  }
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


*************************this is the dividing line*****************************



/** Example 1 */

/** [minor] Split into two asserts or add a message showing what the offending value actually is? */

protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
  assertTrue ( project . getState ( ) != null && project . getState ( ) != Project . State . UNRECOGNIZED ) ;
}


protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
  assertTrue ( project . getState ( ) != null && project . getState ( ) != Project . State . UNRECOGNIZED ) ;
}


protected void checkProject ( Project project ) {
  assertNotNull ( project . getId ( ) ) ;
  assertEquals ( project . toString ( ) , client . getProjectApi ( ) . getProject ( project . getId ( ) ) . toString ( ) ) ;
  assertTrue ( project . getState ( ) != null && project . getState ( ) != Project . State . UNRECOGNIZED ) ;
}


*************************this is the dividing line*****************************



/** Example 2 */

/** This is not really relevant IMO. It's not data of that rules, just an internal helper. In practice this is always going to be true anyway since it's a singleton component. */

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


*************************this is the dividing line*****************************



/** Example 3 */

/** Since you are at it, can you please change this to `long` primitive type? :) */

public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  Long id = Long . parseLong ( issueId + "0" + newCommentId ) ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , null , id ) ;
}


public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  Long id = Long . parseLong ( issueId + "0" + newCommentId ) ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , null , id ) ;
}


public static Comment newComment ( long issueId , int newCommentId , String comment ) {
  DateTime now = DateTime . now ( ) ;
  Long id = Long . parseLong ( issueId + "0" + newCommentId ) ;
  URI selfUri = URI . create ( TEST_JIRA_URL + "/rest/api/latest/issue/" + issueId + "/comment" ) ;
  return new Comment ( selfUri , comment , null , null , now , null , null , id ) ;
}


*************************this is the dividing line*****************************



/** Example 4 */

/** If it's interrupted you might want to return too, rather than getting stuck in another park. */

public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  boolean interrupted = false ;
  while ( ! changeset . isProcessed ( ) ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      interrupted = true ;
    }
  }
  if ( interrupted ) {
    Thread . currentThread ( ) . interrupt ( ) ;
  }
}


public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  boolean interrupted = false ;
  while ( ! changeset . isProcessed ( ) ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      interrupted = true ;
    }
  }
  if ( interrupted ) {
    Thread . currentThread ( ) . interrupt ( ) ;
  }
}


public void submit ( List < LuceneWork > workList , IndexingMonitor monitor ) {
  Changeset changeset = new Changeset ( workList , Thread . currentThread ( ) , monitor ) ;
  transferQueue . add ( changeset ) ;
  wakeUpConsumer ( ) ;
  boolean interrupted = false ;
  while ( ! changeset . isProcessed ( ) ) {
    LockSupport . park ( ) ;
    if ( Thread . interrupted ( ) ) {
      interrupted = true ;
    }
  }
  if ( interrupted ) {
    Thread . currentThread ( ) . interrupt ( ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 5 */

/** This will create a new object every time the method is called. Is this wanted? If not it'd be better to store the object once and always return it (static field). */

public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return new SnapshotInfo ( EMPTY_STRING ) ;
}


public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return new SnapshotInfo ( EMPTY_STRING ) ;
}


public ISnapshotInfo getSnapshotInfo ( String sessionName , IProgressMonitor monitor ) throws ExecutionException {
  return new SnapshotInfo ( EMPTY_STRING ) ;
}


*************************this is the dividing line*****************************



/** Example 6 */

/** Missing `final` (was indicated on the previous patch as well). */

private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) ;
  launchIntent . putExtra ( Intents . EXTRA_GEOCODE , destCode ) ;
  launchIntent . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) ;
  launchIntent . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) ;
  launchIntent . putExtra ( Intents . EXTRA_GEOCODE , destCode ) ;
  launchIntent . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) ;
  launchIntent . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


private static void navigate ( final Activity activity , final String destName , final String destCode , final Geopoint coords ) {
  Intent launchIntent = new Intent ( INTENT_ACTION ) ;
  launchIntent . putExtra ( Intents . EXTRA_NAME , destName ) ;
  launchIntent . putExtra ( Intents . EXTRA_GEOCODE , destCode ) ;
  launchIntent . putExtra ( Intents . EXTRA_LATITUDE , coords . getLatitude ( ) ) ;
  launchIntent . putExtra ( Intents . EXTRA_LONGITUDE , coords . getLongitude ( ) ) ;
  activity . startService ( launchIntent ) ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** Looking at other HandlerUtil.getVariable() calls, the usual logic is to look for an instance of what you were looking for (in this case Boolean) and to treat any other situation as if null was provided.  This would remove the need to check for Boolean in checkForCompositeRename and having code to issue an error log message which should never occur. */

public Object execute ( ExecutionEvent event ) throws ExecutionException {
  Object checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename != null ) {
    return checkForCompositeRename ( event , checkCompositeRename ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


public Object execute ( ExecutionEvent event ) throws ExecutionException {
  Object checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename != null ) {
    return checkForCompositeRename ( event , checkCompositeRename ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


public Object execute ( ExecutionEvent event ) throws ExecutionException {
  Object checkCompositeRename = HandlerUtil . getVariable ( event , LTK_CHECK_COMPOSITE_RENAME_PARAMETER_KEY ) ;
  if ( checkCompositeRename != null ) {
    return checkForCompositeRename ( event , checkCompositeRename ) ;
  }
  else {
    performRename ( event ) ;
  }
  return null ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** Maybe pass the layout inflater as a param to the adapter. */

public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  LayoutInflater inflater = LayoutInflater . from ( parent . getContext ( ) ) ;
  return new ChannelViewHolder ( ( ChannelView ) inflater . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  LayoutInflater inflater = LayoutInflater . from ( parent . getContext ( ) ) ;
  return new ChannelViewHolder ( ( ChannelView ) inflater . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


public ChannelViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
  LayoutInflater inflater = LayoutInflater . from ( parent . getContext ( ) ) ;
  return new ChannelViewHolder ( ( ChannelView ) inflater . inflate ( R . layout . channel_item_layout , parent , false ) ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** why the newArrayList?  Iterables.filter already returns an iterable. */

public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Lists . newArrayList ( Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ) ;
}


public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Lists . newArrayList ( Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ) ;
}


public static Iterable < ITmfEventAspect < ? >> getEventAspects ( ITmfTrace trace , Class < ? extends ITmfEventAspect < ? >> aspectClass ) {
  return Lists . newArrayList ( Iterables . filter ( Iterables . concat ( trace . getEventAspects ( ) , EXTRA_ASPECTS ) , aspect -> aspectClass . isAssignableFrom ( aspect . getClass ( ) ) ) ) ;
}


*************************this is the dividing line*****************************



/** Example 10 */

/** I think tuple size used to be 3. I'll fix it. */

public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) + 3 ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) + 3 ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


public < VT > MessageOut < T > withParameter ( ParameterType type , VT value ) {
  List < Object > newParameters = new ArrayList < > ( parameters . size ( ) + 3 ) ;
  newParameters . addAll ( parameters ) ;
  newParameters . add ( type ) ;
  newParameters . add ( value ) ;
  return new MessageOut < T > ( verb , payload , serializer , newParameters ) ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** @qeesung: nit you can merge the above 2 lines as `checkNotNull` returns `channelClass`. */

public B channel ( Class < ? extends C > channelClass ) {
  ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


public B channel ( Class < ? extends C > channelClass ) {
  ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


public B channel ( Class < ? extends C > channelClass ) {
  ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** I think this should be reverted, so it would still take into account additions from pre-`TransientActionFactory` implementations. */

public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getPersistedActions ( ) , type ) ;
  for ( TransientActionFactory < ? > taf : TransientActionFactory . factoriesFor ( getClass ( ) , type ) ) {
    _actions . addAll ( Util . filter ( createFor ( taf ) , type ) ) ;
  }
  return Collections . unmodifiableList ( _actions ) ;
}


public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getPersistedActions ( ) , type ) ;
  for ( TransientActionFactory < ? > taf : TransientActionFactory . factoriesFor ( getClass ( ) , type ) ) {
    _actions . addAll ( Util . filter ( createFor ( taf ) , type ) ) ;
  }
  return Collections . unmodifiableList ( _actions ) ;
}


public < T extends Action > List < T > getActions ( Class < T > type ) {
  List < T > _actions = Util . filter ( getPersistedActions ( ) , type ) ;
  for ( TransientActionFactory < ? > taf : TransientActionFactory . factoriesFor ( getClass ( ) , type ) ) {
    _actions . addAll ( Util . filter ( createFor ( taf ) , type ) ) ;
  }
  return Collections . unmodifiableList ( _actions ) ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** Missing a .get() here after .getKey() as the UUID is the key in the map, not the PatchLineComment.Key object instance. */

private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , parentMap . get ( c . getKey ( ) ) , outResult ) ;
    }
  }
}


private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , parentMap . get ( c . getKey ( ) ) , outResult ) ;
    }
  }
}


private static void addChildren ( Map < String , List < PatchLineComment >> parentMap , List < PatchLineComment > children , List < PatchLineComment > outResult ) {
  if ( children != null ) {
    for ( PatchLineComment c : children ) {
      outResult . add ( c ) ;
      addChildren ( parentMap , parentMap . get ( c . getKey ( ) ) , outResult ) ;
    }
  }
}


*************************this is the dividing line*****************************



/** Example 14 */

/** `toLowerCase` */

protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name . toLowerCase ( ) ;
}


protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name . toLowerCase ( ) ;
}


protected String getConfigRoot ( ) {
  return ClientConfigSections . HAZELCAST_CLIENT . name . toLowerCase ( ) ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** Please split this test into several, testing each case separately. */

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


*************************this is the dividing line*****************************



/** Example 16 */

/** Comparing with null is not enough. You might replace an existing attachment with a different instance in which case you should return true. In short if the return is different from the input then something changed. */

public boolean add ( XWikiAttachment attachment ) {
  return set ( attachment ) != null ;
}


public boolean add ( XWikiAttachment attachment ) {
  return set ( attachment ) != null ;
}


public boolean add ( XWikiAttachment attachment ) {
  return set ( attachment ) != null ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** I would recommend to use <code>this()</code> in this constructor */

public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  set ( format , line , hash ) ;
}


public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  set ( format , line , hash ) ;
}


public CronTab ( String format , int line , Hash hash ) throws ANTLRException {
  set ( format , line , hash ) ;
}


*************************this is the dividing line*****************************



/** Example 18 */

/** This is only required in things that render the FluidStack in a TESR. */

public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  super . writePacketData ( data ) ;
  tankManager . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  super . writePacketData ( data ) ;
  tankManager . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


public void writePacketData ( RailcraftOutputStream data ) throws IOException {
  super . writePacketData ( data ) ;
  tankManager . writePacketData ( data ) ;
  data . writeBoolean ( boiler . isBurning ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** s/n/name/ n is always an index */

private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand c : createCmds ) {
    ObjectId id = c . getNewId ( ) ;
    String n = c . getRefName ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , n ) ) ;
  }
}


private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand c : createCmds ) {
    ObjectId id = c . getNewId ( ) ;
    String n = c . getRefName ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , n ) ) ;
  }
}


private static void delete ( List < ReceiveCommand > cmds , List < ReceiveCommand > createCmds ) {
  for ( ReceiveCommand c : createCmds ) {
    ObjectId id = c . getNewId ( ) ;
    String n = c . getRefName ( ) ;
    cmds . add ( new ReceiveCommand ( id , ObjectId . zeroId ( ) , n ) ) ;
  }
}


*************************this is the dividing line*****************************



