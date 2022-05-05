/** Example 0 */

/** Actually I don't think this is how it should work? We do not expose jackson directly to the user, and all the encoding and decoding happens on the spring side and not with the SDK itself.. shouldn't this go into the mapper/converter logic instead? */

// Manual revision
protected void configureEnvironment ( final ClusterEnvironment . Builder builder ) {
  ObjectMapper objectMapper = new ObjectMapper ( ) ;
  objectMapper . registerModule ( new CouchbaseJacksonModule ( ) ) ;
  objectMapper . registerModule ( new JsonValueModule ( ) ) ;
  builder . jsonSerializer ( JacksonJsonSerializer . create ( objectMapper ) ) ;
}


// Suggested Revision A
protected void configureEnvironment ( final ClusterEnvironment . Builder builder ) {
  builder . jsonSerializer ( JacksonJsonSerializer . create ( objectMapper ) ) ;
}


// Suggested Revision B
protected void configureEnvironment ( final ClusterEnvironment . Builder builder ) {
  Jackson2ObjectMapperBuilder jacksonBuilder = new Jackson2ObjectMapperBuilder ( ) ;
  jacksonBuilder . serializationInclusion ( JsonInclude . Include . NON_NULL ) ;
  jacksonBuilder . modules ( new CouchbaseJacksonModule ( ) , new JsonValueModule ( ) ) ;
  ObjectMapper objectMapper = new ObjectMapper ( ) ;
  objectMapper . registerModule ( new CouchbaseJacksonModule ( ) ) ;
  objectMapper . registerModule ( new JsonValueModule ( ) ) ;
  builder . jsonSerializer ( JacksonJsonSerializer . create ( objectMapper ) ) ;
}


==========================this is the dividing line=============================



/** Example 1 */

/** Why do you perform this test on FeaturesProvider's class? This really looks strange and I do not see how this relates to the goal of this commit... */

// Manual revision
public void init ( EObject original , EditingDomain editingDomain ) {
  List < EStructuralFeature > features = featuresProvider . getFeatures ( original ) ;
  initControlFactory ( editingDomain , original ) ;
  for ( final EStructuralFeature feature : features ) {
    createControlForFeature ( feature ) ;
  }
  this . layout ( ) ;
}


// Suggested Revision A
public void init ( EObject original , EditingDomain editingDomain ) {
  List < EStructuralFeature > features = featuresProvider . getFeatures ( original ) ;
  initControlFactory ( editingDomain , original ) ;
  for ( final EStructuralFeature feature : features ) {
    if ( isToBeRendered ( feature ) ) {
      createControlForFeature ( feature ) ;
    }
  }
  this . layout ( ) ;
}


// Suggested Revision B
public void init ( EObject original , EditingDomain editingDomain ) {
  List < EStructuralFeature > features = featuresProvider . getFeatures ( original ) ;
  initControlFactory ( editingDomain , original ) ;
  for ( final EStructuralFeature feature : features ) {
    if ( ! isToBeRendered ( feature ) ) {
      createControlForFeature ( feature ) ;
    }
  }
  this . layout ( ) ;
}


==========================this is the dividing line=============================



/** Example 2 */

/** This is not needed here */

// Manual revision
public synchronized void onHeaders ( Response response ) {
  long length = response . getHeaders ( ) . getLongField ( HttpHeader . CONTENT_LENGTH . asString ( ) ) ;
  if ( length > maxLength ) {
    response . abort ( new ResponseTooLargeException ( ) ) ;
  }
}


// Suggested Revision A
public synchronized void onHeaders ( Response response ) {
  long length = response . getHeaders ( ) . getLongField ( HttpHeader . CONTENT_LENGTH . asString ( ) ) ;
  if ( length > maxLength ) {
    response . abort ( new ResponseTooLargeException ( ) ) ;
  }
  allocateCurrentArray ( ) ;
}


// Suggested Revision B
public synchronized void onHeaders ( Response response ) {
  long length = response . getHeaders ( ) . getLongField ( HttpHeader . CONTENT_LENGTH . asString ( ) ) ;
  if ( length > maxLength ) {
    response . abort ( new ResponseTooLargeException ( ) ) ;
  }
}


==========================this is the dividing line=============================



/** Example 3 */

