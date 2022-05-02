/** Example 0 */

/** ['ChangeDetailEditor_EGerriTipValue has no more arguments, should we just use it directly , no need to set the arguments ?', 'ChangeDetailEditor_EGerriTipValue has no more arguments, should we just use it directly , no need to set the arguments ?'] */
private void activateMarkers ( ) {
  if ( ! fGerritClient . getRepository ( ) . getServerInfo ( ) . isAnonymous ( ) ) {
    String value = NLS . bind ( Messages . ChangeDetailEditor_EGerriTipValue , fChangeInfo . getUserSelectedRevision ( ) . get_number ( ) ) ;
    UIUtils . showDialogTip ( MARKERS_KEY , headerSection . getShell ( ) , Messages . EGerriTip , value ) ;
  }
}




private void activateMarkers ( ) {
  if ( ! fGerritClient . getRepository ( ) . getServerInfo ( ) . isAnonymous ( ) ) {
    String value = NLS . bind ( Messages . ChangeDetailEditor_EGerriTipValue , fChangeInfo . getUserSelectedRevision ( ) . get_number ( ) ) ;
    UIUtils . showDialogTip ( MARKERS_KEY , headerSection . getShell ( ) , Messages . EGerriTip , value ) ;
  }
}




*************************this is the dividing line*****************************



/** Example 1 */

/** ['should be called `resource`', 'should be called `resource`'] */
public void testCreate ( ) throws StripeException {
  Map < String , Object > params = new HashMap < String , Object > ( ) ;
  params . put ( "currency" , "usd" ) ;
  final Order order = Order . create ( params ) ;
  assertNotNull ( order ) ;
  verifyRequest ( APIResource . RequestMethod . POST , "/v1/orders" , params ) ;
}




public void testCreate ( ) throws StripeException {
  Map < String , Object > params = new HashMap < String , Object > ( ) ;
  params . put ( "currency" , "usd" ) ;
  final Order order = Order . create ( params ) ;
  assertNotNull ( order ) ;
  verifyRequest ( APIResource . RequestMethod . POST , "/v1/orders" , params ) ;
}




*************************this is the dividing line*****************************



/** Example 2 */

/** ['Should probably use a Set<String> instead of a List<String> so that the intention of the code is clear by first glance.', 'Should probably use a Set<String> instead of a List<String> so that the intention of the code is clear by first glance.'] */
public void addDownload ( String download ) {
  if ( ! downloads . contains ( download ) ) {
    downloads . add ( download ) ;
  }
}




public void addDownload ( String download ) {
  if ( ! downloads . contains ( download ) ) {
    downloads . add ( download ) ;
  }
}




*************************this is the dividing line*****************************



/** Example 3 */

/** ['Should this be 1 or null instead of 0?', 'Should this be 1 or null instead of 0?'] */
public void copyDetailsFromOtherCuObjectCodeActivationGlobal ( CuObjectCodeActivationGlobal oldGlobal ) {
  for ( CuObjectCodeGlobalDetail oldDetail : oldGlobal . getObjectCodeGlobalDetails ( ) ) {
    CuObjectCodeGlobalDetail newDetail = ( CuObjectCodeGlobalDetail ) ObjectUtils . deepCopy ( oldDetail ) ;
    newDetail . setObjectId ( null ) ;
    newDetail . setDocumentNumber ( getDocumentNumber ( ) ) ;
    newDetail . setVersionNumber ( new Long ( 0 ) ) ;
    getObjectCodeGlobalDetails ( ) . add ( newDetail ) ;
  }
}




public void copyDetailsFromOtherCuObjectCodeActivationGlobal ( CuObjectCodeActivationGlobal oldGlobal ) {
  for ( CuObjectCodeGlobalDetail oldDetail : oldGlobal . getObjectCodeGlobalDetails ( ) ) {
    CuObjectCodeGlobalDetail newDetail = ( CuObjectCodeGlobalDetail ) ObjectUtils . deepCopy ( oldDetail ) ;
    newDetail . setObjectId ( null ) ;
    newDetail . setDocumentNumber ( getDocumentNumber ( ) ) ;
    newDetail . setVersionNumber ( new Long ( 0 ) ) ;
    getObjectCodeGlobalDetails ( ) . add ( newDetail ) ;
  }
}




*************************this is the dividing line*****************************



/** Example 4 */

