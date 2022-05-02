/** Method 0 */

/** updated comment */
  public boolean parseMoreData(final EncodedImage encodedImage) {
    if (mParserState == NOT_A_JPEG) {
      return false;
    }

    final int dataBufferSize = encodedImage.getSize();

    // Is there any new data to parse?
    // mBytesParsed might be greater than size of dataBuffer - that happens when
    // we skip more data than is available to read inside doParseMoreData method
    if (dataBufferSize <= mBytesParsed) {
      return false;
    }

    final InputStream bufferedDataStream =
        new PooledByteArrayBufferedInputStream(
            encodedImage.getInputStream(), mByteArrayPool.get(BUFFER_SIZE), mByteArrayPool);
    try {
      StreamUtil.skip(bufferedDataStream, mBytesParsed);
      return doParseMoreData(bufferedDataStream);
    } catch (IOException ioe) {
      // Does not happen - streams returned by PooledByteBuffers do not throw IOExceptions
      Throwables.propagate(ioe);
      return false;
    } finally {
      Closeables.closeQuietly(bufferedDataStream);
    }
  }



==========================this is the dividing line=============================



/** Method 1 */

/** updated comment */
  public SQLInsertClause insertOnDuplicateKeyUpdate(
      RelationalPath<?> entity, Expression<?>... clauses) {
    SQLInsertClause insert = insert(entity);
    StringBuilder flag = new StringBuilder(" on duplicate key update ");
    for (int i = 0; i < clauses.length; i++) {
      flag.append(i > 0 ? ", " : "").append("{" + i + "}");
    }
    insert.addFlag(Position.END, ExpressionUtils.template(String.class, flag.toString(), clauses));
    return insert;
  }



==========================this is the dividing line=============================



/** Method 2 */

/** updated comment */
  public String getTypeDeclaration(Schema p) {
    if (ModelUtils.isArraySchema(p)) {
      ArraySchema ap = (ArraySchema) p;
      Schema inner = ap.getItems();
      return getTypeDeclaration(inner) + "[]";
    } else if (ModelUtils.isMapSchema(p)) {
      Schema inner = (Schema) p.getAdditionalProperties();
      // TODO not sure if the following map/hash declaration is correct
      return "{String, " + getTypeDeclaration(inner) + "}";
    } else if (!languageSpecificPrimitives.contains(getSchemaType(p))) {
      return packageName + ".Model." + super.getTypeDeclaration(p);
    }
    return super.getTypeDeclaration(p);
  }



==========================this is the dividing line=============================



/** Method 3 */

/** updated comment */
  public int compareTo(ReadablePartial partial) {
    if (partial == null) {
      throw new IllegalArgumentException("The instant must not be null");
    }
    int thisValue = get();
    int otherValue = partial.get(getFieldType());
    if (thisValue < otherValue) {
      return -1;
    } else if (thisValue > otherValue) {
      return 1;
    } else {
      return 0;
    }
  }



==========================this is the dividing line=============================



/** Method 4 */

/** updated comment */
  public boolean searchText(String regex, int matches) {
    boolean found = searcher.searchText(regex, matches, true);
    return found;
  }



==========================this is the dividing line=============================



/** Method 5 */

/** updated comment */
  public static BroadcasterFactory buildAndReplaceDefaultfactory(
      Class<? extends Broadcaster> clazz, AtmosphereServlet.AtmosphereConfig c)
      throws InstantiationException, IllegalAccessException {

    factory = new DefaultBroadcasterFactory(clazz);
    config = c;
    return factory;
  }



==========================this is the dividing line=============================



/** Method 6 */

/** updated comment */
  protected String determineSegmentColumnName(Properties params, JdbcEnvironment jdbcEnvironment) {
    final String name =
        ConfigurationHelper.getString(SEGMENT_COLUMN_PARAM, params, DEF_SEGMENT_COLUMN);
    return jdbcEnvironment
        .getIdentifierHelper()
        .toIdentifier(name)
        .render(jdbcEnvironment.getDialect());
  }



==========================this is the dividing line=============================



