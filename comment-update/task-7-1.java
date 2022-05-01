/** Method 0 */

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



/** Method 1 */

/** updated comment */
  @Override
  public final String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(STR);
    Iterator<E> it = iterator();
    if (it.hasNext()) {
      for (; ; ) {
        Object e = it.next();
        sb.append(e == this ? STR : e);
        if (!it.hasNext()) {
          break;
        }
        sb.append(STR).append(STR);
      }
    }
    return sb.append(STR).toString();
  }



==========================this is the dividing line=============================



/** Method 2 */

/** updated comment */
  @Deprecated
  public int getTileSize() {
    return Math.max(tileHeight, tileWidth);
  }



==========================this is the dividing line=============================



/** Method 3 */

/** updated comment */
  public Collection<OsmPrimitive> getSelected() {
    return Collections.unmodifiableSet(selectedPrimitives);
  }



==========================this is the dividing line=============================



/** Method 4 */

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



/** Method 5 */

/** updated comment */
  public int track(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
    long currentTime = System.currentTimeMillis();
    long totalTime = currentTime + timeout;
    CloudFoundryServerBehaviour behaviour = cloudServer.getBehaviour();
    String appName = appModule.getDeployedApplicationName();
    printlnToConsole(
        NLS.bind(Messages.ApplicationInstanceStartingTracker_STARTING_TRACKING, appName),
        appModule);
    int state = IServer.STATE_UNKNOWN;
    while (state != IServer.STATE_STARTED
        && state != IServer.STATE_STOPPED
        && currentTime < totalTime) {
      if (monitor != null && monitor.isCanceled()) {
        String error =
            NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_CHECK_CANCELED, appName);
        printlnToConsole(error, appModule);
        throw new OperationCanceledException(error);
      }
      CloudApplication cloudApp = behaviour.getCloudApplication(appName, monitor);
      ApplicationStats applicationStats = behaviour.getApplicationStats(appName, monitor);
      if (cloudApp == null) {
        String error =
            NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_NOT_EXISTS, appName);
        printlnToConsole(error, appModule);
        throw CloudErrorUtil.toCoreException(error);
      } else {
        state = CloudFoundryApplicationModule.getCloudState(cloudApp, applicationStats);
        try {
          Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
        }
        currentTime = System.currentTimeMillis();
      }
    }
    String runningStateMessage =
        state == IServer.STATE_STARTED
            ? NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_RUNNING, appName)
            : NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_NOT_RUNNING, appName);
    printlnToConsole(runningStateMessage, appModule);
    return state;
  }



==========================this is the dividing line=============================



/** Method 6 */

/** updated comment */
  public List<TestSuite> getSuite() {
    return this.testSuites;
  }



==========================this is the dividing line=============================



/** Method 7 */

/** updated comment */
  public static QName getXSIType(Parameter param) {
    if (param.getMIMEType() != null) {
      return getMIMETypeQName(param.getMIMEType());
    }

    QName xmlType = null;
    TypeEntry te = param.getType();

    // If the TypeEntry describes an Element, get
    // the referenced Type.
    if (te != null && te instanceof Element && te.getRefType() != null) {
      te = te.getRefType();
    }
    // If the TypeEntry is a CollectionType, use
    // the TypeEntry representing the component Type
    // So for example a parameter that takes a
    // collection type for
    // <element name="A" type="xsd:string" maxOccurs="unbounded"/>
    // will be
    // new ParameterDesc(<QName of A>, IN,
    //                   <QName of xsd:string>,
    //                   String[])
    if (te != null && te instanceof CollectionType && te.getRefType() != null) {
      te = te.getRefType();
    }
    if (te != null) {
      xmlType = te.getQName();
    }
    return xmlType;
  }



==========================this is the dividing line=============================



/** Method 8 */

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



/** Method 9 */

/** updated comment */
  public float getX() {
    if (left == null) {
      calculateLeft();
    }
    return left.floatValue();
  }