/** ['These arguments can all go on the same line', 'These arguments can all go on the same line'] */
private RuleApplication applyRule ( ) {
  SymbolAllocator symbolAllocator = new SymbolAllocator ( symbols ) ;
  Memo memo = new Memo ( idAllocator , plan ) ;
  Lookup lookup = Lookup . from ( memo :: resolve ) ;
  Optional < PlanNode > result = inTransaction ( session -> rule . apply ( memo . getNode ( memo . getRootGroup ( ) ) , lookup , idAllocator , symbolAllocator , session ) ) ;
  return new RuleApplication ( memo , lookup , symbolAllocator . getTypes ( ) , result ) ;
}




private RuleApplication applyRule ( ) {
  SymbolAllocator symbolAllocator = new SymbolAllocator ( symbols ) ;
  Memo memo = new Memo ( idAllocator , plan ) ;
  Lookup lookup = Lookup . from ( memo :: resolve ) ;
  Optional < PlanNode > result = inTransaction ( session -> rule . apply ( memo . getNode ( memo . getRootGroup ( ) ) , lookup , idAllocator , symbolAllocator , session ) ) ;
  return new RuleApplication ( memo , lookup , symbolAllocator . getTypes ( ) , result ) ;
}




*************************this is the dividing line*****************************



/** Example 5 */

/** ['Why the expected output was changed?', 'Why the expected output was changed?'] */
public void testPushDownArray ( ) throws Exception {
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 1" , 3 , 2 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 100" , 0 , 1 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] <> 1" , 8 , 7 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] > 20" , 5 , 4 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] between 10 and 20" , 5 , 5 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[4] = 15" , 1 , 3 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] is not null" , 11 , 6 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[3] is null" , 11 , 7 ) ;
}




public void testPushDownArray ( ) throws Exception {
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 1" , 3 , 2 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] = 100" , 0 , 1 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] <> 1" , 8 , 7 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] > 20" , 5 , 4 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[0] between 10 and 20" , 5 , 5 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[4] = 15" , 1 , 3 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[2] is not null" , 11 , 6 ) ;
  testParquetFilterPushDown ( "t.`user`.hobby_ids[3] is null" , 11 , 7 ) ;
}




*************************this is the dividing line*****************************



/** Example 6 */

/** ['This logic should be in the default implementation.', 'This logic should be in the default implementation.'] */
default Direction getBubbleElevatorDirection ( ) {
  Block block = this . getBlockState ( ) . getBlock ( ) ;
  if ( block == Blocks . BUBBLE_COLUMN ) {
    return this . getBlockState ( ) . get ( BubbleColumnBlock . DRAG ) ? Direction . DOWN : Direction . UP ;
  }
  else {
    return block . getBubbleElevatorDirection ( this . getBlockState ( ) ) ;
  }
}




default Direction getBubbleElevatorDirection ( ) {
  Block block = this . getBlockState ( ) . getBlock ( ) ;
  if ( block == Blocks . BUBBLE_COLUMN ) {
    return this . getBlockState ( ) . get ( BubbleColumnBlock . DRAG ) ? Direction . DOWN : Direction . UP ;
  }
  else {
    return block . getBubbleElevatorDirection ( this . getBlockState ( ) ) ;
  }
}




*************************this is the dividing line*****************************



/** Example 7 */

/** ['Why access this method staticly?', 'Why access this method staticly?'] */
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




*************************this is the dividing line*****************************



/** Example 8 */

/** ['You can set it on a plain field, no need for atomics:  ``` java this.inner = inner; o.onSubscribe(this); inner.request(Long.MAX_VALUE); ```', 'You can set it on a plain field, no need for atomics:  ``` java this.inner = inner; o.onSubscribe(this); inner.request(Long.MAX_VALUE); ```'] */
public void onSubscribe ( Subscription inner ) {
  SubscriptionHelper . setOnce ( this , inner ) ;
  o . onSubscribe ( this ) ;
  inner . request ( Long . MAX_VALUE ) ;
}




public void onSubscribe ( Subscription inner ) {
  SubscriptionHelper . setOnce ( this , inner ) ;
  o . onSubscribe ( this ) ;
  inner . request ( Long . MAX_VALUE ) ;
}




*************************this is the dividing line*****************************



/** Example 9 */

