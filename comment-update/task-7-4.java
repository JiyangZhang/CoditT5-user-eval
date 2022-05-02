/** Method 0 */

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



/** Method 1 */

/** updated comment */
  public float getX() {
    if (left == null) {
      calculateLeft();
    }

    return left.floatValue();
  }



==========================this is the dividing line=============================



/** Method 2 */

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



/** Method 3 */

/** updated comment */
  private Languages.Language getLanguage(String languageStr) {
    for (Languages.Language l : Languages.Language.values()) {
      if (l.name().equalsIgnoreCase(languageStr)) return l;
    }
    return null;
  }



==========================this is the dividing line=============================



/** Method 4 */

/** updated comment */
  private int updateRedundancy() {
    int desiredRedundancy = this.pRegion.getRedundantCopies();
    int numBucketHosts = getNumInitializedBuckets();
    if (isClosed()) {
      return numBucketHosts;
    }
    int actualRedundancy = numBucketHosts - 1;
    this.redundancy = actualRedundancy;
    if (this.redundancySatisfied && numBucketHosts > 0 && actualRedundancy < desiredRedundancy) {
      incLowRedundancyBucketCount(1);
      this.redundancySatisfied = false;
    } else if (!this.redundancySatisfied
        && numBucketHosts > 0
        && actualRedundancy >= desiredRedundancy) {
      incLowRedundancyBucketCount(-1);
      this.redundancySatisfied = true;
      this.redundancyEverSatisfied = true;
    }
    return numBucketHosts;
  }



==========================this is the dividing line=============================



/** Method 5 */

/** updated comment */
  public List<TestSuite> getSuite() {
    return this.testSuites;
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
  public Collection<OsmPrimitive> getSelected() {
    return Collections.unmodifiableSet(selectedPrimitives);
  }



==========================this is the dividing line=============================



/** Method 8 */

/** updated comment */
  public String[] createText(MilStd2525TacticalGraphic graphic) {
    String[] result;

    String functionId = graphic.getFunctionId();
    if (CircularFireSupportArea.FUNCTION_ID_TARGET.equals(functionId)) {
      result = new String[] {graphic.getText()};
    } else {
      boolean useSeparateTimeLabel = this.isShowSeparateTimeLabel(functionId);
      String mainText = this.createMainText(graphic, functionId, !useSeparateTimeLabel);

      if (useSeparateTimeLabel) {
        String timeText = this.createTimeRangeText(graphic);
        result = new String[] {mainText, timeText};
      } else {
        result = new String[] {mainText};
      }
    }
    return result;
  }



==========================this is the dividing line=============================



/** Method 9 */

/** updated comment */
  public static final TwitterTokenStream of(TwitterTokenStream... streams) {
    return new TokenStreamAggregator(streams);
  }



==========================this is the dividing line=============================



/** Method 10 */

/** updated comment */
  public float getY() {
    if (top == null) {
      calculateTop();
    }

    return top.floatValue();
  }



==========================this is the dividing line=============================



/** Method 11 */

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



/** Method 12 */

/** updated comment */
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



==========================this is the dividing line=============================



/** Method 13 */

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



/** Method 14 */

/** updated comment */
  public boolean equals(Object readableInterval) {
    if (this == readableInterval) {
      return true;
    }
    if (readableInterval instanceof ReadableInterval == false) {
      return false;
    }
    ReadableInterval other = (ReadableInterval) readableInterval;
    return (getStartMillis() == other.getStartMillis()
        && getEndMillis() == other.getEndMillis()
        && getChronology() == other.getChronology());
  }



==========================this is the dividing line=============================



/** Method 15 */

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



/** Method 16 */

/** updated comment */
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



==========================this is the dividing line=============================



/** Method 17 */

/** updated comment */
  public static <T> Method findMethod(Class<?> implClass, Operation<T> operation)
      throws NoSuchMethodException {
    String name = operation.getName();
    Class<?>[] paramTypes = getPhysicalTypes(operation);
    return implClass.getMethod(name, paramTypes);
  }



==========================this is the dividing line=============================



/** Method 18 */

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



/** Method 19 */

/** updated comment */
  public static RequestQueue newRequestQueue(IRestProtocol implRestConnection, int threadPoolSize) {
    return newRequestQueue(RestParser.getInstance(implRestConnection), threadPoolSize);
  }



==========================this is the dividing line=============================



