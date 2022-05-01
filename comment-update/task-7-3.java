/** Method 0 */

/** updated comment */
  public Collection<OsmPrimitive> getSelected() {
    return Collections.unmodifiableSet(selectedPrimitives);
  }



==========================this is the dividing line=============================



/** Method 1 */

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



/** Method 2 */

/** updated comment */
  private long now() {
    return SystemClock.uptimeMillis();
  }



==========================this is the dividing line=============================



/** Method 3 */

/** updated comment */
  public static W3CWidget getWidget(String metadata, String shindig) throws Exception {
    JSONObject gadget = null;
    JSONObject response = new JSONObject(metadata);
    JSONArray gadgets = response.getJSONArray("gadgets");
    if (gadgets.length() == 0) return null;
    gadget = gadgets.getJSONObject(0);
    return new GadgetAdapter(gadget, shindig);
  }



==========================this is the dividing line=============================



/** Method 4 */

/** updated comment */
  public String getCharset() {
    if (charset != null) {
      return charset.name();
    }
    return DEFAULT_CHARSET;
  }



==========================this is the dividing line=============================



/** Method 5 */

/** updated comment */
  public String getKDCList(String realm) throws KrbException {
    if (realm == null) {
      realm = getDefaultRealm();
    }
    Exception cause = null;
    String kdcs = getDefault(STR, realm);
    if (kdcs == null) {
      kdcs =
          java.security.AccessController.doPrivileged(
              new java.security.PrivilegedAction<String>() {

                @Override
                public String run() {
                  String osname = System.getProperty(STR);
                  if (osname.startsWith(STR)) {
                    String logonServer = System.getenv(STR);
                    if (logonServer != null && logonServer.startsWith(STR)) {
                      logonServer = logonServer.substring(NUM);
                    }
                    return logonServer;
                  }
                  return null;
                }
              });
    }
    if (kdcs == null) {
      KrbException ke = new KrbException(STR);
      if (cause != null) {
        ke.initCause(cause);
      }
      throw ke;
    }
    return kdcs;
  }



==========================this is the dividing line=============================



/** Method 6 */

/** updated comment */
  private boolean isShareable() {
    return getRequestScope().getDictionary().isShareable(obj.getClass());
  }



==========================this is the dividing line=============================



/** Method 7 */

/** updated comment */
  public static BooleanOperation predicate(Operator operation, Expression<?>... args) {
    return new BooleanOperation(operation, args);
  }



==========================this is the dividing line=============================



/** Method 8 */

/** updated comment */
  public short getRed() {
    return data[getFirst1DIndex()];
  }



==========================this is the dividing line=============================



/** Method 9 */

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



/** Method 10 */

/** updated comment */
  private Languages.Language getLanguage(String languageStr) {
    for (Languages.Language l : Languages.Language.values()) {
      if (l.name().equalsIgnoreCase(languageStr)) return l;
    }
    return null;
  }



==========================this is the dividing line=============================



/** Method 11 */

/** updated comment */
  public static <T extends CharSequence> T validIndex(final T chars, final int index) {
    return validIndex(
        chars, index, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(index));
  }



==========================this is the dividing line=============================



/** Method 12 */

/** updated comment */
  public static <T> Method findMethod(Class<?> implClass, Operation<T> operation)
      throws NoSuchMethodException {
    String name = operation.getName();
    Class<?>[] paramTypes = getPhysicalTypes(operation);
    return implClass.getMethod(name, paramTypes);
  }



==========================this is the dividing line=============================



/** Method 13 */

/** updated comment */
  public InstantConverter removeInstantConverter(InstantConverter converter)
      throws SecurityException {

    checkAlterInstantConverters();
    if (converter == null) {
      return null;
    }
    InstantConverter[] removed = new InstantConverter[1];
    iInstantConverters = iInstantConverters.remove(converter, removed);
    return removed[0];
  }



==========================this is the dividing line=============================



/** Method 14 */

/** updated comment */
  public static YourKitContext startProfile(
      boolean enableStackTelemetry,
      boolean enableCPUProfilling,
      boolean enableAllocationRecording) {
    Controller controller;
    try {
      controller = new Controller();
      // CHECKSTYLE: stop IllegalCatch
    } catch (Exception e) {
      // CHECKSTYLE: resume IllegalCatch
      LOG.info("Failed to set up YourKit controller", e);
      return null;
    }

    try {
      if (enableStackTelemetry) {
        controller.enableStackTelemetry();
        LOG.info("Enabled Yourkit stack telemetry");
      }
      // CHECKSTYLE: stop IllegalCatch
    } catch (Exception e) {
      // CHECKSTYLE: resume IllegalCatch
      LOG.info("Failed to enable YourKit stack telemetry", e);
    }

    try {
      if (enableCPUProfilling) {
        controller.startCPUProfiling(
            ProfilingModes.CPU_SAMPLING,
            Controller.DEFAULT_FILTERS,
            Controller.DEFAULT_WALLTIME_SPEC);
        LOG.info("Started YourKit CPU profiling");
      }
      // CHECKSTYLE: stop IllegalCatch
    } catch (Exception e) {
      // CHECKSTYLE: resume IllegalCatch
      LOG.info("Failed to start YourKit CPU profiling", e);
    }

    try {
      if (enableAllocationRecording) {
        controller.startAllocationRecording(
            true, ALLOCATION_RECORDING_INTERVAL, false, -1, true, false);
        LOG.info("Started YourKit allocation recording");
      }
      // CHECKSTYLE: stop IllegalCatch
    } catch (Exception e) {
      // CHECKSTYLE: resume IllegalCatch
      LOG.info("Failed to start YourKit allocation recording", e);
    }

    return new YourKitContext(controller);
  }



==========================this is the dividing line=============================



/** Method 15 */

/** updated comment */
  public String applyLocksToSql(String sql, LockOptions aliasedLockOptions, Map keyColumnNames) {
    return sql + new ForUpdateFragment(this, aliasedLockOptions, keyColumnNames).toFragmentString();
  }



==========================this is the dividing line=============================



/** Method 16 */

/** updated comment */
  @CheckForNull
  public final SCMRevision fetch(@NonNull String thingName, @CheckForNull TaskListener listener)
      throws IOException, InterruptedException {
    return retrieve(thingName, defaultListener(listener));
  }



==========================this is the dividing line=============================



/** Method 17 */

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



/** Method 18 */

/** updated comment */
  private <T> T processResponse(final ClientResponse clientResponse, final Type responseType) {
    final String response = readResponseFromClientResponse(clientResponse);
    if (clientResponse.getStatus() == NUM) {
      return null;
    } else if (clientResponse.getStatus() >= NUM) {
      throw new HandshakeAPIException(response);
    }
    try {
      return parseJson(response, responseType);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }



==========================this is the dividing line=============================



/** Method 19 */

/** updated comment */
  public RepoPackageVersion removePackageVersion(PackageVersion packageVersion) {
    if ((this.repoPackageVersions == null) || (packageVersion == null)) {
      return null;
    }

    RepoPackageVersion doomed = null;

    for (RepoPackageVersion cpv : this.repoPackageVersions) {
      if (packageVersion.equals(cpv.getRepoPackageVersionPK().getPackageVersion())) {
        doomed = cpv;
        break;
      }
    }

    if (doomed != null) {
      this.repoPackageVersions.remove(doomed);
    }

    return doomed;
  }



==========================this is the dividing line=============================