/** ["There's no need to make these public, even if the package is internal.", "There's no need to make these public, even if the package is internal."] */
public static Color getSystemForegroundColor ( Display display ) {
  ColorRegistry colorRegistry = JFaceResources . getColorRegistry ( ) ;
  Color foreground = colorRegistry . get ( JFacePreferences . INFORMATION_FOREGROUND_COLOR ) ;
  if ( foreground == null ) {
    return JFaceColors . getInformationViewerForegroundColor ( display ) ;
  }
  return foreground ;
}




public static Color getSystemForegroundColor ( Display display ) {
  ColorRegistry colorRegistry = JFaceResources . getColorRegistry ( ) ;
  Color foreground = colorRegistry . get ( JFacePreferences . INFORMATION_FOREGROUND_COLOR ) ;
  if ( foreground == null ) {
    return JFaceColors . getInformationViewerForegroundColor ( display ) ;
  }
  return foreground ;
}




*************************this is the dividing line*****************************



/** Example 10 */

/** ['You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ```', 'You should go one step more in simplifying the rule: Change this method to return a boolean: `hasNoDefault(switchStatementTree)`  ``` return allLabels(switchStatementTree).noneMatch(SwitchLastCaseIsDefaultCheck::isDefault); ```'] */
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



/** Example 11 */

/** ['style nit: no braces around single line blocks', 'style nit: no braces around single line blocks'] */
private void createIndex ( ) {
  lastFoundElementPosition = 0 ;
  filteredPlan . clear ( ) ;
  for ( PlanElement element : plan . getList ( ) ) {
    if ( ! element . isComment ( ) ) {
      filteredPlan . add ( element ) ;
    }
  }
}




private void createIndex ( ) {
  lastFoundElementPosition = 0 ;
  filteredPlan . clear ( ) ;
  for ( PlanElement element : plan . getList ( ) ) {
    if ( ! element . isComment ( ) ) {
      filteredPlan . add ( element ) ;
    }
  }
}




*************************this is the dividing line*****************************



/** Example 12 */

/** ['is there a difference between parallelStream() and entryStream().parallel() ?', 'is there a difference between parallelStream() and entryStream().parallel() ?'] */
public Collection < Map . Entry < K , V >> scanAndFilterByEntry ( Predicate < ? super Map . Entry < K , V >> entryPredicate ) {
  return mainMap . entryStream ( ) . parallel ( ) . filter ( entryPredicate ) . collect ( Collectors . toCollection ( ArrayList :: new ) ) ;
}




public Collection < Map . Entry < K , V >> scanAndFilterByEntry ( Predicate < ? super Map . Entry < K , V >> entryPredicate ) {
  return mainMap . entryStream ( ) . parallel ( ) . filter ( entryPredicate ) . collect ( Collectors . toCollection ( ArrayList :: new ) ) ;
}




*************************this is the dividing line*****************************



/** Example 13 */

/** ['Toni, could we please choose better variable names here? `equals` and `equals1` do not say much for newcomer to the codebase.  Or we could avoid storing partial results by: ```java if(!Objects.equals(editorPlaceRequest, event.getPlace())) { return false; }  if (!Objects.equals(getEditorIdentifier(), event.getPlace().getIdentifier())) { return false; } return true; ```  Please let me know what do you think.', 'Toni, could we please choose better variable names here? `equals` and `equals1` do not say much for newcomer to the codebase.  Or we could avoid storing partial results by: ```java if(!Objects.equals(editorPlaceRequest, event.getPlace())) { return false; }  if (!Objects.equals(getEditorIdentifier(), event.getPlace().getIdentifier())) { return false; } return true; ```  Please let me know what do you think.'] */
public boolean verifyEventIdentifier ( AbstractPlaceEvent event ) {
  boolean equals = Objects . equals ( getEditorIdentifier ( ) , event . getPlace ( ) . getIdentifier ( ) ) ;
  boolean equals1 = Objects . equals ( editorPlaceRequest , event . getPlace ( ) ) ;
  return ( equals && equals1 ) ;
}




public boolean verifyEventIdentifier ( AbstractPlaceEvent event ) {
  boolean equals = Objects . equals ( getEditorIdentifier ( ) , event . getPlace ( ) . getIdentifier ( ) ) ;
  boolean equals1 = Objects . equals ( editorPlaceRequest , event . getPlace ( ) ) ;
  return ( equals && equals1 ) ;
}




*************************this is the dividing line*****************************



/** Example 14 */

