/** Method 0 */

/** Return a list of all selected objects. */
  public Collection<OsmPrimitive> getSelected() {
    // It would be nice to have this be a copy-on-write list
    // or an Collections.unmodifiableList().  It would be
    // much faster for large selections.  May users just
    // call this, and only check the .size().
    return new ArrayList<OsmPrimitive>(selectedPrimitives);
  }



*************************this is the dividing line*****************************



/** Method 1 */

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



/** Method 2 */

/** @return the current time in ms */
  private long now() {
    return mMonotonicClock == null ? SystemClock.uptimeMillis() : mMonotonicClock.now();
  }



*************************this is the dividing line*****************************



/** Method 3 */

/** Marshall JSON metadata into a new Widget instance */
  public static Widget getWidget(String metadata, String shindig) throws Exception {
    JSONObject gadget = null;
    Widget widget = null;
    JSONObject response = new JSONObject(metadata);
    JSONArray gadgets = response.getJSONArray("gadgets");
    if (gadgets.length() > 0) {
      gadget = gadgets.getJSONObject(0);
      if (gadget.has("errors")) throw new Exception("Invalid gadget - Shindig error");

      widget = new Widget();
      // Defaults
      String title = "Untitled Gadget";
      int height = 200;
      int width = 320;
      String author = "Unknown Author";
      String description = "Google Gadget";
      String icon = DEFAULT_ICON;

      if (!gadget.has("url")) throw new Exception("Invalid gadget - URL missing");
      if (gadget.getString("url") == null || gadget.getString("url").equals(""))
        throw new Exception("Invalid gadget - Invalid URL");
      try {
        @SuppressWarnings("unused")
        URL url = new URL(gadget.getString("url"));
      } catch (Exception e) {
        throw new Exception("Invalid gadget - invalid URL");
      }

      // Use the URL as the GUID
      widget.setGuid(gadget.getString("url"));

      // We should be able to use the "iframeUrl" property here, but
      // it isn't very reliable at generating a usable value, so we construct
      // a very basic URL instead
      StartFile sf = new StartFile();
      sf.setWidget(widget);
      // FIXME we need to use real locales in these URLs
      sf.setUrl(
          shindig + "/gadgets/ifr?url=" + gadget.getString("url") + "&amp;lang=en&amp;country=UK");

      if (gadget.has("height")) if (gadget.getInt("height") != 0) height = gadget.getInt("height");
      if (gadget.has("width")) if (gadget.getInt("width") != 0) width = gadget.getInt("width");

      if (gadget.has("author")) {
        if (gadget.getString("author") != null) {
          if (!(gadget.getString("author").trim()).equals("")) {
            author = gadget.getString("author");
          }
        }
      }

      if (gadget.has("title")) {
        if (gadget.getString("title") != null) {
          if (!(gadget.getString("title").trim()).equals("")) {
            title = gadget.getString("title");
          }
        }
      }

      // Override the title with directory title if present (this is intended for gallery use)
      if (gadget.has("directory_title")) {
        if (gadget.getString("directory_title") != null) {
          if (!(gadget.getString("directory_title").trim()).equals("")) {
            title = gadget.getString("directory_title");
          }
        }
      }

      if (gadget.has("description")) {
        if (gadget.getString("description") != null) {
          if (!(gadget.getString("description").trim()).equals("")) {
            title = gadget.getString("description");
          }
        }
      }

      if (gadget.has("thumbnail")) {
        if (gadget.getString("thumbnail") != null) {
          if (!(gadget.getString("thumbnail").trim()).equals("")) {
            icon = gadget.getString("thumbnail");
          }
        }
      }

      widget.setMaximize(false);
      widget.setHeight(height);
      widget.setWidth(width);
      Name name = new Name();
      name.setWidget(widget);
      name.setName(title);
      Description desc = new Description();
      desc.setWidget(widget);
      desc.setContent(description);
      WidgetIcon wicon = new WidgetIcon();
      wicon.setSrc(icon);
      wicon.setWidget(widget);
      widget.setWidgetAuthor(author);

      widget.save();
      sf.save();
      name.save();
      wicon.save();
      desc.save();
    }
    return widget;
  }



*************************this is the dividing line*****************************



/** Method 4 */

/** @return Returns the charset. */
  public String getCharset() {
    return charset;
  }



*************************this is the dividing line*****************************



/** Method 5 */

/** @return the list of KDCs */
  public String getKDCList(String realm) {
    if (realm == null) {
      realm = getDefaultRealm();
    }
    String kdcs = getDefault(STR, realm);
    if (kdcs == null) {
      return null;
    }
    return kdcs;
  }



