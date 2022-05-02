/** Example 0 */

/** maybe you need a specific Exception Type */

// option 0 
void verifyMetadata ( MessageMetadata metadata ) throws Exception {
  if ( metadata . getMessageMetadataType ( ) != MessageType . LOG_ENTRY_MESSAGE || metadata . getSnapshotTimestamp ( ) != srcGlobalSnapshot ) {
    log . error ( "Wrong message metadata {
}, expecting  type {
}
 snapshot {
}" , metadata , MessageType . LOG_ENTRY_MESSAGE , srcGlobalSnapshot ) ;
  throw new Exception ( "wrong type of message" ) ;
}
}


// option 1 
void verifyMetadata ( MessageMetadata metadata ) throws Exception {
  if ( metadata . getMessageMetadataType ( ) != MessageType . LOG_ENTRY_MESSAGE || metadata . getSnapshotTimestamp ( ) != srcGlobalSnapshot ) {
    log . error ( "Wrong message metadata {
}, expecting  type {
}
 snapshot {
}" , metadata , MessageType . LOG_ENTRY_MESSAGE , srcGlobalSnapshot ) ;
  throw new Exception ( "wrong type of message" ) ;
}
}


*************************this is the dividing line*****************************



/** Example 1 */

/** what is this part for? you are not checking throw statements. */

// option 0 
public void setPrice1 ( int price3 ) {
  if ( price3 < 0 || price3 > 10000 ) {
    throw new IllegalArgumentException ( "Invalid price: " + price3 ) ;
  }
  if ( true ) {
    assert price3 > 1000 ;
  }
}


// option 1 
public void setPrice1 ( int price3 ) {
  if ( price3 < 0 || price3 > 10000 ) {
    throw new IllegalArgumentException ( "Invalid price: " + price3 ) ;
  }
  if ( true ) {
    assert price3 > 1000 ;
  }
}


*************************this is the dividing line*****************************



/** Example 2 */

/** This will fail on `null` */

// option 0 
public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
  if ( text == null ) {
    return null ;
  }
  var repetitions = ( int ) args [ 1 ] . value ( ) ;
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}


// option 1 
public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
  if ( text == null ) {
    return null ;
  }
  var repetitions = ( int ) args [ 1 ] . value ( ) ;
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 3 */

/** Please use {} for every if/else/for/etc. block. */

// option 0 
public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) return ProjectBuildType . AUTO_TOOLS ;
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) return ProjectBuildType . MANAGED_MAKEFILE ;
  else return ProjectBuildType . OTHER ;
}


// option 1 
public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) return ProjectBuildType . AUTO_TOOLS ;
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) return ProjectBuildType . MANAGED_MAKEFILE ;
  else return ProjectBuildType . OTHER ;
}


*************************this is the dividing line*****************************



/** Example 4 */

/** public */

// option 0 
public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


// option 1 
public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 5 */

/** JavaDoc and method signature did not match. Please update the JavaDoc! */

// option 0 
private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


// option 1 
private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


*************************this is the dividing line*****************************



/** Example 6 */

/** For this it's better to do:  ``` threadsLocked.inc(); try { // other stuff } finally { threadsLocked.dec(); } ```  This way if an exception is thrown we still decrement the threadsLocked counter. */

// option 0 
public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
  threadsLocked . dec ( ) ;
}


// option 1 
public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
  threadsLocked . dec ( ) ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** looks like syntax typo  (`Add position checks in RunLenghtEncodedBlock` commit) */

// option 0 
public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    throw new IllegalArgumentException ( format ( "Value can not be an instance of a %s" , getClass ( ) . getName ( ) ) ) ;
  }
  if ( positionCount < 0 ) {
    throw new IllegalArgumentException ( "positionCount is negative" ) ;
  }
  this . value = value this . positionCount = positionCount ;
}


// option 1 
public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    throw new IllegalArgumentException ( format ( "Value can not be an instance of a %s" , getClass ( ) . getName ( ) ) ) ;
  }
  if ( positionCount < 0 ) {
    throw new IllegalArgumentException ( "positionCount is negative" ) ;
  }
  this . value = value this . positionCount = positionCount ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** I would prefer to use full words. For example `directoryAllow`. */

// option 0 
public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}


// option 1 
public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** Another extra space, can you plese cleanup all these similar things? There're a few others, some functions have spaces in parameters, some don't like `queryPos( APPBARDATA ABData )` vs. `dwABM.setValue(ShellAPI.ABM_QUERYPOS);`. Sorry to be a pest, just looks messy and inconsistent. */

