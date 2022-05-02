/** Method 0 */

/** @param dataBufferRef Next set of bytes received by the caller */
  public boolean parseMoreData(final CloseableReference<PooledByteBuffer> dataBufferRef) {
    if (mParserState == NOT_A_JPEG) {
      return false;
    }

    final PooledByteBuffer dataBuffer = dataBufferRef.get();
    final int dataBufferSize = dataBuffer.size();

    // Is there any new data to parse?
    // mBytesParsed might be greater than size of dataBuffer - that happens when
    // we skip more data than is available to read inside doParseMoreData method
    if (dataBufferSize <= mBytesParsed) {
      return false;
    }

    final InputStream bufferedDataStream =
        new PooledByteArrayBufferedInputStream(
            new PooledByteBufferInputStream(dataBuffer),
            mByteArrayPool.get(BUFFER_SIZE),
            mByteArrayPool);
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



*************************this is the dividing line*****************************



/** Method 1 */

/** @param clause clause */
  public SQLInsertClause insertOnDuplicateKeyUpdate(
      RelationalPath<?> entity, Expression<?> clause) {
    SQLInsertClause insert = insert(entity);
    insert.addFlag(
        Position.END,
        ExpressionUtils.template(String.class, " on duplicate key update {0}", clause));
    return insert;
  }



*************************this is the dividing line*****************************



/** Method 2 */

/** @param p Swagger Property object */
  public String getTypeDeclaration(Property p) {
    if (p instanceof ArrayProperty) {
      ArrayProperty ap = (ArrayProperty) p;
      Property inner = ap.getItems();
      return getTypeDeclaration(inner) + "[]";
    } else if (p instanceof MapProperty) {
      MapProperty mp = (MapProperty) p;
      Property inner = mp.getAdditionalProperties();
      // TODO not sure if the following map/hash declaration is correct
      return "{String, " + getTypeDeclaration(inner) + "}";
    } else if (!languageSpecificPrimitives.contains(getSwaggerType(p))) {
      return packageName + ".Model." + super.getTypeDeclaration(p);
    }
    return super.getTypeDeclaration(p);
  }



*************************this is the dividing line*****************************



/** Method 3 */

/** @param instant the instant to compare to */
  public int compareTo(ReadablePartial instant) {
    if (instant == null) {
      throw new IllegalArgumentException("The instant must not be null");
    }
    int thisValue = get();
    int otherValue = instant.get(getField());
    if (thisValue < otherValue) {
      return -1;
    } else if (thisValue > otherValue) {
      return 1;
    } else {
      return 0;
    }
  }



*************************this is the dividing line*****************************



/** Method 4 */

/** @param search the string to be searched. The parameter will be interpreted as a regular expression. */
  public boolean searchText(String search, int matches) {
    boolean found = searcher.searchText(search, matches, true);
    return found;
  }



*************************this is the dividing line*****************************



/** Method 5 */

/** @param config An instance of  BroadcasterConfig */
  public static BroadcasterFactory buildAndReplaceDefaultfactory(
      Class<? extends Broadcaster> clazz, BroadcasterConfig config)
      throws InstantiationException, IllegalAccessException {

    factory = new DefaultBroadcasterFactory(clazz);
    return factory;
  }



*************************this is the dividing line*****************************



/** Method 6 */

/** @param dialect The dialect in effect */
  protected String determineSegmentColumnName(Properties params, Dialect dialect) {
    final ObjectNameNormalizer normalizer =
        (ObjectNameNormalizer) params.get(IDENTIFIER_NORMALIZER);
    final String name =
        ConfigurationHelper.getString(SEGMENT_COLUMN_PARAM, params, DEF_SEGMENT_COLUMN);
    return normalizer.toDatabaseIdentifierText(name);
  }



*************************this is the dividing line*****************************



/** Method 7 */

/** @param is The input stream to read from. This should contain a single protocol buffer and nothing else. */
  public Annotation readUndelimited(InputStream is) throws IOException {
    return fromProto(CoreNLPProtos.Document.parseDelimitedFrom(is));
  }



*************************this is the dividing line*****************************



/** Method 8 */

/** @param action the action to be performed on eureka server. Try the fallback servers in case of problems communicating to the primary one. */
  private ClientResponse makeRemoteCall(Action action, int serviceUrlIndex) throws Throwable {
    String urlPath = null;
    Stopwatch tracer = null;
    String serviceUrl = eurekaServiceUrls.get().get(serviceUrlIndex);
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
      String msg = "Can't get a response from " + serviceUrl + urlPath;
      if (eurekaServiceUrls.get().size() > (++serviceUrlIndex)) {
        logger.warn(msg, t);
        logger.warn("Trying backup: " + eurekaServiceUrls.get().get(serviceUrlIndex));
        SERVER_RETRY_COUNTER.increment();
        return makeRemoteCall(action, serviceUrlIndex);
      } else {
        ALL_SERVER_FAILURE_COUNT.increment();
        logger.error(
            msg + "\nCan't contact any eureka nodes - possibly a security group issue?", t);
        throw t;
      }
    } finally {
      if (tracer != null) {
        tracer.stop();
      }
    }
  }