/** Shouldn't this also be changed to super.selectedItemsChanged()? */

// Manual revision
protected void selectedItemsChanged ( ) {
  super . selectedItemsChanged ( ) ;
  updateActionAvailability ( ) ;
}


// Suggested Revision A
protected void selectedItemsChanged ( ) {
  updateActionAvailability ( ) ;
}


// Suggested Revision B
protected void selectedItemsChanged ( ) {
  super . selectedItemsChanged ( ) ;
  updateActionAvailability ( ) ;
}


==========================this is the dividing line=============================



/** Example 4 */

/** Could use an entrySet. */

// Manual revision
protected void addExtraHeaders ( Builder webResource ) {
  if ( additionalHeaders != null ) {
    for ( Map . Entry < String , List < Object >> entry : additionalHeaders . entrySet ( ) ) {
      webResource . header ( entry . getKey ( ) , entry . getValue ( ) ) ;
    }
  }
}


// Suggested Revision A
protected void addExtraHeaders ( Builder webResource ) {
  if ( additionalHeaders != null ) {
    for ( String e : additionalHeaders . entrySet ( ) ) {
      webResource . header ( e . getKey ( ) , additionalHeaders . get ( e . getKey ( ) ) ) ;
    }
  }
}


// Suggested Revision B
protected void addExtraHeaders ( Builder webResource ) {
  if ( additionalHeaders != null ) {
    for ( Entry < String , String > entry : additionalHeaders . entrySet ( ) ) {
      webResource . header ( entry . getKey ( ) , entry . getValue ( ) ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 5 */

/** Interesting approach. I guess I'd have tried to use qualifiers or the CDI alternative mechanism, but this seems the simplest. */

// Manual revision
public WebArchive createDeployment ( ) {
  if ( resourceLocal ) {
    archive . addClasses ( MemberRegistrationWithResourceLocal . class ) ;
  }
  else {
    archive . addClasses ( MemberRegistrationWithJta . class , JtaResources . class ) ;
  }
  return archive ;
}


// Suggested Revision A
public WebArchive createDeployment ( ) {
  archive . addClasses ( MemberRegistrationWithJta . class , JtaResources . class ) ;
  return archive ;
}


// Suggested Revision B
public WebArchive createDeployment ( ) {
  return archive ;
}


==========================this is the dividing line=============================



/** Example 6 */

/** you handle all these exceptions in the same way so you can use multi-catch:  } catch (RevisionSyntaxException | AmbiguousObjectException | IncorrectObjectTypeException | IOException e) { */

// Manual revision
protected RevCommit findHead ( Repository repo ) {
  try ( RevWalk walk = new RevWalk ( repo ) ) {
    try {
      ObjectId head = repo . resolve ( HEAD ) ;
      return walk . parseCommit ( head ) ;
    }
    catch ( RevisionSyntaxException | IOException e ) {
      throw new RuntimeException ( e ) ;
    }
  }
}


// Suggested Revision A
protected RevCommit findHead ( Repository repo ) {
  try ( RevWalk walk = new RevWalk ( repo ) ) {
    try {
      ObjectId head = repo . resolve ( HEAD ) ;
      return walk . parseCommit ( head ) ;
    }
    catch ( AmbiguousObjectException e ) {
      throw new RuntimeException ( e ) ;
    }
    catch ( IncorrectObjectTypeException e ) {
      throw new RuntimeException ( e ) ;
    }
    catch ( IOException e ) {
      throw new RuntimeException ( e ) ;
    }
  }
}


// Suggested Revision B
protected RevCommit findHead ( Repository repo ) {
  try ( RevWalk walk = new RevWalk ( repo ) ) {
    try {
      ObjectId head = repo . resolve ( HEAD ) ;
      return walk . parseCommit ( head ) ;
    }
    catch ( RevisionSyntaxException | AmbiguousObjectException | IncorrectObjectTypeException | IOException e ) {
      throw new RuntimeException ( e ) ;
    }
  }
}


==========================this is the dividing line=============================



/** Example 7 */

/** Why don't you push this down to `LogData::getPayload` ? (since that's when deserialize is actually invoked) */

// Manual revision
protected boolean processEntryForContext ( final ILogData data ) {
  if ( data != null ) {
    final Object payload = data . getPayload ( runtime ) ;
  }
  return false ;
}


// Suggested Revision A
protected boolean processEntryForContext ( final ILogData data ) {
  if ( data != null ) {
    try {
      return data . getPayload ( runtime ) ;
    }
    catch ( Throwable e ) {
      log . error ( "Exception caught at address {
}, {
}, {
}, {
}" , data . getGlobalAddress ( ) , data . getStreams ( ) , data . getType ( ) ) ;
throw e ;
}
}
return false ;
}


// Suggested Revision B
protected boolean processEntryForContext ( final ILogData data ) {
  if ( data != null ) {
    try {
      final Object payload = data . getPayload ( ) ;
    }
    catch ( Throwable e ) {
      log . error ( "Exception caught at address {
}, {
}, {
}" , data . getGlobalAddress ( ) , data . getStreams ( ) , data . getType ( ) ) ;
  throw e ;
}
}
return false ;
}


==========================this is the dividing line=============================



/** Example 8 */

/** Move this line after logging the error, so in any case the error get logged. */

// Manual revision
public void run ( ) {
  resetGlobalProgress ( ) ;
  indexingAll = true ;
  for ( ObjectType objectType : ObjectType . values ( ) ) {
    startIndexing ( objectType ) ;
  }
  try {
    sleep ( pause ) ;
  }
  catch ( InterruptedException e ) {
    logger . error ( "Thread interrupted: " + e . getMessage ( ) ) ;
    Thread . currentThread ( ) . interrupt ( ) ;
  }
  currentIndexState = ObjectType . NONE ;
  indexingAll = false ;
  pollingChannel . send ( INDEXING_FINISHED_MESSAGE ) ;
}


// Suggested Revision A
public void run ( ) {
  indexingAll = true ;
  for ( ObjectType objectType : ObjectType . values ( ) ) {
    startIndexing ( objectType ) ;
  }
  try {
    sleep ( pause ) ;
  }
  catch ( InterruptedException e ) {
    Thread . currentThread ( ) . interrupt ( ) ;
    logger . error ( "Thread interrupted: " + e . getMessage ( ) ) ;
  }
  currentIndexState = ObjectType . NONE ;
  indexingAll = false ;
  pollingChannel . send ( INDEXING_FINISHED_MESSAGE ) ;
}


// Suggested Revision B
public void run ( ) {
  resetGlobalProgress ( ) ;
  indexingAll = true ;
  for ( ObjectType objectType : ObjectType . values ( ) ) {
    startIndexing ( objectType ) ;
  }
  try {
    sleep ( pause ) ;
  }
  catch ( InterruptedException e ) {
    Thread . currentThread ( ) . interrupt ( ) ;
    logger . error ( "Thread interrupted: " + e . getMessage ( ) ) ;
  }
  currentIndexState = ObjectType . NONE ;
  indexingAll = false ;
  pollingChannel . send ( INDEXING_FINISHED_MESSAGE ) ;
}


==========================this is the dividing line=============================



/** Example 9 */

/** no need to assign to counterName just to return on next line. However, we probably should add a null check for the evaluationContext. */

// Manual revision
protected String computeMetricName ( Message < ? > message ) {
  return nameExpression . getValue ( evaluationContext , message , CharSequence . class ) . toString ( ) ;
}


// Suggested Revision A
protected String computeMetricName ( Message < ? > message ) {
  return nameExpression . getValue ( evaluationContext , message , CharSequence . class ) . toString ( ) ;
}


// Suggested Revision B
protected String computeMetricName ( Message < ? > message ) {
  if ( evaluationContext == null ) {
    return null ;
  }
  return nameExpression . getValue ( evaluationContext , message , CharSequence . class ) . toString ( ) ;
}


==========================this is the dividing line=============================



/** Example 10 */

/** Why is this method required? Didn't see it used anywhere in the code */

// Manual revision
int getImageselector ( ) {
  return imageSelectorIndex ;
}


// Suggested Revision A
public Integer getImageselector ( ) {
  return imageSelectorIndex ;
}


// Suggested Revision B
protected int getImageselector ( ) {
  return imageSelectorIndex ;
}


==========================this is the dividing line=============================



/** Example 11 */

/** should look like this but without the declaration above - they should be on one line  ```suggestion long deckID = getCol().getDecks().selected(); ``` */

// Manual revision
protected long getParentDid ( ) {
  long deckID = getCol ( ) . getDecks ( ) . selected ( ) ;
  return deckID ;
}


// Suggested Revision A
protected long getParentDid ( ) {
  deckID = getCol ( ) . getDecks ( ) . selected ( ) ;
  return deckID ;
}


// Suggested Revision B
protected long getParentDid ( ) {
  long deckID = getCol ( ) . getDecks ( ) . selected ( ) ;
  return deckID ;
}


==========================this is the dividing line=============================



/** Example 12 */

/** Would it make more sense to mark the brand parameter of setBrand as @NonNull instead of checking it here? */

// Manual revision
protected void updateTitle ( String brand ) {
  IBrandManager brandManager = TasksUiPlugin . getDefault ( ) . getBrandManager ( ) ;
  setTitle ( brandManager . getConnectorLabel ( getConnector ( ) , brand ) ) ;
}


// Suggested Revision A
protected void updateTitle ( String brand ) {
  if ( brand != null ) {
    IBrandManager brandManager = TasksUiPlugin . getDefault ( ) . getBrandManager ( ) ;
    setTitle ( brandManager . getConnectorLabel ( getConnector ( ) , brand ) ) ;
  }
}


// Suggested Revision B
protected void updateTitle ( String brand ) {
  IBrandManager brandManager = TasksUiPlugin . getDefault ( ) . getBrandManager ( ) ;
  setTitle ( brandManager . getConnectorLabel ( getConnector ( ) , brand ) ) ;
}


==========================this is the dividing line=============================



/** Example 13 */

/** Any way we can clean this up? It seems to only be needed for example commands, but hard to check what the command is here since it's wrapped in decorators. */

// Manual revision
private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  return new CommandCall ( null , commandCall . getCommand ( ) , element , commandCall . getExpression ( ) , commandCall . getResource ( ) ) ;
}


// Suggested Revision A
private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  return new CommandCall ( null , commandCall . getCommand ( ) , element , expression , commandCall . getResource ( ) ) ;
}


// Suggested Revision B
private CommandCall duplicateCommandForDifferentElement ( CommandCall commandCall , Element element ) {
  String expression = commandCall . getExpression ( ) ;
  if ( expression . equals ( "" ) ) {
    expression = element . getText ( ) ;
  }
  return new CommandCall ( null , commandCall . getCommand ( ) , element , expression , commandCall . getResource ( ) ) ;
}


==========================this is the dividing line=============================



/** Example 14 */

/** no need for `.toString()` */

// Manual revision
public Type convertReadValueToType ( String pvReadValue ) {
  Type lvType = convertReadValueToUnmodifiedType ( pvReadValue ) ;
  for ( InterfaceOneWireTypeModifier lvTypeModifier : getTypeModifieryList ( ) ) {
    logger . debug ( "type of {
}
 before modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType ) ;
    lvType = lvTypeModifier . modify4Read ( lvType ) ;
    logger . debug ( "type of {
}
 after modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType ) ;
  }
  return lvType ;
}