*************************this is the dividing line*****************************



/** Method 6 */

/** Checks if this persistent resource's underlying entity is sharable. */
  private boolean isShareable() {
    return getRequestScope().getDictionary().isSharable(obj.getClass());
  }



*************************this is the dividing line*****************************



/** Method 7 */

/** @param operator operator */
  public static BooleanOperation predicate(Operator operator, Expression<?>... args) {
    return new BooleanOperation(operator, args);
  }



*************************this is the dividing line*****************************



/** Method 8 */

/** @return red value in given position */
  public short getRed(final int i) {
    return data[get1DIndex(i)];
  }



*************************this is the dividing line*****************************



/** Method 9 */

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



/** Method 10 */

/** Get the  edu.stanford.nlp.international.Language object corresponding to the given language string. */
  private Language getLanguage(String languageStr) {
    for (Language l : Language.values()) {
      if (l.name().equalsIgnoreCase(languageStr)) return l;
    }
    return null;
  }



*************************this is the dividing line*****************************



/** Method 11 */

/** @return the validated collection (never {@code null} for method chaining) */
  public static <T extends Collection<?>> T validIndex(final T collection, final int index) {
    return validIndex(
        collection, index, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(index));
  }



*************************this is the dividing line*****************************



/** Method 12 */

/** Searches an array of methods for a match against the given operation */
  public static Method findMethod(Operation<?> operation, Method[] methods) {
    for (Method method : methods) {
      if (match(operation, method)) {
        return method;
      }
    }
    return null;
  }



*************************this is the dividing line*****************************



/** Method 13 */

/** Removes a converter from the set of converters, by index. */
  public InstantConverter removeInstantConverter(int index) throws SecurityException {
    checkAlterInstantConverters();
    InstantConverter[] removed = new InstantConverter[1];
    iInstantConverters = iInstantConverters.remove(index, removed);
    return removed[0];
  }



*************************this is the dividing line*****************************



/** Method 14 */

/** Convenient replacement of  #startProfilingCPU(long) with  ProfilingModes#CPU_TRACING for the mode. */
  public static YourKitContext startProfile(GiraphConfiguration conf) {
    Controller controller = null;
    try {
      controller = new Controller();
      controller.enableStackTelemetry();
      controller.startCPUProfiling(ProfilingModes.CPU_SAMPLING, Controller.DEFAULT_FILTERS);
      LOG.debug("Started YourKit profiling CPU");
      // CHECKSTYLE: stop IllegalCatch
    } catch (Exception e) {
      // CHECKSTYLE: resume IllegalCatch
      LOG.debug("Failed to start YourKit CPU profiling", e);
    }
    return new YourKitContext(controller);
  }



*************************this is the dividing line*****************************



/** Method 15 */

/** @param aliasedLockOptions a map of lock options indexed by aliased table names. */
  public String applyLocksToSql(String sql, Map aliasedLockOptions, Map keyColumnNames) {
    return sql + new ForUpdateFragment(this, aliasedLockOptions, keyColumnNames).toFragmentString();
  }



*************************this is the dividing line*****************************



/** Method 16 */

/** Looks up a specific revision based on some SCM-specific set of permissible syntaxes. */
  @CheckForNull
  public final SCMRevision fetch(@NonNull String revision, @CheckForNull TaskListener listener)
      throws IOException, InterruptedException {
    return retrieve(revision, defaultListener(listener));
  }



*************************this is the dividing line*****************************



/** Method 17 */

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



/** Method 18 */

/** @return the response, or an Exception if something bad happened */
  private <T> T processResponse(final ClientResponse clientResponse, final Type responseType) {
    final String response = readResponseFromClientResponse(clientResponse);
    if (clientResponse.getStatus() >= NUM) {
      throw new HandshakeAPIException(response);
    }
    try {
      return parseJson(response, responseType);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }



*************************this is the dividing line*****************************



/** Method 19 */

/** Removes the package version from this channel, if it exists. */
  public ChannelPackageVersion removePackageVersion(PackageVersion packageVersion) {
    if ((this.channelPackageVersions == null) || (packageVersion == null)) {
      return null;
    }

    ChannelPackageVersion doomed = null;

    for (ChannelPackageVersion cpv : this.channelPackageVersions) {
      if (packageVersion.equals(cpv.getChannelPackageVersionPK().getPackageVersion())) {
        doomed = cpv;
        break;
      }
    }

    if (doomed != null) {
      this.channelPackageVersions.remove(doomed);
    }

    return doomed;
  }



*************************this is the dividing line*****************************



