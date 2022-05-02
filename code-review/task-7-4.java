/** Example 0 */

/** ["This is a bug, the setter does nothing, use 'this'"] */
public void setVmBackup ( VmBackup value ) {
  this . vmBackup = value ;
}




==========================this is the dividing line=============================



/** Example 1 */

/** ['what is this part for? you are not checking throw statements.', 'what is this part for? you are not checking throw statements.'] */
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
  assert price3 > 1000 ;
}




==========================this is the dividing line=============================



/** Example 2 */

/** ['This will fail on `null`', 'This will fail on `null`'] */
public String evaluate ( TransactionContext txnCtx , Input < Object > [ ] args ) {
  assert args . length == 2 : "repeat takes exactly two arguments" ;
  var text = ( String ) args [ 0 ] . value ( ) ;
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
    return "" ;
  }
  var repetitions = ( int ) args [ 1 ] . value ( ) ;
  if ( repetitions <= 0 ) {
    return "" ;
  }
  else {
    return text . repeat ( repetitions ) ;
  }
}




==========================this is the dividing line=============================



/** Example 3 */

/** ['why is this public?'] */
private void setActionBarNotificationBarColor ( MaterialColor color ) {
  getSupportActionBar ( ) . setBackgroundDrawable ( new ColorDrawable ( color . toActionBarColor ( this ) ) ) ;
  if ( Build . VERSION . SDK_INT >= Build . VERSION_CODES . LOLLIPOP ) {
    getWindow ( ) . setStatusBarColor ( color . toStatusBarColor ( this ) ) ;
  }
}




==========================this is the dividing line=============================



/** Example 4 */

/** ['Please use {} for every if/else/for/etc. block.', 'Please use {} for every if/else/for/etc. block.'] */
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
  return ProjectBuildType . OTHER ;
}




==========================this is the dividing line=============================



/** Example 5 */

/** ["This isn't necessary."] */
protected long download ( T object , File outFile ) throws IOException {
  openObjectFunction . open ( object , outFile ) ;
  return outFile . length ( ) ;
}




==========================this is the dividing line=============================



/** Example 6 */

/** ["what's the point of catching and then throwing the same exception type?"] */
private Collection < VCastResult > getResultFiles ( VCastDataStore dataStore ) {
  Collection < VCastResult > results = null ;
  results = dataStore . getAllResults ( ) ;
  return results ;
}




==========================this is the dividing line=============================



/** Example 7 */

/** ['public', 'public'] */
public PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}




private PinotQueryGeneratorContext visitFilter ( FilterNode node , PinotQueryGeneratorContext context ) {
  context = node . getSource ( ) . accept ( this , context ) ;
  requireNonNull ( context , "context is null" ) ;
  LinkedHashMap < VariableReferenceExpression , Selection > selections = context . getSelections ( ) ;
  String filter = node . getPredicate ( ) . accept ( pinotFilterExpressionConverter , ( var ) -> selections . get ( var ) ) . getDefinition ( ) ;
  return context . withFilter ( filter ) . withOutputColumns ( node . getOutputVariables ( ) ) ;
}




==========================this is the dividing line=============================



/** Example 8 */

/** ['JavaDoc and method signature did not match. Please update the JavaDoc!', 'JavaDoc and method signature did not match. Please update the JavaDoc!'] */
private Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}




public Space ( String enumeratedValue ) {
  this . enumeratedValue = enumeratedValue ;
}




==========================this is the dividing line=============================



/** Example 9 */

/** ['still requires fix: domain.getstorage_domain_type() == type'] */
public Guid getStorageDomainIdForPoolByType ( Guid pool , StorageDomainType type ) {
  Guid returnValue = Guid . Empty ;
  List < storage_domains > domains = getAllForStoragePool ( pool ) ;
  for ( storage_domains domain : domains ) {
    if ( domain . getstorage_domain_type ( ) == type ) {
      returnValue = domain . getId ( ) ;
      break ;
    }
  }
  return returnValue ;
}




==========================this is the dividing line=============================



/** Example 10 */

/** ["For this it's better to do:  ``` threadsLocked.inc(); try { // other stuff } finally { threadsLocked.dec(); } ```  This way if an exception is thrown we still decrement the threadsLocked counter.", "For this it's better to do:  ``` threadsLocked.inc(); try { // other stuff } finally { threadsLocked.dec(); } ```  This way if an exception is thrown we still decrement the threadsLocked counter."] */
public void lock ( T id ) throws InterruptedException {
  threadsLocked . inc ( ) ;
  idsLocked . update ( 1 ) ;
  lockInternal ( id ) ;
}




public void lock ( T id ) throws InterruptedException {
  try {
    threadsLocked . inc ( ) ;
    idsLocked . update ( 1 ) ;
    lockInternal ( id ) ;
  }
  finally {
    threadsLocked . dec ( ) ;
  }
}




==========================this is the dividing line=============================



/** Example 11 */