/** Method 7 */

/** updated comment */
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



==========================this is the dividing line=============================



/** Method 8 */

/** updated comment */
  private ClientResponse makeRemoteCall(Action action, String serviceUrl) throws Throwable {
    String urlPath = null;
    Stopwatch tracer = null;
    ClientResponse response = null;
    logger.debug("Discovery Client talking to the server {}", serviceUrl);
    try {
      // If the application is unknown do not register/renew/cancel but
      // refresh
      if ((UNKNOWN.equals(instanceInfo.getAppName())
          && (!Action.Refresh.equals(action))
          && (!Action.Refresh_Delta.equals(action)))) {
        return null;
      }
      WebResource r = discoveryApacheClient.resource(serviceUrl);
      String remoteRegionsToFetchStr;
      switch (action) {
        case Renew:
          tracer = RENEW_TIMER.start();
          urlPath = "apps/" + appPathIdentifier;
          response =
              r.path(urlPath)
                  .queryParam("status", instanceInfo.getStatus().toString())
                  .queryParam("lastDirtyTimestamp", instanceInfo.getLastDirtyTimestamp().toString())
                  .put(ClientResponse.class);
          break;
        case Refresh:
          tracer = REFRESH_TIMER.start();
          final String vipAddress = clientConfig.getRegistryRefreshSingleVipAddress();
          urlPath = vipAddress == null ? "apps/" : "vips/" + vipAddress;
          remoteRegionsToFetchStr = remoteRegionsToFetch.get();
          if (!Strings.isNullOrEmpty(remoteRegionsToFetchStr)) {
            urlPath += "?regions=" + remoteRegionsToFetchStr;
          }
          response = getUrl(serviceUrl + urlPath);
          break;
        case Refresh_Delta:
          tracer = REFRESH_DELTA_TIMER.start();
          urlPath = "apps/delta";
          remoteRegionsToFetchStr = remoteRegionsToFetch.get();
          if (!Strings.isNullOrEmpty(remoteRegionsToFetchStr)) {
            urlPath += "?regions=" + remoteRegionsToFetchStr;
          }
          response = getUrl(serviceUrl + urlPath);
          break;
        case Register:
          tracer = REGISTER_TIMER.start();
          urlPath = "apps/" + instanceInfo.getAppName();
          response =
              r.path(urlPath)
                  .type(MediaType.APPLICATION_JSON_TYPE)
                  .post(ClientResponse.class, instanceInfo);
          break;
        case Cancel:
          tracer = CANCEL_TIMER.start();
          urlPath = "apps/" + appPathIdentifier;
          response = r.path(urlPath).delete(ClientResponse.class);
          // Return without during de-registration if it is not registered
          // already and if we get a 404
          if ((!isRegisteredWithDiscovery)
              && (response.getStatus() == Status.NOT_FOUND.getStatusCode())) {
            return response;
          }
          break;
      }

      if (logger.isDebugEnabled()) {
        logger.debug(
            "Finished a call to service url {} and url path {} with status code {}.",
            new String[] {serviceUrl, urlPath, String.valueOf(response.getStatus())});
      }
      if (isOk(action, response.getStatus())) {
        return response;
      } else {
        logger.warn(
            "Action: "
                + action
                + "  => returned status of "
                + response.getStatus()
                + " from "
                + serviceUrl
                + urlPath);
        throw new RuntimeException("Bad status: " + response.getStatus());
      }
    } catch (Throwable t) {
      closeResponse(response);
      logger.warn("Can't get a response from " + serviceUrl + urlPath, t);
      throw t;
    } finally {
      if (tracer != null) {
        tracer.stop();
      }
    }
  }



==========================this is the dividing line=============================



/** Method 9 */

/** updated comment */
  public boolean searchText(String regex) {
    boolean found = searcher.searchText(regex, 0, true);
    return found;
  }



==========================this is the dividing line=============================



/** Method 10 */

