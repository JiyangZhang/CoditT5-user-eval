/** Method 0 */

/** Removes a converter from the set of converters, by index. */
  public InstantConverter removeInstantConverter(int index) throws SecurityException {
    checkAlterInstantConverters();
    InstantConverter[] removed = new InstantConverter[1];
    iInstantConverters = iInstantConverters.remove(index, removed);
    return removed[0];
  }



*************************this is the dividing line*****************************



/** Method 1 */

/** Get the x location of the center of this circle */
  public float getX() {
    return center[0];
  }



*************************this is the dividing line*****************************



/** Method 2 */

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



/** Method 3 */

/** Get the  edu.stanford.nlp.international.Language object corresponding to the given language string. */
  private Language getLanguage(String languageStr) {
    for (Language l : Language.values()) {
      if (l.name().equalsIgnoreCase(languageStr)) return l;
    }
    return null;
  }



*************************this is the dividing line*****************************



/** Method 4 */

/** Get the current number of bucket hosts and update the redundancy statistics for the region */
  private int updateRedundancy() {
    int numBucketHosts = getNumInitializedBuckets();
    if (!isClosed()) {
      redundancyTracker.updateStatistics(numBucketHosts);
    }
    return numBucketHosts;
  }



*************************this is the dividing line*****************************



/** Method 5 */

/** Retrieves the parsed Test Suite. */
  public TestSuite getSuite() {
    return this.testSuite;
  }



*************************this is the dividing line*****************************



/** Method 6 */

/** Checks if this persistent resource's underlying entity is sharable. */
  private boolean isShareable() {
    return getRequestScope().getDictionary().isSharable(obj.getClass());
  }



*************************this is the dividing line*****************************



/** Method 7 */

/** Return a list of all selected objects. */
  public Collection<OsmPrimitive> getSelected() {
    // It would be nice to have this be a copy-on-write list
    // or an Collections.unmodifiableList().  It would be
    // much faster for large selections.  May users just
    // call this, and only check the .size().
    return new ArrayList<OsmPrimitive>(selectedPrimitives);
  }



*************************this is the dividing line*****************************



/** Method 8 */

/** Construct the text for the main label of a graphic. */
  public String createText(MilStd2525TacticalGraphic graphic) {
    String functionId = graphic.getFunctionId();
    if (CircularFireSupportArea.FUNCTION_ID_TARGET.equals(functionId)) return graphic.getText();
    else return createDateRangeText(graphic, functionId);
  }



*************************this is the dividing line*****************************



/** Method 9 */

/** Creates a  TokenStream that aggregates the outputs of a given set of  TokenStreams. */
  public static final TokenStream of(TokenStream... streams) {
    return new TokenStreamAggregator(streams);
  }



*************************this is the dividing line*****************************



/** Method 10 */

/** Get the y location of the center of this circle */
  public float getY() {
    return center[1];
  }



*************************this is the dividing line*****************************



/** Method 11 */

/** Searches for a button with the given search string and returns true if the searched button is found a given number of times */
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



*************************this is the dividing line*****************************



/** Method 12 */

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



/** Method 13 */

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



/** Method 14 */

/** Compares this object with the specified object for equality based on start and end millis. */
  public boolean equals(Object readableInterval) {
    if (this == readableInterval) {
      return true;
    }
    if (readableInterval instanceof ReadableInterval == false) {
      return false;
    }
    ReadableInterval other = (ReadableInterval) readableInterval;
    return (getStartMillis() == other.getStartMillis() && getEndMillis() == other.getEndMillis());
  }



*************************this is the dividing line*****************************



/** Method 15 */

/** Returns the stored portlet preferences array. */
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



*************************this is the dividing line*****************************



/** Method 16 */

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



/** Method 17 */

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



/** Method 18 */

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



/** Method 19 */

/** Create a new request queue, using NoHttp default request executor  HttpRestConnection and default response parser  HttpRestParser. */
  public static RequestQueue newRequestQueue(
      ImplRestConnection implRestConnection, int threadPoolSize) {
    return newRequestQueue(HttpRestParser.getInstance(implRestConnection), threadPoolSize);
  }



*************************this is the dividing line*****************************