/** ["What is the need to make `issueArticles` nullable? It would be easier to understand this view class if we required it.  If that's totally impractical, we should consider having a separate view class to capture the difference.", "What is the need to make `issueArticles` nullable? It would be easier to understand this view class if we required it.  If that's totally impractical, we should consider having a separate view class to capture the difference."] */
public IssueOutputView ( Issue issue ) {
  this ( issue , null , null ) ;
}




public IssueOutputView ( Issue issue ) {
  this ( issue , null , null ) ;
}




*************************this is the dividing line*****************************



/** Example 15 */

/** ['not 100% sure, but this breaks binary compatibility, right?', 'not 100% sure, but this breaks binary compatibility, right?'] */
public ProcessEngineConfiguration setDefaultNumberOfRetries ( int defaultNumberOfRetries ) {
  this . defaultNumberOfRetries = defaultNumberOfRetries ;
  return this ;
}




public ProcessEngineConfiguration setDefaultNumberOfRetries ( int defaultNumberOfRetries ) {
  this . defaultNumberOfRetries = defaultNumberOfRetries ;
  return this ;
}




*************************this is the dividing line*****************************



/** Example 16 */

/** ["instead of an early assignment which might be overridden in line 2355, it can be set as the 'else' part of the if statement below (line 2356).", "instead of an early assignment which might be overridden in line 2355, it can be set as the 'else' part of the if statement below (line 2356)."] */
public long getSessionSeqId ( ) {
  if ( sessionSeqId == null ) {
    sessionSeqId = - 1L ;
    String sessionId = getContext ( ) . getEngineContext ( ) . getSessionId ( ) ;
    if ( getSessionDataContainer ( ) . isSessionExists ( sessionId ) ) {
      sessionSeqId = getSessionDataContainer ( ) . getEngineSessionSeqId ( sessionId ) ;
    }
  }
  return sessionSeqId ;
}




public long getSessionSeqId ( ) {
  if ( sessionSeqId == null ) {
    sessionSeqId = - 1L ;
    String sessionId = getContext ( ) . getEngineContext ( ) . getSessionId ( ) ;
    if ( getSessionDataContainer ( ) . isSessionExists ( sessionId ) ) {
      sessionSeqId = getSessionDataContainer ( ) . getEngineSessionSeqId ( sessionId ) ;
    }
  }
  return sessionSeqId ;
}




*************************this is the dividing line*****************************



/** Example 17 */

/** ['Allocate write ID is a DB/table related event and should be ignored if not lookup on this DB/table.', 'Allocate write ID is a DB/table related event and should be ignored if not lookup on this DB/table.'] */
private boolean isTxnRelatedEvent ( final NotificationEvent event ) {
  return ( ( event . getEventType ( ) . equals ( MessageFactory . OPEN_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . COMMIT_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . ABORT_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . ALLOC_WRITE_ID_EVENT ) ) ) ;
}




private boolean isTxnRelatedEvent ( final NotificationEvent event ) {
  return ( ( event . getEventType ( ) . equals ( MessageFactory . OPEN_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . COMMIT_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . ABORT_TXN_EVENT ) ) || ( event . getEventType ( ) . equals ( MessageFactory . ALLOC_WRITE_ID_EVENT ) ) ) ;
}




*************************this is the dividing line*****************************



/** Example 18 */

/** ["Can't we have this static flag on FS instead? Then we wouldn't need to make FileStoreAttributeCache public.", "Can't we have this static flag on FS instead? Then we wouldn't need to make FileStoreAttributeCache public."] */
public static void setBackground ( boolean async ) {
  background = async ;
}




public static void setBackground ( boolean async ) {
  background = async ;
}




*************************this is the dividing line*****************************



/** Example 19 */

/** ['For a small maximuSize, like 1, it may be more reasonable to check for:  map.size() > maximumSize', 'For a small maximuSize, like 1, it may be more reasonable to check for:  map.size() > maximumSize'] */
public V put ( @ NonNull K key , @ NonNull V value ) {
  map . put ( key , new Entry < > ( key , value , ++ time ) ) ;
  if ( map . size ( ) >= maximumSize ) {
    purge ( ) ;
  }
  return value ;
}




public V put ( @ NonNull K key , @ NonNull V value ) {
  map . put ( key , new Entry < > ( key , value , ++ time ) ) ;
  if ( map . size ( ) >= maximumSize ) {
    purge ( ) ;
  }
  return value ;
}




*************************this is the dividing line*****************************



