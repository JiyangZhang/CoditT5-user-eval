/** Example 0 */

/** ['I think LIBRARY are no more used'] */
private static Set < String > getRootQualifiers ( ResourceTypes resourceTypes ) {
  return resourceTypes . getRoots ( ) . stream ( ) . map ( ResourceType :: getQualifier ) . filter ( q -> ! DEPRECATED_QUALIFIERS . contains ( q ) ) . collect ( Collectors . toCollection ( TreeSet :: new ) ) ;
}




==========================this is the dividing line=============================



/** Example 1 */

/** ['Consider using `System.lineSeparator()` instead.'] */
public RuntimeFilterManager ( QueryWorkUnit workUnit , DrillbitContext drillbitContext ) {
  this . rootWrapper = workUnit . getRootWrapper ( ) ;
  this . drillbitContext = drillbitContext ;
  lineSeparator = System . lineSeparator ( ) ;
}




==========================this is the dividing line=============================



/** Example 2 */

/** ['ChangeDetailEditor_EGerriTipValue has no more arguments, should we just use it directly , no need to set the arguments ?', 'ChangeDetailEditor_EGerriTipValue has no more arguments, should we just use it directly , no need to set the arguments ?'] */
private void activateMarkers ( ) {
  if ( ! fGerritClient . getRepository ( ) . getServerInfo ( ) . isAnonymous ( ) ) {
    String value = NLS . bind ( Messages . ChangeDetailEditor_EGerriTipValue , fChangeInfo . getUserSelectedRevision ( ) . get_number ( ) ) ;
    UIUtils . showDialogTip ( MARKERS_KEY , headerSection . getShell ( ) , Messages . EGerriTip , value ) ;
  }
}




private void activateMarkers ( ) {
  if ( ! fGerritClient . getRepository ( ) . getServerInfo ( ) . isAnonymous ( ) ) {
    String value = ChangeDetailEditor_EGerriTipValue . bind ( fChangeInfo . getUserSelectedRevision ( ) . get_number ( ) ) ;
    UIUtils . showDialogTip ( MARKERS_KEY , headerSection . getShell ( ) , Messages . EGerriTip , value ) ;
  }
}




==========================this is the dividing line=============================



/** Example 3 */

/** ['should be called `resource`', 'should be called `resource`'] */
public void testCreate ( ) throws StripeException {
  final Order order = Order . create ( new HashMap < String , Object > ( ) ) ;
  assertNotNull ( order ) ;
  verifyRequest ( APIResource . RequestMethod . POST , "/v1/orders" , params ) ;
}




public void testCreate ( ) throws StripeException {
  final Map < String , Object > params = new HashMap < String , Object > ( ) ;
  params . put ( "currency" , "usd" ) ;
  final Order order = Order . create ( params ) ;
  assertNotNull ( order ) ;
  verifyRequest ( APIResource . RequestMethod . POST , "/v1/orders" , params ) ;
}




==========================this is the dividing line=============================



/** Example 4 */

/** ['Just `return rule`.'] */
private FirewallRule findById ( List < FirewallRule > collection , String id ) {
  for ( FirewallRule rule : collection ) {
    if ( rule . id ( ) . equals ( id ) ) {
      return rule ;
    }
  }
  return null ;
}




==========================this is the dividing line=============================



/** Example 5 */

/** ['Should probably use a Set<String> instead of a List<String> so that the intention of the code is clear by first glance.', 'Should probably use a Set<String> instead of a List<String> so that the intention of the code is clear by first glance.'] */
private void addDownload ( String download ) {
  if ( ! downloads . contains ( download ) ) {
    downloads . add ( download ) ;
  }
}




public void addDownload ( String download ) {
  if ( ! downloads . contains ( download ) ) {
    downloads . add ( download ) ;
  }
}




==========================this is the dividing line=============================



/** Example 6 */

/** ['Should this be 1 or null instead of 0?', 'Should this be 1 or null instead of 0?'] */
public void copyDetailsFromOtherCuObjectCodeActivationGlobal ( CuObjectCodeActivationGlobal oldGlobal ) {
  for ( CuObjectCodeGlobalDetail oldDetail : oldGlobal . getObjectCodeGlobalDetails ( ) ) {
    CuObjectCodeGlobalDetail newDetail = ( CuObjectCodeGlobalDetail ) ObjectUtils . deepCopy ( oldDetail ) ;
    newDetail . setObjectId ( null ) ;
    newDetail . setDocumentNumber ( getDocumentNumber ( ) ) ;
    newDetail . setVersionNumber ( 1 ) ;
    getObjectCodeGlobalDetails ( ) . add ( newDetail ) ;
  }
}