// Suggested Revision A
public Type convertReadValueToType ( String pvReadValue ) {
  Type lvType = convertReadValueToUnmodifiedType ( pvReadValue ) ;
  for ( InterfaceOneWireTypeModifier lvTypeModifier : getTypeModifieryList ( ) ) {
    logger . debug ( "type of {
}
 before modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType ) ;
    lvType = lvTypeModifier . modify4Read ( lvType ) ;
    logger . debug ( "type of {
}
 after modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType . toString ( ) ) ;
  }
  return lvType ;
}


// Suggested Revision B
public Type convertReadValueToType ( String pvReadValue ) {
  Type lvType = convertReadValueToUnmodifiedType ( pvReadValue ) ;
  for ( InterfaceOneWireTypeModifier lvTypeModifier : getTypeModifieryList ( ) ) {
    logger . debug ( "type of {
}
 before modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType ) ;
    lvType = lvTypeModifier . modify4Read ( lvType ) ;
    logger . debug ( "type of {
}
 after modifier:{
}
 type={
}" , getDevicePropertyPath ( ) , lvTypeModifier . getModifierName ( ) , lvType ) ;
  }
  return lvType ;
}


==========================this is the dividing line=============================



/** Example 15 */

/** a couple of questions: - can't you return true here? - is it possible to configure multiple directory providers? */

