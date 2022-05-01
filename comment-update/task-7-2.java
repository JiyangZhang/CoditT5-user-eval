/** Method 0 */

/** @return {@link ScaleAnimationBuilder} instance. Call {@link com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAnimationBuilder#start()} to start the anim. */
  public ScaleAnimationBuilder animateScale(float scale) {
    if (!isImageReady()) {
      return null;
    }
    return new ScaleAnimationBuilder(scale);
  }



*************************this is the dividing line*****************************



/** Method 1 */

/** @param config An instance of  BroadcasterConfig */
  public static BroadcasterFactory buildAndReplaceDefaultfactory(
      Class<? extends Broadcaster> clazz, BroadcasterConfig config)
      throws InstantiationException, IllegalAccessException {

    factory = new DefaultBroadcasterFactory(clazz);
    return factory;
  }



*************************this is the dividing line*****************************



/** Method 2 */

/** @param search the string to be searched. The parameter will be interpreted as a regular expression. */
  public boolean searchText(String search) {
    boolean found = searcher.searchText(search, 0, true);
    return found;
  }



*************************this is the dividing line*****************************



/** Method 3 */

/** @return true if a message was removed, false otherwise. */
  public boolean removeActiveMessage() {
    return removeMessage(currentPage);
  }



*************************this is the dividing line*****************************



/** Method 4 */

/** @return A configuration configured via the stream */
  protected Configuration doConfigure(InputStream stream, String resourceName)
      throws HibernateException {

    org.dom4j.Document doc;
    try {
      List errors = new ArrayList();
      doc =
          xmlHelper
              .createSAXReader(resourceName, errors, entityResolver)
              .read(new InputSource(stream));
      if (errors.size() != 0) {
        throw new MappingException("invalid configuration", (Throwable) errors.get(0));
      }
    } catch (DocumentException e) {
      throw new HibernateException("Could not parse configuration: " + resourceName, e);
    } finally {
      try {
        stream.close();
      } catch (IOException ioe) {
        log.warn("could not close input stream for: " + resourceName, ioe);
      }
    }

    return doConfigure(doc);
  }



*************************this is the dividing line*****************************



/** Method 5 */

/** @return the next power of two that is larger than the specified int value. */
  public static int nextPowerOfTwo(int value) {
    if (!isPowerOfTwo(value)) {
      value--;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value |= value >> NUM;
      value++;
    }
    return value;
  }



*************************this is the dividing line*****************************



/** Method 6 */

/** @return The stored value or null if it doesn't exist in specified form. */
  public boolean getExtraBoolean(String key) {
    return mExtraData.optBoolean(key);
  }



*************************this is the dividing line*****************************



/** Method 7 */

/** @return the converted value, or null if the conversion could not be made */
  protected Object convertTimestampToEpochMillisAsDate(
      Column column, Field fieldDefn, Object data) {
    if (data == null) return null;
    try {
      return new java.util.Date(Timestamp.toEpochMillis(data));
    } catch (IllegalArgumentException e) {
      return handleUnknownData(column, fieldDefn, data);
    }
  }



*************************this is the dividing line*****************************



/** Method 8 */

/** @return The generated proxy. */
  public static Blob generateProxy(InputStream stream, long length) {
    return (Blob)
        Proxy.newProxyInstance(
            getProxyClassLoader(), PROXY_INTERFACES, new BlobProxy(stream, length));
  }



*************************this is the dividing line*****************************



/** Method 9 */

/** @return an  ExecutionResult */
  protected CompletableFuture<ExecutionResult> completeValueForList(
      ExecutionContext executionContext,
      ExecutionStrategyParameters parameters,
      Iterable<Object> iterableValues) {

    ExecutionTypeInfo typeInfo = parameters.getTypeInfo();
    GraphQLList fieldType = typeInfo.castType(GraphQLList.class);
    GraphQLFieldDefinition fieldDef = parameters.getTypeInfo().getFieldDefinition();

    InstrumentationFieldCompleteParameters instrumentationParams =
        new InstrumentationFieldCompleteParameters(
            executionContext,
            parameters,
            fieldDef,
            fieldTypeInfo(parameters, fieldDef),
            iterableValues);
    Instrumentation instrumentation = executionContext.getInstrumentation();

    InstrumentationContext<ExecutionResult> completeListCtx =
        instrumentation.beginFieldListComplete(instrumentationParams);

    CompletableFuture<List<ExecutionResult>> resultsFuture =
        Async.each(
            iterableValues,
            (item, index) -> {
              ExecutionPath indexedPath = parameters.getPath().segment(index);

              ExecutionTypeInfo wrappedTypeInfo =
                  ExecutionTypeInfo.newTypeInfo()
                      .parentInfo(typeInfo)
                      .type(fieldType.getWrappedType())
                      .path(indexedPath)
                      .fieldDefinition(fieldDef)
                      .build();

              NonNullableFieldValidator nonNullableFieldValidator =
                  new NonNullableFieldValidator(executionContext, wrappedTypeInfo);

              ExecutionStrategyParameters newParameters =
                  parameters.transform(
                      builder ->
                          builder
                              .typeInfo(wrappedTypeInfo)
                              .nonNullFieldValidator(nonNullableFieldValidator)
                              .path(indexedPath)
                              .source(item));

              return completeValue(executionContext, newParameters);
            });

    CompletableFuture<ExecutionResult> overallResult = new CompletableFuture<>();
    completeListCtx.onDispatched(overallResult);

    resultsFuture.whenComplete(
        (results, exception) -> {
          if (exception != null) {
            ExecutionResult executionResult =
                handleNonNullException(executionContext, overallResult, exception);
            completeListCtx.onCompleted(executionResult, exception);
            return;
          }
          List<Object> completedResults = new ArrayList<>();
          for (ExecutionResult completedValue : results) {
            completedResults.add(completedValue.getData());
          }
          ExecutionResultImpl executionResult = new ExecutionResultImpl(completedResults, null);
          overallResult.complete(executionResult);
        });
    overallResult.whenComplete(completeListCtx::onCompleted);
    return overallResult;
  }