// option 0 
private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


// option 1 
private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


// option 2 
private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


*************************this is the dividing line*****************************



/** Example 10 */

/** It is always expected that launch would be an instance of GdbLaunch, I don't think the check is required. */

// option 0 
protected Sequence getServicesSequence ( DsfSession session , ILaunch launch , IProgressMonitor rm ) {
  if ( launch instanceof GdbLaunch ) {
    return new ServicesLaunchSequence ( session , ( GdbLaunch ) launch , rm ) ;
  }
  return null ;
}


// option 1 
protected Sequence getServicesSequence ( DsfSession session , ILaunch launch , IProgressMonitor rm ) {
  if ( launch instanceof GdbLaunch ) {
    return new ServicesLaunchSequence ( session , ( GdbLaunch ) launch , rm ) ;
  }
  return null ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** `MiddlewareQueryException` is now a run time exception so it is not required to be part of the method signature. Not invalid to have it in signature, but Sonar will report it as a _Major_ category violation. */

// option 0 
public AdvanceResult advanceNursery ( final AdvancingNursery advanceInfo , final Workbook workbook ) throws RuleException , MiddlewareQueryException , FieldbookException {
  return this . namingConventionService . advanceNursery ( advanceInfo , workbook ) ;
}


// option 1 
public AdvanceResult advanceNursery ( final AdvancingNursery advanceInfo , final Workbook workbook ) throws RuleException , MiddlewareQueryException , FieldbookException {
  return this . namingConventionService . advanceNursery ( advanceInfo , workbook ) ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** Please make it non-static, similar to what is done with ManagementNetworkFinder */

// option 0 
public org . ovirt . engine . api . model . Cluster update ( org . ovirt . engine . api . model . Cluster incoming ) {
  MacPool macPool = incoming . getMacPool ( ) ;
  macPool . setId ( MacPoolIdByIdOrName . get ( macPool . getId ( ) , macPool . getName ( ) , this ) ) ;
  return performUpdate ( incoming , new QueryIdResolver < > ( VdcQueryType . GetClusterById , IdQueryParameters . class ) , VdcActionType . UpdateCluster , new UpdateParametersProvider ( ) ) ;
}


// option 1 
public org . ovirt . engine . api . model . Cluster update ( org . ovirt . engine . api . model . Cluster incoming ) {
  MacPool macPool = incoming . getMacPool ( ) ;
  macPool . setId ( MacPoolIdByIdOrName . get ( macPool . getId ( ) , macPool . getName ( ) , this ) ) ;
  return performUpdate ( incoming , new QueryIdResolver < > ( VdcQueryType . GetClusterById , IdQueryParameters . class ) , VdcActionType . UpdateCluster , new UpdateParametersProvider ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** I think it makes more sense to omit this assert in the expected exception cases? */

// option 0 
public void testReservedSkippableBeforeStreamIdentifier ( ) throws Exception {
  ByteBuf in = Unpooled . wrappedBuffer ( new byte [ ] {
    - 0x7f , 0x06 , 0x00 , 0x00 , 's' , 'n' , 'e' , 't' , 't' , 'y' }
    ) ;
    assertFalse ( channel . writeInbound ( in ) ) ;
  }
  

// option 1 
public void testReservedSkippableBeforeStreamIdentifier ( ) throws Exception {
  ByteBuf in = Unpooled . wrappedBuffer ( new byte [ ] {
    - 0x7f , 0x06 , 0x00 , 0x00 , 's' , 'n' , 'e' , 't' , 't' , 'y' }
    ) ;
    assertFalse ( channel . writeInbound ( in ) ) ;
  }
  

*************************this is the dividing line*****************************



/** Example 14 */

/** In the `get` method which calls `getChild` we use `property.getName()` instead of `field.getName().getPrefixedName()` as the key in the `children` map. Can you make this consistent so that we're sure there's no discrepancy between prefixed/unprefixed? */

// option 0 
public void set ( String name , Property property ) throws PropertyNotFoundException {
  Field field = getType ( ) . getField ( name ) ;
  if ( field == null ) {
    Property removedProperty = computeRemovedProperty ( name ) ;
    if ( removedProperty != null ) {
      removedProperty . set ( name , property ) ;
    }
    return ;
  }
  children . put ( field . getName ( ) . getPrefixedName ( ) , property ) ;
  setIsModified ( ) ;
}


// option 1 
public void set ( String name , Property property ) throws PropertyNotFoundException {
  Field field = getType ( ) . getField ( name ) ;
  if ( field == null ) {
    Property removedProperty = computeRemovedProperty ( name ) ;
    if ( removedProperty != null ) {
      removedProperty . set ( name , property ) ;
    }
    return ;
  }
  children . put ( field . getName ( ) . getPrefixedName ( ) , property ) ;
  setIsModified ( ) ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** `andCardinality(Container)` should be called here instead of `and(Container).getCardinality()` */

// option 0 
public int andCardinality ( Container x ) {
  if ( this . getCardinality ( ) == 0 ) return 0 ;
  else if ( x . getCardinality ( ) == 0 ) return 0 ;
  else {
    if ( x instanceof ArrayContainer ) return and ( ( ArrayContainer ) x ) . getCardinality ( ) ;
    else if ( x instanceof BitmapContainer ) return and ( ( BitmapContainer ) x ) . getCardinality ( ) ;
    return and ( ( RunContainer ) x ) . getCardinality ( ) ;
  }
}


// option 1 
public int andCardinality ( Container x ) {
  if ( this . getCardinality ( ) == 0 ) return 0 ;
  else if ( x . getCardinality ( ) == 0 ) return 0 ;
  else {
    if ( x instanceof ArrayContainer ) return and ( ( ArrayContainer ) x ) . getCardinality ( ) ;
    else if ( x instanceof BitmapContainer ) return and ( ( BitmapContainer ) x ) . getCardinality ( ) ;
    return and ( ( RunContainer ) x ) . getCardinality ( ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 16 */

/** public @Nullable String... */

// option 0 
public String getAttributeValue ( @ Nullable String name ) {
  return name ;
}


// option 1 
public String getAttributeValue ( @ Nullable String name ) {
  return name ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** This logic will obviously need updated once we change `this.cookiesToClear`. */

// option 0 
public void logout ( HttpServletRequest request , HttpServletResponse response , Authentication authentication ) {
  for ( Object cookie : cookiesToClear ) {
    Cookie realCookie = null ;
    if ( cookie instanceof String ) {
      realCookie = new Cookie ( ( String ) cookie , null ) ;
      String cookiePath = request . getContextPath ( ) + "/" ;
      realCookie . setPath ( cookiePath ) ;
      realCookie . setMaxAge ( 0 ) ;
    }
    else if ( cookie instanceof Cookie ) {
      realCookie = ( Cookie ) cookie ;
    }
    response . addCookie ( realCookie ) ;
  }
}


// option 1 
public void logout ( HttpServletRequest request , HttpServletResponse response , Authentication authentication ) {
  for ( Object cookie : cookiesToClear ) {
    Cookie realCookie = null ;
    if ( cookie instanceof String ) {
      realCookie = new Cookie ( ( String ) cookie , null ) ;
      String cookiePath = request . getContextPath ( ) + "/" ;
      realCookie . setPath ( cookiePath ) ;
      realCookie . setMaxAge ( 0 ) ;
    }
    else if ( cookie instanceof Cookie ) {
      realCookie = ( Cookie ) cookie ;
    }
    response . addCookie ( realCookie ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 18 */

/** won't this be a double-decrement? */

// option 0 
public void channelOpen ( ChannelHandlerContext ctx , ChannelStateEvent e ) throws Exception {
  if ( maxConnections > 0 ) {
    if ( numConnections . incrementAndGet ( ) > maxConnections ) {
      ctx . getChannel ( ) . close ( ) ;
      numConnections . decrementAndGet ( ) ;
      log . info ( "Accepted connection above limit ({
}
). Dropping." , maxConnections ) ;
    }
  }
  super . channelOpen ( ctx , e ) ;
}


// option 1 
public void channelOpen ( ChannelHandlerContext ctx , ChannelStateEvent e ) throws Exception {
  if ( maxConnections > 0 ) {
    if ( numConnections . incrementAndGet ( ) > maxConnections ) {
      ctx . getChannel ( ) . close ( ) ;
      numConnections . decrementAndGet ( ) ;
      log . info ( "Accepted connection above limit ({
}
). Dropping." , maxConnections ) ;
    }
  }
  super . channelOpen ( ctx , e ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** @qeesung: nit you can merge the above 2 lines as `checkNotNull` returns `channelClass`. */

// option 0 
public B channel ( Class < ? extends C > channelClass ) {
  ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


// option 1 
public B channel ( Class < ? extends C > channelClass ) {
  ObjectUtil . checkNotNull ( channelClass , "channelClass" ) ;
  return channelFactory ( new ReflectiveChannelFactory < C > ( channelClass ) ) ;
}


*************************this is the dividing line*****************************