*************************this is the dividing line*****************************



/** Method 9 */

/** @param search the string to be searched. The parameter will be interpreted as a regular expression. */
  public boolean searchText(String search) {
    boolean found = searcher.searchText(search, 0, true);
    return found;
  }



*************************this is the dividing line*****************************



/** Method 10 */

/** @param verCfg Audit configuration. */
  protected EntityInfo getEntityInfo(AuditConfiguration verCfg, String entityName) {
    EntityConfiguration entCfg = verCfg.getEntCfg().get(entityName);
    boolean isRelationAudited = true;
    if (entCfg == null) {
      // a relation marked as RelationTargetAuditMode.NOT_AUDITED
      entCfg = verCfg.getEntCfg().getNotVersionEntityConfiguration(entityName);
      isRelationAudited = false;
    }
    final Class entityClass =
        ReflectionTools.loadClass(entCfg.getEntityClassName(), verCfg.getClassLoaderService());
    return new EntityInfo(entityClass, entityName, isRelationAudited);
  }



*************************this is the dividing line*****************************



/** Method 11 */

/** @param p Swagger property object */
  public String toInstantiationType(Property p) {
    if (p instanceof MapProperty) {
      MapProperty ap = (MapProperty) p;
      Property additionalProperties2 = ap.getAdditionalProperties();
      String type = additionalProperties2.getType();
      if (null == type) {
        LOGGER.error(
            "No Type defined for Additional Property "
                + additionalProperties2
                + "\n" //
                + "\tIn Property: "
                + p);
      }
      String inner = getSwaggerType(additionalProperties2);
      return instantiationTypes.get("map") + "<String, " + inner + ">";
    } else if (p instanceof ArrayProperty) {
      ArrayProperty ap = (ArrayProperty) p;
      String inner = getSwaggerType(ap.getItems());
      return instantiationTypes.get("array") + "<" + inner + ">";
    } else {
      return null;
    }
  }



*************************this is the dividing line*****************************



/** Method 12 */

/** @param docdate The document date */
  public static String normalizeDateString(String s, Date docdate) {
    // TODO [pengqi]: still need to handle relative dates ("å»å¹´") and temporal references
    // ("å½æ¶")
    // TODO [pengqi]: need to handle irregular years ("81å¹´")
    // TODO [pengqi]: need to handle basic localization ("å¨ä¸æäºæ¥å°[å
«æ¥]é´")
    Pattern p = Pattern.compile(BASIC_YYYYMMDD_PATTERN);
    Matcher m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();
      String year = m.group(1);
      for (int i = 0; i < year.length(); i++) {
        String t = "" + year.charAt(i);
        if (CHINESE_LITERAL_DECIMAL_PATTERN.matcher(t).matches()) {
          if (wordsToValues.containsKey(t)) res.append((int) wordsToValues.getCount(t));
          else
            // something unexpected happened
            return null;
        } else res.append(t);
      }

      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(3)));

      return res.toString();
    }

    p = Pattern.compile(BASIC_MMDD_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 2) {
      StringBuilder res = new StringBuilder();
      String year = new SimpleDateFormat("yyyy").format(docdate);

      res.append(year);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));

      return res.toString();
    }

    p = Pattern.compile(BASIC_DD_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 1) {
      StringBuilder res = new StringBuilder();
      String year = new SimpleDateFormat("yyyy").format(docdate);
      String month = new SimpleDateFormat("MM").format(docdate);

      res.append(year);
      res.append("-");
      res.append(month);
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));

      return res.toString();
    }

    p = Pattern.compile(ENGLISH_MMDDYYYY_PATTERN);
    m = p.matcher(s);

    if (m.find() && m.groupCount() == 3) {
      StringBuilder res = new StringBuilder();

      String year = new SimpleDateFormat("yyyy").format(docdate);

      if (m.group(3) == null) res.append(year);
      else res.append(m.group(3));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(1)));
      res.append("-");
      res.append(normalizeMonthOrDay(m.group(2)));

      return res.toString();
    }

    return s;
  }



