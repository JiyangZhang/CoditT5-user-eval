Method 0 

  public AnimationBuilder animateScale(float scale) {
    if (!isImageReady()) {
      return null;
    }
    return new AnimationBuilder(scale);
  }



=======================================================



Method 1 

  public static BroadcasterFactory buildAndReplaceDefaultfactory(
      Class<? extends Broadcaster> clazz, AtmosphereServlet.AtmosphereConfig c)
      throws InstantiationException, IllegalAccessException {

    factory = new DefaultBroadcasterFactory(clazz);
    config = c;
    return factory;
  }



=======================================================



Method 2 

  public boolean searchText(String regex) {
    boolean found = searcher.searchText(regex, 0, true);
    return found;
  }



=======================================================



Method 3 

  public int removeActiveMessage() {
    return removeMessage(currentPage);
  }



=======================================================



Method 4 

  protected Configuration doConfigure(InputStream stream, String resourceName)
      throws HibernateException {
    try {
      List errors = new ArrayList();
      Document document =
          xmlHelper
              .createSAXReader(resourceName, errors, entityResolver)
              .read(new InputSource(stream));
      if (errors.size() != 0) {
        throw new MappingException("invalid configuration", (Throwable) errors.get(0));
      }
      doConfigure(document);
    } catch (DocumentException e) {
      throw new HibernateException("Could not parse configuration: " + resourceName, e);
    } finally {
      try {
        stream.close();
      } catch (IOException ioe) {
        log.warn("could not close input stream for: " + resourceName, ioe);
      }
    }
    return this;
  }



=======================================================



Method 5 

  public static int nextPowerOfTwo(final int value) {
    return NUM << (NUM - Integer.numberOfLeadingZeros(value - NUM));
  }



=======================================================



Method 6 

  public boolean getExtraBoolean(String key) throws JSONException {
    return mExtraData.getBoolean(key);
  }



=======================================================



Method 7 

  protected Object convertTimestampToEpochMillisAsDate(
      Column column, Field fieldDefn, Object data) {
    if (data == null) {
      data = fieldDefn.schema().defaultValue();
    }
    if (data == null) {
      if (column.isOptional()) return null;
      return new java.util.Date(0L); // return epoch
    }
    try {
      return new java.util.Date(Timestamp.toEpochMillis(data));
    } catch (IllegalArgumentException e) {
      return handleUnknownData(column, fieldDefn, data);
    }
  }



=======================================================



Method 8 

  public static Blob generateProxy(InputStream stream, long length) {
    return new BlobProxy(stream, length);
  }



=======================================================



Method 9 

  protected FieldValueInfo completeValueForList(
      ExecutionContext executionContext,
      ExecutionStrategyParameters parameters,
      Iterable<Object> iterableValues) {

    Collection<Object> values = FpKit.toCollection(iterableValues);
    ExecutionTypeInfo typeInfo = parameters.getTypeInfo();
    GraphQLList fieldType = typeInfo.castType(GraphQLList.class);
    GraphQLFieldDefinition fieldDef = parameters.getTypeInfo().getFieldDefinition();

    InstrumentationFieldCompleteParameters instrumentationParams =
        new InstrumentationFieldCompleteParameters(
            executionContext, parameters, fieldDef, fieldTypeInfo(parameters, fieldDef), values);
    Instrumentation instrumentation = executionContext.getInstrumentation();

    InstrumentationContext<ExecutionResult> completeListCtx =
        instrumentation.beginFieldListComplete(instrumentationParams);

    List<FieldValueInfo> fieldValueInfos = new ArrayList<>();
    int index = 0;
    for (Object item : values) {
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

      int finalIndex = index;
      ExecutionStrategyParameters newParameters =
          parameters.transform(
              builder ->
                  builder
                      .typeInfo(wrappedTypeInfo)
                      .nonNullFieldValidator(nonNullableFieldValidator)
                      .listSize(values.size())
                      .currentListIndex(finalIndex)
                      .path(indexedPath)
                      .source(item));
      fieldValueInfos.add(completeValue(executionContext, newParameters));
      index++;
    }

    CompletableFuture<List<ExecutionResult>> resultsFuture =
        Async.each(fieldValueInfos, (item, i) -> item.getFieldValue());

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

    return FieldValueInfo.newFieldValueInfo(LIST)
        .fieldValue(overallResult)
        .fieldValueInfos(fieldValueInfos)
        .build();
  }



=======================================================



Method 10 

  public UpdateUserOper body(User body) {
    reqSpec.setBody(body);
    return this;
  }