==========================this is the dividing line=============================



/** Method 10 */

/** updated comment */
  protected boolean useGzipWhenAccepted(Response r) {
    return r.getMimeType() != null && r.getMimeType().toLowerCase().contains("text/");
  }



==========================this is the dividing line=============================



/** Method 11 */

/** updated comment */
  public Map<String, InternalPortletPreference> getStoredPreferences(
      PortletWindow portletWindow, PortletRequest request) throws PortletContainerException {
    String key = getFormattedKey(portletWindow, request);
    Map<String, InternalPortletPreference> preferences = storage.get(key);
    if (preferences == null) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("No portlet preferences found for: " + key);
      }
      return Collections.emptyMap();
    } else {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Got " + preferences.size() + " stored preferences.");
      }
      return clonePreferences(preferences);
    }
  }



==========================this is the dividing line=============================



/** Method 12 */

/** updated comment */
  public static Criterion fromRawSelection(final String selection, final String[] selectionArgs) {
    if (TextUtils.isEmpty(selection)) {
      return null;
    }
    return new Criterion(null) {

      @Override
      protected void populate(SqlBuilder builder, boolean forSqlValidation) {
        builder.sql.append(selection);
        if (selectionArgs != null && selectionArgs.length > NUM) {
          if (builder.args == null) {
            throw new UnsupportedOperationException(STR + STR);
          }
          Collections.addAll(builder.args, selectionArgs);
        }
      }
    };
  }



==========================this is the dividing line=============================



/** Method 13 */

/** updated comment */
  private boolean searchForButton(String regex, int matches) {
    sleeper.sleep();
    inst.waitForIdleSync();
    Pattern p = Pattern.compile(regex);
    Matcher matcher;
    ArrayList<Button> buttonList = viewFetcher.getCurrentViews(Button.class);
    if (matches == 0) matches = 1;
    for (Button button : buttonList) {
      matcher = p.matcher(button.getText().toString());
      if (matcher.find()) {
        countMatches++;
      }
      if (countMatches == matches) {
        countMatches = 0;
        return true;
      }
    }

    if (scroller.scroll(Scroller.Direction.DOWN)) {
      return searchForButton(regex, matches);
    } else {
      if (countMatches > 0)
        Log.d(LOG_TAG, " There are only " + countMatches + " matches of " + regex);
      countMatches = 0;
      return false;
    }
  }



==========================this is the dividing line=============================



/** Method 14 */

/** updated comment */
  public Package getRuleSet() {
    return this.pkg;
  }



==========================this is the dividing line=============================



/** Method 15 */

/** updated comment */
  public boolean searchText(String regex, int matches) {
    boolean found = searcher.searchText(regex, matches, true);
    return found;
  }



==========================this is the dividing line=============================



/** Method 16 */

/** updated comment */
  public static ImportMode getModeValue(String mode) {
    if (mode == null) return null;
    mode = mode.trim().toLowerCase();
    if (mode.indexOf(STR) == -NUM) {
      if (STR.equals(mode)) {
        return ImportMode.insert;
      } else if (STR.equals(mode)) {
        return ImportMode.update;
      } else {
        return null;
      }
    } else {
      List l = StringUtil.stringToList(mode, STR);
      String first = (String) l.get(NUM);
      String second = (String) l.get(NUM);
      if (STR.equals(first) && STR.equals(second)) {
        return ImportMode.insertUpdate;
      } else if (STR.equals(first) && STR.equals(second)) {
        return ImportMode.updateInsert;
      } else {
        return null;
      }
    }
  }



==========================this is the dividing line=============================



/** Method 17 */

/** updated comment */
  public boolean isBoolean() {
    return raw.equals("true") || raw.equals("false");
  }



==========================this is the dividing line=============================



/** Method 18 */

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



/** Method 19 */

/** updated comment */
  public float getX() {
    if (left == null) {
      calculateLeft();
    }

    return left.floatValue();
  }



==========================this is the dividing line=============================