*************************this is the dividing line*****************************



/** Method 10 */

/** @param user (User) Updated user object (required) */
  public UpdateUserOper body(User user) {
    reqSpec.setBody(user);
    return this;
  }



*************************this is the dividing line*****************************



/** Method 11 */

/** Returns the message id header value of a SIP request */
  public static String getMessageId(SipRequest request) {
    // Read ID from Message-Id header
    ExtensionHeader messageIdHeader =
        (ExtensionHeader) request.getHeader(ImdnUtils.HEADER_IMDN_MSG_ID);
    if (messageIdHeader != null) {
      return messageIdHeader.getValue();
    }

    // Read ID from multipart content
    try {
      String content = request.getContent();
      int index = content.indexOf(ImdnUtils.HEADER_IMDN_MSG_ID);
      if (index != -1) {
        index = index + ImdnUtils.HEADER_IMDN_MSG_ID.length() + 1;
        String part = content.substring(index);
        String msgId = part.substring(0, part.indexOf(SipUtils.CRLF));
        return msgId.trim();
      }
    } catch (Exception e) {
    }

    // No message id
    return null;
  }



*************************this is the dividing line*****************************



/** Method 12 */

/** Get the y location of the center of this circle */
  public float getY() {
    return center[1];
  }



*************************this is the dividing line*****************************



/** Method 13 */

/** Removes the content source from this channel, if it exists. */
  public ChannelContentSource removeContentSource(ContentSource contentSource) {
    if ((this.channelContentSources == null) || (contentSource == null)) {
      return null;
    }

    ChannelContentSource doomed = null;

    for (ChannelContentSource ccs : this.channelContentSources) {
      if (contentSource.equals(ccs.getChannelContentSourcePK().getContentSource())) {
        doomed = ccs;
        break;
      }
    }

    if (doomed != null) {
      this.channelContentSources.remove(doomed);
    }

    return doomed;
  }



*************************this is the dividing line*****************************



/** Method 14 */

/** @return An annotator as specified by the given name and properties. */
  private static synchronized Supplier<Annotator> getOrCreate(
      String name, Properties props, Supplier<Annotator> annotator) {
    StanfordCoreNLP.AnnotatorSignature key =
        new StanfordCoreNLP.AnnotatorSignature(name, PropertiesUtils.getSignature(name, props));
    customAnnotators.register(
        name,
        props,
        StanfordCoreNLP.GLOBAL_ANNOTATOR_CACHE.computeIfAbsent(
            key, (sig) -> Lazy.cache(annotator)));
    return () -> customAnnotators.get(name);
  }



*************************this is the dividing line*****************************



/** Method 15 */

/** Returns the common base directory between a current base directory and a given file. */
  File getBaseDir(File base, File file) {
    if (base == null) {
      return file.getParentFile().getAbsoluteFile();
    } else {
      Iterator bases = getParents(base).iterator();
      Iterator fileParents = getParents(file.getAbsoluteFile()).iterator();
      File result = null;
      while (bases.hasNext() && fileParents.hasNext()) {
        File next = (File) bases.next();
        if (next.equals(fileParents.next())) {
          result = next;
        } else {
          break;
        }
      }
      return result;
    }
  }



*************************this is the dividing line*****************************



/** Method 16 */

/** Create a new request queue, using NoHttp default request executor  HttpRestConnection and default response parser  HttpRestParser. */
  public static RequestQueue newRequestQueue(
      ImplRestConnection implRestConnection, int threadPoolSize) {
    return newRequestQueue(HttpRestParser.getInstance(implRestConnection), threadPoolSize);
  }



*************************this is the dividing line*****************************



/** Method 17 */

/** Returns an instance of  org.mule.module.google.calendar.model.CalendarList listing the calendars of the user that owns the OAuth access token. */
  @Processor
  @Inject
  @OAuthProtected
  @OAuthInvalidateAccessTokenOn(exception = OAuthTokenExpiredException.class)
  public List<CalendarList> getCalendarList(
      MuleMessage message,
      @Optional @Default("100") int maxResults,
      @Optional String pageToken,
      @Optional @Default("false") boolean showHidden)
      throws IOException {

    com.google.api.services.calendar.Calendar.CalendarList.List calendars =
        this.client.calendarList().list();
    com.google.api.services.calendar.model.CalendarList list =
        calendars
            .setMaxResults(maxResults)
            .setPageToken(pageToken)
            .setShowHidden(showHidden)
            .execute();

    this.saveNextPageToken(list, message);
    return CalendarList.valueOf(list.getItems(), CalendarList.class);
  }



*************************this is the dividing line*****************************



/** Method 18 */

/** @param is The input stream to read from. This should contain a single protocol buffer and nothing else. */
  public Annotation readUndelimited(InputStream is) throws IOException {
    return fromProto(CoreNLPProtos.Document.parseDelimitedFrom(is));
  }



*************************this is the dividing line*****************************



/** Method 19 */

/** Index of terminal to show after closing indicated terminal index */
  private int terminalToShowWhenClosing(int terminalClosing) {
    if (terminalClosing > 0) return terminalClosing - 1;
    else if (terminalClosing + 1 < getTerminalCount()) return terminalClosing + 1;
    else return -1;
  }



*************************this is the dividing line*****************************