public void copyDetailsFromOtherCuObjectCodeActivationGlobal ( CuObjectCodeActivationGlobal oldGlobal ) {
  for ( CuObjectCodeGlobalDetail oldDetail : oldGlobal . getObjectCodeGlobalDetails ( ) ) {
    CuObjectCodeGlobalDetail newDetail = ( CuObjectCodeGlobalDetail ) ObjectUtils . deepCopy ( oldDetail ) ;
    newDetail . setObjectId ( null ) ;
    newDetail . setDocumentNumber ( getDocumentNumber ( ) ) ;
    newDetail . setVersionNumber ( null ) ;
    getObjectCodeGlobalDetails ( ) . add ( newDetail ) ;
  }
}




==========================this is the dividing line=============================



/** Example 7 */

/** ['You can not be sure that the value is present in the local storage (see the storeVncData). Please wrap the ...valueOf(...) by try-catch'] */
private void loadVncData ( HasConsoleModel model , KeyMaker keyMaker ) {
  if ( ! ( model . getDefaultConsoleModel ( ) instanceof VncConsoleModel ) ) {
    return ;
  }
  model . setSelectedProtocol ( ConsoleProtocol . VNC ) ;
  asVncConsoleModel ( model ) . setVncImplementation ( VncConsoleModel . ClientConsoleMode . valueOf ( clientStorage . getLocalItem ( keyMaker . make ( VNC_CLIENT_MODE ) ) ) ) ;
}




==========================this is the dividing line=============================



/** Example 8 */

/** ['These arguments can all go on the same line', 'These arguments can all go on the same line'] */
private RuleApplication applyRule ( ) {
  SymbolAllocator symbolAllocator = new SymbolAllocator ( symbols ) ;
  Memo memo = new Memo ( idAllocator , plan ) ;
  Lookup lookup = Lookup . from ( memo :: resolve ) ;
  Optional < PlanNode > result = inTransaction ( session -> rule . apply ( memo . getNode ( memo . getRootGroup ( ) ) , lookup , idAllocator , symbolAllocator , session ) ) ;
  return new RuleApplication ( memo , lookup , symbolAllocator . getTypes ( ) , result ) ;
}




private RuleApplication applyRule ( ) {
  Memo memo = new Memo ( idAllocator , plan ) ;
  Lookup lookup = Lookup . from ( memo :: resolve ) ;
  Optional < PlanNode > result = inTransaction ( session -> rule . apply ( memo . getNode ( memo . getRootGroup ( ) ) , lookup , idAllocator , symbolAllocator , session ) ) ;
  return new RuleApplication ( memo , lookup , symbolAllocator . getTypes ( ) , result ) ;
}




==========================this is the dividing line=============================



/** Example 9 */

/** ['Why the expected output was changed?', 'Why the expected output was changed?'] */
public void testPushDownArray ( ) throws Exception {
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 1" , 3 , 2 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 100" , 0 , 1 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] <> 1" , 8 , 7 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] > 20" , 5 , 4 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] between 10 and 20" , 5 , 5 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[4] = 15" , 1 , 3 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[3] is not null" , 11 , 6 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[4] is null" , 11 , 7 ) ;
}




public void testPushDownArray ( ) throws Exception {
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 1" , 3 , 2 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 100" , 0 , 1 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] <> 1" , 8 , 7 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] <> 1" , 8 , 7 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] > 20" , 5 , 4 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[4] = 15" , 1 , 3 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[3] is null" ) ;
}




==========================this is the dividing line=============================



/** Example 10 */

/** ['This logic should be in the default implementation.', 'This logic should be in the default implementation.'] */
default Direction getBubbleElevatorDirection ( ) {
  Block block = this . getBlockState ( ) . getBlock ( ) ;
  if ( block == Blocks . BUBBLE_COLUMN ) {
    return this . getBlockState ( ) . get ( BubbleColumnBlock . DRAG ) ? Direction . DOWN : Direction . UP ;
  }
  return block . getBubbleElevatorDirection ( this . getBlockState ( ) ) ;
}




default Direction getBubbleElevatorDirection ( ) {
  Block block = this . getBlockState ( ) . getBlock ( ) ;
  return block . getBubbleElevatorDirection ( this . getBlockState ( ) ) ;
}




==========================this is the dividing line=============================



/** Example 11 */

/** ['Why access this method staticly?', 'Why access this method staticly?'] */
public static void testSystemPropertiesOverrideConfigurationValues ( ) {
  final String keyName = CoreConfig . MAX_CASSANDRA_CONNECTIONS . toString ( ) ;
  Configuration config = Configuration . getInstance ( ) ;
  try {
    Assert . assertEquals ( "75" , config . getStringProperty ( CoreConfig . MAX_CASSANDRA_CONNECTIONS ) ) ;
    System . setProperty ( keyName , "something else" ) ;
    Assert . assertEquals ( "something else" , config . getStringProperty ( CoreConfig . MAX_CASSANDRA_CONNECTIONS ) ) ;
  }
  finally {
    System . clearProperty ( keyName ) ;
    Configuration . clearProperty ( keyName ) ;
  }
}




