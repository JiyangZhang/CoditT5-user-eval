/** Example 0 */

/** Looks good to me, but worth to protect `getFirstDrId()` and `getLastDrId()` too, they'll throw `NoSuchElementException` also if `m_map` is empty. */

public long getSafePointDrId ( ) {
  synchronized ( m_map ) {
    assert ( ! m_map . isEmpty ( ) ) ;
    return end ( m_map . asRanges ( ) . iterator ( ) . next ( ) ) ;
  }
}


public long getSafePointDrId ( ) {
  synchronized ( m_map ) {
    assert ( ! m_map . isEmpty ( ) ) ;
    return end ( m_map . asRanges ( ) . iterator ( ) . next ( ) ) ;
  }
}


public long getSafePointDrId ( ) {
  synchronized ( m_map ) {
    assert ( ! m_map . isEmpty ( ) ) ;
    return end ( m_map . asRanges ( ) . iterator ( ) . next ( ) ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 1 */

/** `super.children().forEach(res::add);` ? */

public Iterable < Tree > children ( ) {
  List < Tree > result = new ArrayList < > ( ) ;
  if ( openParenToken != null ) {
    result . add ( openParenToken ) ;
  }
  for ( Tree tree : super . children ( ) ) {
    result . add ( tree ) ;
  }
  if ( closeParenToken != null ) {
    result . add ( closeParenToken ) ;
  }
  return result ;
}


public Iterable < Tree > children ( ) {
  List < Tree > result = new ArrayList < > ( ) ;
  if ( openParenToken != null ) {
    result . add ( openParenToken ) ;
  }
  for ( Tree tree : super . children ( ) ) {
    result . add ( tree ) ;
  }
  if ( closeParenToken != null ) {
    result . add ( closeParenToken ) ;
  }
  return result ;
}


public Iterable < Tree > children ( ) {
  List < Tree > result = new ArrayList < > ( ) ;
  if ( openParenToken != null ) {
    result . add ( openParenToken ) ;
  }
  for ( Tree tree : super . children ( ) ) {
    result . add ( tree ) ;
  }
  if ( closeParenToken != null ) {
    result . add ( closeParenToken ) ;
  }
  return result ;
}


public Iterable < Tree > children ( ) {
  List < Tree > result = new ArrayList < > ( ) ;
  if ( openParenToken != null ) {
    result . add ( openParenToken ) ;
  }
  for ( Tree tree : super . children ( ) ) {
    result . add ( tree ) ;
  }
  if ( closeParenToken != null ) {
    result . add ( closeParenToken ) ;
  }
  return result ;
}


*************************this is the dividing line*****************************



/** Example 2 */

/** lambda? */

public PatternScatterGraphView ( ) {
  super ( ID ) ;
  this . addPartPropertyListener ( new IPropertyChangeListener ( ) {
    @ Override public void propertyChange ( PropertyChangeEvent event ) {
      if ( event . getProperty ( ) . equals ( TmfXmlStrings . XML_LATENCY_OUTPUT_DATA ) ) {
        Object newValue = event . getNewValue ( ) ;
        if ( newValue instanceof String ) {
          String data = ( String ) newValue ;
          fViewInfo . setViewData ( data ) ;
          setPartName ( fViewInfo . getLabel ( ) ) ;
          loadLatencyView ( ) ;
        }
      }
    }
  }
  ) ;
}


public PatternScatterGraphView ( ) {
  super ( ID ) ;
  this . addPartPropertyListener ( new IPropertyChangeListener ( ) {
    @ Override public void propertyChange ( PropertyChangeEvent event ) {
      if ( event . getProperty ( ) . equals ( TmfXmlStrings . XML_LATENCY_OUTPUT_DATA ) ) {
        Object newValue = event . getNewValue ( ) ;
        if ( newValue instanceof String ) {
          String data = ( String ) newValue ;
          fViewInfo . setViewData ( data ) ;
          setPartName ( fViewInfo . getLabel ( ) ) ;
          loadLatencyView ( ) ;
        }
      }
    }
  }
  ) ;
}


public PatternScatterGraphView ( ) {
  super ( ID ) ;
  this . addPartPropertyListener ( new IPropertyChangeListener ( ) {
    @ Override public void propertyChange ( PropertyChangeEvent event ) {
      if ( event . getProperty ( ) . equals ( TmfXmlStrings . XML_LATENCY_OUTPUT_DATA ) ) {
        Object newValue = event . getNewValue ( ) ;
        if ( newValue instanceof String ) {
          String data = ( String ) newValue ;
          fViewInfo . setViewData ( data ) ;
          setPartName ( fViewInfo . getLabel ( ) ) ;
          loadLatencyView ( ) ;
        }
      }
    }
  }
  ) ;
}


*************************this is the dividing line*****************************



/** Example 3 */

/** Please post the examples of content for new metadata cache files to the Jira description */

public ColumnMetadata_v4 ( String [ ] name , PrimitiveType . PrimitiveTypeName primitiveType , Object minValue , Object maxValue , Long nulls ) {
  this . name = name ;
  this . minValue = minValue ;
  this . maxValue = maxValue ;
  this . nulls = nulls ;
  this . primitiveType = primitiveType ;
}


public ColumnMetadata_v4 ( String [ ] name , PrimitiveType . PrimitiveTypeName primitiveType , Object minValue , Object maxValue , Long nulls ) {
  this . name = name ;
  this . minValue = minValue ;
  this . maxValue = maxValue ;
  this . nulls = nulls ;
  this . primitiveType = primitiveType ;
}


public ColumnMetadata_v4 ( String [ ] name , PrimitiveType . PrimitiveTypeName primitiveType , Object minValue , Object maxValue , Long nulls ) {
  this . name = name ;
  this . minValue = minValue ;
  this . maxValue = maxValue ;
  this . nulls = nulls ;
  this . primitiveType = primitiveType ;
}


*************************this is the dividing line*****************************



/** Example 4 */

/** no need for isNotNull nor isInstanceOf(String.class). They are both implicit with .isEqualTo("1.0.0.0") */

public void registerSonarQubeVersion_publishes_version_on_first_call ( ) {
  ClusterProperties clusterProperties = new ClusterProperties ( newClusterSettings ( ) ) ;
  try ( HazelcastCluster hzCluster = HazelcastCluster . builder ( clusterProperties ) . build ( ) ) {
    hzCluster . registerSonarQubeVersion ( "1.0.0.0" ) ;
    HazelcastInstance hzInstance = createHazelcastClient ( hzCluster ) ;
    assertThat ( hzInstance . getAtomicReference ( SONARQUBE_VERSION ) . get ( ) ) . isNotNull ( ) . isInstanceOf ( String . class ) . isEqualTo ( "1.0.0.0" ) ;
  }
}


public void registerSonarQubeVersion_publishes_version_on_first_call ( ) {
  ClusterProperties clusterProperties = new ClusterProperties ( newClusterSettings ( ) ) ;
  try ( HazelcastCluster hzCluster = HazelcastCluster . builder ( clusterProperties ) . build ( ) ) {
    hzCluster . registerSonarQubeVersion ( "1.0.0.0" ) ;
    HazelcastInstance hzInstance = createHazelcastClient ( hzCluster ) ;
    assertThat ( hzInstance . getAtomicReference ( SONARQUBE_VERSION ) . get ( ) ) . isNotNull ( ) . isInstanceOf ( String . class ) . isEqualTo ( "1.0.0.0" ) ;
  }
}


public void registerSonarQubeVersion_publishes_version_on_first_call ( ) {
  ClusterProperties clusterProperties = new ClusterProperties ( newClusterSettings ( ) ) ;
  try ( HazelcastCluster hzCluster = HazelcastCluster . builder ( clusterProperties ) . build ( ) ) {
    hzCluster . registerSonarQubeVersion ( "1.0.0.0" ) ;
    HazelcastInstance hzInstance = createHazelcastClient ( hzCluster ) ;
    assertThat ( hzInstance . getAtomicReference ( SONARQUBE_VERSION ) . get ( ) ) . isNotNull ( ) . isInstanceOf ( String . class ) . isEqualTo ( "1.0.0.0" ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 5 */

/** Is CouchbaseLiteException thrown from anything in this method? Or it should return void but throw CouchbaseLiteException instead? */

boolean selectCommonAncestor ( ReadOnlyDocument doc1 , ReadOnlyDocument doc2 ) throws CouchbaseLiteException {
  if ( ! c4doc . getRawDoc ( ) . selectCommonAncestorRevision ( doc1 . getRevID ( ) , doc2 . getRevID ( ) ) ) return false ;
  setC4Doc ( c4doc ) ;
  return true ;
}


boolean selectCommonAncestor ( ReadOnlyDocument doc1 , ReadOnlyDocument doc2 ) throws CouchbaseLiteException {
  if ( ! c4doc . getRawDoc ( ) . selectCommonAncestorRevision ( doc1 . getRevID ( ) , doc2 . getRevID ( ) ) ) return false ;
  setC4Doc ( c4doc ) ;
  return true ;
}


boolean selectCommonAncestor ( ReadOnlyDocument doc1 , ReadOnlyDocument doc2 ) throws CouchbaseLiteException {
  if ( ! c4doc . getRawDoc ( ) . selectCommonAncestorRevision ( doc1 . getRevID ( ) , doc2 . getRevID ( ) ) ) return false ;
  setC4Doc ( c4doc ) ;
  return true ;
}


*************************this is the dividing line*****************************



/** Example 6 */

/** Missing assertNotNull for executionSet here. */

public void testUnmarshallSubprocessLevelEventEmptyProperties ( ) throws Exception {
  Diagram < Graph , Metadata > diagram = unmarshall ( marshaller , BPMN_START_EVENT_FILE_PATH ) ;
  assertDiagram ( diagram , AMOUNT_OF_NODES_IN_DIAGRAM ) ;
  StartNoneEvent emptySubprocess = getStartNodeById ( diagram , EMPTY_SUBPROCESS_LEVEL_EVENT_ID , StartNoneEvent . class ) ;
  assertGeneralSet ( emptySubprocess . getGeneral ( ) , EMPTY_VALUE , EMPTY_VALUE ) ;
  assertStartEventSlaDueDate ( emptySubprocess . getExecutionSet ( ) , EMPTY_VALUE ) ;
}


public void testUnmarshallSubprocessLevelEventEmptyProperties ( ) throws Exception {
  Diagram < Graph , Metadata > diagram = unmarshall ( marshaller , BPMN_START_EVENT_FILE_PATH ) ;
  assertDiagram ( diagram , AMOUNT_OF_NODES_IN_DIAGRAM ) ;
  StartNoneEvent emptySubprocess = getStartNodeById ( diagram , EMPTY_SUBPROCESS_LEVEL_EVENT_ID , StartNoneEvent . class ) ;
  assertGeneralSet ( emptySubprocess . getGeneral ( ) , EMPTY_VALUE , EMPTY_VALUE ) ;
  assertStartEventSlaDueDate ( emptySubprocess . getExecutionSet ( ) , EMPTY_VALUE ) ;
}


public void testUnmarshallSubprocessLevelEventEmptyProperties ( ) throws Exception {
  Diagram < Graph , Metadata > diagram = unmarshall ( marshaller , BPMN_START_EVENT_FILE_PATH ) ;
  assertDiagram ( diagram , AMOUNT_OF_NODES_IN_DIAGRAM ) ;
  StartNoneEvent emptySubprocess = getStartNodeById ( diagram , EMPTY_SUBPROCESS_LEVEL_EVENT_ID , StartNoneEvent . class ) ;
  assertGeneralSet ( emptySubprocess . getGeneral ( ) , EMPTY_VALUE , EMPTY_VALUE ) ;
  assertStartEventSlaDueDate ( emptySubprocess . getExecutionSet ( ) , EMPTY_VALUE ) ;
}


*************************this is the dividing line*****************************



/** Example 7 */

/** fix name */

public void testGenerateXpathSuppressionOptionEmptyConfig ( ) throws Exception {
  final String expected = " < ? xml SPACETOKEN version = \ " 1.0\ " SPACETOKEN encoding = \ " UTF - 8\ " ? > \n " + " < ! DOCTYPE SPACETOKEN suppressions SPACETOKEN PUBLIC \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " - // Puppy SPACETOKEN Crawl // DTD SPACETOKEN Suppressions SPACETOKEN Xpath SPACETOKEN Experimental SPACETOKEN 1.2 // EN\ " \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " http : // checkstyle . sourceforge . net / dtds / " + " suppressions _ 1_2 _ xpath _ experimental . dtd\ " > \n " + " < suppressions > \n " + " < / suppressions > \n " ;
  exit . checkAssertionAfterwards ( ( ) -> {
    assertEquals ( " Unexpected SPACETOKEN output SPACETOKEN log " , expected , systemOut . getLog ( ) ) ;
    assertEquals ( " Unexpected SPACETOKEN system SPACETOKEN error SPACETOKEN log " , " " , systemErr . getLog ( ) ) ;
  }
  ) ;
  Main . main ( " - c " , getPath ( " InputMainConfig - empty . xml " ) , " - - generate - xpath - suppression " , getPath ( " InputMainComplexityOverflow . java " ) ) ;
}


public void testGenerateXpathSuppressionOptionEmptyConfig ( ) throws Exception {
  final String expected = " < ? xml SPACETOKEN version = \ " 1.0\ " SPACETOKEN encoding = \ " UTF - 8\ " ? > \n " + " < ! DOCTYPE SPACETOKEN suppressions SPACETOKEN PUBLIC \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " - // Puppy SPACETOKEN Crawl // DTD SPACETOKEN Suppressions SPACETOKEN Xpath SPACETOKEN Experimental SPACETOKEN 1.2 // EN\ " \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " http : // checkstyle . sourceforge . net / dtds / " + " suppressions _ 1_2 _ xpath _ experimental . dtd\ " > \n " + " < suppressions > \n " + " < / suppressions > \n " ;
  exit . checkAssertionAfterwards ( ( ) -> {
    assertEquals ( " Unexpected SPACETOKEN output SPACETOKEN log " , expected , systemOut . getLog ( ) ) ;
    assertEquals ( " Unexpected SPACETOKEN system SPACETOKEN error SPACETOKEN log " , " " , systemErr . getLog ( ) ) ;
  }
  ) ;
  Main . main ( " - c " , getPath ( " InputMainConfig - empty . xml " ) , " - - generate - xpath - suppression " , getPath ( " InputMainComplexityOverflow . java " ) ) ;
}


public void testGenerateXpathSuppressionOptionEmptyConfig ( ) throws Exception {
  final String expected = " < ? xml SPACETOKEN version = \ " 1.0\ " SPACETOKEN encoding = \ " UTF - 8\ " ? > \n " + " < ! DOCTYPE SPACETOKEN suppressions SPACETOKEN PUBLIC \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " - // Puppy SPACETOKEN Crawl // DTD SPACETOKEN Suppressions SPACETOKEN Xpath SPACETOKEN Experimental SPACETOKEN 1.2 // EN\ " \n " + " SPACETOKEN SPACETOKEN SPACETOKEN SPACETOKEN \ " http : // checkstyle . sourceforge . net / dtds / " + " suppressions _ 1_2 _ xpath _ experimental . dtd\ " > \n " + " < suppressions > \n " + " < / suppressions > \n " ;
  exit . checkAssertionAfterwards ( ( ) -> {
    assertEquals ( " Unexpected SPACETOKEN output SPACETOKEN log " , expected , systemOut . getLog ( ) ) ;
    assertEquals ( " Unexpected SPACETOKEN system SPACETOKEN error SPACETOKEN log " , " " , systemErr . getLog ( ) ) ;
  }
  ) ;
  Main . main ( " - c " , getPath ( " InputMainConfig - empty . xml " ) , " - - generate - xpath - suppression " , getPath ( " InputMainComplexityOverflow . java " ) ) ;
}


*************************this is the dividing line*****************************



/** Example 8 */

/** I would turn this `&&` around. A simple deadlineName check is a lot cheaper than the full parameter assignment verification. */

public boolean canHandle ( Message < ? > message ) {
  return super . canHandle ( message ) && deadlineNameMatch ( ( DeadlineMessage ) message ) ;
}


public boolean canHandle ( Message < ? > message ) {
  return super . canHandle ( message ) && deadlineNameMatch ( ( DeadlineMessage ) message ) ;
}


public boolean canHandle ( Message < ? > message ) {
  return super . canHandle ( message ) && deadlineNameMatch ( ( DeadlineMessage ) message ) ;
}


*************************this is the dividing line*****************************



/** Example 9 */

/** Doesn't the InstallReceiver depend on a WikipediaApp instance being created by the system? Since NotificationPollService.start() is already called there, I think this would call it a second time */

public void onReceive ( Context ctx , Intent intent ) {
  String action = intent . getAction ( ) ;
  switch ( action ) {
    case INSTALL_ACTION : installReferrer ( ctx , intent ) ;
    break ;
    case Intent . ACTION_BOOT_COMPLETED : recordChannelId ( ctx ) ;
    NotificationPollService . start ( ctx . getApplicationContext ( ) ) ;
    break ;
    default : L . d ( "action=" + action ) ;
    break ;
  }
}


public void onReceive ( Context ctx , Intent intent ) {
  String action = intent . getAction ( ) ;
  switch ( action ) {
    case INSTALL_ACTION : installReferrer ( ctx , intent ) ;
    break ;
    case Intent . ACTION_BOOT_COMPLETED : recordChannelId ( ctx ) ;
    NotificationPollService . start ( ctx . getApplicationContext ( ) ) ;
    break ;
    default : L . d ( "action=" + action ) ;
    break ;
  }
}


public void onReceive ( Context ctx , Intent intent ) {
  String action = intent . getAction ( ) ;
  switch ( action ) {
    case INSTALL_ACTION : installReferrer ( ctx , intent ) ;
    break ;
    case Intent . ACTION_BOOT_COMPLETED : recordChannelId ( ctx ) ;
    NotificationPollService . start ( ctx . getApplicationContext ( ) ) ;
    break ;
    default : L . d ( "action=" + action ) ;
    break ;
  }
}


*************************this is the dividing line*****************************



/** Example 10 */

/** Is the check for trailing Path.SEPARATOR necessary ? We just got the IntroTheme.ATT_ID property which is not supposed to have a trailing Path.SEPARATOR, no ? */

private String getThemePrefixedPath ( String path ) {
  String prefix = themeProperties != null ? themeProperties . get ( IntroTheme . ATT_ID ) : null ;
  prefix = prefix == null ? "" : prefix . trim ( ) ;
  if ( prefix . length ( ) == 0 ) {
    return null ;
  }
  return prefix . charAt ( prefix . length ( ) - 1 ) == Path . SEPARATOR ? prefix + path : prefix + Path . SEPARATOR + path ;
}


private String getThemePrefixedPath ( String path ) {
  String prefix = themeProperties != null ? themeProperties . get ( IntroTheme . ATT_ID ) : null ;
  prefix = prefix == null ? "" : prefix . trim ( ) ;
  if ( prefix . length ( ) == 0 ) {
    return null ;
  }
  return prefix . charAt ( prefix . length ( ) - 1 ) == Path . SEPARATOR ? prefix + path : prefix + Path . SEPARATOR + path ;
}


private String getThemePrefixedPath ( String path ) {
  String prefix = themeProperties != null ? themeProperties . get ( IntroTheme . ATT_ID ) : null ;
  prefix = prefix == null ? "" : prefix . trim ( ) ;
  if ( prefix . length ( ) == 0 ) {
    return null ;
  }
  return prefix . charAt ( prefix . length ( ) - 1 ) == Path . SEPARATOR ? prefix + path : prefix + Path . SEPARATOR + path ;
}


*************************this is the dividing line*****************************



/** Example 11 */

/** Multi return is forbidden. */

public Dimension getFloatingItemOffset ( ) {
  if ( editPart instanceof FloatingLabelEditPart ) {
    return ( ( FloatingLabelEditPart ) editPart ) . getFloatingItemOffset ( ) ;
  }
  return new Dimension ( ) ;
}


public Dimension getFloatingItemOffset ( ) {
  if ( editPart instanceof FloatingLabelEditPart ) {
    return ( ( FloatingLabelEditPart ) editPart ) . getFloatingItemOffset ( ) ;
  }
  return new Dimension ( ) ;
}


public Dimension getFloatingItemOffset ( ) {
  if ( editPart instanceof FloatingLabelEditPart ) {
    return ( ( FloatingLabelEditPart ) editPart ) . getFloatingItemOffset ( ) ;
  }
  return new Dimension ( ) ;
}


*************************this is the dividing line*****************************



/** Example 12 */

/** This block is useless. */

public boolean areEqual ( MapObject o1 , MapObject o2 ) {
  if ( o1 == null ^ o2 == null ) {
    return false ;
  }
  else if ( o1 == o2 ) {
    return true ;
  }
  else {
    return o1 . id . equals ( o2 . id ) ;
  }
}


public boolean areEqual ( MapObject o1 , MapObject o2 ) {
  if ( o1 == null ^ o2 == null ) {
    return false ;
  }
  else if ( o1 == o2 ) {
    return true ;
  }
  else {
    return o1 . id . equals ( o2 . id ) ;
  }
}


public boolean areEqual ( MapObject o1 , MapObject o2 ) {
  if ( o1 == null ^ o2 == null ) {
    return false ;
  }
  else if ( o1 == o2 ) {
    return true ;
  }
  else {
    return o1 . id . equals ( o2 . id ) ;
  }
}


*************************this is the dividing line*****************************



/** Example 13 */

/** please change to setSucceeded */

public void endSuccessfully ( ) {
  super . endSuccessfully ( ) ;
  if ( getParameters ( ) . getImportAsTemplate ( ) ) {
    Guid newTemplateId = createTemplate ( ) ;
    if ( newTemplateId != null ) {
      attachDiskToTemplate ( newTemplateId ) ;
    }
  }
  updateDiskStatus ( ImageStatus . OK ) ;
  getReturnValue ( ) . setSucceeded ( true ) ;
}


public void endSuccessfully ( ) {
  super . endSuccessfully ( ) ;
  if ( getParameters ( ) . getImportAsTemplate ( ) ) {
    Guid newTemplateId = createTemplate ( ) ;
    if ( newTemplateId != null ) {
      attachDiskToTemplate ( newTemplateId ) ;
    }
  }
  updateDiskStatus ( ImageStatus . OK ) ;
  getReturnValue ( ) . setSucceeded ( true ) ;
}


public void endSuccessfully ( ) {
  super . endSuccessfully ( ) ;
  if ( getParameters ( ) . getImportAsTemplate ( ) ) {
    Guid newTemplateId = createTemplate ( ) ;
    if ( newTemplateId != null ) {
      attachDiskToTemplate ( newTemplateId ) ;
    }
  }
  updateDiskStatus ( ImageStatus . OK ) ;
  getReturnValue ( ) . setSucceeded ( true ) ;
}


*************************this is the dividing line*****************************



/** Example 14 */

/** why do you need to wrap it in a new `ArrayList`? Seems wasteful. */

public ByteBufferReadableStreamChannel ( List < ByteBuffer > bufferList ) {
  if ( bufferList == null || bufferList . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "Input List of ByteBuffer cannot be null/empty for ByteBufferReadableStreamChannel" ) ;
  }
  buffers = new ArrayList < > ( bufferList ) ;
  size = computeSize ( bufferList ) ;
}


public ByteBufferReadableStreamChannel ( List < ByteBuffer > bufferList ) {
  if ( bufferList == null || bufferList . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "Input List of ByteBuffer cannot be null/empty for ByteBufferReadableStreamChannel" ) ;
  }
  buffers = new ArrayList < > ( bufferList ) ;
  size = computeSize ( bufferList ) ;
}


public ByteBufferReadableStreamChannel ( List < ByteBuffer > bufferList ) {
  if ( bufferList == null || bufferList . isEmpty ( ) ) {
    throw new IllegalArgumentException ( "Input List of ByteBuffer cannot be null/empty for ByteBufferReadableStreamChannel" ) ;
  }
  buffers = new ArrayList < > ( bufferList ) ;
  size = computeSize ( bufferList ) ;
}


*************************this is the dividing line*****************************



/** Example 15 */

/** I don't see why I need this cast. The group and artifact IDs are accessible even at interface level. Also the version is accessible, but I don't think you should add it here: this is for multimodule project compilaton and afaik you cannot have different modules with same GA and different version in the same project. */

public static String getModelFileWithGAV ( ReleaseId releaseId ) {
  ReleaseIdImpl releaseIdImpl = ( ReleaseIdImpl ) releaseId ;
  return Paths . get ( MODEL_FILE_DIRECTORY , releaseIdImpl . getGroupId ( ) , releaseIdImpl . getArtifactId ( ) , releaseIdImpl . getVersion ( ) , MODEL_FILE_NAME ) . toString ( ) ;
}


public static String getModelFileWithGAV ( ReleaseId releaseId ) {
  ReleaseIdImpl releaseIdImpl = ( ReleaseIdImpl ) releaseId ;
  return Paths . get ( MODEL_FILE_DIRECTORY , releaseIdImpl . getGroupId ( ) , releaseIdImpl . getArtifactId ( ) , releaseIdImpl . getVersion ( ) , MODEL_FILE_NAME ) . toString ( ) ;
}


public static String getModelFileWithGAV ( ReleaseId releaseId ) {
  ReleaseIdImpl releaseIdImpl = ( ReleaseIdImpl ) releaseId ;
  return Paths . get ( MODEL_FILE_DIRECTORY , releaseIdImpl . getGroupId ( ) , releaseIdImpl . getArtifactId ( ) , releaseIdImpl . getVersion ( ) , MODEL_FILE_NAME ) . toString ( ) ;
}


*************************this is the dividing line*****************************



/** Example 16 */

/** can you explain why this is necessary? */

public int hashCode ( ) {
  return getClass ( ) . hashCode ( ) ;
}


public int hashCode ( ) {
  return getClass ( ) . hashCode ( ) ;
}


public int hashCode ( ) {
  return getClass ( ) . hashCode ( ) ;
}


*************************this is the dividing line*****************************



/** Example 17 */

/** `==` instead of `.equals` (in both instances) would make this null-safe */

public boolean respondsTo ( RunEvent event ) {
  Run r = event . getEventObject ( ) ;
  if ( event . getEventType ( ) . equals ( MisoEventType . RUN_FAILED ) && r . getHealth ( ) . equals ( HealthType . Failed ) ) {
    log . info ( "Run " + r . getAlias ( ) + ": " + event . getEventMessage ( ) ) ;
    return true ;
  }
  return false ;
}


public boolean respondsTo ( RunEvent event ) {
  Run r = event . getEventObject ( ) ;
  if ( event . getEventType ( ) . equals ( MisoEventType . RUN_FAILED ) && r . getHealth ( ) . equals ( HealthType . Failed ) ) {
    log . info ( "Run " + r . getAlias ( ) + ": " + event . getEventMessage ( ) ) ;
    return true ;
  }
  return false ;
}


public boolean respondsTo ( RunEvent event ) {
  Run r = event . getEventObject ( ) ;
  if ( event . getEventType ( ) . equals ( MisoEventType . RUN_FAILED ) && r . getHealth ( ) . equals ( HealthType . Failed ) ) {
    log . info ( "Run " + r . getAlias ( ) + ": " + event . getEventMessage ( ) ) ;
    return true ;
  }
  return false ;
}


*************************this is the dividing line*****************************



/** Example 18 */

/** You need to keep in mind that the sentence construction in other languages could be different, so the query string doesn't always show at the end. You should use %1$s in your string on values/strings.xml and pass the query term as an extra argument to getString() */

private void onFragmentLoaded ( ) {
  if ( searchAdapter == null ) {
    searchAdapter = new SearchlistAdapter ( getActivity ( ) , itemAccess ) ;
    setListAdapter ( searchAdapter ) ;
  }
  searchAdapter . notifyDataSetChanged ( ) ;
  setListShown ( true ) ;
  String query = getArguments ( ) . getString ( ARG_QUERY ) ;
  setEmptyText ( getString ( R . string . no_results_for_query ) + " SPACETOKEN \ " " + query + " \ " " ) ;
}


private void onFragmentLoaded ( ) {
  if ( searchAdapter == null ) {
    searchAdapter = new SearchlistAdapter ( getActivity ( ) , itemAccess ) ;
    setListAdapter ( searchAdapter ) ;
  }
  searchAdapter . notifyDataSetChanged ( ) ;
  setListShown ( true ) ;
  String query = getArguments ( ) . getString ( ARG_QUERY ) ;
  setEmptyText ( getString ( R . string . no_results_for_query ) + " SPACETOKEN \ " " + query + " \ " " ) ;
}


private void onFragmentLoaded ( ) {
  if ( searchAdapter == null ) {
    searchAdapter = new SearchlistAdapter ( getActivity ( ) , itemAccess ) ;
    setListAdapter ( searchAdapter ) ;
  }
  searchAdapter . notifyDataSetChanged ( ) ;
  setListShown ( true ) ;
  String query = getArguments ( ) . getString ( ARG_QUERY ) ;
  setEmptyText ( getString ( R . string . no_results_for_query ) + " SPACETOKEN \ " " + query + " \ " " ) ;
}


*************************this is the dividing line*****************************



/** Example 19 */

/** Please use Java conventions - param */

private List < Disk > manualAggregateSnapshots ( ) {
  List < Disk > Param = new ArrayList < > ( ) ;
  DiskImage diskWithSnaps = diskWithSnapshots ;
  diskWithSnaps . getSnapshots ( ) . addAll ( snapshotsList ) ;
  Param . add ( diskWithSnapshots ) ;
  Param . add ( diskWithoutSnapshots ) ;
  Param . add ( ovfImage ) ;
  Param . add ( cinderDisk ) ;
  return Param ;
}


private List < Disk > manualAggregateSnapshots ( ) {
  List < Disk > Param = new ArrayList < > ( ) ;
  DiskImage diskWithSnaps = diskWithSnapshots ;
  diskWithSnaps . getSnapshots ( ) . addAll ( snapshotsList ) ;
  Param . add ( diskWithSnapshots ) ;
  Param . add ( diskWithoutSnapshots ) ;
  Param . add ( ovfImage ) ;
  Param . add ( cinderDisk ) ;
  return Param ;
}


private List < Disk > manualAggregateSnapshots ( ) {
  List < Disk > Param = new ArrayList < > ( ) ;
  DiskImage diskWithSnaps = diskWithSnapshots ;
  diskWithSnaps . getSnapshots ( ) . addAll ( snapshotsList ) ;
  Param . add ( diskWithSnapshots ) ;
  Param . add ( diskWithoutSnapshots ) ;
  Param . add ( ovfImage ) ;
  Param . add ( cinderDisk ) ;
  return Param ;
}


*************************this is the dividing line*****************************



