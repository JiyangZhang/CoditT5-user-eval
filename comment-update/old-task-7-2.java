Method 0 

  public ScaleAnimationBuilder animateScale(float scale) {
    if (!isImageReady()) {
      return null;
    }
    return new ScaleAnimationBuilder(scale);
  }



=======================================================



Method 1 

  public static BroadcasterFactory buildAndReplaceDefaultfactory(
      Class<? extends Broadcaster> clazz, BroadcasterConfig config)
      throws InstantiationException, IllegalAccessException {

    factory = new DefaultBroadcasterFactory(clazz);
    return factory;
  }



=======================================================



Method 2 

  public boolean searchText(String search) {
    boolean found = searcher.searchText(search, 0, true);
    return found;
  }



=======================================================



Method 3 

  public boolean removeActiveMessage() {
    return removeMessage(currentPage);
  }



=======================================================



Method 4 

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



=======================================================



Method 5 

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



=======================================================



Method 6 

  public boolean getExtraBoolean(String key) {
    return mExtraData.optBoolean(key);
  }



=======================================================



Method 7 

  protected Object convertTimestampToEpochMillisAsDate(
      Column column, Field fieldDefn, Object data) {
    if (data == null) return null;
    try {
      return new java.util.Date(Timestamp.toEpochMillis(data));
    } catch (IllegalArgumentException e) {
      return handleUnknownData(column, fieldDefn, data);
    }
  }



=======================================================



Method 8 

  public static Blob generateProxy(InputStream stream, long length) {
    return (Blob)
        Proxy.newProxyInstance(
            getProxyClassLoader(), PROXY_INTERFACES, new BlobProxy(stream, length));
  }



=======================================================



Method 9 

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



=======================================================



Method 10 

  public UpdateUserOper body(User user) {
    reqSpec.setBody(user);
    return this;
  }



=======================================================



Method 11 

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



=======================================================



Method 12 

  public float getY() {
    return center[1];
  }



=======================================================



Method 13 

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



=======================================================



Method 14 

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



=======================================================



Method 15 

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



=======================================================



Method 16 

  public static RequestQueue newRequestQueue(
      ImplRestConnection implRestConnection, int threadPoolSize) {
    return newRequestQueue(HttpRestParser.getInstance(implRestConnection), threadPoolSize);
  }



=======================================================



Method 17 

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



=======================================================



Method 18 

  public Annotation readUndelimited(InputStream is) throws IOException {
    return fromProto(CoreNLPProtos.Document.parseDelimitedFrom(is));
  }



=======================================================



Method 19 

  private int terminalToShowWhenClosing(int terminalClosing) {
    if (terminalClosing > 0) return terminalClosing - 1;
    else if (terminalClosing + 1 < getTerminalCount()) return terminalClosing + 1;
    else return -1;
  }



=======================================================