/** updated comment */
  protected EntityInfo getEntityInfo(EnversService enversService, String entityName) {
    EntityConfiguration entCfg = enversService.getEntitiesConfigurations().get(entityName);
    boolean isRelationAudited = true;
    if (entCfg == null) {
      // a relation marked as RelationTargetAuditMode.NOT_AUDITED
      entCfg =
          enversService.getEntitiesConfigurations().getNotVersionEntityConfiguration(entityName);
      isRelationAudited = false;
    }
    final Class entityClass =
        ReflectionTools.loadClass(
            entCfg.getEntityClassName(), enversService.getClassLoaderService());
    return new EntityInfo(entityClass, entityName, isRelationAudited);
  }



==========================this is the dividing line=============================



/** Method 11 */

/** updated comment */
  public String toInstantiationType(Schema schema) {
    if (ModelUtils.isMapSchema(schema)) {
      Schema additionalProperties = (Schema) schema.getAdditionalProperties();
      String type = additionalProperties.getType();
      if (null == type) {
        LOGGER.error(
            "No Type defined for Additional Property "
                + additionalProperties
                + "\n" //
                + "\tIn Property: "
                + schema);
      }
      String inner = getSchemaType(additionalProperties);
      return instantiationTypes.get("map") + "<String, " + inner + ">";
    } else if (ModelUtils.isArraySchema(schema)) {
      ArraySchema arraySchema = (ArraySchema) schema;
      String inner = getSchemaType(arraySchema.getItems());
      return instantiationTypes.get("array") + "<" + inner + ">";
    } else {
      return null;
    }
  }



==========================this is the dividing line=============================



/** Method 12 */

/** updated comment */
  public static String normalizeDateString(String s, Date ctxdate) {
    // TODO [pengqi]: need to handle basic localization ("å¨ä¸æäºæ¥å°[å
«æ¥]é´")
    // TODO [pengqi]: need to handle literal numeral dates (usually used in events, e.g. "ä¸ä¸äº"
    // for 03-15)
    // TODO [pengqi]: might need to add a pattern for centuries ("ä¸ä¸çºª90å¹´ä»£")?
    String ctxyear = new SimpleDateFormat("yyyy").format(ctxdate);
    String ctxmonth = new SimpleDateFormat("MM").format(ctxdate);
    String ctxday = new SimpleDateFormat("dd").format(ctxdate);

    Pattern p = Pattern.compile("^" + BASIC_YYYYMMDD_PATTERN + "$");
    Matcher m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      res.append(normalizeYear(m.group(1), ctxyear));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(3), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + BASIC_MMDD_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 2) {
      StringBuilder res = new StringBuilder();

      res.append(ctxyear);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + BASIC_DD_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 1) {
      StringBuilder res = new StringBuilder();

      res.append(ctxyear);
      res.append("-");
      res.append(ctxmonth);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxday));

      return res.toString();
    }

    p = Pattern.compile("^" + ENGLISH_MMDDYYYY_PATTERN + "$");
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      if (m.group(3) == null) res.append(ctxyear);
      else res.append(normalizeYear(m.group(3), ctxyear));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1), ctxmonth));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2), ctxday));

      return res.toString();
    }

    return s;
  }



==========================this is the dividing line=============================



/** Method 13 */

/** updated comment */
  public SubProjectData getProjectInfo(AbstractProject context) {

    SubProjectData subProjectData = new SubProjectData();

    iterateBuilds(context, projects, subProjectData);

    // We don't want to show a project twice
    subProjectData.getTriggered().removeAll(subProjectData.getDynamic());
    subProjectData.getTriggered().removeAll(subProjectData.getFixed());

    return subProjectData;
  }



==========================this is the dividing line=============================



/** Method 14 */

/** updated comment */
  public boolean isFlagSet(int flagsToCheck) {
    return (flags & flagsToCheck) != 0;
  }



==========================this is the dividing line=============================



/** Method 15 */

