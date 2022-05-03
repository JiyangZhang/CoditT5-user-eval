/** Example 0 */

/** maybe you need a specific Exception Type */

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

void verifyMetadata ( MessageMetadata metadata ) throws Exception {
  if ( metadata . getMessageMetadataType ( ) != MessageType . LOG_ENTRY_MESSAGE ) {
    log . error ( "Wrong message metadata {
}, expecting  type {
}
 snapshot {
}" , metadata , MessageType . LOG_ENTRY_MESSAGE , srcGlobalSnapshot ) ;
  throw new Exception ( "wrong type of message" ) ;
}
}


void verifyMetadata ( MessageMetadata metadata ) throws Exception {
  if ( metadata . getMessageMetadataType ( ) != MessageType . LOG_ENTRY_MESSAGE ) {
    log . error ( "Wrong message metadata {
}, expecting  type {
}
 snapshot {
}" , metadata , MessageType . LOG_ENTRY_MESSAGE , srcGlobalSnapshot ) ;
  throw new Exception ( "wrong type of message" ) ;
}
}


void verifyMetadata ( MessageMetadata metadata ) throws Exception {
  if ( metadata . getMessageMetadataType ( ) != MessageType . LOG_ENTRY_MESSAGE ) {
    log . error ( "Wrong message metadata {
}, expecting  type {
}
 snapshot {
}" , metadata , MessageType . LOG_ENTRY_MESSAGE , srcGlobalSnapshot ) ;
  throw new Exception ( "wrong type of message" ) ;
}
}


*************************this is the dividing line*****************************



/** Example 2 */

/** This will fail on `null` */

public void setPrice1 ( int price3 ) {
  if ( price3 < 0 || price3 > 10000 ) {
    throw new IllegalArgumentException ( "Invalid price: " + price3 ) ;
  }
  if ( true ) {
    assert price3 > 1000 ;
  }
}


public void setPrice1 ( int price3 ) {
  if ( price3 < 0 || price3 > 10000 ) {
    throw new IllegalArgumentException ( "Invalid price: " + price3 ) ;
  }
  if ( true ) {
    assert price3 > 1000 ;
  }
}


public void setPrice1 ( int price3 ) {
  if ( price3 < 0 || price3 > 10000 ) {
    throw new IllegalArgumentException ( "Invalid price: " + price3 ) ;
  }
  if ( true ) {
    assert price3 > 1000 ;
  }
}


*************************this is the dividing line*****************************



/** Example 3 */

/** Please use {} for every if/else/for/etc. block. */

public void setPrice1 ( int price3 ) {
  if ( true ) {
    assert price3 > 1000 ;
  }
}


public void setPrice1 ( int price3 ) {
  if ( true ) {
    assert price3 > 1000 ;
  }
}


public void setPrice1 ( int price3 ) {
  if ( true ) {
    assert price3 > 1000 ;
  }
}


*************************this is the dividing line*****************************



/** Example 4 */

/** public */

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



/** Example 5 */

/** JavaDoc and method signature did not match. Please update the JavaDoc! */

public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
  var repetitions = ( Integer ) args [ 1 ] . value ( ) ;
  if ( text == null || repetitions == null ) {
    return null ;
  }
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}


public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
  var repetitions = ( Integer ) args [ 1 ] . value ( ) ;
  if ( text == null || repetitions == null ) {
    return null ;
  }
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}


public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
  var repetitions = ( Integer ) args [ 1 ] . value ( ) ;
  if ( text == null || repetitions == null ) {
    return null ;
  }
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 6 */

/** For this it's better to do:  ``` threadsLocked.inc(); try { // other stuff } finally { threadsLocked.dec(); } ```  This way if an exception is thrown we still decrement the threadsLocked counter. */

public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) return ProjectBuildType . AUTO_TOOLS ;
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) return ProjectBuildType . MANAGED_MAKEFILE ;
  else return ProjectBuildType . OTHER ;
}


public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) return ProjectBuildType . AUTO_TOOLS ;
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) return ProjectBuildType . MANAGED_MAKEFILE ;
  else return ProjectBuildType . OTHER ;
}


public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) return ProjectBuildType . AUTO_TOOLS ;
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) return ProjectBuildType . MANAGED_MAKEFILE ;
  else return ProjectBuildType . OTHER ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** looks like syntax typo  (`Add position checks in RunLenghtEncodedBlock` commit) */

public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) {
    return ProjectBuildType . AUTO_TOOLS ;
  }
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) {
    return ProjectBuildType . MANAGED_MAKEFILE ;
  }
  else {
    return ProjectBuildType . OTHER ;
  }
}


public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) {
    return ProjectBuildType . AUTO_TOOLS ;
  }
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) {
    return ProjectBuildType . MANAGED_MAKEFILE ;
  }
  else {
    return ProjectBuildType . OTHER ;
  }
}