public void testSystemPropertiesOverrideConfigurationValues ( ) {
  final String keyName = CoreConfig . MAX_CASSANDRA_CONNECTIONS . toString ( ) ;
  Configuration config = Configuration . getInstance ( ) ;
  try {
    Assert . assertEquals ( "75" , config . getStringProperty ( CoreConfig . MAX_CASSANDRA_CONNECTIONS ) ) ;
    System . setProperty ( keyName , "something else" ) ;
    Assert . assertEquals ( "something else" , config . getStringProperty ( CoreConfig . MAX_CASSANDRA_CONNECTIONS ) ) ;
  }
  finally {
    System . clearProperty ( keyName ) ;
    Configuration . clearProperty ( keyName ) ;
  }
}




==========================this is the dividing line=============================



/** Example 12 */

/** ['You can set it on a plain field, no need for atomics:  ``` java this.inner = inner; o.onSubscribe(this); inner.request(Long.MAX_VALUE); ```', 'You can set it on a plain field, no need for atomics:  ``` java this.inner = inner; o.onSubscribe(this); inner.request(Long.MAX_VALUE); ```'] */
public void onSubscribe ( Subscription inner ) {
  SubscriptionHelper . setOnce ( this , inner ) ;
  o . onSubscribe ( this ) ;
  inner . request ( Long . MAX_VALUE ) ;
}




public void onSubscribe ( Subscription inner ) {
  o . onSubscribe ( this ) ;
  inner . request ( Long . MAX_VALUE ) ;
}




==========================this is the dividing line=============================



/** Example 13 */

/** ['`true` -> `false` ?'] */
public WebElement forElementPresent ( By by ) {
  changeImplicitWait ( 250 , TimeUnit . MILLISECONDS ) ;
  try {
    return wait . until ( ExpectedConditions . presenceOfElementLocated ( by ) ) ;
  }
  catch ( TimeoutException e ) {
    PageObjectLogging . log ( ELEMENT_PRESENT_MESSAGE , String . format ( ELEMENT_PRESENT_ERROR_FORMAT , by . toString ( ) ) , false ) ;
    throw e ;
  }
  finally {
    restoreDeaultImplicitWait ( ) ;
  }
}




==========================this is the dividing line=============================



/** Example 14 */

/** ['could be simplified.'] */
public boolean accept ( Issue issue ) {
  return issueShouldNotBeReported ( issue , excludedLinesByRule ( ) ) ;
}




==========================this is the dividing line=============================



/** Example 15 */

/** ['this method should be changed to private'] */
private HashMap < String , ArrayList < Order >> getBuyOrders ( ) {
  return buyOrders ;
}




==========================this is the dividing line=============================



/** Example 16 */

/** ["There's no need to make these public, even if the package is internal.", "There's no need to make these public, even if the package is internal."] */
private static Color getSystemForegroundColor ( Display display ) {
  ColorRegistry colorRegistry = JFaceResources . getColorRegistry ( ) ;
  Color foreground = colorRegistry . get ( JFacePreferences . INFORMATION_FOREGROUND_COLOR ) ;
  if ( foreground == null ) {
    return JFaceColors . getInformationViewerForegroundColor ( display ) ;
  }
  return foreground ;
}




static Color getSystemForegroundColor ( Display display ) {
  ColorRegistry colorRegistry = JFaceResources . getColorRegistry ( ) ;
  Color foreground = colorRegistry . get ( JFacePreferences . INFORMATION_FOREGROUND_COLOR ) ;
  if ( foreground == null ) {
    return JFaceColors . getInformationViewerForegroundColor ( display ) ;
  }
  return foreground ;
}




==========================this is the dividing line=============================



/** Example 17 */

/** ['You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ```', 'You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ```'] */
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



/** Example 18 */

/** ['This method should be synchronized, otherwise, chances are eventually there might be a race condition for setting fAttribute.'] */
public synchronized String getAttribute ( ) {
  if ( fAttribute . equals ( NOT_SET ) ) {
    setAttribute ( ) ;
  }
  return fAttribute ;
}




==========================this is the dividing line=============================



/** Example 19 */

/** ['![BLOCKER](https://sonarsource.github.io/sonar-github/severity-blocker.png \'Severity: BLOCKER\') Move this "start" call to another method. [![rule](https://sonarsource.github.io/sonar-github/rule.png)](https://sonarcloud.io/coding_rules#rule_key=squid%3AS2693)'] */
public DotRunnableThread ( final List < DotRunnable > allListeners ) {
  this . listeners = getListeners ( allListeners ) ;
  this . flushers = getFlushers ( allListeners ) ;
}




==========================this is the dividing line=============================