/** ['looks like syntax typo  (`Add position checks in RunLenghtEncodedBlock` commit)', 'looks like syntax typo  (`Add position checks in RunLenghtEncodedBlock` commit)'] */
public RunLengthEncodedBlock ( Block value , int positionCount ) {
  requireNonNull ( value , "value is null" ) ;
  if ( value . getPositionCount ( ) != 1 ) {
    throw new IllegalArgumentException ( format ( "Expected value to contain a single position but has %s positions" , value . getPositionCount ( ) ) ) ;
  }
  if ( value instanceof RunLengthEncodedBlock ) {
    throw new IllegalArgumentException ( format ( "Value can not be an instance of a %s" , getClass ( ) . getName ( ) ) ) ;
  }
  this . value = value ;
  this . positionCount = positionCount ;
}




public RunLengthEncodedBlock ( Block value , int positionCount ) {
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




==========================this is the dividing line=============================



/** Example 12 */

/** ['Is the idea to always copy because the request could be used again in a Retry (independent of a speculative execution being executed?)'] */
public Message . Request request ( ) {
  return callback . request ( ) ;
}




==========================this is the dividing line=============================



/** Example 13 */

/** ['I would prefer to use full words. For example `directoryAllow`.', 'I would prefer to use full words. For example `directoryAllow`.'] */
public void init ( FilterConfig filterConfig ) throws ServletException {
  directoryAllow = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}




public void init ( FilterConfig filterConfig ) throws ServletException {
  dirAllowed = Context . getConfig ( ) . getBoolean ( "media.dirAllowed" ) ;
}




==========================this is the dividing line=============================



/** Example 14 */

/** ['This is backwards, you want the expected condition to be here.'] */
public ExtentBufferedCompositePattern ( Extent extent , Pattern ... patterns ) {
  super ( extent ) ;
  this . patterns = patterns ;
}




==========================this is the dividing line=============================



/** Example 15 */

/** ["It's tangential, but `IllegalArgumentException` seems more reasonable."] */
public boolean isValid ( Object [ ] value , ConstraintValidatorContext context ) {
  if ( value . length != 3 ) {
    throw new IllegalArgumentException ( "Unexpected method signature" ) ;
  }
  if ( value [ 1 ] == null || value [ 2 ] == null ) {
    return true ;
  }
  return ( ( Date ) value [ 1 ] ) . before ( ( Date ) value [ 2 ] ) ;
}




==========================this is the dividing line=============================



/** Example 16 */

/** ['maybe check for start of file or newline also?'] */
private static boolean monoNativeFailure ( Either < Utils . CommandResult > result ) {
  if ( result == null || ! result . isSuccess ( ) ) {
    return true ;
  }
  else {
    Utils . CommandResult commandResult = result . get ( ) ;
    return monoNativeFailure ( commandResult . output ) || monoNativeFailure ( commandResult . error ) ;
  }
}




==========================this is the dividing line=============================



/** Example 17 */

/** ["Another extra space, can you plese cleanup all these similar things? There're a few others, some functions have spaces in parameters, some don't like `queryPos( APPBARDATA ABData )` vs. `dwABM.setValue(ShellAPI.ABM_QUERYPOS);`. Sorry to be a pest, just looks messy and inconsistent.", "Another extra space, can you plese cleanup all these similar things? There're a few others, some functions have spaces in parameters, some don't like `queryPos( APPBARDATA ABData )` vs. `dwABM.setValue(ShellAPI.ABM_QUERYPOS);`. Sorry to be a pest, just looks messy and inconsistent.", "Another extra space, can you plese cleanup all these similar things? There're a few others, some functions have spaces in parameters, some don't like `queryPos( APPBARDATA ABData )` vs. `dwABM.setValue(ShellAPI.ABM_QUERYPOS);`. Sorry to be a pest, just looks messy and inconsistent."] */




private void removeAppBar ( ) {
  APPBARDATA data = new APPBARDATA . ByReference ( ) ;
  data . cbSize . setValue ( data . size ( ) ) ;
  data . cbSize . setValue ( data . size ( ) ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( new DWORD ( ShellAPI . ABM_REMOVE ) , data ) ;
  assertNotNull ( result ) ;
}




private void removeAppBar ( ) {
  APPBARDATA ABData = new APPBARDATA . ByReference ( ) ;
  ABData . cbSize . setValue ( ABData . size ( ) ) ;
  dwABM . setValue ( ShellAPI . ABM_REMOVE ) ;
  UINT_PTR result = Shell32 . INSTANCE . SHAppBarMessage ( dwABM , ABData ) ;
  assertNotNull ( result ) ;
}




==========================this is the dividing line=============================



/** Example 18 */

/** ['stray parens  Also, use the standard couldMatch format used through Denizen, not this weird inline thing.'] */
public boolean couldMatch ( ScriptPath path ) {
  return path . eventLower . startsWith ( "mythicmob" ) && path . eventArgLowerAt ( 2 ) . equals ( "spawns" ) ;
}




==========================this is the dividing line=============================



/** Example 19 */

/** ["Why does it resolve controller home? is it better to name it with HomeDir?  It's because this class not only called from controller but agent."] */
void init ( ) {
  this . initAccessOfDirectories ( ) ;
  this . initAccessOfHosts ( ) ;
}




==========================this is the dividing line=============================