/** updated comment */
  File getBaseDir(final File file1, final File file2) {
    if (file1 == null || file2 == null) {
      return null;
    }
    final Iterator bases = getParents(file1).iterator();
    final Iterator fileParents = getParents(file2.getAbsoluteFile()).iterator();
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



==========================this is the dividing line=============================



/** Method 16 */

/** updated comment */
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



==========================this is the dividing line=============================



/** Method 17 */

/** updated comment */
  @CheckForNull
  public final SCMRevision fetch(@NonNull String thingName, @CheckForNull TaskListener listener)
      throws IOException, InterruptedException {
    return retrieve(thingName, defaultListener(listener));
  }



==========================this is the dividing line=============================



/** Method 18 */

/** updated comment */
  public Action doCometSupport(AtmosphereRequest req, AtmosphereResponse res)
      throws IOException, ServletException {
    req.setAttribute(BROADCASTER_FACTORY, broadcasterFactory);
    req.setAttribute(PROPERTY_USE_STREAM, useStreamForFlushingComments);
    req.setAttribute(BROADCASTER_CLASS, broadcasterClassName);
    req.setAttribute(ATMOSPHERE_CONFIG, config);

    Action a = null;
    try {
      if ((config.getInitParameter(ALLOW_QUERYSTRING_AS_REQUEST) != null
              || (isIECandidate(req) || req.getParameter(HeaderConfig.JSONP_CALLBACK_NAME) != null))
          && req.getAttribute(WebSocket.WEBSOCKET_SUSPEND) == null) {

        Map<String, String> headers = configureQueryStringAsRequest(req);
        String body = headers.remove(ATMOSPHERE_POST_BODY);
        if (body != null && body.isEmpty()) {
          body = null;
        }

        req.headers(headers)
            .method(
                body != null && req.getMethod().equalsIgnoreCase("GET") ? "POST" : req.getMethod());

        if (body != null) {
          req.body(body);
        }

        a = asyncSupport.service(req, res);
      } else {
        return asyncSupport.service(req, res);
      }
    } catch (IllegalStateException ex) {
      if (ex.getMessage() != null
          && (ex.getMessage().startsWith("Tomcat failed")
              || ex.getMessage().startsWith("JBoss failed"))) {
        if (!isFilter) {
          logger.warn(
              "Failed using comet support: {}, error: {} Is the Nio or Apr Connector enabled?",
              asyncSupport.getClass().getName(),
              ex.getMessage());
          logger.warn("Using BlockingIOCometSupport.");
        }
        logger.trace(ex.getMessage(), ex);

        asyncSupport = new BlockingIOCometSupport(config);
        doCometSupport(req, res);
      } else {
        logger.error("AtmosphereServlet exception", ex);
        throw ex;
      }
    } finally {
      if (req != null && a != null && a.type != Action.TYPE.SUSPEND) {
        req.destroy();
        res.destroy();
      }
    }
    return null;
  }



==========================this is the dividing line=============================



/** Method 19 */

/** updated comment */
  public <T> int querySimpleList(
      Class<T> c, String sqlCmd, Connection conn, Collection<T> result) { // Check status
    if (checkOpen() == false) return -1;
    // Start query
    ResultSet rs = null;
    try { // Log performance
      long start = System.currentTimeMillis();
      if (log.isInfoEnabled()) log.info("executing: " + sqlCmd);
      // Get the next Value
      rs = driver.executeQuery(sqlCmd, null, false, conn);
      if (rs == null) { // Error
        error(driver);
        return -1;
      }
      // Check Result
      int count = 0;
      while (rs.next()) {
        T item = ObjectUtils.convert(c, rs.getObject(1));
        result.add(item);
        count++;
      }
      // No Value
      if (log.isInfoEnabled())
        log.info(
            "querySimpleList retured "
                + String.valueOf(count)
                + " items. Query completed in "
                + String.valueOf(System.currentTimeMillis() - start)
                + " ms");
      clearError();
      return count;
    } catch (ClassCastException e) {
      log.error("querySingleValue cast exception: ", e);
      error(Errors.Exception, e);
      return -1;
    } catch (SQLException e) {
      log.error("querySimpleList exception: ", e);
      error(DBErrors.QueryFailed, e);
      return -1;
    } finally { // Cleanup
      closeResultSet(rs);
    }
  }



==========================this is the dividing line=============================