// Manual revision
public boolean indexShareable ( ) {
  TypedProperties properties = properties ( ) ;
  boolean hasRamDirectoryProvider = false ;
  for ( Object objKey : properties . keySet ( ) ) {
    String key = ( String ) objKey ;
    if ( key . endsWith ( DIRECTORY_PROVIDER_KEY ) ) {
      if ( properties . get ( key ) . equals ( RAM_DIRECTORY_PROVIDER ) ) {
        hasRamDirectoryProvider = true ;
      }
      else {
        return true ;
      }
    }
  }
  return ! hasRamDirectoryProvider ;
}


// Suggested Revision A
public boolean indexShareable ( ) {
  TypedProperties properties = properties ( ) ;
  boolean hasRamDirectoryProvider = false ;
  boolean hasOtherDirectoryProvider = false ;
  for ( Object objKey : properties . keySet ( ) ) {
    String key = ( String ) objKey ;
    if ( key . endsWith ( DIRECTORY_PROVIDER_KEY ) ) {
      if ( properties . get ( key ) . equals ( RAM_DIRECTORY_PROVIDER ) ) {
        hasRamDirectoryProvider = true ;
      }
      else {
        hasOtherDirectoryProvider = true ;
      }
    }
  }
  return ! hasRamDirectoryProvider && ! hasOtherDirectoryProvider ;
}