public static ProjectBuildType getProjectType ( IProject project ) {
  if ( isAutoTools ( project ) ) {
    return ProjectBuildType . AUTO_TOOLS ;
  }
  IConfiguration defaultConfiguration = helper_getActiveConfiguration ( project ) ;
  IBuilder builder = defaultConfiguration . getBuilder ( ) ;
  Boolean projIsManaged = builder . isManagedBuildOn ( ) ;
  if ( projIsManaged ) {
    return ProjectBuildType . MANAGED_MAKEFILE ;
  }
  else {
    return ProjectBuildType . OTHER ;
  }
}


*************************this is the dividing line*****************************



/** Example 8 */

/** I would prefer to use full words. For example `directoryAllow`. */

public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** Another extra space, can you plese cleanup all these similar things? There're a few others, some functions have spaces in parameters, some don't like `queryPos( APPBARDATA ABData )` vs. `dwABM.setValue(ShellAPI.ABM_QUERYPOS);`. Sorry to be a pest, just looks messy and inconsistent. */

public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , selections :: get ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , selections :: get ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , selections :: get ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , selections :: get ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}


*************************this is the dividing line*****************************



/** Example 10 */

/** It is always expected that launch would be an instance of GdbLaunch, I don't think the check is required. */

private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** `MiddlewareQueryException` is now a run time exception so it is not required to be part of the method signature. Not invalid to have it in signature, but Sonar will report it as a _Major_ category violation. */

Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** Please make it non-static, similar to what is done with ManagementNetworkFinder */

public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
  threadsLocked . dec ( ) ;
}


public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
  threadsLocked . dec ( ) ;
}


public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
  threadsLocked . dec ( ) ;
}


*************************this is the dividing line*****************************



/** Example 13 */

/** I think it makes more sense to omit this assert in the expected exception cases? */

public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  try {
    idsLocked . update ( 1 ) ;
    lockInternal ( id ) ;
  }
  finally {
    threadsLocked . dec ( ) ;
  }
}


public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  try {
    idsLocked . update ( 1 ) ;
    lockInternal ( id ) ;
  }
  finally {
    threadsLocked . dec ( ) ;
  }
}


public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  try {
    idsLocked . update ( 1 ) ;
    lockInternal ( id ) ;
  }
  finally {
    threadsLocked . dec ( ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 14 */

/** In the `get` method which calls `getChild` we use `property.getName()` instead of `field.getName().getPrefixedName()` as the key in the `children` map. Can you make this consistent so that we're sure there's no discrepancy between prefixed/unprefixed? */

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



/** Example 15 */

/** `andCardinality(Container)` should be called here instead of `and(Container).getCardinality()` */

public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    this . value = ( ( RunLengthEncodedBlock ) value ) . getValue ( ) ;
  }
  else {
    this . value = value ;
  }
  if ( positionCount < 0 ) {
    throw new IllegalArgumentException ( "positionCount is negative" ) ;
  }
  this . positionCount = positionCount ;
}


public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    this . value = ( ( RunLengthEncodedBlock ) value ) . getValue ( ) ;
  }
  else {
    this . value = value ;
  }
  if ( positionCount < 0 ) {
    throw new IllegalArgumentException ( "positionCount is negative" ) ;
  }
  this . positionCount = positionCount ;
}


public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    this . value = ( ( RunLengthEncodedBlock ) value ) . getValue ( ) ;
  }
  else {
    this . value = value ;
  }
  if ( positionCount < 0 ) {
    throw new IllegalArgumentException ( "positionCount is negative" ) ;
  }
  this . positionCount = positionCount ;
}


*************************this is the dividing line*****************************



/** Example 16 */

/** public @Nullable String... */

public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}


public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}


public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** This logic will obviously need updated once we change `this.cookiesToClear`. */

public void init ( FilterConfig filterConfig ) throws ServletException {
}


public void init ( FilterConfig filterConfig ) throws ServletException {
}


public void init ( FilterConfig filterConfig ) throws ServletException {
}


*************************this is the dividing line*****************************



/** Example 18 */

/** won't this be a double-decrement? */

private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


private void removeAppBar ( ) {
  DWORD dwABM = new DWORD ( ) ;
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** @qeesung: nit you can merge the above 2 lines as `checkNotNull` returns `channelClass`. */

private void removeAppBar ( ) {
  APPBARDATA data = new APPBARDATA . ByReference ( ) ;
  data . cbSize . setValue ( data . size ( ) ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( new DWORD ( ShellAPI . ABM_REMOVE ) , data ) ;
  assertNotNull ( result ) ;
}


private void removeAppBar ( ) {
  APPBARDATA data = new APPBARDATA . ByReference ( ) ;
  data . cbSize . setValue ( data . size ( ) ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( new DWORD ( ShellAPI . ABM_REMOVE ) , data ) ;
  assertNotNull ( result ) ;
}


private void removeAppBar ( ) {
  APPBARDATA data = new APPBARDATA . ByReference ( ) ;
  data . cbSize . setValue ( data . size ( ) ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( new DWORD ( ShellAPI . ABM_REMOVE ) , data ) ;
  assertNotNull ( result ) ;
}


*************************this is the dividing line*****************************