=======================================================



Method 11 

  public static String getMessageId(SipRequest request) {
    String result = null;
    try {
      // Read ID from multipart content
      String content = request.getContent();
      int index = content.indexOf(ImdnUtils.HEADER_IMDN_MSG_ID);
      if (index != -1) {
        index = index + ImdnUtils.HEADER_IMDN_MSG_ID.length() + 1;
        String part = content.substring(index);
        String msgId = part.substring(0, part.indexOf(CRLF));
        result = msgId.trim();
      }
    } catch (Exception e) {
    }
    return result;
  }



=======================================================



Method 12 

  public float getY() {
    if (top == null) {
      calculateTop();
    }

    return top.floatValue();
  }



=======================================================



Method 13 

  public RepoContentSource removeContentSource(ContentSource contentSource) {
    if ((this.repoContentSources == null) || (contentSource == null)) {
      return null;
    }

    RepoContentSource doomed = null;

    for (RepoContentSource ccs : this.repoContentSources) {
      if (contentSource.equals(ccs.getRepoContentSourcePK().getContentSource())) {
        doomed = ccs;
        break;
      }
    }

    if (doomed != null) {
      this.repoContentSources.remove(doomed);
    }

    return doomed;
  }



=======================================================



Method 14 

  private static synchronized Supplier<Annotator> getOrCreate(AnnotatorFactory factory) {
    return () -> {
      Annotator rtn = customAnnotators.get(factory.signature());
      if (rtn == null) {
        // Create the annotator
        rtn = factory.create();
        // Register the annotator
        customAnnotators.put(factory.signature(), factory.create());
        // Clean up memory if needed
        while (customAnnotators.size() > 10) {
          customAnnotators.keySet().iterator().remove();
        }
      }
      return rtn;
    };
  }



=======================================================



Method 15 

  File getBaseDir(final File file1, final File file2) {
    if (file1 == null || file2 == null) {
      return null;
    }
    final Iterator file1Parents = getParents(file1).iterator();
    final Iterator file2Parents = getParents(file2.getAbsoluteFile()).iterator();
    File result = null;
    while (file1Parents.hasNext() && file2Parents.hasNext()) {
      File next = (File) file1Parents.next();
      if (next.equals(file2Parents.next())) {
        result = next;
      } else {
        break;
      }
    }
    return result;
  }



=======================================================



Method 16 

  public static RequestQueue newRequestQueue(IRestProtocol implRestConnection, int threadPoolSize) {
    return newRequestQueue(RestParser.getInstance(implRestConnection), threadPoolSize);
  }



=======================================================



Method 17 

  @Processor
  @OAuthProtected
  @OAuthInvalidateAccessTokenOn(exception = OAuthTokenExpiredException.class)
  @Paged
  public PagingDelegate<CalendarList> getCalendarList(
      final @Optional @Default("false") boolean showHidden,
      final PagingConfiguration pagingConfiguration)
      throws IOException {

    return new TokenBasedPagingDelegate<CalendarList>() {

      @Override
      public List<CalendarList> doGetPage() throws IOException {
        com.google.api.services.calendar.Calendar.CalendarList.List calendars =
            client.calendarList().list();
        com.google.api.services.calendar.model.CalendarList list =
            calendars
                .setMaxResults(pagingConfiguration.getFetchSize())
                .setPageToken(this.getPageToken())
                .setShowHidden(showHidden)
                .execute();

        setPageToken(list.getNextPageToken());
        return CalendarList.valueOf(list.getItems(), CalendarList.class);
      }
    };
  }



=======================================================



Method 18 

  public Annotation readUndelimited(File in) throws IOException {
    FileInputStream delimited = new FileInputStream(in);
    FileInputStream undelimited = new FileInputStream(in);
    CoreNLPProtos.Document doc;
    try {
      doc = CoreNLPProtos.Document.parseFrom(delimited);
    } catch (Exception e) {
      doc = CoreNLPProtos.Document.parseDelimitedFrom(undelimited);
    } finally {
      delimited.close();
      undelimited.close();
    }
    return fromProto(doc);
  }



=======================================================



Method 19 

  private String terminalToShowWhenClosing(String handle) {
    int terminalClosing = terminals_.indexOfTerminal(handle);
    if (terminalClosing > 0) return terminals_.terminalHandleAtIndex(terminalClosing - 1);
    else if (terminalClosing + 1 < terminals_.terminalCount())
      return terminals_.terminalHandleAtIndex(terminalClosing + 1);
    else return null;
  }



=======================================================