*************************this is the dividing line*****************************



/** Method 13 */

/** Provides a list containing four set, each containing projects to be displayed on the project view for projects using the parameterized trigger plugin under 'Subprojects'.  */
  public List<Set<?>> getProjectInfo(AbstractProject context) {

    Comparator customComparator =
        new Comparator<AbstractProject>() {
          public int compare(AbstractProject abstractProject1, AbstractProject abstractProject2) {
            return abstractProject1.getFullName().compareTo(abstractProject2.getFullName());
          }
        };

    Set<AbstractProject> dynamicProject = new TreeSet<AbstractProject>(customComparator);
    Set<AbstractProject> staticProject = new TreeSet<AbstractProject>(customComparator);
    Set<AbstractProject> triggeredProject = new TreeSet<AbstractProject>(customComparator);
    Set<String> unresolvedProject = new TreeSet<String>();

    iterateBuilds(
        context, projects, dynamicProject, staticProject, triggeredProject, unresolvedProject);

    // We don't want to show a project twice
    triggeredProject.removeAll(dynamicProject);
    triggeredProject.removeAll(staticProject);

    return Arrays.asList(staticProject, dynamicProject, triggeredProject, unresolvedProject);
  }



*************************this is the dividing line*****************************



/** Method 14 */

/** Checks if a flag is set. */
  public boolean isFlagSet(int flag) {
    return (flags & flag) != 0;
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



/** Method 17 */

/** Looks up a specific revision based on some SCM-specific set of permissible syntaxes. */
  @CheckForNull
  public final SCMRevision fetch(@NonNull String revision, @CheckForNull TaskListener listener)
      throws IOException, InterruptedException {
    return retrieve(revision, defaultListener(listener));
  }



*************************this is the dividing line*****************************



/** Method 18 */

/** Invoke the proprietary  CometSupport */
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

        a = cometSupport.service(req, res);
      } else {
        return cometSupport.service(req, res);
      }
    } catch (IllegalStateException ex) {
      if (ex.getMessage() != null
          && (ex.getMessage().startsWith("Tomcat failed")
              || ex.getMessage().startsWith("JBoss failed"))) {
        if (!isFilter) {
          logger.warn(
              "Failed using comet support: {}, error: {} Is the Nio or Apr Connector enabled?",
              cometSupport.getClass().getName(),
              ex.getMessage());
          logger.warn("Using BlockingIOCometSupport.");
        }
        logger.trace(ex.getMessage(), ex);

        cometSupport = new BlockingIOCometSupport(config);
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



*************************this is the dividing line*****************************



/** Method 19 */

/** Returns a one dimensional array from an sql query. */
  public <T> List<T> querySimpleList(
      Class<T> c, String sqlCmd, Connection conn) { // Execute the  Statement
    if (checkOpen() == false) return null;
    // Debug
    ResultSet rs = null;
    try { // Check Open
      if (checkOpen() == false) return null;
      // Debug
      long start = System.currentTimeMillis();
      if (log.isInfoEnabled()) log.info("executing: " + sqlCmd);
      // Get the next Value
      rs = driver.executeQuery(sqlCmd, null, false, conn);
      if (rs == null) { // Error
        error(driver);
        return null;
      }
      // Check Result
      List<T> result = new ArrayList<T>();
      while (rs.next()) {
        T item = ObjectUtils.convert(c, rs.getObject(1));
        result.add(item);
      }
      // No Value
      if (log.isInfoEnabled())
        log.info(
            "querySimpleList retured "
                + String.valueOf(result.size())
                + " items. Query completed in "
                + String.valueOf(System.currentTimeMillis() - start)
                + " ms");
      clearError();
      return result;
    } catch (ClassCastException e) {
      log.error("querySingleValue cast exception: ", e);
      error(Errors.Exception, e);
      return null;
    } catch (SQLException e) {
      log.error("querySimpleList exception: ", e);
      error(DBErrors.QueryFailed, e);
      return null;
    } finally { // Cleanup
      closeResultSet(rs);
    }
  }



*************************this is the dividing line*****************************