// Suggested Revision B
public boolean indexShareable ( ) {
  TypedProperties properties = properties ( ) ;
  boolean hasRamDirectoryProvider = false ;
  boolean hasOtherDirectoryProvider = false ;
  for ( Object objKey : properties . keySet ( ) ) {
    String key = ( String ) objKey ;
    if ( key . endsWith ( DIRECTORY_PROVIDER_KEY ) ) {
      if ( properties . get ( key ) . equals ( RAM_DIRECTORY_PROVIDER ) ) {
        hasRamDirectoryProvider = true ;
      }
      else {
        hasOtherDirectoryProvider = true ;
      }
    }
  }
  return true ;
}


==========================this is the dividing line=============================



/** Example 16 */

/** Sounds like you forgot to remove this one */

// Manual revision
public void startThreads ( ) {
  synchronized ( this ) {
    if ( ! this . threadStarted ) {
      int nbThreads = this . configuration . getProperty ( "mentions.poolSize" , 1 ) ;
      for ( int i = 0 ;
      i < nbThreads ;
      i ++ ) {
        startConsumer ( ) ;
      }
      this . threadStarted = true ;
    }
  }
}


// Suggested Revision A
public void startThreads ( ) {
  if ( ! this . threadStarted ) {
    synchronized ( this ) {
      if ( ! this . threadStarted ) {
        int nbThreads = this . configuration . getProperty ( "mentions.poolSize" , 1 ) ;
        for ( int i = 0 ;
        i < nbThreads ;
        i ++ ) {
          startConsumer ( ) ;
        }
        this . threadStarted = true ;
      }
    }
  }
}


// Suggested Revision B
public void startThreads ( ) {
  if ( ! this . threadStarted ) {
    synchronized ( this ) {
      if ( ! this . threadStarted ) {
        int nbThreads = this . configuration . getProperty ( "mentions.poolSize" , 1 ) ;
        for ( int i = 0 ;
        i < nbThreads ;
        i ++ ) {
          startConsumer ( ) ;
        }
      }
    }
  }
}


==========================this is the dividing line=============================



/** Example 17 */

/** In the LB impls (both this and the Base version), if we are deprecating getServerList(boolean), it would be preferable to move the code logic into getReachableServer() and getAllServers(), and defer getServerList(boolean) to call either getReachableServers or getAllServers based on the boolean. */

// Manual revision
public List < Server > getReachableServers ( ) {
  return null ;
}


// Suggested Revision A
public List < Server > getReachableServers ( ) {
  return getServerList ( false ) ;
}


// Suggested Revision B
public List < Server > getReachableServers ( ) {
  return getServerList ( true ) ;
}


==========================this is the dividing line=============================



/** Example 18 */

