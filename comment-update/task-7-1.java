Method 0 

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



=======================================================



Method 1 

  @Override
  public String toString() {
    Node<K, V>[] t;
    int f = (t = table) == null ? NUM : t.length;
    Traverser<K, V> it = new Traverser<K, V>(t, f, NUM, f);
    StringBuilder sb = new StringBuilder();
    sb.append(STR);
    Node<K, V> p;
    if ((p = it.advance()) != null) {
      for (; ; ) {
        K k = p.key;
        V v = p.val;
        sb.append(k == this ? STR : k);
        sb.append(STR);
        sb.append(v == this ? STR : v);
        if ((p = it.advance()) == null) {
          break;
        }
        sb.append(STR).append(STR);
      }
    }
    return sb.append(STR).toString();
  }



=======================================================



Method 2 

  public int getTileSize() {
    return tileSize;
  }



=======================================================



Method 3 

  public Collection<OsmPrimitive> getSelected() {
    return new ArrayList<OsmPrimitive>(selectedPrimitives);
  }



=======================================================



Method 4 

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



=======================================================



Method 5 

  public int track(IProgressMonitor monitor) throws CoreException {
    long currentTime = System.currentTimeMillis();
    long totalTime = currentTime + timeout;
    CloudFoundryApplicationModule appModule =
        cloudServer.getBehaviour().updateModuleWithAllCloudInfo(appName, monitor);
    printlnToConsole(
        NLS.bind(Messages.ApplicationInstanceStartingTracker_STARTING_TRACKING, appName),
        appModule);
    int state = appModule.getState();
    while (state != IServer.STATE_STARTED
        && state != IServer.STATE_STOPPED
        && currentTime < totalTime) {
      appModule = cloudServer.getBehaviour().updateModuleWithAllCloudInfo(appName, monitor);
      if (appModule == null || appModule.getApplication() == null) {
        printlnToConsole(
            NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_NOT_EXISTS, appName),
            appModule);
        return IServer.STATE_UNKNOWN;
      }
      if (monitor != null && monitor.isCanceled()) {
        printlnToConsole(
            NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_CHECK_CANCELED, appName),
            appModule);
        return IServer.STATE_UNKNOWN;
      }
      state = appModule.getState();
      try {
        Thread.sleep(WAIT_TIME);
      } catch (InterruptedException e) {
      }
      currentTime = System.currentTimeMillis();
    }
    String runningStateMessage =
        state == IServer.STATE_STARTED
            ? NLS.bind(Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_RUNNING, appName)
            : NLS.bind(
                Messages.ApplicationInstanceStartingTracker_APPLICATION_IS_NOT_RUNNING, appName);
    printlnToConsole(runningStateMessage, appModule);
    return state;
  }



=======================================================



Method 6 

  public TestSuite getSuite() {
    return this.testSuite;
  }



=======================================================



Method 7 

  public static QName getXSIType(TypeEntry te) {
    QName xmlType = null;

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



=======================================================



Method 8 

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



=======================================================



Method 9 

  public float getX() {
    return center[NUM];
  }



=======================================================



Method 10 

  protected boolean useGzipWhenAccepted() {
    return false;
  }



=======================================================



Method 11 

  public InternalPortletPreference[] getStoredPreferences(
      PortletWindow portletWindow, PortletRequest request) throws PortletContainerException {
    String key = getFormattedKey(portletWindow, request);
    InternalPortletPreference[] preferences = storage.get(key);
    if (preferences == null) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("No portlet preferences found for: " + key);
      }
      return new InternalPortletPreference[0];
    } else {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Got " + preferences.length + " stored preferences.");
      }
      return clonePreferences(preferences);
    }
  }



=======================================================



Method 12 

  public static Criterion fromRawSelection(final String selection, final String[] selectionArgs) {
    if (TextUtils.isEmpty(selection)) {
      return Criterion.all;
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



=======================================================



Method 13 

  private boolean searchForButton(String search, int matches) {
    sleeper.sleep();
    inst.waitForIdleSync();
    Pattern p = Pattern.compile(search);
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
      return searchForButton(search, matches);
    } else {
      if (countMatches > 0)
        Log.d(LOG_TAG, " There are only " + countMatches + " matches of " + search);
      countMatches = 0;
      return false;
    }
  }



=======================================================



Method 14 

  public RuleSet getRuleSet() {
    return this.ruleSet;
  }



=======================================================



Method 15 

  public boolean searchText(String search, int matches) {
    boolean found = searcher.searchText(search, matches, true);
    return found;
  }



=======================================================



Method 16 

  public static int getModeValue(String mode) {
    if (mode == null) return -NUM;
    mode = mode.trim().toLowerCase();
    if (mode.indexOf(STR) == -NUM) {
      if (STR.equals(mode)) {
        return MODE_INSERT;
      } else if (STR.equals(mode)) {
        return MODE_UPDATE;
      } else {
        return -NUM;
      }
    } else {
      List l = StringUtil.stringToList(mode, STR);
      String first = (String) l.get(NUM);
      String second = (String) l.get(NUM);
      if (STR.equals(first) && STR.equals(second)) {
        return MODE_INSERT_UPDATE;
      } else if (STR.equals(first) && STR.equals(second)) {
        return MODE_UPDATE_INSERT;
      } else {
        return -NUM;
      }
    }
  }



=======================================================



Method 17 

  public boolean isBoolean() {
    return arg.equals("true") || arg.equals("false");
  }



=======================================================



Method 18 

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



=======================================================



Method 19 

  public float getX() {
    return center[0];
  }



=======================================================