/** The cast should not be removed to avoid compilation errors on Eclipse versions which do not have the generified getAdapter. */

// Manual revision
public boolean provides ( IOperation operation ) {
  if ( ! ( operation instanceof CreateDecoratorsOperation ) ) {
    return false ;
  }
  IDecoratorTarget decoratorTarget = ( ( CreateDecoratorsOperation ) operation ) . getDecoratorTarget ( ) ;
  View view = ( View ) decoratorTarget . getAdapter ( View . class ) ;
  return view != null && DDiagramEditPart . MODEL_ID . equals ( SiriusVisualIDRegistry . getModelID ( view ) ) ;
}


// Suggested Revision A
public boolean provides ( IOperation operation ) {
  if ( ! ( operation instanceof CreateDecoratorsOperation ) ) {
    return false ;
  }
  IDecoratorTarget decoratorTarget = operation . getDecoratorTarget ( ) ;
  View view = decoratorTarget . getAdapter ( View . class ) ;
  return view != null && DDiagramEditPart . MODEL_ID . equals ( SiriusVisualIDRegistry . getModelID ( view ) ) ;
}


// Suggested Revision B
public boolean provides ( IOperation operation ) {
  if ( ! ( operation instanceof CreateDecoratorsOperation ) ) {
    return false ;
  }
  IDecoratorTarget decoratorTarget = ( ( CreateDecoratorsOperation ) operation ) . getDecoratorTarget ( ) ;
  View view = decoratorTarget . getAdapter ( View . class ) ;
  return view != null && DDiagramEditPart . MODEL_ID . equals ( SiriusVisualIDRegistry . getModelID ( view ) ) ;
}


==========================this is the dividing line=============================



/** Example 19 */

/** Its a heavy read that bug! When you check if breakpoint applicable probably better reverse instanceof check and call. Instanceof is cheaper */

// Manual revision
public void startTrackingBpForProcess ( final IContainerDMContext containerDmc , final RequestMonitor rm ) {
  final IBreakpointsTargetDMContext targetBpDmc = DMContexts . getAncestorOfType ( containerDmc , IBreakpointsTargetDMContext . class ) ;
  IBreakpoint [ ] breakpoints = DebugPlugin . getDefault ( ) . getBreakpointManager ( ) . getBreakpoints ( fDebugModelId ) ;
  for ( IBreakpoint breakpoint : breakpoints ) {
    if ( breakpoint instanceof ICBreakpoint && supportsBreakpoint ( breakpoint ) ) {
      setTargetFilter ( ( ICBreakpoint ) breakpoint , containerDmc ) ;
    }
  }
  startTrackingBreakpoints ( targetBpDmc , rm ) ;
}


// Suggested Revision A
public void startTrackingBpForProcess ( final IContainerDMContext containerDmc , final RequestMonitor rm ) {
  final IBreakpointsTargetDMContext targetBpDmc = DMContexts . getAncestorOfType ( containerDmc , IBreakpointsTargetDMContext . class ) ;
  IBreakpoint [ ] breakpoints = DebugPlugin . getDefault ( ) . getBreakpointManager ( ) . getBreakpoints ( fDebugModelId ) ;
  for ( IBreakpoint breakpoint : breakpoints ) {
    if ( supportsBreakpoint ( breakpoint ) ) {
      setTargetFilter ( ( ICBreakpoint ) breakpoint , containerDmc ) ;
    }
  }
  startTrackingBreakpoints ( targetBpDmc , rm ) ;
}


// Suggested Revision B
public void startTrackingBpForProcess ( final IContainerDMContext containerDmc , final RequestMonitor rm ) {
  final IBreakpointsTargetDMContext targetBpDmc = DMContexts . getAncestorOfType ( containerDmc , IBreakpointsTargetDMContext . class ) ;
  IBreakpoint [ ] breakpoints = DebugPlugin . getDefault ( ) . getBreakpointManager ( ) . getBreakpoints ( fDebugModelId ) ;
  for ( IBreakpoint breakpoint : breakpoints ) {
    if ( breakpoint instanceof ICBreakpoint ) {
      setTargetFilter ( ( ICBreakpoint ) breakpoint , containerDmc ) ;
    }
  }
  startTrackingBreakpoints ( targetBpDmc , rm ) ;
}


==========================this is the dividing line=============================



